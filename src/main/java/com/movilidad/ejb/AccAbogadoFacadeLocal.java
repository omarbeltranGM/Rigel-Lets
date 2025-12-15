package com.movilidad.ejb;

import com.movilidad.model.AccAbogado;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author Carlos Ballestas
 */
@Local
public interface AccAbogadoFacadeLocal {

    void create(AccAbogado accAbogado);

    void edit(AccAbogado accAbogado);

    void remove(AccAbogado accAbogado);

    AccAbogado find(Object id);

    List<AccAbogado> findAll();

    List<AccAbogado> findRange(int[] range);

    int count();
    
}
