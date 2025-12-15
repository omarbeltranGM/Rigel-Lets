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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Ballestas
 */
@Entity
@Table(name = "novedad_mtto_tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NovedadMttoTipo.findAll", query = "SELECT n FROM NovedadMttoTipo n")
    , @NamedQuery(name = "NovedadMttoTipo.findByIdNovedadMttoTipo", query = "SELECT n FROM NovedadMttoTipo n WHERE n.idNovedadMttoTipo = :idNovedadMttoTipo")
    , @NamedQuery(name = "NovedadMttoTipo.findByNombre", query = "SELECT n FROM NovedadMttoTipo n WHERE n.nombre = :nombre")
    , @NamedQuery(name = "NovedadMttoTipo.findByDescripcion", query = "SELECT n FROM NovedadMttoTipo n WHERE n.descripcion = :descripcion")
    , @NamedQuery(name = "NovedadMttoTipo.findByUsername", query = "SELECT n FROM NovedadMttoTipo n WHERE n.username = :username")
    , @NamedQuery(name = "NovedadMttoTipo.findByCreado", query = "SELECT n FROM NovedadMttoTipo n WHERE n.creado = :creado")
    , @NamedQuery(name = "NovedadMttoTipo.findByModificado", query = "SELECT n FROM NovedadMttoTipo n WHERE n.modificado = :modificado")
    , @NamedQuery(name = "NovedadMttoTipo.findByEstadoReg", query = "SELECT n FROM NovedadMttoTipo n WHERE n.estadoReg = :estadoReg")})
public class NovedadMttoTipo implements Serializable {

    @OneToMany(mappedBy = "idNovedadMttoTipo", fetch = FetchType.LAZY)
    private List<NovedadMtto> novedadMttoList;

    @OneToMany(mappedBy = "idNovedadMttoTipo", fetch = FetchType.LAZY)
    private List<NovedadMttoTipoDet> novedadMttoTipoDetList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_novedad_mtto_tipo")
    private Integer idNovedadMttoTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
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

    public NovedadMttoTipo() {
    }

    public NovedadMttoTipo(Integer idNovedadMttoTipo) {
        this.idNovedadMttoTipo = idNovedadMttoTipo;
    }

    public NovedadMttoTipo(Integer idNovedadMttoTipo, String nombre, String descripcion) {
        this.idNovedadMttoTipo = idNovedadMttoTipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdNovedadMttoTipo() {
        return idNovedadMttoTipo;
    }

    public void setIdNovedadMttoTipo(Integer idNovedadMttoTipo) {
        this.idNovedadMttoTipo = idNovedadMttoTipo;
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
        hash += (idNovedadMttoTipo != null ? idNovedadMttoTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NovedadMttoTipo)) {
            return false;
        }
        NovedadMttoTipo other = (NovedadMttoTipo) object;
        if ((this.idNovedadMttoTipo == null && other.idNovedadMttoTipo != null) || (this.idNovedadMttoTipo != null && !this.idNovedadMttoTipo.equals(other.idNovedadMttoTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.NovedadMttoTipo[ idNovedadMttoTipo=" + idNovedadMttoTipo + " ]";
    }

    @XmlTransient
    public List<NovedadMttoTipoDet> getNovedadMttoTipoDetList() {
        return novedadMttoTipoDetList;
    }

    public void setNovedadMttoTipoDetList(List<NovedadMttoTipoDet> novedadMttoTipoDetList) {
        this.novedadMttoTipoDetList = novedadMttoTipoDetList;
    }

    @XmlTransient
    public List<NovedadMtto> getNovedadMttoList() {
        return novedadMttoList;
    }

    public void setNovedadMttoList(List<NovedadMtto> novedadMttoList) {
        this.novedadMttoList = novedadMttoList;
    }
    
}
