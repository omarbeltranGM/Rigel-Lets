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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author solucionesit
 */
@Entity
@Table(name = "auditoria_estacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuditoriaEstacion.findAll", query = "SELECT a FROM AuditoriaEstacion a"),
    @NamedQuery(name = "AuditoriaEstacion.findByIdAuditoriaEstacion", query = "SELECT a FROM AuditoriaEstacion a WHERE a.idAuditoriaEstacion = :idAuditoriaEstacion"),
    @NamedQuery(name = "AuditoriaEstacion.findByNombre", query = "SELECT a FROM AuditoriaEstacion a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "AuditoriaEstacion.findByDescripcion", query = "SELECT a FROM AuditoriaEstacion a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "AuditoriaEstacion.findByCreado", query = "SELECT a FROM AuditoriaEstacion a WHERE a.creado = :creado"),
    @NamedQuery(name = "AuditoriaEstacion.findByModificado", query = "SELECT a FROM AuditoriaEstacion a WHERE a.modificado = :modificado"),
    @NamedQuery(name = "AuditoriaEstacion.findByEstadoReg", query = "SELECT a FROM AuditoriaEstacion a WHERE a.estadoReg = :estadoReg")})
public class AuditoriaEstacion implements Serializable {

    @OneToMany(mappedBy = "idAuditoriaEstacion", fetch = FetchType.LAZY)
    private List<AuditoriaRealizadoPor> auditoriaRealizadoPorList;
 
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_auditoria_estacion")
    private Integer idAuditoriaEstacion;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_reg")
    private int estadoReg;
    @JoinColumn(name = "id_param_area", referencedColumnName = "id_param_area")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ParamArea idParamArea;

    public AuditoriaEstacion() {
    }

    public AuditoriaEstacion(Integer idAuditoriaEstacion) {
        this.idAuditoriaEstacion = idAuditoriaEstacion;
    }

    public AuditoriaEstacion(Integer idAuditoriaEstacion, Date creado, int estadoReg) {
        this.idAuditoriaEstacion = idAuditoriaEstacion;
        this.creado = creado;
        this.estadoReg = estadoReg;
    }

    public Integer getIdAuditoriaEstacion() {
        return idAuditoriaEstacion;
    }

    public void setIdAuditoriaEstacion(Integer idAuditoriaEstacion) {
        this.idAuditoriaEstacion = idAuditoriaEstacion;
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

    public int getEstadoReg() {
        return estadoReg;
    }

    public void setEstadoReg(int estadoReg) {
        this.estadoReg = estadoReg;
    }

    public ParamArea getIdParamArea() {
        return idParamArea;
    }

    public void setIdParamArea(ParamArea idParamArea) {
        this.idParamArea = idParamArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuditoriaEstacion != null ? idAuditoriaEstacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuditoriaEstacion)) {
            return false;
        }
        AuditoriaEstacion other = (AuditoriaEstacion) object;
        if ((this.idAuditoriaEstacion == null && other.idAuditoriaEstacion != null) || (this.idAuditoriaEstacion != null && !this.idAuditoriaEstacion.equals(other.idAuditoriaEstacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AuditoriaEstacion[ idAuditoriaEstacion=" + idAuditoriaEstacion + " ]";
    }

    @XmlTransient
    public List<AuditoriaRealizadoPor> getAuditoriaRealizadoPorList() {
        return auditoriaRealizadoPorList;
    }

    public void setAuditoriaRealizadoPorList(List<AuditoriaRealizadoPor> auditoriaRealizadoPorList) {
        this.auditoriaRealizadoPorList = auditoriaRealizadoPorList;
    }
    
}
