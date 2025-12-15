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
 * @author solucionesit
 */
@Entity
@Table(name = "atv_prestador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtvPrestador.findAll", query = "SELECT a FROM AtvPrestador a")
    , @NamedQuery(name = "AtvPrestador.findByIdAtvPrestador", query = "SELECT a FROM AtvPrestador a WHERE a.idAtvPrestador = :idAtvPrestador")
    , @NamedQuery(name = "AtvPrestador.findByNombre", query = "SELECT a FROM AtvPrestador a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "AtvPrestador.findByActivo", query = "SELECT a FROM AtvPrestador a WHERE a.activo = :activo")
    , @NamedQuery(name = "AtvPrestador.findByDescripcion", query = "SELECT a FROM AtvPrestador a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "AtvPrestador.findByUsername", query = "SELECT a FROM AtvPrestador a WHERE a.username = :username")
    , @NamedQuery(name = "AtvPrestador.findByCreado", query = "SELECT a FROM AtvPrestador a WHERE a.creado = :creado")
    , @NamedQuery(name = "AtvPrestador.findByModificado", query = "SELECT a FROM AtvPrestador a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AtvPrestador.findByEstadoReg", query = "SELECT a FROM AtvPrestador a WHERE a.estadoReg = :estadoReg")})
public class AtvPrestador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_atv_prestador")
    private Integer idAtvPrestador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private int activo;
    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "desde")
    @Temporal(TemporalType.DATE)
    private Date desde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hasta")
    @Temporal(TemporalType.DATE)
    private Date hasta;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAtvPrestador", fetch = FetchType.LAZY)
    private List<AtvCostoServicio> atvCostoServicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAtvPrestador", fetch = FetchType.LAZY)
    private List<AtvVehiculosAtencion> atvVehiculosAtencionList;

    @Column(name = "correo")
    private String correo;
    
    public AtvPrestador() {
    }

    public AtvPrestador(Integer idAtvPrestador) {
        this.idAtvPrestador = idAtvPrestador;
    }

    public AtvPrestador(Integer idAtvPrestador, String nombre, int activo) {
        this.idAtvPrestador = idAtvPrestador;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getIdAtvPrestador() {
        return idAtvPrestador;
    }

    public void setIdAtvPrestador(Integer idAtvPrestador) {
        this.idAtvPrestador = idAtvPrestador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
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

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }
    

    @XmlTransient
    public List<AtvCostoServicio> getAtvCostoServicioList() {
        return atvCostoServicioList;
    }

    public void setAtvCostoServicioList(List<AtvCostoServicio> atvCostoServicioList) {
        this.atvCostoServicioList = atvCostoServicioList;
    }

    @XmlTransient
    public List<AtvVehiculosAtencion> getAtvVehiculosAtencionList() {
        return atvVehiculosAtencionList;
    }

    public void setAtvVehiculosAtencionList(List<AtvVehiculosAtencion> atvVehiculosAtencionList) {
        this.atvVehiculosAtencionList = atvVehiculosAtencionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAtvPrestador != null ? idAtvPrestador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtvPrestador)) {
            return false;
        }
        AtvPrestador other = (AtvPrestador) object;
        if ((this.idAtvPrestador == null && other.idAtvPrestador != null) || (this.idAtvPrestador != null && !this.idAtvPrestador.equals(other.idAtvPrestador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AtvPrestador[ idAtvPrestador=" + idAtvPrestador + " ]";
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
