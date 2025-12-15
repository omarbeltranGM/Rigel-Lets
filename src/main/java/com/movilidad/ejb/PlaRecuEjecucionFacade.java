/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movilidad.ejb;

import com.movilidad.model.planificacion_recursos.PlaRecuEjecucion;
import com.movilidad.utils.Util;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author Omar.beltran
 */
@Stateless
public class PlaRecuEjecucionFacade extends AbstractFacade<PlaRecuEjecucion> implements PlaRecuEjecucionFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    public PlaRecuEjecucionFacade() {
        super(PlaRecuEjecucion.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<PlaRecuEjecucion> findAllByFechaRangeAndEstadoReg(Date desde, Date hasta, int estadoReg) {
        try {
            String sql = "SELECT \n"
                    + "    *\n"
                    + "FROM\n"
                    + "    pla_recu_ejecucion\n"
                    + "WHERE\n"
                    + "    (( ?1 <= DATE(fecha_inicio) AND DATE(fecha_inicio) <=  ?2) OR\n"
                    + "     ( ?1 <= DATE(fecha_fin) AND DATE(fecha_fin) <=  ?2) OR\n"
                    + "     ( ?1 <= DATE(fecha_fin) AND DATE(fecha_fin) >  ?2)) AND\n"
                    + "        estado_reg = ?3;";
            Query query = em.createNativeQuery(sql, PlaRecuEjecucion.class);
            query.setParameter(1, Util.dateFormat(desde));
            query.setParameter(2, Util.dateFormat(hasta));
            query.setParameter(3, estadoReg);
            return query.getResultList();    
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<PlaRecuEjecucion> findAllByFechaRange(Date desde, Date hasta) {
        try {
            String sql_fechas = "    ((DATE(fecha_ini) between ?1 AND ?2) OR\n"
                        + "     (DATE(fecha_fin) between ?1 AND ?2) OR\n"
                        + "     (DATE(fecha_ini) <= ?1 AND ?2 <= DATE(fecha_fin)) OR \n"
                        + "     (?1 <= DATE(fecha_ini) AND DATE(fecha_fin) <= ?2)) AND \n";
      
            String sql = "SELECT \n"
                    + "    *\n"
                    + "FROM\n"
                    + "    pla_recu_ejecucion\n"
                    + "WHERE\n"
                    + sql_fechas
                    + "    estado_reg = 0;";
            Query query = em.createNativeQuery(sql, PlaRecuEjecucion.class);
            query.setParameter(1, Util.dateFormat(desde));
            query.setParameter(2, Util.dateFormat(hasta));
            return query.getResultList();    
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<PlaRecuEjecucion> findAllByFechaInicio(Date desde) {
        try {
            String sql = "SELECT \n"
                    + "    *\n"
                    + "FROM\n"
                    + "    pla_recu_ejecucion\n"
                    + "WHERE\n"
                    + "    ?1 <= DATE(fecha_inicio) AND\n"
                    + "    estado_reg = 0;";
            Query query = em.createNativeQuery(sql, PlaRecuEjecucion.class);
            query.setParameter(1, Util.dateFormat(desde));
            return query.getResultList();    
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PlaRecuEjecucion findExecute(Date fechaIni, Date fechaFin, String horaIni, String horaFin, Integer idEmpleado) {
        try {
            String sql = "SELECT \n"
                    + "    *\n"
                    + "FROM\n"
                    + "    pla_recu_ejecucion\n"
                    + "WHERE\n"
                    + "    (( ?1 BETWEEN DATE(fecha_inicio) AND DATE(fecha_fin)) OR\n"
                    + "     ( ?2 BETWEEN DATE(fecha_inicio) AND DATE(fecha_fin))) \n"
                    + "        AND hora_inicio = ?3 \n"
                    + "        AND hora_fin = ?4 \n"
                    + "        AND id_empleado = ?5 \n"
                    + "        AND estado_reg = 0;";
            Query query = em.createNativeQuery(sql, PlaRecuEjecucion.class);
            query.setParameter(1, Util.dateFormat(fechaIni));
            query.setParameter(2, Util.dateFormat(fechaFin));
            query.setParameter(3, horaIni);
            query.setParameter(4, horaFin);
            query.setParameter(5, idEmpleado);

            return (PlaRecuEjecucion)query.getSingleResult();    
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public PlaRecuEjecucion findExecute(Date fechaIni, Date fechaFin, Integer idEmpleado) {
        try {
            String sql = "SELECT \n"
                    + "    *\n"
                    + "FROM\n"
                    + "    pla_recu_ejecucion\n"
                    + "WHERE\n"
                    + "    ((?1 BETWEEN DATE(fecha_inicio) AND DATE(fecha_fin)) OR\n"
                    + "     (?2 BETWEEN DATE(fecha_inicio) AND DATE(fecha_fin))) \n"
                    + "        AND id_empleado = ?3 \n"
                    + "        AND estado_reg = 0;";
            Query query = em.createNativeQuery(sql, PlaRecuEjecucion.class);
            query.setParameter(1, Util.dateFormat(fechaIni));
            query.setParameter(2, Util.dateFormat(fechaFin));
            query.setParameter(3, idEmpleado);

            // Usar getResultList para evitar excepciones si no hay resultados
            List<PlaRecuEjecucion> results = query.getResultList();
            if (results.isEmpty()) {
                System.out.println("No se encontraron registros que coincidan con los criterios especificados.");
                return null;
            }
            // Devuelve el primer resultado si es necesario uno solo
            return results.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<PlaRecuEjecucion> findByEmpleado(int idEmpleado) {
        try {
        String sql = "SELECT \n"
                    + "    *\n"
                    + "FROM\n"
                    + "    pla_recu_ejecucion\n"
                    + "WHERE\n"
                    + "     id_empleado = ?1 \n"
                    + "     AND estado_reg = 0;";
            Query query = em.createNativeQuery(sql, PlaRecuEjecucion.class);
            query.setParameter(1, idEmpleado);
            return query.getResultList();    
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<PlaRecuEjecucion> findByIdGopUnidadFuncional(int idGopUnidadFuncional, Date fechaIni, Date fechaFin ) {
        try {
            String sql_fechas = "";
            if (fechaIni != null && fechaFin != null) {
                sql_fechas = "AND    ((DATE(e.fecha_inicio) between ?1 AND ?2) OR\n"
                        + "     (DATE(e.fecha_fin) between ?1 AND ?2) OR\n"
                        + "     (DATE(e.fecha_inicio) <= ?1 AND ?2 <= DATE(e.fecha_fin)) OR \n"
                        + "     (?1 <= DATE(e.fecha_inicio) AND DATE(e.fecha_fin) <= ?2))\n";
            }
            
            String sql_unida_func = idGopUnidadFuncional == 0 ? "" : "        AND e.id_gop_unidad_funcional = ?3\n";
            Query q = em.createNativeQuery("SELECT \n"
                    + "    e.*\n"
                    + "FROM\n"
                    + "    pla_recu_ejecucion e\n"
                    + "WHERE\n"
                    + "    e.estado_reg = 0\n"
                    + sql_fechas 
                    + sql_unida_func, PlaRecuEjecucion.class);
            q.setParameter(3, idGopUnidadFuncional);
            q.setParameter(1, fechaIni);
            q.setParameter(2, fechaFin);
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    
}
