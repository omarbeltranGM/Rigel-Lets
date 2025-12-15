/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AccViaDemarcacion;
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
public class AccViaDemarcacionFacade extends AbstractFacade<AccViaDemarcacion> implements AccViaDemarcacionFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccViaDemarcacionFacade() {
        super(AccViaDemarcacion.class);
    }

    @Override
    public List<AccViaDemarcacion> estadoReg() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM acc_via_demarcacion WHERE estado_reg = 0", AccViaDemarcacion.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en Facade Vía Demarcación");
            return null;
        }
    }

}
