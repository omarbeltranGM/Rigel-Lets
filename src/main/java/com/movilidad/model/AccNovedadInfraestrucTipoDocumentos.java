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
 * @author Carlos Ballestas
 */
@Entity
@Table(name = "acc_novedad_infraestruc_tipo_documentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccNovedadInfraestrucTipoDocumentos.findAll", query = "SELECT a FROM AccNovedadInfraestrucTipoDocumentos a"),
    @NamedQuery(name = "AccNovedadInfraestrucTipoDocumentos.findByIdAccNovedadInfraestrucTipoDocumentos", query = "SELECT a FROM AccNovedadInfraestrucTipoDocumentos a WHERE a.idAccNovedadInfraestrucTipoDocumentos = :idAccNovedadInfraestrucTipoDocumentos"),
    @NamedQuery(name = "AccNovedadInfraestrucTipoDocumentos.findByNombre", query = "SELECT a FROM AccNovedadInfraestrucTipoDocumentos a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "AccNovedadInfraestrucTipoDocumentos.findByDescripcion", query = "SELECT a FROM AccNovedadInfraestrucTipoDocumentos a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "AccNovedadInfraestrucTipoDocumentos.findByObligatorio", query = "SELECT a FROM AccNovedadInfraestrucTipoDocumentos a WHERE a.obligatorio = :obligatorio"),
    @NamedQuery(name = "AccNovedadInfraestrucTipoDocumentos.findByUsername", query = "SELECT a FROM AccNovedadInfraestrucTipoDocumentos a WHERE a.username = :username"),
    @NamedQuery(name = "AccNovedadInfraestrucTipoDocumentos.findByCreado", query = "SELECT a FROM AccNovedadInfraestrucTipoDocumentos a WHERE a.creado = :creado"),
    @NamedQuery(name = "AccNovedadInfraestrucTipoDocumentos.findByModificado", query = "SELECT a FROM AccNovedadInfraestrucTipoDocumentos a WHERE a.modificado = :modificado"),
    @NamedQuery(name = "AccNovedadInfraestrucTipoDocumentos.findByEstadoReg", query = "SELECT a FROM AccNovedadInfraestrucTipoDocumentos a WHERE a.estadoReg = :estadoReg")})
public class AccNovedadInfraestrucTipoDocumentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acc_novedad_infraestruc_tipo_documentos")
    private Integer idAccNovedadInfraestrucTipoDocumentos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obligatorio")
    private int obligatorio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAccNovedadInfraestrucTipoDocumentos", fetch = FetchType.LAZY)
    private List<AccNovedadInfraestrucDocumentos> accNovedadInfraestrucDocumentosList;

    public AccNovedadInfraestrucTipoDocumentos() {
    }

    public AccNovedadInfraestrucTipoDocumentos(Integer idAccNovedadInfraestrucTipoDocumentos) {
        this.idAccNovedadInfraestrucTipoDocumentos = idAccNovedadInfraestrucTipoDocumentos;
    }

    public AccNovedadInfraestrucTipoDocumentos(Integer idAccNovedadInfraestrucTipoDocumentos, String nombre, int obligatorio, String username, int estadoReg) {
        this.idAccNovedadInfraestrucTipoDocumentos = idAccNovedadInfraestrucTipoDocumentos;
        this.nombre = nombre;
        this.obligatorio = obligatorio;
        this.username = username;
        this.estadoReg = estadoReg;
    }

    public Integer getIdAccNovedadInfraestrucTipoDocumentos() {
        return idAccNovedadInfraestrucTipoDocumentos;
    }

    public void setIdAccNovedadInfraestrucTipoDocumentos(Integer idAccNovedadInfraestrucTipoDocumentos) {
        this.idAccNovedadInfraestrucTipoDocumentos = idAccNovedadInfraestrucTipoDocumentos;
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

    public int getObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(int obligatorio) {
        this.obligatorio = obligatorio;
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

    @XmlTransient
    public List<AccNovedadInfraestrucDocumentos> getAccNovedadInfraestrucDocumentosList() {
        return accNovedadInfraestrucDocumentosList;
    }

    public void setAccNovedadInfraestrucDocumentosList(List<AccNovedadInfraestrucDocumentos> accNovedadInfraestrucDocumentosList) {
        this.accNovedadInfraestrucDocumentosList = accNovedadInfraestrucDocumentosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccNovedadInfraestrucTipoDocumentos != null ? idAccNovedadInfraestrucTipoDocumentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccNovedadInfraestrucTipoDocumentos)) {
            return false;
        }
        AccNovedadInfraestrucTipoDocumentos other = (AccNovedadInfraestrucTipoDocumentos) object;
        if ((this.idAccNovedadInfraestrucTipoDocumentos == null && other.idAccNovedadInfraestrucTipoDocumentos != null) || (this.idAccNovedadInfraestrucTipoDocumentos != null && !this.idAccNovedadInfraestrucTipoDocumentos.equals(other.idAccNovedadInfraestrucTipoDocumentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccNovedadInfraestrucTipoDocumentos[ idAccNovedadInfraestrucTipoDocumentos=" + idAccNovedadInfraestrucTipoDocumentos + " ]";
    }
    
}
