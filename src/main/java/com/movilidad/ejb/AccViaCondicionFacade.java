/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AccViaCondicion;
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
public class AccViaCondicionFacade extends AbstractFacade<AccViaCondicion> implements AccViaCondicionFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccViaCondicionFacade() {
        super(AccViaCondicion.class);
    }

    @Override
    public List<AccViaCondicion> estadoReg() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM acc_via_condicion WHERE estado_reg = 0", AccViaCondicion.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en Facade Via Condición");
            return null;
        }
    }

}
