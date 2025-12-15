package com.movilidad.jsf;

import com.movilidad.utils.MovilidadUtil;
import com.movilidad.utils.Util;
import java.io.Serializable;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author HP
 */
@Named(value = "cargaArchivosJSF")
@ViewScoped
public class CargaArchivosJSF implements Serializable {

    private String c_ruta;

    private UploadedFile file;

    public CargaArchivosJSF() {
    }

    @PostConstruct
    public void init() {
        c_ruta = "/rigel/";
    }

    public void handleFileUpload(FileUploadEvent event) {
        file = event.getFile();
        MovilidadUtil.addSuccessMessage("Archivo cargado correctamente");
    }

    public void guardarArchivo() {
        if (file != null) {
            if (file.getSize() > 0) {
                String ruta = c_ruta + file.getFileName();
                if (Util.deleteFile(ruta)) {
                    boolean ok = Util.saveFile(file, ruta, false);
                    if (ok) {
                        MovilidadUtil.addSuccessMessage("Archivo sobreescrito correctamente");
                    } else {
                        MovilidadUtil.addErrorMessage("Ocurrio un problema");
                    }
                } else {
                    boolean ok = Util.saveFile(file, c_ruta, true);
                    if (ok) {
                        MovilidadUtil.addSuccessMessage("Archivo guardado correctamente");
                    } else {
                        MovilidadUtil.addErrorMessage("Ocurrio un problema");
                    }
                }
                reset();
                return;
            }
        }
        MovilidadUtil.addErrorMessage("No se realizó la carga de un archivo");
    }

    public void reset() {
        file = null;
        c_ruta = "/rigel/";
    }

    public String getC_ruta() {
        return c_ruta;
    }

    public void setC_ruta(String c_ruta) {
        this.c_ruta = c_ruta;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

}
