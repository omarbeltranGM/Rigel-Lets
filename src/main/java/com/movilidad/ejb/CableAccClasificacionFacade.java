/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.CableAccClasificacion;
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
public class CableAccClasificacionFacade extends AbstractFacade<CableAccClasificacion> implements CableAccClasificacionFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CableAccClasificacionFacade() {
        super(CableAccClasificacion.class);
    }

    @Override
    public List<CableAccClasificacion> findAllEstadoReg() {
        try {
            String sql = "SELECT * "
                    + "FROM cable_acc_clasificacion "
                    + "WHERE estado_reg = 0";
            Query q = em.createNativeQuery(sql, CableAccClasificacion.class);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
