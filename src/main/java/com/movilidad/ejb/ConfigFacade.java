/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.Config;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author solucionesit
 */
@Stateless
public class ConfigFacade extends AbstractFacade<Config> implements ConfigFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConfigFacade() {
        super(Config.class);
    }

    @Override
    public Config findByKey(String key) {
        try {
            Query q = em.createNativeQuery("SELECT c.* FROM config c where c.key= ?1 limit 1;", Config.class);
            q.setParameter(1, key);
            return (Config) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
