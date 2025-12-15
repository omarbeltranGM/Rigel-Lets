/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.DispSistema;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author solucionesit
 */
@Stateless
public class DispSistemaFacade extends AbstractFacade<DispSistema> implements DispSistemaFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DispSistemaFacade() {
        super(DispSistema.class);
    }

    @Override
    public List<DispSistema> findAllByEstadoReg() {
        Query q = em.createNamedQuery("DispSistema.findByEstadoReg", DispSistema.class);
        q.setParameter("estadoReg", 0);
        return q.getResultList();
    }

    @Override
    public DispSistema findByNombre(String nombre, int id) {
        try {
            Query q = em.createNamedQuery("DispSistema.findByNombre", DispSistema.class);
            q.setParameter("nombre", nombre);
            q.setParameter("idDispSistema", id);
            return (DispSistema) q.getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }

}
