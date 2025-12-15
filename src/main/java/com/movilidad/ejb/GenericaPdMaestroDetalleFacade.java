/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.GenericaPdMaestroDetalle;
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
public class GenericaPdMaestroDetalleFacade extends AbstractFacade<GenericaPdMaestroDetalle> implements GenericaPdMaestroDetalleFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GenericaPdMaestroDetalleFacade() {
        super(GenericaPdMaestroDetalle.class);
    }

    @Override
    public List<GenericaPdMaestroDetalle> findByIdProceso(Integer idProceso) {
        try {
            String sql = "SELECT * FROM generica_pd_maestro_detalle where id_generica_pd_maestro = ?1 and estado_reg = 0;";
            Query query = em.createNativeQuery(sql, GenericaPdMaestroDetalle.class);
            query.setParameter(1, idProceso);

            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
