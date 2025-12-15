/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.Opcion;
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
public class OpcionFacade extends AbstractFacade<Opcion> implements OpcionFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OpcionFacade() {
        super(Opcion.class);
    }

    @Override
    public String findRecurso(Integer i) {
        try {
            Query q = em.createNativeQuery("SELECT recurso FROM opcion where id= ?1");
            q.setParameter(1, i);
            return (String) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("estas mal en --> opcionFacade");
            return null;
        }
    }

    @Override
    public List<Opcion> getAllData() {
        try {
            String sql = "SELECT * from opcion order by DESCRIPCION ASC, NAMEOP asc;";

            Query query = em.createNativeQuery(sql, Opcion.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
