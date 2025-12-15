/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.GenericaJornadaToken;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author solucionesit
 */
@Stateless
public class GenericaJornadaTokenFacade extends AbstractFacade<GenericaJornadaToken> implements GenericaJornadaTokenFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GenericaJornadaTokenFacade() {
        super(GenericaJornadaToken.class);
    }

    @Override
    public GenericaJornadaToken findByToken(String token) {
        try {
            Query q = em.createNativeQuery("SELECT "
                    + "gjt.* "
                    + "FROM generica_jornada_token gjt "
                    + "WHERE gjt.token=?1 AND gjt.activo=0 AND gjt.estado_reg=0;", GenericaJornadaToken.class);
            q.setParameter(1, token);
            return (GenericaJornadaToken) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
