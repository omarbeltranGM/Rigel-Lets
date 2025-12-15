package com.movilidad.ejb;

import com.movilidad.model.Infracciones;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Omar Beltrán
 */
@Local
public interface InfraccionesFacadeLocal {

    void create(Infracciones infraccion);

    void edit(Infracciones infraccion);

    void remove(Infracciones infraccion);

    Infracciones find(Object id);

    List<Infracciones> findAll();

    List<Infracciones> findAllByDateRangeAndEstadoReg(Date desde, Date hasta);

    List<Infracciones> findAllByDateRangeAndArea(Date desde, Date hasta, int idInfraccionesParamArea);

    List<Infracciones> findRange(int[] range);

    int count();

    /**
     * Permite buscar un infracción dado su identificador
     * @param idNovedad identificador de la infracción a buscar
     * @return retorn un objeto de tipo Infracciones que contiene la información coincidente
     */
    Infracciones findByIdNovedad(int idNovedad);
    
    /**
     * Busca una infracción dado el identificador ICO
     * @param idICO
     * @return retorn un objeto de tipo Infracciones que contiene la información coincidente
     */
    Infracciones findByIdICO(String idICO);

    /**
     * Permite validar si hay alguna infracción  que coincida con los valores de
     * los parametros de entrada.
     * @param fechaNovedad
     * @param tipoNovedad
     * @param placa
     * @param cedulaOperador
     * @return 
     */
    boolean consultaInfraccionDuplicada(Date fechaNovedad, String tipoNovedad, String placa, String cedulaOperador);
}
