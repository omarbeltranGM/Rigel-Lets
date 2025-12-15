/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.NovedadMttoDiaria;
import com.movilidad.utils.Util;
import java.util.Date;
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
public class NovedadMttoDiariaFacade extends AbstractFacade<NovedadMttoDiaria> implements NovedadMttoDiariaFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NovedadMttoDiariaFacade() {
        super(NovedadMttoDiaria.class);
    }

    /**
     * Permite retornar List NovedadMttoDiaria con los parametros de fecha
     * suministrados
     *
     * @param ini Objeto Date
     * @param fin Objeto Date
     * @return Objeto List NovedadMttoDiaria
     */
    @Override
    public List<NovedadMttoDiaria> findAllByFechaHora(Date ini, Date fin) {
        try {
            String sql = "SELECT * "
                    + "FROM novedad_mtto_diaria "
                    + "WHERE fecha_hora BETWEEN ?1 AND ?2 "
                    + "AND estado_reg = 0";
            Query q = em.createNativeQuery(sql, NovedadMttoDiaria.class);
            q.setParameter(1, Util.dateTimeFormat(ini));
            q.setParameter(2, Util.dateTimeFormat(fin));
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
