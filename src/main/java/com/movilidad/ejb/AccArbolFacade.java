package com.movilidad.ejb;

import com.movilidad.model.AccArbol;
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
public class AccArbolFacade extends AbstractFacade<AccArbol> implements AccArbolFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccArbolFacade() {
        super(AccArbol.class);
    }

    @Override
    public List<AccArbol> estadoReg() {
        try {
            Query q = em.createNativeQuery("Select * from acc_arbol where estado_reg = 0", AccArbol.class);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
