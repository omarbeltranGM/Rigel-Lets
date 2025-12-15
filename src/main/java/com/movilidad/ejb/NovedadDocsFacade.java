/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.NovedadDocs;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author solucionesit
 */
@Stateless
public class NovedadDocsFacade extends AbstractFacade<NovedadDocs> implements NovedadDocsFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NovedadDocsFacade() {
        super(NovedadDocs.class);
    }

    @Override
    public List<NovedadDocs> findAllByIdNovedad(int idNovedad) {
        Query q = em.createNativeQuery("SELECT \n"
                + "    nd.*\n"
                + "FROM\n"
                + "    novedad_docs nd\n"
                + "WHERE\n"
                + "    nd.id_novedad = ?1 AND nd.estado_reg = 0", NovedadDocs.class);
        q.setParameter(1, idNovedad);
        return q.getResultList();
    }

}
