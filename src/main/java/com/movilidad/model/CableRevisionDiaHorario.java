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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Ballestas
 */
@Entity
@Table(name = "cable_revision_dia_horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CableRevisionDiaHorario.findAll", query = "SELECT c FROM CableRevisionDiaHorario c"),
    @NamedQuery(name = "CableRevisionDiaHorario.findByIdCableRevisionDiaHorario", query = "SELECT c FROM CableRevisionDiaHorario c WHERE c.idCableRevisionDiaHorario = :idCableRevisionDiaHorario"),
    @NamedQuery(name = "CableRevisionDiaHorario.findByHora", query = "SELECT c FROM CableRevisionDiaHorario c WHERE c.hora = :hora"),
    @NamedQuery(name = "CableRevisionDiaHorario.findByUsername", query = "SELECT c FROM CableRevisionDiaHorario c WHERE c.username = :username"),
    @NamedQuery(name = "CableRevisionDiaHorario.findByCreado", query = "SELECT c FROM CableRevisionDiaHorario c WHERE c.creado = :creado"),
    @NamedQuery(name = "CableRevisionDiaHorario.findByModificado", query = "SELECT c FROM CableRevisionDiaHorario c WHERE c.modificado = :modificado"),
    @NamedQuery(name = "CableRevisionDiaHorario.findByEstadoReg", query = "SELECT c FROM CableRevisionDiaHorario c WHERE c.estadoReg = :estadoReg")})
public class CableRevisionDiaHorario implements Serializable {
    @OneToMany(mappedBy = "idCableRevisionDiaHorario", fetch = FetchType.LAZY)
    private List<CableRevisionDiaRta> cableRevisionDiaRtaList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cable_revision_dia_horario")
    private Integer idCableRevisionDiaHorario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "hora")
    private String hora;
    @Size(max = 15)
    @Column(name = "username")
    private String username;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_reg")
    private int estadoReg;

    public CableRevisionDiaHorario() {
    }

    public CableRevisionDiaHorario(Integer idCableRevisionDiaHorario) {
        this.idCableRevisionDiaHorario = idCableRevisionDiaHorario;
    }

    public CableRevisionDiaHorario(Integer idCableRevisionDiaHorario, String hora, int estadoReg) {
        this.idCableRevisionDiaHorario = idCableRevisionDiaHorario;
        this.hora = hora;
        this.estadoReg = estadoReg;
    }

    public Integer getIdCableRevisionDiaHorario() {
        return idCableRevisionDiaHorario;
    }

    public void setIdCableRevisionDiaHorario(Integer idCableRevisionDiaHorario) {
        this.idCableRevisionDiaHorario = idCableRevisionDiaHorario;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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

    public int getEstadoReg() {
        return estadoReg;
    }

    public void setEstadoReg(int estadoReg) {
        this.estadoReg = estadoReg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCableRevisionDiaHorario != null ? idCableRevisionDiaHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CableRevisionDiaHorario)) {
            return false;
        }
        CableRevisionDiaHorario other = (CableRevisionDiaHorario) object;
        if ((this.idCableRevisionDiaHorario == null && other.idCableRevisionDiaHorario != null) || (this.idCableRevisionDiaHorario != null && !this.idCableRevisionDiaHorario.equals(other.idCableRevisionDiaHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.CableRevisionDiaHorario[ idCableRevisionDiaHorario=" + idCableRevisionDiaHorario + " ]";
    }

    @XmlTransient
    public List<CableRevisionDiaRta> getCableRevisionDiaRtaList() {
        return cableRevisionDiaRtaList;
    }

    public void setCableRevisionDiaRtaList(List<CableRevisionDiaRta> cableRevisionDiaRtaList) {
        this.cableRevisionDiaRtaList = cableRevisionDiaRtaList;
    }
    
}
