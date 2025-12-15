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
@Table(name = "acc_causa_raiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccCausaRaiz.findAll", query = "SELECT a FROM AccCausaRaiz a")
    , @NamedQuery(name = "AccCausaRaiz.findByIdAccCausaRaiz", query = "SELECT a FROM AccCausaRaiz a WHERE a.idAccCausaRaiz = :idAccCausaRaiz")
    , @NamedQuery(name = "AccCausaRaiz.findByCausaRaiz", query = "SELECT a FROM AccCausaRaiz a WHERE a.causaRaiz = :causaRaiz")
    , @NamedQuery(name = "AccCausaRaiz.findByUsername", query = "SELECT a FROM AccCausaRaiz a WHERE a.username = :username")
    , @NamedQuery(name = "AccCausaRaiz.findByCreado", query = "SELECT a FROM AccCausaRaiz a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccCausaRaiz.findByModificado", query = "SELECT a FROM AccCausaRaiz a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccCausaRaiz.findByEstadoReg", query = "SELECT a FROM AccCausaRaiz a WHERE a.estadoReg = :estadoReg")})
public class AccCausaRaiz implements Serializable {

    @OneToMany(mappedBy = "idCausaraiz", fetch = FetchType.LAZY)
    private List<AccidentePreCalificacion> accidentePreCalificacionList;

    @OneToMany(mappedBy = "idCausaRaiz", fetch = FetchType.LAZY)
    private List<AccInformeOpeCausalidad> accInformeOpeCausalidadList;

//    @OneToMany(mappedBy = "idCausaRaiz", fetch = FetchType.LAZY)
//    private List<AccidenteAnalisis> accidenteAnalisisList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_causa_raiz")
    private Integer idAccCausaRaiz;
    @Size(max = 60)
    @Column(name = "causa_raiz")
    private String causaRaiz;
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
    @JoinColumn(name = "id_acc_subcausa", referencedColumnName = "id_acc_subcausa")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AccCausaSub idAccSubcausa;

    public AccCausaRaiz() {
    }

    public AccCausaRaiz(Integer idAccCausaRaiz) {
        this.idAccCausaRaiz = idAccCausaRaiz;
    }

    public Integer getIdAccCausaRaiz() {
        return idAccCausaRaiz;
    }

    public void setIdAccCausaRaiz(Integer idAccCausaRaiz) {
        this.idAccCausaRaiz = idAccCausaRaiz;
    }

    public String getCausaRaiz() {
        return causaRaiz;
    }

    public void setCausaRaiz(String causaRaiz) {
        this.causaRaiz = causaRaiz;
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

    public AccCausaSub getIdAccSubcausa() {
        return idAccSubcausa;
    }

    public void setIdAccSubcausa(AccCausaSub idAccSubcausa) {
        this.idAccSubcausa = idAccSubcausa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccCausaRaiz != null ? idAccCausaRaiz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccCausaRaiz)) {
            return false;
        }
        AccCausaRaiz other = (AccCausaRaiz) object;
        if ((this.idAccCausaRaiz == null && other.idAccCausaRaiz != null) || (this.idAccCausaRaiz != null && !this.idAccCausaRaiz.equals(other.idAccCausaRaiz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.AccCausaRaiz[ idAccCausaRaiz=" + idAccCausaRaiz + " ]";
    }

//    @XmlTransient
//    public List<AccidenteAnalisis> getAccidenteAnalisisList() {
//        return accidenteAnalisisList;
//    }
//
//    public void setAccidenteAnalisisList(List<AccidenteAnalisis> accidenteAnalisisList) {
//        this.accidenteAnalisisList = accidenteAnalisisList;
//    }

    @XmlTransient
    public List<AccInformeOpeCausalidad> getAccInformeOpeCausalidadList() {
        return accInformeOpeCausalidadList;
    }

    public void setAccInformeOpeCausalidadList(List<AccInformeOpeCausalidad> accInformeOpeCausalidadList) {
        this.accInformeOpeCausalidadList = accInformeOpeCausalidadList;
    }

    @XmlTransient
    public List<AccidentePreCalificacion> getAccidentePreCalificacionList() {
        return accidentePreCalificacionList;
    }

    public void setAccidentePreCalificacionList(List<AccidentePreCalificacion> accidentePreCalificacionList) {
        this.accidentePreCalificacionList = accidentePreCalificacionList;
    }
    
}
