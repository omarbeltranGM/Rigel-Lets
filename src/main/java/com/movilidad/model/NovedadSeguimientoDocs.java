/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Alberto
 */
@Entity
@Table(name = "novedad_seguimiento_docs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NovedadSeguimientoDocs.findAll", query = "SELECT n FROM NovedadSeguimientoDocs n"),
    @NamedQuery(name = "NovedadSeguimientoDocs.findByIdNovedadSeguimientoDoc", query = "SELECT n FROM NovedadSeguimientoDocs n WHERE n.idNovedadSeguimientoDoc = :idNovedadSeguimientoDoc"),
    @NamedQuery(name = "NovedadSeguimientoDocs.findByPathArchivo", query = "SELECT n FROM NovedadSeguimientoDocs n WHERE n.pathArchivo = :pathArchivo"),
    @NamedQuery(name = "NovedadSeguimientoDocs.findByNombreArchivo", query = "SELECT n FROM NovedadSeguimientoDocs n WHERE n.nombreArchivo= :nombreArchivo"),
    @NamedQuery(name = "NovedadSeguimientoDocs.findByUsername", query = "SELECT n FROM NovedadSeguimientoDocs n WHERE n.username = :username"),
    @NamedQuery(name = "NovedadSeguimientoDocs.findByCreado", query = "SELECT n FROM NovedadSeguimientoDocs n WHERE n.creado = :creado"),
    @NamedQuery(name = "NovedadSeguimientoDocs.findByModificado", query = "SELECT n FROM NovedadSeguimientoDocs n WHERE n.modificado = :modificado"),
    @NamedQuery(name = "NovedadSeguimientoDocs.findByEstadoReg", query = "SELECT n FROM NovedadSeguimientoDocs n WHERE n.estadoReg = :estadoReg")})
public class NovedadSeguimientoDocs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_novedad_seguimiento_doc")
    private Integer idNovedadSeguimientoDoc;
    @Size(max = 150)
    @Column(name = "path_archivo")
    private String pathArchivo;
    @Size(max = 150)
    @Column(name = "nombre_archivo")
    private String nombreArchivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
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
    @JoinColumn(name = "id_novedad_seguimiento", referencedColumnName = "id_novedad_seguimiento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NovedadSeguimiento idNovedadSeguimiento;

    public NovedadSeguimientoDocs() {
    }

    public NovedadSeguimientoDocs(Integer idNovedadSeguimientoDoc) {
        this.idNovedadSeguimientoDoc = idNovedadSeguimientoDoc;
    }

    public NovedadSeguimientoDocs(Integer idNovedadSeguimientoDoc, String username, Date creado, int estadoReg) {
        this.idNovedadSeguimientoDoc = idNovedadSeguimientoDoc;
        this.username = username;
        this.creado = creado;
        this.estadoReg = estadoReg;
    }

    public Integer getIdNovedadSeguimientoDoc() {
        return idNovedadSeguimientoDoc;
    }

    public void setIdNovedadSeguimientoDoc(Integer idNovedadSeguimientoDoc) {
        this.idNovedadSeguimientoDoc = idNovedadSeguimientoDoc;
    }

    public String getPathArchivo() {
        return pathArchivo;
    }

    public void setPathArchivo(String pathArchivo) {
        this.pathArchivo = pathArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
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

    public NovedadSeguimiento getIdNovedadSeguimiento() {
        return idNovedadSeguimiento;
    }

    public void setIdNovedadSeguimiento(NovedadSeguimiento idNovedadSeguimiento) {
        this.idNovedadSeguimiento = idNovedadSeguimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNovedadSeguimientoDoc != null ? idNovedadSeguimientoDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NovedadSeguimientoDocs)) {
            return false;
        }
        NovedadSeguimientoDocs other = (NovedadSeguimientoDocs) object;
        if ((this.idNovedadSeguimientoDoc == null && other.idNovedadSeguimientoDoc != null) || (this.idNovedadSeguimientoDoc != null && !this.idNovedadSeguimientoDoc.equals(other.idNovedadSeguimientoDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.NovedadSeguimientoDocs[ idNovedadSeguimientoDoc=" + idNovedadSeguimientoDoc + " ]";
    }

}
