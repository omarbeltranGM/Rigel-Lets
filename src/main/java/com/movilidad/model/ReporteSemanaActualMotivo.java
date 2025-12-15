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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "reporte_semana_motivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteSemanaActualMotivo.findAll", query = "SELECT p FROM ReporteSemanaActualMotivo p"),
    @NamedQuery(name = "ReporteSemanaActualMotivo.findByActivo", query = "SELECT p FROM ReporteSemanaActualMotivo p WHERE p.activo = :activo"),
    @NamedQuery(name = "ReporteSemanaActualMotivo.findByUsername", query = "SELECT p FROM ReporteSemanaActualMotivo p WHERE p.username = :username"),
    @NamedQuery(name = "ReporteSemanaActualMotivo.findByCreado", query = "SELECT p FROM ReporteSemanaActualMotivo p WHERE p.creado = :creado"),
    @NamedQuery(name = "ReporteSemanaActualMotivo.findByModificado", query = "SELECT p FROM ReporteSemanaActualMotivo p WHERE p.modificado = :modificado"),
    @NamedQuery(name = "ReporteSemanaActualMotivo.findByEstadoReg", query = "SELECT p FROM ReporteSemanaActualMotivo p WHERE p.estadoReg = :estadoReg")})
public class ReporteSemanaActualMotivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_motivo") 
    private Integer idMotivo;
        
    @Column(name = "activo")
    private Integer activo;
    
    @Column(name = "motivo")
    private String motivo;
    
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic(optional = false)
    private Date creado;
    
    @Column(name = "modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificado;
    
    @Column(name = "estado_reg")
    private Integer estadoReg;
    
    @Size(max = 15)
    @Column(name = "username")
    private String username;

    public ReporteSemanaActualMotivo() {
    }

    public ReporteSemanaActualMotivo(Integer idMotivo) {
        this.idMotivo = idMotivo;
    }

    public ReporteSemanaActualMotivo(Integer idMotivo, Integer activo, String motivo, Date creado, Date modificado, Integer estadoReg, String username) {
        this.idMotivo = idMotivo;
        this.activo = activo;
        this.motivo = motivo;
        this.creado = creado;
        this.modificado = modificado;
        this.estadoReg = estadoReg;
        this.username = username;
    }

    public Integer getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(Integer idMotivo) {
        this.idMotivo = idMotivo;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
