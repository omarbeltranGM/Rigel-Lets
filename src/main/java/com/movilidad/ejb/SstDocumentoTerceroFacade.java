/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.SstDocumentoTercero;
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
public class SstDocumentoTerceroFacade extends AbstractFacade<SstDocumentoTercero> implements SstDocumentoTerceroFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SstDocumentoTerceroFacade() {
        super(SstDocumentoTercero.class);
    }

    @Override
    public List<SstDocumentoTercero> findAllEstadoReg() {
        try {
            Query query = em.createNamedQuery("SstDocumentoTercero.findByEstadoReg", SstDocumentoTercero.class);
            query.setParameter("estadoReg", 0);

            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public SstDocumentoTercero findByTipoDocumento(String tipo) {
        try {
            Query query = em.createNamedQuery("SstDocumentoTercero.findByTipoDocTercero", SstDocumentoTercero.class);
            query.setParameter("tipoDocTercero", tipo);

            return (SstDocumentoTercero) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<SstDocumentoTercero> findAllTiposVigentes() {
        try {
            String sql = "select * from sst_documento_tercero where estado_reg = 0;";
            Query query = em.createNativeQuery(sql, SstDocumentoTercero.class);

            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
