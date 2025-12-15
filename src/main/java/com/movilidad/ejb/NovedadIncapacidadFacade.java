/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.NovedadIncapacidad;
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
public class NovedadIncapacidadFacade extends AbstractFacade<NovedadIncapacidad> implements NovedadIncapacidadFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NovedadIncapacidadFacade() {
        super(NovedadIncapacidad.class);
    }

    @Override
    public List<NovedadIncapacidad> findByNovedad(int idNovedad) {
        Query query = em.createNativeQuery("SELECT * FROM novedad_incapacidad WHERE id_novedad = ?1;", NovedadIncapacidad.class);
        query.setParameter(1, idNovedad);
        return query.getResultList();
    }

}
