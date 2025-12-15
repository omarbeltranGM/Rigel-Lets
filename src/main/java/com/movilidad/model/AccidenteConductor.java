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
import jakarta.persistence.Lob;
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
 * @author HP
 */
@Entity
@Table(name = "accidente_conductor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccidenteConductor.findAll", query = "SELECT a FROM AccidenteConductor a")
    , @NamedQuery(name = "AccidenteConductor.findByIdAccidenteConductor", query = "SELECT a FROM AccidenteConductor a WHERE a.idAccidenteConductor = :idAccidenteConductor")
    , @NamedQuery(name = "AccidenteConductor.findByCedula", query = "SELECT a FROM AccidenteConductor a WHERE a.cedula = :cedula")
    , @NamedQuery(name = "AccidenteConductor.findByNombres", query = "SELECT a FROM AccidenteConductor a WHERE a.nombres = :nombres")
    , @NamedQuery(name = "AccidenteConductor.findByApellidos", query = "SELECT a FROM AccidenteConductor a WHERE a.apellidos = :apellidos")
    , @NamedQuery(name = "AccidenteConductor.findByTelefono", query = "SELECT a FROM AccidenteConductor a WHERE a.telefono = :telefono")
    , @NamedQuery(name = "AccidenteConductor.findByCelular", query = "SELECT a FROM AccidenteConductor a WHERE a.celular = :celular")
    , @NamedQuery(name = "AccidenteConductor.findByDireccion", query = "SELECT a FROM AccidenteConductor a WHERE a.direccion = :direccion")
    , @NamedQuery(name = "AccidenteConductor.findByEstrato", query = "SELECT a FROM AccidenteConductor a WHERE a.estrato = :estrato")
    , @NamedQuery(name = "AccidenteConductor.findByFechaNcto", query = "SELECT a FROM AccidenteConductor a WHERE a.fechaNcto = :fechaNcto")
    , @NamedQuery(name = "AccidenteConductor.findByGenero", query = "SELECT a FROM AccidenteConductor a WHERE a.genero = :genero")
    , @NamedQuery(name = "AccidenteConductor.findByCentroAsistencial", query = "SELECT a FROM AccidenteConductor a WHERE a.centroAsistencial = :centroAsistencial")
    , @NamedQuery(name = "AccidenteConductor.findByVictima", query = "SELECT a FROM AccidenteConductor a WHERE a.victima = :victima")
    , @NamedQuery(name = "AccidenteConductor.findByUsername", query = "SELECT a FROM AccidenteConductor a WHERE a.username = :username")
    , @NamedQuery(name = "AccidenteConductor.findByCreado", query = "SELECT a FROM AccidenteConductor a WHERE a.creado = :creado")
    , @NamedQuery(name = "AccidenteConductor.findByModificado", query = "SELECT a FROM AccidenteConductor a WHERE a.modificado = :modificado")
    , @NamedQuery(name = "AccidenteConductor.findByEstadoReg", query = "SELECT a FROM AccidenteConductor a WHERE a.estadoReg = :estadoReg")})
public class AccidenteConductor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_accidente_conductor")
    private Integer idAccidenteConductor;
    @Size(max = 15)
    @Column(name = "cedula")
    private String cedula;
    @Size(max = 150)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 150)
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 45)
    @Column(name = "celular")
    private String celular;
    @Size(max = 150)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "estrato")
    private Integer estrato;
    @Column(name = "fecha_ncto")
    @Temporal(TemporalType.DATE)
    private Date fechaNcto;
    @Column(name = "genero")
    private Character genero;
    @Size(max = 150)
    @Column(name = "centro_asistencial")
    private String centroAsistencial;
    @Column(name = "victima")
    private Integer victima;
    @Lob
    @Size(max = 65535)
    @Column(name = "version")
    private String version;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacion")
    private String observacion;
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
    @JoinColumn(name = "id_acc_condicion", referencedColumnName = "id_acc_condicion")
    @ManyToOne(fetch = FetchType.LAZY)
    private AccCondicion idAccCondicion;
    @JoinColumn(name = "id_accidente", referencedColumnName = "id_accidente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Accidente idAccidente;
    @JoinColumn(name = "id_accidente_vehiculo", referencedColumnName = "id_accidente_vehiculo")
    @ManyToOne(fetch = FetchType.LAZY)
    private AccidenteVehiculo idAccidenteVehiculo;

    public AccidenteConductor() {
    }

    public AccidenteConductor(Integer idAccidenteConductor) {
        this.idAccidenteConductor = idAccidenteConductor;
    }

    public Integer getIdAccidenteConductor() {
        return idAccidenteConductor;
    }

    public void setIdAccidenteConductor(Integer idAccidenteConductor) {
        this.idAccidenteConductor = idAccidenteConductor;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEstrato() {
        return estrato;
    }

    public void setEstrato(Integer estrato) {
        this.estrato = estrato;
    }

    public Date getFechaNcto() {
        return fechaNcto;
    }

    public void setFechaNcto(Date fechaNcto) {
        this.fechaNcto = fechaNcto;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getCentroAsistencial() {
        return centroAsistencial;
    }

    public void setCentroAsistencial(String centroAsistencial) {
        this.centroAsistencial = centroAsistencial;
    }

    public Integer getVictima() {
        return victima;
    }

    public void setVictima(Integer victima) {
        this.victima = victima;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public AccCondicion getIdAccCondicion() {
        return idAccCondicion;
    }

    public void setIdAccCondicion(AccCondicion idAccCondicion) {
        this.idAccCondicion = idAccCondicion;
    }

    public Accidente getIdAccidente() {
        return idAccidente;
    }

    public void setIdAccidente(Accidente idAccidente) {
        this.idAccidente = idAccidente;
    }

    public AccidenteVehiculo getIdAccidenteVehiculo() {
        return idAccidenteVehiculo;
    }

    public void setIdAccidenteVehiculo(AccidenteVehiculo idAccidenteVehiculo) {
        this.idAccidenteVehiculo = idAccidenteVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccidenteConductor != null ? idAccidenteConductor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccidenteConductor)) {
            return false;
        }
        AccidenteConductor other = (AccidenteConductor) object;
        if ((this.idAccidenteConductor == null && other.idAccidenteConductor != null) || (this.idAccidenteConductor != null && !this.idAccidenteConductor.equals(other.idAccidenteConductor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.AccidenteConductor[ idAccidenteConductor=" + idAccidenteConductor + " ]";
    }
    
}
