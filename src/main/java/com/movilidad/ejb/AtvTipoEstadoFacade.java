/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AtvTipoEstado;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author soluciones-it
 */
@Stateless
public class AtvTipoEstadoFacade extends AbstractFacade<AtvTipoEstado> implements AtvTipoEstadoFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AtvTipoEstadoFacade() {
        super(AtvTipoEstado.class);
    }

    @Override
    public List<AtvTipoEstado> findByEstadoReg() {
        String sql = "SELECT "
                + " * "
                + "FROM atv_tipo_estado "
                + "WHERE estado_reg = 0";
        Query q = em.createNativeQuery(sql, AtvTipoEstado.class);
        return q.getResultList();
    }

}
