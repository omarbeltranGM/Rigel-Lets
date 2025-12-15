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
 * @author Andres
 */
@Entity
@Table(name = "version_rigel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VersionRigel.findAll", query = "SELECT s FROM VersionRigel s"),
    @NamedQuery(name = "VersionRigel.findByIdVersionRigel", query = "SELECT s FROM VersionRigel s WHERE s.idVersionRigel = :idVersionRigel"),
    @NamedQuery(name = "VersionRigel.findByNombreVersionRigel", query = "SELECT s FROM VersionRigel s WHERE s.idVersionTipo.nombreVersionTipo = :nombreVersionTipo"),
    @NamedQuery(name = "VersionRigel.findByFecha", query = "SELECT s FROM VersionRigel s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "VersionRigel.findByVersion", query = "SELECT s FROM VersionRigel s WHERE s.version = :version"),
    @NamedQuery(name = "VersionRigel.findByIdVersionTipo", query = "SELECT s FROM VersionRigel s WHERE s.idVersionTipo = :IdVersionTipo"),
    @NamedQuery(name = "VersionRigel.findByObservaciones", query = "SELECT s FROM VersionRigel s WHERE s.observaciones = :observaciones"),    
    @NamedQuery(name = "VersionRigel.findByUsernameCreate", query = "SELECT s FROM VersionRigel s WHERE s.usernameCreate = :usernameCreate"),
    @NamedQuery(name = "VersionRigel.findByUsernameEdit", query = "SELECT s FROM VersionRigel s WHERE s.usernameEdit = :usernameEdit"),
    @NamedQuery(name = "VersionRigel.findByCreado", query = "SELECT s FROM VersionRigel s WHERE s.creado = :creado"),
    @NamedQuery(name = "VersionRigel.findByModificado", query = "SELECT s FROM VersionRigel s WHERE s.modificado = :modificado"),
    @NamedQuery(name = "VersionRigel.findByEstadoReg", query = "SELECT s FROM VersionRigel s WHERE s.estadoReg = :estadoReg")})

public class VersionRigel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_version_rigel")    
    private Integer idVersionRigel;    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @NotNull
    @Size(max = 20)
    @Column(name = "version")
    private String version;     
    @Column(name = "observaciones")
    private String observaciones;  
    @Column(name = "username_create")
    private String usernameCreate;
    @Column(name = "username_edit")
    private String usernameEdit;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificado;
    @Column(name = "estado_reg")
    private Integer estadoReg = 0;//valor default
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_version_tipo", referencedColumnName = "id_version_tipo")
    private VersionTipo idVersionTipo;
    
    public VersionRigel() {
    }

    public VersionTipo getIdVersionTipo() {
        return idVersionTipo;
    }

    public void setIdVersionTipo(VersionTipo idVersionTipo) {
        this.idVersionTipo = idVersionTipo;
    }

    public Integer getIdVersionRigel() {
        return idVersionRigel;
    }

    public void setIdVersionRigel(Integer idVersionRigel) {
        this.idVersionRigel = idVersionRigel;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getUsernameCreate() {
        return usernameCreate;
    }

    public void setUsernameCreate(String usernameCreate) {
        this.usernameCreate = usernameCreate;
    }

    public String getUsernameEdit() {
        return usernameEdit;
    }

    public void setUsernameEdit(String usernameEdit) {
        this.usernameEdit = usernameEdit;
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
    
}
