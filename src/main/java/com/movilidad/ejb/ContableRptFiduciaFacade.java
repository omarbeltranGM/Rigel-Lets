/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.ContableRptFiducia;
import com.movilidad.utils.Util;
import java.util.Date;
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
public class ContableRptFiduciaFacade extends AbstractFacade<ContableRptFiducia> implements ContableRptFiduciaFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContableRptFiduciaFacade() {
        super(ContableRptFiducia.class);
    }

    @Override
    public List<ContableRptFiducia> getContablesRptFiduciaByDate(Date d, Integer idContableRptFiducia) {
        try {
            String sql = "SELECT * "
                    + "FROM contable_rpt_fiducia "
                    + "WHERE ?1 BETWEEN desde AND hasta "
                    + "AND id_contable_rpt_fiducia <> ?2 "
                    + "AND estado_reg = 0";
            Query q = em.createNativeQuery(sql, ContableRptFiducia.class);
            q.setParameter(1, Util.dateFormat(d));
            q.setParameter(2, idContableRptFiducia);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ContableRptFiducia> findAllEstadoReg() {
        try {
            String sql = "SELECT * "
                    + "FROM contable_rpt_fiducia "
                    + "WHERE estado_reg = 0";
            Query q = em.createNativeQuery(sql, ContableRptFiducia.class);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ContableRptFiducia> findAllRangoFechaEstadoReg(Date desde, Date hasta) {
        try {
            String sql = "SELECT * "
                    + "FROM contable_rpt_fiducia "
                    + "WHERE desde >= ?1 AND hasta <= ?2 "
                    + "AND estado_reg = 0 "
                    + "ORDER BY desde";
            Query q = em.createNativeQuery(sql, ContableRptFiducia.class);
            q.setParameter(1, Util.dateFormat(desde));
            q.setParameter(2, Util.dateFormat(hasta));
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
