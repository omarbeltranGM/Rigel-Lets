package com.movilidad.ejb;

import com.movilidad.model.planificacion_recursos.PlaRecuEstado;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author Omar Beltrán
 */
@Stateless
public class PlaRecuEstadoFacade extends AbstractFacade<PlaRecuEstado> implements PlaRecuEstadoFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlaRecuEstadoFacade() {
        super(PlaRecuEstado.class);
    }
    
    @Override
    public List<PlaRecuEstado> estadoReg(int estado) {
        try {
            Query q = em.createNativeQuery("SELECT * FROM pla_recu_estado WHERE estado_reg = ?1", PlaRecuEstado.class);
            q.setParameter(1, estado);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en Facade Planeación Recursos Estado");
            return null;
        }
    }
    
    @Override
    public List<PlaRecuEstado> findAll() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM pla_recu_estado WHERE estado_reg = 0", PlaRecuEstado.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en Facade Planeación Recursos Estado");
            return null;
        }
    }
    
    @Override
    public PlaRecuEstado findByName(String estadoName) {
        try {
            Query q = em.createNativeQuery("SELECT * FROM pla_recu_estado WHERE estado = ?1 AND estado_reg = 0", PlaRecuEstado.class);
            q.setParameter(1, estadoName);
            return q.getResultList().isEmpty() ? null : (PlaRecuEstado) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error en Facade Planeación Recursos Estado");
            return null;
        }
    }

}
