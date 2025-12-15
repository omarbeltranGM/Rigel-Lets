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
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "acc_tipo_conc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccTipoConc.findAll", query = "SELECT a FROM AccTipoConc a")
    , @NamedQuery(name = "AccTipoConc.findByIdAccTipoConc", query = "SELECT a FROM AccTipoConc a WHERE a.idAccTipoConc = :idAccTipoConc")
    , @NamedQuery(name = "AccTipoConc.findByTipoConc", query = "SELECT a FROM AccTipoConc a WHERE a.tipoConc = :tipoConc")
    , @NamedQuery(name = "AccTipoConc.findByUsername", query = "SELECT a FROM AccTipoConc a WHERE a.username = :username")
    , @NamedQuery(name = "AccTipoConc.findByCreado", query = "SELECT a FROM AccTipoConc a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccTipoConc.findByModificado", query = "SELECT a FROM AccTipoConc a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccTipoConc.findByEstadoReg", query = "SELECT a FROM AccTipoConc a WHERE a.estadoReg = :estadoReg")})
public class AccTipoConc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_tipo_conc")
    private Integer idAccTipoConc;
    @Size(max = 60)
    @Column(name = "tipo_conc")
    private String tipoConc;
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

    public AccTipoConc() {
    }

    public AccTipoConc(Integer idAccTipoConc) {
        this.idAccTipoConc = idAccTipoConc;
    }

    public Integer getIdAccTipoConc() {
        return idAccTipoConc;
    }

    public void setIdAccTipoConc(Integer idAccTipoConc) {
        this.idAccTipoConc = idAccTipoConc;
    }

    public String getTipoConc() {
        return tipoConc;
    }

    public void setTipoConc(String tipoConc) {
        this.tipoConc = tipoConc;
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
        hash += (idAccTipoConc != null ? idAccTipoConc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccTipoConc)) {
            return false;
        }
        AccTipoConc other = (AccTipoConc) object;
        if ((this.idAccTipoConc == null && other.idAccTipoConc != null) || (this.idAccTipoConc != null && !this.idAccTipoConc.equals(other.idAccTipoConc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccTipoConc[ idAccTipoConc=" + idAccTipoConc + " ]";
    }
    
}
