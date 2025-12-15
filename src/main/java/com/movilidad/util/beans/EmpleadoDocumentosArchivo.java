package com.movilidad.util.beans;

import com.movilidad.model.EmpleadoDocumentos;
import java.io.Serializable;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author solucionesit
 */
public class EmpleadoDocumentosArchivo implements Serializable {

    private EmpleadoDocumentos empleadoDocumentos;
    private UploadedFile archivo;

    public EmpleadoDocumentos getEmpleadoDocumentos() {
        return empleadoDocumentos;
    }

    public void setEmpleadoDocumentos(EmpleadoDocumentos empleadoDocumentos) {
        this.empleadoDocumentos = empleadoDocumentos;
    }

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }
    
    
}
