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
@Table(name = "gestor_nov_requerimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GestorNovRequerimiento.findAll", query = "SELECT g FROM GestorNovRequerimiento g"),
    @NamedQuery(name = "GestorNovRequerimiento.findByIdGestorNovRequerimiento", query = "SELECT g FROM GestorNovRequerimiento g WHERE g.idGestorNovRequerimiento = :idGestorNovRequerimiento"),
    @NamedQuery(name = "GestorNovRequerimiento.findByNombre", query = "SELECT g FROM GestorNovRequerimiento g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "GestorNovRequerimiento.findByUsername", query = "SELECT g FROM GestorNovRequerimiento g WHERE g.username = :username"),
    @NamedQuery(name = "GestorNovRequerimiento.findByCreado", query = "SELECT g FROM GestorNovRequerimiento g WHERE g.creado = :creado"),
    @NamedQuery(name = "GestorNovRequerimiento.findByModificado", query = "SELECT g FROM GestorNovRequerimiento g WHERE g.modificado = :modificado"),
    @NamedQuery(name = "GestorNovRequerimiento.findByEstadoReg", query = "SELECT g FROM GestorNovRequerimiento g WHERE g.estadoReg = :estadoReg")})
public class GestorNovRequerimiento implements Serializable {

    @OneToMany(mappedBy = "idGestorNovRequerimiento", fetch = FetchType.LAZY)
    private List<GestorNovReqSemana> gestorNovReqSemanaList;

    @OneToMany(mappedBy = "idGestorNovRequerimiento", fetch = FetchType.LAZY)
    private List<GestorNovReqDet> gestorNovReqDetList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gestor_nov_requerimiento")
    private Integer idGestorNovRequerimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
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
    @Column(name = "estado_reg")
    private Integer estadoReg;

    public GestorNovRequerimiento() {
    }

    public GestorNovRequerimiento(Integer idGestorNovRequerimiento) {
        this.idGestorNovRequerimiento = idGestorNovRequerimiento;
    }

    public GestorNovRequerimiento(Integer idGestorNovRequerimiento, String nombre, String descripcion) {
        this.idGestorNovRequerimiento = idGestorNovRequerimiento;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdGestorNovRequerimiento() {
        return idGestorNovRequerimiento;
    }

    public void setIdGestorNovRequerimiento(Integer idGestorNovRequerimiento) {
        this.idGestorNovRequerimiento = idGestorNovRequerimiento;
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

    public Integer getEstadoReg() {
        return estadoReg;
    }

    public void setEstadoReg(Integer estadoReg) {
        this.estadoReg = estadoReg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGestorNovRequerimiento != null ? idGestorNovRequerimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GestorNovRequerimiento)) {
            return false;
        }
        GestorNovRequerimiento other = (GestorNovRequerimiento) object;
        if ((this.idGestorNovRequerimiento == null && other.idGestorNovRequerimiento != null) || (this.idGestorNovRequerimiento != null && !this.idGestorNovRequerimiento.equals(other.idGestorNovRequerimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.GestorNovRequerimiento[ idGestorNovRequerimiento=" + idGestorNovRequerimiento + " ]";
    }

    @XmlTransient
    public List<GestorNovReqDet> getGestorNovReqDetList() {
        return gestorNovReqDetList;
    }

    public void setGestorNovReqDetList(List<GestorNovReqDet> gestorNovReqDetList) {
        this.gestorNovReqDetList = gestorNovReqDetList;
    }

    @XmlTransient
    public List<GestorNovReqSemana> getGestorNovReqSemanaList() {
        return gestorNovReqSemanaList;
    }

    public void setGestorNovReqSemanaList(List<GestorNovReqSemana> gestorNovReqSemanaList) {
        this.gestorNovReqSemanaList = gestorNovReqSemanaList;
    }
    
}
