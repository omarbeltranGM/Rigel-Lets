package com.movilidad.ejb;

import com.movilidad.model.GenericaPmGrupoParam;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author Carlos Ballestas
 */
@Local
public interface GenericaPmGrupoParamFacadeLocal {

    void create(GenericaPmGrupoParam genericaPmGrupoParam);

    void edit(GenericaPmGrupoParam genericaPmGrupoParam);

    void remove(GenericaPmGrupoParam genericaPmGrupoParam);

    GenericaPmGrupoParam find(Object id);

    GenericaPmGrupoParam findByIdArea(int idArea);

    GenericaPmGrupoParam verificarRegistro(Integer idArea);

    List<GenericaPmGrupoParam> findAll(Integer idArea);

    List<GenericaPmGrupoParam> findAllEstadoReg();

    List<GenericaPmGrupoParam> findRange(int[] range);

    int count();

}
