/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.MultaTipo;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author USUARIO
 */
@Stateless
public class MultaTipoFacade extends AbstractFacade<MultaTipo> implements MultaTipoFacadeLocal {
    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MultaTipoFacade() {
        super(MultaTipo.class);
    }
    
    @Override
    public List<MultaTipo> findEstaRegis(){
                try {
            Query q = em.createQuery("SELECT m FROM MultaTipo m WHERE NOT m.estadoReg = :estadoReg", MultaTipo.class)
                    .setParameter("estadoReg", 1);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
