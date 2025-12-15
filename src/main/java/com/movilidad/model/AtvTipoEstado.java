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
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author soluciones-it
 */
@Entity
@Table(name = "atv_tipo_estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtvTipoEstado.findAll", query = "SELECT a FROM AtvTipoEstado a")
    , @NamedQuery(name = "AtvTipoEstado.findByIdAtvTipoEstado", query = "SELECT a FROM AtvTipoEstado a WHERE a.idAtvTipoEstado = :idAtvTipoEstado")
    , @NamedQuery(name = "AtvTipoEstado.findByEstado", query = "SELECT a FROM AtvTipoEstado a WHERE a.estado = :estado")
    , @NamedQuery(name = "AtvTipoEstado.findByTipoEstado", query = "SELECT a FROM AtvTipoEstado a WHERE a.tipoEstado = :tipoEstado")
    , @NamedQuery(name = "AtvTipoEstado.findByDescripcion", query = "SELECT a FROM AtvTipoEstado a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "AtvTipoEstado.findByUsername", query = "SELECT a FROM AtvTipoEstado a WHERE a.username = :username")
    , @NamedQuery(name = "AtvTipoEstado.findByCreado", query = "SELECT a FROM AtvTipoEstado a WHERE a.creado = :creado")
    , @NamedQuery(name = "AtvTipoEstado.findByModificado", query = "SELECT a FROM AtvTipoEstado a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AtvTipoEstado.findByEstadoReg", query = "SELECT a FROM AtvTipoEstado a WHERE a.estadoReg = :estadoReg")
    , @NamedQuery(name = "AtvTipoEstado.findByOrden", query = "SELECT a FROM AtvTipoEstado a WHERE a.orden = :orden")})
public class AtvTipoEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_atv_tipo_estado")
    private Integer idAtvTipoEstado;
    @Column(name = "estado")
    private Integer estado;
    @Size(max = 45)
    @Column(name = "tipo_estado")
    private String tipoEstado;
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
    @Column(name = "orden")
    private Integer orden;
    @OneToMany(mappedBy = "idAtvTipoEstado", fetch = FetchType.LAZY)
    private List<AtvEvidencia> atvEvidenciaList;
    @OneToMany(mappedBy = "idAtvTipoEstado", fetch = FetchType.LAZY)
    private List<AtvLocation> atvLocationList;
    @JoinColumn(name = "id_atv_tipo_atencion", referencedColumnName = "id_atv_tipo_atencion")
    @ManyToOne(fetch = FetchType.LAZY)
    private AtvTipoAtencion idAtvTipoAtencion;

    public AtvTipoEstado() {
    }

    public AtvTipoEstado(Integer idAtvTipoEstado) {
        this.idAtvTipoEstado = idAtvTipoEstado;
    }

    public Integer getIdAtvTipoEstado() {
        return idAtvTipoEstado;
    }

    public void setIdAtvTipoEstado(Integer idAtvTipoEstado) {
        this.idAtvTipoEstado = idAtvTipoEstado;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
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

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @XmlTransient
    public List<AtvEvidencia> getAtvEvidenciaList() {
        return atvEvidenciaList;
    }

    public void setAtvEvidenciaList(List<AtvEvidencia> atvEvidenciaList) {
        this.atvEvidenciaList = atvEvidenciaList;
    }

    @XmlTransient
    public List<AtvLocation> getAtvLocationList() {
        return atvLocationList;
    }

    public void setAtvLocationList(List<AtvLocation> atvLocationList) {
        this.atvLocationList = atvLocationList;
    }

    public AtvTipoAtencion getIdAtvTipoAtencion() {
        return idAtvTipoAtencion;
    }

    public void setIdAtvTipoAtencion(AtvTipoAtencion idAtvTipoAtencion) {
        this.idAtvTipoAtencion = idAtvTipoAtencion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAtvTipoEstado != null ? idAtvTipoEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtvTipoEstado)) {
            return false;
        }
        AtvTipoEstado other = (AtvTipoEstado) object;
        if ((this.idAtvTipoEstado == null && other.idAtvTipoEstado != null) || (this.idAtvTipoEstado != null && !this.idAtvTipoEstado.equals(other.idAtvTipoEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AtvTipoEstado[ idAtvTipoEstado=" + idAtvTipoEstado + " ]";
    }
    
}
