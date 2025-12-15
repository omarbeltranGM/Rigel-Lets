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
@Table(name = "acc_tipo_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccTipoVehiculo.findAll", query = "SELECT a FROM AccTipoVehiculo a")
    , @NamedQuery(name = "AccTipoVehiculo.findByIdAccTipoVehiculo", query = "SELECT a FROM AccTipoVehiculo a WHERE a.idAccTipoVehiculo = :idAccTipoVehiculo")
    , @NamedQuery(name = "AccTipoVehiculo.findByTipoVehiculo", query = "SELECT a FROM AccTipoVehiculo a WHERE a.tipoVehiculo = :tipoVehiculo")
    , @NamedQuery(name = "AccTipoVehiculo.findByUsername", query = "SELECT a FROM AccTipoVehiculo a WHERE a.username = :username")
    , @NamedQuery(name = "AccTipoVehiculo.findByCreado", query = "SELECT a FROM AccTipoVehiculo a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccTipoVehiculo.findByModificado", query = "SELECT a FROM AccTipoVehiculo a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccTipoVehiculo.findByEstadoReg", query = "SELECT a FROM AccTipoVehiculo a WHERE a.estadoReg = :estadoReg")})
public class AccTipoVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_tipo_vehiculo")
    private Integer idAccTipoVehiculo;
    @Size(max = 60)
    @Column(name = "tipo_vehiculo")
    private String tipoVehiculo;
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
    @OneToMany(mappedBy = "idAccTipoVehiculo", fetch = FetchType.LAZY)
    private List<AccInformeVehCond> accInformeVehCondList;
    @OneToMany(mappedBy = "idAccTipoVehiculo", fetch = FetchType.LAZY)
    private List<AccChoqueInforme> accChoqueInformeList;

    public AccTipoVehiculo() {
    }

    public AccTipoVehiculo(Integer idAccTipoVehiculo) {
        this.idAccTipoVehiculo = idAccTipoVehiculo;
    }

    public Integer getIdAccTipoVehiculo() {
        return idAccTipoVehiculo;
    }

    public void setIdAccTipoVehiculo(Integer idAccTipoVehiculo) {
        this.idAccTipoVehiculo = idAccTipoVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
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
    public List<AccInformeVehCond> getAccInformeVehCondList() {
        return accInformeVehCondList;
    }

    public void setAccInformeVehCondList(List<AccInformeVehCond> accInformeVehCondList) {
        this.accInformeVehCondList = accInformeVehCondList;
    }

    @XmlTransient
    public List<AccChoqueInforme> getAccChoqueInformeList() {
        return accChoqueInformeList;
    }

    public void setAccChoqueInformeList(List<AccChoqueInforme> accChoqueInformeList) {
        this.accChoqueInformeList = accChoqueInformeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccTipoVehiculo != null ? idAccTipoVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccTipoVehiculo)) {
            return false;
        }
        AccTipoVehiculo other = (AccTipoVehiculo) object;
        if ((this.idAccTipoVehiculo == null && other.idAccTipoVehiculo != null) || (this.idAccTipoVehiculo != null && !this.idAccTipoVehiculo.equals(other.idAccTipoVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccTipoVehiculo[ idAccTipoVehiculo=" + idAccTipoVehiculo + " ]";
    }
    
}
