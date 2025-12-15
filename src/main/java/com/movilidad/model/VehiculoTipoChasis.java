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
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "vehiculo_tipo_chasis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehiculoTipoChasis.findAll", query = "SELECT v FROM VehiculoTipoChasis v")
    , @NamedQuery(name = "VehiculoTipoChasis.findByIdVehiculoTipoChasis", query = "SELECT v FROM VehiculoTipoChasis v WHERE v.idVehiculoTipoChasis = :idVehiculoTipoChasis")
    , @NamedQuery(name = "VehiculoTipoChasis.findByNombreTipoChasis", query = "SELECT v FROM VehiculoTipoChasis v WHERE v.nombreTipoChasis = :nombreTipoChasis")
    , @NamedQuery(name = "VehiculoTipoChasis.findByDescripcionTipoChasis", query = "SELECT v FROM VehiculoTipoChasis v WHERE v.descripcionTipoChasis = :descripcionTipoChasis")
    , @NamedQuery(name = "VehiculoTipoChasis.findByUsername", query = "SELECT v FROM VehiculoTipoChasis v WHERE v.username = :username")
    , @NamedQuery(name = "VehiculoTipoChasis.findByCreado", query = "SELECT v FROM VehiculoTipoChasis v WHERE v.creado = :creado")
    , @NamedQuery(name = "VehiculoTipoChasis.findByModificado", query = "SELECT v FROM VehiculoTipoChasis v WHERE v.modificado = :modificado")
    , @NamedQuery(name = "VehiculoTipoChasis.findByEstadoReg", query = "SELECT v FROM VehiculoTipoChasis v WHERE v.estadoReg = :estadoReg")})
public class VehiculoTipoChasis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo_tipo_chasis")
    private Integer idVehiculoTipoChasis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_chasis")
    private String nombreTipoChasis;
    @Size(max = 100)
    @Column(name = "descripcion_tipo_chasis")
    private String descripcionTipoChasis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "username")
    private String username;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_reg")
    private int estadoReg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculoChasis", fetch = FetchType.LAZY)
    private List<Vehiculo> vehiculoList;

    public VehiculoTipoChasis() {
    }

    public VehiculoTipoChasis(Integer idVehiculoTipoChasis) {
        this.idVehiculoTipoChasis = idVehiculoTipoChasis;
    }

    public VehiculoTipoChasis(Integer idVehiculoTipoChasis, String nombreTipoChasis, String username, int estadoReg) {
        this.idVehiculoTipoChasis = idVehiculoTipoChasis;
        this.nombreTipoChasis = nombreTipoChasis;
        this.username = username;
        this.estadoReg = estadoReg;
    }

    public Integer getIdVehiculoTipoChasis() {
        return idVehiculoTipoChasis;
    }

    public void setIdVehiculoTipoChasis(Integer idVehiculoTipoChasis) {
        this.idVehiculoTipoChasis = idVehiculoTipoChasis;
    }

    public String getNombreTipoChasis() {
        return nombreTipoChasis;
    }

    public void setNombreTipoChasis(String nombreTipoChasis) {
        this.nombreTipoChasis = nombreTipoChasis;
    }

    public String getDescripcionTipoChasis() {
        return descripcionTipoChasis;
    }

    public void setDescripcionTipoChasis(String descripcionTipoChasis) {
        this.descripcionTipoChasis = descripcionTipoChasis;
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

    public int getEstadoReg() {
        return estadoReg;
    }

    public void setEstadoReg(int estadoReg) {
        this.estadoReg = estadoReg;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculoTipoChasis != null ? idVehiculoTipoChasis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculoTipoChasis)) {
            return false;
        }
        VehiculoTipoChasis other = (VehiculoTipoChasis) object;
        if ((this.idVehiculoTipoChasis == null && other.idVehiculoTipoChasis != null) || (this.idVehiculoTipoChasis != null && !this.idVehiculoTipoChasis.equals(other.idVehiculoTipoChasis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.VehiculoTipoChasis[ idVehiculoTipoChasis=" + idVehiculoTipoChasis + " ]";
    }
    
}
