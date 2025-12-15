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
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cesar
 */
@Entity
@Table(name = "prg_borrado_asignacion_bus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgBorradoAsignacionBus.findAll", query = "SELECT p FROM PrgBorradoAsignacionBus p")
    , @NamedQuery(name = "PrgBorradoAsignacionBus.findByIdPrgBorradoAsignacionBus", query = "SELECT p FROM PrgBorradoAsignacionBus p WHERE p.idPrgBorradoAsignacionBus = :idPrgBorradoAsignacionBus")
    , @NamedQuery(name = "PrgBorradoAsignacionBus.findByFechaHora", query = "SELECT p FROM PrgBorradoAsignacionBus p WHERE p.fechaHora = :fechaHora")
    , @NamedQuery(name = "PrgBorradoAsignacionBus.findByUsername", query = "SELECT p FROM PrgBorradoAsignacionBus p WHERE p.username = :username")
    , @NamedQuery(name = "PrgBorradoAsignacionBus.findByCreado", query = "SELECT p FROM PrgBorradoAsignacionBus p WHERE p.creado = :creado")
    , @NamedQuery(name = "PrgBorradoAsignacionBus.findByModificado", query = "SELECT p FROM PrgBorradoAsignacionBus p WHERE p.modificado = :modificado")
    , @NamedQuery(name = "PrgBorradoAsignacionBus.findByEstadoReg", query = "SELECT p FROM PrgBorradoAsignacionBus p WHERE p.estadoReg = :estadoReg")})
public class PrgBorradoAsignacionBus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prg_borrado_asignacion_bus")
    private Integer idPrgBorradoAsignacionBus;
    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @Lob
    @Size(max = 65535)
    @Column(name = "motivo")
    private String motivo;
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

    public PrgBorradoAsignacionBus() {
    }

    public PrgBorradoAsignacionBus(Integer idPrgBorradoAsignacionBus) {
        this.idPrgBorradoAsignacionBus = idPrgBorradoAsignacionBus;
    }

    public Integer getIdPrgBorradoAsignacionBus() {
        return idPrgBorradoAsignacionBus;
    }

    public void setIdPrgBorradoAsignacionBus(Integer idPrgBorradoAsignacionBus) {
        this.idPrgBorradoAsignacionBus = idPrgBorradoAsignacionBus;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
        hash += (idPrgBorradoAsignacionBus != null ? idPrgBorradoAsignacionBus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgBorradoAsignacionBus)) {
            return false;
        }
        PrgBorradoAsignacionBus other = (PrgBorradoAsignacionBus) object;
        if ((this.idPrgBorradoAsignacionBus == null && other.idPrgBorradoAsignacionBus != null) || (this.idPrgBorradoAsignacionBus != null && !this.idPrgBorradoAsignacionBus.equals(other.idPrgBorradoAsignacionBus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.PrgBorradoAsignacionBus[ idPrgBorradoAsignacionBus=" + idPrgBorradoAsignacionBus + " ]";
    }
    
}
