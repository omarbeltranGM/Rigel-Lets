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
@Table(name = "acc_via_zonat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccViaZonat.findAll", query = "SELECT a FROM AccViaZonat a")
    , @NamedQuery(name = "AccViaZonat.findByIdAccViaZonat", query = "SELECT a FROM AccViaZonat a WHERE a.idAccViaZonat = :idAccViaZonat")
    , @NamedQuery(name = "AccViaZonat.findByViaZonat", query = "SELECT a FROM AccViaZonat a WHERE a.viaZonat = :viaZonat")
    , @NamedQuery(name = "AccViaZonat.findByUsername", query = "SELECT a FROM AccViaZonat a WHERE a.username = :username")
    , @NamedQuery(name = "AccViaZonat.findByCreado", query = "SELECT a FROM AccViaZonat a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccViaZonat.findByModificado", query = "SELECT a FROM AccViaZonat a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccViaZonat.findByEstadoReg", query = "SELECT a FROM AccViaZonat a WHERE a.estadoReg = :estadoReg")})
public class AccViaZonat implements Serializable {

    @OneToMany(mappedBy = "idAccViaZonat", fetch = FetchType.LAZY)
    private List<AccidenteLugar> accidenteLugarList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_via_zonat")
    private Integer idAccViaZonat;
    @Size(max = 60)
    @Column(name = "via_zonat")
    private String viaZonat;
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

    public AccViaZonat() {
    }

    public AccViaZonat(Integer idAccViaZonat) {
        this.idAccViaZonat = idAccViaZonat;
    }

    public Integer getIdAccViaZonat() {
        return idAccViaZonat;
    }

    public void setIdAccViaZonat(Integer idAccViaZonat) {
        this.idAccViaZonat = idAccViaZonat;
    }

    public String getViaZonat() {
        return viaZonat;
    }

    public void setViaZonat(String viaZonat) {
        this.viaZonat = viaZonat;
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
        hash += (idAccViaZonat != null ? idAccViaZonat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccViaZonat)) {
            return false;
        }
        AccViaZonat other = (AccViaZonat) object;
        if ((this.idAccViaZonat == null && other.idAccViaZonat != null) || (this.idAccViaZonat != null && !this.idAccViaZonat.equals(other.idAccViaZonat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccViaZonat[ idAccViaZonat=" + idAccViaZonat + " ]";
    }

    @XmlTransient
    public List<AccidenteLugar> getAccidenteLugarList() {
        return accidenteLugarList;
    }

    public void setAccidenteLugarList(List<AccidenteLugar> accidenteLugarList) {
        this.accidenteLugarList = accidenteLugarList;
    }
    
}
