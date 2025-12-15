package com.movilidad.model;

import com.movilidad.model.Empleado;
import com.movilidad.model.GopUnidadFuncional;
import com.movilidad.model.Vehiculo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "chk_diario")
@XmlRootElement
public class ChkDiario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_chk_diario")
    private Integer idChkDiario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    //
    @Column(name = "username")
    private String username;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificado;
    @Basic(optional = false)
    @Column(name = "estado_reg")
    private Integer estadoReg;

    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehiculo idVehiculo;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado idEmpleado;
    @JoinColumn(name = "id_gop_unidad_funcional", referencedColumnName = "id_gop_unidad_funcional")
    @ManyToOne(fetch = FetchType.LAZY)
    private GopUnidadFuncional idGopUnidadFuncional;

    //
    @OneToMany(mappedBy = "idChkDiario", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<ChkDiarioDet> chkDiarioDetList;

    public ChkDiario() {
    }

    public ChkDiario(Integer idChkDiario) {
        this.idChkDiario = idChkDiario;
    }

    public Integer getIdChkDiario() {
        return idChkDiario;
    }

    public void setIdChkDiario(Integer idChkDiario) {
        this.idChkDiario = idChkDiario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Vehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculo idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public GopUnidadFuncional getIdGopUnidadFuncional() {
        return idGopUnidadFuncional;
    }

    public void setIdGopUnidadFuncional(GopUnidadFuncional idGopUnidadFuncional) {
        this.idGopUnidadFuncional = idGopUnidadFuncional;
    }

    @XmlTransient
    public List<ChkDiarioDet> getChkDiarioDetList() {
        return chkDiarioDetList;
    }

    public void setChkDiarioDetList(List<ChkDiarioDet> chkDiarioDetList) {
        this.chkDiarioDetList = chkDiarioDetList;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChkDiario other = (ChkDiario) obj;
        if (!Objects.equals(this.idChkDiario, other.idChkDiario)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idChkDiario);
        return hash;
    }

    @Override
    public String toString() {
        return "ChkDiario{" + "idChkDiario=" + idChkDiario + ", fecha=" + fecha + ", username=" + username + ", creado=" + creado + ", modificado=" + modificado + ", estadoReg=" + estadoReg + ", idVehiculo=" + idVehiculo + ", idEmpleado=" + idEmpleado + ", idGopUnidadFuncional=" + idGopUnidadFuncional + ", chkDiarioDetList=" + chkDiarioDetList + '}';
    }

}
