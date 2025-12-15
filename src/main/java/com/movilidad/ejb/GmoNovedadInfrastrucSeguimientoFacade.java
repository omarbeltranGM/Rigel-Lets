/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.GmoNovedadInfrastrucSeguimiento;
import java.util.ArrayList;
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
public class GmoNovedadInfrastrucSeguimientoFacade extends AbstractFacade<GmoNovedadInfrastrucSeguimiento> implements GmoNovedadInfrastrucSeguimientoFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GmoNovedadInfrastrucSeguimientoFacade() {
        super(GmoNovedadInfrastrucSeguimiento.class);
    }

    @Override
    public List<GmoNovedadInfrastrucSeguimiento> findAllByIdNovedad(Integer idGmoNovedadInfra) {
        try {
            String sql = "SELECT * FROM gmo_novedad_infrastruc_seguimiento where id_gmo_novedad_infrastruc = ?1 and estado_reg = 0;";

            Query query = em.createNativeQuery(sql, GmoNovedadInfrastrucSeguimiento.class);
            query.setParameter(1, idGmoNovedadInfra);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
}
