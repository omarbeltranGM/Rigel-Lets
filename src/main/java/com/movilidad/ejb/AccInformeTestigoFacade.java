/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AccInformeTestigo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class AccInformeTestigoFacade extends AbstractFacade<AccInformeTestigo> implements AccInformeTestigoFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccInformeTestigoFacade() {
        super(AccInformeTestigo.class);
    }
    
}
