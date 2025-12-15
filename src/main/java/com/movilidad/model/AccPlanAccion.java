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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "acc_plan_accion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccPlanAccion.findAll", query = "SELECT a FROM AccPlanAccion a"),
    @NamedQuery(name = "AccPlanAccion.findByIdAccPlanAccion", query = "SELECT a FROM AccPlanAccion a WHERE a.idAccPlanAccion = :idAccPlanAccion"),
    @NamedQuery(name = "AccPlanAccion.findByPlan", query = "SELECT a FROM AccPlanAccion a WHERE a.plan = :plan"),
    @NamedQuery(name = "AccPlanAccion.findByUsername", query = "SELECT a FROM AccPlanAccion a WHERE a.username = :username"),
    @NamedQuery(name = "AccPlanAccion.findByCreado", query = "SELECT a FROM AccPlanAccion a WHERE a.creado = :creado"),
    @NamedQuery(name = "AccPlanAccion.findByModificado", query = "SELECT a FROM AccPlanAccion a WHERE a.modificado = :modificado"),
    @NamedQuery(name = "AccPlanAccion.findByEstadoReg", query = "SELECT a FROM AccPlanAccion a WHERE a.estadoReg = :estadoReg")})
public class AccPlanAccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_plan_accion")
    private Integer idAccPlanAccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "plan")
    private String plan;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 255)
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

    public AccPlanAccion() {
    }

    public AccPlanAccion(Integer idAccPlanAccion) {
        this.idAccPlanAccion = idAccPlanAccion;
    }

    public AccPlanAccion(Integer idAccPlanAccion, String plan, String descripcion) {
        this.idAccPlanAccion = idAccPlanAccion;
        this.plan = plan;
        this.descripcion = descripcion;
    }

    public Integer getIdAccPlanAccion() {
        return idAccPlanAccion;
    }

    public void setIdAccPlanAccion(Integer idAccPlanAccion) {
        this.idAccPlanAccion = idAccPlanAccion;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
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
        hash += (idAccPlanAccion != null ? idAccPlanAccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccPlanAccion)) {
            return false;
        }
        AccPlanAccion other = (AccPlanAccion) object;
        if ((this.idAccPlanAccion == null && other.idAccPlanAccion != null) || (this.idAccPlanAccion != null && !this.idAccPlanAccion.equals(other.idAccPlanAccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccPlanAccion[ idAccPlanAccion=" + idAccPlanAccion + " ]";
    }
    
}
