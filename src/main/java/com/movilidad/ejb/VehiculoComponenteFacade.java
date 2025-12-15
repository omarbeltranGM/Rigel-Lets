/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AseoParamArea;
import com.movilidad.model.VehiculoComponente;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author USUARIO
 */
@Stateless
public class VehiculoComponenteFacade extends AbstractFacade<VehiculoComponente> implements VehiculoComponenteFacadeLocal {
    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoComponenteFacade() {
        super(VehiculoComponente.class);
    }
        
    @Override
    public VehiculoComponente findByName(String Name) {
        try {
            Query query = em.createNamedQuery("VehiculoComponente.findByNombre", VehiculoComponente.class);
            query.setParameter("nombre", Name);
            return (VehiculoComponente) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }    
}
