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
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
@Table(name = "acc_causa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccCausa.findAll", query = "SELECT a FROM AccCausa a")
    , @NamedQuery(name = "AccCausa.findByIdAccCausa", query = "SELECT a FROM AccCausa a WHERE a.idAccCausa = :idAccCausa")
    , @NamedQuery(name = "AccCausa.findByCausa", query = "SELECT a FROM AccCausa a WHERE a.causa = :causa")
    , @NamedQuery(name = "AccCausa.findByUsername", query = "SELECT a FROM AccCausa a WHERE a.username = :username")
    , @NamedQuery(name = "AccCausa.findByCreado", query = "SELECT a FROM AccCausa a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccCausa.findByModificado", query = "SELECT a FROM AccCausa a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccCausa.findByEstadoReg", query = "SELECT a FROM AccCausa a WHERE a.estadoReg = :estadoReg")})
public class AccCausa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_causa")
    private Integer idAccCausa;
    @Size(max = 60)
    @Column(name = "causa")
    private String causa;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCausa", fetch = FetchType.LAZY)
    private List<AccCausaSub> accCausaSubList;
    @JoinColumn(name = "id_acc_arbol", referencedColumnName = "id_acc_arbol")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AccArbol idAccArbol;

    public AccCausa() {
    }

    public AccCausa(Integer idAccCausa) {
        this.idAccCausa = idAccCausa;
    }

    public Integer getIdAccCausa() {
        return idAccCausa;
    }

    public void setIdAccCausa(Integer idAccCausa) {
        this.idAccCausa = idAccCausa;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
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
    public List<AccCausaSub> getAccCausaSubList() {
        return accCausaSubList;
    }

    public void setAccCausaSubList(List<AccCausaSub> accCausaSubList) {
        this.accCausaSubList = accCausaSubList;
    }

    public AccArbol getIdAccArbol() {
        return idAccArbol;
    }

    public void setIdAccArbol(AccArbol idAccArbol) {
        this.idAccArbol = idAccArbol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccCausa != null ? idAccCausa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccCausa)) {
            return false;
        }
        AccCausa other = (AccCausa) object;
        if ((this.idAccCausa == null && other.idAccCausa != null) || (this.idAccCausa != null && !this.idAccCausa.equals(other.idAccCausa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccCausa[ idAccCausa=" + idAccCausa + " ]";
    }
    
}
