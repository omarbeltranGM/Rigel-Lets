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
@Table(name = "generica_pm_puntos_empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenericaPmPuntosEmpresa.findAll", query = "SELECT g FROM GenericaPmPuntosEmpresa g"),
    @NamedQuery(name = "GenericaPmPuntosEmpresa.findByIdGenericaPmPuntosEmpresa", query = "SELECT g FROM GenericaPmPuntosEmpresa g WHERE g.idGenericaPmPuntosEmpresa = :idGenericaPmPuntosEmpresa"),
    @NamedQuery(name = "GenericaPmPuntosEmpresa.findByDesde", query = "SELECT g FROM GenericaPmPuntosEmpresa g WHERE g.desde = :desde"),
    @NamedQuery(name = "GenericaPmPuntosEmpresa.findByHasta", query = "SELECT g FROM GenericaPmPuntosEmpresa g WHERE g.hasta = :hasta"),
    @NamedQuery(name = "GenericaPmPuntosEmpresa.findByVrPuntos", query = "SELECT g FROM GenericaPmPuntosEmpresa g WHERE g.vrPuntos = :vrPuntos"),
    @NamedQuery(name = "GenericaPmPuntosEmpresa.findByNroDias", query = "SELECT g FROM GenericaPmPuntosEmpresa g WHERE g.nroDias = :nroDias"),
    @NamedQuery(name = "GenericaPmPuntosEmpresa.findByUsername", query = "SELECT g FROM GenericaPmPuntosEmpresa g WHERE g.username = :username"),
    @NamedQuery(name = "GenericaPmPuntosEmpresa.findByCreado", query = "SELECT g FROM GenericaPmPuntosEmpresa g WHERE g.creado = :creado"),
    @NamedQuery(name = "GenericaPmPuntosEmpresa.findByModificado", query = "SELECT g FROM GenericaPmPuntosEmpresa g WHERE g.modificado = :modificado"),
    @NamedQuery(name = "GenericaPmPuntosEmpresa.findByEstadoReg", query = "SELECT g FROM GenericaPmPuntosEmpresa g WHERE g.estadoReg = :estadoReg")})
public class GenericaPmPuntosEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_generica_pm_puntos_empresa")
    private Integer idGenericaPmPuntosEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "desde")
    @Temporal(TemporalType.DATE)
    private Date desde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hasta")
    @Temporal(TemporalType.DATE)
    private Date hasta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vr_puntos")
    private int vrPuntos;
    @Column(name = "nro_dias")
    private Integer nroDias;
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
    @JoinColumn(name = "id_param_area", referencedColumnName = "id_param_area")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ParamArea idParamArea;

    public GenericaPmPuntosEmpresa() {
    }

    public GenericaPmPuntosEmpresa(Integer idGenericaPmPuntosEmpresa) {
        this.idGenericaPmPuntosEmpresa = idGenericaPmPuntosEmpresa;
    }

    public GenericaPmPuntosEmpresa(Integer idGenericaPmPuntosEmpresa, Date desde, Date hasta, int vrPuntos, String username, Date creado, int estadoReg) {
        this.idGenericaPmPuntosEmpresa = idGenericaPmPuntosEmpresa;
        this.desde = desde;
        this.hasta = hasta;
        this.vrPuntos = vrPuntos;
        this.username = username;
        this.creado = creado;
        this.estadoReg = estadoReg;
    }

    public Integer getIdGenericaPmPuntosEmpresa() {
        return idGenericaPmPuntosEmpresa;
    }

    public void setIdGenericaPmPuntosEmpresa(Integer idGenericaPmPuntosEmpresa) {
        this.idGenericaPmPuntosEmpresa = idGenericaPmPuntosEmpresa;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public int getVrPuntos() {
        return vrPuntos;
    }

    public void setVrPuntos(int vrPuntos) {
        this.vrPuntos = vrPuntos;
    }

    public Integer getNroDias() {
        return nroDias;
    }

    public void setNroDias(Integer nroDias) {
        this.nroDias = nroDias;
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

    public ParamArea getIdParamArea() {
        return idParamArea;
    }

    public void setIdParamArea(ParamArea idParamArea) {
        this.idParamArea = idParamArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGenericaPmPuntosEmpresa != null ? idGenericaPmPuntosEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenericaPmPuntosEmpresa)) {
            return false;
        }
        GenericaPmPuntosEmpresa other = (GenericaPmPuntosEmpresa) object;
        if ((this.idGenericaPmPuntosEmpresa == null && other.idGenericaPmPuntosEmpresa != null) || (this.idGenericaPmPuntosEmpresa != null && !this.idGenericaPmPuntosEmpresa.equals(other.idGenericaPmPuntosEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.GenericaPmPuntosEmpresa[ idGenericaPmPuntosEmpresa=" + idGenericaPmPuntosEmpresa + " ]";
    }
    
}
