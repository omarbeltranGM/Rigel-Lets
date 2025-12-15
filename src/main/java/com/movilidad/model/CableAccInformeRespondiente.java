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
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
 * @author soluciones-it
 */
@Entity
@Table(name = "cable_acc_informe_respondiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CableAccInformeRespondiente.findAll", query = "SELECT c FROM CableAccInformeRespondiente c")
    , @NamedQuery(name = "CableAccInformeRespondiente.findByIdCableAccInformeRespondiente", query = "SELECT c FROM CableAccInformeRespondiente c WHERE c.idCableAccInformeRespondiente = :idCableAccInformeRespondiente")
    , @NamedQuery(name = "CableAccInformeRespondiente.findByUsername", query = "SELECT c FROM CableAccInformeRespondiente c WHERE c.username = :username")
    , @NamedQuery(name = "CableAccInformeRespondiente.findByCreado", query = "SELECT c FROM CableAccInformeRespondiente c WHERE c.creado = :creado")
    , @NamedQuery(name = "CableAccInformeRespondiente.findByModificado", query = "SELECT c FROM CableAccInformeRespondiente c WHERE c.modificado = :modificado")
    , @NamedQuery(name = "CableAccInformeRespondiente.findByEstadoReg", query = "SELECT c FROM CableAccInformeRespondiente c WHERE c.estadoReg = :estadoReg")})
public class CableAccInformeRespondiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cable_acc_informe_respondiente")
    private Integer idCableAccInformeRespondiente;
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
    @JoinColumn(name = "id_cable_accidentalidad", referencedColumnName = "id_cable_accidentalidad")
    @ManyToOne(fetch = FetchType.LAZY)
    private CableAccidentalidad idCableAccidentalidad;
    @JoinColumn(name = "id_empleado_supervisor", referencedColumnName = "id_empleado")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado idEmpleadoSupervisor;
    @OneToMany(mappedBy = "idCableAccInformeRespondiente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CableAccInformeRespondienteDet> cableAccInformeRespondienteDetList;

    public CableAccInformeRespondiente() {
    }

    public CableAccInformeRespondiente(Integer idCableAccInformeRespondiente) {
        this.idCableAccInformeRespondiente = idCableAccInformeRespondiente;
    }

    public Integer getIdCableAccInformeRespondiente() {
        return idCableAccInformeRespondiente;
    }

    public void setIdCableAccInformeRespondiente(Integer idCableAccInformeRespondiente) {
        this.idCableAccInformeRespondiente = idCableAccInformeRespondiente;
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

    public CableAccidentalidad getIdCableAccidentalidad() {
        return idCableAccidentalidad;
    }

    public void setIdCableAccidentalidad(CableAccidentalidad idCableAccidentalidad) {
        this.idCableAccidentalidad = idCableAccidentalidad;
    }

    public Empleado getIdEmpleadoSupervisor() {
        return idEmpleadoSupervisor;
    }

    public void setIdEmpleadoSupervisor(Empleado idEmpleadoSupervisor) {
        this.idEmpleadoSupervisor = idEmpleadoSupervisor;
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
        hash += (idCableAccInformeRespondiente != null ? idCableAccInformeRespondiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CableAccInformeRespondiente)) {
            return false;
        }
        CableAccInformeRespondiente other = (CableAccInformeRespondiente) object;
        if ((this.idCableAccInformeRespondiente == null && other.idCableAccInformeRespondiente != null) || (this.idCableAccInformeRespondiente != null && !this.idCableAccInformeRespondiente.equals(other.idCableAccInformeRespondiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.CableAccInformeRespondiente[ idCableAccInformeRespondiente=" + idCableAccInformeRespondiente + " ]";
    }

}
