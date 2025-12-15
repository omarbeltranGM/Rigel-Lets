/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.CableAccPlanAccion;
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
public class CableAccPlanAccionFacade extends AbstractFacade<CableAccPlanAccion> implements CableAccPlanAccionFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CableAccPlanAccionFacade() {
        super(CableAccPlanAccion.class);
    }

    @Override
    public List<CableAccPlanAccion> findAllEstadoReg(Integer idCableAccidentalidad) {
        try {
            String sql = "SELECT * "
                    + "FROM cable_acc_plan_accion "
                    + "WHERE id_cable_accidentalidad = ?1 "
                    + "AND estado_reg = 0";
            Query q = em.createNativeQuery(sql, CableAccPlanAccion.class);
            q.setParameter(1, idCableAccidentalidad);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
