/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.InformeSeguridad;
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
public class InformeSeguridadFacade extends AbstractFacade<InformeSeguridad> implements InformeSeguridadFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InformeSeguridadFacade() {
        super(InformeSeguridad.class);
    }

    @Override
    public List<InformeSeguridad> findAllByEstadoReg() {
        try {
            Query query = em.createNamedQuery("InformeSeguridad.findByEstadoReg", InformeSeguridad.class);
            query.setParameter("estadoReg", 0);

            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
