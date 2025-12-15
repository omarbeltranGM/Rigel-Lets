/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.ParamArea;
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
public class ParamAreaFacade extends AbstractFacade<ParamArea> implements ParamAreaFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParamAreaFacade() {
        super(ParamArea.class);
    }

    @Override
    public List<ParamArea> findAllEstadoReg() {
        try {
            String sql = "SELECT * FROM param_area WHERE estado_reg = 0 order by depende";
            Query q = em.createNativeQuery(sql, ParamArea.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error ParamAreaFacade " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public List<ParamArea> findAllPadre() {
        try {
            String sql = "SELECT * FROM param_area WHERE estado_reg = 0 and depende = 0";
            Query q = em.createNativeQuery(sql, ParamArea.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error ParamAreaFacade " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public List<ParamArea> findAllHijo(int hijo) {
        try {
            String sql = "SELECT * FROM param_area WHERE estado_reg = 0 and depende = ?1";
            Query q = em.createNativeQuery(sql, ParamArea.class);
            q.setParameter(1, hijo);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error ParamAreaFacade " + e.getMessage());
            return null;
        }
    }

    @Override
    public ParamArea findParamAreaByArea(String area) {
        try {
            String sql = "SELECT * "
                    + "FROM param_area "
                    + "WHERE area = ?1 "
                    + "AND estado_reg = 0";
            Query q = em.createNativeQuery(sql, ParamArea.class);
            q.setParameter(1, area);
            return (ParamArea) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public String findParamAreaByIdArea(int depende) {
        try {
            String sql = "SELECT area "
                    + "FROM param_area "
                    + "WHERE id_param_area = ?1 "
                    + "AND estado_reg = 0";
            Query q = em.createNativeQuery(sql);
            q.setParameter(1, depende);
            return (String) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
