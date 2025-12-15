/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.GenericaDocumentos;
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
public class GenericaDocumentosFacade extends AbstractFacade<GenericaDocumentos> implements GenericaDocumentosFacadeLocal {
    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GenericaDocumentosFacade() {
        super(GenericaDocumentos.class);
    }

    @Override
    public List<GenericaDocumentos> findByIdNovedad(int id) {
        try {
            Query query = em.createQuery("SELECT nd FROM GenericaDocumentos nd where nd.idGenerica.idGenerica = :id")
                    .setParameter("id", id);
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
