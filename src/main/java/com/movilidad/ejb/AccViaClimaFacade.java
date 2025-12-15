/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AccViaClima;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author HP
 */
@Stateless
public class AccViaClimaFacade extends AbstractFacade<AccViaClima> implements AccViaClimaFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccViaClimaFacade() {
        super(AccViaClima.class);
    }

    @Override
    public List<AccViaClima> estadoReg() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM acc_via_clima WHERE estado_reg = 0", AccViaClima.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en Facade Via Clima");
            return null;
        }
    }

}
