/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.RegistroEstadoArmamento;
import java.util.ArrayList;
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
public class RegistroEstadoArmamentoFacade extends AbstractFacade<RegistroEstadoArmamento> implements RegistroEstadoArmamentoFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroEstadoArmamentoFacade() {
        super(RegistroEstadoArmamento.class);
    }

    @Override
    public List<RegistroEstadoArmamento> findAllByEstadoReg() {
        try {
            Query query = em.createNamedQuery("RegistroEstadoArmamento.findByEstadoReg", RegistroEstadoArmamento.class);
            query.setParameter("estadoReg", 0);

            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
