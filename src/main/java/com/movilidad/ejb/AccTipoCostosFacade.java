/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AccTipoCostos;
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
public class AccTipoCostosFacade extends AbstractFacade<AccTipoCostos> implements AccTipoCostosFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccTipoCostosFacade() {
        super(AccTipoCostos.class);
    }

    @Override
    public List<AccTipoCostos> estadoReg() {
        try {
            Query q = em.createNativeQuery("Select * from acc_tipo_costos where estado_reg = 0", AccTipoCostos.class);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<AccTipoCostos> findByTipoCosto(int i_tipoCosto) {
        try {
            Query q = em.createNativeQuery("Select * from acc_tipo_costos where directo = " + i_tipoCosto + " and estado_reg = 0", AccTipoCostos.class);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
