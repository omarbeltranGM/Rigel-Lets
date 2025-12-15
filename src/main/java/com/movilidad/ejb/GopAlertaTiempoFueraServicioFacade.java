/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.GopAlertaTiempoFueraServicio;
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
public class GopAlertaTiempoFueraServicioFacade extends AbstractFacade<GopAlertaTiempoFueraServicio> implements GopAlertaTiempoFueraServicioFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GopAlertaTiempoFueraServicioFacade() {
        super(GopAlertaTiempoFueraServicio.class);
    }

    @Override
    public List<GopAlertaTiempoFueraServicio> findEstadoReg() {
        Query q = em.createNativeQuery("SELECT \n"
                + "    g.*\n"
                + "FROM\n"
                + "    gop_alerta_tiempo_fuera_servicio g\n"
                + "WHERE\n"
                + "    g.estado_reg = 0\n"
                + "LIMIT 1;", GopAlertaTiempoFueraServicio.class);
        return q.getResultList();
    }

}
