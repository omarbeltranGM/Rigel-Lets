/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.GestorNovParamDet;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author Carlos Ballestas
 */
@Stateless
public class GestorNovParamDetFacade extends AbstractFacade<GestorNovParamDet> implements GestorNovParamDetFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GestorNovParamDetFacade() {
        super(GestorNovParamDet.class);
    }

    @Override
    public List<GestorNovParamDet> findAllByIdCargo(Integer idEmpleadoTipoCargo, Integer idGestorNovedad) {
        try {
            String sql = "SELECT * FROM gestor_nov_param_det where id_empleado_tipo_cargo = ?1\n"
                    + "and id_gestor_novedad = ?2;";
            Query q = em.createNativeQuery(sql, GestorNovParamDet.class);
            q.setParameter(1, idEmpleadoTipoCargo);
            q.setParameter(2, idGestorNovedad);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
