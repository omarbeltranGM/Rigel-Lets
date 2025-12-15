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
@Table(name = "vehiculo_tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehiculoTipo.findAll", query = "SELECT v FROM VehiculoTipo v"),
    @NamedQuery(name = "VehiculoTipo.findByIdVehiculoTipo", query = "SELECT v FROM VehiculoTipo v WHERE v.idVehiculoTipo = :idVehiculoTipo"),
    @NamedQuery(name = "VehiculoTipo.findByNombreTipoVehiculo", query = "SELECT v FROM VehiculoTipo v WHERE v.nombreTipoVehiculo = :nombreTipoVehiculo"),
    @NamedQuery(name = "VehiculoTipo.findByDescripcionTipoVehiculo", query = "SELECT v FROM VehiculoTipo v WHERE v.descripcionTipoVehiculo = :descripcionTipoVehiculo"),
    @NamedQuery(name = "VehiculoTipo.findByUsername", query = "SELECT v FROM VehiculoTipo v WHERE v.username = :username"),
    @NamedQuery(name = "VehiculoTipo.findByCreado", query = "SELECT v FROM VehiculoTipo v WHERE v.creado = :creado"),
    @NamedQuery(name = "VehiculoTipo.findByModificado", query = "SELECT v FROM VehiculoTipo v WHERE v.modificado = :modificado"),
    @NamedQuery(name = "VehiculoTipo.findByEstadoReg", query = "SELECT v FROM VehiculoTipo v WHERE v.estadoReg = :estadoReg")})
public class VehiculoTipo implements Serializable {

    @OneToMany(mappedBy = "idVehiculoTipo", fetch = FetchType.LAZY)
    private List<PrgTcResumenVrConciliados> prgTcResumenVrConciliadosList;

    @OneToMany(mappedBy = "idVehiculoTipo", fetch = FetchType.LAZY)
    private List<MttoBateriaCritica> mttoBateriaCriticaList;
    @OneToMany(mappedBy = "idVehiculoTipo", fetch = FetchType.LAZY)
    private List<MttoElementosAbordo> mttoElementosAbordoList;
    @OneToMany(mappedBy = "idVehiculoTipo", fetch = FetchType.LAZY)
    private List<AuditoriaCosto> auditoriaCostoList;
    @OneToMany(mappedBy = "idVehiculoTipo", fetch = FetchType.LAZY)
    private List<AuditoriaLugar> auditoriaLugarList;

    @OneToMany(mappedBy = "idVehiculoTipo", fetch = FetchType.LAZY)
    private List<AtvCostoServicio> atvCostoServicioList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo_tipo")
    private Integer idVehiculoTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_vehiculo")
    private String nombreTipoVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion_tipo_vehiculo")
    private String descripcionTipoVehiculo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculoTipo", fetch = FetchType.LAZY)
    private List<PmVrbonoTipovehi> pmVrbonoTipovehiList;
    @OneToMany(mappedBy = "idVehiculoTipo", fetch = FetchType.LAZY)
    private List<PrgTc> prgTcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculoTipo", fetch = FetchType.LAZY)
    private List<Vehiculo> vehiculoList;
    @OneToMany(mappedBy = "idVehiculoTipo", fetch = FetchType.LAZY)
    private List<PrgVehicleStatus> prgVehicleStatusList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculoTipo", fetch = FetchType.LAZY)
    private List<LavadoTipoServicio> lavadoTipoServicioList;

    public VehiculoTipo() {
    }

    public VehiculoTipo(Integer idVehiculoTipo) {
        this.idVehiculoTipo = idVehiculoTipo;
    }

    public VehiculoTipo(Integer idVehiculoTipo, String nombreTipoVehiculo, String descripcionTipoVehiculo, String username, Date creado, int estadoReg) {
        this.idVehiculoTipo = idVehiculoTipo;
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.descripcionTipoVehiculo = descripcionTipoVehiculo;
        this.username = username;
        this.creado = creado;
        this.estadoReg = estadoReg;
    }

    public Integer getIdVehiculoTipo() {
        return idVehiculoTipo;
    }

    public void setIdVehiculoTipo(Integer idVehiculoTipo) {
        this.idVehiculoTipo = idVehiculoTipo;
    }

    public String getNombreTipoVehiculo() {
        return nombreTipoVehiculo;
    }

    public void setNombreTipoVehiculo(String nombreTipoVehiculo) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
    }

    public String getDescripcionTipoVehiculo() {
        return descripcionTipoVehiculo;
    }

    public void setDescripcionTipoVehiculo(String descripcionTipoVehiculo) {
        this.descripcionTipoVehiculo = descripcionTipoVehiculo;
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
    public List<PmVrbonoTipovehi> getPmVrbonoTipovehiList() {
        return pmVrbonoTipovehiList;
    }

    public void setPmVrbonoTipovehiList(List<PmVrbonoTipovehi> pmVrbonoTipovehiList) {
        this.pmVrbonoTipovehiList = pmVrbonoTipovehiList;
    }

    @XmlTransient
    public List<PrgTc> getPrgTcList() {
        return prgTcList;
    }

    public void setPrgTcList(List<PrgTc> prgTcList) {
        this.prgTcList = prgTcList;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @XmlTransient
    public List<PrgVehicleStatus> getPrgVehicleStatusList() {
        return prgVehicleStatusList;
    }

    public void setPrgVehicleStatusList(List<PrgVehicleStatus> prgVehicleStatusList) {
        this.prgVehicleStatusList = prgVehicleStatusList;
    }

    @XmlTransient
    public List<AuditoriaLugar> getAuditoriaLugarList() {
        return auditoriaLugarList;
    }

    public void setAuditoriaLugarList(List<AuditoriaLugar> auditoriaLugarList) {
        this.auditoriaLugarList = auditoriaLugarList;
    }

    @XmlTransient
    public List<LavadoTipoServicio> getLavadoTipoServicioList() {
        return lavadoTipoServicioList;
    }

    public void setLavadoTipoServicioList(List<LavadoTipoServicio> lavadoTipoServicioList) {
        this.lavadoTipoServicioList = lavadoTipoServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculoTipo != null ? idVehiculoTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculoTipo)) {
            return false;
        }
        VehiculoTipo other = (VehiculoTipo) object;
        if ((this.idVehiculoTipo == null && other.idVehiculoTipo != null) || (this.idVehiculoTipo != null && !this.idVehiculoTipo.equals(other.idVehiculoTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.VehiculoTipo[ idVehiculoTipo=" + idVehiculoTipo + " ]";
    }

    @XmlTransient
    public List<MttoBateriaCritica> getMttoBateriaCriticaList() {
        return mttoBateriaCriticaList;
    }

    public void setMttoBateriaCriticaList(List<MttoBateriaCritica> mttoBateriaCriticaList) {
        this.mttoBateriaCriticaList = mttoBateriaCriticaList;
    }

    @XmlTransient
    public List<MttoElementosAbordo> getMttoElementosAbordoList() {
        return mttoElementosAbordoList;
    }

    public void setMttoElementosAbordoList(List<MttoElementosAbordo> mttoElementosAbordoList) {
        this.mttoElementosAbordoList = mttoElementosAbordoList;
    }

    @XmlTransient
    public List<AtvCostoServicio> getAtvCostoServicioList() {
        return atvCostoServicioList;
    }

    public void setAtvCostoServicioList(List<AtvCostoServicio> atvCostoServicioList) {
        this.atvCostoServicioList = atvCostoServicioList;
    }

    @XmlTransient
    public List<AuditoriaCosto> getAuditoriaCostoList() {
        return auditoriaCostoList;
    }

    public void setAuditoriaCostoList(List<AuditoriaCosto> auditoriaCostoList) {
        this.auditoriaCostoList = auditoriaCostoList;
    }

    @XmlTransient
    public List<PrgTcResumenVrConciliados> getPrgTcResumenVrConciliadosList() {
        return prgTcResumenVrConciliadosList;
    }

    public void setPrgTcResumenVrConciliadosList(List<PrgTcResumenVrConciliados> prgTcResumenVrConciliadosList) {
        this.prgTcResumenVrConciliadosList = prgTcResumenVrConciliadosList;
    }

}
