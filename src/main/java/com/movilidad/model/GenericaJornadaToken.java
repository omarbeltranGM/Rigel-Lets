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
 * @author solucionesit
 */
@Entity
@Table(name = "generica_jornada_token")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenericaJornadaToken.findAll", query = "SELECT g FROM GenericaJornadaToken g"),
    @NamedQuery(name = "GenericaJornadaToken.findByIdGenericaJornadaToken", query = "SELECT g FROM GenericaJornadaToken g WHERE g.idGenericaJornadaToken = :idGenericaJornadaToken"),
    @NamedQuery(name = "GenericaJornadaToken.findByToken", query = "SELECT g FROM GenericaJornadaToken g WHERE g.token = :token"),
    @NamedQuery(name = "GenericaJornadaToken.findByActivo", query = "SELECT g FROM GenericaJornadaToken g WHERE g.activo = :activo"),
    @NamedQuery(name = "GenericaJornadaToken.findByUsername", query = "SELECT g FROM GenericaJornadaToken g WHERE g.username = :username"),
    @NamedQuery(name = "GenericaJornadaToken.findByCreado", query = "SELECT g FROM GenericaJornadaToken g WHERE g.creado = :creado"),
    @NamedQuery(name = "GenericaJornadaToken.findByModificado", query = "SELECT g FROM GenericaJornadaToken g WHERE g.modificado = :modificado"),
    @NamedQuery(name = "GenericaJornadaToken.findByEstadoReg", query = "SELECT g FROM GenericaJornadaToken g WHERE g.estadoReg = :estadoReg")})
public class GenericaJornadaToken implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_generica_jornada_token")
    private Integer idGenericaJornadaToken;
    @Size(max = 6)
    @Column(name = "token")
    private String token;
    @Column(name = "activo")
    private Integer activo;
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
    @JoinColumn(name = "id_generica_jornada", referencedColumnName = "id_generica_jornada")
    @ManyToOne(fetch = FetchType.LAZY)
    private GenericaJornada idGenericaJornada;

    public GenericaJornadaToken() {
    }

    public GenericaJornadaToken(Integer idGenericaJornadaToken) {
        this.idGenericaJornadaToken = idGenericaJornadaToken;
    }

    public Integer getIdGenericaJornadaToken() {
        return idGenericaJornadaToken;
    }

    public void setIdGenericaJornadaToken(Integer idGenericaJornadaToken) {
        this.idGenericaJornadaToken = idGenericaJornadaToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
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

    public GenericaJornada getIdGenericaJornada() {
        return idGenericaJornada;
    }

    public void setIdGenericaJornada(GenericaJornada idGenericaJornada) {
        this.idGenericaJornada = idGenericaJornada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGenericaJornadaToken != null ? idGenericaJornadaToken.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenericaJornadaToken)) {
            return false;
        }
        GenericaJornadaToken other = (GenericaJornadaToken) object;
        if ((this.idGenericaJornadaToken == null && other.idGenericaJornadaToken != null) || (this.idGenericaJornadaToken != null && !this.idGenericaJornadaToken.equals(other.idGenericaJornadaToken))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.GenericaJornadaToken[ idGenericaJornadaToken=" + idGenericaJornadaToken + " ]";
    }
    
}
