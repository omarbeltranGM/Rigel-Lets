/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author soluciones-it
 */
@Entity
@Table(name = "my_app_novedad_param")
public class MyAppNovedadParam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_my_app_novedad_param")
    private Integer idMyAppNovedadParam;
    @Column(name = "codigo_proceso")
    private String codigoProceso;
    @Column(name = "descripcion") // descripcion proceso
    private String descripcion;
    @Column(name = "asunto")
    private String asunto; // default 0
    @Column(name = "username") // descripcion proceso
    private String username;
    @Basic(optional = false)
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Basic(optional = false)
    @Column(name = "modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificado;
    @Basic(optional = false)
    @Column(name = "estado_reg")
    private Integer estadoReg;
    @JoinColumn(name = "id_novedad_tipo_detalle", referencedColumnName = "id_novedad_tipo_detalle")
    @ManyToOne(fetch = FetchType.LAZY)
    private NovedadTipoDetalles idNovedadTipoDetalle;

    public Integer getIdMyAppNovedadParam() {
        return idMyAppNovedadParam;
    }

    public void setIdMyAppNovedadParam(Integer idMyAppNovedadParam) {
        this.idMyAppNovedadParam = idMyAppNovedadParam;
    }

    public String getCodigoProceso() {
        return codigoProceso;
    }

    public void setCodigoProceso(String codigoProceso) {
        this.codigoProceso = codigoProceso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getModificado() {
        return modificado;
    }

    public void setModificado(Date modificado) {
        this.modificado = modificado;
    }

    public Integer getEstadoReg() {
        return estadoReg;
    }

    public void setEstadoReg(Integer estadoReg) {
        this.estadoReg = estadoReg;
    }

    public NovedadTipoDetalles getIdNovedadTipoDetalle() {
        return idNovedadTipoDetalle;
    }

    public void setIdNovedadTipoDetalle(NovedadTipoDetalles idNovedadTipoDetalle) {
        this.idNovedadTipoDetalle = idNovedadTipoDetalle;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

}
