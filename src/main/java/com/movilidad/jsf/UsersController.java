package com.movilidad.jsf;

import com.movilidad.ejb.EmpleadoFacadeLocal;
import com.movilidad.ejb.NotificacionCorreoConfFacadeLocal;
import com.movilidad.ejb.NotificacionTemplateFacadeLocal;
import com.movilidad.ejb.RolFacadeLocal;
import com.movilidad.ejb.UserRolesFacadeLocal;
import com.movilidad.model.Users;
import com.movilidad.ejb.UsersFacadeLocal;
import com.movilidad.model.Empleado;
import com.movilidad.model.GopUnidadFuncional;
import com.movilidad.model.NotificacionCorreoConf;
import com.movilidad.model.Rol;
import com.movilidad.model.UserRoles;
import com.movilidad.security.UserExtended;
import com.movilidad.utils.JsfUtil;
import com.movilidad.utils.JsfUtil.PersistAction;
import static com.movilidad.utils.MailConfig.getMailParams;
import com.movilidad.utils.MovilidadUtil;
import com.movilidad.utils.SendMails;
import com.movilidad.model.NotificacionTemplate;
import com.movilidad.utils.ConstantsUtil;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Named("usersController")
@ViewScoped
public class UsersController implements Serializable {

    @EJB
    private UsersFacadeLocal userEJB;
    @EJB
    private EmpleadoFacadeLocal empleadoFacade;
    @EJB
    private UserRolesFacadeLocal rolesFacade;
    @EJB 
    private NotificacionTemplateFacadeLocal notificaTemplateEJB;
    @EJB
    private NotificacionCorreoConfFacadeLocal NCCEJB;
    @EJB
    private RolFacadeLocal rolEJB;

    @Inject
    private SelectGopUnidadFuncionalBean selectGopUnidadFuncionalBean;
    @Inject
    private GopUnidadFuncionalSessionBean unidadFuncionalSessionBean;

    private List<Users> items = null;
    private List<Rol> itemsRoles;
    private List<Empleado> listEmpleados;

    private Users selected;
    private Empleado empleado;
    
    //----
    private String confirContrasena;
    private String c_aux1;
    private String c_aux2;
    private String c_aux3;

    //----Rol
    private String rol;

    private String c_username;

    private boolean b_cont = false;
    private boolean b_cont2 = false;

    UserExtended user = (UserExtended) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    public UsersController() {
    }

    @PostConstruct
    public void init() {
        consultarUsuarios();
    }

    public Users prepareCreate() {
        selected = new Users();
        selected.setEnabled(true);
        empleado = new Empleado();
        selectGopUnidadFuncionalBean.consultarList();
        return selected;
    }

    public void prepareEdit() {
        if (selected == null) {
            return;
        }
        if (selected.getIdGopUnidadFuncional() != null) {
            unidadFuncionalSessionBean.setI_unidad_funcional(selected.getIdGopUnidadFuncional().getIdGopUnidadFuncional());
        }
        selectGopUnidadFuncionalBean.consultarList();
        MovilidadUtil.openModal("UsersEditDialog");
    }
    
    public void prepareResetPassword(){
        if (selected == null) {
            return;
        }
        String nuevaContrasena = generarPasswordUser(8);
        getSelected().setPassword(nuevaContrasena);//Se pasa la contraseña al usuario seleccionado
        encriptarContrasena();
        userEJB.edit(selected);//Se actualiza el usuario en la base de datos                   
        JsfUtil.addSuccessMessage("Usuario actualizado correctamente");//Mensaje de confirmacion 
        
        //Datos del correo
        Users selectUsers = this.getSelected();
        String asunto = "Cambio de contraseña";
        emailCambioContrasena(selectUsers, asunto, nuevaContrasena);
    }
    
    public void create() {
        //Disparador cuando se guarda el usuario        
        Users selectedUser = this.getSelected();          
        String nombre = selectedUser.getNombres();
        String email = this.empleado.getEmailCorporativo();
        String username = selectedUser.getUsername();
        String password = selectedUser.getPassword();               
        persist(PersistAction.CREATE, "Usuario creado corrrectamente");        
                  
        if (JsfUtil.isValidationFailed()) {
            JsfUtil.addErrorMessage("Error, Usuario no se creó");                  
        }
        //Usuario Temporal para recolectar la informacion para el correo 
        Users userCorreo = new Users();
        userCorreo.setNombres(nombre);
        userCorreo.setEmail(email);
        userCorreo.setUsername(username);
        userCorreo.setPassword(password);        
                
        String asunto = "ASIGNACIÓN USUARIO RIGEL";//Asunto del método enviarEmailUser        
        consultarUsuarios();         
        enviarEmailUser(userCorreo, asunto, password);               
    } 
    
    public void enviarEmailUser(Users user, String asunto, String password) {        
        try {
            NotificacionCorreoConf conf = NCCEJB.find(1);
            NotificacionTemplate template = 
                    notificaTemplateEJB.findByTemplate(ConstantsUtil.TEMPLATE_NOTIFICACION_CREACION_USUARIO);          
            
            if (template == null) {
                System.out.println("No se encontro la plantilla");
                return;
            }            
            Map mapa = SendMails.getMailParams(conf, template);
            mapa.put("template", template.getPath());
            Map mailProperties = new HashMap();   
            
            //Datos del correo que sera reemplazados en la plantilla 
            mailProperties.put("nombre", user.getNombres());  
            mailProperties.put("username", user.getUsername());
            mailProperties.put("password", password);
            mailProperties.put("url_acceso", "http://rigel.greenmovil.com.co:8080/");                        
            SendMails.sendEmail(mapa, mailProperties, asunto, "", user.getEmail(), 
                    "Notificaciones RIGEL", null, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void emailCambioContrasena(Users user, String asunto, String password){        
        try{
            NotificacionCorreoConf conf = NCCEJB.find(1);
            NotificacionTemplate template = 
                    notificaTemplateEJB.findByTemplate(ConstantsUtil.TEMPLATE_NOTIFICACION_CAMBIO_CONTRASENA);             
            
            if (template == null) {                
                return;
            }
            Map mapa = SendMails.getMailParams(conf, template);
            mapa.put("template", template.getPath());
            Map mailProperties = new HashMap();
            
            mailProperties.put("nombre", user.getNombres());
            mailProperties.put("username", user.getUsername());
            mailProperties.put("password", password);
            mailProperties.put("url_acceso", "http://rigel.greenmovil.com.co:8080/"); 
            SendMails.sendEmail(mapa, mailProperties, asunto, "", user.getEmail(), 
                    "Notificaciones RIGEL", null, true);            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, "Usuario actualizado correctamente");
        if (JsfUtil.isValidationFailed()) {
            JsfUtil.addErrorMessage("Error, Usuario no se actualizó correctamente");
        }
        consultarUsuarios();        
    }

    public void destroy() {
        persist(PersistAction.DELETE, "Usuario eliminado correctamente");
        if (JsfUtil.isValidationFailed()) {
            JsfUtil.addErrorMessage("Error, Usuario no se eliminó correctamente");
        }
    }

    public void reset() {
        selected = new Users();
        consultarUsuarios();
        empleado = new Empleado();
        c_aux1 = "";
        c_aux2 = "";
        c_aux3 = "";
        b_cont = false;
        confirContrasena = "";
        c_username = "";
        empleado = null;
        rol = "";
    }

    boolean validarCorreo() {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.matches(regex, selected.getEmail());
    }

    boolean validarNombreUsuario() {
        return userEJB.userNameFind(getSelected().getUsername());
    }

    void encriptarContrasena() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(getSelected().getPassword());
        getSelected().setPassword(encode);
    }
    
    public String generarUsuario(){           

        String[] nombres = getEmpleado().getNombres().split(" ");//Split separa una cadena por lo que se le indica en este caso espacio
        String[] apellidos = getEmpleado().getApellidos().split(" ");   
        
        //Toma la primera letra del nombre mas el primer apellido como usuario y pasa todo a minuscula
        String UserTest = (Character.toString(nombres[0].charAt(0)) + "" + apellidos[0]).toLowerCase(); 
        
        //Paso como argumento el usuario para ser validado 
        getSelected().setUsername(UserTest);         
                
        if (validarNombreUsuario()) {            
            return UserTest;
        }
        
        //genera usuario de alternativa
        generarUserName();        
        
        getSelected().setUsername(c_aux1);
        if (validarNombreUsuario()) {
            return c_aux1;
        }
        
        getSelected().setUsername(c_aux2);
        if (validarNombreUsuario()) {
            return c_aux2;
        }
        getSelected().setUsername(c_aux3);
        if (validarNombreUsuario()) {
            return c_aux3;
        }        
        return "";//Retorna en Blanco en caso que no haya ningún usuario 
    }

    void generarUserName() {
        String c_cod = Integer.toString(getEmpleado().getCodigoTm());
        String[] nombres = getEmpleado().getNombres().split(" ");
        String[] apellidos = getEmpleado().getApellidos().split(" ");
        if (nombres.length == 2) {
            c_aux1 = (Character.toString(nombres[0].charAt(0)) + "" + apellidos[0] + "" + Character.toString(nombres[1].charAt(0))).toLowerCase();
            c_aux2 = (Character.toString(nombres[0].charAt(0)) + "" + apellidos[0] + "" + c_cod).toLowerCase();
            c_aux3 = (apellidos[0] + "" + Character.toString(nombres[0].charAt(0)) + "" + c_cod).toLowerCase();
            return;
        }
        if (nombres.length > 2) {
            c_aux1 = (Character.toString(nombres[0].charAt(0)) + "" + apellidos[0]).toLowerCase();
            c_aux2 = (Character.toString(nombres[0].charAt(0)) + "" + apellidos[0] + "" + c_cod).toLowerCase();
            c_aux3 = (apellidos[0] + "" + Character.toString(nombres[0].charAt(0)) + "" + c_cod).toLowerCase();
            return;
        }
        c_aux1 = (nombres[0] + "" + apellidos[0] + "" + c_cod).toLowerCase();
        c_aux2 = (Character.toString(nombres[0].charAt(0)) + "" + apellidos[0] + "" + c_cod).toLowerCase();
        c_aux3 = (apellidos[0] + "" + Character.toString(nombres[0].charAt(0)) + "" + c_cod).toLowerCase();

    }

    boolean validarContrasena() {        
        return getSelected().getPassword().equals(confirContrasena);
    }

    public void onRowSelectEmpleado(SelectEvent event) {
        empleado = (Empleado) event.getObject();       
        if (empleado != null) {
            if (!validarUsuario()) {
                MovilidadUtil.addErrorMessage("Empleado cuenta con usuario registrado");
                reset();
                PrimeFaces.current().executeScript("PF('empleDlg').hide();");
                return;
            }
            b_cont = true;
            getSelected().setNombres(empleado.getNombres() + " " + empleado.getApellidos());
            getSelected().setIdEmpleado(empleado);
            getSelected().setEnabled(true);//el usuario está activo por defecto
            c_username = generarUsuario();//Valor que toma el campo usuario            
            MovilidadUtil.addSuccessMessage("Empleado valido");            
            asignarContrasena();//Funcion que asigna la contraseña al usuario
           
        }
        PrimeFaces.current().executeScript("PF('empleDlg').hide();");
    }
    
    public void asignarContrasena(){
        String password = generarPasswordUser(8);//La contraseña generada tiene 8 caracteres
        getSelected().setPassword(password);
        confirContrasena = password;                 
    }
    
    public String generarPasswordUser(int longitud){
        // Definimos los caracteres que puede tener la contraseña
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#!*()_+$-=/%¡.&";
        StringBuilder contrasena = new StringBuilder();
        Random rnd = new Random();
        
        // Construimos la contraseña caracter por caracter
        for (int i = 0; i < longitud; i++) {
            int indice = rnd.nextInt(caracteres.length());
            char c = caracteres.charAt(indice);
            contrasena.append(c);
        }
        return contrasena.toString();
    }
    
    boolean validarUsuario() {
        return userEJB.validarUnicoEmpleado(empleado.getIdEmpleado());
    }

    private void persist(PersistAction persistAction, String successMessage) {
        selected.setCreatedBy(user.getUsername());
        if (selected != null) {
            try {
                switch (persistAction) {
                    case CREATE:
                        if (c_username.equals("") || c_username.isEmpty()) {
                            MovilidadUtil.addErrorMessage("Usuario es requerido");
                            return;
                        }
                        selected.setEmail(empleado.getEmailCorporativo());
                        if (!validarCorreo()) {
                            MovilidadUtil.addErrorMessage("Correo no valido");
                            return;
                        }
                        selected.setUsername(c_username);
                        if (!validarNombreUsuario()) {
                            generarUserName();
                            MovilidadUtil.addErrorMessage("Nombre de usuario no disponible");
                            MovilidadUtil.addAdvertenciaMessage("Intente los siguientes Usuarios:");
                            MovilidadUtil.addAdvertenciaMessage(c_aux1 + "--" + c_aux2 + "--" + c_aux3);
                            return;
                        }
                        if (!validarContrasena()) {                            
                            MovilidadUtil.addErrorMessage("Las contraseñas no coinciden");
                            return;
                        }
                        if (selected.getPassword().length() < 4) {
                            MovilidadUtil.addErrorMessage("Contraseña no valida, tamaño no permitido");
                            return;
                        }
                        selected.setUltimoAcceso(MovilidadUtil.fechaCompletaHoy());

                        if (unidadFuncionalSessionBean.getI_unidad_funcional() != null) {
                            selected.setIdGopUnidadFuncional(new GopUnidadFuncional(unidadFuncionalSessionBean.getI_unidad_funcional()));
                        } else {
                            selected.setIdGopUnidadFuncional(null);
                        }
                        selected.setCreado(MovilidadUtil.fechaCompletaHoy());
                        encriptarContrasena();
                        guardarRol(); // también persiste el usuario
                        JsfUtil.addSuccessMessage(successMessage);
                        reset();
                        break;
                    case DELETE:
                        reset();
                        break;
                    case UPDATE:
                        //se utiliza la variable c_aux1 para la contraseña.
                        if (!(c_aux1.equals("") || c_aux1.isEmpty())) {
                            if (!c_aux1.equals(confirContrasena)) {
                                MovilidadUtil.addErrorMessage("Las contraseñas no coinciden");
                                return;
                            } else {
                                if (c_aux1.length() < 4) {
                                    MovilidadUtil.addErrorMessage("Contraseña no valida, tamaño no permitido");
                                    return;
                                }
                                selected.setPassword(c_aux1);
                                encriptarContrasena();
                            }
                        }

                        if (unidadFuncionalSessionBean.getI_unidad_funcional() != null) {
                            selected.setIdGopUnidadFuncional(new GopUnidadFuncional(unidadFuncionalSessionBean.getI_unidad_funcional()));
                        } else {
                            selected.setIdGopUnidadFuncional(null);
                        }
                        userEJB.edit(selected);
                        if (!rol.equals("") || !rol.isEmpty()) {
                            Collection<UserRoles> userRolesCollection = selected.getUserRolesCollection();
                            if (userRolesCollection != null && userRolesCollection.size() > 0) {
                                for (UserRoles usr : userRolesCollection) {
                                    usr.setAuthority(rol);
                                    rolesFacade.edit(usr);
                                    break;
                                }
                            }
                        }
                        JsfUtil.addSuccessMessage(successMessage);
                        PrimeFaces current = PrimeFaces.current();
                        current.executeScript("PF('UsersEditDialog').hide();");
                        reset();
                        break;
                    default:
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                MovilidadUtil.addErrorMessage("Error de sistema");
            }
        }
    }

    //---- Rol
    void guardarRol() {
        try {
            UserRoles userRoles = new UserRoles();
            if (rol.equals("") || rol.isEmpty()) {
                MovilidadUtil.addErrorMessage("Debe seleccionar un Rol para el Usuario");
                return;
            }
            userRoles.setUserId(selected);
            userRoles.setAuthority(rol);
            rolesFacade.create(userRoles);
        } catch (Exception e) {
            MovilidadUtil.addErrorMessage("Error al registrar Rol");
        }
    }

    public void handleKeyEvent() {
        c_username = c_username.toLowerCase();
    }

    public List<Users> consultarUsuarios() {
        items = userEJB.findAllUsersActivosByUnidadFunc(unidadFuncionalSessionBean.obtenerIdGopUnidadFuncional());
        Collections.reverse(items);
        return items;
    }

    public void onRowSelect(SelectEvent event) {
        selected = (Users) event.getObject();
        c_aux1 = "";
        Collection<UserRoles> userRolesCollection = selected.getUserRolesCollection();
        if (userRolesCollection != null && userRolesCollection.size() > 0) {
            for (UserRoles usr : userRolesCollection) {
                rol = usr.getAuthority();
                break;
            }
        }
    }
    
    public void cargarEmpleados() {
        listEmpleados = empleadoFacade.findAll();
    }

    public List<Empleado> getListEmpleados() {
        return listEmpleados;
    }

    public Users getSelected() {
        return selected;
    }

    public void setSelected(Users selected) {
        this.selected = selected;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getC_aux1() {
        return c_aux1;
    }

    public void setC_aux1(String c_aux1) {
        this.c_aux1 = c_aux1;
    }

    public String getC_aux2() {
        return c_aux2;
    }

    public void setC_aux2(String c_aux2) {
        this.c_aux2 = c_aux2;
    }

    public String getC_aux3() {
        return c_aux3;
    }

    public void setC_aux3(String c_aux3) {
        this.c_aux3 = c_aux3;
    }

    public boolean isB_cont() {
        return b_cont;
    }

    public void setB_cont(boolean b_cont) {
        this.b_cont = b_cont;
    }

    public boolean isB_cont2() {
        return b_cont2;
    }

    public void setB_cont2(boolean b_cont2) {
        this.b_cont2 = b_cont2;
    }

    public String getConfirContrasena() {
        return confirContrasena;
    }

    public void setConfirContrasena(String confirContrasena) {
        this.confirContrasena = confirContrasena;
    }

    public List<Rol> getItemsRoles() {
        if (itemsRoles == null) {
            itemsRoles = rolEJB.findAllEstadoReg();
        }
        return itemsRoles;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getC_username() {
        return c_username;
    }

    public void setC_username(String c_username) {
        this.c_username = c_username;
    }

    public List<Users> getItems() {
        return items;
    }

    public void setItems(List<Users> items) {
        this.items = items;
    }

}
