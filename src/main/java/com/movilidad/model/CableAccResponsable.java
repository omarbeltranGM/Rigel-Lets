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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cesar
 */
@Entity
@Table(name = "cable_acc_responsable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CableAccResponsable.findAll", query = "SELECT c FROM CableAccResponsable c")
    , @NamedQuery(name = "CableAccResponsable.findByIdCableAccResponsable", query = "SELECT c FROM CableAccResponsable c WHERE c.idCableAccResponsable = :idCableAccResponsable")
    , @NamedQuery(name = "CableAccResponsable.findByNombre", query = "SELECT c FROM CableAccResponsable c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CableAccResponsable.findByDescripcion", query = "SELECT c FROM CableAccResponsable c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "CableAccResponsable.findByUsername", query = "SELECT c FROM CableAccResponsable c WHERE c.username = :username")
    , @NamedQuery(name = "CableAccResponsable.findByCreado", query = "SELECT c FROM CableAccResponsable c WHERE c.creado = :creado")
    , @NamedQuery(name = "CableAccResponsable.findByModificado", query = "SELECT c FROM CableAccResponsable c WHERE c.modificado = :modificado")
    , @NamedQuery(name = "CableAccResponsable.findByEstadoReg", query = "SELECT c FROM CableAccResponsable c WHERE c.estadoReg = :estadoReg")})
public class CableAccResponsable implements Serializable {

    @OneToMany(mappedBy = "idCableAccResponsable", fetch = FetchType.LAZY)
    private List<CableAccPlanAccion> cableAccPlanAccionList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cable_acc_responsable")
    private Integer idCableAccResponsable;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
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

    public CableAccResponsable() {
    }

    public CableAccResponsable(Integer idCableAccResponsable) {
        this.idCableAccResponsable = idCableAccResponsable;
    }

    public Integer getIdCableAccResponsable() {
        return idCableAccResponsable;
    }

    public void setIdCableAccResponsable(Integer idCableAccResponsable) {
        this.idCableAccResponsable = idCableAccResponsable;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCableAccResponsable != null ? idCableAccResponsable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CableAccResponsable)) {
            return false;
        }
        CableAccResponsable other = (CableAccResponsable) object;
        if ((this.idCableAccResponsable == null && other.idCableAccResponsable != null) || (this.idCableAccResponsable != null && !this.idCableAccResponsable.equals(other.idCableAccResponsable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.CableAccResponsable[ idCableAccResponsable=" + idCableAccResponsable + " ]";
    }

    @XmlTransient
    public List<CableAccPlanAccion> getCableAccPlanAccionList() {
        return cableAccPlanAccionList;
    }

    public void setCableAccPlanAccionList(List<CableAccPlanAccion> cableAccPlanAccionList) {
        this.cableAccPlanAccionList = cableAccPlanAccionList;
    }
    
}
