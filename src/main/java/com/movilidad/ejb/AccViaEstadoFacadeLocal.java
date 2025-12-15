/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.ejb;

import com.movilidad.model.AccViaEstado;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface AccViaEstadoFacadeLocal {

    void create(AccViaEstado accViaEstado);

    void edit(AccViaEstado accViaEstado);

    void remove(AccViaEstado accViaEstado);

    AccViaEstado find(Object id);

    List<AccViaEstado> findAll();

    List<AccViaEstado> findRange(int[] range);

    int count();

    List<AccViaEstado> estadoReg();

}
