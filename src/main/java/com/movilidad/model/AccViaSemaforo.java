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
@Table(name = "acc_via_semaforo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccViaSemaforo.findAll", query = "SELECT a FROM AccViaSemaforo a")
    , @NamedQuery(name = "AccViaSemaforo.findByIdAccViaSemaforo", query = "SELECT a FROM AccViaSemaforo a WHERE a.idAccViaSemaforo = :idAccViaSemaforo")
    , @NamedQuery(name = "AccViaSemaforo.findByViaSemaforo", query = "SELECT a FROM AccViaSemaforo a WHERE a.viaSemaforo = :viaSemaforo")
    , @NamedQuery(name = "AccViaSemaforo.findByUsername", query = "SELECT a FROM AccViaSemaforo a WHERE a.username = :username")
    , @NamedQuery(name = "AccViaSemaforo.findByCreado", query = "SELECT a FROM AccViaSemaforo a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccViaSemaforo.findByModificado", query = "SELECT a FROM AccViaSemaforo a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccViaSemaforo.findByEstadoReg", query = "SELECT a FROM AccViaSemaforo a WHERE a.estadoReg = :estadoReg")})
public class AccViaSemaforo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_via_semaforo")
    private Integer idAccViaSemaforo;
    @Size(max = 60)
    @Column(name = "via_semaforo")
    private String viaSemaforo;
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
    @OneToMany(mappedBy = "idAccViaSemaforo", fetch = FetchType.LAZY)
    private List<AccInformeOpe> accInformeOpeList;

    public AccViaSemaforo() {
    }

    public AccViaSemaforo(Integer idAccViaSemaforo) {
        this.idAccViaSemaforo = idAccViaSemaforo;
    }

    public Integer getIdAccViaSemaforo() {
        return idAccViaSemaforo;
    }

    public void setIdAccViaSemaforo(Integer idAccViaSemaforo) {
        this.idAccViaSemaforo = idAccViaSemaforo;
    }

    public String getViaSemaforo() {
        return viaSemaforo;
    }

    public void setViaSemaforo(String viaSemaforo) {
        this.viaSemaforo = viaSemaforo;
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
        hash += (idAccViaSemaforo != null ? idAccViaSemaforo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccViaSemaforo)) {
            return false;
        }
        AccViaSemaforo other = (AccViaSemaforo) object;
        if ((this.idAccViaSemaforo == null && other.idAccViaSemaforo != null) || (this.idAccViaSemaforo != null && !this.idAccViaSemaforo.equals(other.idAccViaSemaforo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccViaSemaforo[ idAccViaSemaforo=" + idAccViaSemaforo + " ]";
    }
    
}
