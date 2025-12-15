/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.HallazgosParamArea;
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
public class HallazgosParamAreaFacade extends AbstractFacade<HallazgosParamArea> implements HallazgosParamAreaFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HallazgosParamAreaFacade() {
        super(HallazgosParamArea.class);
    }

    @Override
    public List<HallazgosParamArea> findAllByEstadoReg() {
        try {
            Query query = em.createNamedQuery("HallazgosParamArea.findByEstadoReg", HallazgosParamArea.class);
            query.setParameter("estadoReg", 0);

            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public HallazgosParamArea findByNombre(String nombre, Integer idRegistro) {
        try {
            String sql = "SELECT * FROM hallazgos_param_area where id_hallazgos_param_area <> ?1 and nombre = ?2 and estado_reg = 0;";
            Query query = em.createNativeQuery(sql, HallazgosParamArea.class);
            query.setParameter(1, idRegistro);
            query.setParameter(2, nombre);

            return (HallazgosParamArea) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
