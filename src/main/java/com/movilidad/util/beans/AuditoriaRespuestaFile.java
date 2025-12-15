package com.movilidad.util.beans;

import com.movilidad.model.AuditoriaRespuesta;
import java.io.Serializable;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author solucionesit
 */
public class AuditoriaRespuestaFile implements Serializable {

    private AuditoriaRespuesta auditoriaRespuesta;
    private UploadedFile uploadedFile;

    public AuditoriaRespuestaFile() {
    }

    public AuditoriaRespuestaFile(AuditoriaRespuesta auditoriaRespuesta) {
        this.auditoriaRespuesta = auditoriaRespuesta;
    }

    public AuditoriaRespuestaFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public AuditoriaRespuestaFile(AuditoriaRespuesta auditoriaRespuesta, UploadedFile uploadedFile) {
        this.auditoriaRespuesta = auditoriaRespuesta;
        this.uploadedFile = uploadedFile;
    }
    
    public AuditoriaRespuesta getAuditoriaRespuesta() {
        return auditoriaRespuesta;
    }

    public void setAuditoriaRespuesta(AuditoriaRespuesta auditoriaRespuesta) {
        this.auditoriaRespuesta = auditoriaRespuesta;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

}
