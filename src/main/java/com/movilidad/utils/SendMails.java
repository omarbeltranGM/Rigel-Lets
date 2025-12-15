package com.movilidad.utils;

import com.movilidad.model.NotificacionCorreoConf;
import com.movilidad.model.NotificacionTemplate;
import java.io.IOException;//***
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.lang.text.StrSubstitutor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Luis Alberto Velez
 *
 *
 */
public class SendMails {

    /**
     *
     * @param config this param is a map type, where it´s possible take several
     * values, like this: host for smtp.gmail.com, port 25 by default, from for
     * the email who send this, connect is for the account witch you established
     * the connection with the server and finally password is obviously
     * @param mailProperties this map has email body data
     * @param asunto takes subject to send
     * @param cuerpo takes the value for body of message
     * @param destinatario takes the value for Recipient
     * @param alias alis for name who sending email
     * @param adjuntos filenames for sending
     *
     */
    private static void send(Map<String, String> config, Map<String, String> mailProperties,
            String asunto, String cuerpo,
            String destinatario,
            String alias,
            List<String> adjuntos,
            boolean isURL) {
        try {
            // se obtiene el objeto Session. La configuración es para
            // una cuenta de gmail.
            Properties props = new Properties();
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", config.get("host"));
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", config.get("port"));
            props.setProperty("mail.smtp.auth", "true");
//            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            Session session = Session.getDefaultInstance(props, null);
            // session.setDebug(true);

            // Se compone la parte del texto
            BodyPart texto = new MimeBodyPart();

//          Lectura de la plantilla que se usara en la notificación del correo electrónico
            String htmlEmail = "";
            StrSubstitutor strSub = null;
            String fileName = config.get("template");
            Path path;
            if (isURL) {
                //validar que exista el archivo
                byte[] fileBytes = downloadFileFromDrive(fileName);
                
                if (fileBytes != null) {
                    htmlEmail = new String(fileBytes, StandardCharsets.UTF_8);
                    strSub = new StrSubstitutor(mailProperties);
                    htmlEmail = strSub.replace(htmlEmail);
                } else {
                    System.err.println("El archivo no existe en esta ruta: "+ fileName);
                }
            } else {
                path = Paths.get(fileName);
//            Validacion que exista el archivo
                if (!Files.exists(path)) {
                    System.err.println("El archivo no existe en esta ruta: " + path.toAbsolutePath());
                } else {
                    try {
                        byte[] fileBytes = Files.readAllBytes(path);
                        htmlEmail = new String(fileBytes, StandardCharsets.UTF_8);

                        strSub = new StrSubstitutor(mailProperties);
                        htmlEmail = strSub.replace(htmlEmail);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            // Una MultiParte para agrupar texto e imagen.
            MimeMultipart multiParte = new MimeMultipart();

            if (adjuntos != null) {
                for (String filePath : adjuntos) {
                    MimeBodyPart attachPart = new MimeBodyPart();

                    try {
                        attachPart.attachFile(filePath);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    multiParte.addBodyPart(attachPart);
                }
            }
            // Se compone el correo, dando to, from, subject y el
            // contenido.
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(config.get("from"), alias));
            InternetAddress[] myToList = InternetAddress.parse(destinatario);
            message.setRecipients(Message.RecipientType.TO, myToList);

            //Acá es donde se envia el correo a otros destinatarios            
            if (config.get("mailBcc") != null) {
                InternetAddress[] myBccList = InternetAddress.parse(config.get("mailBcc"));
                if (myBccList != null) {
                    message.setRecipients(Message.RecipientType.BCC, myBccList);
                }
            }

            message.setSubject(asunto);
            texto.setContent(htmlEmail, "text/html; charset=utf-8");
            multiParte.addBodyPart(texto);

            message.setContent(multiParte);

            // Se envia el correo.
            Transport t = session.getTransport("smtp");
            t.connect(config.get("from"), config.get("password"));
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Convierte el recurso (archivo) en un objeto byte[].
     * También permite validar la existencia del recurso en la unidad drive.
     * 
    */
    private static byte[] downloadFileFromDrive(String driveUrl) throws IOException {
        // Extraer el ID del archivo de la URL de Google Drive
        String fileId = extractFileId(driveUrl);
        if (fileId == null) {
            throw new IOException("No se pudo extraer el ID del archivo de la URL.");
        }
        
        // Generar la URL de descarga directa
        String downloadUrl = "https://drive.google.com/uc?id=" + fileId + "&export=download";
        
        // Hacer una solicitud HTTP GET a la URL de descarga
        URL url = new URL(downloadUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000); // 5 segundos de timeout
        connection.setReadTimeout(5000); // 5 segundos de timeout
        
        int responseCode = connection.getResponseCode();
        
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Si la respuesta es 200 OK, leer el archivo
            try (InputStream inputStream = connection.getInputStream();
                 ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
                
                byte[] buffer = new byte[1024];
                int bytesRead;
                
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, bytesRead);
                }
                
                return byteArrayOutputStream.toByteArray(); // Retorna el archivo como un arreglo de bytes
            }
        } else {
            throw new IOException("Error al acceder al archivo, código de respuesta HTTP: " + responseCode);
        }
    }
    
    // Método para extraer el ID del archivo desde la URL de Google Drive
    private static String extractFileId(String urlString) {
        // Google Drive URL estándar: https://drive.google.com/file/d/FILE_ID/view?usp=sharing
        String[] parts = urlString.split("/d/");
        if (parts.length > 1) {
            return parts[1].split("/")[0]; // Extraemos el ID del archivo
        }
        return null;
    }

    private static byte[] validarArchivoURL(String urlString) throws IOException {
        // Validar si el archivo existe en la URL
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Establecemos un tiempo de espera para la conexión
        connection.setConnectTimeout(5000); // 5 segundos
        connection.setReadTimeout(5000); // 5 segundos

        // Realizamos una solicitud GET para verificar si el archivo existe
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            // El archivo existe, ahora lo convertimos en un arreglo de bytes
            try (InputStream inputStream = connection.getInputStream(); ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, bytesRead);
                }

                return byteArrayOutputStream.toByteArray();
            }
        } else {
            // Si no se pudo acceder al archivo, lanzamos una excepción o devolvemos null
            throw new IOException("El archivo no se pudo encontrar o acceder, código de respuesta HTTP: " + responseCode);
        }
    }

    /**
     * Lee el contenido textual desde un stream de entrada
     *
     * @param input Stream de entrada
     * @param encoding Codificación
     * @return El contenido del stream de entrada
     * @throws IOException Cualquier excepción de Entrada/Salida
     */
    public static String fileToString(InputStream input, String encoding) throws IOException {
        StringWriter sw = new StringWriter();
        InputStreamReader in = new InputStreamReader(input, encoding);

        char[] buffer = new char[1024 * 2];
        int n = 0;
        while (-1 != (n = in.read(buffer))) {
            sw.write(buffer, 0, n);
        }
        return sw.toString();
    }

    /**
     * Método encargado de cargar el un mapa con la data necesaria para enviar
     * un correo. La data es consultada en la base de datos.
     *
     * @return Mapa cargado con la data necesaria.
     */
    public static Map getMailParams(NotificacionCorreoConf conf, NotificacionTemplate template) {
        Map mapa = new HashMap();
        mapa.put("host", conf.getSmtpServer());
        mapa.put("mailBcc", conf.getCc1());
        mapa.put("from", conf.getEmail());
        mapa.put("port", conf.getPuerto().toString());
        mapa.put("password", conf.getPassword());
        mapa.put("template", template.getPath());
        return mapa;
    }

    /**
     * método que permite la carga de una rchivo en una ubicación dentro del servidor
     * */
    public static void sendEmail(Map<String, String> config, Map mailProperties,
            String asunto, String cuerpo,
            String destinatario,
            String alias,
            List<String> adjuntos) {
        Runnable iniMail = () -> {
            send(config, mailProperties, asunto, cuerpo, destinatario, alias, 
                    adjuntos, false);
        };
        Thread newTharead = new Thread(iniMail);
        newTharead.start();
    }

    /**
     * Se genera sobre carga del método con @isURL, con este parametro se realiza un flujo alterno
     * para la acción de carga del archivo, dado que se realiza para un archivo contenido en una
     * carpeta drive.
     * */
    public static void sendEmail(Map<String, String> config, Map mailProperties,
            String asunto, String cuerpo,
            String destinatario,
            String alias,
            List<String> adjuntos,
            boolean isURL) {
        Runnable iniMail = () -> {
            send(config, mailProperties, asunto, cuerpo, destinatario, alias, 
                    adjuntos, isURL);
        };
        Thread newTharead = new Thread(iniMail);
        newTharead.start();
    }

}