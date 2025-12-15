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
@Table(name = "cable_acc_informe_pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CableAccInformePregunta.findAll", query = "SELECT c FROM CableAccInformePregunta c")
    , @NamedQuery(name = "CableAccInformePregunta.findByIdCableAccInformePregunta", query = "SELECT c FROM CableAccInformePregunta c WHERE c.idCableAccInformePregunta = :idCableAccInformePregunta")
    , @NamedQuery(name = "CableAccInformePregunta.findByPregunta", query = "SELECT c FROM CableAccInformePregunta c WHERE c.pregunta = :pregunta")
    , @NamedQuery(name = "CableAccInformePregunta.findByDescripcion", query = "SELECT c FROM CableAccInformePregunta c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "CableAccInformePregunta.findByRequerido", query = "SELECT c FROM CableAccInformePregunta c WHERE c.requerido = :requerido")
    , @NamedQuery(name = "CableAccInformePregunta.findByUsername", query = "SELECT c FROM CableAccInformePregunta c WHERE c.username = :username")
    , @NamedQuery(name = "CableAccInformePregunta.findByCreado", query = "SELECT c FROM CableAccInformePregunta c WHERE c.creado = :creado")
    , @NamedQuery(name = "CableAccInformePregunta.findByModificado", query = "SELECT c FROM CableAccInformePregunta c WHERE c.modificado = :modificado")
    , @NamedQuery(name = "CableAccInformePregunta.findByEstadoReg", query = "SELECT c FROM CableAccInformePregunta c WHERE c.estadoReg = :estadoReg")})
public class CableAccInformePregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cable_acc_informe_pregunta")
    private Integer idCableAccInformePregunta;
    @Size(max = 45)
    @Column(name = "pregunta")
    private String pregunta;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "requerido")
    private Integer requerido;
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
    @OneToMany(mappedBy = "idCableAccInformePregunta", fetch = FetchType.LAZY)
    private List<CableAccInformeRespondienteDet> cableAccInformeRespondienteDetList;

    public CableAccInformePregunta() {
    }

    public CableAccInformePregunta(Integer idCableAccInformePregunta) {
        this.idCableAccInformePregunta = idCableAccInformePregunta;
    }

    public Integer getIdCableAccInformePregunta() {
        return idCableAccInformePregunta;
    }

    public void setIdCableAccInformePregunta(Integer idCableAccInformePregunta) {
        this.idCableAccInformePregunta = idCableAccInformePregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getRequerido() {
        return requerido;
    }

    public void setRequerido(Integer requerido) {
        this.requerido = requerido;
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
    public List<CableAccInformeRespondienteDet> getCableAccInformeRespondienteDetList() {
        return cableAccInformeRespondienteDetList;
    }

    public void setCableAccInformeRespondienteDetList(List<CableAccInformeRespondienteDet> cableAccInformeRespondienteDetList) {
        this.cableAccInformeRespondienteDetList = cableAccInformeRespondienteDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCableAccInformePregunta != null ? idCableAccInformePregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CableAccInformePregunta)) {
            return false;
        }
        CableAccInformePregunta other = (CableAccInformePregunta) object;
        if ((this.idCableAccInformePregunta == null && other.idCableAccInformePregunta != null) || (this.idCableAccInformePregunta != null && !this.idCableAccInformePregunta.equals(other.idCableAccInformePregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.CableAccInformePregunta[ idCableAccInformePregunta=" + idCableAccInformePregunta + " ]";
    }
    
}
