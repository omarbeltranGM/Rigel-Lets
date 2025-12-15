/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jjunco
 */
@Entity
@Table(name = "gestion_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GestionVehiculo.findAll", query = "SELECT l FROM GestionVehiculo l"),
    @NamedQuery(name = "GestionVehiculo.findByIdGestionVehiculo", query = "SELECT l FROM GestionVehiculo l WHERE l.idGestionVehiculo = :idGestionVehiculo"),
    @NamedQuery(name = "GestionVehiculo.findByUsername", query = "SELECT l FROM GestionVehiculo l WHERE l.username = :username"),
    @NamedQuery(name = "GestionVehiculo.findByCreado", query = "SELECT l FROM GestionVehiculo l WHERE l.creado = :creado"),
    @NamedQuery(name = "GestionVehiculo.findByModificado", query = "SELECT l FROM GestionVehiculo l WHERE l.modificado = :modificado"),
    @NamedQuery(name = "GestionVehiculo.findByEstadoReg", query = "SELECT l FROM GestionVehiculo l WHERE l.estadoReg = :estadoReg")})
@NamedQuery(name = "GestionVehiculo.findByIdGestionVehiculoWithEstado", query = "SELECT g FROM GestionVehiculo g JOIN FETCH g.idGestionVehiculoEstado WHERE g.idGestionVehiculo = :idGestionVehiculo")

public class GestionVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gestion_vehiculo")
    private Integer idGestionVehiculo;
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne(optional = false)
    private Vehiculo idVehiculo;
    @JoinColumn(name = "id_gestion_vehiculo_tipo_estado", referencedColumnName = "id_gestion_vehiculo_tipo_estado")
    @ManyToOne(optional = false)
    private GestionVehiculoTipoEstado idGestionVehiculoEstado;
    @JoinColumn(name = "id_gestion_vehiculo_ubicacion", referencedColumnName = "id_gestion_vehiculo_ubicacion")
    @ManyToOne(optional = false)
    private GestionVehiculoUbicacion idGestionVehiculoUbicacion;
    @Column(name = "carga_inicial")
    private Long cargaInicial;
    @Column(name = "carga_final")
    private Long cargaFinal;
    @Column(name = "kilometraje")
    private Integer kilometraje;
    @Column(name = "bateria")
    private Long bateria;
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

    public GestionVehiculo() {
    }

    public Integer getIdGestionVehiculo() {
        return idGestionVehiculo;
    }

    public void setIdGestionVehiculo(Integer idGestionVehiculo) {
        this.idGestionVehiculo = idGestionVehiculo;
    }

    public Vehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculo idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public GestionVehiculoTipoEstado getIdGestionVehiculoEstado() {
        return idGestionVehiculoEstado;
    }

    public void setIdGestionVehiculoEstado(GestionVehiculoTipoEstado idGestionVehiculoEstado) {
        this.idGestionVehiculoEstado = idGestionVehiculoEstado;
    }

    public GestionVehiculoUbicacion getIdGestionVehiculoUbicacion() {
        return idGestionVehiculoUbicacion;
    }

    public void setIdGestionVehiculoUbicacion(GestionVehiculoUbicacion idGestionVehiculoUbicacion) {
        this.idGestionVehiculoUbicacion = idGestionVehiculoUbicacion;
    }

    public Long getCargaInicial() {
        return cargaInicial;
    }

    public void setCargaInicial(Long cargaInicial) {
        this.cargaInicial = cargaInicial;
    }

    public Long getCargaFinal() {
        return cargaFinal;
    }

    public void setCargaFinal(Long cargaFinal) {
        this.cargaFinal = cargaFinal;
    }

    public Integer getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Integer kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Long getBateria() {
        return bateria;
    }

    public void setBateria(Long bateria) {
        this.bateria = bateria;
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
        hash += (idGestionVehiculo != null ? idGestionVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GestionVehiculo)) {
            return false;
        }
        GestionVehiculo other = (GestionVehiculo) object;
        if ((this.idGestionVehiculo == null && other.idGestionVehiculo != null) || (this.idGestionVehiculo != null && !this.idGestionVehiculo.equals(other.idGestionVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.GestionVehiculo[ idGestionVehiculo=" + idGestionVehiculo + " ]";
    }

}
