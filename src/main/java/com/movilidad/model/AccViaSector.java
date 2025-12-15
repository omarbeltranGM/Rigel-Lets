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
@Table(name = "acc_via_sector")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccViaSector.findAll", query = "SELECT a FROM AccViaSector a")
    , @NamedQuery(name = "AccViaSector.findByIdAccViaSector", query = "SELECT a FROM AccViaSector a WHERE a.idAccViaSector = :idAccViaSector")
    , @NamedQuery(name = "AccViaSector.findByViaSector", query = "SELECT a FROM AccViaSector a WHERE a.viaSector = :viaSector")
    , @NamedQuery(name = "AccViaSector.findByUsername", query = "SELECT a FROM AccViaSector a WHERE a.username = :username")
    , @NamedQuery(name = "AccViaSector.findByCreado", query = "SELECT a FROM AccViaSector a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccViaSector.findByModificado", query = "SELECT a FROM AccViaSector a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccViaSector.findByEstadoReg", query = "SELECT a FROM AccViaSector a WHERE a.estadoReg = :estadoReg")})
public class AccViaSector implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_via_sector")
    private Integer idAccViaSector;
    @Size(max = 60)
    @Column(name = "via_sector")
    private String viaSector;
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
    @OneToMany(mappedBy = "idAccViaSector", fetch = FetchType.LAZY)
    private List<AccInformeOpe> accInformeOpeList;

    public AccViaSector() {
    }

    public AccViaSector(Integer idAccViaSector) {
        this.idAccViaSector = idAccViaSector;
    }

    public Integer getIdAccViaSector() {
        return idAccViaSector;
    }

    public void setIdAccViaSector(Integer idAccViaSector) {
        this.idAccViaSector = idAccViaSector;
    }

    public String getViaSector() {
        return viaSector;
    }

    public void setViaSector(String viaSector) {
        this.viaSector = viaSector;
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
    public List<AccInformeOpe> getAccInformeOpeList() {
        return accInformeOpeList;
    }

    public void setAccInformeOpeList(List<AccInformeOpe> accInformeOpeList) {
        this.accInformeOpeList = accInformeOpeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccViaSector != null ? idAccViaSector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccViaSector)) {
            return false;
        }
        AccViaSector other = (AccViaSector) object;
        if ((this.idAccViaSector == null && other.idAccViaSector != null) || (this.idAccViaSector != null && !this.idAccViaSector.equals(other.idAccViaSector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccViaSector[ idAccViaSector=" + idAccViaSector + " ]";
    }
    
}
