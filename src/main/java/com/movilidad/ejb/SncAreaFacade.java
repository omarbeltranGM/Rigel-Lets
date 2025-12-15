/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.SncArea;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author Pc
 */
@Stateless
public class SncAreaFacade extends AbstractFacade<SncArea> implements SncAreaFacadeLocal {
    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SncAreaFacade() {
        super(SncArea.class);
    }
    @Override
    public List <SncArea> findallEst () {
        
        try {
            Query q = em.createQuery("SELECT m FROM SncArea m WHERE m.estadoReg = :estadoReg", SncArea.class)
                    .setParameter("estadoReg", 0);
            return q.getResultList();
        }catch (Exception e) {
        return null;
        }
}
}