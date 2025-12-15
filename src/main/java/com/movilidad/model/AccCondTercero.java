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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "acc_cond_tercero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccCondTercero.findAll", query = "SELECT a FROM AccCondTercero a")
    , @NamedQuery(name = "AccCondTercero.findByIdAccCondTercero", query = "SELECT a FROM AccCondTercero a WHERE a.idAccCondTercero = :idAccCondTercero")
    , @NamedQuery(name = "AccCondTercero.findByCondTercero", query = "SELECT a FROM AccCondTercero a WHERE a.condTercero = :condTercero")
    , @NamedQuery(name = "AccCondTercero.findByUsername", query = "SELECT a FROM AccCondTercero a WHERE a.username = :username")
    , @NamedQuery(name = "AccCondTercero.findByCreado", query = "SELECT a FROM AccCondTercero a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccCondTercero.findByModificado", query = "SELECT a FROM AccCondTercero a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccCondTercero.findByEstadoReg", query = "SELECT a FROM AccCondTercero a WHERE a.estadoReg = :estadoReg")})
public class AccCondTercero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_cond_tercero")
    private Integer idAccCondTercero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "cond_tercero")
    private String condTercero;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 15)
    @Column(name = "username")
    private String username;
    @Column(name = "creado")
    @Temporal(TemporalType.DATE)
    private Date creado;
    @Column(name = "modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificado;
    @Column(name = "estado_reg")
    private Integer estadoReg;

    public AccCondTercero() {
    }

    public AccCondTercero(Integer idAccCondTercero) {
        this.idAccCondTercero = idAccCondTercero;
    }

    public AccCondTercero(Integer idAccCondTercero, String condTercero) {
        this.idAccCondTercero = idAccCondTercero;
        this.condTercero = condTercero;
    }

    public Integer getIdAccCondTercero() {
        return idAccCondTercero;
    }

    public void setIdAccCondTercero(Integer idAccCondTercero) {
        this.idAccCondTercero = idAccCondTercero;
    }

    public String getCondTercero() {
        return condTercero;
    }

    public void setCondTercero(String condTercero) {
        this.condTercero = condTercero;
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
        hash += (idAccCondTercero != null ? idAccCondTercero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccCondTercero)) {
            return false;
        }
        AccCondTercero other = (AccCondTercero) object;
        if ((this.idAccCondTercero == null && other.idAccCondTercero != null) || (this.idAccCondTercero != null && !this.idAccCondTercero.equals(other.idAccCondTercero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccCondTercero[ idAccCondTercero=" + idAccCondTercero + " ]";
    }
    
}
