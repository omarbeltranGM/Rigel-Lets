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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
 * @author Carlos Ballestas
 */
@Entity
@Table(name = "vehiculo_tipo_estado_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehiculoTipoEstadoDet.findAll", query = "SELECT v FROM VehiculoTipoEstadoDet v")
    ,
    @NamedQuery(name = "VehiculoTipoEstadoDet.findByIdVehiculoTipoEstadoDet", query = "SELECT v FROM VehiculoTipoEstadoDet v WHERE v.idVehiculoTipoEstadoDet = :idVehiculoTipoEstadoDet")
    ,
    @NamedQuery(name = "VehiculoTipoEstadoDet.findByNombre", query = "SELECT v FROM VehiculoTipoEstadoDet v WHERE v.nombre = :nombre")
    ,
    @NamedQuery(name = "VehiculoTipoEstadoDet.findByUsername", query = "SELECT v FROM VehiculoTipoEstadoDet v WHERE v.username = :username")
    ,
    @NamedQuery(name = "VehiculoTipoEstadoDet.findByCreado", query = "SELECT v FROM VehiculoTipoEstadoDet v WHERE v.creado = :creado")
    ,
    @NamedQuery(name = "VehiculoTipoEstadoDet.findByModificado", query = "SELECT v FROM VehiculoTipoEstadoDet v WHERE v.modificado = :modificado")
    ,
    @NamedQuery(name = "VehiculoTipoEstadoDet.findByEstadoReg", query = "SELECT v FROM VehiculoTipoEstadoDet v WHERE v.estadoReg = :estadoReg")
    ,
    @NamedQuery(name = "VehiculoTipoEstadoDet.findByIdVehiculoTipoEstado", query = "SELECT v FROM VehiculoTipoEstadoDet v WHERE v.idVehiculoTipoEstado.idVehiculoTipoEstado = :idVehiculoTipoEstado AND v.estadoReg = :estadoReg")})
public class VehiculoTipoEstadoDet implements Serializable {

//    @Column(name = "por_defecto_diferir")
//    private int porDefectoDiferir;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,
            mappedBy = "idVehiculoTipoEstadoDet", fetch = FetchType.LAZY)
    private List<DispEpaVted> dispEpaVtedList;

    @OneToMany(mappedBy = "idVehiculoTipoEstadoDet", fetch = FetchType.LAZY)
    private List<DispConciliacionDet> dispConciliacionDetList;

    @OneToMany(mappedBy = "idVehiculoTipoEstadoDet", fetch = FetchType.LAZY)
    private List<DispActividad> dispActividadList;

    @OneToMany(mappedBy = "idVehiculoTipoEstadoDet", fetch = FetchType.LAZY)
    private List<NovedadTipoDetalles> novedadTipoDetallesList;

    @OneToMany(mappedBy = "idVehiculoTipoEstadoDet", fetch = FetchType.LAZY)
    private List<VehiculoEstadoHistorico> VehiculoEstadoHistoricoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo_tipo_estado_det")
    private Integer idVehiculoTipoEstadoDet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
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
    @JoinColumn(name = "id_vehiculo_tipo_estado", referencedColumnName = "id_vehiculo_tipo_estado")
    @ManyToOne(fetch = FetchType.LAZY)
    private VehiculoTipoEstado idVehiculoTipoEstado;

    public VehiculoTipoEstadoDet() {
    }

    public VehiculoTipoEstadoDet(Integer idVehiculoTipoEstadoDet) {
        this.idVehiculoTipoEstadoDet = idVehiculoTipoEstadoDet;
    }

    public VehiculoTipoEstadoDet(Integer idVehiculoTipoEstadoDet, String nombre, String username, Date creado, int estadoReg) {
        this.idVehiculoTipoEstadoDet = idVehiculoTipoEstadoDet;
        this.nombre = nombre;
        this.username = username;
        this.creado = creado;
        this.estadoReg = estadoReg;
    }

    public Integer getIdVehiculoTipoEstadoDet() {
        return idVehiculoTipoEstadoDet;
    }

    public void setIdVehiculoTipoEstadoDet(Integer idVehiculoTipoEstadoDet) {
        this.idVehiculoTipoEstadoDet = idVehiculoTipoEstadoDet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getEstadoReg() {
        return estadoReg;
    }

    public void setEstadoReg(int estadoReg) {
        this.estadoReg = estadoReg;
    }

    public VehiculoTipoEstado getIdVehiculoTipoEstado() {
        return idVehiculoTipoEstado;
    }

    public void setIdVehiculoTipoEstado(VehiculoTipoEstado idVehiculoTipoEstado) {
        this.idVehiculoTipoEstado = idVehiculoTipoEstado;
    }

    @XmlTransient
    public List<NovedadTipoDetalles> getNovedadTipoDetallesList() {
        return novedadTipoDetallesList;
    }

    public void setNovedadTipoDetallesList(List<NovedadTipoDetalles> novedadTipoDetallesList) {
        this.novedadTipoDetallesList = novedadTipoDetallesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculoTipoEstadoDet != null ? idVehiculoTipoEstadoDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculoTipoEstadoDet)) {
            return false;
        }
        VehiculoTipoEstadoDet other = (VehiculoTipoEstadoDet) object;
        if ((this.idVehiculoTipoEstadoDet == null && other.idVehiculoTipoEstadoDet != null) || (this.idVehiculoTipoEstadoDet != null && !this.idVehiculoTipoEstadoDet.equals(other.idVehiculoTipoEstadoDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.VehiculoTipoEstadoDet[ idVehiculoTipoEstadoDet=" + idVehiculoTipoEstadoDet + " ]";
    }

    @XmlTransient
    public List<DispActividad> getDispActividadList() {
        return dispActividadList;
    }

    public void setDispActividadList(List<DispActividad> dispActividadList) {
        this.dispActividadList = dispActividadList;
    }

//    public int getPorDefectoDiferir() {
//        return porDefectoDiferir;
//    }
//
//    public void setPorDefectoDiferir(int porDefectoDiferir) {
//        this.porDefectoDiferir = porDefectoDiferir;
//    }

    @XmlTransient
    public List<DispConciliacionDet> getDispConciliacionDetList() {
        return dispConciliacionDetList;
    }

    public void setDispConciliacionDetList(List<DispConciliacionDet> dispConciliacionDetList) {
        this.dispConciliacionDetList = dispConciliacionDetList;
    }

    @XmlTransient
    public List<VehiculoEstadoHistorico> getVehiculoEstadoHistoricoList() {
        return VehiculoEstadoHistoricoList;
    }

    public void setVehiculoEstadoHistoricoList(List<VehiculoEstadoHistorico> VehiculoEstadoHistoricoList) {
        this.VehiculoEstadoHistoricoList = VehiculoEstadoHistoricoList;
    }

    @XmlTransient
    public List<DispEpaVted> getDispEpaVtedList() {
        return dispEpaVtedList;
    }

    public void setDispEpaVtedList(List<DispEpaVted> dispEpaVtedList) {
        this.dispEpaVtedList = dispEpaVtedList;
    }

}
