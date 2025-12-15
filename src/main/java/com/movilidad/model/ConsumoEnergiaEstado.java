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
 * @author solucionesit
 */
@Entity
@Table(name = "consumo_energia_estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsumoEnergiaEstado.findAll", query = "SELECT c FROM ConsumoEnergiaEstado c")
    , @NamedQuery(name = "ConsumoEnergiaEstado.findByIdConsumoEnergiaEstado", query = "SELECT c FROM ConsumoEnergiaEstado c WHERE c.idConsumoEnergiaEstado = :idConsumoEnergiaEstado")
    , @NamedQuery(name = "ConsumoEnergiaEstado.findByNombre", query = "SELECT c FROM ConsumoEnergiaEstado c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "ConsumoEnergiaEstado.findByUsername", query = "SELECT c FROM ConsumoEnergiaEstado c WHERE c.username = :username")
    , @NamedQuery(name = "ConsumoEnergiaEstado.findByCreado", query = "SELECT c FROM ConsumoEnergiaEstado c WHERE c.creado = :creado")
    , @NamedQuery(name = "ConsumoEnergiaEstado.findByModificado", query = "SELECT c FROM ConsumoEnergiaEstado c WHERE c.modificado = :modificado")
    , @NamedQuery(name = "ConsumoEnergiaEstado.findByEstadoReg", query = "SELECT c FROM ConsumoEnergiaEstado c WHERE c.estadoReg = :estadoReg")})
public class ConsumoEnergiaEstado implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsumoEnergiaEstado", fetch = FetchType.LAZY)
    private List<ConsumoEnergia> consumoEnergiaList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_consumo_energia_estado")
    private Integer idConsumoEnergiaEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
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

    public ConsumoEnergiaEstado() {
    }

    public ConsumoEnergiaEstado(Integer idConsumoEnergiaEstado) {
        this.idConsumoEnergiaEstado = idConsumoEnergiaEstado;
    }

    public ConsumoEnergiaEstado(Integer idConsumoEnergiaEstado, String nombre, int estadoReg) {
        this.idConsumoEnergiaEstado = idConsumoEnergiaEstado;
        this.nombre = nombre;
        this.estadoReg = estadoReg;
    }

    public Integer getIdConsumoEnergiaEstado() {
        return idConsumoEnergiaEstado;
    }

    public void setIdConsumoEnergiaEstado(Integer idConsumoEnergiaEstado) {
        this.idConsumoEnergiaEstado = idConsumoEnergiaEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idConsumoEnergiaEstado != null ? idConsumoEnergiaEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsumoEnergiaEstado)) {
            return false;
        }
        ConsumoEnergiaEstado other = (ConsumoEnergiaEstado) object;
        if ((this.idConsumoEnergiaEstado == null && other.idConsumoEnergiaEstado != null) || (this.idConsumoEnergiaEstado != null && !this.idConsumoEnergiaEstado.equals(other.idConsumoEnergiaEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.ConsumoEnergiaEstado[ idConsumoEnergiaEstado=" + idConsumoEnergiaEstado + " ]";
    }

    @XmlTransient
    public List<ConsumoEnergia> getConsumoEnergiaList() {
        return consumoEnergiaList;
    }

    public void setConsumoEnergiaList(List<ConsumoEnergia> consumoEnergiaList) {
        this.consumoEnergiaList = consumoEnergiaList;
    }

}
