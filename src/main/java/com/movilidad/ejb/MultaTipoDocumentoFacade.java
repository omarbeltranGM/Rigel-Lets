/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.MultaTipoDocumentos;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Soluciones IT
 */
@Stateless
public class MultaTipoDocumentoFacade extends AbstractFacade<MultaTipoDocumentos> implements MultaTipoDocumentoFacadeLocal {
    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MultaTipoDocumentoFacade() {
        super(MultaTipoDocumentos.class);
    }
    
}
