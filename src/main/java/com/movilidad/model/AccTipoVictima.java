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
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author soluciones-it
 */
@Entity
@Table(name = "acc_tipo_victima")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccTipoVictima.findAll", query = "SELECT a FROM AccTipoVictima a")
    , @NamedQuery(name = "AccTipoVictima.findByIdAccTipoVictima", query = "SELECT a FROM AccTipoVictima a WHERE a.idAccTipoVictima = :idAccTipoVictima")
    , @NamedQuery(name = "AccTipoVictima.findByTipo", query = "SELECT a FROM AccTipoVictima a WHERE a.tipo = :tipo")
    , @NamedQuery(name = "AccTipoVictima.findByUsername", query = "SELECT a FROM AccTipoVictima a WHERE a.username = :username")
    , @NamedQuery(name = "AccTipoVictima.findByCreado", query = "SELECT a FROM AccTipoVictima a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccTipoVictima.findByModificado", query = "SELECT a FROM AccTipoVictima a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccTipoVictima.findByEstadoReg", query = "SELECT a FROM AccTipoVictima a WHERE a.estadoReg = :estadoReg")})
public class AccTipoVictima implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_tipo_victima")
    private Integer idAccTipoVictima;
    @Size(max = 60)
    @Column(name = "tipo")
    private String tipo;
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
    @OneToMany(mappedBy = "idAccTipoVictima", fetch = FetchType.LAZY)
    private List<AccInformeMasterVic> accInformeMasterVicList;

    public AccTipoVictima() {
    }

    public AccTipoVictima(Integer idAccTipoVictima) {
        this.idAccTipoVictima = idAccTipoVictima;
    }

    public Integer getIdAccTipoVictima() {
        return idAccTipoVictima;
    }

    public void setIdAccTipoVictima(Integer idAccTipoVictima) {
        this.idAccTipoVictima = idAccTipoVictima;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
    public List<AccInformeMasterVic> getAccInformeMasterVicList() {
        return accInformeMasterVicList;
    }

    public void setAccInformeMasterVicList(List<AccInformeMasterVic> accInformeMasterVicList) {
        this.accInformeMasterVicList = accInformeMasterVicList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccTipoVictima != null ? idAccTipoVictima.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccTipoVictima)) {
            return false;
        }
        AccTipoVictima other = (AccTipoVictima) object;
        if ((this.idAccTipoVictima == null && other.idAccTipoVictima != null) || (this.idAccTipoVictima != null && !this.idAccTipoVictima.equals(other.idAccTipoVictima))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccTipoVictima[ idAccTipoVictima=" + idAccTipoVictima + " ]";
    }
    
}
