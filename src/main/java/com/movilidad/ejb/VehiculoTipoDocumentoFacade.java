/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.VehiculoTipoDocumentos;
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
public class VehiculoTipoDocumentoFacade extends AbstractFacade<VehiculoTipoDocumentos> implements VehiculoTipoDocumentoFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoTipoDocumentoFacade() {
        super(VehiculoTipoDocumentos.class);
    }

    /**
     * PErmite obtener la data que cumpla con el atributo estadoReg = 0
     *
     * @return Objeto List de objetos VehiculoTipoDocumentos
     */
    @Override
    public List<VehiculoTipoDocumentos> findAllEstadoReg() {
        try {
            String sql = "SELECT * "
                    + "FROM vehiculo_tipo_documentos "
                    + "WHERE estado_Reg = 0";
            Query q = em.createNativeQuery(sql, VehiculoTipoDocumentos.class);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
