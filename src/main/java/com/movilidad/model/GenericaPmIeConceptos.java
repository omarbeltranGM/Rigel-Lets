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
@Table(name = "generica_pm_ie_conceptos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenericaPmIeConceptos.findAll", query = "SELECT g FROM GenericaPmIeConceptos g")
    , @NamedQuery(name = "GenericaPmIeConceptos.findByIdGenericaPmIeConceptos", query = "SELECT g FROM GenericaPmIeConceptos g WHERE g.idGenericaPmIeConceptos = :idGenericaPmIeConceptos")
    , @NamedQuery(name = "GenericaPmIeConceptos.findByConcepto", query = "SELECT g FROM GenericaPmIeConceptos g WHERE g.concepto = :concepto")
    , @NamedQuery(name = "GenericaPmIeConceptos.findByUsername", query = "SELECT g FROM GenericaPmIeConceptos g WHERE g.username = :username")
    , @NamedQuery(name = "GenericaPmIeConceptos.findByCreado", query = "SELECT g FROM GenericaPmIeConceptos g WHERE g.creado = :creado")
    , @NamedQuery(name = "GenericaPmIeConceptos.findByModificado", query = "SELECT g FROM GenericaPmIeConceptos g WHERE g.modificado = :modificado")
    , @NamedQuery(name = "GenericaPmIeConceptos.findByEstadoReg", query = "SELECT g FROM GenericaPmIeConceptos g WHERE g.estadoReg = :estadoReg")})
public class GenericaPmIeConceptos implements Serializable {

    @OneToMany(mappedBy = "idGenericaPmIeConceptos", fetch = FetchType.LAZY)
    private List<GenericaPmIngEgr> genericaPmIngEgrList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_generica_pm_ie_conceptos")
    private Integer idGenericaPmIeConceptos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 160)
    @Column(name = "concepto")
    private String concepto;
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
    @JoinColumn(name = "id_param_area", referencedColumnName = "id_param_area")
    @ManyToOne(fetch = FetchType.LAZY)
    private ParamArea idParamArea;
    @JoinColumn(name = "id_generica_pm_tipo_concepto", referencedColumnName = "id_generica_pm_tipo_concepto")
    @ManyToOne(fetch = FetchType.LAZY)
    private GenericaPmTipoConcepto idGenericaPmTipoConcepto;

    public GenericaPmIeConceptos() {
    }

    public GenericaPmIeConceptos(Integer idGenericaPmIeConceptos) {
        this.idGenericaPmIeConceptos = idGenericaPmIeConceptos;
    }

    public GenericaPmIeConceptos(Integer idGenericaPmIeConceptos, String concepto) {
        this.idGenericaPmIeConceptos = idGenericaPmIeConceptos;
        this.concepto = concepto;
    }

    public Integer getIdGenericaPmIeConceptos() {
        return idGenericaPmIeConceptos;
    }

    public void setIdGenericaPmIeConceptos(Integer idGenericaPmIeConceptos) {
        this.idGenericaPmIeConceptos = idGenericaPmIeConceptos;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
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

    public ParamArea getIdParamArea() {
        return idParamArea;
    }

    public void setIdParamArea(ParamArea idParamArea) {
        this.idParamArea = idParamArea;
    }

    public GenericaPmTipoConcepto getIdGenericaPmTipoConcepto() {
        return idGenericaPmTipoConcepto;
    }

    public void setIdGenericaPmTipoConcepto(GenericaPmTipoConcepto idGenericaPmTipoConcepto) {
        this.idGenericaPmTipoConcepto = idGenericaPmTipoConcepto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGenericaPmIeConceptos != null ? idGenericaPmIeConceptos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenericaPmIeConceptos)) {
            return false;
        }
        GenericaPmIeConceptos other = (GenericaPmIeConceptos) object;
        if ((this.idGenericaPmIeConceptos == null && other.idGenericaPmIeConceptos != null) || (this.idGenericaPmIeConceptos != null && !this.idGenericaPmIeConceptos.equals(other.idGenericaPmIeConceptos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.GenericaPmIeConceptos[ idGenericaPmIeConceptos=" + idGenericaPmIeConceptos + " ]";
    }

    @XmlTransient
    public List<GenericaPmIngEgr> getGenericaPmIngEgrList() {
        return genericaPmIngEgrList;
    }

    public void setGenericaPmIngEgrList(List<GenericaPmIngEgr> genericaPmIngEgrList) {
        this.genericaPmIngEgrList = genericaPmIngEgrList;
    }

}
