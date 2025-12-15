/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.model;

import java.io.Serializable;
import java.util.Date;
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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Ballestas
 */
@Entity
@Table(name = "novedad_mtto_docs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NovedadMttoDocs.findAll", query = "SELECT n FROM NovedadMttoDocs n"),
    @NamedQuery(name = "NovedadMttoDocs.findByIdNovedadMttoDocs", query = "SELECT n FROM NovedadMttoDocs n WHERE n.idNovedadMttoDocs = :idNovedadMttoDocs"),
    @NamedQuery(name = "NovedadMttoDocs.findByPath", query = "SELECT n FROM NovedadMttoDocs n WHERE n.path = :path"),
    @NamedQuery(name = "NovedadMttoDocs.findByUsername", query = "SELECT n FROM NovedadMttoDocs n WHERE n.username = :username"),
    @NamedQuery(name = "NovedadMttoDocs.findByCreado", query = "SELECT n FROM NovedadMttoDocs n WHERE n.creado = :creado"),
    @NamedQuery(name = "NovedadMttoDocs.findByModificado", query = "SELECT n FROM NovedadMttoDocs n WHERE n.modificado = :modificado"),
    @NamedQuery(name = "NovedadMttoDocs.findByEstadoReg", query = "SELECT n FROM NovedadMttoDocs n WHERE n.estadoReg = :estadoReg")})
public class NovedadMttoDocs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_novedad_mtto_docs")
    private Integer idNovedadMttoDocs;
    @Size(max = 255)
    @Column(name = "path")
    private String path;
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
    @JoinColumn(name = "id_novedad_mtto", referencedColumnName = "id_novedad_mtto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NovedadMtto idNovedadMtto;

    public NovedadMttoDocs() {
    }

    public NovedadMttoDocs(Integer idNovedadMttoDocs) {
        this.idNovedadMttoDocs = idNovedadMttoDocs;
    }

    public Integer getIdNovedadMttoDocs() {
        return idNovedadMttoDocs;
    }

    public void setIdNovedadMttoDocs(Integer idNovedadMttoDocs) {
        this.idNovedadMttoDocs = idNovedadMttoDocs;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public NovedadMtto getIdNovedadMtto() {
        return idNovedadMtto;
    }

    public void setIdNovedadMtto(NovedadMtto idNovedadMtto) {
        this.idNovedadMtto = idNovedadMtto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNovedadMttoDocs != null ? idNovedadMttoDocs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NovedadMttoDocs)) {
            return false;
        }
        NovedadMttoDocs other = (NovedadMttoDocs) object;
        if ((this.idNovedadMttoDocs == null && other.idNovedadMttoDocs != null) || (this.idNovedadMttoDocs != null && !this.idNovedadMttoDocs.equals(other.idNovedadMttoDocs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.NovedadMttoDocs[ idNovedadMttoDocs=" + idNovedadMttoDocs + " ]";
    }
    
}
