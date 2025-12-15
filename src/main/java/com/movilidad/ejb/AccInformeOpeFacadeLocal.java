/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AccInformeOpe;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface AccInformeOpeFacadeLocal {

    void create(AccInformeOpe accInformeOpe);

    void edit(AccInformeOpe accInformeOpe);

    void remove(AccInformeOpe accInformeOpe);

    AccInformeOpe find(Object id);

    List<AccInformeOpe> findAll();

    List<AccInformeOpe> findRange(int[] range);

    int count();
    
}
