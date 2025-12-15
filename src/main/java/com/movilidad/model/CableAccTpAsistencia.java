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
@Table(name = "cable_acc_tp_asistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CableAccTpAsistencia.findAll", query = "SELECT c FROM CableAccTpAsistencia c")
    , @NamedQuery(name = "CableAccTpAsistencia.findByIdCableAccTpAsistencia", query = "SELECT c FROM CableAccTpAsistencia c WHERE c.idCableAccTpAsistencia = :idCableAccTpAsistencia")
    , @NamedQuery(name = "CableAccTpAsistencia.findByTipo", query = "SELECT c FROM CableAccTpAsistencia c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "CableAccTpAsistencia.findByDescripcion", query = "SELECT c FROM CableAccTpAsistencia c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "CableAccTpAsistencia.findByUsername", query = "SELECT c FROM CableAccTpAsistencia c WHERE c.username = :username")
    , @NamedQuery(name = "CableAccTpAsistencia.findByCreado", query = "SELECT c FROM CableAccTpAsistencia c WHERE c.creado = :creado")
    , @NamedQuery(name = "CableAccTpAsistencia.findByModificado", query = "SELECT c FROM CableAccTpAsistencia c WHERE c.modificado = :modificado")
    , @NamedQuery(name = "CableAccTpAsistencia.findByEstadoReg", query = "SELECT c FROM CableAccTpAsistencia c WHERE c.estadoReg = :estadoReg")})
public class CableAccTpAsistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cable_acc_tp_asistencia")
    private Integer idCableAccTpAsistencia;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 255)
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
    @OneToMany(mappedBy = "idCableAccTpAsistencia", fetch = FetchType.LAZY)
    private List<CableAccSiniestrado> cableAccSiniestradoList;

    public CableAccTpAsistencia() {
    }

    public CableAccTpAsistencia(Integer idCableAccTpAsistencia) {
        this.idCableAccTpAsistencia = idCableAccTpAsistencia;
    }

    public Integer getIdCableAccTpAsistencia() {
        return idCableAccTpAsistencia;
    }

    public void setIdCableAccTpAsistencia(Integer idCableAccTpAsistencia) {
        this.idCableAccTpAsistencia = idCableAccTpAsistencia;
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
    public List<CableAccSiniestrado> getCableAccSiniestradoList() {
        return cableAccSiniestradoList;
    }

    public void setCableAccSiniestradoList(List<CableAccSiniestrado> cableAccSiniestradoList) {
        this.cableAccSiniestradoList = cableAccSiniestradoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCableAccTpAsistencia != null ? idCableAccTpAsistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CableAccTpAsistencia)) {
            return false;
        }
        CableAccTpAsistencia other = (CableAccTpAsistencia) object;
        if ((this.idCableAccTpAsistencia == null && other.idCableAccTpAsistencia != null) || (this.idCableAccTpAsistencia != null && !this.idCableAccTpAsistencia.equals(other.idCableAccTpAsistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.CableAccTpAsistencia[ idCableAccTpAsistencia=" + idCableAccTpAsistencia + " ]";
    }
    
}
