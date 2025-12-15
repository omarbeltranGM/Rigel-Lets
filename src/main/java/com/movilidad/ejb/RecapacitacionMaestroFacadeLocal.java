/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.PrgTc;
import com.movilidad.model.RecapacitacionMaestro;
import java.util.Date;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author solucionesit
 */
@Local
public interface RecapacitacionMaestroFacadeLocal {

    void create(RecapacitacionMaestro r);

    void edit(RecapacitacionMaestro r);

    void remove(RecapacitacionMaestro r);

    RecapacitacionMaestro find(Object id);

    List<RecapacitacionMaestro> findAll();

    List<RecapacitacionMaestro> findRange(int[] range);

    int count();

    List<RecapacitacionMaestro> findAllByEstadoReg();
    
    List<RecapacitacionMaestro> findRangeRecapacitacion(Date desde, Date hasta, int idGopUF);
    
    List<RecapacitacionMaestro> findRangeRecapacitacionCita(Date desde, int idGopUF);
    
    RecapacitacionMaestro findNovedad(int idNovedad);
    
    List<RecapacitacionMaestro> findRangeRecapacitacionNoProgramadas(int idGopUF);
    
    /**
     * Trae las recapacitaciones por UF que aún no han sido programadas
     * Cuando existe mas de una recapacitación por operador pendiente por programar,
     * se trae la novedad más antigua
     * @param idGopUF identificador de la unidad funcional 
     * @return lista de coincidencias de objetos tipo RecapacitacionMaestro
     */
    List<RecapacitacionMaestro> findRangeRecapacitacionNoProgramadasUnicas(int idGopUF);
    
    List<PrgTc> findRangeTareasRecapacitacionProgramadas(Date desde, Date hasta, int idGopUF);
    
    /**
     * Trae las tareas de recapacitación asignadas a un empleado @idEmpleado para un rago de fechas @desde - @hasta
     * @param desde fecha desde la que se desea buscar la tarea
     * @param hasta fecha hasta la que se desea buscar la tarea
     * @param idEmpleado identificador del empleado 
     * @param idUF 
     * @return 
     */
    PrgTc findRangeTareasRecapacitacionProgramadasByEmpleado(Date desde, Date hasta, int idEmpleado, int idUF);

    /**
     * Trae los registros de recapacitaciones en los que no hay asistencia por parte de colaborador
     * 
     * @param fechaHoy
     * @param idGopUF
     * @return 
     */
    List<RecapacitacionMaestro> findRangeNoAsistenciaRecapacitacion(Date fechaHoy, int idGopUF);
}
