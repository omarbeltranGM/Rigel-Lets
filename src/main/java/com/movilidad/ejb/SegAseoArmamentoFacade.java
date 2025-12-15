/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.SegAseoArmamento;
import com.movilidad.utils.Util;
import java.util.ArrayList;
import java.util.Date;
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
public class SegAseoArmamentoFacade extends AbstractFacade<SegAseoArmamento> implements SegAseoArmamentoFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegAseoArmamentoFacade() {
        super(SegAseoArmamento.class);
    }

    @Override
    public List<SegAseoArmamento> findRangoFechaEstadoReg(Date desde, Date hasta) {
        try {
            Query q = em.createNativeQuery("SELECT \n"
                    + "    p.*\n"
                    + "FROM\n"
                    + "    seg_aseo_armamento p\n"
                    + "WHERE\n"
                    + "    DATE(p.fecha_inicio) BETWEEN DATE(?1) AND DATE(?2)\n"
                    + "        OR DATE(p.fecha_fin) BETWEEN DATE(?1) AND DATE(?2)\n"
                    + "        AND p.estado_reg = 0;", SegAseoArmamento.class);
            q.setParameter(1, Util.dateFormat(desde));
            q.setParameter(2, Util.dateFormat(hasta));
            return q.getResultList();

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
