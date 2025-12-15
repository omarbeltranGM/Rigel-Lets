/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.SstEsMatEqui;
import com.movilidad.model.SstMatEqui;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author Carlos Ballestas
 */
@Stateless
public class SstEsMatEquiFacade extends AbstractFacade<SstEsMatEqui> implements SstEsMatEquiFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SstEsMatEquiFacade() {
        super(SstEsMatEqui.class);
    }

    @Override
    public List<SstEsMatEqui> findAllEstadoReg() {
        try {
            Query query = em.createNamedQuery("SstEsMatEqui.findByEstadoReg", SstMatEqui.class);
            query.setParameter("estadoReg", 0);

            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
