package com.movilidad.model.planificacion_recursos;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Clase que permite la iteracción del sistema con la tabla pla_recu_motivo que corresponde 
 a 'PlaRecuMotivo' del módulo 'Planificación de recursos'
 * @author Omar Beltrán
 */
@Entity
@Table(name = "pla_recu_motivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlaRecuMotivo.findAll", query = "SELECT i FROM PlaRecuMotivo i"),
    @NamedQuery(name = "PlaRecuMotivo.findByIdMotivo", query = "SELECT i FROM PlaRecuMotivo i WHERE i.idPlaRecuMotivo = :idPlaRecuMotivo"),
    @NamedQuery(name = "PlaRecuMotivo.findByDescripcion", query = "SELECT i FROM PlaRecuMotivo i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "PlaRecuMotivo.findByMotivo", query = "SELECT i FROM PlaRecuMotivo i WHERE i.motivo = :motivo"),
    @NamedQuery(name = "PlaRecuMotivo.findByCreado", query = "SELECT i FROM PlaRecuMotivo i WHERE i.creado = :creado"),
    @NamedQuery(name = "PlaRecuMotivo.findByModificado", query = "SELECT i FROM PlaRecuMotivo i WHERE i.modificado = :modificado"),
    @NamedQuery(name = "PlaRecuMotivo.findByEstadoReg", query = "SELECT i FROM PlaRecuMotivo i WHERE i.estadoReg = :estadoReg")})

public class PlaRecuMotivo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pla_recu_motivo")
    private Integer idPlaRecuMotivo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "motivo")
    private String motivo;
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
    
    public PlaRecuMotivo() {
    }

    public Integer getIdPlaRecuMotivo() {
        return idPlaRecuMotivo;
    }

    public void setIdPlaRecuMotivo(Integer idPlaRecuMotivo) {
        this.idPlaRecuMotivo = idPlaRecuMotivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlaRecuMotivo != null ? idPlaRecuMotivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaRecuMotivo)) {
            return false;
        }
        PlaRecuMotivo other = (PlaRecuMotivo) object;
        return !((this.idPlaRecuMotivo == null && other.idPlaRecuMotivo != null) || (this.idPlaRecuMotivo != null && 
                !this.idPlaRecuMotivo.equals(other.idPlaRecuMotivo)));
    }

    @Override
    public String toString() {
        return "com.movilidad.model.planificacion_recursos.Motivo[ idPlaRecuMotivo=" + idPlaRecuMotivo + " ]";
    }
    
}