package com.movilidad.ejb;

import com.movilidad.model.planificacion_recursos.PlaRecuProcesoHis;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Luis Lancheros
 */
@Local
public interface PlaRecuProcesoHisFacadeLocal {

    void create(PlaRecuProcesoHis plaRecuProcesoHis);

    void edit(PlaRecuProcesoHis plaRecuProcesoHis);

    void remove(PlaRecuProcesoHis plaRecuProcesHis);

    PlaRecuProcesoHis find(Object id);

    List<PlaRecuProcesoHis> findAll();
    
    PlaRecuProcesoHis findByDescripcion(String descripcion);

    List<PlaRecuProcesoHis> findRange(int[] range);
    
    List<PlaRecuProcesoHis> findByDateRange(Date fechaIni, Date fechaFin, int idGopUnidadFuncional);

    int count();

    List<PlaRecuProcesoHis> estadoReg(int estado);
    
    Long findCounty(Date fechaIni, Date fechaFin, int idGopUnidadFuncional);

}
