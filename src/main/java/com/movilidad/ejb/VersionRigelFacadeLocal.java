package com.movilidad.ejb;

import java.util.List;
import com.movilidad.model.VersionRigel;
import com.movilidad.model.VersionTipo;
import javax.ejb.Local;

/**
 *
 * @author Andres
 */
@Local
public interface VersionRigelFacadeLocal {

    void create(VersionRigel versionRigel);

    void edit(VersionRigel versionRigel);

    void remove(VersionRigel versionRigel);

    VersionRigel find(Object id);

    List<VersionRigel> findAll();

    List<VersionRigel> findRange(int[] range);

    int count();

    List<VersionRigel> findAllEstadoreg();

    /**
     * Busca una versión de rigel mediante su número de versión y tipo de
     * versión, principalmente para validar que no haya duplicados.
     *
     * @param version
     * @param tipoVersion
     * @return
     */
    VersionRigel findByVersionAndTipo(String version, VersionTipo tipoVersion);

    /**
     * Se consulta si existe un posible registro duplicado de una version al
     * momento de editar un registro.
     *
     * @param version
     * @param tipoVersion
     * @param idExcluido
     * @return
     */
    VersionRigel findDuplicadoEdit(String version, VersionTipo tipoVersion, Integer idExcluido);

    /**
     * Trae la última versión para actualizarla automáticamente en el icono de
     * versiones del topbar.
     *
     * @return
     */
    public VersionRigel findUltimaVersion();

}
