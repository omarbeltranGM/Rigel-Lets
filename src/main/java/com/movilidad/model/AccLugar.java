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
@Table(name = "acc_lugar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccLugar.findAll", query = "SELECT a FROM AccLugar a")
    , @NamedQuery(name = "AccLugar.findByIdAccLugar", query = "SELECT a FROM AccLugar a WHERE a.idAccLugar = :idAccLugar")
    , @NamedQuery(name = "AccLugar.findByLugar", query = "SELECT a FROM AccLugar a WHERE a.lugar = :lugar")
    , @NamedQuery(name = "AccLugar.findByUsername", query = "SELECT a FROM AccLugar a WHERE a.username = :username")
    , @NamedQuery(name = "AccLugar.findByCreado", query = "SELECT a FROM AccLugar a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccLugar.findByModificado", query = "SELECT a FROM AccLugar a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccLugar.findByEstadoReg", query = "SELECT a FROM AccLugar a WHERE a.estadoReg = :estadoReg")})
public class AccLugar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_lugar")
    private Integer idAccLugar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "lugar")
    private String lugar;
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

    public AccLugar() {
    }

    public AccLugar(Integer idAccLugar) {
        this.idAccLugar = idAccLugar;
    }

    public AccLugar(Integer idAccLugar, String lugar) {
        this.idAccLugar = idAccLugar;
        this.lugar = lugar;
    }

    public Integer getIdAccLugar() {
        return idAccLugar;
    }

    public void setIdAccLugar(Integer idAccLugar) {
        this.idAccLugar = idAccLugar;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
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
        hash += (idAccLugar != null ? idAccLugar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccLugar)) {
            return false;
        }
        AccLugar other = (AccLugar) object;
        if ((this.idAccLugar == null && other.idAccLugar != null) || (this.idAccLugar != null && !this.idAccLugar.equals(other.idAccLugar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccLugar[ idAccLugar=" + idAccLugar + " ]";
    }
    
}
