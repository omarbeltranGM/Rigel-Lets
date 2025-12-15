package com.movilidad.ejb;

import com.movilidad.model.AccCondInfra;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface AccCondInfraFacadeLocal {

    void create(AccCondInfra accCondInfra);

    void edit(AccCondInfra accCondInfra);

    void remove(AccCondInfra accCondInfra);

    AccCondInfra find(Object id);

    List<AccCondInfra> findAll();

    List<AccCondInfra> findRange(int[] range);

    int count();

    List<AccCondInfra> estadoReg();

}
