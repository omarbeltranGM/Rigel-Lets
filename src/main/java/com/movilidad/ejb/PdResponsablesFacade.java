/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.PdResponsables;
import java.util.ArrayList;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author Julián Arévalo
 */
@Stateless
public class PdResponsablesFacade extends AbstractFacade<PdResponsables> implements PdResponsablesFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PdResponsablesFacade() {
        super(PdResponsables.class);
    }

    @Override
    public List<PdResponsables> getAllActivo() {
        try {
            Query q = em.createNativeQuery("SELECT \n"
                    + "    p.*\n"
                    + "FROM\n"
                    + "    pd_responsables p\n"
                    + "WHERE\n"
                    + "    p.estado_reg = 0 and p.activo = 1;", PdResponsables.class);
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
