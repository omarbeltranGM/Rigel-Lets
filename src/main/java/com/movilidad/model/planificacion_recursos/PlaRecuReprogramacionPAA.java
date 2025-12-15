package com.movilidad.model.planificacion_recursos;

import com.movilidad.model.Empleado;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Permite hacer persistencia con la tabla formación y desarrollo entrega de operadores
 * @author Omar.beltran
 */
@Entity
@Table(name = "pla_recu_reprogramacion_paa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlaRecuReprogramacionPAA.findAll", query = "SELECT i FROM PlaRecuReprogramacionPAA i"),
    @NamedQuery(name = "PlaRecuReprogramacionPAA.findByIdReprogramacionPAA", query = "SELECT i FROM PlaRecuReprogramacionPAA i WHERE i.idPlaRecuReprogramacionPAA = :idPlaRecuReprogramacionPAA"),
    @NamedQuery(name = "PlaRecuReprogramacionPAA.findByCreado", query = "SELECT i FROM PlaRecuReprogramacionPAA i WHERE i.creado = :creado"),
    @NamedQuery(name = "PlaRecuReprogramacionPAA.findByModificado", query = "SELECT i FROM PlaRecuReprogramacionPAA i WHERE i.modificado = :modificado"),
    @NamedQuery(name = "PlaRecuReprogramacionPAA.findByEstadoReg", query = "SELECT i FROM PlaRecuReprogramacionPAA i WHERE i.estadoReg = :estadoReg")})

public class PlaRecuReprogramacionPAA implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pla_recu_reprogramacion_paa")
    private Integer idPlaRecuReprogramacionPAA;
    @JoinColumn(name = "id_pla_recu_modalidad", referencedColumnName = "id_pla_recu_modalidad")
    @ManyToOne(fetch = FetchType.LAZY)
    private PlaRecuModalidad idPlaRecuModalidad;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado empleado; // se emplea para obtiener código TM, cédula, nombres, apellidos, cargo
    @Column(name = "lunes")
    private Integer lunes;
    @Column(name = "martes")
    private Integer martes;
    @Column(name = "miercoles")
    private Integer miercoles;
    @Column(name = "jueves")
    private Integer jueves;
    @Column(name = "viernes")
    private Integer viernes;
    @Column(name = "observaciones")
    private String observaciones;
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

    public Integer getIdEjecucion() {
        return idPlaRecuReprogramacionPAA;
    }

    public void setIdEjecucion(Integer idPlaRecuReprogramacionPAA) {
        this.idPlaRecuReprogramacionPAA = idPlaRecuReprogramacionPAA;
    }

    public PlaRecuModalidad getIdPlaRecuModalidad() {
        return idPlaRecuModalidad;
    }

    public void setIdPlaRecuModalidad(PlaRecuModalidad idPlaRecuModalidad) {
        this.idPlaRecuModalidad = idPlaRecuModalidad;
    }

    public Integer getLunes() {
        return lunes;
    }

    public void setLunes(Integer lunes) {
        this.lunes = lunes;
    }

    public Integer getMartes() {
        return martes;
    }

    public void setMartes(Integer martes) {
        this.martes = martes;
    }

    public Integer getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(Integer miercoles) {
        this.miercoles = miercoles;
    }

    public Integer getJueves() {
        return jueves;
    }

    public void setJueves(Integer jueves) {
        this.jueves = jueves;
    }

    public Integer getViernes() {
        return viernes;
    }

    public void setViernes(Integer viernes) {
        this.viernes = viernes;
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

    public GopUnidadFuncional getIdGopUnidadFuncional() {
        return idGopUnidadFuncional;
    }

    public void setIdGopUnidadFuncional(GopUnidadFuncional idGopUnidadFuncional) {
        this.idGopUnidadFuncional = idGopUnidadFuncional;
    }

    public Integer getIdPlaRecuReprogramacionPAA() {
        return idPlaRecuReprogramacionPAA;
    }

    public void setIdPlaRecuReprogramacionPAA(Integer idPlaRecuReprogramacionPAA) {
        this.idPlaRecuReprogramacionPAA = idPlaRecuReprogramacionPAA;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaRecuReprogramacionPAA)) {
            return false;
        }
        PlaRecuReprogramacionPAA other = (PlaRecuReprogramacionPAA) object;
        return !((this.idPlaRecuReprogramacionPAA == null && other.idPlaRecuReprogramacionPAA != null) || (this.idPlaRecuReprogramacionPAA != null && 
                !this.idPlaRecuReprogramacionPAA.equals(other.idPlaRecuReprogramacionPAA)));
    }

    @Override
    public String toString() {
        return "com.movilidad.model.planificacion_recursos.PlaRecuReprogramacionPAA[ idPlaRecuReprogramacionPAA=" + idPlaRecuReprogramacionPAA + " ]";
    }
    
}
