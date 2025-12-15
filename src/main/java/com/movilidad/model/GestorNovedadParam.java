/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Ballestas
 */
@Entity
@Table(name = "gestor_novedad_param")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GestorNovedadParam.findAll", query = "SELECT g FROM GestorNovedadParam g"),
    @NamedQuery(name = "GestorNovedadParam.findByIdGestorNovedadParam", query = "SELECT g FROM GestorNovedadParam g WHERE g.idGestorNovedadParam = :idGestorNovedadParam"),
    @NamedQuery(name = "GestorNovedadParam.findByTxt", query = "SELECT g FROM GestorNovedadParam g WHERE g.txt = :txt")})
public class GestorNovedadParam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gestor_novedad_param")
    private Integer idGestorNovedadParam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "txt")
    private String txt;
    @OneToMany(mappedBy = "idGestorNovedadParam", fetch = FetchType.LAZY)
    private List<GestorNovParamDet> gestorNovParamDetList;

    public GestorNovedadParam() {
    }

    public GestorNovedadParam(Integer idGestorNovedadParam) {
        this.idGestorNovedadParam = idGestorNovedadParam;
    }

    public GestorNovedadParam(Integer idGestorNovedadParam, String txt) {
        this.idGestorNovedadParam = idGestorNovedadParam;
        this.txt = txt;
    }

    public Integer getIdGestorNovedadParam() {
        return idGestorNovedadParam;
    }

    public void setIdGestorNovedadParam(Integer idGestorNovedadParam) {
        this.idGestorNovedadParam = idGestorNovedadParam;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    @XmlTransient
    public List<GestorNovParamDet> getGestorNovParamDetList() {
        return gestorNovParamDetList;
    }

    public void setGestorNovParamDetList(List<GestorNovParamDet> gestorNovParamDetList) {
        this.gestorNovParamDetList = gestorNovParamDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGestorNovedadParam != null ? idGestorNovedadParam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GestorNovedadParam)) {
            return false;
        }
        GestorNovedadParam other = (GestorNovedadParam) object;
        if ((this.idGestorNovedadParam == null && other.idGestorNovedadParam != null) || (this.idGestorNovedadParam != null && !this.idGestorNovedadParam.equals(other.idGestorNovedadParam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movilidad.model.GestorNovedadParam[ idGestorNovedadParam=" + idGestorNovedadParam + " ]";
    }
    
}
