/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.PdMaestroDetalle;
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
public class PdMaestroDetalleFacade extends AbstractFacade<PdMaestroDetalle> implements PdMaestroDetalleFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PdMaestroDetalleFacade() {
        super(PdMaestroDetalle.class);
    }

    @Override
    public List<PdMaestroDetalle> findByIdProceso(Integer idProceso) {
        try {
            String sql = "SELECT * FROM pd_maestro_detalle where id_pd_maestro = ?1 and estado_reg = 0;";
            Query query = em.createNativeQuery(sql, PdMaestroDetalle.class);
            query.setParameter(1, idProceso);

            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PdMaestroDetalle findByIdNovedad(Integer idNovedad) {
        try {
            String sql = "SELECT * FROM pd_maestro_detalle where id_novedad = ?1 and estado_reg = 0 LIMIT 1;";
            Query query = em.createNativeQuery(sql, PdMaestroDetalle.class);
            query.setParameter(1, idNovedad);

            return (PdMaestroDetalle) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
