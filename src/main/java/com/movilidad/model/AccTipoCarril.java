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
@Table(name = "acc_tipo_carril")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccTipoCarril.findAll", query = "SELECT a FROM AccTipoCarril a")
    , @NamedQuery(name = "AccTipoCarril.findByIdAccTipoCarril", query = "SELECT a FROM AccTipoCarril a WHERE a.idAccTipoCarril = :idAccTipoCarril")
    , @NamedQuery(name = "AccTipoCarril.findByTipoCarril", query = "SELECT a FROM AccTipoCarril a WHERE a.tipoCarril = :tipoCarril")
    , @NamedQuery(name = "AccTipoCarril.findByUsername", query = "SELECT a FROM AccTipoCarril a WHERE a.username = :username")
    , @NamedQuery(name = "AccTipoCarril.findByCreado", query = "SELECT a FROM AccTipoCarril a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccTipoCarril.findByModificado", query = "SELECT a FROM AccTipoCarril a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccTipoCarril.findByEstadoReg", query = "SELECT a FROM AccTipoCarril a WHERE a.estadoReg = :estadoReg")})
public class AccTipoCarril implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_tipo_carril")
    private Integer idAccTipoCarril;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "tipo_carril")
    private String tipoCarril;
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

    public AccTipoCarril() {
    }

    public AccTipoCarril(Integer idAccTipoCarril) {
        this.idAccTipoCarril = idAccTipoCarril;
    }

    public AccTipoCarril(Integer idAccTipoCarril, String tipoCarril) {
        this.idAccTipoCarril = idAccTipoCarril;
        this.tipoCarril = tipoCarril;
    }

    public Integer getIdAccTipoCarril() {
        return idAccTipoCarril;
    }

    public void setIdAccTipoCarril(Integer idAccTipoCarril) {
        this.idAccTipoCarril = idAccTipoCarril;
    }

    public String getTipoCarril() {
        return tipoCarril;
    }

    public void setTipoCarril(String tipoCarril) {
        this.tipoCarril = tipoCarril;
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
        hash += (idAccTipoCarril != null ? idAccTipoCarril.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccTipoCarril)) {
            return false;
        }
        AccTipoCarril other = (AccTipoCarril) object;
        if ((this.idAccTipoCarril == null && other.idAccTipoCarril != null) || (this.idAccTipoCarril != null && !this.idAccTipoCarril.equals(other.idAccTipoCarril))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccTipoCarril[ idAccTipoCarril=" + idAccTipoCarril + " ]";
    }
    
}
