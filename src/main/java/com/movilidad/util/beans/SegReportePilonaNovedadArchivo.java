package com.movilidad.util.beans;

import com.movilidad.model.SegReportePilonaNovedad;
import java.io.Serializable;
import java.util.List;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author solucionesit
 */
@XmlRootElement
public class SegReportePilonaNovedadArchivo implements Serializable {

    private SegReportePilonaNovedad segReportePilonaNovedad;
    private List<UploadedFile> archivos;

    public SegReportePilonaNovedadArchivo(SegReportePilonaNovedad segReportePilonaNovedad, List<UploadedFile> archivos) {
        this.segReportePilonaNovedad = segReportePilonaNovedad;
        this.archivos = archivos;
    }

    public SegReportePilonaNovedadArchivo() {
    }

    public SegReportePilonaNovedad getSegReportePilonaNovedad() {
        return segReportePilonaNovedad;
    }

    public void setSegReportePilonaNovedad(SegReportePilonaNovedad segReportePilonaNovedad) {
        this.segReportePilonaNovedad = segReportePilonaNovedad;
    }

    public List<UploadedFile> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<UploadedFile> archivos) {
        this.archivos = archivos;
    }

}
