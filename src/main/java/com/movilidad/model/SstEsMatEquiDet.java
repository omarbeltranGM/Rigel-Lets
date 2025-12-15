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
 * @author Carlos Ballestas
 */
@Entity
@Table(name = "sst_es_mat_equi_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SstEsMatEquiDet.findAll", query = "SELECT s FROM SstEsMatEquiDet s"),
    @NamedQuery(name = "SstEsMatEquiDet.findByIdSstEsMatEquiDet", query = "SELECT s FROM SstEsMatEquiDet s WHERE s.idSstEsMatEquiDet = :idSstEsMatEquiDet"),
    @NamedQuery(name = "SstEsMatEquiDet.findBySerial", query = "SELECT s FROM SstEsMatEquiDet s WHERE s.serial = :serial"),
    @NamedQuery(name = "SstEsMatEquiDet.findByCantidad", query = "SELECT s FROM SstEsMatEquiDet s WHERE s.cantidad = :cantidad"),
    @NamedQuery(name = "SstEsMatEquiDet.findByUsername", query = "SELECT s FROM SstEsMatEquiDet s WHERE s.username = :username"),
    @NamedQuery(name = "SstEsMatEquiDet.findByCreado", query = "SELECT s FROM SstEsMatEquiDet s WHERE s.creado = :creado"),
    @NamedQuery(name = "SstEsMatEquiDet.findByModificado", query = "SELECT s FROM SstEsMatEquiDet s WHERE s.modificado = :modificado"),
    @NamedQuery(name = "SstEsMatEquiDet.findByEstadoReg", query = "SELECT s FROM SstEsMatEquiDet s WHERE s.estadoReg = :estadoReg")})
public class SstEsMatEquiDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sst_es_mat_equi_det")
    private Integer idSstEsMatEquiDet;
    @Size(max = 60)
    @Column(name = "serial")
    private String serial;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 15)
    @Column(name = "username")
    private String username;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificado;
    @Column(name = "estado_reg")
    private Integer estadoReg;
    @JoinColumn(name = "id_sst_es_mat_equi", referencedColumnName = "id_sst_es_mat_equi")
    @ManyToOne(fetch = FetchType.LAZY)
    private SstEsMatEqui idSstEsMatEqui;
    @JoinColumn(name = "id_sst_mat_equi", referencedColumnName = "id_sst_mat_equi")
    @ManyToOne(fetch = FetchType.LAZY)
    private SstMatEqui idSstMatEqui;

    public SstEsMatEquiDet() {
    }

    public SstEsMatEquiDet(Integer idSstEsMatEquiDet) {
        this.idSstEsMatEquiDet = idSstEsMatEquiDet;
    }

    public Integer getIdSstEsMatEquiDet() {
        return idSstEsMatEquiDet;
    }

    public void setIdSstEsMatEquiDet(Integer idSstEsMatEquiDet) {
        this.idSstEsMatEquiDet = idSstEsMatEquiDet;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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

    public SstEsMatEqui getIdSstEsMatEqui() {
        return idSstEsMatEqui;
    }

    public void setIdSstEsMatEqui(SstEsMatEqui idSstEsMatEqui) {
        this.idSstEsMatEqui = idSstEsMatEqui;
    }

    public SstMatEqui getIdSstMatEqui() {
        return idSstMatEqui;
    }

    public void setIdSstMatEqui(SstMatEqui idSstMatEqui) {
        this.idSstMatEqui = idSstMatEqui;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSstEsMatEquiDet != null ? idSstEsMatEquiDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SstEsMatEquiDet)) {
            return false;
        }
        SstEsMatEquiDet other = (SstEsMatEquiDet) object;
        if ((this.idSstEsMatEquiDet == null && other.idSstEsMatEquiDet != null) || (this.idSstEsMatEquiDet != null && !this.idSstEsMatEquiDet.equals(other.idSstEsMatEquiDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.SstEsMatEquiDet[ idSstEsMatEquiDet=" + idSstEsMatEquiDet + " ]";
    }
    
}
