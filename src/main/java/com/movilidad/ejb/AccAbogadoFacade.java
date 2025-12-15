package com.movilidad.ejb;

import com.movilidad.model.AccAbogado;
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
public class AccAbogadoFacade extends AbstractFacade<AccAbogado> implements AccAbogadoFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccAbogadoFacade() {
        super(AccAbogado.class);
    }

    @Override
    public List<AccAbogado> findAll() {
        try {
            String sql = "select * from acc_abogado where estado_reg = 0;";

            Query query = em.createNativeQuery(sql, AccAbogado.class);

            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
