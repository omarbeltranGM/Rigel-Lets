/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.ContableRptFiduciaDet;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author cesar
 */
@Stateless
public class ContableRptFiduciaDetFacade extends AbstractFacade<ContableRptFiduciaDet> implements ContableRptFiduciaDetFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContableRptFiduciaDetFacade() {
        super(ContableRptFiduciaDet.class);
    }

}
