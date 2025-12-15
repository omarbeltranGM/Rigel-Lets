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
import jakarta.persistence.FetchType;
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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author solucionesit
 */
@Entity
@Table(name = "vehiculo_estado_historico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehiculoEstadoHistorico.findAll", query = "SELECT v FROM VehiculoEstadoHistorico v")
    , @NamedQuery(name = "VehiculoEstadoHistorico.findByIdVehiculoEstadoHistorico", query = "SELECT v FROM VehiculoEstadoHistorico v WHERE v.idVehiculoEstadoHistorico = :idVehiculoEstadoHistorico")
    , @NamedQuery(name = "VehiculoEstadoHistorico.findByFechaHora", query = "SELECT v FROM VehiculoEstadoHistorico v WHERE v.fechaHora = :fechaHora")
    , @NamedQuery(name = "VehiculoEstadoHistorico.findByUsuarioReporta", query = "SELECT v FROM VehiculoEstadoHistorico v WHERE v.usuarioReporta = :usuarioReporta")
    , @NamedQuery(name = "VehiculoEstadoHistorico.findByUsername", query = "SELECT v FROM VehiculoEstadoHistorico v WHERE v.username = :username")
    , @NamedQuery(name = "VehiculoEstadoHistorico.findByCreado", query = "SELECT v FROM VehiculoEstadoHistorico v WHERE v.creado = :creado")
    , @NamedQuery(name = "VehiculoEstadoHistorico.findByModificado", query = "SELECT v FROM VehiculoEstadoHistorico v WHERE v.modificado = :modificado")
    , @NamedQuery(name = "VehiculoEstadoHistorico.findByEstadoReg", query = "SELECT v FROM VehiculoEstadoHistorico v WHERE v.estadoReg = :estadoReg")})
public class VehiculoEstadoHistorico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo_estado_historico")
    private Integer idVehiculoEstadoHistorico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "usuario_reporta")
    private String usuarioReporta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
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
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vehiculo idVehiculo;
    @JoinColumn(name = "id_disp_actividad", referencedColumnName = "id_disp_actividad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DispActividad idDispActividad;
    @JoinColumn(name = "id_vehiculo_tipo_estado_det", referencedColumnName = "id_vehiculo_tipo_estado_det")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private VehiculoTipoEstadoDet idVehiculoTipoEstadoDet;
    @JoinColumn(name = "id_disp_estado_pend_actual", referencedColumnName = "id_disp_estado_pend_actual")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DispEstadoPendActual idDispEstadoPendActual;
    @JoinColumn(name = "id_vehiculo_tipo_estado", referencedColumnName = "id_vehiculo_tipo_estado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private VehiculoTipoEstado idVehiculoTipoEstado;

    public VehiculoEstadoHistorico() {
    }

    public VehiculoEstadoHistorico(Integer idVehiculoEstadoHistorico) {
        this.idVehiculoEstadoHistorico = idVehiculoEstadoHistorico;
    }

    public VehiculoEstadoHistorico(Integer idVehiculoEstadoHistorico, Date fechaHora, String usuarioReporta, String username, Date creado, int estadoReg) {
        this.idVehiculoEstadoHistorico = idVehiculoEstadoHistorico;
        this.fechaHora = fechaHora;
        this.usuarioReporta = usuarioReporta;
        this.username = username;
        this.creado = creado;
        this.estadoReg = estadoReg;
    }

    public Integer getIdVehiculoEstadoHistorico() {
        return idVehiculoEstadoHistorico;
    }

    public void setIdVehiculoEstadoHistorico(Integer idVehiculoEstadoHistorico) {
        this.idVehiculoEstadoHistorico = idVehiculoEstadoHistorico;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getUsuarioReporta() {
        return usuarioReporta;
    }

    public void setUsuarioReporta(String usuarioReporta) {
        this.usuarioReporta = usuarioReporta;
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

    public Vehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculo idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public DispActividad getIdDispActividad() {
        return idDispActividad;
    }

    public void setIdDispActividad(DispActividad idDispActividad) {
        this.idDispActividad = idDispActividad;
    }

    public VehiculoTipoEstadoDet getIdVehiculoTipoEstadoDet() {
        return idVehiculoTipoEstadoDet;
    }

    public void setIdVehiculoTipoEstadoDet(VehiculoTipoEstadoDet idVehiculoTipoEstadoDet) {
        this.idVehiculoTipoEstadoDet = idVehiculoTipoEstadoDet;
    }

    public DispEstadoPendActual getIdDispEstadoPendActual() {
        return idDispEstadoPendActual;
    }

    public void setIdDispEstadoPendActual(DispEstadoPendActual idDispEstadoPendActual) {
        this.idDispEstadoPendActual = idDispEstadoPendActual;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public VehiculoTipoEstado getIdVehiculoTipoEstado() {
        return idVehiculoTipoEstado;
    }

    public void setIdVehiculoTipoEstado(VehiculoTipoEstado idVehiculoTipoEstado) {
        this.idVehiculoTipoEstado = idVehiculoTipoEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculoEstadoHistorico != null ? idVehiculoEstadoHistorico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculoEstadoHistorico)) {
            return false;
        }
        VehiculoEstadoHistorico other = (VehiculoEstadoHistorico) object;
        if ((this.idVehiculoEstadoHistorico == null && other.idVehiculoEstadoHistorico != null) || (this.idVehiculoEstadoHistorico != null && !this.idVehiculoEstadoHistorico.equals(other.idVehiculoEstadoHistorico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.VehiculoEstadoHistorico[ idVehiculoEstadoHistorico=" + idVehiculoEstadoHistorico + " ]";
    }

}
