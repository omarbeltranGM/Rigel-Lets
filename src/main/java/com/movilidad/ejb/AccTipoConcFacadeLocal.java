package com.movilidad.ejb;

import com.movilidad.model.AccTipoConc;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface AccTipoConcFacadeLocal {

    void create(AccTipoConc accTipoConc);

    void edit(AccTipoConc accTipoConc);

    void remove(AccTipoConc accTipoConc);

    AccTipoConc find(Object id);

    List<AccTipoConc> findAll();

    List<AccTipoConc> findRange(int[] range);

    int count();
    
    List<AccTipoConc> estadoReg();
    
}
