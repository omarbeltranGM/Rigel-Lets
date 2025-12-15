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
@Table(name = "vehiculo_componente_dano")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehiculoComponenteDano.findAll", query = "SELECT v FROM VehiculoComponenteDano v")
    , @NamedQuery(name = "VehiculoComponenteDano.findByIdVehiculoComponenteDano", query = "SELECT v FROM VehiculoComponenteDano v WHERE v.idVehiculoComponenteDano = :idVehiculoComponenteDano")
    , @NamedQuery(name = "VehiculoComponenteDano.findByUsername", query = "SELECT v FROM VehiculoComponenteDano v WHERE v.username = :username")
    , @NamedQuery(name = "VehiculoComponenteDano.findByCreado", query = "SELECT v FROM VehiculoComponenteDano v WHERE v.creado = :creado")
    , @NamedQuery(name = "VehiculoComponenteDano.findByModificado", query = "SELECT v FROM VehiculoComponenteDano v WHERE v.modificado = :modificado")
    , @NamedQuery(name = "VehiculoComponenteDano.findByEstadoReg", query = "SELECT v FROM VehiculoComponenteDano v WHERE v.estadoReg = :estadoReg")})
public class VehiculoComponenteDano implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo_componente_dano")
    private Integer idVehiculoComponenteDano;
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
    @JoinColumn(name = "id_vehiculo_componente_grupo", referencedColumnName = "id_vehiculo_componente_grupo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private VehiculoComponenteGrupo idVehiculoComponenteGrupo;
    @JoinColumn(name = "id_vehiculo_dano", referencedColumnName = "id_vehiculo_dano")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private VehiculoDano idVehiculoDano;
    @OneToMany(mappedBy = "idVehiculoComponenteDano", fetch = FetchType.LAZY)
    private List<NovedadDano> novedadDanoList;

    public VehiculoComponenteDano() {
    }

    public VehiculoComponenteDano(Integer idVehiculoComponenteDano) {
        this.idVehiculoComponenteDano = idVehiculoComponenteDano;
    }

    public VehiculoComponenteDano(Integer idVehiculoComponenteDano, String username, Date creado, int estadoReg) {
        this.idVehiculoComponenteDano = idVehiculoComponenteDano;
        this.username = username;
        this.creado = creado;
        this.estadoReg = estadoReg;
    }

    public Integer getIdVehiculoComponenteDano() {
        return idVehiculoComponenteDano;
    }

    public void setIdVehiculoComponenteDano(Integer idVehiculoComponenteDano) {
        this.idVehiculoComponenteDano = idVehiculoComponenteDano;
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

    public VehiculoComponenteGrupo getIdVehiculoComponenteGrupo() {
        return idVehiculoComponenteGrupo;
    }

    public void setIdVehiculoComponenteGrupo(VehiculoComponenteGrupo idVehiculoComponenteGrupo) {
        this.idVehiculoComponenteGrupo = idVehiculoComponenteGrupo;
    }

    public VehiculoDano getIdVehiculoDano() {
        return idVehiculoDano;
    }

    public void setIdVehiculoDano(VehiculoDano idVehiculoDano) {
        this.idVehiculoDano = idVehiculoDano;
    }

    @XmlTransient
    public List<NovedadDano> getNovedadDanoList() {
        return novedadDanoList;
    }

    public void setNovedadDanoList(List<NovedadDano> novedadDanoList) {
        this.novedadDanoList = novedadDanoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculoComponenteDano != null ? idVehiculoComponenteDano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculoComponenteDano)) {
            return false;
        }
        VehiculoComponenteDano other = (VehiculoComponenteDano) object;
        if ((this.idVehiculoComponenteDano == null && other.idVehiculoComponenteDano != null) || (this.idVehiculoComponenteDano != null && !this.idVehiculoComponenteDano.equals(other.idVehiculoComponenteDano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.VehiculoComponenteDano[ idVehiculoComponenteDano=" + idVehiculoComponenteDano + " ]";
    }
    
}
