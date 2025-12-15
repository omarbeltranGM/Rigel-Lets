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
@Table(name = "acc_etapa_proceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccEtapaProceso.findAll", query = "SELECT a FROM AccEtapaProceso a")
    , @NamedQuery(name = "AccEtapaProceso.findByIdAccEtapaProceso", query = "SELECT a FROM AccEtapaProceso a WHERE a.idAccEtapaProceso = :idAccEtapaProceso")
    , @NamedQuery(name = "AccEtapaProceso.findByCausaRaiz", query = "SELECT a FROM AccEtapaProceso a WHERE a.causaRaiz = :causaRaiz")
    , @NamedQuery(name = "AccEtapaProceso.findByUsername", query = "SELECT a FROM AccEtapaProceso a WHERE a.username = :username")
    , @NamedQuery(name = "AccEtapaProceso.findByCreado", query = "SELECT a FROM AccEtapaProceso a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccEtapaProceso.findByModificado", query = "SELECT a FROM AccEtapaProceso a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccEtapaProceso.findByEstadoReg", query = "SELECT a FROM AccEtapaProceso a WHERE a.estadoReg = :estadoReg")})
public class AccEtapaProceso implements Serializable {

    @OneToMany(mappedBy = "idAccEtapaProceso", fetch = FetchType.LAZY)
    private List<AccidenteDiligenciasj> accidenteDiligenciasjList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_etapa_proceso")
    private Integer idAccEtapaProceso;
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
    @JoinColumn(name = "id_acc_tipo_proceso", referencedColumnName = "id_acc_tipo_proceso")
    @ManyToOne(fetch = FetchType.LAZY)
    private AccTipoProceso idAccTipoProceso;

    public AccEtapaProceso() {
    }

    public AccEtapaProceso(Integer idAccEtapaProceso) {
        this.idAccEtapaProceso = idAccEtapaProceso;
    }

    public Integer getIdAccEtapaProceso() {
        return idAccEtapaProceso;
    }

    public void setIdAccEtapaProceso(Integer idAccEtapaProceso) {
        this.idAccEtapaProceso = idAccEtapaProceso;
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

    public AccTipoProceso getIdAccTipoProceso() {
        return idAccTipoProceso;
    }

    public void setIdAccTipoProceso(AccTipoProceso idAccTipoProceso) {
        this.idAccTipoProceso = idAccTipoProceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccEtapaProceso != null ? idAccEtapaProceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccEtapaProceso)) {
            return false;
        }
        AccEtapaProceso other = (AccEtapaProceso) object;
        if ((this.idAccEtapaProceso == null && other.idAccEtapaProceso != null) || (this.idAccEtapaProceso != null && !this.idAccEtapaProceso.equals(other.idAccEtapaProceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccEtapaProceso[ idAccEtapaProceso=" + idAccEtapaProceso + " ]";
    }

    @XmlTransient
    public List<AccidenteDiligenciasj> getAccidenteDiligenciasjList() {
        return accidenteDiligenciasjList;
    }

    public void setAccidenteDiligenciasjList(List<AccidenteDiligenciasj> accidenteDiligenciasjList) {
        this.accidenteDiligenciasjList = accidenteDiligenciasjList;
    }
    
}
