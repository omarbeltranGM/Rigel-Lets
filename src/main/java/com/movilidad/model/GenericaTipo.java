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
import jakarta.persistence.CascadeType;
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
@Table(name = "generica_tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenericaTipo.findAll", query = "SELECT g FROM GenericaTipo g"),
    @NamedQuery(name = "GenericaTipo.findByIdGenericaTipo", query = "SELECT g FROM GenericaTipo g WHERE g.idGenericaTipo = :idGenericaTipo"),
    @NamedQuery(name = "GenericaTipo.findByNombreTipoNovedad", query = "SELECT g FROM GenericaTipo g WHERE g.nombreTipoNovedad = :nombreTipoNovedad"),
    @NamedQuery(name = "GenericaTipo.findByDescripcionTipoNovedad", query = "SELECT g FROM GenericaTipo g WHERE g.descripcionTipoNovedad = :descripcionTipoNovedad"),
    @NamedQuery(name = "GenericaTipo.findByUsername", query = "SELECT g FROM GenericaTipo g WHERE g.username = :username"),
    @NamedQuery(name = "GenericaTipo.findByCreado", query = "SELECT g FROM GenericaTipo g WHERE g.creado = :creado"),
    @NamedQuery(name = "GenericaTipo.findByModificado", query = "SELECT g FROM GenericaTipo g WHERE g.modificado = :modificado"),
    @NamedQuery(name = "GenericaTipo.findByEstadoReg", query = "SELECT g FROM GenericaTipo g WHERE g.estadoReg = :estadoReg")})
public class GenericaTipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_generica_tipo")
    private Integer idGenericaTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_novedad")
    private String nombreTipoNovedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion_tipo_novedad")
    private String descripcionTipoNovedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "username")
    private String username;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGenericaTipo", fetch = FetchType.LAZY)
    private List<Generica> genericaList;
    @OneToMany(mappedBy = "idGenericaTipo", fetch = FetchType.LAZY)
    private List<GenericaTipoDetalles> genericaTipoDetallesList;
    @JoinColumn(name = "id_param_area", referencedColumnName = "id_param_area")
    @ManyToOne(fetch = FetchType.LAZY)
    private ParamArea idParamArea;

    public GenericaTipo() {
    }

    public GenericaTipo(Integer idGenericaTipo) {
        this.idGenericaTipo = idGenericaTipo;
    }

    public GenericaTipo(Integer idGenericaTipo, String nombreTipoNovedad, String descripcionTipoNovedad, String username, int estadoReg) {
        this.idGenericaTipo = idGenericaTipo;
        this.nombreTipoNovedad = nombreTipoNovedad;
        this.descripcionTipoNovedad = descripcionTipoNovedad;
        this.username = username;
        this.estadoReg = estadoReg;
    }

    public Integer getIdGenericaTipo() {
        return idGenericaTipo;
    }

    public void setIdGenericaTipo(Integer idGenericaTipo) {
        this.idGenericaTipo = idGenericaTipo;
    }

    public String getNombreTipoNovedad() {
        return nombreTipoNovedad;
    }

    public void setNombreTipoNovedad(String nombreTipoNovedad) {
        this.nombreTipoNovedad = nombreTipoNovedad;
    }

    public String getDescripcionTipoNovedad() {
        return descripcionTipoNovedad;
    }

    public void setDescripcionTipoNovedad(String descripcionTipoNovedad) {
        this.descripcionTipoNovedad = descripcionTipoNovedad;
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

    @XmlTransient
    public List<Generica> getGenericaList() {
        return genericaList;
    }

    public void setGenericaList(List<Generica> genericaList) {
        this.genericaList = genericaList;
    }

    @XmlTransient
    public List<GenericaTipoDetalles> getGenericaTipoDetallesList() {
        return genericaTipoDetallesList;
    }

    public void setGenericaTipoDetallesList(List<GenericaTipoDetalles> genericaTipoDetallesList) {
        this.genericaTipoDetallesList = genericaTipoDetallesList;
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
        hash += (idGenericaTipo != null ? idGenericaTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenericaTipo)) {
            return false;
        }
        GenericaTipo other = (GenericaTipo) object;
        if ((this.idGenericaTipo == null && other.idGenericaTipo != null) || (this.idGenericaTipo != null && !this.idGenericaTipo.equals(other.idGenericaTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.GenericaTipo[ idGenericaTipo=" + idGenericaTipo + " ]";
    }
    
}
