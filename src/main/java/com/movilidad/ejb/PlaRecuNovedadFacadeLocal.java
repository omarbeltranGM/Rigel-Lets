package com.movilidad.ejb;

import com.movilidad.model.planificacion_recursos.PlaRecuNovedad;
import java.util.Date;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author Omar.beltran
 */
@Local
public interface PlaRecuNovedadFacadeLocal {
    
    void create(PlaRecuNovedad plaRecuNovedad);

    void edit(PlaRecuNovedad plaRecuNovedad);

    void remove(PlaRecuNovedad plaRecuNovedad);

    PlaRecuNovedad find(Object id);

    int count();
    
    List<PlaRecuNovedad> findAll();
    
    PlaRecuNovedad findNovedad(PlaRecuNovedad plaRecuNovedad);
    
    PlaRecuNovedad findByName(String name);
    
    PlaRecuNovedad findById(String id);
}

