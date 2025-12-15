/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.PdTipoSancion;
import com.movilidad.model.PdTipoSancion;
import java.util.ArrayList;
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
public class PdTipoSancionFacade extends AbstractFacade<PdTipoSancion> implements PdTipoSancionFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PdTipoSancionFacade() {
        super(PdTipoSancion.class);
    }

    @Override
    public PdTipoSancion findByNombre(Integer idRegistro, String nombre) {
        try {
            String sql = "SELECT * FROM pd_tipo_sancion where id_pd_tipo_sancion <> ?1 and nombre = ?2 and estado_reg = 0;";
            Query query = em.createNativeQuery(sql, PdTipoSancion.class);
            query.setParameter(1, idRegistro);
            query.setParameter(2, nombre);

            return (PdTipoSancion) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<PdTipoSancion> findAllByEstadoReg() {
        try {
            Query query = em.createNamedQuery("PdTipoSancion.findByEstadoReg", PdTipoSancion.class);
            query.setParameter("estadoReg", 0);

            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    
}
