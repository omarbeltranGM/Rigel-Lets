/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.PmDiasEmpresa;
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
public class PmDiasEmpresaFacade extends AbstractFacade<PmDiasEmpresa> implements PmDiasEmpresaFacadeLocal {
    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PmDiasEmpresaFacade() {
        super(PmDiasEmpresa.class);
    }
    @Override
    public List <PmDiasEmpresa> findallEst () {
        
        try {
            Query q = em.createQuery("SELECT m FROM PmDiasEmpresa m WHERE m.estadoReg = :estadoReg", PmDiasEmpresa.class)
                    .setParameter("estadoReg", 0);
            return q.getResultList();
        }catch (Exception e) {
        return null;
        }

        }
}
