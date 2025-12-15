package com.movilidad.ejb;

import com.movilidad.model.planificacion_recursos.PlaRecuProcesoHis;
import com.movilidad.utils.Util;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Luis Lancheros
 */
@Stateless
public class PlaRecuProcesoHisFacade extends AbstractFacade<PlaRecuProcesoHis> implements PlaRecuProcesoHisFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlaRecuProcesoHisFacade() {
        super(PlaRecuProcesoHis.class);
    }
    
    @Override
    public List<PlaRecuProcesoHis> estadoReg(int estado) {
        try {
            Query q = em.createNativeQuery("SELECT * FROM pla_recu_proceso_his WHERE estado_reg = ?1", PlaRecuProcesoHis.class);
            q.setParameter(1, estado);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en Facade Planeación Recursos Proceso Programación");
            return null;
        }
    }
    
    @Override
    public List<PlaRecuProcesoHis> findAll() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM pla_recu_proceso_his WHERE estado_reg = 0 order by id_pla_recu_proceso_his ", PlaRecuProcesoHis.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en Facade Planeación Recursos Proceso Historico");
            return null;
        }
    }
    
    @Override
    public PlaRecuProcesoHis findByDescripcion(String descripcion) {
        try {
            Query q = em.createNativeQuery("SELECT * FROM pla_recu_proceso_his WHERE descripcion = ?1 AND estado_reg = 0", PlaRecuProcesoHis.class);
            q.setParameter(1, descripcion);
            return (PlaRecuProcesoHis) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error en Facade Planeación Recursos Proceso Programación");
            return null;
        }
    }
    
    @Override
    public List<PlaRecuProcesoHis> findByDateRange(Date fechaIni, Date fechaFin, int idGopUnidadFuncional) {
        try {
            Query query = em.createNativeQuery("SELECT * FROM pla_recu_proceso_his "
                    + "WHERE estado_reg = 0 "
                    + "AND fecha_ini = ?1 "
                    + "AND fecha_fin = ?2 "
                    + "AND id_gop_unidad_funcional = ?3 "
                    + "ORDER BY id_pla_recu_proceso_his ",PlaRecuProcesoHis.class);
            query.setParameter(1, Util.toDate(Util.dateFormat(fechaIni)));
            query.setParameter(2, Util.toDate(Util.dateFormat(fechaFin)));
            query.setParameter(3,idGopUnidadFuncional);
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public Long findCounty(Date fechaIni, Date fechaFin, int idGopUnidadFuncional) {
        try {
        Query query = em.createNativeQuery("SELECT COUNT(*) FROM pla_recu_proceso_his "
                    + "WHERE estado_reg = 0 "
                    + "AND (DATE(fecha_ini) <= ?2 AND DATE(fecha_fin) >= ?1) "
                    + "AND id_gop_unidad_funcional = ?3 "
                    + "ORDER BY id_pla_recu_proceso_his ");
            query.setParameter(1, Util.toDate(Util.dateFormat(fechaIni)));
            query.setParameter(2, Util.toDate(Util.dateFormat(fechaFin)));
            query.setParameter(3,idGopUnidadFuncional);

            return (Long) query.getSingleResult();    
        } catch (Exception e) {
            return Long.valueOf(0);
        }
    }

}

