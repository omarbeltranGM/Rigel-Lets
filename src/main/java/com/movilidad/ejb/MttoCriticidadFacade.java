/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.MttoCriticidad;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author solucionesit
 */
@Stateless
public class MttoCriticidadFacade extends AbstractFacade<MttoCriticidad> implements MttoCriticidadFacadeLocal {
    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MttoCriticidadFacade() {
        super(MttoCriticidad.class);
    }
    
}
