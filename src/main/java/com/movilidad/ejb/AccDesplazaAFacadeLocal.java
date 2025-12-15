package com.movilidad.ejb;

import com.movilidad.model.AccDesplazaA;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author Carlos Ballestas
 */
@Local
public interface AccDesplazaAFacadeLocal {

    void create(AccDesplazaA accDesplazaA);

    void edit(AccDesplazaA accDesplazaA);

    void remove(AccDesplazaA accDesplazaA);

    AccDesplazaA find(Object id);

    AccDesplazaA findByNombre(String nombre, Integer id);

    List<AccDesplazaA> findAll();

    List<AccDesplazaA> findByEstadoReg();

    List<AccDesplazaA> findRange(int[] range);

    int count();

}
