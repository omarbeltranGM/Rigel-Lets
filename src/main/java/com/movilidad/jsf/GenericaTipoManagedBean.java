package com.movilidad.jsf;

import com.movilidad.ejb.GenericaTipoFacadeLocal;
import com.movilidad.model.GenericaTipo;
import com.movilidad.model.ParamAreaUsr;
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
import org.primefaces.PrimeFaces;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Carlos Ballestas
 */
@Named(value = "genericaTipoBean")
@ViewScoped
public class GenericaTipoManagedBean implements Serializable {

    @EJB
    private GenericaTipoFacadeLocal genericaTipoEjb;
    private GenericaTipo genericaTipo;
    private List<GenericaTipo> lista;
    private GenericaTipo selected;
    private ParamAreaUsr paramAreaUsr;
    private boolean flagBtnNuevo = false;

    UserExtended user = (UserExtended) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    @PostConstruct
    public void init() {
        paramAreaUsr = genericaTipoEjb.findByUsername(user.getUsername());
        if (paramAreaUsr != null) {
            this.lista = this.genericaTipoEjb.findAllByArea(paramAreaUsr.getIdParamArea().getIdParamArea());
        } else {
            this.lista = null;
            flagBtnNuevo = true;
        }
        this.genericaTipo = new GenericaTipo();
        this.selected = null;
    }

    public void guardar() {
        genericaTipo.setUsername(user.getUsername());
        genericaTipo.setCreado(new Date());
        genericaTipo.setIdParamArea(paramAreaUsr.getIdParamArea());
        this.genericaTipoEjb.create(genericaTipo);
        lista.add(genericaTipo);
        nuevo();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Tipo de novedad agregado."));
    }

    public void actualizar() {
        genericaTipo.setUsername(user.getUsername());
        genericaTipo.setModificado(new Date());
        genericaTipo.setIdParamArea(paramAreaUsr.getIdParamArea());
        this.genericaTipoEjb.edit(genericaTipo);
        PrimeFaces.current().executeScript("PF('mtipo').hide();");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Tipo de novedad actualizado."));
    }

    public void editar() {
        this.genericaTipo = this.selected;
    }

    public void cambiarEstado() {
        this.selected.setEstadoReg(1);
        this.genericaTipoEjb.edit(selected);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Estado Tipo de novedad cambiado éxitosamente."));
    }

    public void nuevo() {
        this.genericaTipo = new GenericaTipo();
        this.selected = null;
    }

    public GenericaTipoFacadeLocal getGenericaTipoEjb() {
        return genericaTipoEjb;
    }

    public void setGenericaTipoEjb(GenericaTipoFacadeLocal genericaTipoEjb) {
        this.genericaTipoEjb = genericaTipoEjb;
    }

    public GenericaTipo getGenericaTipo() {
        return genericaTipo;
    }

    public void setGenericaTipo(GenericaTipo genericaTipo) {
        this.genericaTipo = genericaTipo;
    }

    public GenericaTipo getSelected() {
        return selected;
    }

    public void setSelected(GenericaTipo selected) {
        this.selected = selected;
    }

    public List<GenericaTipo> getLista() {
        return lista;
    }

    public void setLista(List<GenericaTipo> lista) {
        this.lista = lista;
    }

    public ParamAreaUsr getParamAreaUsr() {
        return paramAreaUsr;
    }

    public void setParamAreaUsr(ParamAreaUsr paramAreaUsr) {
        this.paramAreaUsr = paramAreaUsr;
    }

    public boolean isFlagBtnNuevo() {
        return flagBtnNuevo;
    }

    public void setFlagBtnNuevo(boolean flagBtnNuevo) {
        this.flagBtnNuevo = flagBtnNuevo;
    }
}