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
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author soluciones-it
 */
@Entity
@Table(name = "mtto_elementos_abordo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MttoElementosAbordo.findAll", query = "SELECT m FROM MttoElementosAbordo m")
    , @NamedQuery(name = "MttoElementosAbordo.findByIdMttoElementosAbordo", query = "SELECT m FROM MttoElementosAbordo m WHERE m.idMttoElementosAbordo = :idMttoElementosAbordo")
    , @NamedQuery(name = "MttoElementosAbordo.findByTipoUbicacion", query = "SELECT m FROM MttoElementosAbordo m WHERE m.tipoUbicacion = :tipoUbicacion")
    , @NamedQuery(name = "MttoElementosAbordo.findByElemento", query = "SELECT m FROM MttoElementosAbordo m WHERE m.elemento = :elemento")
    , @NamedQuery(name = "MttoElementosAbordo.findByUsername", query = "SELECT m FROM MttoElementosAbordo m WHERE m.username = :username")
    , @NamedQuery(name = "MttoElementosAbordo.findByCreado", query = "SELECT m FROM MttoElementosAbordo m WHERE m.creado = :creado")
    , @NamedQuery(name = "MttoElementosAbordo.findByModificado", query = "SELECT m FROM MttoElementosAbordo m WHERE m.modificado = :modificado")
    , @NamedQuery(name = "MttoElementosAbordo.findByEstadoReg", query = "SELECT m FROM MttoElementosAbordo m WHERE m.estadoReg = :estadoReg")})
public class MttoElementosAbordo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mtto_elementos_abordo")
    private Integer idMttoElementosAbordo;
    @Column(name = "tipo_ubicacion")
    private Integer tipoUbicacion;
    @Size(max = 60)
    @Column(name = "elemento")
    private String elemento;
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
    @JoinColumn(name = "id_vehiculo_tipo", referencedColumnName = "id_vehiculo_tipo")
    @ManyToOne(fetch = FetchType.LAZY)
    private VehiculoTipo idVehiculoTipo;

    public MttoElementosAbordo() {
    }

    public MttoElementosAbordo(Integer idMttoElementosAbordo) {
        this.idMttoElementosAbordo = idMttoElementosAbordo;
    }

    public Integer getIdMttoElementosAbordo() {
        return idMttoElementosAbordo;
    }

    public void setIdMttoElementosAbordo(Integer idMttoElementosAbordo) {
        this.idMttoElementosAbordo = idMttoElementosAbordo;
    }

    public Integer getTipoUbicacion() {
        return tipoUbicacion;
    }

    public void setTipoUbicacion(Integer tipoUbicacion) {
        this.tipoUbicacion = tipoUbicacion;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
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

    public VehiculoTipo getIdVehiculoTipo() {
        return idVehiculoTipo;
    }

    public void setIdVehiculoTipo(VehiculoTipo idVehiculoTipo) {
        this.idVehiculoTipo = idVehiculoTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMttoElementosAbordo != null ? idMttoElementosAbordo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MttoElementosAbordo)) {
            return false;
        }
        MttoElementosAbordo other = (MttoElementosAbordo) object;
        if ((this.idMttoElementosAbordo == null && other.idMttoElementosAbordo != null) || (this.idMttoElementosAbordo != null && !this.idMttoElementosAbordo.equals(other.idMttoElementosAbordo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.MttoElementosAbordo[ idMttoElementosAbordo=" + idMttoElementosAbordo + " ]";
    }
    
}
