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
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "acc_via_clase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccViaClase.findAll", query = "SELECT a FROM AccViaClase a")
    , @NamedQuery(name = "AccViaClase.findByIdAccViaClase", query = "SELECT a FROM AccViaClase a WHERE a.idAccViaClase = :idAccViaClase")
    , @NamedQuery(name = "AccViaClase.findByViaClase", query = "SELECT a FROM AccViaClase a WHERE a.viaClase = :viaClase")
    , @NamedQuery(name = "AccViaClase.findByUsername", query = "SELECT a FROM AccViaClase a WHERE a.username = :username")
    , @NamedQuery(name = "AccViaClase.findByCreado", query = "SELECT a FROM AccViaClase a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccViaClase.findByModificado", query = "SELECT a FROM AccViaClase a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccViaClase.findByEstadoReg", query = "SELECT a FROM AccViaClase a WHERE a.estadoReg = :estadoReg")})
public class AccViaClase implements Serializable {

    @OneToMany(mappedBy = "idAccViaClase", fetch = FetchType.LAZY)
    private List<AccidenteLugar> accidenteLugarList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_via_clase")
    private Integer idAccViaClase;
    @Size(max = 60)
    @Column(name = "via_clase")
    private String viaClase;
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

    public AccViaClase() {
    }

    public AccViaClase(Integer idAccViaClase) {
        this.idAccViaClase = idAccViaClase;
    }

    public Integer getIdAccViaClase() {
        return idAccViaClase;
    }

    public void setIdAccViaClase(Integer idAccViaClase) {
        this.idAccViaClase = idAccViaClase;
    }

    public String getViaClase() {
        return viaClase;
    }

    public void setViaClase(String viaClase) {
        this.viaClase = viaClase;
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
        hash += (idAccViaClase != null ? idAccViaClase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccViaClase)) {
            return false;
        }
        AccViaClase other = (AccViaClase) object;
        if ((this.idAccViaClase == null && other.idAccViaClase != null) || (this.idAccViaClase != null && !this.idAccViaClase.equals(other.idAccViaClase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccViaClase[ idAccViaClase=" + idAccViaClase + " ]";
    }

    @XmlTransient
    public List<AccidenteLugar> getAccidenteLugarList() {
        return accidenteLugarList;
    }

    public void setAccidenteLugarList(List<AccidenteLugar> accidenteLugarList) {
        this.accidenteLugarList = accidenteLugarList;
    }
    
}
