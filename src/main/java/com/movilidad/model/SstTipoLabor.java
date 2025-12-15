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
 * @author Carlos Ballestas
 */
@Entity
@Table(name = "sst_tipo_labor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SstTipoLabor.findAll", query = "SELECT s FROM SstTipoLabor s"),
    @NamedQuery(name = "SstTipoLabor.findByIdSstTipoLabor", query = "SELECT s FROM SstTipoLabor s WHERE s.idSstTipoLabor = :idSstTipoLabor"),
    @NamedQuery(name = "SstTipoLabor.findByTipoLabor", query = "SELECT s FROM SstTipoLabor s WHERE s.tipoLabor = :tipoLabor"),
    @NamedQuery(name = "SstTipoLabor.findByUsername", query = "SELECT s FROM SstTipoLabor s WHERE s.username = :username"),
    @NamedQuery(name = "SstTipoLabor.findByCreado", query = "SELECT s FROM SstTipoLabor s WHERE s.creado = :creado"),
    @NamedQuery(name = "SstTipoLabor.findByModificado", query = "SELECT s FROM SstTipoLabor s WHERE s.modificado = :modificado"),
    @NamedQuery(name = "SstTipoLabor.findByEstadoReg", query = "SELECT s FROM SstTipoLabor s WHERE s.estadoReg = :estadoReg")})
public class SstTipoLabor implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSstTipoLabor", fetch = FetchType.LAZY)
    private List<SstAutorizacion> sstAutorizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoLabor", fetch = FetchType.LAZY)
    private List<SstLaborTipoDocs> sstLaborTipoDocsList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sst_tipo_labor")
    private Integer idSstTipoLabor;
    @Size(max = 60)
    @Column(name = "tipo_labor")
    private String tipoLabor;
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

    public SstTipoLabor() {
    }

    public SstTipoLabor(Integer idSstTipoLabor) {
        this.idSstTipoLabor = idSstTipoLabor;
    }

    public Integer getIdSstTipoLabor() {
        return idSstTipoLabor;
    }

    public void setIdSstTipoLabor(Integer idSstTipoLabor) {
        this.idSstTipoLabor = idSstTipoLabor;
    }

    public String getTipoLabor() {
        return tipoLabor;
    }

    public void setTipoLabor(String tipoLabor) {
        this.tipoLabor = tipoLabor;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSstTipoLabor != null ? idSstTipoLabor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SstTipoLabor)) {
            return false;
        }
        SstTipoLabor other = (SstTipoLabor) object;
        if ((this.idSstTipoLabor == null && other.idSstTipoLabor != null) || (this.idSstTipoLabor != null && !this.idSstTipoLabor.equals(other.idSstTipoLabor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.SstTipoLabor[ idSstTipoLabor=" + idSstTipoLabor + " ]";
    }

    @XmlTransient
    public List<SstLaborTipoDocs> getSstLaborTipoDocsList() {
        return sstLaborTipoDocsList;
    }

    public void setSstLaborTipoDocsList(List<SstLaborTipoDocs> sstLaborTipoDocsList) {
        this.sstLaborTipoDocsList = sstLaborTipoDocsList;
    }

    @XmlTransient
    public List<SstAutorizacion> getSstAutorizacionList() {
        return sstAutorizacionList;
    }

    public void setSstAutorizacionList(List<SstAutorizacion> sstAutorizacionList) {
        this.sstAutorizacionList = sstAutorizacionList;
    }
    
}
