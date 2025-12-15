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
@Table(name = "empleado_empleador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadoEmpleador.findAll", query = "SELECT e FROM EmpleadoEmpleador e")
    , @NamedQuery(name = "EmpleadoEmpleador.findByIdEmpleadoEmpleador", query = "SELECT e FROM EmpleadoEmpleador e WHERE e.idEmpleadoEmpleador = :idEmpleadoEmpleador")
    , @NamedQuery(name = "EmpleadoEmpleador.findByNombre", query = "SELECT e FROM EmpleadoEmpleador e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "EmpleadoEmpleador.findByUsername", query = "SELECT e FROM EmpleadoEmpleador e WHERE e.username = :username")
    , @NamedQuery(name = "EmpleadoEmpleador.findByCreado", query = "SELECT e FROM EmpleadoEmpleador e WHERE e.creado = :creado")
    , @NamedQuery(name = "EmpleadoEmpleador.findByModificado", query = "SELECT e FROM EmpleadoEmpleador e WHERE e.modificado = :modificado")
    , @NamedQuery(name = "EmpleadoEmpleador.findByEstadoReg", query = "SELECT e FROM EmpleadoEmpleador e WHERE e.estadoReg = :estadoReg")})
public class EmpleadoEmpleador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado_empleador")
    private Integer idEmpleadoEmpleador;
    @Size(max = 60)
    @Column(name = "nombre")
    private String nombre;
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
    @OneToMany(mappedBy = "idEmpleadoEmpleador", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList;

    public EmpleadoEmpleador() {
    }

    public EmpleadoEmpleador(Integer idEmpleadoEmpleador) {
        this.idEmpleadoEmpleador = idEmpleadoEmpleador;
    }

    public Integer getIdEmpleadoEmpleador() {
        return idEmpleadoEmpleador;
    }

    public void setIdEmpleadoEmpleador(Integer idEmpleadoEmpleador) {
        this.idEmpleadoEmpleador = idEmpleadoEmpleador;
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

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleadoEmpleador != null ? idEmpleadoEmpleador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoEmpleador)) {
            return false;
        }
        EmpleadoEmpleador other = (EmpleadoEmpleador) object;
        if ((this.idEmpleadoEmpleador == null && other.idEmpleadoEmpleador != null) || (this.idEmpleadoEmpleador != null && !this.idEmpleadoEmpleador.equals(other.idEmpleadoEmpleador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.EmpleadoEmpleador[ idEmpleadoEmpleador=" + idEmpleadoEmpleador + " ]";
    }
    
}
