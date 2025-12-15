/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.CableAccTipoEvento;
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
public class CableAccTipoEventoFacade extends AbstractFacade<CableAccTipoEvento> implements CableAccTipoEventoFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CableAccTipoEventoFacade() {
        super(CableAccTipoEvento.class);
    }

    @Override
    public List<CableAccTipoEvento> findAllEstadoReg() {
        try {
            String sql = "SELECT * "
                    + "FROM cable_acc_tipo_evento "
                    + "WHERE estado_reg = 0";
            Query q = em.createNativeQuery(sql, CableAccTipoEvento.class);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
