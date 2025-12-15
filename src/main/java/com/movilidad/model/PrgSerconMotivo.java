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
 * @author HP
 */
@Entity
@Table(name = "prg_sercon_motivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgSerconMotivo.findAll", query = "SELECT p FROM PrgSerconMotivo p")
    , @NamedQuery(name = "PrgSerconMotivo.findByIdPrgSerconMotivo", query = "SELECT p FROM PrgSerconMotivo p WHERE p.idPrgSerconMotivo = :idPrgSerconMotivo")
    , @NamedQuery(name = "PrgSerconMotivo.findByDescripcion", query = "SELECT p FROM PrgSerconMotivo p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "PrgSerconMotivo.findByUsername", query = "SELECT p FROM PrgSerconMotivo p WHERE p.username = :username")
    , @NamedQuery(name = "PrgSerconMotivo.findByCreado", query = "SELECT p FROM PrgSerconMotivo p WHERE p.creado = :creado")
    , @NamedQuery(name = "PrgSerconMotivo.findByModificado", query = "SELECT p FROM PrgSerconMotivo p WHERE p.modificado = :modificado")
    , @NamedQuery(name = "PrgSerconMotivo.findByEstadoReg", query = "SELECT p FROM PrgSerconMotivo p WHERE p.estadoReg = :estadoReg")})
public class PrgSerconMotivo implements Serializable {

    @OneToMany(mappedBy = "idPrgSerconMotivo", fetch = FetchType.LAZY)
    private List<PrgDesasignarParam> prgDesasignarParamList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prg_sercon_motivo")
    private Integer idPrgSerconMotivo;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 15)
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
    @Column(name = "estado_reg")
    private Integer estadoReg;
    @OneToMany(mappedBy = "idPrgSerconMotivo", fetch = FetchType.LAZY)
    private List<PrgSercon> prgSerconList;

    public PrgSerconMotivo() {
    }

    public PrgSerconMotivo(Integer idPrgSerconMotivo) {
        this.idPrgSerconMotivo = idPrgSerconMotivo;
    }

    public PrgSerconMotivo(Integer idPrgSerconMotivo, Date creado) {
        this.idPrgSerconMotivo = idPrgSerconMotivo;
        this.creado = creado;
    }

    public Integer getIdPrgSerconMotivo() {
        return idPrgSerconMotivo;
    }

    public void setIdPrgSerconMotivo(Integer idPrgSerconMotivo) {
        this.idPrgSerconMotivo = idPrgSerconMotivo;
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
    public List<PrgSercon> getPrgSerconList() {
        return prgSerconList;
    }

    public void setPrgSerconList(List<PrgSercon> prgSerconList) {
        this.prgSerconList = prgSerconList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrgSerconMotivo != null ? idPrgSerconMotivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgSerconMotivo)) {
            return false;
        }
        PrgSerconMotivo other = (PrgSerconMotivo) object;
        if ((this.idPrgSerconMotivo == null && other.idPrgSerconMotivo != null) || (this.idPrgSerconMotivo != null && !this.idPrgSerconMotivo.equals(other.idPrgSerconMotivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.PrgSerconMotivo[ idPrgSerconMotivo=" + idPrgSerconMotivo + " ]";
    }

    @XmlTransient
    public List<PrgDesasignarParam> getPrgDesasignarParamList() {
        return prgDesasignarParamList;
    }

    public void setPrgDesasignarParamList(List<PrgDesasignarParam> prgDesasignarParamList) {
        this.prgDesasignarParamList = prgDesasignarParamList;
    }
    
}
