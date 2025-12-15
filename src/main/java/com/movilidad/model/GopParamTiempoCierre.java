/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author solucionesit
 */
@Entity
@Table(name = "gop_param_tiempo_cierre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GopParamTiempoCierre.findAll", query = "SELECT g FROM GopParamTiempoCierre g")
    , @NamedQuery(name = "GopParamTiempoCierre.findByIdGopParamTiempoCierre", query = "SELECT g FROM GopParamTiempoCierre g WHERE g.idGopParamTiempoCierre = :idGopParamTiempoCierre")
    , @NamedQuery(name = "GopParamTiempoCierre.findByTiempo", query = "SELECT g FROM GopParamTiempoCierre g WHERE g.tiempo = :tiempo")
    , @NamedQuery(name = "GopParamTiempoCierre.findByUsername", query = "SELECT g FROM GopParamTiempoCierre g WHERE g.username = :username")
    , @NamedQuery(name = "GopParamTiempoCierre.findByCreado", query = "SELECT g FROM GopParamTiempoCierre g WHERE g.creado = :creado")
    , @NamedQuery(name = "GopParamTiempoCierre.findByModificado", query = "SELECT g FROM GopParamTiempoCierre g WHERE g.modificado = :modificado")
    , @NamedQuery(name = "GopParamTiempoCierre.findByEstadoReg", query = "SELECT g FROM GopParamTiempoCierre g WHERE g.estadoReg = :estadoReg")})
public class GopParamTiempoCierre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gop_param_tiempo_cierre")
    private Integer idGopParamTiempoCierre;
    @Size(max = 8)
    @Column(name = "tiempo")
    private String tiempo;
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

    @JoinColumn(name = "id_gop_unidad_funcional", referencedColumnName = "id_gop_unidad_funcional")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GopUnidadFuncional idGopUnidadFuncional;

    public GopParamTiempoCierre() {
    }

    public GopParamTiempoCierre(Integer idGopParamTiempoCierre) {
        this.idGopParamTiempoCierre = idGopParamTiempoCierre;
    }

    public Integer getIdGopParamTiempoCierre() {
        return idGopParamTiempoCierre;
    }

    public void setIdGopParamTiempoCierre(Integer idGopParamTiempoCierre) {
        this.idGopParamTiempoCierre = idGopParamTiempoCierre;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
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

    public GopUnidadFuncional getIdGopUnidadFuncional() {
        return idGopUnidadFuncional;
    }

    public void setIdGopUnidadFuncional(GopUnidadFuncional idGopUnidadFuncional) {
        this.idGopUnidadFuncional = idGopUnidadFuncional;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGopParamTiempoCierre != null ? idGopParamTiempoCierre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GopParamTiempoCierre)) {
            return false;
        }
        GopParamTiempoCierre other = (GopParamTiempoCierre) object;
        if ((this.idGopParamTiempoCierre == null && other.idGopParamTiempoCierre != null) || (this.idGopParamTiempoCierre != null && !this.idGopParamTiempoCierre.equals(other.idGopParamTiempoCierre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.GopParamTiempoCierre[ idGopParamTiempoCierre=" + idGopParamTiempoCierre + " ]";
    }

}
