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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julián Arévalo
 */
@Entity
@Table(name = "pm_periodos_liquidacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmPeriodosLiquidacion.findAll", query = "SELECT p FROM PmPeriodosLiquidacion p"),
    @NamedQuery(name = "PmPeriodosLiquidacion.findByIdPmNovedadIncluir", query = "SELECT p FROM PmPeriodosLiquidacion p WHERE p.idPmPeriodoLiquidacion = :idPmPeriodoLiquidacion"),
    @NamedQuery(name = "PmPeriodosLiquidacion.findByActivo", query = "SELECT p FROM PmPeriodosLiquidacion p WHERE p.activo = :activo"),
    @NamedQuery(name = "PmPeriodosLiquidacion.findByUsername", query = "SELECT p FROM PmPeriodosLiquidacion p WHERE p.username = :username"),
    @NamedQuery(name = "PmPeriodosLiquidacion.findByCreado", query = "SELECT p FROM PmPeriodosLiquidacion p WHERE p.creado = :creado"),
    @NamedQuery(name = "PmPeriodosLiquidacion.findByModificado", query = "SELECT p FROM PmPeriodosLiquidacion p WHERE p.modificado = :modificado"),
    @NamedQuery(name = "PmPeriodosLiquidacion.findByEstadoReg", query = "SELECT p FROM PmPeriodosLiquidacion p WHERE p.estadoReg = :estadoReg")})
public class PmPeriodosLiquidacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_periodos_liquidacion") 
    private int idPmPeriodoLiquidacion;
    
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    
    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "activo")
    private Integer activo;
    
    @Size(max = 15)
    @Column(name = "username")
    private String username;
    
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic(optional = false)
    private Date creado;
    
    @Column(name = "modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificado;
    
    @Column(name = "estado_reg")
    private Integer estadoReg;


    public PmPeriodosLiquidacion() {
    }

    public PmPeriodosLiquidacion(int idPmPeriodoLiquidacion) {
        this.idPmPeriodoLiquidacion = idPmPeriodoLiquidacion;
    }

    public int getIdPmPeriodoLiquidacion() {
        return idPmPeriodoLiquidacion;
    }

    public void setIdPmPeriodoLiquidacion(Integer idPmPeriodoLiquidacion) {
        this.idPmPeriodoLiquidacion = idPmPeriodoLiquidacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

}
