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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cesar
 */
@Entity
@Table(name = "novedad_mtto_tipo_actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NovedadMttoTipoActividad.findAll", query = "SELECT n FROM NovedadMttoTipoActividad n")
    , @NamedQuery(name = "NovedadMttoTipoActividad.findByIdNovedadMttoTipoActividad", query = "SELECT n FROM NovedadMttoTipoActividad n WHERE n.idNovedadMttoTipoActividad = :idNovedadMttoTipoActividad")
    , @NamedQuery(name = "NovedadMttoTipoActividad.findByNombre", query = "SELECT n FROM NovedadMttoTipoActividad n WHERE n.nombre = :nombre")
    , @NamedQuery(name = "NovedadMttoTipoActividad.findByDescripcion", query = "SELECT n FROM NovedadMttoTipoActividad n WHERE n.descripcion = :descripcion")
    , @NamedQuery(name = "NovedadMttoTipoActividad.findByCreado", query = "SELECT n FROM NovedadMttoTipoActividad n WHERE n.creado = :creado")
    , @NamedQuery(name = "NovedadMttoTipoActividad.findByModificado", query = "SELECT n FROM NovedadMttoTipoActividad n WHERE n.modificado = :modificado")
    , @NamedQuery(name = "NovedadMttoTipoActividad.findByEstadoReg", query = "SELECT n FROM NovedadMttoTipoActividad n WHERE n.estadoReg = :estadoReg")})
public class NovedadMttoTipoActividad implements Serializable {

    @OneToMany(mappedBy = "idNovedadMttoTipoActividad", fetch = FetchType.LAZY)
    private List<NovedadMttoDiaria> novedadMttoDiariaList;

    @Size(max = 15)
    @Column(name = "username")
    private String username;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_novedad_mtto_tipo_actividad")
    private Integer idNovedadMttoTipoActividad;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificado;
    @Column(name = "estado_reg")
    private Integer estadoReg;
    @OneToMany(mappedBy = "idNovedadMttoTipoActividad", fetch = FetchType.LAZY)
    private List<NovedadMttoTipoActividadDet> novedadMttoTipoActividadDetList;

    public NovedadMttoTipoActividad() {
    }

    public NovedadMttoTipoActividad(Integer idNovedadMttoTipoActividad) {
        this.idNovedadMttoTipoActividad = idNovedadMttoTipoActividad;
    }

    public NovedadMttoTipoActividad(Integer idNovedadMttoTipoActividad, Date modificado) {
        this.idNovedadMttoTipoActividad = idNovedadMttoTipoActividad;
        this.modificado = modificado;
    }

    public Integer getIdNovedadMttoTipoActividad() {
        return idNovedadMttoTipoActividad;
    }

    public void setIdNovedadMttoTipoActividad(Integer idNovedadMttoTipoActividad) {
        this.idNovedadMttoTipoActividad = idNovedadMttoTipoActividad;
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

    public Integer getEstadoReg() {
        return estadoReg;
    }

    public void setEstadoReg(Integer estadoReg) {
        this.estadoReg = estadoReg;
    }

    @XmlTransient
    public List<NovedadMttoTipoActividadDet> getNovedadMttoTipoActividadDetList() {
        return novedadMttoTipoActividadDetList;
    }

    public void setNovedadMttoTipoActividadDetList(List<NovedadMttoTipoActividadDet> novedadMttoTipoActividadDetList) {
        this.novedadMttoTipoActividadDetList = novedadMttoTipoActividadDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNovedadMttoTipoActividad != null ? idNovedadMttoTipoActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NovedadMttoTipoActividad)) {
            return false;
        }
        NovedadMttoTipoActividad other = (NovedadMttoTipoActividad) object;
        if ((this.idNovedadMttoTipoActividad == null && other.idNovedadMttoTipoActividad != null) || (this.idNovedadMttoTipoActividad != null && !this.idNovedadMttoTipoActividad.equals(other.idNovedadMttoTipoActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.NovedadMttoTipoActividad[ idNovedadMttoTipoActividad=" + idNovedadMttoTipoActividad + " ]";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlTransient
    public List<NovedadMttoDiaria> getNovedadMttoDiariaList() {
        return novedadMttoDiariaList;
    }

    public void setNovedadMttoDiariaList(List<NovedadMttoDiaria> novedadMttoDiariaList) {
        this.novedadMttoDiariaList = novedadMttoDiariaList;
    }
    
}
