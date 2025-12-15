/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.NovedadTipoInfraccion;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author solucionesit
 */
@Stateless
public class NovedadTipoInfraccionFacade extends AbstractFacade<NovedadTipoInfraccion> implements NovedadTipoInfraccionFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NovedadTipoInfraccionFacade() {
        super(NovedadTipoInfraccion.class);
    }

    @Override
    public List<NovedadTipoInfraccion> findAllByEstadoReg() {
        try {
            Query query = em.createNamedQuery("NovedadTipoInfraccion.findByEstadoReg", NovedadTipoInfraccion.class);
            query.setParameter("estadoReg", 0);

            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public NovedadTipoInfraccion findByName(String nombre) {
        try {
            return em.createNamedQuery("NovedadTipoInfraccion.findByNombre", NovedadTipoInfraccion.class)
                    .setParameter("nombre", nombre)
                    .setMaxResults(1) // Limita a un resultado
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
}
