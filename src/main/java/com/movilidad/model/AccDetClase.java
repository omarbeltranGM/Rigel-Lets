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
@Table(name = "acc_det_clase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccDetClase.findAll", query = "SELECT a FROM AccDetClase a")
    , @NamedQuery(name = "AccDetClase.findByIdAccDetClase", query = "SELECT a FROM AccDetClase a WHERE a.idAccDetClase = :idAccDetClase")
    , @NamedQuery(name = "AccDetClase.findByDetClase", query = "SELECT a FROM AccDetClase a WHERE a.detClase = :detClase")
    , @NamedQuery(name = "AccDetClase.findByUsername", query = "SELECT a FROM AccDetClase a WHERE a.username = :username")
    , @NamedQuery(name = "AccDetClase.findByCreado", query = "SELECT a FROM AccDetClase a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccDetClase.findByModificado", query = "SELECT a FROM AccDetClase a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccDetClase.findByEstadoReg", query = "SELECT a FROM AccDetClase a WHERE a.estadoReg = :estadoReg")})
public class AccDetClase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_det_clase")
    private Integer idAccDetClase;
    @Size(max = 60)
    @Column(name = "det_clase")
    private String detClase;
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
    @OneToMany(mappedBy = "idAccDetClase", fetch = FetchType.LAZY)
    private List<Accidente> accidenteList;

    public AccDetClase() {
    }

    public AccDetClase(Integer idAccDetClase) {
        this.idAccDetClase = idAccDetClase;
    }

    public Integer getIdAccDetClase() {
        return idAccDetClase;
    }

    public void setIdAccDetClase(Integer idAccDetClase) {
        this.idAccDetClase = idAccDetClase;
    }

    public String getDetClase() {
        return detClase;
    }

    public void setDetClase(String detClase) {
        this.detClase = detClase;
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
    public List<Accidente> getAccidenteList() {
        return accidenteList;
    }

    public void setAccidenteList(List<Accidente> accidenteList) {
        this.accidenteList = accidenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccDetClase != null ? idAccDetClase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccDetClase)) {
            return false;
        }
        AccDetClase other = (AccDetClase) object;
        if ((this.idAccDetClase == null && other.idAccDetClase != null) || (this.idAccDetClase != null && !this.idAccDetClase.equals(other.idAccDetClase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccDetClase[ idAccDetClase=" + idAccDetClase + " ]";
    }
    
}
