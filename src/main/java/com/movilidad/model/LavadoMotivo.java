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
@Table(name = "lavado_motivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LavadoMotivo.findAll", query = "SELECT l FROM LavadoMotivo l")
    , @NamedQuery(name = "LavadoMotivo.findByIdLavadoMotivo", query = "SELECT l FROM LavadoMotivo l WHERE l.idLavadoMotivo = :idLavadoMotivo")
    , @NamedQuery(name = "LavadoMotivo.findByMotivo", query = "SELECT l FROM LavadoMotivo l WHERE l.motivo = :motivo")
    , @NamedQuery(name = "LavadoMotivo.findByUsername", query = "SELECT l FROM LavadoMotivo l WHERE l.username = :username")
    , @NamedQuery(name = "LavadoMotivo.findByCreado", query = "SELECT l FROM LavadoMotivo l WHERE l.creado = :creado")
    , @NamedQuery(name = "LavadoMotivo.findByModificado", query = "SELECT l FROM LavadoMotivo l WHERE l.modificado = :modificado")
    , @NamedQuery(name = "LavadoMotivo.findByEstadoReg", query = "SELECT l FROM LavadoMotivo l WHERE l.estadoReg = :estadoReg")})
public class LavadoMotivo implements Serializable {

    @OneToMany(mappedBy = "idLavadoMotivo", fetch = FetchType.LAZY)
    private List<LavadoGm> lavadoGmList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lavado_motivo")
    private Integer idLavadoMotivo;
    @Size(max = 60)
    @Column(name = "motivo")
    private String motivo;
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

    public LavadoMotivo() {
    }

    public LavadoMotivo(Integer idLavadoMotivo) {
        this.idLavadoMotivo = idLavadoMotivo;
    }

    public Integer getIdLavadoMotivo() {
        return idLavadoMotivo;
    }

    public void setIdLavadoMotivo(Integer idLavadoMotivo) {
        this.idLavadoMotivo = idLavadoMotivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLavadoMotivo != null ? idLavadoMotivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LavadoMotivo)) {
            return false;
        }
        LavadoMotivo other = (LavadoMotivo) object;
        if ((this.idLavadoMotivo == null && other.idLavadoMotivo != null) || (this.idLavadoMotivo != null && !this.idLavadoMotivo.equals(other.idLavadoMotivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.LavadoMotivo[ idLavadoMotivo=" + idLavadoMotivo + " ]";
    }

    @XmlTransient
    public List<LavadoGm> getLavadoGmList() {
        return lavadoGmList;
    }

    public void setLavadoGmList(List<LavadoGm> lavadoGmList) {
        this.lavadoGmList = lavadoGmList;
    }
    
}
