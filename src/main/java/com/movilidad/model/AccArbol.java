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
@Table(name = "acc_arbol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccArbol.findAll", query = "SELECT a FROM AccArbol a")
    , @NamedQuery(name = "AccArbol.findByIdAccArbol", query = "SELECT a FROM AccArbol a WHERE a.idAccArbol = :idAccArbol")
    , @NamedQuery(name = "AccArbol.findByArbol", query = "SELECT a FROM AccArbol a WHERE a.arbol = :arbol")
    , @NamedQuery(name = "AccArbol.findByUsername", query = "SELECT a FROM AccArbol a WHERE a.username = :username")
    , @NamedQuery(name = "AccArbol.findByCreado", query = "SELECT a FROM AccArbol a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccArbol.findByModificado", query = "SELECT a FROM AccArbol a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccArbol.findByEstadoReg", query = "SELECT a FROM AccArbol a WHERE a.estadoReg = :estadoReg")})
public class AccArbol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_arbol")
    private Integer idAccArbol;
    @Size(max = 60)
    @Column(name = "arbol")
    private String arbol;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAccArbol", fetch = FetchType.LAZY)
    private List<AccCausa> accCausaList;

    public AccArbol() {
    }

    public AccArbol(Integer idAccArbol) {
        this.idAccArbol = idAccArbol;
    }

    public Integer getIdAccArbol() {
        return idAccArbol;
    }

    public void setIdAccArbol(Integer idAccArbol) {
        this.idAccArbol = idAccArbol;
    }

    public String getArbol() {
        return arbol;
    }

    public void setArbol(String arbol) {
        this.arbol = arbol;
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
    public List<AccCausa> getAccCausaList() {
        return accCausaList;
    }

    public void setAccCausaList(List<AccCausa> accCausaList) {
        this.accCausaList = accCausaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccArbol != null ? idAccArbol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccArbol)) {
            return false;
        }
        AccArbol other = (AccArbol) object;
        if ((this.idAccArbol == null && other.idAccArbol != null) || (this.idAccArbol != null && !this.idAccArbol.equals(other.idAccArbol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccArbol[ idAccArbol=" + idAccArbol + " ]";
    }

}
