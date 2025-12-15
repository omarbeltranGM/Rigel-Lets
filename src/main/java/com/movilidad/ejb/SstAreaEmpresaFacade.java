/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.SstAreaEmpresa;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author cesar
 */
@Stateless
public class SstAreaEmpresaFacade extends AbstractFacade<SstAreaEmpresa> implements SstAreaEmpresaFacadeLocal {
    
    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SstAreaEmpresaFacade() {
        super(SstAreaEmpresa.class);
    }

    /**
     * Permite obtener la lista de objetos donde su atributo estado_reg sea
     * igual a 0
     *
     * @return Lista de objetos SstAreaEmpresa, null en caso de error
     */
    @Override
    public List<SstAreaEmpresa> findAllEstadoReg() {
        try {
            String sql = "SELECT * "
                    + "FROM sst_area_empresa "
                    + "WHERE estado_reg = 0";
            Query q = em.createNativeQuery(sql, SstAreaEmpresa.class);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
