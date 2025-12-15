package com.movilidad.util.beans;

import com.movilidad.model.AseoCabinaNovedad;
import java.io.Serializable;
import java.util.List;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author solucionesit
 */
@XmlRootElement
public class AseoCabinaNovedadArchivo implements Serializable {

    private AseoCabinaNovedad AseoCabinaNovedad;
    private List<UploadedFile> archivos;

    public AseoCabinaNovedadArchivo(AseoCabinaNovedad AseoCabinaNovedad, List<UploadedFile> archivos) {
        this.AseoCabinaNovedad = AseoCabinaNovedad;
        this.archivos = archivos;
    }

    public AseoCabinaNovedadArchivo() {
    }

    public AseoCabinaNovedad getAseoCabinaNovedad() {
        return AseoCabinaNovedad;
    }

    public void setAseoCabinaNovedad(AseoCabinaNovedad AseoCabinaNovedad) {
        this.AseoCabinaNovedad = AseoCabinaNovedad;
    }

    public List<UploadedFile> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<UploadedFile> archivos) {
        this.archivos = archivos;
    }

}
