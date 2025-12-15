/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AccCausa;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface AccCausaFacadeLocal {

    void create(AccCausa accCausa);

    void edit(AccCausa accCausa);

    void remove(AccCausa accCausa);

    AccCausa find(Object id);

    List<AccCausa> findAll();

    List<AccCausa> findRange(int[] range);

    int count();
    
    List<AccCausa> estadoReg();
    
    List<AccCausa> findByArbol(int i_idAccArbol);
    
}
