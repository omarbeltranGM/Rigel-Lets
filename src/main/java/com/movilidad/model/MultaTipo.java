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
 * @author HP
 */
@Entity
@Table(name = "multa_tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MultaTipo.findAll", query = "SELECT m FROM MultaTipo m")
    , @NamedQuery(name = "MultaTipo.findByIdMultaTipo", query = "SELECT m FROM MultaTipo m WHERE m.idMultaTipo = :idMultaTipo")
    , @NamedQuery(name = "MultaTipo.findByTipo", query = "SELECT m FROM MultaTipo m WHERE m.tipo = :tipo")
    , @NamedQuery(name = "MultaTipo.findByUsername", query = "SELECT m FROM MultaTipo m WHERE m.username = :username")
    , @NamedQuery(name = "MultaTipo.findByCreado", query = "SELECT m FROM MultaTipo m WHERE m.creado = :creado")
    , @NamedQuery(name = "MultaTipo.findByModificado", query = "SELECT m FROM MultaTipo m WHERE m.modificado = :modificado")
    , @NamedQuery(name = "MultaTipo.findByEstadoReg", query = "SELECT m FROM MultaTipo m WHERE m.estadoReg = :estadoReg")})
public class MultaTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_multa_tipo")
    private Integer idMultaTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo")
    private String tipo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMultaTipo", fetch = FetchType.LAZY)
    private List<Multa> multaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMultaTipo", fetch = FetchType.LAZY)
    private List<MultaClasificacion> multaClasificacionList;

    public MultaTipo() {
    }

    public MultaTipo(Integer idMultaTipo) {
        this.idMultaTipo = idMultaTipo;
    }

    public MultaTipo(Integer idMultaTipo, String tipo, String username, Date creado, int estadoReg) {
        this.idMultaTipo = idMultaTipo;
        this.tipo = tipo;
        this.username = username;
        this.creado = creado;
        this.estadoReg = estadoReg;
    }

    public Integer getIdMultaTipo() {
        return idMultaTipo;
    }

    public void setIdMultaTipo(Integer idMultaTipo) {
        this.idMultaTipo = idMultaTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
    public List<Multa> getMultaList() {
        return multaList;
    }

    public void setMultaList(List<Multa> multaList) {
        this.multaList = multaList;
    }

    @XmlTransient
    public List<MultaClasificacion> getMultaClasificacionList() {
        return multaClasificacionList;
    }

    public void setMultaClasificacionList(List<MultaClasificacion> multaClasificacionList) {
        this.multaClasificacionList = multaClasificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMultaTipo != null ? idMultaTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MultaTipo)) {
            return false;
        }
        MultaTipo other = (MultaTipo) object;
        if ((this.idMultaTipo == null && other.idMultaTipo != null) || (this.idMultaTipo != null && !this.idMultaTipo.equals(other.idMultaTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.MultaTipo[ idMultaTipo=" + idMultaTipo + " ]";
    }
    
}
