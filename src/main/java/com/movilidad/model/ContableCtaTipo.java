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
 * @author soluciones-it
 */
@Entity
@Table(name = "contable_cta_tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContableCtaTipo.findAll", query = "SELECT c FROM ContableCtaTipo c")
    , @NamedQuery(name = "ContableCtaTipo.findByIdContableCtaTipo", query = "SELECT c FROM ContableCtaTipo c WHERE c.idContableCtaTipo = :idContableCtaTipo")
    , @NamedQuery(name = "ContableCtaTipo.findByTipoCuenta", query = "SELECT c FROM ContableCtaTipo c WHERE c.tipoCuenta = :tipoCuenta")
    , @NamedQuery(name = "ContableCtaTipo.findByTipo", query = "SELECT c FROM ContableCtaTipo c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "ContableCtaTipo.findByDescripcion", query = "SELECT c FROM ContableCtaTipo c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "ContableCtaTipo.findByUsername", query = "SELECT c FROM ContableCtaTipo c WHERE c.username = :username")
    , @NamedQuery(name = "ContableCtaTipo.findByCreado", query = "SELECT c FROM ContableCtaTipo c WHERE c.creado = :creado")
    , @NamedQuery(name = "ContableCtaTipo.findByModificado", query = "SELECT c FROM ContableCtaTipo c WHERE c.modificado = :modificado")
    , @NamedQuery(name = "ContableCtaTipo.findByEstadoReg", query = "SELECT c FROM ContableCtaTipo c WHERE c.estadoReg = :estadoReg")})
public class ContableCtaTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contable_cta_tipo")
    private Integer idContableCtaTipo;
    @Size(max = 45)
    @Column(name = "tipo_cuenta")
    private String tipoCuenta;
    @Column(name = "tipo")
    private Integer tipo;
    @Size(max = 255)
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
    @OneToMany(mappedBy = "idContableCtaTipo", fetch = FetchType.LAZY)
    private List<ContableCtaVehiculo> contableCtaVehiculoList;
    @OneToMany(mappedBy = "idContableCtaTipo", fetch = FetchType.LAZY)
    private List<ContableCta> contableCtaList;

    public ContableCtaTipo() {
    }

    public ContableCtaTipo(Integer idContableCtaTipo) {
        this.idContableCtaTipo = idContableCtaTipo;
    }

    public Integer getIdContableCtaTipo() {
        return idContableCtaTipo;
    }

    public void setIdContableCtaTipo(Integer idContableCtaTipo) {
        this.idContableCtaTipo = idContableCtaTipo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
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
    public List<ContableCtaVehiculo> getContableCtaVehiculoList() {
        return contableCtaVehiculoList;
    }

    public void setContableCtaVehiculoList(List<ContableCtaVehiculo> contableCtaVehiculoList) {
        this.contableCtaVehiculoList = contableCtaVehiculoList;
    }

    @XmlTransient
    public List<ContableCta> getContableCtaList() {
        return contableCtaList;
    }

    public void setContableCtaList(List<ContableCta> contableCtaList) {
        this.contableCtaList = contableCtaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContableCtaTipo != null ? idContableCtaTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContableCtaTipo)) {
            return false;
        }
        ContableCtaTipo other = (ContableCtaTipo) object;
        if ((this.idContableCtaTipo == null && other.idContableCtaTipo != null) || (this.idContableCtaTipo != null && !this.idContableCtaTipo.equals(other.idContableCtaTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.ContableCtaTipo[ idContableCtaTipo=" + idContableCtaTipo + " ]";
    }
    
}
