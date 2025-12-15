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
 * @author HP
 */
@Entity
@Table(name = "acc_objeto_fijo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccObjetoFijo.findAll", query = "SELECT a FROM AccObjetoFijo a")
    , @NamedQuery(name = "AccObjetoFijo.findByIdAccObjetoFijo", query = "SELECT a FROM AccObjetoFijo a WHERE a.idAccObjetoFijo = :idAccObjetoFijo")
    , @NamedQuery(name = "AccObjetoFijo.findByObjetoFijo", query = "SELECT a FROM AccObjetoFijo a WHERE a.objetoFijo = :objetoFijo")
    , @NamedQuery(name = "AccObjetoFijo.findByUsername", query = "SELECT a FROM AccObjetoFijo a WHERE a.username = :username")
    , @NamedQuery(name = "AccObjetoFijo.findByCreado", query = "SELECT a FROM AccObjetoFijo a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccObjetoFijo.findByModificado", query = "SELECT a FROM AccObjetoFijo a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccObjetoFijo.findByEstadoReg", query = "SELECT a FROM AccObjetoFijo a WHERE a.estadoReg = :estadoReg")})
public class AccObjetoFijo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_objeto_fijo")
    private Integer idAccObjetoFijo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "objeto_fijo")
    private String objetoFijo;
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
    @OneToMany(mappedBy = "idAccObjetoFijo", fetch = FetchType.LAZY)
    private List<AccObjetoFijoInforme> accObjetoFijoInformeList;

    public AccObjetoFijo() {
    }

    public AccObjetoFijo(Integer idAccObjetoFijo) {
        this.idAccObjetoFijo = idAccObjetoFijo;
    }

    public AccObjetoFijo(Integer idAccObjetoFijo, String objetoFijo) {
        this.idAccObjetoFijo = idAccObjetoFijo;
        this.objetoFijo = objetoFijo;
    }

    public Integer getIdAccObjetoFijo() {
        return idAccObjetoFijo;
    }

    public void setIdAccObjetoFijo(Integer idAccObjetoFijo) {
        this.idAccObjetoFijo = idAccObjetoFijo;
    }

    public String getObjetoFijo() {
        return objetoFijo;
    }

    public void setObjetoFijo(String objetoFijo) {
        this.objetoFijo = objetoFijo;
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
    public List<AccObjetoFijoInforme> getAccObjetoFijoInformeList() {
        return accObjetoFijoInformeList;
    }

    public void setAccObjetoFijoInformeList(List<AccObjetoFijoInforme> accObjetoFijoInformeList) {
        this.accObjetoFijoInformeList = accObjetoFijoInformeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccObjetoFijo != null ? idAccObjetoFijo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccObjetoFijo)) {
            return false;
        }
        AccObjetoFijo other = (AccObjetoFijo) object;
        if ((this.idAccObjetoFijo == null && other.idAccObjetoFijo != null) || (this.idAccObjetoFijo != null && !this.idAccObjetoFijo.equals(other.idAccObjetoFijo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccObjetoFijo[ idAccObjetoFijo=" + idAccObjetoFijo + " ]";
    }
    
}
