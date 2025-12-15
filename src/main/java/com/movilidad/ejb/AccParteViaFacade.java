/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AccParteVia;
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
public class AccParteViaFacade extends AbstractFacade<AccParteVia> implements AccParteViaFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccParteViaFacade() {
        super(AccParteVia.class);
    }

    @Override
    public List<AccParteVia> estadoReg() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM acc_parte_via WHERE estado_reg = 0;", AccParteVia.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en Facade AccParteVia");
            return null;
        }
    }

}
