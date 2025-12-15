/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.CableAccResponsable;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author cesar
 */
@Stateless
public class CableAccResponsableFacade extends AbstractFacade<CableAccResponsable> implements CableAccResponsableFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CableAccResponsableFacade() {
        super(CableAccResponsable.class);
    }

    @Override
    public List<CableAccResponsable> findAllEstadoReg() {
        try {
            String sql = "SELECT * "
                    + "FROM cable_acc_responsable "
                    + "WHERE estado_reg = 0";
            Query q = em.createNativeQuery(sql, CableAccResponsable.class);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
