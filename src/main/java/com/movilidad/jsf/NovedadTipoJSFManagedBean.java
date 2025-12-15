package com.movilidad.jsf;

import com.movilidad.ejb.NovedadTipoFacadeLocal;
import com.movilidad.model.NovedadTipo;
import com.movilidad.security.UserExtended;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Carlos Ballestas
 */
@Named(value = "novedadTipoBean")
@ViewScoped
public class NovedadTipoJSFManagedBean implements Serializable {

    @EJB
    private NovedadTipoFacadeLocal novedadTipoEjb;
    private NovedadTipo novedadTipo;
    private List<NovedadTipo> lista;
    private NovedadTipo selected;
    
    UserExtended user = (UserExtended) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    

    @PostConstruct
    public void init() {
        this.lista = this.novedadTipoEjb.findAll();
        this.novedadTipo = new NovedadTipo();
        this.selected = null;
    }

    public void guardar() {
        novedadTipo.setUsername(user.getUsername());
        novedadTipo.setCreado(new Date());
        this.novedadTipoEjb.create(novedadTipo);
        init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Tipo de novedad agregado."));
    }

    public void actualizar() {
        novedadTipo.setUsername(user.getUsername());
        this.novedadTipoEjb.edit(novedadTipo);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Tipo de novedad actualizado."));
    }

    public void editar() {
        this.novedadTipo = this.selected;
    }

    public void cambiarEstado() {
        this.selected.setEstadoReg(1);
        this.novedadTipoEjb.edit(selected);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Estado Tipo de novedad cambiado éxitosamente."));
    }

    public void nuevo() {
        this.novedadTipo = new NovedadTipo();
        this.selected = null;
    }

    public NovedadTipoFacadeLocal getNovedadTipoEjb() {
        return novedadTipoEjb;
    }

    public void setNovedadTipoEjb(NovedadTipoFacadeLocal novedadTipoEjb) {
        this.novedadTipoEjb = novedadTipoEjb;
    }

    public NovedadTipo getNovedadTipo() {
        return novedadTipo;
    }

    public void setNovedadTipo(NovedadTipo novedadTipo) {
        this.novedadTipo = novedadTipo;
    }

    public NovedadTipo getSelected() {
        return selected;
    }

    public void setSelected(NovedadTipo selected) {
        this.selected = selected;
    }

    public List<NovedadTipo> getLista() {
        return lista;
    }

    public void setLista(List<NovedadTipo> lista) {
        this.lista = lista;
    }

}
