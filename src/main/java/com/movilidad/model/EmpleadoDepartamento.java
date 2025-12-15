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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "empleado_departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadoDepartamento.findAll", query = "SELECT e FROM EmpleadoDepartamento e")
    , @NamedQuery(name = "EmpleadoDepartamento.findByIdEmpleadoDepartamento", query = "SELECT e FROM EmpleadoDepartamento e WHERE e.idEmpleadoDepartamento = :idEmpleadoDepartamento")
    , @NamedQuery(name = "EmpleadoDepartamento.findByNombre", query = "SELECT e FROM EmpleadoDepartamento e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "EmpleadoDepartamento.findByUsername", query = "SELECT e FROM EmpleadoDepartamento e WHERE e.username = :username")
    , @NamedQuery(name = "EmpleadoDepartamento.findByCreado", query = "SELECT e FROM EmpleadoDepartamento e WHERE e.creado = :creado")
    , @NamedQuery(name = "EmpleadoDepartamento.findByModificado", query = "SELECT e FROM EmpleadoDepartamento e WHERE e.modificado = :modificado")
    , @NamedQuery(name = "EmpleadoDepartamento.findByEstadoReg", query = "SELECT e FROM EmpleadoDepartamento e WHERE e.estadoReg = :estadoReg")})
public class EmpleadoDepartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado_departamento")
    private Integer idEmpleadoDepartamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleadoDepartamento", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleadoDepartamento", fetch = FetchType.LAZY)
    private List<EmpleadoMunicipio> empleadoMunicipioList;

    public EmpleadoDepartamento() {
    }

    public EmpleadoDepartamento(Integer idEmpleadoDepartamento) {
        this.idEmpleadoDepartamento = idEmpleadoDepartamento;
    }

    public EmpleadoDepartamento(Integer idEmpleadoDepartamento, String nombre, String username, Date creado, int estadoReg) {
        this.idEmpleadoDepartamento = idEmpleadoDepartamento;
        this.nombre = nombre;
        this.username = username;
        this.creado = creado;
        this.estadoReg = estadoReg;
    }

    public Integer getIdEmpleadoDepartamento() {
        return idEmpleadoDepartamento;
    }

    public void setIdEmpleadoDepartamento(Integer idEmpleadoDepartamento) {
        this.idEmpleadoDepartamento = idEmpleadoDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @XmlTransient
    public List<EmpleadoMunicipio> getEmpleadoMunicipioList() {
        return empleadoMunicipioList;
    }

    public void setEmpleadoMunicipioList(List<EmpleadoMunicipio> empleadoMunicipioList) {
        this.empleadoMunicipioList = empleadoMunicipioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleadoDepartamento != null ? idEmpleadoDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoDepartamento)) {
            return false;
        }
        EmpleadoDepartamento other = (EmpleadoDepartamento) object;
        if ((this.idEmpleadoDepartamento == null && other.idEmpleadoDepartamento != null) || (this.idEmpleadoDepartamento != null && !this.idEmpleadoDepartamento.equals(other.idEmpleadoDepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.EmpleadoDepartamento[ idEmpleadoDepartamento=" + idEmpleadoDepartamento + " ]";
    }
    
}
