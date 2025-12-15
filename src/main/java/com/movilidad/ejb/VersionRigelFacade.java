package com.movilidad.ejb;

import com.movilidad.model.VersionRigel;
import com.movilidad.model.VersionTipo;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author Andres
 */
@Stateless
public class VersionRigelFacade extends AbstractFacade<VersionRigel> implements VersionRigelFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VersionRigelFacade() {
        super(VersionRigel.class);
    }

    @Override
    public List<VersionRigel> findAllEstadoreg() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM version_rigel WHERE estado_reg = 0 ORDER BY fecha desc", VersionRigel.class);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Busca una versión de rigel mediante su número de versión y tipo de
     * versión, principalmente para validar que no haya duplicados.
     *
     * @param version
     * @param tipoVersion
     * @return
     */
    @Override
    public VersionRigel findByVersionAndTipo(String version, VersionTipo tipoVersion) {
        try {
            return em.createQuery(
                    "SELECT v FROM VersionRigel v "
                    + "WHERE v.version = :version "
                    + "AND v.idVersionTipo = :tipoVersion "
                    + "AND v.estadoReg = 0",
                    VersionRigel.class
            )
                    .setParameter("version", version)
                    .setParameter("tipoVersion", tipoVersion)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    /**
     * Se consulta si existe un posible registro duplicado de una version al
     * momento de editar un registro.
     *
     * @param version
     * @param tipoVersion
     * @param idExcluido
     * @return
     */
    @Override
    public VersionRigel findDuplicadoEdit(String version, VersionTipo tipoVersion, Integer idExcluido) {
        try {
            return em.createQuery(
                    "SELECT v FROM VersionRigel v "
                    + "WHERE v.version = :version "
                    + "AND v.idVersionTipo = :tipoVersion "
                    + "AND v.estadoReg = 0 "
                    + "AND v.idVersionRigel <> :idExcluido",
                    VersionRigel.class
            )
                    .setParameter("version", version)
                    .setParameter("tipoVersion", tipoVersion)
                    .setParameter("idExcluido", idExcluido)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // No existe duplicado
        }
    }

    /**
     * Trae la última versión para actualizarla automáticamente en el icono de
     * versiones del topbar
     *
     * @return
     */
    @Override
    public VersionRigel findUltimaVersion() {
        try {
            Query q = em.createQuery("SELECT v FROM VersionRigel v ORDER BY v.creado DESC", VersionRigel.class);
            q.setMaxResults(1);
            return (VersionRigel) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
