/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.PqrMaestroDocumentos;
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
public class PqrMaestroDocumentosFacade extends AbstractFacade<PqrMaestroDocumentos> implements PqrMaestroDocumentosFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PqrMaestroDocumentosFacade() {
        super(PqrMaestroDocumentos.class);
    }

    @Override
    public List<PqrMaestroDocumentos> findByIdPqrMaestro(Integer idPqrMaestro) {
        try {
            String sql = "SELECT * FROM pqr_maestro_documentos where id_pqr_maestro = ?1 and estado_reg = 0;";

            Query query = em.createNativeQuery(sql, PqrMaestroDocumentos.class);
            query.setParameter(1, idPqrMaestro);

            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
