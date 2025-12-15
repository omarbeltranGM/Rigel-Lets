/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.NominaServerParamDetGen;
import java.util.ArrayList;
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
public class NominaServerParamDetGenFacade extends AbstractFacade<NominaServerParamDetGen> implements NominaServerParamDetGenFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NominaServerParamDetGenFacade() {
        super(NominaServerParamDetGen.class);
    }

    @Override
    public List<NominaServerParamDetGen> findAllByEstadoReg() {
        try {
            Query query = em.createNamedQuery("NominaServerParamDetGen.findByEstadoReg", NominaServerParamDetGen.class);
            query.setParameter("estadoReg", 0);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
