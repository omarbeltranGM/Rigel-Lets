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
import jakarta.persistence.Lob;
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
 * @author Carlos Ballestas
 */
@Entity
@Table(name = "mtto_componente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MttoComponente.findAll", query = "SELECT m FROM MttoComponente m")
    ,
    @NamedQuery(name = "MttoComponente.findByIdMttoComponente", query = "SELECT m FROM MttoComponente m WHERE m.idMttoComponente = :idMttoComponente")
    ,
    @NamedQuery(name = "MttoComponente.findByNombre", query = "SELECT m FROM MttoComponente m WHERE m.nombre = :nombre")
    ,
    @NamedQuery(name = "MttoComponente.findByUsername", query = "SELECT m FROM MttoComponente m WHERE m.username = :username")
    ,
    @NamedQuery(name = "MttoComponente.findByCreado", query = "SELECT m FROM MttoComponente m WHERE m.creado = :creado")
    ,
    @NamedQuery(name = "MttoComponente.findByModificado", query = "SELECT m FROM MttoComponente m WHERE m.modificado = :modificado")
    ,
    @NamedQuery(name = "MttoComponente.findByEstadoReg", query = "SELECT m FROM MttoComponente m WHERE m.estadoReg = :estadoReg")})
public class MttoComponente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mtto_componente")
    private Integer idMttoComponente;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Size(max = 65535)
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
    @OneToMany(mappedBy = "idMttoComponente", fetch = FetchType.LAZY)
    private List<MttoNovedad> mttoNovedadList;
    @OneToMany(mappedBy = "idMttoComponente", fetch = FetchType.LAZY)
    private List<MttoComponenteFalla> mttoComponenteFallaList;
    @Size(max = 45)
    @Column(name = "icono")
    private String icono;

    public MttoComponente() {
    }

    public MttoComponente(Integer idMttoComponente) {
        this.idMttoComponente = idMttoComponente;
    }

    public Integer getIdMttoComponente() {
        return idMttoComponente;
    }

    public void setIdMttoComponente(Integer idMttoComponente) {
        this.idMttoComponente = idMttoComponente;
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
    public List<MttoNovedad> getMttoNovedadList() {
        return mttoNovedadList;
    }

    public void setMttoNovedadList(List<MttoNovedad> mttoNovedadList) {
        this.mttoNovedadList = mttoNovedadList;
    }

    @XmlTransient
    public List<MttoComponenteFalla> getMttoComponenteFallaList() {
        return mttoComponenteFallaList;
    }

    public void setMttoComponenteFallaList(List<MttoComponenteFalla> mttoComponenteFallaList) {
        this.mttoComponenteFallaList = mttoComponenteFallaList;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMttoComponente != null ? idMttoComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MttoComponente)) {
            return false;
        }
        MttoComponente other = (MttoComponente) object;
        if ((this.idMttoComponente == null && other.idMttoComponente != null) || (this.idMttoComponente != null && !this.idMttoComponente.equals(other.idMttoComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.MttoComponente[ idMttoComponente=" + idMttoComponente + " ]";
    }

}
