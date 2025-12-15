/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.ContableRptFiduciaDist;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author cesar
 */
@Stateless
public class ContableRptFiduciaDistFacade extends AbstractFacade<ContableRptFiduciaDist> implements ContableRptFiduciaDistFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContableRptFiduciaDistFacade() {
        super(ContableRptFiduciaDist.class);
    }
    
}
