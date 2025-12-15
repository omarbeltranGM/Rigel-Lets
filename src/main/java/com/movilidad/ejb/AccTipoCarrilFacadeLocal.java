package com.movilidad.ejb;

import com.movilidad.model.AccTipoCarril;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface AccTipoCarrilFacadeLocal {

    void create(AccTipoCarril accTipoCarril);

    void edit(AccTipoCarril accTipoCarril);

    void remove(AccTipoCarril accTipoCarril);

    AccTipoCarril find(Object id);

    List<AccTipoCarril> findAll();

    List<AccTipoCarril> findRange(int[] range);

    int count();
    
    List<AccTipoCarril> estadoReg();
    
}
