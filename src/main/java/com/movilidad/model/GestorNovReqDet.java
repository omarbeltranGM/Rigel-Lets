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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Ballestas
 */
@Entity
@Table(name = "gestor_nov_req_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GestorNovReqDet.findAll", query = "SELECT g FROM GestorNovReqDet g"),
    @NamedQuery(name = "GestorNovReqDet.findByIdGestorNovReqDet", query = "SELECT g FROM GestorNovReqDet g WHERE g.idGestorNovReqDet = :idGestorNovReqDet"),
    @NamedQuery(name = "GestorNovReqDet.findByValor", query = "SELECT g FROM GestorNovReqDet g WHERE g.valor = :valor"),
    @NamedQuery(name = "GestorNovReqDet.findByUsername", query = "SELECT g FROM GestorNovReqDet g WHERE g.username = :username"),
    @NamedQuery(name = "GestorNovReqDet.findByCreado", query = "SELECT g FROM GestorNovReqDet g WHERE g.creado = :creado"),
    @NamedQuery(name = "GestorNovReqDet.findByModificado", query = "SELECT g FROM GestorNovReqDet g WHERE g.modificado = :modificado"),
    @NamedQuery(name = "GestorNovReqDet.findByEstadoReg", query = "SELECT g FROM GestorNovReqDet g WHERE g.estadoReg = :estadoReg")})
public class GestorNovReqDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gestor_nov_req_det")
    private Integer idGestorNovReqDet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
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
    @JoinColumn(name = "id_gestor_nov_requerimiento", referencedColumnName = "id_gestor_nov_requerimiento")
    @ManyToOne(fetch = FetchType.LAZY)
    private GestorNovRequerimiento idGestorNovRequerimiento;
    @JoinColumn(name = "id_gestor_novedad", referencedColumnName = "id_gestor_novedad")
    @ManyToOne(fetch = FetchType.LAZY)
    private GestorNovedad idGestorNovedad;

    public GestorNovReqDet() {
    }

    public GestorNovReqDet(Integer idGestorNovReqDet) {
        this.idGestorNovReqDet = idGestorNovReqDet;
    }

    public GestorNovReqDet(Integer idGestorNovReqDet, int valor) {
        this.idGestorNovReqDet = idGestorNovReqDet;
        this.valor = valor;
    }

    public Integer getIdGestorNovReqDet() {
        return idGestorNovReqDet;
    }

    public void setIdGestorNovReqDet(Integer idGestorNovReqDet) {
        this.idGestorNovReqDet = idGestorNovReqDet;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
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

    public GestorNovRequerimiento getIdGestorNovRequerimiento() {
        return idGestorNovRequerimiento;
    }

    public void setIdGestorNovRequerimiento(GestorNovRequerimiento idGestorNovRequerimiento) {
        this.idGestorNovRequerimiento = idGestorNovRequerimiento;
    }

    public GestorNovedad getIdGestorNovedad() {
        return idGestorNovedad;
    }

    public void setIdGestorNovedad(GestorNovedad idGestorNovedad) {
        this.idGestorNovedad = idGestorNovedad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGestorNovReqDet != null ? idGestorNovReqDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GestorNovReqDet)) {
            return false;
        }
        GestorNovReqDet other = (GestorNovReqDet) object;
        if ((this.idGestorNovReqDet == null && other.idGestorNovReqDet != null) || (this.idGestorNovReqDet != null && !this.idGestorNovReqDet.equals(other.idGestorNovReqDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.GestorNovReqDet[ idGestorNovReqDet=" + idGestorNovReqDet + " ]";
    }
    
}
