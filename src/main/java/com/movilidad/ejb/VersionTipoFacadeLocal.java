/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movilidad.ejb;

import com.movilidad.model.VersionTipo;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author Andres
 */
@Local
public interface VersionTipoFacadeLocal {

    void create(VersionTipo versionTipo);

    void edit(VersionTipo versionTipo);

    void remove(VersionTipo versionTipo);

    VersionTipo find(Object id);

    List<VersionTipo> findAll();

    List<VersionTipo> findRange(int[] range);

    int count();

    List<VersionTipo> findAllEstadoreg();
    List findNombreTipoVersion();
}
