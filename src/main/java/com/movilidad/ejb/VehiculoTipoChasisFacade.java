/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.VehiculoTipoChasis;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author USUARIO
 */
@Stateless
public class VehiculoTipoChasisFacade extends AbstractFacade<VehiculoTipoChasis> implements VehiculoTipoChasisFacadeLocal {
    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoTipoChasisFacade() {
        super(VehiculoTipoChasis.class);
    }
    
}
