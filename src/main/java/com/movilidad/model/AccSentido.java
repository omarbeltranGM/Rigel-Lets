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
import jakarta.persistence.Lob;
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
@Table(name = "acc_sentido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccSentido.findAll", query = "SELECT a FROM AccSentido a")
    , @NamedQuery(name = "AccSentido.findByIdAccSentido", query = "SELECT a FROM AccSentido a WHERE a.idAccSentido = :idAccSentido")
    , @NamedQuery(name = "AccSentido.findBySentido", query = "SELECT a FROM AccSentido a WHERE a.sentido = :sentido")
    , @NamedQuery(name = "AccSentido.findByUsername", query = "SELECT a FROM AccSentido a WHERE a.username = :username")
    , @NamedQuery(name = "AccSentido.findByCreado", query = "SELECT a FROM AccSentido a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccSentido.findByModificado", query = "SELECT a FROM AccSentido a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccSentido.findByEstadoReg", query = "SELECT a FROM AccSentido a WHERE a.estadoReg = :estadoReg")})
public class AccSentido implements Serializable {

    @OneToMany(mappedBy = "idAccSentido", fetch = FetchType.LAZY)
    private List<AccidenteLugar> accidenteLugarList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_sentido")
    private Integer idAccSentido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "sentido")
    private String sentido;
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

    public AccSentido() {
    }

    public AccSentido(Integer idAccSentido) {
        this.idAccSentido = idAccSentido;
    }

    public AccSentido(Integer idAccSentido, String sentido) {
        this.idAccSentido = idAccSentido;
        this.sentido = sentido;
    }

    public Integer getIdAccSentido() {
        return idAccSentido;
    }

    public void setIdAccSentido(Integer idAccSentido) {
        this.idAccSentido = idAccSentido;
    }

    public String getSentido() {
        return sentido;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
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
        hash += (idAccSentido != null ? idAccSentido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccSentido)) {
            return false;
        }
        AccSentido other = (AccSentido) object;
        if ((this.idAccSentido == null && other.idAccSentido != null) || (this.idAccSentido != null && !this.idAccSentido.equals(other.idAccSentido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccSentido[ idAccSentido=" + idAccSentido + " ]";
    }

    @XmlTransient
    public List<AccidenteLugar> getAccidenteLugarList() {
        return accidenteLugarList;
    }

    public void setAccidenteLugarList(List<AccidenteLugar> accidenteLugarList) {
        this.accidenteLugarList = accidenteLugarList;
    }
    
}
