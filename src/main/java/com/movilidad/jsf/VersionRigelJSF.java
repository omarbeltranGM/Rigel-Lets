package com.movilidad.jsf;

import java.io.Serializable;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import com.movilidad.ejb.VersionRigelFacadeLocal;
import com.movilidad.model.VersionRigel;
import com.movilidad.utils.MovilidadUtil;
import com.movilidad.model.VersionTipo;
import com.movilidad.ejb.VersionTipoFacadeLocal;
import com.movilidad.security.UserExtended;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Andres Luna
 */
@Named(value = "versionRigelJSF")
@ViewScoped

public class VersionRigelJSF implements Serializable {

    @EJB
    private VersionRigelFacadeLocal versionRigelEJB;
    @EJB
    private VersionTipoFacadeLocal versionTipoEJB;

    private VersionRigel nuevaVersion = new VersionRigel();

    //Lista para mostrar en el panel principal de versiones.
    private List<VersionRigel> listaVersiones;
    private List<VersionTipo> itemsVersiones;

    private VersionRigel selected;
    private VersionRigel selectedEdit;

    private String tipoVersion;
    private Integer idTipoVersionSelecccionado;

    public List<VersionRigel> getListaVersiones() {
        if (listaVersiones == null) {
            listaVersiones = versionRigelEJB.findAllEstadoreg();
        }
        return listaVersiones;
    }
    
    public VersionRigel getUltimaVersion(){
        return versionRigelEJB.findUltimaVersion();
    }

    public void guardar() {
        try {
            if (idTipoVersionSelecccionado != null) {
                VersionTipo vt = versionTipoEJB.find(idTipoVersionSelecccionado);
                nuevaVersion.setIdVersionTipo(vt);

                VersionRigel duplicada = versionRigelEJB.findByVersionAndTipo(nuevaVersion.getVersion(), vt);
                if (duplicada != null) {
                    MovilidadUtil.addErrorMessage("La nota versión ya existe.");
                    FacesContext.getCurrentInstance().validationFailed(); //Se interpreta que hubo un error en la validacion y el modal no se cierra
                    return;
                }
            }
            if (nuevaVersion.getEstadoReg() == null) {
                nuevaVersion.setEstadoReg(0);
            }
            nuevaVersion.setCreado(new Date());
            //Se obtiene el usuario en sesión y se asigna a la nueva nota de versión
            UserExtended user = (UserExtended) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            nuevaVersion.setUsernameCreate(user.getUsername());
            versionRigelEJB.create(nuevaVersion);
            listaVersiones = versionRigelEJB.findAllEstadoreg();
            MovilidadUtil.addSuccessMessage("Nota de versión creada correctamente");
            nuevaVersion = new VersionRigel();
            idTipoVersionSelecccionado = null;
        } catch (Exception e) {
            MovilidadUtil.addErrorMessage("Error al crear la nota de versión" + e.getMessage());
            FacesContext.getCurrentInstance().validationFailed();
        }

    }

    public List<VersionTipo> getItemsVersiones() {
        if (itemsVersiones == null) {
            itemsVersiones = versionTipoEJB.findAllEstadoreg();
        }
        return itemsVersiones;
    }

    public void prepareEdit() {
        if (selected != null) {
            if (selected.getIdVersionRigel() != null) {
                this.idTipoVersionSelecccionado = selected.getIdVersionTipo().getIdVersionTipo();
            }
            this.selectedEdit = new VersionRigel();
            this.selectedEdit.setIdVersionRigel(selected.getIdVersionRigel());
            this.selectedEdit.setFecha(selected.getFecha());
            this.selectedEdit.setVersion(selected.getVersion());
            this.selectedEdit.setIdVersionTipo(selected.getIdVersionTipo());
            this.selectedEdit.setObservaciones(selected.getObservaciones());
            MovilidadUtil.openModal("VersionEditDialog");
        } else {
            MovilidadUtil.addErrorMessage("");
        }
    }

    public void editar() {
        try {
            if (selectedEdit != null) {
                if (idTipoVersionSelecccionado != null) {
                    VersionTipo vt = versionTipoEJB.find(idTipoVersionSelecccionado);
                    selectedEdit.setIdVersionTipo(vt);
                    VersionRigel duplicado = versionRigelEJB.findDuplicadoEdit(selectedEdit.getVersion(), selectedEdit.getIdVersionTipo(), selectedEdit.getIdVersionRigel());
                    if (duplicado != null) {
                        MovilidadUtil.addErrorMessage("Ya existe una nota de versión con estos datos.");
                        FacesContext.getCurrentInstance().validationFailed();
                        selectedEdit = versionRigelEJB.find(selectedEdit.getIdVersionRigel());
                        return;
                    }
                }
                selected.setFecha(selectedEdit.getFecha());
                selected.setVersion(selectedEdit.getVersion());
                selected.setIdVersionTipo(selectedEdit.getIdVersionTipo());
                selected.setObservaciones(selectedEdit.getObservaciones());
                UserExtended user = (UserExtended) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                selected.setUsernameEdit(user.getUsername());
                selected.setModificado(new Date());
                versionRigelEJB.edit(selected);
                listaVersiones = versionRigelEJB.findAllEstadoreg();
                MovilidadUtil.addSuccessMessage("Nota de versión actualizada correctamente");
            } else {
                MovilidadUtil.addErrorMessage("No hay versión seleccionada para editar");
            }
        } catch (Exception e) {
            MovilidadUtil.addErrorMessage("Error al actualizar la nota de versión: " + e.getMessage());
        }
    }

    public List<VersionRigel> getUltimasVersiones() {
        if (listaVersiones == null) {
            listaVersiones = versionRigelEJB.findAllEstadoreg();
        }
        return listaVersiones.stream().limit(5).collect(Collectors.toList());
    }

    public String convertirDescripcionHTML(String texto) {
        if (texto == null || texto.isEmpty()) {
            return "";
        }
        String[] lineas = texto.split("\\r?\\n");
        StringBuilder sb = new StringBuilder("<ul class='ajustes-lista'>");

        for (String i : lineas) {
            String trimmed = i.trim();

            //Se valida si el texto empieza por "-" o "*"
            if (trimmed.matches("^[-*]\\s*.*")) {
                //Expresion regular para reemplazar "-" o "*" para que quede ordenado en la vista
                sb.append("<li>").append(i.replaceFirst("^[-*]\\s*", "")).append("</li>");
            } //Si empieza por un numero seguido de un punto "1." se ordena por viñetas
            else if (trimmed.matches("^\\d+\\.\\s*.*")) {
                sb.append("<li>").append(trimmed.replaceFirst("^\\d+\\.\\s*", "")).append("</li>");
            } else {
                sb.append("<div>").append(trimmed).append("</div>");
            }
        }
        sb.append("</ul>");
        return sb.toString();
    }

    public String obtenerTextoExportar(Object value) {
        if (value == null) {
            return "";
        }
        String texto = value.toString();
        texto = texto.replace("(?i)<li>", "- ").replaceAll("(?i)</li>", "\n").replaceAll("(?i)<[^>]*>", "");
        return texto.trim();
    }

    public void onRowSelect(SelectEvent event) {
        this.selected = (VersionRigel) event.getObject();
        MovilidadUtil.addSuccessMessage("Version seleccionada: " + selected.getVersion());
    }

    public void onUnRowSelect(SelectEvent event) {
        this.selected = null;
    }

    public VersionRigelFacadeLocal getVersionRigelFacadeLocal() {
        return versionRigelEJB;
    }

    public void setVersionRigelFacadeLocal(VersionRigelFacadeLocal versionRigelFacadeLocal) {
        this.versionRigelEJB = versionRigelFacadeLocal;
    }

    public VersionRigel getNuevaVersion() {
        return nuevaVersion;
    }

    public void setNuevaVersion(VersionRigel nuevaVersion) {
        this.nuevaVersion = nuevaVersion;
    }

    public String getTipoVersion() {
        return tipoVersion;
    }

    public void setTipoVersion(String tipoVersion) {
        this.tipoVersion = tipoVersion;
    }

    public Integer getIdTipoVersionSelecccionado() {
        return idTipoVersionSelecccionado;
    }

    public void setIdTipoVersionSelecccionado(Integer idTipoVersionSelecccionado) {
        this.idTipoVersionSelecccionado = idTipoVersionSelecccionado;
    }

    public VersionRigel getSelected() {
        return selected;
    }

    public void setSelected(VersionRigel selected) {
        this.selected = selected;
    }

    public VersionRigel getSelectedEdit() {
        return selectedEdit;
    }

    public void setSelectedEdit(VersionRigel selectedEdit) {
        this.selectedEdit = selectedEdit;
    }
}
