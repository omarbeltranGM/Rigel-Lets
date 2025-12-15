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
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Ballestas
 */
@Entity
@Table(name = "my_app_confirm_depot_entry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MyAppConfirmDepotEntry.findAll", query = "SELECT m FROM MyAppConfirmDepotEntry m"),
    @NamedQuery(name = "MyAppConfirmDepotEntry.findByIdMyAppConfirmDepotEntry", query = "SELECT m FROM MyAppConfirmDepotEntry m WHERE m.idMyAppConfirmDepotEntry = :idMyAppConfirmDepotEntry"),
    @NamedQuery(name = "MyAppConfirmDepotEntry.findByFechaHora", query = "SELECT m FROM MyAppConfirmDepotEntry m WHERE m.fechaHora = :fechaHora"),
    @NamedQuery(name = "MyAppConfirmDepotEntry.findByProcesado", query = "SELECT m FROM MyAppConfirmDepotEntry m WHERE m.procesado = :procesado"),
    @NamedQuery(name = "MyAppConfirmDepotEntry.findByCreado", query = "SELECT m FROM MyAppConfirmDepotEntry m WHERE m.creado = :creado"),
    @NamedQuery(name = "MyAppConfirmDepotEntry.findByModificado", query = "SELECT m FROM MyAppConfirmDepotEntry m WHERE m.modificado = :modificado"),
    @NamedQuery(name = "MyAppConfirmDepotEntry.findByEstadoReg", query = "SELECT m FROM MyAppConfirmDepotEntry m WHERE m.estadoReg = :estadoReg")})
public class MyAppConfirmDepotEntry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_my_app_confirm_depot_entry")
    private Integer idMyAppConfirmDepotEntry;
    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @Column(name = "procesado")
    private Integer procesado;
    @Column(name = "verbo")
    private String verbo;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificado;
    @Column(name = "estado_reg")
    private Integer estadoReg;
    @Column(name = "id_task")
    private Integer idTask;
    @Column(name = "tipo_tabla")
    private Integer tipoTabla;
    @JoinColumn(name = "id_prg_tc", referencedColumnName = "id_prg_tc")
    @ManyToOne(fetch = FetchType.LAZY)
    private PrgTc idPrgTc;

    public MyAppConfirmDepotEntry() {
    }

    public MyAppConfirmDepotEntry(Integer idMyAppConfirmDepotEntry) {
        this.idMyAppConfirmDepotEntry = idMyAppConfirmDepotEntry;
    }

    public Integer getIdMyAppConfirmDepotEntry() {
        return idMyAppConfirmDepotEntry;
    }

    public void setIdMyAppConfirmDepotEntry(Integer idMyAppConfirmDepotEntry) {
        this.idMyAppConfirmDepotEntry = idMyAppConfirmDepotEntry;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Integer getProcesado() {
        return procesado;
    }

    public void setProcesado(Integer procesado) {
        this.procesado = procesado;
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

    public Integer getIdTask() {
        return idTask;
    }

    public void setIdTask(Integer idTask) {
        this.idTask = idTask;
    }

    public PrgTc getIdPrgTc() {
        return idPrgTc;
    }

    public void setIdPrgTc(PrgTc idPrgTc) {
        this.idPrgTc = idPrgTc;
    }

    public String getVerbo() {
        return verbo;
    }

    public void setVerbo(String verbo) {
        this.verbo = verbo;
    }
    
    public Integer getTipoTabla() {
        return tipoTabla;
    }

    public void setTipoTabla(Integer tipoTabla) {
        this.tipoTabla = tipoTabla;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMyAppConfirmDepotEntry != null ? idMyAppConfirmDepotEntry.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MyAppConfirmDepotEntry)) {
            return false;
        }
        MyAppConfirmDepotEntry other = (MyAppConfirmDepotEntry) object;
        if ((this.idMyAppConfirmDepotEntry == null && other.idMyAppConfirmDepotEntry != null) || (this.idMyAppConfirmDepotEntry != null && !this.idMyAppConfirmDepotEntry.equals(other.idMyAppConfirmDepotEntry))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.MyAppConfirmDepotEntry[ idMyAppConfirmDepotEntry=" + idMyAppConfirmDepotEntry + " ]";
    }

}
