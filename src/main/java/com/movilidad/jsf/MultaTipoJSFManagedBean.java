package com.movilidad.jsf;

import com.movilidad.ejb.MultaTipoFacadeLocal;
import com.movilidad.model.MultaTipo;
import com.movilidad.security.UserExtended;
import com.movilidad.utils.MovilidadUtil;
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
@Named(value = "multaTipoBean")
@ViewScoped
public class MultaTipoJSFManagedBean implements Serializable {

    @EJB
    private MultaTipoFacadeLocal multaTipoEjb;
    private MultaTipo multaTipo;
    private List<MultaTipo> lista;
    private MultaTipo selected;

    UserExtended user = (UserExtended) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    
    @PostConstruct
    public void init() {
        this.lista = this.multaTipoEjb.findAll();
        this.multaTipo = new MultaTipo();
        this.selected = null;
    }

    public void guardar() {
        multaTipo.setUsername(user.getUsername());
        multaTipo.setCreado(new Date());
        this.multaTipoEjb.create(multaTipo);
        init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Tipo de multa agregado."));
    }

    public void actualizar() {
        multaTipo.setUsername(user.getUsername());
        this.multaTipoEjb.edit(multaTipo);
        MovilidadUtil.hideModal("mtipo");
        MovilidadUtil.addSuccessMessage("Tipo de multa actualizado.");
    }

    public void editar() {
        this.multaTipo = this.selected;
    }

    public void cambiarEstado() {
        this.selected.setEstadoReg(1);
        this.multaTipoEjb.edit(selected);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Estado Tipo de multa cambiado éxitosamente."));
    }

    public void nuevo() {
        this.multaTipo = new MultaTipo();
        this.selected = null;
    }

    public MultaTipoFacadeLocal getMultaTipoEjb() {
        return multaTipoEjb;
    }

    public void setMultaTipoEjb(MultaTipoFacadeLocal multaTipoEjb) {
        this.multaTipoEjb = multaTipoEjb;
    }

    public MultaTipo getMultaTipo() {
        return multaTipo;
    }

    public void setMultaTipo(MultaTipo multaTipo) {
        this.multaTipo = multaTipo;
    }

    public MultaTipo getSelected() {
        return selected;
    }

    public void setSelected(MultaTipo selected) {
        this.selected = selected;
    }

    public List<MultaTipo> getLista() {
        return lista;
    }

    public void setLista(List<MultaTipo> lista) {
        this.lista = lista;
    }
}
