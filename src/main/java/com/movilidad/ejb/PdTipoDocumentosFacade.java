/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.PdTipoDocumentos;
import com.movilidad.model.PdTipoProceso;
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
public class PdTipoDocumentosFacade extends AbstractFacade<PdTipoDocumentos> implements PdTipoDocumentosFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PdTipoDocumentosFacade() {
        super(PdTipoDocumentos.class);
    }

    @Override
    public PdTipoDocumentos findByNombre(Integer idRegistro, String nombre) {
        try {
            String sql = "SELECT * FROM pd_tipo_documentos where id_pd_tipo_documento <> ?1 and nombre = ?2 and estado_reg = 0;";
            Query query = em.createNativeQuery(sql, PdTipoDocumentos.class);
            query.setParameter(1, idRegistro);
            query.setParameter(2, nombre);

            return (PdTipoDocumentos) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<PdTipoDocumentos> findAllByEstadoReg() {
         try {
            Query query = em.createNamedQuery("PdTipoDocumentos.findByEstadoReg", PdTipoDocumentos.class);
            query.setParameter("estadoReg", 0);

            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    
}
