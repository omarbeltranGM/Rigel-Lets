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
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cesar
 */
@Entity
@Table(name = "sst_empresa_visitante_docs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SstEmpresaVisitanteDocs.findAll", query = "SELECT s FROM SstEmpresaVisitanteDocs s"),
    @NamedQuery(name = "SstEmpresaVisitanteDocs.findByIdSstEmpresaVisitanteDocs", query = "SELECT s FROM SstEmpresaVisitanteDocs s WHERE s.idSstEmpresaVisitanteDocs = :idSstEmpresaVisitanteDocs"),
    @NamedQuery(name = "SstEmpresaVisitanteDocs.findByPath", query = "SELECT s FROM SstEmpresaVisitanteDocs s WHERE s.path = :path"),
    @NamedQuery(name = "SstEmpresaVisitanteDocs.findByActivo", query = "SELECT s FROM SstEmpresaVisitanteDocs s WHERE s.activo = :activo"),
    @NamedQuery(name = "SstEmpresaVisitanteDocs.findByNumero", query = "SELECT s FROM SstEmpresaVisitanteDocs s WHERE s.numero = :numero"),
    @NamedQuery(name = "SstEmpresaVisitanteDocs.findByDesde", query = "SELECT s FROM SstEmpresaVisitanteDocs s WHERE s.desde = :desde"),
    @NamedQuery(name = "SstEmpresaVisitanteDocs.findByHasta", query = "SELECT s FROM SstEmpresaVisitanteDocs s WHERE s.hasta = :hasta"),
    @NamedQuery(name = "SstEmpresaVisitanteDocs.findByUsername", query = "SELECT s FROM SstEmpresaVisitanteDocs s WHERE s.username = :username"),
    @NamedQuery(name = "SstEmpresaVisitanteDocs.findByCreado", query = "SELECT s FROM SstEmpresaVisitanteDocs s WHERE s.creado = :creado"),
    @NamedQuery(name = "SstEmpresaVisitanteDocs.findByModificado", query = "SELECT s FROM SstEmpresaVisitanteDocs s WHERE s.modificado = :modificado"),
    @NamedQuery(name = "SstEmpresaVisitanteDocs.findByEstadoReg", query = "SELECT s FROM SstEmpresaVisitanteDocs s WHERE s.estadoReg = :estadoReg")})
public class SstEmpresaVisitanteDocs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sst_empresa_visitante_docs")
    private Integer idSstEmpresaVisitanteDocs;
    @Size(max = 255)
    @Column(name = "path")
    private String path;
    @Column(name = "activo")
    private int activo;
    @Size(max = 15)
    @Column(name = "numero")
    private String numero;
    @Column(name = "desde")
    @Temporal(TemporalType.DATE)
    private Date desde;
    @Column(name = "hasta")
    @Temporal(TemporalType.DATE)
    private Date hasta;
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
    @JoinColumn(name = "id_sst_documento_tercero", referencedColumnName = "id_sst_documento_tercero")
    @ManyToOne(fetch = FetchType.LAZY)
    private SstDocumentoTercero idSstDocumentoTercero;
    @JoinColumn(name = "id_sst_empresa_visitante", referencedColumnName = "id_sst_empresa_visitante")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SstEmpresaVisitante idSstEmpresaVisitante;

    public SstEmpresaVisitanteDocs() {
    }

    public SstEmpresaVisitanteDocs(Integer idSstEmpresaVisitanteDocs) {
        this.idSstEmpresaVisitanteDocs = idSstEmpresaVisitanteDocs;
    }

    public Integer getIdSstEmpresaVisitanteDocs() {
        return idSstEmpresaVisitanteDocs;
    }

    public void setIdSstEmpresaVisitanteDocs(Integer idSstEmpresaVisitanteDocs) {
        this.idSstEmpresaVisitanteDocs = idSstEmpresaVisitanteDocs;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
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

    public SstDocumentoTercero getIdSstDocumentoTercero() {
        return idSstDocumentoTercero;
    }

    public void setIdSstDocumentoTercero(SstDocumentoTercero idSstDocumentoTercero) {
        this.idSstDocumentoTercero = idSstDocumentoTercero;
    }

    public SstEmpresaVisitante getIdSstEmpresaVisitante() {
        return idSstEmpresaVisitante;
    }

    public void setIdSstEmpresaVisitante(SstEmpresaVisitante idSstEmpresaVisitante) {
        this.idSstEmpresaVisitante = idSstEmpresaVisitante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSstEmpresaVisitanteDocs != null ? idSstEmpresaVisitanteDocs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SstEmpresaVisitanteDocs)) {
            return false;
        }
        SstEmpresaVisitanteDocs other = (SstEmpresaVisitanteDocs) object;
        if ((this.idSstEmpresaVisitanteDocs == null && other.idSstEmpresaVisitanteDocs != null) || (this.idSstEmpresaVisitanteDocs != null && !this.idSstEmpresaVisitanteDocs.equals(other.idSstEmpresaVisitanteDocs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.SstEmpresaVisitanteDocs[ idSstEmpresaVisitanteDocs=" + idSstEmpresaVisitanteDocs + " ]";
    }

}
