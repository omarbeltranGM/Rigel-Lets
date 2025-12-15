/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author HP
 */
@Entity
@Table(name = "tanqueo_rendimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TanqueoRendimiento.findAll", query = "SELECT t FROM TanqueoRendimiento t")
    , @NamedQuery(name = "TanqueoRendimiento.findByIdTanqueoRendimiento", query = "SELECT t FROM TanqueoRendimiento t WHERE t.idTanqueoRendimiento = :idTanqueoRendimiento")
    , @NamedQuery(name = "TanqueoRendimiento.findByRendimiento", query = "SELECT t FROM TanqueoRendimiento t WHERE t.rendimiento = :rendimiento")
    , @NamedQuery(name = "TanqueoRendimiento.findByUsername", query = "SELECT t FROM TanqueoRendimiento t WHERE t.username = :username")
    , @NamedQuery(name = "TanqueoRendimiento.findByCreado", query = "SELECT t FROM TanqueoRendimiento t WHERE t.creado = :creado")
    , @NamedQuery(name = "TanqueoRendimiento.findByModificado", query = "SELECT t FROM TanqueoRendimiento t WHERE t.modificado = :modificado")
    , @NamedQuery(name = "TanqueoRendimiento.findByEstadoReg", query = "SELECT t FROM TanqueoRendimiento t WHERE t.estadoReg = :estadoReg")})
public class TanqueoRendimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tanqueo_rendimiento")
    private Integer idTanqueoRendimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "rendimiento")
    private BigDecimal rendimiento;
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
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vehiculo idVehiculo;

    public TanqueoRendimiento() {
    }

    public TanqueoRendimiento(Integer idTanqueoRendimiento) {
        this.idTanqueoRendimiento = idTanqueoRendimiento;
    }

    public TanqueoRendimiento(Integer idTanqueoRendimiento, BigDecimal rendimiento, String username, Date creado, int estadoReg) {
        this.idTanqueoRendimiento = idTanqueoRendimiento;
        this.rendimiento = rendimiento;
        this.username = username;
        this.creado = creado;
        this.estadoReg = estadoReg;
    }

    public Integer getIdTanqueoRendimiento() {
        return idTanqueoRendimiento;
    }

    public void setIdTanqueoRendimiento(Integer idTanqueoRendimiento) {
        this.idTanqueoRendimiento = idTanqueoRendimiento;
    }

    public BigDecimal getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(BigDecimal rendimiento) {
        this.rendimiento = rendimiento;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTanqueoRendimiento != null ? idTanqueoRendimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TanqueoRendimiento)) {
            return false;
        }
        TanqueoRendimiento other = (TanqueoRendimiento) object;
        if ((this.idTanqueoRendimiento == null && other.idTanqueoRendimiento != null) || (this.idTanqueoRendimiento != null && !this.idTanqueoRendimiento.equals(other.idTanqueoRendimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.TanqueoRendimiento[ idTanqueoRendimiento=" + idTanqueoRendimiento + " ]";
    }
    
}
