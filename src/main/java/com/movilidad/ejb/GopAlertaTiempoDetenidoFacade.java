/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.GopAlertaTiempoDetenido;
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
public class GopAlertaTiempoDetenidoFacade extends AbstractFacade<GopAlertaTiempoDetenido> implements GopAlertaTiempoDetenidoFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GopAlertaTiempoDetenidoFacade() {
        super(GopAlertaTiempoDetenido.class);
    }

    /**
     * Obtener objeto List de GopAlertaTiempoDetenido por estadoReg = 0
     *
     * @return List GopAlertaTiempoDetenido
     */
    @Override
    public List<GopAlertaTiempoDetenido> findAllEstadoReg() {
        String sql = "SELECT * FROM gop_alerta_tiempo_detenido WHERE estado_reg = 0";
        Query q = em.createNativeQuery(sql, GopAlertaTiempoDetenido.class);
        return q.getResultList();
    }

}
