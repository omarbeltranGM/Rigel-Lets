/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.SstVehiculoMarca;
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
public class SstVehiculoMarcaFacade extends AbstractFacade<SstVehiculoMarca> implements SstVehiculoMarcaFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SstVehiculoMarcaFacade() {
        super(SstVehiculoMarca.class);
    }

    /**
     * Permite obtener la lista de objetos donde su atributo estado_reg sea
     * igual a 0
     *
     * @return Lista de objetos SstVehiculoMarca, null en caso de error
     */
    @Override
    public List<SstVehiculoMarca> findAllEstadoReg() {
        try {
            String sql = "SELECT * "
                    + "FROM sst_vehiculo_marca "
                    + "WHERE estado_reg = 0";
            Query q = em.createNativeQuery(sql, SstVehiculoMarca.class);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
