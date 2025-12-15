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
import jakarta.persistence.Lob;
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
 * @author HP
 */
@Entity
@Table(name = "acc_empresa_operadora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccEmpresaOperadora.findAll", query = "SELECT a FROM AccEmpresaOperadora a")
    , @NamedQuery(name = "AccEmpresaOperadora.findByIdAccEmpresaOperadora", query = "SELECT a FROM AccEmpresaOperadora a WHERE a.idAccEmpresaOperadora = :idAccEmpresaOperadora")
    , @NamedQuery(name = "AccEmpresaOperadora.findByEmpresaOperadora", query = "SELECT a FROM AccEmpresaOperadora a WHERE a.empresaOperadora = :empresaOperadora")
    , @NamedQuery(name = "AccEmpresaOperadora.findByUsername", query = "SELECT a FROM AccEmpresaOperadora a WHERE a.username = :username")
    , @NamedQuery(name = "AccEmpresaOperadora.findByCreado", query = "SELECT a FROM AccEmpresaOperadora a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccEmpresaOperadora.findByModificado", query = "SELECT a FROM AccEmpresaOperadora a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccEmpresaOperadora.findByEstadoReg", query = "SELECT a FROM AccEmpresaOperadora a WHERE a.estadoReg = :estadoReg")})
public class AccEmpresaOperadora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_empresa_operadora")
    private Integer idAccEmpresaOperadora;
    @Size(max = 60)
    @Column(name = "empresa_operadora")
    private String empresaOperadora;
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
    @OneToMany(mappedBy = "idEmpresaOperadora", fetch = FetchType.LAZY)
    private List<AccInformeVehCond> accInformeVehCondList;

    public AccEmpresaOperadora() {
    }

    public AccEmpresaOperadora(Integer idAccEmpresaOperadora) {
        this.idAccEmpresaOperadora = idAccEmpresaOperadora;
    }

    public Integer getIdAccEmpresaOperadora() {
        return idAccEmpresaOperadora;
    }

    public void setIdAccEmpresaOperadora(Integer idAccEmpresaOperadora) {
        this.idAccEmpresaOperadora = idAccEmpresaOperadora;
    }

    public String getEmpresaOperadora() {
        return empresaOperadora;
    }

    public void setEmpresaOperadora(String empresaOperadora) {
        this.empresaOperadora = empresaOperadora;
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
    public List<AccInformeVehCond> getAccInformeVehCondList() {
        return accInformeVehCondList;
    }

    public void setAccInformeVehCondList(List<AccInformeVehCond> accInformeVehCondList) {
        this.accInformeVehCondList = accInformeVehCondList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccEmpresaOperadora != null ? idAccEmpresaOperadora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccEmpresaOperadora)) {
            return false;
        }
        AccEmpresaOperadora other = (AccEmpresaOperadora) object;
        if ((this.idAccEmpresaOperadora == null && other.idAccEmpresaOperadora != null) || (this.idAccEmpresaOperadora != null && !this.idAccEmpresaOperadora.equals(other.idAccEmpresaOperadora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccEmpresaOperadora[ idAccEmpresaOperadora=" + idAccEmpresaOperadora + " ]";
    }
    
}
