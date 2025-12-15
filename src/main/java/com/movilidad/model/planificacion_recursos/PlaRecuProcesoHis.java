package com.movilidad.model.planificacion_recursos;

import com.movilidad.model.GopUnidadFuncional;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que permite la iteracción del sistema con la tabla pla_recu_proceso_his que corresponde 'Planificación de recursos'
 * @author Luis Lancheros
 */
@Entity
@Table(name = "pla_recu_proceso_his")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlaRecuProcesoHis.findAll", query = "SELECT i FROM PlaRecuProcesoHis i"),
    @NamedQuery(name = "PlaRecuProcesoHis.findByIdProcesoHis", query = "SELECT i FROM PlaRecuProcesoHis i WHERE i.idPlaRecuProcesoHis = :idPlaRecuProcesoHis"),
    @NamedQuery(name = "PlaRecuProcesoHis.findByDescripcion", query = "SELECT i FROM PlaRecuProcesoHis i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "PlaRecuProcesoHis.findByCreado", query = "SELECT i FROM PlaRecuProcesoHis i WHERE i.creado = :creado"),
    @NamedQuery(name = "PlaRecuProcesoHis.findByModificado", query = "SELECT i FROM PlaRecuProcesoHis i WHERE i.modificado = :modificado"),
    @NamedQuery(name = "PlaRecuProcesoHis.findByEstadoReg", query = "SELECT i FROM PlaRecuProcesoHis i WHERE i.estadoReg = :estadoReg")})

public class PlaRecuProcesoHis implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pla_recu_proceso_his")
    private Integer idPlaRecuProcesoHis;
    @JoinColumn(name = "id_pla_recu_proceso_pro_det", referencedColumnName = "id_pla_recu_proceso_pro_det")
    @ManyToOne(fetch = FetchType.LAZY)
    private PlaRecuProcesoProDet idPlaRecuProcesoProDet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "is_checked")
    private Boolean isChecked;
    @Column(name = "duracion")
    private Integer duracion;
    @Size(max = 15)
    @Column(name = "username_create")
    private String usernameCreate;
    @Size(max = 15)
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
    @JoinColumn(name = "id_gop_unidad_funcional", referencedColumnName = "id_gop_unidad_funcional")
    @ManyToOne(fetch = FetchType.EAGER)
    private GopUnidadFuncional idGopUnidadFuncional;
    
    public PlaRecuProcesoHis() {
    }

    public Integer getIdPlaRecuProcesoHis() {
        return idPlaRecuProcesoHis;
    }

    public void setIdPlaRecuProcesoHis(Integer idPlaRecuProcesoHis) {
        this.idPlaRecuProcesoHis = idPlaRecuProcesoHis;
    }

    public PlaRecuProcesoProDet getIdPlaRecuProcesoProDet() {
        return idPlaRecuProcesoProDet;
    }

    public void setIdPlaRecuProcesoProDet(PlaRecuProcesoProDet idPlaRecuProcesoProDet) {
        this.idPlaRecuProcesoProDet = idPlaRecuProcesoProDet;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
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

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public GopUnidadFuncional getIdGopUnidadFuncional() {
        return idGopUnidadFuncional;
    }

    public void setIdGopUnidadFuncional(GopUnidadFuncional idGopUnidadFuncional) {
        this.idGopUnidadFuncional = idGopUnidadFuncional;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlaRecuProcesoHis != null ? idPlaRecuProcesoHis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaRecuProcesoHis)) {
            return false;
        }
        PlaRecuProcesoHis other = (PlaRecuProcesoHis) object;
        return !((this.idPlaRecuProcesoHis == null && other.idPlaRecuProcesoHis != null) || (this.idPlaRecuProcesoHis != null && 
                !this.idPlaRecuProcesoHis.equals(other.idPlaRecuProcesoHis)));
    }

    @Override
    public String toString() {
        return "com.movilidad.model.planificacion_recursos.procesoHis[ idPlaRecuProcesoHis=" + idPlaRecuProcesoHis + " ]";
    }

    public Object stream() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}