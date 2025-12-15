/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.PmTamplitudVrbono;
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
public class PmTamplitudVrbonoFacade extends AbstractFacade<PmTamplitudVrbono> implements PmTamplitudVrbonoFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PmTamplitudVrbonoFacade() {
        super(PmTamplitudVrbono.class);
    }

    @Override
    public List<PmTamplitudVrbono> cargarEstadoRegistro() {
        try {
            Query q = em.createQuery("SELECT p FROM PmTamplitudVrbono p WHERE p.estadoReg = :estadoReg", PmTamplitudVrbono.class)
                    .setParameter("estadoReg", 0);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
