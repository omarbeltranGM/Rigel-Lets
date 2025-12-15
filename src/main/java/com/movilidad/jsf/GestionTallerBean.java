/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.jsf;

import com.movilidad.ejb.PrgTcFacadeLocal;
import com.movilidad.util.beans.ServiciosPorSalir;
import com.movilidad.utils.MovilidadUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;

/**
 *
 * @author solucionesit
 */
@Named(value = "gestionTallerBean")
@ViewScoped
public class GestionTallerBean implements Serializable {

    /**
     * Creates a new instance of GestionTallerBean
     */
    public GestionTallerBean() {
    }

    @EJB
    private PrgTcFacadeLocal tcEJB;

    private List<ServiciosPorSalir> list;
    private Date fecha;

    @PostConstruct
    public void init() {
        consultar();
        fecha = MovilidadUtil.fechaHoy();
    }

    public void consultar() {
        list = tcEJB.findServiciosForGestionTaller();
    }

    public List<ServiciosPorSalir> getList() {
        return list;
    }

    public void setList(List<ServiciosPorSalir> list) {
        this.list = list;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
