/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.GenericaSolicitudCambio;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author Carlos Ballestas
 */
@Stateless
public class GenericaSolicitudCambioFacade extends AbstractFacade<GenericaSolicitudCambio> implements GenericaSolicitudCambioFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GenericaSolicitudCambioFacade() {
        super(GenericaSolicitudCambio.class);
    }

    @Override
    public GenericaSolicitudCambio findBySolicitud(Integer idSolicitud) {
        try {
            String sql = "select * from generica_solicitud_cambio where id_generica_solicitud = ?1 and estado_reg=0;";

            Query query = em.createNativeQuery(sql, GenericaSolicitudCambio.class);
            query.setParameter(1, idSolicitud);

            return (GenericaSolicitudCambio) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
