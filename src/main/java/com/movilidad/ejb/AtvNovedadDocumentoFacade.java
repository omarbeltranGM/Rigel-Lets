/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AtvNovedadDocumento;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author soluciones-it
 */
@Stateless
public class AtvNovedadDocumentoFacade extends AbstractFacade<AtvNovedadDocumento> implements AtvNovedadDocumentoFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AtvNovedadDocumentoFacade() {
        super(AtvNovedadDocumento.class);
    }

    @Override
    public List<AtvNovedadDocumento> findAllByIdNovedadAndActivos(Integer idNovedad) {
        String sql = "SELECT "
                + " * "
                + "FROM atv_novedad_documento "
                + "WHERE id_novedad = ?1 "
                + "AND estado_reg = 0";
        Query q = em.createNativeQuery(sql, AtvNovedadDocumento.class);
        q.setParameter(1, idNovedad);
        return q.getResultList();
    }

}
