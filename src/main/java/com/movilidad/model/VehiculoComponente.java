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
 * @author HP
 */
@Entity
@Table(name = "vehiculo_componente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehiculoComponente.findAll", query = "SELECT v FROM VehiculoComponente v")
    , @NamedQuery(name = "VehiculoComponente.findByIdVehiculoComponente", query = "SELECT v FROM VehiculoComponente v WHERE v.idVehiculoComponente = :idVehiculoComponente")
    , @NamedQuery(name = "VehiculoComponente.findByNombre", query = "SELECT v FROM VehiculoComponente v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "VehiculoComponente.findByDescripcion", query = "SELECT v FROM VehiculoComponente v WHERE v.descripcion = :descripcion")
    , @NamedQuery(name = "VehiculoComponente.findByAfectaPm", query = "SELECT v FROM VehiculoComponente v WHERE v.afectaPm = :afectaPm")
    , @NamedQuery(name = "VehiculoComponente.findByUsername", query = "SELECT v FROM VehiculoComponente v WHERE v.username = :username")
    , @NamedQuery(name = "VehiculoComponente.findByCreado", query = "SELECT v FROM VehiculoComponente v WHERE v.creado = :creado")
    , @NamedQuery(name = "VehiculoComponente.findByModificado", query = "SELECT v FROM VehiculoComponente v WHERE v.modificado = :modificado")
    , @NamedQuery(name = "VehiculoComponente.findByEstadoReg", query = "SELECT v FROM VehiculoComponente v WHERE v.estadoReg = :estadoReg")})
public class VehiculoComponente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo_componente")
    private Integer idVehiculoComponente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "afecta_pm")
    private int afectaPm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "username")
    private String username;
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
    @JoinColumn(name = "id_vehiculo_componente_zona", referencedColumnName = "id_vehiculo_componente_zona")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private VehiculoComponenteZona idVehiculoComponenteZona;
    @JoinColumn(name = "id_vehiculo_componente_grupo", referencedColumnName = "id_vehiculo_componente_grupo")
    @ManyToOne(fetch = FetchType.LAZY)
    private VehiculoComponenteGrupo idVehiculoComponenteGrupo;
    @OneToMany(mappedBy = "idVehiculoComponente", fetch = FetchType.LAZY)
    private List<NovedadDano> novedadDanoList;

    public VehiculoComponente() {
    }

    public VehiculoComponente(Integer idVehiculoComponente) {
        this.idVehiculoComponente = idVehiculoComponente;
    }

    public VehiculoComponente(Integer idVehiculoComponente, String nombre, String descripcion, int afectaPm, String username, Date creado, int estadoReg) {
        this.idVehiculoComponente = idVehiculoComponente;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.afectaPm = afectaPm;
        this.username = username;
        this.creado = creado;
        this.estadoReg = estadoReg;
    }

    public Integer getIdVehiculoComponente() {
        return idVehiculoComponente;
    }

    public void setIdVehiculoComponente(Integer idVehiculoComponente) {
        this.idVehiculoComponente = idVehiculoComponente;
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

    public int getAfectaPm() {
        return afectaPm;
    }

    public void setAfectaPm(int afectaPm) {
        this.afectaPm = afectaPm;
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

    public int getEstadoReg() {
        return estadoReg;
    }

    public void setEstadoReg(int estadoReg) {
        this.estadoReg = estadoReg;
    }

    public VehiculoComponenteZona getIdVehiculoComponenteZona() {
        return idVehiculoComponenteZona;
    }

    public void setIdVehiculoComponenteZona(VehiculoComponenteZona idVehiculoComponenteZona) {
        this.idVehiculoComponenteZona = idVehiculoComponenteZona;
    }

    public VehiculoComponenteGrupo getIdVehiculoComponenteGrupo() {
        return idVehiculoComponenteGrupo;
    }

    public void setIdVehiculoComponenteGrupo(VehiculoComponenteGrupo idVehiculoComponenteGrupo) {
        this.idVehiculoComponenteGrupo = idVehiculoComponenteGrupo;
    }

    @XmlTransient
    public List<NovedadDano> getNovedadDanoList() {
        return novedadDanoList;
    }

    public void setNovedadDanoList(List<NovedadDano> novedadDanoList) {
        this.novedadDanoList = novedadDanoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculoComponente != null ? idVehiculoComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculoComponente)) {
            return false;
        }
        VehiculoComponente other = (VehiculoComponente) object;
        if ((this.idVehiculoComponente == null && other.idVehiculoComponente != null) || (this.idVehiculoComponente != null && !this.idVehiculoComponente.equals(other.idVehiculoComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.VehiculoComponente[ idVehiculoComponente=" + idVehiculoComponente + " ]";
    }
    
}
