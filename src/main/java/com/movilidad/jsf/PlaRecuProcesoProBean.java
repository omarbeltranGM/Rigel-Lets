package com.movilidad.jsf;

import com.movilidad.ejb.PlaRecuProcesoHisFacadeLocal;
import com.movilidad.ejb.PlaRecuProcesoProDetFacadeLocal;
import com.movilidad.model.ParamAreaUsr;
import com.movilidad.model.planificacion_recursos.PlaRecuProcesoPro;
import com.movilidad.security.UserExtended;
import com.movilidad.utils.MovilidadUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.springframework.security.core.context.SecurityContextHolder;
import com.movilidad.ejb.PlaRecuProcesoProFacadeLocal;
import com.movilidad.model.GopUnidadFuncional;
import com.movilidad.model.planificacion_recursos.PlaRecuProcesoHis;
import com.movilidad.model.planificacion_recursos.PlaRecuProcesoProDet;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import jakarta.inject.Inject;
import org.primefaces.PrimeFaces;

@Named(value = "planRecuProcesoProBean")
@ViewScoped
public class PlaRecuProcesoProBean implements Serializable {

    @EJB
    private PlaRecuProcesoProFacadeLocal procesoProEJB;
    @EJB
    private PlaRecuProcesoProDetFacadeLocal procesoProDetEJB;
    @EJB
    private PlaRecuProcesoHisFacadeLocal procesoHisEJB;
    @Inject
    private GopUnidadFuncionalSessionBean unidadFuncionalSessionBean;

    //colecciones
    private List<PlaRecuProcesoPro> listProcesoPro;
    private List<PlaRecuProcesoProDet> listProcesoProDet;
    private List<PlaRecuProcesoHis> listProcesoHis = new ArrayList<>();
    private PlaRecuProcesoHis CreateProcesoHis;

    //atributos
    private ParamAreaUsr pau;
    UserExtended user = (UserExtended) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    private Double porcentaje;
    private PlaRecuProcesoPro nuevaEtapa;
    private String nuevoDetalle;
    private Integer nuevaDuracion;
    private GopUnidadFuncional uf;

    private Map<String, Double> progresoTotalPorEtapa;
    private Set<String> etapasMostradas;
    private Date fechaInicio;
    private Date fechaFin;
    private Date fechaInicioModal;
    private Date fechaFinModal;

    @PostConstruct
    public void init() {
        fechaInicioModal = null;
        fechaFinModal = null;
        uf = null;
        listProcesoPro = procesoProEJB.findAll();
        listProcesoProDet = procesoProDetEJB.findAll();
        progresoTotalPorEtapa = calcularProgresoTotalPorEtapa();
        calcularPromedioDuracion();
        etapasMostradas = new HashSet<>();
        nuevaEtapa = new PlaRecuProcesoPro();
        CreateProcesoHis = new PlaRecuProcesoHis();
    }

    public void consultar() {
        this.listProcesoHis = this.procesoHisEJB.findByDateRange(fechaInicio, fechaFin, unidadFuncionalSessionBean.obtenerIdGopUnidadFuncional());
    }

    public void cargarDatos() {
        PrimeFaces.current().executeScript("PF('dt_CheckList').clearFilters()");
        consultar();
        progresoTotalPorEtapa = calcularProgresoTotalPorEtapa();

        PrimeFaces.current().ajax().update("form-list:dt_CheckList");

        if (listProcesoHis == null || listProcesoHis.isEmpty()) {
            PrimeFaces.current().ajax().update(":msgs");
            MovilidadUtil.addAdvertenciaMessage("No se encontraron registros para éste rango de fechas");
        }
    }

    public boolean todosUnchecked(String descripcionEtapa) {
        return listProcesoHis.stream()
                .filter(item -> item.getIdPlaRecuProcesoProDet().getIdPlaRecuProcesoPro().getDescripcion().equals(descripcionEtapa))
                .allMatch(item -> !item.getIsChecked());
    }

    public String getProgresoPorEtapa(String descripcionEtapa) {
        double progreso = progresoTotalPorEtapa.getOrDefault(descripcionEtapa, 0.0);

        // Verifica si todos los registros de la etapa están en false
        boolean todosUnchecked = listProcesoHis.stream()
                .filter(item -> item.getIdPlaRecuProcesoProDet().getIdPlaRecuProcesoPro().getDescripcion().equals(descripcionEtapa))
                .allMatch(item -> !item.getIsChecked());

        if (todosUnchecked) {
            return "Sin progreso"; // Texto personalizado o valor predeterminado
        }

        return formatProgreso(progreso);
    }

    public Map<String, Double> calcularProgresoTotalPorEtapa() {
        Map<String, Double> progreso = new HashMap<>();

        for (PlaRecuProcesoHis item : listProcesoHis) {
            String descripcionEtapa = item.getIdPlaRecuProcesoProDet().getIdPlaRecuProcesoPro().getDescripcion();
            double totalDuracionEtapa = getTotalDuracionPorEtapa(descripcionEtapa);

            // Solo calcular progreso si hay duración total
            if (totalDuracionEtapa > 0) {
                double progresoEtapa = (item.getDuracion() * 100.0) / totalDuracionEtapa;

                // Sumar al progreso total si está marcado
                if (item.getIsChecked()) {
                    progreso.merge(descripcionEtapa, progresoEtapa, Double::sum);
                }
            }
        }

        return progreso;
    }

    // Método para obtener la suma total de duraciones por etapa
    public double getTotalDuracionPorEtapa(String descripcionEtapa) {
        return listProcesoHis.stream()
                .filter(item -> item.getIdPlaRecuProcesoProDet().getIdPlaRecuProcesoPro().getDescripcion().equals(descripcionEtapa))
                .mapToDouble(PlaRecuProcesoHis::getDuracion)
                .sum();
    }

    public Map<String, Double> getProgresoTotalPorEtapa() {
        return progresoTotalPorEtapa;
    }

    public void cambiarCheck(PlaRecuProcesoHis item) {
        item.setIsChecked(!item.getIsChecked());
        item.setModificado(new Date());
        item.setUsernameEdit(user.getUsername());
        procesoHisEJB.edit(item);

        // Recalcular progreso total y promedio después del cambio
        progresoTotalPorEtapa = calcularProgresoTotalPorEtapa();
        calcularPromedioDuracion();
    }

    public double calcularProgresoGeneral() {
        double progresoTotal = 0.0;
        int totalEtapas = 0;

        for (Map.Entry<String, Double> entry : progresoTotalPorEtapa.entrySet()) {
            progresoTotal += entry.getValue();
            totalEtapas++;
        }

        double promedio = (totalEtapas > 0) ? progresoTotal / totalEtapas : 0.0;
        return promedio * 100;
    }

    public String formatProgreso(Double valor) {
        if (valor == null) {
            return "0.00 %";
        }
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(valor) + " %";
    }

    public double calcularPromedioDuracion() {
        double sumaTotalDuracion = 0;
        double sumaDuracionChecked = 0;

        // Recorremos la lista de procesos
        for (PlaRecuProcesoHis item : listProcesoHis) {
            double duracion = item.getDuracion();
            sumaTotalDuracion += duracion;

            if (item.getIsChecked() == true) {
                sumaDuracionChecked += duracion;
            }
        }

        if (sumaTotalDuracion == 0) {
            return 0;
        }
        return (sumaDuracionChecked / sumaTotalDuracion) * 100;
    }

    public void guardarNuevoDetalle() {
        if (nuevaEtapa != null && nuevoDetalle != null && nuevaDuracion != null) {
            PlaRecuProcesoProDet nuevoRegistro = new PlaRecuProcesoProDet();
            nuevaEtapa = procesoProEJB.find(nuevaEtapa.getIdPlaRecuProcesoPro());
            nuevoRegistro.setIdPlaRecuProcesoPro(nuevaEtapa);
            nuevoRegistro.setDescripcion(nuevoDetalle);
            nuevoRegistro.setDuracion(nuevaDuracion);
            nuevoRegistro.setIsChecked(false); // Inicializamos como no marcado
            nuevoRegistro.setCreado(new Date());
            nuevoRegistro.setEstadoReg(0);
            nuevoRegistro.setUsernameCreate(user.getUsername());
            procesoProDetEJB.create(nuevoRegistro);

            MovilidadUtil.addSuccessMessage("Registro Creado correctamente");

            //nuevaEtapa = null;
            //nuevoDetalle = null;
            //(nuevaDuracion = null;
        } else {
            MovilidadUtil.addErrorMessage("Agregar todos los campos");
        }
    }

    public String getProgressBarClass(double value) {
        if (value < 30) {
            return "low-progress";
        } else if (value < 70) {
            return "medium-progress";
        } else {
            return "high-progress";
        }
    }

    public boolean mostrarProgreso(String etapa) {
        if (etapasMostradas.contains(etapa)) {
            return false;
        }
        etapasMostradas.add(etapa);
        return true;
    }

    public void resetEtapasMostradas() {
        etapasMostradas.clear();
    }

    public boolean esPrimeraFila(String etapa, int index) {
        for (int i = 0; i < index; i++) {
            if (listProcesoHis.get(i).getIdPlaRecuProcesoProDet().getIdPlaRecuProcesoPro().getDescripcion().equals(etapa)) {
                return false;
            }
        }
        return true;
    }

    public Long existeRegistros() {
        return procesoHisEJB.findCounty(fechaInicioModal, fechaFinModal, unidadFuncionalSessionBean.obtenerIdGopUnidadFuncional());
    }

    public void crearListaChequeo() {
        uf = new GopUnidadFuncional();
        uf.setIdGopUnidadFuncional(unidadFuncionalSessionBean.obtenerIdGopUnidadFuncional());

        if (uf.getIdGopUnidadFuncional() == 0) {
            MovilidadUtil.addAdvertenciaMessage("Debe seleccionar un grupo de unidad funcional");
            return;
        }
        if (fechaInicioModal.after(fechaFinModal)) {
            MovilidadUtil.addAdvertenciaMessage("'Fecha Fin' no puede ser menor que 'Fecha Inicio'.");
            return;
        }
        if (existeRegistros() > 0) {
            MovilidadUtil.addErrorMessage("Existe registros para las fechas seleccionadas");
            return;
        }
        try {
            for (PlaRecuProcesoProDet list : listProcesoProDet) {
                PlaRecuProcesoHis nuevoProcesoHis = new PlaRecuProcesoHis();
                nuevoProcesoHis.setDescripcion(list.getDescripcion());
                nuevoProcesoHis.setDuracion(list.getDuracion());
                nuevoProcesoHis.setCreado(new Date());
                nuevoProcesoHis.setEstadoReg(0);
                nuevoProcesoHis.setFechaFin(fechaFinModal);
                nuevoProcesoHis.setFechaIni(fechaInicioModal);
                nuevoProcesoHis.setIdGopUnidadFuncional(uf);
                nuevoProcesoHis.setIdPlaRecuProcesoProDet(list);
                nuevoProcesoHis.setIsChecked(Boolean.FALSE);
                nuevoProcesoHis.setUsernameCreate(user.getUsername());

                procesoHisEJB.create(nuevoProcesoHis);
            }

            PrimeFaces.current().executeScript("PF('wvPlaRecuList').hide();");
            MovilidadUtil.addSuccessMessage("Registro Creado");

        } catch (Exception e) {
            MovilidadUtil.addErrorMessage("Error al crear el registro: " + e.getMessage());
        }
    }

    public void prepararExportacion() {
        cargarDatos();  // Asegura que los datos están actualizados
    }

    public boolean validarCheck(Date fechaInicio, Date fechaFin) {
        if (fechaInicio == null || fechaFin == null) {
            return false;
        }

        LocalDate hoy = LocalDate.now();
        LocalDate inicio = fechaInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fin = fechaFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        boolean dentroDelRango = !hoy.isBefore(inicio) && !hoy.isAfter(fin);
        boolean rangoFuturo = hoy.isBefore(inicio);

        return dentroDelRango || rangoFuturo;
    }

    public PlaRecuProcesoProFacadeLocal getProcesoProEJB() {
        return procesoProEJB;
    }

    public Set<String> getEtapasMostradas() {
        return etapasMostradas;
    }

    public void setEtapasMostradas(Set<String> etapasMostradas) {
        this.etapasMostradas = etapasMostradas;
    }

    public void setProcesoProEJB(PlaRecuProcesoProFacadeLocal procesoProEJB) {
        this.procesoProEJB = procesoProEJB;
    }

    public PlaRecuProcesoProDetFacadeLocal getProcesoProDetEJB() {
        return procesoProDetEJB;
    }

    public void setProcesoProDetEJB(PlaRecuProcesoProDetFacadeLocal procesoProDetEJB) {
        this.procesoProDetEJB = procesoProDetEJB;
    }

    public List<PlaRecuProcesoPro> getListProcesoPro() {
        return listProcesoPro;
    }

    public void setListProcesoPro(List<PlaRecuProcesoPro> listProcesoPro) {
        this.listProcesoPro = listProcesoPro;
    }

    public List<PlaRecuProcesoProDet> getListProcesoProDet() {
        return listProcesoProDet;
    }

    public void setListProcesoProDet(List<PlaRecuProcesoProDet> listProcesoProDet) {
        this.listProcesoProDet = listProcesoProDet;
    }

    public UserExtended getUser() {
        return user;
    }

    public void setUser(UserExtended user) {
        this.user = user;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public PlaRecuProcesoPro getNuevaEtapa() {
        return nuevaEtapa;
    }

    public void setNuevaEtapa(PlaRecuProcesoPro nuevaEtapa) {
        this.nuevaEtapa = nuevaEtapa;
    }

    public String getNuevoDetalle() {
        return nuevoDetalle;
    }

    public void setNuevoDetalle(String nuevoDetalle) {
        this.nuevoDetalle = nuevoDetalle;
    }

    public Integer getNuevaDuracion() {
        return nuevaDuracion;
    }

    public void setNuevaDuracion(Integer nuevaDuracion) {
        this.nuevaDuracion = nuevaDuracion;
    }

    public List<PlaRecuProcesoHis> getListProcesoHis() {
        return listProcesoHis;
    }

    public void setListProcesoHis(List<PlaRecuProcesoHis> listProcesoHis) {
        this.listProcesoHis = listProcesoHis;
    }

    public PlaRecuProcesoHisFacadeLocal getProcesoHisEJB() {
        return procesoHisEJB;
    }

    public void setProcesoHisEJB(PlaRecuProcesoHisFacadeLocal procesoHisEJB) {
        this.procesoHisEJB = procesoHisEJB;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicioModal() {
        return fechaInicioModal;
    }

    public void setFechaInicioModal(Date fechaInicioModal) {
        this.fechaInicioModal = fechaInicioModal;
    }

    public Date getFechaFinModal() {
        return fechaFinModal;
    }

    public void setFechaFinModal(Date fechaFinModal) {
        this.fechaFinModal = fechaFinModal;
    }

    public PlaRecuProcesoHis getCreateProcesoHis() {
        return CreateProcesoHis;
    }

    public void setCreateProcesoHis(PlaRecuProcesoHis CreateProcesoHis) {
        this.CreateProcesoHis = CreateProcesoHis;
    }

    public GopUnidadFuncional getUf() {
        return uf;
    }

    public void setUf(GopUnidadFuncional uf) {
        this.uf = uf;
    }

}
