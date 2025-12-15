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
@Table(name = "acc_via_geometrica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccViaGeometrica.findAll", query = "SELECT a FROM AccViaGeometrica a")
    , @NamedQuery(name = "AccViaGeometrica.findByIdAccViaGeometrica", query = "SELECT a FROM AccViaGeometrica a WHERE a.idAccViaGeometrica = :idAccViaGeometrica")
    , @NamedQuery(name = "AccViaGeometrica.findByViaGeometrica", query = "SELECT a FROM AccViaGeometrica a WHERE a.viaGeometrica = :viaGeometrica")
    , @NamedQuery(name = "AccViaGeometrica.findByUsername", query = "SELECT a FROM AccViaGeometrica a WHERE a.username = :username")
    , @NamedQuery(name = "AccViaGeometrica.findByCreado", query = "SELECT a FROM AccViaGeometrica a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccViaGeometrica.findByModificado", query = "SELECT a FROM AccViaGeometrica a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccViaGeometrica.findByEstadoReg", query = "SELECT a FROM AccViaGeometrica a WHERE a.estadoReg = :estadoReg")})
public class AccViaGeometrica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_via_geometrica")
    private Integer idAccViaGeometrica;
    @Size(max = 60)
    @Column(name = "via_geometrica")
    private String viaGeometrica;
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
    @OneToMany(mappedBy = "idAccViaGeometrica", fetch = FetchType.LAZY)
    private List<AccInformeOpe> accInformeOpeList;

    public AccViaGeometrica() {
    }

    public AccViaGeometrica(Integer idAccViaGeometrica) {
        this.idAccViaGeometrica = idAccViaGeometrica;
    }

    public Integer getIdAccViaGeometrica() {
        return idAccViaGeometrica;
    }

    public void setIdAccViaGeometrica(Integer idAccViaGeometrica) {
        this.idAccViaGeometrica = idAccViaGeometrica;
    }

    public String getViaGeometrica() {
        return viaGeometrica;
    }

    public void setViaGeometrica(String viaGeometrica) {
        this.viaGeometrica = viaGeometrica;
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
        hash += (idAccViaGeometrica != null ? idAccViaGeometrica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccViaGeometrica)) {
            return false;
        }
        AccViaGeometrica other = (AccViaGeometrica) object;
        if ((this.idAccViaGeometrica == null && other.idAccViaGeometrica != null) || (this.idAccViaGeometrica != null && !this.idAccViaGeometrica.equals(other.idAccViaGeometrica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccViaGeometrica[ idAccViaGeometrica=" + idAccViaGeometrica + " ]";
    }
    
}
