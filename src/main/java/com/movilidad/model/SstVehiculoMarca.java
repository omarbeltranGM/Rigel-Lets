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
 * @author Carlos Ballestas
 */
@Entity
@Table(name = "sst_vehiculo_marca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SstVehiculoMarca.findAll", query = "SELECT s FROM SstVehiculoMarca s"),
    @NamedQuery(name = "SstVehiculoMarca.findByIdSstVehiculoMarca", query = "SELECT s FROM SstVehiculoMarca s WHERE s.idSstVehiculoMarca = :idSstVehiculoMarca"),
    @NamedQuery(name = "SstVehiculoMarca.findByMarca", query = "SELECT s FROM SstVehiculoMarca s WHERE s.marca = :marca"),
    @NamedQuery(name = "SstVehiculoMarca.findByDescripcion", query = "SELECT s FROM SstVehiculoMarca s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SstVehiculoMarca.findByUsername", query = "SELECT s FROM SstVehiculoMarca s WHERE s.username = :username"),
    @NamedQuery(name = "SstVehiculoMarca.findByCreado", query = "SELECT s FROM SstVehiculoMarca s WHERE s.creado = :creado"),
    @NamedQuery(name = "SstVehiculoMarca.findByModificado", query = "SELECT s FROM SstVehiculoMarca s WHERE s.modificado = :modificado"),
    @NamedQuery(name = "SstVehiculoMarca.findByEstadoReg", query = "SELECT s FROM SstVehiculoMarca s WHERE s.estadoReg = :estadoReg")})
public class SstVehiculoMarca implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sst_vehiculo_marca")
    private Integer idSstVehiculoMarca;
    @Size(max = 45)
    @Column(name = "marca")
    private String marca;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSstVehiculoMarca", fetch = FetchType.LAZY)
    private List<SstEmpresaVisitante> sstEmpresaVisitanteList;

    public SstVehiculoMarca() {
    }

    public SstVehiculoMarca(Integer idSstVehiculoMarca) {
        this.idSstVehiculoMarca = idSstVehiculoMarca;
    }

    public Integer getIdSstVehiculoMarca() {
        return idSstVehiculoMarca;
    }

    public void setIdSstVehiculoMarca(Integer idSstVehiculoMarca) {
        this.idSstVehiculoMarca = idSstVehiculoMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
        hash += (idSstVehiculoMarca != null ? idSstVehiculoMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SstVehiculoMarca)) {
            return false;
        }
        SstVehiculoMarca other = (SstVehiculoMarca) object;
        if ((this.idSstVehiculoMarca == null && other.idSstVehiculoMarca != null) || (this.idSstVehiculoMarca != null && !this.idSstVehiculoMarca.equals(other.idSstVehiculoMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.SstVehiculoMarca[ idSstVehiculoMarca=" + idSstVehiculoMarca + " ]";
    }
    
}
