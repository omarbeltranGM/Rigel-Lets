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
import jakarta.persistence.JoinColumn;
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
 * @author HP
 */
@Entity
@Table(name = "vehiculo_componente_zona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehiculoComponenteZona.findAll", query = "SELECT v FROM VehiculoComponenteZona v")
    , @NamedQuery(name = "VehiculoComponenteZona.findByIdVehiculoComponenteZona", query = "SELECT v FROM VehiculoComponenteZona v WHERE v.idVehiculoComponenteZona = :idVehiculoComponenteZona")
    , @NamedQuery(name = "VehiculoComponenteZona.findByNombre", query = "SELECT v FROM VehiculoComponenteZona v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "VehiculoComponenteZona.findByDescripcion", query = "SELECT v FROM VehiculoComponenteZona v WHERE v.descripcion = :descripcion")
    , @NamedQuery(name = "VehiculoComponenteZona.findByUsername", query = "SELECT v FROM VehiculoComponenteZona v WHERE v.username = :username")
    , @NamedQuery(name = "VehiculoComponenteZona.findByCreado", query = "SELECT v FROM VehiculoComponenteZona v WHERE v.creado = :creado")
    , @NamedQuery(name = "VehiculoComponenteZona.findByModificado", query = "SELECT v FROM VehiculoComponenteZona v WHERE v.modificado = :modificado")
    , @NamedQuery(name = "VehiculoComponenteZona.findByEstadoReg", query = "SELECT v FROM VehiculoComponenteZona v WHERE v.estadoReg = :estadoReg")})
public class VehiculoComponenteZona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo_componente_zona")
    private Integer idVehiculoComponenteZona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculoComponenteZona", fetch = FetchType.LAZY)
    private List<VehiculoComponente> vehiculoComponenteList;
    @JoinColumn(name = "id_vehiculo_componente_grupo", referencedColumnName = "id_vehiculo_componente_grupo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private VehiculoComponenteGrupo idVehiculoComponenteGrupo;

    public VehiculoComponenteZona() {
    }

    public VehiculoComponenteZona(Integer idVehiculoComponenteZona) {
        this.idVehiculoComponenteZona = idVehiculoComponenteZona;
    }

    public VehiculoComponenteZona(Integer idVehiculoComponenteZona, String nombre, String descripcion, String username, Date creado, int estadoReg) {
        this.idVehiculoComponenteZona = idVehiculoComponenteZona;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.username = username;
        this.creado = creado;
        this.estadoReg = estadoReg;
    }

    public Integer getIdVehiculoComponenteZona() {
        return idVehiculoComponenteZona;
    }

    public void setIdVehiculoComponenteZona(Integer idVehiculoComponenteZona) {
        this.idVehiculoComponenteZona = idVehiculoComponenteZona;
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

    @XmlTransient
    public List<VehiculoComponente> getVehiculoComponenteList() {
        return vehiculoComponenteList;
    }

    public void setVehiculoComponenteList(List<VehiculoComponente> vehiculoComponenteList) {
        this.vehiculoComponenteList = vehiculoComponenteList;
    }

    public VehiculoComponenteGrupo getIdVehiculoComponenteGrupo() {
        return idVehiculoComponenteGrupo;
    }

    public void setIdVehiculoComponenteGrupo(VehiculoComponenteGrupo idVehiculoComponenteGrupo) {
        this.idVehiculoComponenteGrupo = idVehiculoComponenteGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculoComponenteZona != null ? idVehiculoComponenteZona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculoComponenteZona)) {
            return false;
        }
        VehiculoComponenteZona other = (VehiculoComponenteZona) object;
        if ((this.idVehiculoComponenteZona == null && other.idVehiculoComponenteZona != null) || (this.idVehiculoComponenteZona != null && !this.idVehiculoComponenteZona.equals(other.idVehiculoComponenteZona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.VehiculoComponenteZona[ idVehiculoComponenteZona=" + idVehiculoComponenteZona + " ]";
    }
    
}
