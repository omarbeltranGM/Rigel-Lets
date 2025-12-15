package com.movilidad.ejb;

import com.movilidad.model.planificacion_recursos.PlaRecuEntregaOperador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import com.movilidad.utils.Util;

/**
 *
 * @author Omar Beltrán
 */
@Stateless
public class PlaRecuEntregaOperadorFacade extends AbstractFacade<PlaRecuEntregaOperador> implements PlaRecuEntregaOperadorFacadeLocal {

    @PersistenceContext(unitName = "rigel")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlaRecuEntregaOperadorFacade() {
        super(PlaRecuEntregaOperador.class);
    }

    @Override
    public List<PlaRecuEntregaOperador> estadoReg(int estado) {
        try {
            Query q = em.createNativeQuery("SELECT * FROM pla_recu_entrega_operador WHERE estado_reg = ?1", PlaRecuEntregaOperador.class);
            q.setParameter(1, estado);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en Facade Formación y Desarrollo Entrega de Operadores");
            return null;
        }
    }

    @Override
    public List<PlaRecuEntregaOperador> findAll() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM pla_recu_entrega_operador WHERE estado_reg = 0", PlaRecuEntregaOperador.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en Facade Formación y Desarrollo Entrega de Operadores");
            return null;
        }
    }

    @Override
    public List<PlaRecuEntregaOperador> findByCategoria(String idCategoria) {
        try {
            Query q = em.createNativeQuery("SELECT * FROM pla_recu_entrega_operador WHERE estado_reg = 0", PlaRecuEntregaOperador.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en Facade Formación y Desarrollo Entrega de Operadores");
            return null;
        }
    }

    @Override
    public PlaRecuEntregaOperador findByName(String categoriaName) {
        try {
            Query q = em.createNativeQuery("SELECT * FROM pla_recu_entrega_operador WHERE name = ?1 AND estado_reg = 0", PlaRecuEntregaOperador.class);
            q.setParameter(1, categoriaName);
            return (PlaRecuEntregaOperador) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error en Facade Formación y Desarrollo Entrega de Operadores");
            return null;
        }
    }

    @Override
    public PlaRecuEntregaOperador find(int idEmpleado, Date fecha_ascenso) {
        try {
            Query q = em.createNativeQuery("SELECT * FROM pla_recu_entrega_operador WHERE id_empleado = ?1 "
                    + "AND DATE(fecha_ascenso_nomina) = ?2 "
                    + "AND estado_reg = 0", PlaRecuEntregaOperador.class
            );
            q.setParameter(1, idEmpleado);
            q.setParameter(2, fecha_ascenso);

            // Usar getResultList para evitar excepciones si no hay resultados
            List<PlaRecuEntregaOperador> results = q.getResultList();
            if (results.isEmpty()) {
                System.out.println("No se encontraron registros que coincidan con los criterios especificados.");
                return null;
            }

            // Devuelve el primer resultado si es necesario uno solo
            return results.get(0);

        } catch (Exception e) {
            System.out.println("Error en Facade Formación y Desarrollo Entrega de Operadores: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<PlaRecuEntregaOperador> findByIdGopUnidadFuncional(int idGopUnidadFuncional) {
        try {
            String sql_unida_func = idGopUnidadFuncional == 0 ? "" : "        AND e.id_gop_unidad_funcional = ?1\n";
            Query q = em.createNativeQuery("SELECT \n"
                    + "    e.*\n"
                    + "FROM\n"
                    + "    pla_recu_entrega_operador e\n"
                    + "WHERE\n"
                    + "    e.estado_reg = 0\n"
                    + sql_unida_func, PlaRecuEntregaOperador.class);
            q.setParameter(1, idGopUnidadFuncional);
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    
    @Override
    public List<PlaRecuEntregaOperador> findAllByFechaRange(Date desde, Date hasta) {
        try {
            String sql = "SELECT \n"
                    + "    b.*\n"
                    + "FROM\n"
                    + "    pla_recu_entrega_operador b\n"
                    + "WHERE\n"
                    + "    ( ?1 <= DATE(b.creado) AND DATE(b.creado) <=  ?2) AND\n"
                    + "        b.estado_reg = 0;";
            Query query = em.createNativeQuery(sql, PlaRecuEntregaOperador.class);
            query.setParameter(1,Util.dateFormat(desde));
            query.setParameter(2,Util.dateFormat(hasta));
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<PlaRecuEntregaOperador> findAllByFechaRangeAndUF(Date desde, Date hasta, int idGopUnidadFuncional) {
        try {
            String sql_unida_func = idGopUnidadFuncional == 0 ? "" : "        AND b.id_gop_unidad_funcional = ?3\n";
            String sql_fechas = "";
            if (desde != null && hasta != null ) {
                sql_fechas = "      AND ( ?1 <= DATE(b.fecha_entrega_programacion) AND DATE(b.fecha_entrega_programacion) <=  ?2)\n";
            }
            
            String sql = "SELECT \n"
                    + "    b.*\n"
                    + "FROM\n"
                    + "    pla_recu_entrega_operador b\n"
                    + "WHERE\n"
                    + "        b.estado_reg = 0 "
                    + sql_unida_func + sql_fechas;
            Query query = em.createNativeQuery(sql, PlaRecuEntregaOperador.class);
            query.setParameter(1,Util.dateFormat(desde));
            query.setParameter(2,Util.dateFormat(hasta));
            query.setParameter(3,idGopUnidadFuncional);
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
