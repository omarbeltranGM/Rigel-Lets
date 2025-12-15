/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.CableAccInformePregunta;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author cesar
 */
@Stateless
public class CableAccInformePreguntaFacade extends AbstractFacade<CableAccInformePregunta> implements CableAccInformePreguntaFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CableAccInformePreguntaFacade() {
        super(CableAccInformePregunta.class);
    }

    @Override
    public List<CableAccInformePregunta> findAllEstadoReg() {
        try {
            String sql = "SELECT * "
                    + "FROM cable_acc_informe_pregunta "
                    + "WHERE estado_reg = 0";
            Query q = em.createNativeQuery(sql, CableAccInformePregunta.class);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
