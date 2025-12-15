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
@Table(name = "lavado_contratista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LavadoContratista.findAll", query = "SELECT l FROM LavadoContratista l"),
    @NamedQuery(name = "LavadoContratista.findByIdLavadoContratista", query = "SELECT l FROM LavadoContratista l WHERE l.idLavadoContratista = :idLavadoContratista"),
    @NamedQuery(name = "LavadoContratista.findByNombre", query = "SELECT l FROM LavadoContratista l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "LavadoContratista.findByActivo", query = "SELECT l FROM LavadoContratista l WHERE l.activo = :activo"),
    @NamedQuery(name = "LavadoContratista.findByUsername", query = "SELECT l FROM LavadoContratista l WHERE l.username = :username"),
    @NamedQuery(name = "LavadoContratista.findByCreado", query = "SELECT l FROM LavadoContratista l WHERE l.creado = :creado"),
    @NamedQuery(name = "LavadoContratista.findByModificado", query = "SELECT l FROM LavadoContratista l WHERE l.modificado = :modificado"),
    @NamedQuery(name = "LavadoContratista.findByEstadoReg", query = "SELECT l FROM LavadoContratista l WHERE l.estadoReg = :estadoReg")})
public class LavadoContratista implements Serializable {

    @OneToMany(mappedBy = "idLavadoContratista", fetch = FetchType.LAZY)
    private List<LavadoCosto> lavadoCostoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lavado_contratista")
    private Integer idLavadoContratista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private int activo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
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

    public LavadoContratista() {
    }

    public LavadoContratista(Integer idLavadoContratista) {
        this.idLavadoContratista = idLavadoContratista;
    }

    public LavadoContratista(Integer idLavadoContratista, String nombre, Date desde, Date hasta, int activo, String descripcion, String username, int estadoReg) {
        this.idLavadoContratista = idLavadoContratista;
        this.nombre = nombre;
        this.desde = desde;
        this.hasta = hasta;
        this.activo = activo;
        this.descripcion = descripcion;
        this.username = username;
        this.estadoReg = estadoReg;
    }

    public Integer getIdLavadoContratista() {
        return idLavadoContratista;
    }

    public void setIdLavadoContratista(Integer idLavadoContratista) {
        this.idLavadoContratista = idLavadoContratista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getEstadoReg() {
        return estadoReg;
    }

    public void setEstadoReg(int estadoReg) {
        this.estadoReg = estadoReg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLavadoContratista != null ? idLavadoContratista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LavadoContratista)) {
            return false;
        }
        LavadoContratista other = (LavadoContratista) object;
        if ((this.idLavadoContratista == null && other.idLavadoContratista != null) || (this.idLavadoContratista != null && !this.idLavadoContratista.equals(other.idLavadoContratista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.LavadoContratista[ idLavadoContratista=" + idLavadoContratista + " ]";
    }

    @XmlTransient
    public List<LavadoCosto> getLavadoCostoList() {
        return lavadoCostoList;
    }

    public void setLavadoCostoList(List<LavadoCosto> lavadoCostoList) {
        this.lavadoCostoList = lavadoCostoList;
    }

}
