/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AccInformeMasterVic;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface AccInformeMasterVicFacadeLocal {

    void create(AccInformeMasterVic accInformeMasterVic);

    void edit(AccInformeMasterVic accInformeMasterVic);

    void remove(AccInformeMasterVic accInformeMasterVic);

    AccInformeMasterVic find(Object id);

    List<AccInformeMasterVic> findAll();

    List<AccInformeMasterVic> findRange(int[] range);

    int count();
    
}
