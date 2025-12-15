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
@Table(name = "cable_acc_entrega_paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CableAccEntregaPaciente.findAll", query = "SELECT c FROM CableAccEntregaPaciente c")
    , @NamedQuery(name = "CableAccEntregaPaciente.findByIdCableAccEntregaPaciente", query = "SELECT c FROM CableAccEntregaPaciente c WHERE c.idCableAccEntregaPaciente = :idCableAccEntregaPaciente")
    , @NamedQuery(name = "CableAccEntregaPaciente.findByNombre", query = "SELECT c FROM CableAccEntregaPaciente c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CableAccEntregaPaciente.findByDescripcion", query = "SELECT c FROM CableAccEntregaPaciente c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "CableAccEntregaPaciente.findByUsername", query = "SELECT c FROM CableAccEntregaPaciente c WHERE c.username = :username")
    , @NamedQuery(name = "CableAccEntregaPaciente.findByCreado", query = "SELECT c FROM CableAccEntregaPaciente c WHERE c.creado = :creado")
    , @NamedQuery(name = "CableAccEntregaPaciente.findByModificado", query = "SELECT c FROM CableAccEntregaPaciente c WHERE c.modificado = :modificado")
    , @NamedQuery(name = "CableAccEntregaPaciente.findByEstadoReg", query = "SELECT c FROM CableAccEntregaPaciente c WHERE c.estadoReg = :estadoReg")})
public class CableAccEntregaPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cable_acc_entrega_paciente")
    private Integer idCableAccEntregaPaciente;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
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
    @OneToMany(mappedBy = "idCableAccEntregaPaciente", fetch = FetchType.LAZY)
    private List<CableAccSiniestrado> cableAccSiniestradoList;

    public CableAccEntregaPaciente() {
    }

    public CableAccEntregaPaciente(Integer idCableAccEntregaPaciente) {
        this.idCableAccEntregaPaciente = idCableAccEntregaPaciente;
    }

    public Integer getIdCableAccEntregaPaciente() {
        return idCableAccEntregaPaciente;
    }

    public void setIdCableAccEntregaPaciente(Integer idCableAccEntregaPaciente) {
        this.idCableAccEntregaPaciente = idCableAccEntregaPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idCableAccEntregaPaciente != null ? idCableAccEntregaPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CableAccEntregaPaciente)) {
            return false;
        }
        CableAccEntregaPaciente other = (CableAccEntregaPaciente) object;
        if ((this.idCableAccEntregaPaciente == null && other.idCableAccEntregaPaciente != null) || (this.idCableAccEntregaPaciente != null && !this.idCableAccEntregaPaciente.equals(other.idCableAccEntregaPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.CableAccEntregaPaciente[ idCableAccEntregaPaciente=" + idCableAccEntregaPaciente + " ]";
    }
    
}
