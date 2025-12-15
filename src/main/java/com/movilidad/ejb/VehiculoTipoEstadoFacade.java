/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.VehiculoTipoEstado;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author USUARIO
 */
@Stateless
public class VehiculoTipoEstadoFacade extends AbstractFacade<VehiculoTipoEstado> implements VehiculoTipoEstadoFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoTipoEstadoFacade() {
        super(VehiculoTipoEstado.class);
    }

    @Override
    public List<VehiculoTipoEstado> findByEstadoReg() {
        Query q = em.createNamedQuery("VehiculoTipoEstado.findByEstadoReg", VehiculoTipoEstado.class);
        q.setParameter("estadoReg", 0);
        return q.getResultList();
    }

    @Override
    public VehiculoTipoEstado findEstadoCierraNovedad(int id) {
        try {
            Query q = em.createNativeQuery("SELECT \n"
                    + "    *\n"
                    + "FROM\n"
                    + "    vehiculo_tipo_estado\n"
                    + "WHERE\n"
                    + "    id_vehiculo_tipo_estado <> ?1\n"
                    + "        AND cierra_novedad = 1\n"
                    + "        AND estado_reg = 0;", VehiculoTipoEstado.class);
            q.setParameter(1, id);
            return (VehiculoTipoEstado) q.getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }
    
    //Trae los estados de vehiculo con id 2 y 3 los cuales seran utilizados para filtrar en la lista "Bitacora de Disponibilidad MTTO".
    @Override
    public List<VehiculoTipoEstado> findEstadosVehiculoBitacora() {
        Query q = em.createQuery(
                "SELECT v FROM VehiculoTipoEstado v "
                + "WHERE v.idVehiculoTipoEstado IN (2, 3) " 
                + "AND v.estadoReg = 0",
                VehiculoTipoEstado.class
        );
        return q.getResultList();
    }

}
