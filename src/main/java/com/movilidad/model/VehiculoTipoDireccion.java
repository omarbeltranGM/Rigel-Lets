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
@Table(name = "vehiculo_tipo_direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehiculoTipoDireccion.findAll", query = "SELECT v FROM VehiculoTipoDireccion v")
    , @NamedQuery(name = "VehiculoTipoDireccion.findByIdVehiculoTipoDireccion", query = "SELECT v FROM VehiculoTipoDireccion v WHERE v.idVehiculoTipoDireccion = :idVehiculoTipoDireccion")
    , @NamedQuery(name = "VehiculoTipoDireccion.findByNombreTipoDireccion", query = "SELECT v FROM VehiculoTipoDireccion v WHERE v.nombreTipoDireccion = :nombreTipoDireccion")
    , @NamedQuery(name = "VehiculoTipoDireccion.findByDescripcionTipoDireccion", query = "SELECT v FROM VehiculoTipoDireccion v WHERE v.descripcionTipoDireccion = :descripcionTipoDireccion")
    , @NamedQuery(name = "VehiculoTipoDireccion.findByUsername", query = "SELECT v FROM VehiculoTipoDireccion v WHERE v.username = :username")
    , @NamedQuery(name = "VehiculoTipoDireccion.findByCreado", query = "SELECT v FROM VehiculoTipoDireccion v WHERE v.creado = :creado")
    , @NamedQuery(name = "VehiculoTipoDireccion.findByModificado", query = "SELECT v FROM VehiculoTipoDireccion v WHERE v.modificado = :modificado")
    , @NamedQuery(name = "VehiculoTipoDireccion.findByEstadoReg", query = "SELECT v FROM VehiculoTipoDireccion v WHERE v.estadoReg = :estadoReg")})
public class VehiculoTipoDireccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo_tipo_direccion")
    private Integer idVehiculoTipoDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_direccion")
    private String nombreTipoDireccion;
    @Size(max = 100)
    @Column(name = "descripcion_tipo_direccion")
    private String descripcionTipoDireccion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculoDireccion", fetch = FetchType.LAZY)
    private List<Vehiculo> vehiculoList;

    public VehiculoTipoDireccion() {
    }

    public VehiculoTipoDireccion(Integer idVehiculoTipoDireccion) {
        this.idVehiculoTipoDireccion = idVehiculoTipoDireccion;
    }

    public VehiculoTipoDireccion(Integer idVehiculoTipoDireccion, String nombreTipoDireccion, String username, int estadoReg) {
        this.idVehiculoTipoDireccion = idVehiculoTipoDireccion;
        this.nombreTipoDireccion = nombreTipoDireccion;
        this.username = username;
        this.estadoReg = estadoReg;
    }

    public Integer getIdVehiculoTipoDireccion() {
        return idVehiculoTipoDireccion;
    }

    public void setIdVehiculoTipoDireccion(Integer idVehiculoTipoDireccion) {
        this.idVehiculoTipoDireccion = idVehiculoTipoDireccion;
    }

    public String getNombreTipoDireccion() {
        return nombreTipoDireccion;
    }

    public void setNombreTipoDireccion(String nombreTipoDireccion) {
        this.nombreTipoDireccion = nombreTipoDireccion;
    }

    public String getDescripcionTipoDireccion() {
        return descripcionTipoDireccion;
    }

    public void setDescripcionTipoDireccion(String descripcionTipoDireccion) {
        this.descripcionTipoDireccion = descripcionTipoDireccion;
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
        hash += (idVehiculoTipoDireccion != null ? idVehiculoTipoDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculoTipoDireccion)) {
            return false;
        }
        VehiculoTipoDireccion other = (VehiculoTipoDireccion) object;
        if ((this.idVehiculoTipoDireccion == null && other.idVehiculoTipoDireccion != null) || (this.idVehiculoTipoDireccion != null && !this.idVehiculoTipoDireccion.equals(other.idVehiculoTipoDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.VehiculoTipoDireccion[ idVehiculoTipoDireccion=" + idVehiculoTipoDireccion + " ]";
    }
    
}
