package com.movilidad.ejb;

import com.movilidad.model.AccArbol;
import java.util.List;
import jakarta.ejb.Local;

/**
 * 
 * @author HP
 */
@Local
public interface AccArbolFacadeLocal {

    void create(AccArbol accArbol);

    void edit(AccArbol accArbol);

    void remove(AccArbol accArbol);

    AccArbol find(Object id);

    List<AccArbol> findAll();

    List<AccArbol> findRange(int[] range);

    int count();

    List<AccArbol> estadoReg();
    

}
