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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "pm_grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmGrupo.findAll", query = "SELECT p FROM PmGrupo p")
    , @NamedQuery(name = "PmGrupo.findByIdPmGrupo", query = "SELECT p FROM PmGrupo p WHERE p.idPmGrupo = :idPmGrupo")
    , @NamedQuery(name = "PmGrupo.findByNombreGrupo", query = "SELECT p FROM PmGrupo p WHERE p.nombreGrupo = :nombreGrupo")
    , @NamedQuery(name = "PmGrupo.findByDescripcion", query = "SELECT p FROM PmGrupo p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "PmGrupo.findByUsername", query = "SELECT p FROM PmGrupo p WHERE p.username = :username")
    , @NamedQuery(name = "PmGrupo.findByCreado", query = "SELECT p FROM PmGrupo p WHERE p.creado = :creado")
    , @NamedQuery(name = "PmGrupo.findByModificado", query = "SELECT p FROM PmGrupo p WHERE p.modificado = :modificado")
    , @NamedQuery(name = "PmGrupo.findByEstadoReg", query = "SELECT p FROM PmGrupo p WHERE p.estadoReg = :estadoReg")})
public class PmGrupo implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupo", fetch = FetchType.LAZY)
    private List<TblLiquidacionGrupoMes> tblLiquidacionGrupoMesList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pm_grupo")
    private Integer idPmGrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_grupo")
    private String nombreGrupo;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
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
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado idEmpleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupo", fetch = FetchType.LAZY)
    private List<PmGrupoDetalle> pmGrupoDetalleList;

    @JoinColumn(name = "id_gop_unidad_funcional", referencedColumnName = "id_gop_unidad_funcional")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GopUnidadFuncional idGopUnidadFuncional;

    public PmGrupo() {
    }

    public PmGrupo(Integer idPmGrupo) {
        this.idPmGrupo = idPmGrupo;
    }

    public PmGrupo(Integer idPmGrupo, String nombreGrupo, String username, Date creado, int estadoReg) {
        this.idPmGrupo = idPmGrupo;
        this.nombreGrupo = nombreGrupo;
        this.username = username;
        this.creado = creado;
        this.estadoReg = estadoReg;
    }

    public Integer getIdPmGrupo() {
        return idPmGrupo;
    }

    public void setIdPmGrupo(Integer idPmGrupo) {
        this.idPmGrupo = idPmGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
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

    public int getEstadoReg() {
        return estadoReg;
    }

    public void setEstadoReg(int estadoReg) {
        this.estadoReg = estadoReg;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @XmlTransient
    public List<PmGrupoDetalle> getPmGrupoDetalleList() {
        return pmGrupoDetalleList;
    }

    public void setPmGrupoDetalleList(List<PmGrupoDetalle> pmGrupoDetalleList) {
        this.pmGrupoDetalleList = pmGrupoDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPmGrupo != null ? idPmGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmGrupo)) {
            return false;
        }
        PmGrupo other = (PmGrupo) object;
        if ((this.idPmGrupo == null && other.idPmGrupo != null) || (this.idPmGrupo != null && !this.idPmGrupo.equals(other.idPmGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.PmGrupo[ idPmGrupo=" + idPmGrupo + " ]";
    }

    @XmlTransient
    public List<TblLiquidacionGrupoMes> getTblLiquidacionGrupoMesList() {
        return tblLiquidacionGrupoMesList;
    }

    public void setTblLiquidacionGrupoMesList(List<TblLiquidacionGrupoMes> tblLiquidacionGrupoMesList) {
        this.tblLiquidacionGrupoMesList = tblLiquidacionGrupoMesList;
    }

    public GopUnidadFuncional getIdGopUnidadFuncional() {
        return idGopUnidadFuncional;
    }

    public void setIdGopUnidadFuncional(GopUnidadFuncional idGopUnidadFuncional) {
        this.idGopUnidadFuncional = idGopUnidadFuncional;
    }

}
