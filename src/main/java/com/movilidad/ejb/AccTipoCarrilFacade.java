/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AccTipoCarril;
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
public class AccTipoCarrilFacade extends AbstractFacade<AccTipoCarril> implements AccTipoCarrilFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccTipoCarrilFacade() {
        super(AccTipoCarril.class);
    }

    @Override
    public List<AccTipoCarril> estadoReg() {
        try {
            Query q = em.createNativeQuery("select * from acc_tipo_carril where estado_reg = 0", AccTipoCarril.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en Facade AccTipoCarril");
            return null;
        }
    }

}
