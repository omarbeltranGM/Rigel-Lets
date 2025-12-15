/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AccCausaRaiz;
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
public class AccCausaRaizFacade extends AbstractFacade<AccCausaRaiz> implements AccCausaRaizFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccCausaRaizFacade() {
        super(AccCausaRaiz.class);
    }

    @Override
    public List<AccCausaRaiz> estadoReg() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM acc_causa_raiz WHERE estado_reg = 0", AccCausaRaiz.class);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<AccCausaRaiz> findByCausaSub(int i_idAccCausaSub) {
        try {
            Query q = em.createNativeQuery("SELECT * FROM acc_causa_raiz WHERE id_acc_subcausa = ?1 and estado_reg = 0", AccCausaRaiz.class);
            q.setParameter(1, i_idAccCausaSub);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
