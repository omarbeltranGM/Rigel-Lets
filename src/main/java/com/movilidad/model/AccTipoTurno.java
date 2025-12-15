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
 * @author HP
 */
@Entity
@Table(name = "acc_tipo_turno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccTipoTurno.findAll", query = "SELECT a FROM AccTipoTurno a")
    , @NamedQuery(name = "AccTipoTurno.findByIdAccTipoTurno", query = "SELECT a FROM AccTipoTurno a WHERE a.idAccTipoTurno = :idAccTipoTurno")
    , @NamedQuery(name = "AccTipoTurno.findByTipoTurno", query = "SELECT a FROM AccTipoTurno a WHERE a.tipoTurno = :tipoTurno")
    , @NamedQuery(name = "AccTipoTurno.findByUsername", query = "SELECT a FROM AccTipoTurno a WHERE a.username = :username")
    , @NamedQuery(name = "AccTipoTurno.findByCreado", query = "SELECT a FROM AccTipoTurno a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccTipoTurno.findByModificado", query = "SELECT a FROM AccTipoTurno a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccTipoTurno.findByEstadoReg", query = "SELECT a FROM AccTipoTurno a WHERE a.estadoReg = :estadoReg")})
public class AccTipoTurno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_tipo_turno")
    private Integer idAccTipoTurno;
    @Size(max = 60)
    @Column(name = "tipo_turno")
    private String tipoTurno;
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
    @OneToMany(mappedBy = "idAccTipoTurno", fetch = FetchType.LAZY)
    private List<Accidente> accidenteList;

    public AccTipoTurno() {
    }

    public AccTipoTurno(Integer idAccTipoTurno) {
        this.idAccTipoTurno = idAccTipoTurno;
    }

    public Integer getIdAccTipoTurno() {
        return idAccTipoTurno;
    }

    public void setIdAccTipoTurno(Integer idAccTipoTurno) {
        this.idAccTipoTurno = idAccTipoTurno;
    }

    public String getTipoTurno() {
        return tipoTurno;
    }

    public void setTipoTurno(String tipoTurno) {
        this.tipoTurno = tipoTurno;
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
    public List<Accidente> getAccidenteList() {
        return accidenteList;
    }

    public void setAccidenteList(List<Accidente> accidenteList) {
        this.accidenteList = accidenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccTipoTurno != null ? idAccTipoTurno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccTipoTurno)) {
            return false;
        }
        AccTipoTurno other = (AccTipoTurno) object;
        if ((this.idAccTipoTurno == null && other.idAccTipoTurno != null) || (this.idAccTipoTurno != null && !this.idAccTipoTurno.equals(other.idAccTipoTurno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccTipoTurno[ idAccTipoTurno=" + idAccTipoTurno + " ]";
    }
    
}
