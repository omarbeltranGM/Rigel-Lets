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
 * @author solucionesit
 */
@Entity
@Table(name = "novedad_docs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NovedadDocs.findAll", query = "SELECT n FROM NovedadDocs n")
    , @NamedQuery(name = "NovedadDocs.findByIdNovedadDocsc", query = "SELECT n FROM NovedadDocs n WHERE n.idNovedadDocsc = :idNovedadDocsc")
    , @NamedQuery(name = "NovedadDocs.findByPathArchivo", query = "SELECT n FROM NovedadDocs n WHERE n.pathArchivo = :pathArchivo")
    , @NamedQuery(name = "NovedadDocs.findByUsername", query = "SELECT n FROM NovedadDocs n WHERE n.username = :username")
    , @NamedQuery(name = "NovedadDocs.findByCreado", query = "SELECT n FROM NovedadDocs n WHERE n.creado = :creado")
    , @NamedQuery(name = "NovedadDocs.findByModificado", query = "SELECT n FROM NovedadDocs n WHERE n.modificado = :modificado")
    , @NamedQuery(name = "NovedadDocs.findByEstadoReg", query = "SELECT n FROM NovedadDocs n WHERE n.estadoReg = :estadoReg")})
public class NovedadDocs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_novedad_docsc")
    private Integer idNovedadDocsc;
    @Size(max = 150)
    @Column(name = "path_archivo")
    private String pathArchivo;
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

    @JoinColumn(name = "id_novedad", referencedColumnName = "id_novedad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Novedad idNovedad;

    public NovedadDocs() {
    }

    public NovedadDocs(Integer idNovedadDocsc) {
        this.idNovedadDocsc = idNovedadDocsc;
    }

    public NovedadDocs(Integer idNovedadDocsc, String username, Date creado, int estadoReg) {
        this.idNovedadDocsc = idNovedadDocsc;
        this.username = username;
        this.creado = creado;
        this.estadoReg = estadoReg;
    }

    public Integer getIdNovedadDocsc() {
        return idNovedadDocsc;
    }

    public void setIdNovedadDocsc(Integer idNovedadDocsc) {
        this.idNovedadDocsc = idNovedadDocsc;
    }

    public String getPathArchivo() {
        return pathArchivo;
    }

    public void setPathArchivo(String pathArchivo) {
        this.pathArchivo = pathArchivo;
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

    public Novedad getIdNovedad() {
        return idNovedad;
    }

    public void setIdNovedad(Novedad idNovedad) {
        this.idNovedad = idNovedad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNovedadDocsc != null ? idNovedadDocsc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NovedadDocs)) {
            return false;
        }
        NovedadDocs other = (NovedadDocs) object;
        if ((this.idNovedadDocsc == null && other.idNovedadDocsc != null) || (this.idNovedadDocsc != null && !this.idNovedadDocsc.equals(other.idNovedadDocsc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.NovedadDocs[ idNovedadDocsc=" + idNovedadDocsc + " ]";
    }

}
