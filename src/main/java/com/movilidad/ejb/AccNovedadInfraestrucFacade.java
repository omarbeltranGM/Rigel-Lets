package com.movilidad.ejb;

import com.movilidad.model.AccNovedadInfraestruc;
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
public class AccNovedadInfraestrucFacade extends AbstractFacade<AccNovedadInfraestruc> implements AccNovedadInfraestrucFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccNovedadInfraestrucFacade() {
        super(AccNovedadInfraestruc.class);
    }

    @Override
    public List<AccNovedadInfraestruc> findAllByEstadoReg() {
        try {
            Query query = em.createNamedQuery("AccNovedadInfraestruc.findByEstadoReg", AccNovedadInfraestruc.class);
            query.setParameter("estadoReg", 0);

            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
