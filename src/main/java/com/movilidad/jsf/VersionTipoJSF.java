/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movilidad.jsf;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import com.movilidad.ejb.VersionTipoFacadeLocal;
import com.movilidad.model.VersionTipo;
import java.util.List;

/**
 *
 * @author Andres
 */
@Named(value = "versionTipoJSF")
@ViewScoped

public class VersionTipoJSF implements Serializable {

    @EJB
    private VersionTipoFacadeLocal versionTipoFacadeLocal;

    private VersionTipo versionTipo;

    private List<VersionTipo> listVersionTipo;

    /**
     * Nueva instancia de versionTipoJSF
     */
    public void VersionTipoJSF() {
    }

    /**
     * Preparar un nuevo registro de VersionTipo
     */
    public void prepareGuardar() {
        versionTipo = new VersionTipo();
    }

}
