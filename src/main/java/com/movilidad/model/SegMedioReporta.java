/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author solucionesit
 */
@Entity
@Table(name = "seg_medio_reporta")
@XmlRootElement
public class SegMedioReporta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_seg_medio_reporta")
    private Integer idSegMedioReporta;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
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
    @OneToMany(mappedBy = "idSegMedioReporta", fetch = FetchType.LAZY)
    private List<SegInoperativos> segInoperativosList;

    public SegMedioReporta() {
    }

    public SegMedioReporta(Integer idSegMedioReporta) {
        this.idSegMedioReporta = idSegMedioReporta;
    }

    public Integer getIdSegMedioReporta() {
        return idSegMedioReporta;
    }

    public void setIdSegMedioReporta(Integer idSegMedioReporta) {
        this.idSegMedioReporta = idSegMedioReporta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @XmlTransient
    public List<SegInoperativos> getSegInoperativosList() {
        return segInoperativosList;
    }

    public void setSegInoperativosList(List<SegInoperativos> segInoperativosList) {
        this.segInoperativosList = segInoperativosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSegMedioReporta != null ? idSegMedioReporta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegMedioReporta)) {
            return false;
        }
        SegMedioReporta other = (SegMedioReporta) object;
        if ((this.idSegMedioReporta == null && other.idSegMedioReporta != null) || (this.idSegMedioReporta != null && !this.idSegMedioReporta.equals(other.idSegMedioReporta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.SegMedioReporta[ idSegMedioReporta=" + idSegMedioReporta + " ]";
    }
    
}
