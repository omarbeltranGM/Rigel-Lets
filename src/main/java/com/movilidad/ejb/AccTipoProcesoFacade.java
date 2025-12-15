/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AccTipoProceso;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author HP
 */
@Stateless
public class AccTipoProcesoFacade extends AbstractFacade<AccTipoProceso> implements AccTipoProcesoFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccTipoProcesoFacade() {
        super(AccTipoProceso.class);
    }

    @Override
    public List<AccTipoProceso> estadoReg() {
        try {
            Query q = em.createNativeQuery("Select * from acc_tipo_proceso where estado_reg = 0", AccTipoProceso.class);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
