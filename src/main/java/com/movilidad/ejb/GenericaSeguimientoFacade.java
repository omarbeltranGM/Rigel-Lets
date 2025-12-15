/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.GenericaSeguimiento;
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
public class GenericaSeguimientoFacade extends AbstractFacade<GenericaSeguimiento> implements GenericaSeguimientoFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GenericaSeguimientoFacade() {
        super(GenericaSeguimiento.class);
    }

    @Override
    public List<GenericaSeguimiento> findByNovedad(int id) {
        try {
            String sql = "select * from generica_seguimiento where id_generica = ?1";

            Query query = em.createNativeQuery(sql, GenericaSeguimiento.class);
            query.setParameter(1, id);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
