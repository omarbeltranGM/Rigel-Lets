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
@Table(name = "acc_condicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccCondicion.findAll", query = "SELECT a FROM AccCondicion a")
    , @NamedQuery(name = "AccCondicion.findByIdAccCondicion", query = "SELECT a FROM AccCondicion a WHERE a.idAccCondicion = :idAccCondicion")
    , @NamedQuery(name = "AccCondicion.findByCondicion", query = "SELECT a FROM AccCondicion a WHERE a.condicion = :condicion")
    , @NamedQuery(name = "AccCondicion.findByUsername", query = "SELECT a FROM AccCondicion a WHERE a.username = :username")
    , @NamedQuery(name = "AccCondicion.findByCreado", query = "SELECT a FROM AccCondicion a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccCondicion.findByModificado", query = "SELECT a FROM AccCondicion a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccCondicion.findByEstadoReg", query = "SELECT a FROM AccCondicion a WHERE a.estadoReg = :estadoReg")})
public class AccCondicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_condicion")
    private Integer idAccCondicion;
    @Size(max = 60)
    @Column(name = "condicion")
    private String condicion;
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
    @OneToMany(mappedBy = "idAccCondicion", fetch = FetchType.LAZY)
    private List<AccidenteConductor> accidenteConductorList;
    @OneToMany(mappedBy = "idAccCondicion", fetch = FetchType.LAZY)
    private List<AccidenteVictima> accidenteVictimaList;

    public AccCondicion() {
    }

    public AccCondicion(Integer idAccCondicion) {
        this.idAccCondicion = idAccCondicion;
    }

    public Integer getIdAccCondicion() {
        return idAccCondicion;
    }

    public void setIdAccCondicion(Integer idAccCondicion) {
        this.idAccCondicion = idAccCondicion;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
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
    public List<AccidenteConductor> getAccidenteConductorList() {
        return accidenteConductorList;
    }

    public void setAccidenteConductorList(List<AccidenteConductor> accidenteConductorList) {
        this.accidenteConductorList = accidenteConductorList;
    }

    @XmlTransient
    public List<AccidenteVictima> getAccidenteVictimaList() {
        return accidenteVictimaList;
    }

    public void setAccidenteVictimaList(List<AccidenteVictima> accidenteVictimaList) {
        this.accidenteVictimaList = accidenteVictimaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccCondicion != null ? idAccCondicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccCondicion)) {
            return false;
        }
        AccCondicion other = (AccCondicion) object;
        if ((this.idAccCondicion == null && other.idAccCondicion != null) || (this.idAccCondicion != null && !this.idAccCondicion.equals(other.idAccCondicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccCondicion[ idAccCondicion=" + idAccCondicion + " ]";
    }
    
}
