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
@Table(name = "acc_via_calzadas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccViaCalzadas.findAll", query = "SELECT a FROM AccViaCalzadas a")
    , @NamedQuery(name = "AccViaCalzadas.findByIdAccViaCalzadas", query = "SELECT a FROM AccViaCalzadas a WHERE a.idAccViaCalzadas = :idAccViaCalzadas")
    , @NamedQuery(name = "AccViaCalzadas.findByViaCalzadas", query = "SELECT a FROM AccViaCalzadas a WHERE a.viaCalzadas = :viaCalzadas")
    , @NamedQuery(name = "AccViaCalzadas.findByUsername", query = "SELECT a FROM AccViaCalzadas a WHERE a.username = :username")
    , @NamedQuery(name = "AccViaCalzadas.findByCreado", query = "SELECT a FROM AccViaCalzadas a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccViaCalzadas.findByModificado", query = "SELECT a FROM AccViaCalzadas a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccViaCalzadas.findByEstadoReg", query = "SELECT a FROM AccViaCalzadas a WHERE a.estadoReg = :estadoReg")})
public class AccViaCalzadas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_via_calzadas")
    private Integer idAccViaCalzadas;
    @Size(max = 60)
    @Column(name = "via_calzadas")
    private String viaCalzadas;
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
    @OneToMany(mappedBy = "idAccViaCalzada", fetch = FetchType.LAZY)
    private List<AccInformeOpe> accInformeOpeList;

    public AccViaCalzadas() {
    }

    public AccViaCalzadas(Integer idAccViaCalzadas) {
        this.idAccViaCalzadas = idAccViaCalzadas;
    }

    public Integer getIdAccViaCalzadas() {
        return idAccViaCalzadas;
    }

    public void setIdAccViaCalzadas(Integer idAccViaCalzadas) {
        this.idAccViaCalzadas = idAccViaCalzadas;
    }

    public String getViaCalzadas() {
        return viaCalzadas;
    }

    public void setViaCalzadas(String viaCalzadas) {
        this.viaCalzadas = viaCalzadas;
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
    public List<AccInformeOpe> getAccInformeOpeList() {
        return accInformeOpeList;
    }

    public void setAccInformeOpeList(List<AccInformeOpe> accInformeOpeList) {
        this.accInformeOpeList = accInformeOpeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccViaCalzadas != null ? idAccViaCalzadas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccViaCalzadas)) {
            return false;
        }
        AccViaCalzadas other = (AccViaCalzadas) object;
        if ((this.idAccViaCalzadas == null && other.idAccViaCalzadas != null) || (this.idAccViaCalzadas != null && !this.idAccViaCalzadas.equals(other.idAccViaCalzadas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccViaCalzadas[ idAccViaCalzadas=" + idAccViaCalzadas + " ]";
    }
    
}
