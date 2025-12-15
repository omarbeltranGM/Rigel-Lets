/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AccidenteAudiencia;
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
public class AccidenteAudienciaFacade extends AbstractFacade<AccidenteAudiencia> implements AccidenteAudienciaFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccidenteAudienciaFacade() {
        super(AccidenteAudiencia.class);
    }

    @Override
    public List<AccidenteAudiencia> estadoReg(int i_idAccidente) {
         try {
            Query q = em.createNativeQuery("SELECT * FROM accidente_audiencia "
                    + "WHERE id_accidente = ?1 AND estado_reg = 0", AccidenteAudiencia.class);
            q.setParameter(1, i_idAccidente);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en Accidente Audiencia Facade Local");
            return null;
        }
    }
    
}
