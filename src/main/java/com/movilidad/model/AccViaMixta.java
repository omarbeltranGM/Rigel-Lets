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
@Table(name = "acc_via_mixta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccViaMixta.findAll", query = "SELECT a FROM AccViaMixta a")
    , @NamedQuery(name = "AccViaMixta.findByIdAccViaMixta", query = "SELECT a FROM AccViaMixta a WHERE a.idAccViaMixta = :idAccViaMixta")
    , @NamedQuery(name = "AccViaMixta.findByViaMixta", query = "SELECT a FROM AccViaMixta a WHERE a.viaMixta = :viaMixta")
    , @NamedQuery(name = "AccViaMixta.findByUsername", query = "SELECT a FROM AccViaMixta a WHERE a.username = :username")
    , @NamedQuery(name = "AccViaMixta.findByCreado", query = "SELECT a FROM AccViaMixta a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccViaMixta.findByModificado", query = "SELECT a FROM AccViaMixta a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccViaMixta.findByEstadoReg", query = "SELECT a FROM AccViaMixta a WHERE a.estadoReg = :estadoReg")})
public class AccViaMixta implements Serializable {

    @OneToMany(mappedBy = "idAccViaMixta", fetch = FetchType.LAZY)
    private List<AccidenteLugar> accidenteLugarList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_via_mixta")
    private Integer idAccViaMixta;
    @Size(max = 60)
    @Column(name = "via_mixta")
    private String viaMixta;
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

    public AccViaMixta() {
    }

    public AccViaMixta(Integer idAccViaMixta) {
        this.idAccViaMixta = idAccViaMixta;
    }

    public Integer getIdAccViaMixta() {
        return idAccViaMixta;
    }

    public void setIdAccViaMixta(Integer idAccViaMixta) {
        this.idAccViaMixta = idAccViaMixta;
    }

    public String getViaMixta() {
        return viaMixta;
    }

    public void setViaMixta(String viaMixta) {
        this.viaMixta = viaMixta;
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
        hash += (idAccViaMixta != null ? idAccViaMixta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccViaMixta)) {
            return false;
        }
        AccViaMixta other = (AccViaMixta) object;
        if ((this.idAccViaMixta == null && other.idAccViaMixta != null) || (this.idAccViaMixta != null && !this.idAccViaMixta.equals(other.idAccViaMixta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccViaMixta[ idAccViaMixta=" + idAccViaMixta + " ]";
    }

    @XmlTransient
    public List<AccidenteLugar> getAccidenteLugarList() {
        return accidenteLugarList;
    }

    public void setAccidenteLugarList(List<AccidenteLugar> accidenteLugarList) {
        this.accidenteLugarList = accidenteLugarList;
    }
    
}
