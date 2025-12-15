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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Ballestas
 */
@Entity
@Table(name = "cable_revision_equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CableRevisionEquipo.findAll", query = "SELECT c FROM CableRevisionEquipo c"),
    @NamedQuery(name = "CableRevisionEquipo.findByIdCableRevisionEquipo", query = "SELECT c FROM CableRevisionEquipo c WHERE c.idCableRevisionEquipo = :idCableRevisionEquipo"),
    @NamedQuery(name = "CableRevisionEquipo.findByNombre", query = "SELECT c FROM CableRevisionEquipo c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "CableRevisionEquipo.findByUsername", query = "SELECT c FROM CableRevisionEquipo c WHERE c.username = :username"),
    @NamedQuery(name = "CableRevisionEquipo.findByCreado", query = "SELECT c FROM CableRevisionEquipo c WHERE c.creado = :creado"),
    @NamedQuery(name = "CableRevisionEquipo.findByModificado", query = "SELECT c FROM CableRevisionEquipo c WHERE c.modificado = :modificado"),
    @NamedQuery(name = "CableRevisionEquipo.findByEstadoReg", query = "SELECT c FROM CableRevisionEquipo c WHERE c.estadoReg = :estadoReg")})
public class CableRevisionEquipo implements Serializable {
    @OneToMany(mappedBy = "idCableRevisionEquipo", fetch = FetchType.LAZY)
    private List<CableRevisionEstacion> cableRevisionEstacionList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cable_revision_equipo")
    private Integer idCableRevisionEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_reg")
    private int estadoReg;

    public CableRevisionEquipo() {
    }

    public CableRevisionEquipo(Integer idCableRevisionEquipo) {
        this.idCableRevisionEquipo = idCableRevisionEquipo;
    }

    public CableRevisionEquipo(Integer idCableRevisionEquipo, String nombre, String descripcion, int estadoReg) {
        this.idCableRevisionEquipo = idCableRevisionEquipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estadoReg = estadoReg;
    }

    public Integer getIdCableRevisionEquipo() {
        return idCableRevisionEquipo;
    }

    public void setIdCableRevisionEquipo(Integer idCableRevisionEquipo) {
        this.idCableRevisionEquipo = idCableRevisionEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getEstadoReg() {
        return estadoReg;
    }

    public void setEstadoReg(int estadoReg) {
        this.estadoReg = estadoReg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCableRevisionEquipo != null ? idCableRevisionEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CableRevisionEquipo)) {
            return false;
        }
        CableRevisionEquipo other = (CableRevisionEquipo) object;
        if ((this.idCableRevisionEquipo == null && other.idCableRevisionEquipo != null) || (this.idCableRevisionEquipo != null && !this.idCableRevisionEquipo.equals(other.idCableRevisionEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.CableRevisionEquipo[ idCableRevisionEquipo=" + idCableRevisionEquipo + " ]";
    }

    @XmlTransient
    public List<CableRevisionEstacion> getCableRevisionEstacionList() {
        return cableRevisionEstacionList;
    }

    public void setCableRevisionEstacionList(List<CableRevisionEstacion> cableRevisionEstacionList) {
        this.cableRevisionEstacionList = cableRevisionEstacionList;
    }
    
}
