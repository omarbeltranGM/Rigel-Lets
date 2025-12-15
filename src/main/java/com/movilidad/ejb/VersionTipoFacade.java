/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movilidad.ejb;

import com.movilidad.model.VersionTipo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Andres
 */
@Stateless
public class VersionTipoFacade extends AbstractFacade<VersionTipo> implements VersionTipoFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }    

    public VersionTipoFacade() {
        super(VersionTipo.class);
    }

    @Override
    public List<VersionTipo> findAllEstadoreg() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM version_tipo WHERE estado_reg = 0", VersionTipo.class);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List findNombreTipoVersion(){
        try {
            Query q = em.createNativeQuery("SELECT DISTINCT nombre_version_tipo FROM version_tipo");
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
