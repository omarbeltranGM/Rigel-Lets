/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.MultaReportadoPor;
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
public class MultaReportadoPorFacade extends AbstractFacade<MultaReportadoPor> implements MultaReportadoPorFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MultaReportadoPorFacade() {
        super(MultaReportadoPor.class);
    }

    @Override
    public List<MultaReportadoPor> listarMRP(String nombres) {
        Query q = em.createNativeQuery("SELECT * FROM multa_reportado_por "
                + "WHERE nombres LIKE ? AND estado_reg = 0", MultaReportadoPor.class)
                .setParameter(1, "%" + nombres + "%");
        try {
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<MultaReportadoPor> findallEst() {

        try {
            Query q = em.createQuery("SELECT m FROM MultaReportadoPor m WHERE m.estadoReg = :estadoReg", MultaReportadoPor.class)
                    .setParameter("estadoReg", 0);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }

    }

}
