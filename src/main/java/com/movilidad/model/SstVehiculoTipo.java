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
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cesar
 */
@Entity
@Table(name = "sst_vehiculo_tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SstVehiculoTipo.findAll", query = "SELECT s FROM SstVehiculoTipo s"),
    @NamedQuery(name = "SstVehiculoTipo.findByIdSstVehiculoTipo", query = "SELECT s FROM SstVehiculoTipo s WHERE s.idSstVehiculoTipo = :idSstVehiculoTipo"),
    @NamedQuery(name = "SstVehiculoTipo.findByTipo", query = "SELECT s FROM SstVehiculoTipo s WHERE s.tipo = :tipo"),
    @NamedQuery(name = "SstVehiculoTipo.findByDescripcion", query = "SELECT s FROM SstVehiculoTipo s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SstVehiculoTipo.findByUsername", query = "SELECT s FROM SstVehiculoTipo s WHERE s.username = :username"),
    @NamedQuery(name = "SstVehiculoTipo.findByCreado", query = "SELECT s FROM SstVehiculoTipo s WHERE s.creado = :creado"),
    @NamedQuery(name = "SstVehiculoTipo.findByModificado", query = "SELECT s FROM SstVehiculoTipo s WHERE s.modificado = :modificado"),
    @NamedQuery(name = "SstVehiculoTipo.findByEstadoReg", query = "SELECT s FROM SstVehiculoTipo s WHERE s.estadoReg = :estadoReg")})
public class SstVehiculoTipo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sst_vehiculo_tipo")
    private Integer idSstVehiculoTipo;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSstVehiculoTipo", fetch = FetchType.LAZY)
    private List<SstEmpresaVisitante> sstEmpresaVisitanteList;

    public SstVehiculoTipo() {
    }

    public SstVehiculoTipo(Integer idSstVehiculoTipo) {
        this.idSstVehiculoTipo = idSstVehiculoTipo;
    }

    public Integer getIdSstVehiculoTipo() {
        return idSstVehiculoTipo;
    }

    public void setIdSstVehiculoTipo(Integer idSstVehiculoTipo) {
        this.idSstVehiculoTipo = idSstVehiculoTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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
    public List<SstEmpresaVisitante> getSstEmpresaVisitanteList() {
        return sstEmpresaVisitanteList;
    }

    public void setSstEmpresaVisitanteList(List<SstEmpresaVisitante> sstEmpresaVisitanteList) {
        this.sstEmpresaVisitanteList = sstEmpresaVisitanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSstVehiculoTipo != null ? idSstVehiculoTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SstVehiculoTipo)) {
            return false;
        }
        SstVehiculoTipo other = (SstVehiculoTipo) object;
        if ((this.idSstVehiculoTipo == null && other.idSstVehiculoTipo != null) || (this.idSstVehiculoTipo != null && !this.idSstVehiculoTipo.equals(other.idSstVehiculoTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.SstVehiculoTipo[ idSstVehiculoTipo=" + idSstVehiculoTipo + " ]";
    }
    
}
