/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.jsf;

import com.movilidad.utils.MovilidadUtil;
import java.io.Serializable;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author HP
 */
@Named(value = "logJSF")
@ViewScoped
public class LogJSF implements Serializable {

    private StreamedContent fileDown;

    @Inject
    private ViewDocumentoJSFManagedBean viewDMB;

    public LogJSF() {
    }

    public void prepDownloadLocal() throws Exception {
        String path = "/opt/payara5/glassfish/domains/domain1/logs/server.log";
        viewDMB.setDownload(MovilidadUtil.prepDownload(path));
        fileDown = MovilidadUtil.prepDownload(path);
    }

    public StreamedContent getFileDown() {
        return fileDown;
    }

    public void setFileDown(StreamedContent fileDown) {
        this.fileDown = fileDown;
    }

}
