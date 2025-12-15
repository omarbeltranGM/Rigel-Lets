
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
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "version_tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VersionTipo.findAll", query = "SELECT s FROM VersionTipo s"),
    @NamedQuery(name = "VersionTipo.findByIdVersionTipo", query = "SELECT s FROM VersionTipo s WHERE s.idVersionTipo = :idVersionTipo"),
    @NamedQuery(name = "VersionTipo.findByNombreVersionTipo", query = "SELECT s FROM VersionTipo s WHERE s.nombreVersionTipo = :nombreVersionTipo"),
    @NamedQuery(name = "VersionTipo.findByUsernameCreate", query = "SELECT s FROM VersionRigel s WHERE s.usernameCreate = :usernameCreate"),
    @NamedQuery(name = "VersionTipo.findByUsernameEdit", query = "SELECT s FROM VersionRigel s WHERE s.usernameEdit = :usernameEdit"),
    @NamedQuery(name = "VersionTipo.findByCreado", query = "SELECT s FROM VersionTipo s WHERE s.creado = :creado"),
    @NamedQuery(name = "VersionTipo.findByModificado", query = "SELECT s FROM VersionTipo s WHERE s.modificado = :modificado"),
    @NamedQuery(name = "VersionTipo.findByEstadoReg", query = "SELECT s FROM VersionTipo s WHERE s.estadoReg = :estadoReg")})

public class VersionTipo implements Serializable {    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_version_tipo")
    private Integer idVersionTipo;
    @Size(max = 20)
    @Column(name = "nombre_version_tipo")
    private String nombreVersionTipo;
    @Size(max = 20)
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
    private Integer estadoReg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVersionTipo", fetch = FetchType.LAZY)
    private List<VersionRigel> versionRigelList;
    
    public VersionTipo() {
    }

    public Integer getIdVersionTipo() {
        return idVersionTipo;
    }

    public void setIdVersionTipo(Integer idVersionTipo) {
        this.idVersionTipo = idVersionTipo;
    }

    public String getNombreVersionTipo() {
        return nombreVersionTipo;
    }

    public void setNombreVersionTipo(String nombreVersionTipo) {
        this.nombreVersionTipo = nombreVersionTipo;
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
    
    @XmlTransient
    public List<VersionRigel> getVersionRigelList() {
        return versionRigelList;
    }
    
    public void setVersionRigelList(List<VersionRigel> VersionRigelList) {
        this.versionRigelList = VersionRigelList;
    }
    
}
