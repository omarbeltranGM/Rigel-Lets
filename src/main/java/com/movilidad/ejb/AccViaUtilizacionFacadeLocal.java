package com.movilidad.ejb;

import com.movilidad.model.AccViaUtilizacion;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface AccViaUtilizacionFacadeLocal {

    void create(AccViaUtilizacion accViaUtilizacion);

    void edit(AccViaUtilizacion accViaUtilizacion);

    void remove(AccViaUtilizacion accViaUtilizacion);

    AccViaUtilizacion find(Object id);

    List<AccViaUtilizacion> findAll();

    List<AccViaUtilizacion> findRange(int[] range);

    int count();

    List<AccViaUtilizacion> estadoReg();

}
