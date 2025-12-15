package com.movilidad.model.planificacion_recursos;

import com.movilidad.model.GopUnidadFuncional;
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
import jakarta.persistence.Lob;
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
 * Clase que permite la iteracción del sistema con la tabla pla_recu_grupo_vacaciones que corresponde 
 * al módulo 'Planificación de recursos'
 * @author Omar Beltrán
 */
@Entity
@Table(name = "pla_recu_grupo_vacaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlaRecuGrupoVacaciones.findAll", query = "SELECT i FROM PlaRecuGrupoVacaciones i WHERE i.estadoReg != 0"),
    @NamedQuery(name = "PlaRecuGrupoVacaciones.findByIdGrupoVacaciones", query = "SELECT i FROM PlaRecuGrupoVacaciones i WHERE i.idPlaRecuGrupoVacaciones = :idPlaRecuGrupoVacaciones"),
    @NamedQuery(name = "PlaRecuGrupoVacaciones.findByGrupo", query = "SELECT i FROM PlaRecuGrupoVacaciones i WHERE i.grupo = :grupo"),
    @NamedQuery(name = "PlaRecuGrupoVacaciones.findByUserCreado", query = "SELECT i FROM PlaRecuGrupoVacaciones i WHERE i.usernameCreate = :usernameCreate"),
    @NamedQuery(name = "PlaRecuGrupoVacaciones.findByUserModificado", query = "SELECT i FROM PlaRecuGrupoVacaciones i WHERE i.usernameEdit = :usernameEdit"),
    @NamedQuery(name = "PlaRecuGrupoVacaciones.findByEstadoReg", query = "SELECT i FROM PlaRecuGrupoVacaciones i WHERE i.estadoReg = :estadoReg")})
/**
 *
 * @author Omar.beltran
 */
public class PlaRecuGrupoVacaciones implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pla_recu_grupo_vacaciones")
    private Integer idPlaRecuGrupoVacaciones;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "grupo")
    private String grupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "cupo")
    private Integer cupo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
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
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GopUnidadFuncional idGopUnidadFuncional;

    public Integer getIdPlaRecuGrupoVacaciones() {
        return idPlaRecuGrupoVacaciones;
    }

    public void setIdPlaRecuGrupoVacaciones(Integer idPlaRecuGrupoVacaciones) {
        this.idPlaRecuGrupoVacaciones = idPlaRecuGrupoVacaciones;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getCupo() {
        return cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
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

    public GopUnidadFuncional getIdGopUnidadFuncional() {
        return idGopUnidadFuncional;
    }

    public void setIdGopUnidadFuncional(GopUnidadFuncional idGopUnidadFuncional) {
        this.idGopUnidadFuncional = idGopUnidadFuncional;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
