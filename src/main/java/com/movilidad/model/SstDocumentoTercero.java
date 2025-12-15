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
 * @author Carlos Ballestas
 */
@Entity
@Table(name = "sst_documento_tercero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SstDocumentoTercero.findAll", query = "SELECT s FROM SstDocumentoTercero s"),
    @NamedQuery(name = "SstDocumentoTercero.findByIdSstDocumentoTercero", query = "SELECT s FROM SstDocumentoTercero s WHERE s.idSstDocumentoTercero = :idSstDocumentoTercero"),
    @NamedQuery(name = "SstDocumentoTercero.findByTipoDocTercero", query = "SELECT s FROM SstDocumentoTercero s WHERE s.tipoDocTercero = :tipoDocTercero"),
    @NamedQuery(name = "SstDocumentoTercero.findByVigencia", query = "SELECT s FROM SstDocumentoTercero s WHERE s.vigencia = :vigencia"),
    @NamedQuery(name = "SstDocumentoTercero.findByRequerido", query = "SELECT s FROM SstDocumentoTercero s WHERE s.requerido = :requerido"),
    @NamedQuery(name = "SstDocumentoTercero.findByUsername", query = "SELECT s FROM SstDocumentoTercero s WHERE s.username = :username"),
    @NamedQuery(name = "SstDocumentoTercero.findByCreado", query = "SELECT s FROM SstDocumentoTercero s WHERE s.creado = :creado"),
    @NamedQuery(name = "SstDocumentoTercero.findByModificado", query = "SELECT s FROM SstDocumentoTercero s WHERE s.modificado = :modificado"),
    @NamedQuery(name = "SstDocumentoTercero.findByEstadoReg", query = "SELECT s FROM SstDocumentoTercero s WHERE s.estadoReg = :estadoReg")})
public class SstDocumentoTercero implements Serializable {

    @OneToMany(mappedBy = "idSstDocumentoTercero", fetch = FetchType.LAZY)
    private List<SstEmpresaVisitanteDocs> sstEmpresaVisitanteDocsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDocTercero", fetch = FetchType.LAZY)
    private List<SstLaborTipoDocs> sstLaborTipoDocsList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sst_documento_tercero")
    private Integer idSstDocumentoTercero;
    @Size(max = 60)
    @Column(name = "tipo_doc_tercero")
    private String tipoDocTercero;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "vigencia")
    private Integer vigencia;
    @Column(name = "requerido")
    private Integer requerido;
    @Column(name = "numero")
    private Integer numero;
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

    public SstDocumentoTercero() {
    }

    public SstDocumentoTercero(Integer idSstDocumentoTercero) {
        this.idSstDocumentoTercero = idSstDocumentoTercero;
    }

    public Integer getIdSstDocumentoTercero() {
        return idSstDocumentoTercero;
    }

    public void setIdSstDocumentoTercero(Integer idSstDocumentoTercero) {
        this.idSstDocumentoTercero = idSstDocumentoTercero;
    }

    public String getTipoDocTercero() {
        return tipoDocTercero;
    }

    public void setTipoDocTercero(String tipoDocTercero) {
        this.tipoDocTercero = tipoDocTercero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public Integer getRequerido() {
        return requerido;
    }

    public void setRequerido(Integer requerido) {
        this.requerido = requerido;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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
        hash += (idSstDocumentoTercero != null ? idSstDocumentoTercero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SstDocumentoTercero)) {
            return false;
        }
        SstDocumentoTercero other = (SstDocumentoTercero) object;
        if ((this.idSstDocumentoTercero == null && other.idSstDocumentoTercero != null) || (this.idSstDocumentoTercero != null && !this.idSstDocumentoTercero.equals(other.idSstDocumentoTercero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.SstDocumentoTercero[ idSstDocumentoTercero=" + idSstDocumentoTercero + " ]";
    }

    @XmlTransient
    public List<SstLaborTipoDocs> getSstLaborTipoDocsList() {
        return sstLaborTipoDocsList;
    }

    public void setSstLaborTipoDocsList(List<SstLaborTipoDocs> sstLaborTipoDocsList) {
        this.sstLaborTipoDocsList = sstLaborTipoDocsList;
    }

    @XmlTransient
    public List<SstEmpresaVisitanteDocs> getSstEmpresaVisitanteDocsList() {
        return sstEmpresaVisitanteDocsList;
    }

    public void setSstEmpresaVisitanteDocsList(List<SstEmpresaVisitanteDocs> sstEmpresaVisitanteDocsList) {
        this.sstEmpresaVisitanteDocsList = sstEmpresaVisitanteDocsList;
    }
    
}
