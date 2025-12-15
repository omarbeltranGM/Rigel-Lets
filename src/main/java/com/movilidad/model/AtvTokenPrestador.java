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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "atv_token_prestador")
@XmlRootElement
public class AtvTokenPrestador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_atv_token_prestador")
    private Integer idAtvTokenPrestador;
    @Column(name = "token")
    private String token;
    @Column(name = "activo")
    private Integer activo;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    
    @JoinColumn(name = "id_atv_prestador", referencedColumnName = "id_atv_prestador")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AtvPrestador idAtvPrestador;

    public AtvTokenPrestador() {
    }

    public Integer getIdAtvTokenPrestador() {
        return idAtvTokenPrestador;
    }

    public void setIdAtvTokenPrestador(Integer idAtvTokenPrestador) {
        this.idAtvTokenPrestador = idAtvTokenPrestador;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public AtvPrestador getIdAtvPrestador() {
        return idAtvPrestador;
    }

    public void setIdAtvPrestador(AtvPrestador idAtvPrestador) {
        this.idAtvPrestador = idAtvPrestador;
    }

    
}
