package com.movilidad.ejb;

import com.movilidad.model.AccActRealizada;
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
public class AccActRealizadaFacade extends AbstractFacade<AccActRealizada> implements AccActRealizadaFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccActRealizadaFacade() {
        super(AccActRealizada.class);
    }

    @Override
    public List<AccActRealizada> estadoReg() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM acc_act_realizada WHERE estado_reg = 0", AccActRealizada.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en Facade Acc Act Realizada");
            return null;
        }
    }

}
