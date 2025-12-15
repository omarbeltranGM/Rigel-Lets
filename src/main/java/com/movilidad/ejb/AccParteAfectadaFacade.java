/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AccParteAfectada;
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
public class AccParteAfectadaFacade extends AbstractFacade<AccParteAfectada> implements AccParteAfectadaFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccParteAfectadaFacade() {
        super(AccParteAfectada.class);
    }

    @Override
    public List<AccParteAfectada> estadoReg() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM acc_parte_afectada WHERE estado_reg = 0", AccParteAfectada.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en el Facadde AccParteAfectada");
            return null;
        }
    }

}
