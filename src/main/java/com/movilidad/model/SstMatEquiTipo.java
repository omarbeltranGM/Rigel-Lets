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
 * @author Carlos Ballestas
 */
@Entity
@Table(name = "sst_mat_equi_tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SstMatEquiTipo.findAll", query = "SELECT s FROM SstMatEquiTipo s"),
    @NamedQuery(name = "SstMatEquiTipo.findByIdSstMatEquiTipo", query = "SELECT s FROM SstMatEquiTipo s WHERE s.idSstMatEquiTipo = :idSstMatEquiTipo"),
    @NamedQuery(name = "SstMatEquiTipo.findByTipo", query = "SELECT s FROM SstMatEquiTipo s WHERE s.tipo = :tipo"),
    @NamedQuery(name = "SstMatEquiTipo.findByDescripcion", query = "SELECT s FROM SstMatEquiTipo s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SstMatEquiTipo.findByUsername", query = "SELECT s FROM SstMatEquiTipo s WHERE s.username = :username"),
    @NamedQuery(name = "SstMatEquiTipo.findByCreado", query = "SELECT s FROM SstMatEquiTipo s WHERE s.creado = :creado"),
    @NamedQuery(name = "SstMatEquiTipo.findByModificado", query = "SELECT s FROM SstMatEquiTipo s WHERE s.modificado = :modificado"),
    @NamedQuery(name = "SstMatEquiTipo.findByEstadoReg", query = "SELECT s FROM SstMatEquiTipo s WHERE s.estadoReg = :estadoReg")})
public class SstMatEquiTipo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sst_mat_equi_tipo")
    private Integer idSstMatEquiTipo;
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
    @OneToMany(mappedBy = "idSstMatEquiTipo", fetch = FetchType.LAZY)
    private List<SstMatEqui> sstMatEquiList;

    public SstMatEquiTipo() {
    }

    public SstMatEquiTipo(Integer idSstMatEquiTipo) {
        this.idSstMatEquiTipo = idSstMatEquiTipo;
    }

    public Integer getIdSstMatEquiTipo() {
        return idSstMatEquiTipo;
    }

    public void setIdSstMatEquiTipo(Integer idSstMatEquiTipo) {
        this.idSstMatEquiTipo = idSstMatEquiTipo;
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
    public List<SstMatEqui> getSstMatEquiList() {
        return sstMatEquiList;
    }

    public void setSstMatEquiList(List<SstMatEqui> sstMatEquiList) {
        this.sstMatEquiList = sstMatEquiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSstMatEquiTipo != null ? idSstMatEquiTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SstMatEquiTipo)) {
            return false;
        }
        SstMatEquiTipo other = (SstMatEquiTipo) object;
        if ((this.idSstMatEquiTipo == null && other.idSstMatEquiTipo != null) || (this.idSstMatEquiTipo != null && !this.idSstMatEquiTipo.equals(other.idSstMatEquiTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.SstMatEquiTipo[ idSstMatEquiTipo=" + idSstMatEquiTipo + " ]";
    }
    
}
