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
@Table(name = "vehiculo_componente_grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehiculoComponenteGrupo.findAll", query = "SELECT v FROM VehiculoComponenteGrupo v"),
    @NamedQuery(name = "VehiculoComponenteGrupo.findByIdVehiculoComponenteGrupo", query = "SELECT v FROM VehiculoComponenteGrupo v WHERE v.idVehiculoComponenteGrupo = :idVehiculoComponenteGrupo"),
    @NamedQuery(name = "VehiculoComponenteGrupo.findByNombre", query = "SELECT v FROM VehiculoComponenteGrupo v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "VehiculoComponenteGrupo.findByDescripcion", query = "SELECT v FROM VehiculoComponenteGrupo v WHERE v.descripcion = :descripcion"),
    @NamedQuery(name = "VehiculoComponenteGrupo.findByTaxonomiaMxm", query = "SELECT v FROM VehiculoComponenteGrupo v WHERE v.taxonomiaMxm = :taxonomiaMxm"),
    @NamedQuery(name = "VehiculoComponenteGrupo.findByUsername", query = "SELECT v FROM VehiculoComponenteGrupo v WHERE v.username = :username"),
    @NamedQuery(name = "VehiculoComponenteGrupo.findByCreado", query = "SELECT v FROM VehiculoComponenteGrupo v WHERE v.creado = :creado"),
    @NamedQuery(name = "VehiculoComponenteGrupo.findByModificado", query = "SELECT v FROM VehiculoComponenteGrupo v WHERE v.modificado = :modificado"),
    @NamedQuery(name = "VehiculoComponenteGrupo.findByEstadoReg", query = "SELECT v FROM VehiculoComponenteGrupo v WHERE v.estadoReg = :estadoReg")})
public class VehiculoComponenteGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo_componente_grupo")
    private Integer idVehiculoComponenteGrupo;
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
    @Size(min = 1, max = 10)
    @Column(name = "taxonomia_mxm")
    private String taxonomiaMxm;
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
    @OneToMany(mappedBy = "idVehiculoComponenteGrupo", fetch = FetchType.LAZY)
    private List<VehiculoComponente> vehiculoComponenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculoComponenteGrupo", fetch = FetchType.LAZY)
    private List<VehiculoComponenteDano> vehiculoComponenteDanoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculoComponenteGrupo", fetch = FetchType.LAZY)
    private List<VehiculoComponenteZona> vehiculoComponenteZonaList;

    public VehiculoComponenteGrupo() {
    }

    public VehiculoComponenteGrupo(Integer idVehiculoComponenteGrupo) {
        this.idVehiculoComponenteGrupo = idVehiculoComponenteGrupo;
    }

    public VehiculoComponenteGrupo(Integer idVehiculoComponenteGrupo, String nombre, String descripcion, String taxonomiaMxm, String username, Date creado, int estadoReg) {
        this.idVehiculoComponenteGrupo = idVehiculoComponenteGrupo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.taxonomiaMxm = taxonomiaMxm;
        this.username = username;
        this.creado = creado;
        this.estadoReg = estadoReg;
    }

    public Integer getIdVehiculoComponenteGrupo() {
        return idVehiculoComponenteGrupo;
    }

    public void setIdVehiculoComponenteGrupo(Integer idVehiculoComponenteGrupo) {
        this.idVehiculoComponenteGrupo = idVehiculoComponenteGrupo;
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

    public String getTaxonomiaMxm() {
        return taxonomiaMxm;
    }

    public void setTaxonomiaMxm(String taxonomiaMxm) {
        this.taxonomiaMxm = taxonomiaMxm;
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

    @XmlTransient
    public List<VehiculoComponenteDano> getVehiculoComponenteDanoList() {
        return vehiculoComponenteDanoList;
    }

    public void setVehiculoComponenteDanoList(List<VehiculoComponenteDano> vehiculoComponenteDanoList) {
        this.vehiculoComponenteDanoList = vehiculoComponenteDanoList;
    }

    @XmlTransient
    public List<VehiculoComponenteZona> getVehiculoComponenteZonaList() {
        return vehiculoComponenteZonaList;
    }

    public void setVehiculoComponenteZonaList(List<VehiculoComponenteZona> vehiculoComponenteZonaList) {
        this.vehiculoComponenteZonaList = vehiculoComponenteZonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculoComponenteGrupo != null ? idVehiculoComponenteGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculoComponenteGrupo)) {
            return false;
        }
        VehiculoComponenteGrupo other = (VehiculoComponenteGrupo) object;
        if ((this.idVehiculoComponenteGrupo == null && other.idVehiculoComponenteGrupo != null) || (this.idVehiculoComponenteGrupo != null && !this.idVehiculoComponenteGrupo.equals(other.idVehiculoComponenteGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.VehiculoComponenteGrupo[ idVehiculoComponenteGrupo=" + idVehiculoComponenteGrupo + " ]";
    }

}
