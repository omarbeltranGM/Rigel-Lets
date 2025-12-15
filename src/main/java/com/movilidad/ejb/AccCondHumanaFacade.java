/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AccCondHumana;
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
public class AccCondHumanaFacade extends AbstractFacade<AccCondHumana> implements AccCondHumanaFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccCondHumanaFacade() {
        super(AccCondHumana.class);
    }

    @Override
    public List<AccCondHumana> estadoReg() {
        try {
            Query q = em.createNativeQuery("Select * from acc_cond_humana where estado_reg = 0", AccCondHumana.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en Facade AccCondHumana");
            return null;
        }
    }

}
