/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AccTipoVehiculo;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author HP
 */
@Stateless
public class AccTipoVehiculoFacade extends AbstractFacade<AccTipoVehiculo> implements AccTipoVehiculoFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccTipoVehiculoFacade() {
        super(AccTipoVehiculo.class);
    }

    @Override
    public List<AccTipoVehiculo> estadoReg() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM acc_tipo_vehiculo WHERE estado_reg = 0", AccTipoVehiculo.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en Facade Acc Tipo Vehículo");
            return null;
        }
    }

}
