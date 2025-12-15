package com.movilidad.util.beans;

import com.movilidad.model.AccInformeMasterTestigo;
import java.io.Serializable;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author HP
 */
public class AccInformeMasterTestigoVideo implements Serializable {

    private AccInformeMasterTestigo accInformeMasterTestigo;
    private UploadedFile uploadedFile;

    public AccInformeMasterTestigoVideo() {

    }

    public AccInformeMasterTestigoVideo(AccInformeMasterTestigo accInformeMasterTestigo, UploadedFile uploadedFile) {
        this.accInformeMasterTestigo = accInformeMasterTestigo;
        this.uploadedFile = uploadedFile;
    }

    public AccInformeMasterTestigo getAccInformeMasterTestigo() {
        return accInformeMasterTestigo;
    }

    public void setAccInformeMasterTestigo(AccInformeMasterTestigo accInformeMasterTestigo) {
        this.accInformeMasterTestigo = accInformeMasterTestigo;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

}
