/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movilidad.jsf;

import com.aja.jornada.controller.GenericaJornadaFlexible;
import com.aja.jornada.controller.calculator;
import com.aja.jornada.model.GenericaJornadaLiqUtil;
import com.aja.jornada.util.JornadaUtil;
import com.movilidad.ejb.GenericaJornadaFacadeLocal;
import com.movilidad.ejb.GenericaJornadaMotivoFacadeLocal;
import com.movilidad.ejb.GenericaJornadaTipoFacadeLocal;
import com.movilidad.ejb.GenericaJornadaTokenFacadeLocal;
import com.movilidad.ejb.NotificacionCorreoConfFacadeLocal;
import com.movilidad.ejb.NotificacionTemplateFacadeLocal;
import com.movilidad.ejb.ParamFeriadoFacadeLocal;
import com.movilidad.model.Empleado;
import com.movilidad.model.GenericaJornada;
import com.movilidad.model.GenericaJornadaMotivo;
import com.movilidad.model.GenericaJornadaParam;
import com.movilidad.model.GenericaJornadaTipo;
import com.movilidad.model.GenericaJornadaToken;
import com.movilidad.model.NotificacionCorreoConf;
import com.movilidad.model.NotificacionTemplate;
import com.movilidad.model.ParamAreaUsr;
import com.movilidad.model.ParamFeriado;
import com.movilidad.security.UserExtended;
import com.movilidad.utils.ConstantsUtil;
import com.movilidad.utils.MovilidadUtil;
import com.movilidad.utils.SendMails;
import com.movilidad.utils.TokenGeneratorUtil;
import com.movilidad.utils.Util;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;
import static com.aja.jornada.util.Util.getDiaSemana;
import com.movilidad.utils.UtilJornada;
import com.movilidad.ejb.ParamAreaUsrFacadeLocal;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.security.core.GrantedAuthority;
import java.util.stream.Collectors;
import java.util.ArrayList;

/**
 *
 * @author solucionesit
 */
@Named(value = "calcularMasivoBean")
@ViewScoped
public class CalcularMasivoJSFManagedBean implements Serializable {

    private static final Logger log = Logger.getGlobal();
    @EJB
    private GenericaJornadaFacadeLocal genJornadaEJB;
    @EJB
    private GenericaJornadaTipoFacadeLocal jornadaTEJB;

    @EJB
    private NotificacionCorreoConfFacadeLocal NCCEJB;
    @EJB
    private GenericaJornadaMotivoFacadeLocal jornadaMotivoEJB;

    @EJB
    private ParamFeriadoFacadeLocal paraFeEJB;

    @EJB
    private NotificacionTemplateFacadeLocal notificacionTemplateEjb;

    @EJB
    private GenericaJornadaTokenFacadeLocal genJornadaTokenEJB;
    @EJB
    private ParamAreaUsrFacadeLocal paramAreaUserEJB;
   
    private GenericaJornadaParam genJornadaParam;
    private ParamAreaUsr pau;
    private boolean b_jornada_flexible = false;

    private Map<String, GenericaJornadaTipo> mapJornadaTipo;
    private Map<String, ParamFeriado> mapParamFeriado;
    String rol_user = "";
    String totalHorasAsignadas = calculator.hr_cero;
    String horasJornada;
    String horasExtrasDia;
    String horasMitadJornada;

    Date fechaDesde = MovilidadUtil.fechaHoy();
    Date fechaHasta = MovilidadUtil.fechaHoy();

    private List<GenericaJornada> genericaJornadaList;

    UserExtended user = (UserExtended) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    private GenericaJornadaFlexible flexible;

    public GenericaJornadaFlexible getJornadaFlexible() {
        if (flexible == null) {
            flexible = new GenericaJornadaFlexible();
        }
        return flexible;
    }

    @PostConstruct
    public void init() {
        for (GrantedAuthority auth : user.getAuthorities()) {
            rol_user = auth.getAuthority();
        }
        //Objeto param area user 

    }

    public boolean jornadaFlexible() {
        return pau == null ? false : pau.getIdParamArea() == null
                ? false : pau.getIdParamArea().getJornadaFlexible() == null ? false
                : pau.getIdParamArea().getJornadaFlexible().equals(1);
    }

    /**
     * Creates a new instance of CalcularMasivoJSFManagedBean
     */
    public CalcularMasivoJSFManagedBean() {
        horasJornada = UtilJornada.getTotalHrsLaborales();
        horasExtrasDia = UtilJornada.getMaxHrsExtrasDia();
        horasMitadJornada = "04:00:00";//si se desea ser exacto este valor debería ser la mitad del valor parametrizado como tiempo jornada, es decir, horasJornada
    }

    /**
     * Responsable de cargar la data de jornadas para ser presentada en la vista
     * principal del modulo.
     *
     * La variables fechaDesde y fechaHasta, son seleccionadas por el usurio
     * desde la vista principla.
     *
     * Limpia los filtros del DataTable de la vista principal.
     *
     */
    public void cargarDatos() {
        calculator.reset();
        if (pau != null) {
            this.genericaJornadaList = genJornadaEJB.getByDate(fechaDesde, fechaHasta, pau.getIdParamArea().getIdParamArea());

        }
//        PrimeFaces.current().executeScript("PF('dtserconlist').clearFilters()");
    }

    /**
     * Valida que la horas sean todas positivas
     *
     * @param gj
     * @return true si las horas son negativas, flase si no.
     */
    public boolean validarHorasPositivas(GenericaJornada gj) {
        if (MovilidadUtil.toSecs(gj.getDiurnas()) < 0) {
            return true;
        }
        if (MovilidadUtil.toSecs(gj.getNocturnas()) < 0) {
            return true;
        }
        if (MovilidadUtil.toSecs(gj.getExtraDiurna()) < 0) {
            return true;
        }
        if (MovilidadUtil.toSecs(gj.getExtraNocturna()) < 0) {
            return true;
        }
        if (MovilidadUtil.toSecs(gj.getFestivoDiurno()) < 0) {
            return true;
        }
        if (MovilidadUtil.toSecs(gj.getFestivoNocturno()) < 0) {
            return true;
        }
        if (MovilidadUtil.toSecs(gj.getFestivoExtraDiurno()) < 0) {
            return true;
        }
        if (MovilidadUtil.toSecs(gj.getFestivoExtraNocturno()) < 0) {
            return true;
        }
        return false;
    }

    public void cargarMapaTipoJornada() {
        mapJornadaTipo = new HashMap<>();
        List<GenericaJornadaTipo> findAllByArea = jornadaTEJB.findAllByArea(
                pau.getIdParamArea().getIdParamArea());
        findAllByArea.forEach((obj) -> {
            mapJornadaTipo.put(obj.getHiniT1() + "_" + obj.getHfinT1(), obj);
        });
    }

    /**
     * Método responsable de calcular jornadas por rango de fechas al invocar el
     * método cargarCalcularDato.
     *
     * Valida que las jornadas no esten liquidadas.
     *
     * @throws java.text.ParseException
     */
    public void cargarCalcularDatos() throws ParseException {
        
        try {            
            // Validación inicial de parámetros
            if (pau == null || pau.getIdParamArea() == null) {
                MovilidadUtil.addErrorMessage("Error: Área de parámetros no válida.");
                return;
            }

            if (fechaDesde == null || fechaHasta == null) {
                MovilidadUtil.addErrorMessage("Error: Fechas de consulta no válidas.");
                return;
            }

            // Cargar jornadas con manejo de errores
            List<GenericaJornada> listJornada = null;
            try {
                listJornada = genJornadaEJB.getByDate(fechaDesde, fechaHasta, pau.getIdParamArea().getIdParamArea());
            } catch (Exception e) {
                MovilidadUtil.addErrorMessage("Error al consultar las jornadas. Intente nuevamente.");
                return;
            }

            if (listJornada == null) {
                MovilidadUtil.addErrorMessage("No se encontraron jornadas en el rango de fechas especificado.");
                return;
            }

             // Filtrar jornadas no liquidadas
            List<GenericaJornada> jornadaNoLiquidada = listJornada.stream()
                    .filter(jornada -> jornada.getLiquidado() != null && jornada.getLiquidado() == 0)
                    .collect(Collectors.toList());

            if (!jornadaNoLiquidada.isEmpty()) {
                MovilidadUtil.addErrorMessage("No se ha bloqueado como liquidadas las jornadas en el rango de fechas seleccionado.");
                return;
            }

            // Validación de permisos y tiempo para usuarios no DIRGEN
            if (!validarPermisosTiempo()) {
                return;
            }

            // Cargar parámetros de jornada
            try {
                UtilJornada.cargarParametrosJar();
            } catch (Exception e) {
                MovilidadUtil.addErrorMessage("Error al cargar parámetros de configuración.");
                return;
            }

            // Inicializar variables
            genericaJornadaList = new ArrayList<>();
            b_jornada_flexible = false;

            // Cargar lista de jornadas y determinar si es flexible
            try {
                genericaJornadaList = genJornadaEJB.getByDate(fechaDesde, fechaHasta, pau.getIdParamArea().getIdParamArea());
                b_jornada_flexible = jornadaFlexible();
            } catch (Exception e) {
                MovilidadUtil.addErrorMessage("Error al procesar las jornadas.");
                return;
            }

            // Procesar según tipo de jornada
            if (b_jornada_flexible) {
                procesarJornadaFlexible();
            } else {
                procesarJornadaTradicional();
            }

            // Cargar datos finales
            try {
                cargarDatos();
                MovilidadUtil.addSuccessMessage("Acción completada exitosamente");
            } catch (Exception e) {
                MovilidadUtil.addErrorMessage("Proceso completado con advertencias. Verifique los resultados.");
            }
        } catch (Exception e) {
            //System.out.println("Error general en cargarCalcularDatos: " + e);
            MovilidadUtil.addErrorMessage("Error interno del sistema. Contacte al administrador.");
        }
    }
    
    /**
    * Valida permisos y restricciones de tiempo para usuarios no DIRGEN
    */
    private boolean validarPermisosTiempo() {
       try {
           if (!"ROLE_DIRGEN".equals(rol_user)) {
               int validacionDia = MovilidadUtil.fechasIgualMenorMayor(
                       MovilidadUtil.sumarDias(fechaDesde, 1), 
                       MovilidadUtil.fechaHoy(), 
                       false
               );

               if (genJornadaParam != null
                       && genJornadaParam.getCtrlAutorizarExtensionJornada() == 0
                       && validacionDia == 0) {
                   MovilidadUtil.addErrorMessage("No es posible modificar jornada, sobrepasa 24hrs después de su ejecución.");
                   return false;
               }
           }
           return true;
       } catch (Exception e) {
           MovilidadUtil.addErrorMessage("Error al validar permisos. Intente nuevamente.");
           return false;
       }
    }

    /**
     * Procesa jornadas flexibles
     */
    private void procesarJornadaFlexible() {
        try {
            Map<String, List<GenericaJornada>> mapJornadasSemanas = cargarMapSemanalDeJornadas(genericaJornadaList);

            for (Map.Entry<String, List<GenericaJornada>> entry : mapJornadasSemanas.entrySet()) {
                try {
                    procesarSemanaFlexible(entry);
                } catch (Exception e) {
                    //System.out.println("Error al procesar semana flexible: " + entry.getKey() +  e);
                    MovilidadUtil.addErrorMessage("Error al procesar semana: " + entry.getKey());
                    // Continúa con la siguiente semana
                }
            }
        } catch (Exception e) {
            //System.out.println("Error general en procesamiento de jornada flexible: " + e);
            MovilidadUtil.addErrorMessage("Error al procesar jornadas flexibles.");
        }
    }

    /**
     * Procesa una semana específica en jornada flexible
     */
    private void procesarSemanaFlexible(Map.Entry<String, List<GenericaJornada>> entry) throws Exception {
        //System.out.println("Procesando semana: " + entry.getKey() + " con " + entry.getValue().size() + " jornadas");

        String[] listaFecha = entry.getKey().split("_");
        if (listaFecha.length != 2) {
            throw new IllegalArgumentException("Formato de fecha de semana inválido: " + entry.getKey());
        }

        Date desde = Util.toDate(listaFecha[0]);
        Date hasta = Util.toDate(listaFecha[1]);

        if (desde == null || hasta == null) {
            throw new IllegalArgumentException("Fechas inválidas para la semana: " + entry.getKey());
        }

        Integer idParamArea = pau.getIdParamArea().getIdParamArea();

        // Cálculo ordinario de jornadas
        try {
            List<GenericaJornadaLiqUtil> calculoOrdinarioJornadas = 
                    getJornadaFlexible().calculoOrdinarioJornadas(desde, hasta, 1, idParamArea);
            //System.out.println("Cálculo ordinario: " + calculoOrdinarioJornadas.size() + " registros");
            genJornadaEJB.updatePrgSerconFromList(calculoOrdinarioJornadas, 0);
        } catch (Exception e) {
            //System.out.println("Error en cálculo ordinario de jornadas: " + e);
            throw new Exception("Error en cálculo ordinario", e);
        }

        // Cálculo de jornada flexible
        try {
            List<GenericaJornadaLiqUtil> calculoJornadaFlexible = 
                    getJornadaFlexible().calculoJornadaFlexible(desde, hasta, 1, idParamArea);
            //System.out.println("Cálculo flexible: " + calculoJornadaFlexible.size() + " registros");
            genJornadaEJB.updatePrgSerconFromList(calculoJornadaFlexible, 0);
        } catch (Exception e) {
            //System.out.println("Error en cálculo de jornada flexible: " + e);
            throw new Exception("Error en cálculo flexible", e);
        }

        // Distribución dominical sin compensatorio
        try {
            List<GenericaJornadaLiqUtil> distribuirDomicalSinCompensatorio = 
                    getJornadaFlexible().distribuirDomicalSinCompensatorio(desde, hasta, idParamArea);
            //System.out.println("Distribución dominical: " + distribuirDomicalSinCompensatorio.size() + " registros");
            genJornadaEJB.updatePrgSerconFromList(distribuirDomicalSinCompensatorio, 0);
        } catch (Exception e) {
            //System.out.println("Error en distribución dominical: " + e);
            throw new Exception("Error en distribución dominical", e);
        }
    }

    /**
     * Procesa jornadas tradicionales (no flexibles)
     */
    private void procesarJornadaTradicional() {
        try {
            cargarMapParamFeriado();
        } catch (Exception e) {
            //System.out.println("Error al cargar parámetros de feriados: " + e);
            MovilidadUtil.addErrorMessage("Error al cargar configuración de feriados.");
            return;
        }

        int jornadasProcesadas = 0;
        int jornadasConError = 0;

        for (GenericaJornada gj : genericaJornadaList) {
            try {
                if (esJornadaProcesable(gj)) {
                    procesarJornadaIndividual(gj);
                    jornadasProcesadas++;
                }
            } catch (Exception e) {
                jornadasConError++;
                //System.out.println("Error al procesar jornada ID: " + 
                //            (gj.getIdEmpleado() != null ? gj.getIdEmpleado().getIdentificacion() : "N/A") + e);

                if (jornadasConError > 10) { // Límite de errores para evitar spam de logs
                    //System.out.println("Demasiados errores en procesamiento. Deteniendo proceso.");
                    MovilidadUtil.addErrorMessage("Se han detectado múltiples errores. Proceso detenido.");
                    break;
                }
            }
        }

        //System.out.println("Jornadas procesadas: " + jornadasProcesadas + ", Con errores: " + jornadasConError);

        if (jornadasConError > 0) {
            MovilidadUtil.addAdvertenciaMessage("Se procesaron " + jornadasProcesadas + 
                                           " jornadas correctamente. " + jornadasConError + " con errores.");
        }
    }

    /**
     * Determina si una jornada es procesable
     */
    private boolean esJornadaProcesable(GenericaJornada gj) {
        return gj != null 
               && gj.getNominaBorrada() == 0 
               && (gj.getAutorizado() == null || (gj.getAutorizado() != null && gj.getAutorizado() == 1));
    }

    /**
     * Procesa una jornada individual
     */
    private void procesarJornadaIndividual(GenericaJornada gj) throws Exception {
        if (gj.getIdEmpleado() == null) {
            throw new IllegalArgumentException("Empleado no válido en jornada");
        }

        // Determinar tiempos a utilizar
        String timeOrigin, timeDestiny;
        boolean realTime = isRealTime(gj.getAutorizado(), gj.getPrgModificada(), gj.getRealTimeOrigin());
        if (realTime) {
            timeOrigin = gj.getRealTimeOrigin();
            timeDestiny = gj.getRealTimeDestiny();
        } else {
            timeOrigin = gj.getTimeOrigin();
            timeDestiny = gj.getTimeDestiny();
        }

        if (timeOrigin == null || timeDestiny == null) {
            throw new IllegalArgumentException("Tiempos de jornada no válidos para empleado: " + 
                                             gj.getIdEmpleado().getIdentificacion());
        }

        // Verificar si es jornada extra
        boolean b_jornadaExtra = esJornadaExtra(timeOrigin, timeDestiny);

        // ⭐ AGREGAR ESTA LÓGICA IGUAL QUE OPERADORES
        try {
            if (UtilJornada.esPorPartes(gj)) {
                cargarCalcularDatoPorPartes(gj, 3);
            } else {
                cargarCalcularDato(gj, 3);
            }         
        } catch (Exception e) {
            throw new Exception("Error al cargar/calcular datos para empleado: " + 
                              gj.getIdEmpleado().getIdentificacion(), e);
        }

        // Validar horas positivas
        if (validarHorasPositivas(gj)) {
            String empleadoInfo = gj.getIdEmpleado().getIdentificacion() + " - " + 
                                 gj.getIdEmpleado().getNombres() + " " + 
                                 gj.getIdEmpleado().getApellidos();
            MovilidadUtil.addErrorMessage("Error al calcular jornada: " + empleadoInfo);
            return;
        }

        // Procesar jornada extra si aplica
        if (b_jornadaExtra) {
            procesarJornadaExtra(gj);
        }

        // Validar y procesar autorizaciones
        procesarAutorizaciones(gj);

        // 🟦 LOG AGREGADO
        /*
        System.out.println("🟦 === CHECKPOINT ANTES DE EDITAR/RECALCULAR ===");
        System.out.println("🟦 ID Jornada: " + gj.getIdGenericaJornada());
        System.out.println("🟦 Empleado: " + gj.getIdEmpleado().getIdentificacion());
        System.out.println("🟦 Fecha: " + gj.getFecha());
        System.out.println("🟦 festivo_diurno: " + gj.getFestivoDiurno());
        System.out.println("🟦 festivo_nocturno: " + gj.getFestivoNocturno());
        System.out.println("🟦 dominical_comp_diurnas: " + gj.getDominicalCompDiurnas());
        System.out.println("🟦 dominical_comp_nocturnas: " + gj.getDominicalCompNocturnas());
        */

        // Guardar cambios
        try {
            genJornadaEJB.edit(gj);

            //System.out.println("🟦 Llamando a recalcularJornada()...");
            recalcularJornada(gj);

            // 🟩 LOG AGREGADO
            /*
            System.out.println("🟩 === CHECKPOINT DESPUÉS DE RECALCULAR ===");
            System.out.println("🟩 festivo_diurno: " + gj.getFestivoDiurno());
            System.out.println("🟩 festivo_nocturno: " + gj.getFestivoNocturno());
            System.out.println("🟩 dominical_comp_diurnas: " + gj.getDominicalCompDiurnas());
            System.out.println("🟩 dominical_comp_nocturnas: " + gj.getDominicalCompNocturnas());
            System.out.println("🟩 ========================================");
            */
        } catch (Exception e) {
            //System.out.println("🟥 ERROR en procesarJornadaIndividual: " + e.getMessage());
            e.printStackTrace();
            throw new Exception("Error al guardar jornada para empleado: " + 
                              gj.getIdEmpleado().getIdentificacion(), e);
        }
    }

    /**
     * Determina si es jornada extra
     */
    private boolean esJornadaExtra(String timeOrigin, String timeDestiny) {
        try {
            int tiempoTrabajado = MovilidadUtil.toSecs(timeDestiny) - MovilidadUtil.toSecs(timeOrigin);
            int horasJornadaSecs = MovilidadUtil.toSecs(horasJornada);
            int horasExtrasDiaSecs = MovilidadUtil.toSecs(horasExtrasDia);

            return tiempoTrabajado > horasJornadaSecs && 
                   (tiempoTrabajado - horasJornadaSecs) <= horasExtrasDiaSecs;
        } catch (Exception e) {
            //System.out.println("Error al determinar jornada extra: " + e);
            return false;
        }
    }

    /**
     * Procesa las horas extra de una jornada
     */
    private void procesarJornadaExtra(GenericaJornada gj) {
        try {
            int festivaExtraNocturna = MovilidadUtil.toSecs(gj.getFestivoExtraNocturno());
            int festivaExtraDiurna = MovilidadUtil.toSecs(gj.getFestivoExtraDiurno());
            int extraNocturna = MovilidadUtil.toSecs(gj.getExtraNocturna());
            int extraDiurna = MovilidadUtil.toSecs(gj.getExtraDiurna());

            gj.setFestivoExtraNocturno(MovilidadUtil.toTimeSec(festivaExtraNocturna));
            gj.setFestivoExtraDiurno(MovilidadUtil.toTimeSec(festivaExtraDiurna));
            gj.setExtraNocturna(MovilidadUtil.toTimeSec(extraNocturna));
            gj.setExtraDiurna(MovilidadUtil.toTimeSec(extraDiurna));
        } catch (Exception e) {
            System.out.println("Error al procesar jornada extra: " + e);
            // No lanzar excepción para no detener el proceso
        }
    }

    /**
     * Procesa las autorizaciones de horas feriadas
     */
    private void procesarAutorizaciones(GenericaJornada gj) {
        try {
            if (!"ROLE_DIRGEN".equals(rol_user) && aprobarHorasFeriadas(gj)) {
                int validacionDia = MovilidadUtil.fechasIgualMenorMayor(
                        MovilidadUtil.sumarDias(gj.getFecha(), 1), 
                        MovilidadUtil.fechaHoy(), 
                        false
                );

                if (genJornadaParam != null
                        && genJornadaParam.getCtrlAprobarExtrasFeriadas() == 0
                        && validacionDia == 0) {

                    gj.setAutorizado(-1);
                    gj.setFechaAutoriza(null);
                    gj.setUserAutorizado("");

                    if (genJornadaParam.getNotifica() == 1 && genJornadaParam.getEmails() != null) {
                        try {
                            notificar(gj);
                        } catch (Exception e) {
                            System.out.println("Error al notificar: " + e);
                            // No detener el proceso por error de notificación
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al procesar autorizaciones: " + e);
            // No lanzar excepción para no detener el proceso
        }
    }

    public GenericaJornada cargarCalcularDatoPorPartes(GenericaJornada gj) {
        GenericaJornada onePart = null;
        GenericaJornada twoPart = null;

        //Calcular el total de horas ejecutadas.
        int totalHoras = MovilidadUtil.toSecs(gj.getTimeDestiny()) - MovilidadUtil.toSecs(gj.getTimeOrigin());
        /**
         * Calcular medio de la jornada de horas ejecutadas, para saber a que
         * hora termina el turno 1 y a que hora comienza el turno 2.
         */
        int mitadHoras = totalHoras / 2;
        String timeOrigin1 = gj.getTimeOrigin();
        String timeDestiny1;
        if (totalHoras > MovilidadUtil.toSecs(horasMitadJornada)) {
            timeDestiny1 = MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(timeOrigin1) + MovilidadUtil.toSecs(horasMitadJornada));
        } else {
            timeDestiny1 = MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(timeOrigin1) + mitadHoras);
        }
        String timeOrigin2 = MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(timeDestiny1));
        String timeDestiny2 = gj.getTimeDestiny();
        if (gj.getAutorizado() != null && gj.getAutorizado() == 1) {

            //Calcular el total de horas ejecutadas.
            totalHoras = MovilidadUtil.toSecs(gj.getRealTimeDestiny())
                    - MovilidadUtil.toSecs(gj.getRealTimeOrigin());
            /**
             * Calcular medio de la jornada de horas ejecutadas, para saber a
             * que hora termina el turno 1 y a que hora comienza el turno 2.
             */
            mitadHoras = totalHoras / 2;
            timeOrigin1 = gj.getRealTimeOrigin();

            if (totalHoras > MovilidadUtil.toSecs(horasMitadJornada)) {
                timeDestiny1 = MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(timeOrigin1)
                        + MovilidadUtil.toSecs(horasMitadJornada));
            } else {
                timeDestiny1 = MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(timeOrigin1) + mitadHoras);
            }
            timeOrigin2 = MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(timeDestiny1));
            timeDestiny2 = gj.getRealTimeDestiny();

        }
//        System.out.println("Parte 1-->" + timeOrigin1 + " - " + timeDestiny1);
//        System.out.println("Parte 3-->" + timeOrigin2 + " - " + timeDestiny2);
        onePart = caluleOnePart(timeOrigin1, timeDestiny1, gj.getFecha());
        twoPart = caluleOnePart(timeOrigin2, timeDestiny2, gj.getFecha());

        totalHorasAsignadas = calculator.hr_cero;
        gj.setDiurnas(calculator.hr_cero);
        gj.setNocturnas(calculator.hr_cero);
        gj.setExtraDiurna(calculator.hr_cero);
        gj.setExtraNocturna(calculator.hr_cero);
        gj.setFestivoDiurno(calculator.hr_cero);
        gj.setFestivoNocturno(calculator.hr_cero);
        gj.setFestivoExtraDiurno(calculator.hr_cero);
        gj.setFestivoExtraNocturno(calculator.hr_cero);
        sumarPorPartes(gj, onePart, false);
        sumarPorPartes(gj, twoPart, MovilidadUtil.toSecs(timeOrigin2) > MovilidadUtil.toSecs(calculator.fin_dia));

        gj.setTipoCalculo(3);
        return gj;
    }

    public GenericaJornada sumarPorPartes(GenericaJornada gj, GenericaJornada gjModificado, boolean diaPaOtro) {
        int parteHorasLaborales;
        int parteHorasExtra;
        int totalAsignar;
        int maxHorasLaborales = MovilidadUtil.toSecs(UtilJornada.getTotalHrsLaborales());
        if (diaPaOtro) {
            totalAsignar = MovilidadUtil.toSecs(totalHorasAsignadas) + MovilidadUtil.toSecs(gjModificado.getNocturnas());

            if (totalAsignar > maxHorasLaborales) {
                parteHorasExtra = totalAsignar - maxHorasLaborales;
                gj.setExtraNocturna(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getExtraNocturna()) + parteHorasExtra));
                if (MovilidadUtil.toSecs(totalHorasAsignadas) < maxHorasLaborales) {
                    parteHorasLaborales = maxHorasLaborales - MovilidadUtil.toSecs(totalHorasAsignadas);
                    gj.setNocturnas(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getNocturnas()) + parteHorasLaborales));
                    totalHorasAsignadas = horasJornada;
                }
            } else {
                totalHorasAsignadas = MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(totalHorasAsignadas) + MovilidadUtil.toSecs(gjModificado.getNocturnas()));
                gj.setNocturnas(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getNocturnas()) + MovilidadUtil.toSecs(gjModificado.getNocturnas())));
            }
            totalAsignar = MovilidadUtil.toSecs(totalHorasAsignadas)
                    + MovilidadUtil.toSecs(gjModificado.getDiurnas());

            if (totalAsignar > maxHorasLaborales) {
                parteHorasExtra = totalAsignar - maxHorasLaborales;
                gj.setExtraDiurna(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getExtraDiurna()) + parteHorasExtra));
                if (MovilidadUtil.toSecs(totalHorasAsignadas) < maxHorasLaborales) {
                    parteHorasLaborales = maxHorasLaborales - MovilidadUtil.toSecs(totalHorasAsignadas);
                    gj.setDiurnas(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getDiurnas()) + parteHorasLaborales));
                    totalHorasAsignadas = UtilJornada.getTotalHrsLaborales();
                }
            } else {
                totalHorasAsignadas = MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(totalHorasAsignadas) + MovilidadUtil.toSecs(gjModificado.getDiurnas()));
                gj.setDiurnas(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getDiurnas()) + MovilidadUtil.toSecs(gjModificado.getDiurnas())));
            }
            totalAsignar = MovilidadUtil.toSecs(totalHorasAsignadas) + MovilidadUtil.toSecs(gjModificado.getFestivoNocturno());

            if (totalAsignar > maxHorasLaborales) {
                parteHorasExtra = totalAsignar - maxHorasLaborales;
                gj.setFestivoExtraNocturno(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getFestivoExtraNocturno()) + parteHorasExtra));
                if (MovilidadUtil.toSecs(totalHorasAsignadas) < maxHorasLaborales) {
                    parteHorasLaborales = maxHorasLaborales - MovilidadUtil.toSecs(totalHorasAsignadas);
                    gj.setFestivoNocturno(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getFestivoNocturno()) + parteHorasLaborales));
                    totalHorasAsignadas = horasJornada;
                }
            } else {
                totalHorasAsignadas = MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(totalHorasAsignadas) + MovilidadUtil.toSecs(gjModificado.getFestivoNocturno()));
                gj.setFestivoNocturno(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getFestivoNocturno()) + MovilidadUtil.toSecs(gjModificado.getFestivoNocturno())));
            }

            totalAsignar = MovilidadUtil.toSecs(totalHorasAsignadas) + MovilidadUtil.toSecs(gjModificado.getFestivoDiurno());

            if (totalAsignar > maxHorasLaborales) {
                parteHorasExtra = totalAsignar - maxHorasLaborales;
                gj.setFestivoExtraDiurno(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getFestivoExtraDiurno()) + parteHorasExtra));
                if (MovilidadUtil.toSecs(totalHorasAsignadas) < maxHorasLaborales) {
                    parteHorasLaborales = maxHorasLaborales - MovilidadUtil.toSecs(totalHorasAsignadas);
                    gj.setFestivoDiurno(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getFestivoDiurno()) + parteHorasLaborales));
                    totalHorasAsignadas = horasJornada;
                }
            } else {
                totalHorasAsignadas = MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(totalHorasAsignadas) + MovilidadUtil.toSecs(gjModificado.getFestivoDiurno()));
                gj.setFestivoDiurno(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getFestivoDiurno()) + MovilidadUtil.toSecs(gjModificado.getFestivoDiurno())));
            }

            gj.setFestivoExtraNocturno(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getFestivoExtraNocturno()) + MovilidadUtil.toSecs(gjModificado.getFestivoExtraNocturno())));
            gj.setFestivoExtraDiurno(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getFestivoExtraDiurno()) + MovilidadUtil.toSecs(gjModificado.getFestivoExtraDiurno())));

            gj.setExtraNocturna(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getExtraNocturna()) + MovilidadUtil.toSecs(gjModificado.getExtraNocturna())));
            gj.setExtraDiurna(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getExtraDiurna()) + MovilidadUtil.toSecs(gjModificado.getExtraDiurna())));

        } else {
            totalAsignar = MovilidadUtil.toSecs(totalHorasAsignadas)
                    + MovilidadUtil.toSecs(gjModificado.getDiurnas());

            if (totalAsignar > maxHorasLaborales) {
                parteHorasExtra = totalAsignar - maxHorasLaborales;
                gj.setExtraDiurna(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getExtraDiurna()) + parteHorasExtra));
                if (MovilidadUtil.toSecs(totalHorasAsignadas) < maxHorasLaborales) {
                    parteHorasLaborales = maxHorasLaborales - MovilidadUtil.toSecs(totalHorasAsignadas);
                    gj.setDiurnas(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getDiurnas()) + parteHorasLaborales));
                    totalHorasAsignadas = UtilJornada.getTotalHrsLaborales();
                }
            } else {
                totalHorasAsignadas = MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(totalHorasAsignadas) + MovilidadUtil.toSecs(gjModificado.getDiurnas()));
                gj.setDiurnas(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getDiurnas()) + MovilidadUtil.toSecs(gjModificado.getDiurnas())));
            }
            totalAsignar = MovilidadUtil.toSecs(totalHorasAsignadas) + MovilidadUtil.toSecs(gjModificado.getNocturnas());

            if (totalAsignar > maxHorasLaborales) {
                parteHorasExtra = totalAsignar - maxHorasLaborales;
                gj.setExtraNocturna(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getExtraNocturna()) + parteHorasExtra));
                if (MovilidadUtil.toSecs(totalHorasAsignadas) < maxHorasLaborales) {
                    parteHorasLaborales = maxHorasLaborales - MovilidadUtil.toSecs(totalHorasAsignadas);
                    gj.setNocturnas(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getNocturnas()) + parteHorasLaborales));
                    totalHorasAsignadas = horasJornada;
                }
            } else {
                totalHorasAsignadas = MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(totalHorasAsignadas) + MovilidadUtil.toSecs(gjModificado.getNocturnas()));
                gj.setNocturnas(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getNocturnas()) + MovilidadUtil.toSecs(gjModificado.getNocturnas())));
            }

            totalAsignar = MovilidadUtil.toSecs(totalHorasAsignadas) + MovilidadUtil.toSecs(gjModificado.getFestivoDiurno());

            if (totalAsignar > maxHorasLaborales) {
                parteHorasExtra = totalAsignar - maxHorasLaborales;
                gj.setFestivoExtraDiurno(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getFestivoExtraDiurno()) + parteHorasExtra));
                if (MovilidadUtil.toSecs(totalHorasAsignadas) < maxHorasLaborales) {
                    parteHorasLaborales = maxHorasLaborales - MovilidadUtil.toSecs(totalHorasAsignadas);
                    gj.setFestivoDiurno(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getFestivoDiurno()) + parteHorasLaborales));
                    totalHorasAsignadas = horasJornada;
                }
            } else {
                totalHorasAsignadas = MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(totalHorasAsignadas) + MovilidadUtil.toSecs(gjModificado.getFestivoDiurno()));
                gj.setFestivoDiurno(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getFestivoDiurno()) + MovilidadUtil.toSecs(gjModificado.getFestivoDiurno())));
            }

            totalAsignar = MovilidadUtil.toSecs(totalHorasAsignadas) + MovilidadUtil.toSecs(gjModificado.getFestivoNocturno());

            if (totalAsignar > maxHorasLaborales) {
                parteHorasExtra = totalAsignar
                        - maxHorasLaborales;
                gj.setFestivoExtraNocturno(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getFestivoExtraNocturno()) + parteHorasExtra));
                if (MovilidadUtil.toSecs(totalHorasAsignadas) < maxHorasLaborales) {
                    parteHorasLaborales = maxHorasLaborales - MovilidadUtil.toSecs(totalHorasAsignadas);
                    gj.setFestivoNocturno(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getFestivoNocturno()) + parteHorasLaborales));
                    totalHorasAsignadas = horasJornada;
                }
            } else {
                totalHorasAsignadas = MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(totalHorasAsignadas) + MovilidadUtil.toSecs(gjModificado.getFestivoNocturno()));
                gj.setFestivoNocturno(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getFestivoNocturno()) + MovilidadUtil.toSecs(gjModificado.getFestivoNocturno())));
            }

            gj.setFestivoExtraDiurno(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getFestivoExtraDiurno()) + MovilidadUtil.toSecs(gjModificado.getFestivoExtraDiurno())));

            gj.setFestivoExtraNocturno(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getFestivoExtraNocturno()) + MovilidadUtil.toSecs(gjModificado.getFestivoExtraNocturno())));

            gj.setExtraDiurna(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getExtraDiurna()) + MovilidadUtil.toSecs(gjModificado.getExtraDiurna())));

            gj.setExtraNocturna(MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(gj.getExtraNocturna()) + MovilidadUtil.toSecs(gjModificado.getExtraNocturna())));
        }
        return gj;
    }

    public void cargarMapParamFeriado() {
        mapParamFeriado = new HashMap<>();
        List<ParamFeriado> listaParamFeriado = paraFeEJB.findAllByFechaMes(
                fechaDesde, MovilidadUtil.sumarDias(fechaHasta, 1));
        listaParamFeriado.forEach((obj) -> {
            mapParamFeriado.put(Util.dateFormat(obj.getFecha()), obj);
        });
    }

    public GenericaJornada caluleOnePart(String s_horaInicio, String s_horaFin, Date fechaParam) {
        calculator.reset();
        GenericaJornada parteJornada = new GenericaJornada();
        int ultimaHoraDia = MovilidadUtil.toSecs("23:59:59");
        int i_horaIniSec;
        int i_horaFinSec;

        i_horaIniSec = MovilidadUtil.toSecs(s_horaInicio);
        i_horaFinSec = MovilidadUtil.toSecs(s_horaFin);

        if (i_horaIniSec <= 0 && i_horaFinSec <= 0) {
            parteJornada.setDiurnas(liquidadorjornada.Jornada.getDiurnas());
            parteJornada.setNocturnas(liquidadorjornada.Jornada.getNocturnas());
            parteJornada.setExtraDiurna(liquidadorjornada.Jornada.getExtra_diurna());
            parteJornada.setExtraNocturna(liquidadorjornada.Jornada.getExtra_nocturna());
            parteJornada.setFestivoDiurno(liquidadorjornada.Jornada.getFestivo_diurno());
            parteJornada.setFestivoNocturno(liquidadorjornada.Jornada.getFestivo_nocturno());
            parteJornada.setFestivoExtraDiurno(liquidadorjornada.Jornada.getFestivo_extra_diurno());
            parteJornada.setFestivoExtraNocturno(liquidadorjornada.Jornada.getFestivo_extra_nocturno());
            return parteJornada;
        }

        if (i_horaIniSec > ultimaHoraDia) {
            Date fecha = MovilidadUtil.sumarDias(fechaParam, 1);
            ParamFeriado pf = mapParamFeriado.get(Util.dateFormat(fecha));
            if (pf == null && !MovilidadUtil.isSunday(fecha)) {
                JornadaUtil.calcular("H",
                        MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(s_horaInicio) - ultimaHoraDia),
                        "H",
                        MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(s_horaFin) - ultimaHoraDia), "");
            } else {
                JornadaUtil.calcular("F",
                        MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(s_horaInicio) - ultimaHoraDia),
                        "F",
                        MovilidadUtil.toTimeSec(MovilidadUtil.toSecs(s_horaFin) - ultimaHoraDia), "");
            }
        } else {

            ParamFeriado pffHI = mapParamFeriado.get(Util.dateFormat(fechaParam));

            ParamFeriado pffHF = pffHI;
            Date fecha = fechaParam;
            if (i_horaFinSec > ultimaHoraDia) {
                fecha = MovilidadUtil.sumarDias(fechaParam, 1);
                pffHF = mapParamFeriado.get(Util.dateFormat(fecha));
            }
            if ((pffHI == null && !MovilidadUtil.isSunday(fechaParam)) && (pffHF == null && !MovilidadUtil.isSunday(fecha))) {
                JornadaUtil.calcular("H", s_horaInicio, "H", s_horaFin, "");
//                System.out.println("H;H->>" + s_horaInicio + " - " + timeDestiny);
            }
            if ((pffHI != null || MovilidadUtil.isSunday(fechaParam)) && (pffHF == null && !MovilidadUtil.isSunday(fecha))) {
                JornadaUtil.calcular("F", s_horaInicio, "H", s_horaFin, "");
//                System.out.println("F;H->>" + s_horaInicio + " - " + timeDestiny);
            }
            if ((pffHI != null || MovilidadUtil.isSunday(fechaParam)) && (pffHF != null || MovilidadUtil.isSunday(fecha))) {
                JornadaUtil.calcular("F", s_horaInicio, "F", s_horaFin, "");
//                System.out.println("F;F->>" + s_horaInicio + " - " + timeDestiny);

            }
            if ((pffHI == null && !MovilidadUtil.isSunday(fechaParam)) && (pffHF != null || MovilidadUtil.isSunday(fecha))) {
                JornadaUtil.calcular("H", s_horaInicio, "F", s_horaFin, "");
//                System.out.println("H;F->>" + s_horaInicio + " - " + timeDestiny);
            }
        }
        parteJornada.setDiurnas(calculator.getDiurnas());
        parteJornada.setNocturnas(calculator.getNocturnas());
        parteJornada.setExtraDiurna(calculator.getExtra_diurna());
        parteJornada.setExtraNocturna(calculator.getExtra_nocturna());
        parteJornada.setFestivoDiurno(calculator.getFestivo_diurno());
        parteJornada.setFestivoNocturno(calculator.getFestivo_nocturno());
        parteJornada.setFestivoExtraDiurno(calculator.getFestivo_extra_diurno());
        parteJornada.setFestivoExtraNocturno(calculator.getFestivo_extra_nocturno());
        return parteJornada;
    }

    /**
     * Método responsable de invocar al método calculaJ para calcular las horas
     * a liquidar(diurnas,nocturnas,extra diurna, extra nocturna, festivo
     * diurno, festivo nocturno, festivo extra diurno, festivo extra nocturno)
     * de una jornada de acuerdo a una hora inicio y hora fin de turno.
     *
     * Persiste la información en BD.
     *
     * Las jornadas o turnos que pasan por este método son almacenadas con el
     * identificador 2 en el atributo 'tipoCalculo', lo cual significa que el
     * tipo de calculo es automatico, hecho por rigel.
     *
     * Invoca al método calculaJ, responsable de calcular la jornada.
     *
     * @param jornada
     * @param opc
     * @param descanso
     * @return
     */
    @Transactional
    public GenericaJornada cargarCalcularDato(GenericaJornada jornada, int opc) {
        calculator.reset();
        int ultimaHoraDia = MovilidadUtil.toSecs("23:59:59");
        int horaIniSec;
        int horaFinSec;
        String timeOrigin;
        String timeDestiny;
        boolean realTime = isRealTime(jornada.getAutorizado(),
                jornada.getPrgModificada(), jornada.getRealTimeOrigin());
        if (realTime) {
            timeOrigin = jornada.getRealTimeOrigin();
            horaIniSec = MovilidadUtil.toSecs(timeOrigin);
            timeDestiny = jornada.getRealTimeDestiny();
            horaFinSec = MovilidadUtil.toSecs(timeDestiny);
        } else {
            timeOrigin = jornada.getTimeOrigin();
            horaIniSec = MovilidadUtil.toSecs(timeOrigin);
            timeDestiny = jornada.getTimeDestiny();
            horaFinSec = MovilidadUtil.toSecs(timeDestiny);
        }

//        if (opc == 0) {
//            ps.setRealTimeOrigin(ps.getTimeOrigin());
//            ps.setRealTimeDestiny(ps.getTimeDestiny());
//        } else 
//        if (opc == 3) {
//            ps.setRealTimeOrigin(ps.getTimeOrigin());
//            ps.setRealTimeDestiny(ps.getTimeDestiny());
//            ps.setAutorizado(1);
//        }
        if (timeOrigin != null && timeDestiny != null) {
            if (timeOrigin.equals(calculator.hr_cero) && timeDestiny.equals(calculator.hr_cero)) {
                jornada.setDiurnas(calculator.getDiurnas());
                jornada.setNocturnas(calculator.getNocturnas());
                jornada.setExtraDiurna(calculator.getExtra_diurna());
                jornada.setExtraNocturna(calculator.getExtra_nocturna());
                jornada.setFestivoDiurno(calculator.getFestivo_diurno());
                jornada.setFestivoNocturno(calculator.getFestivo_nocturno());
                jornada.setFestivoExtraDiurno(calculator.getFestivo_extra_diurno());
                jornada.setFestivoExtraNocturno(calculator.getFestivo_extra_nocturno());
                //Tipo de calculo automatico
                jornada.setTipoCalculo(2);
                if (opc == 1) {
                    genJornadaEJB.edit(jornada);
                } else if (opc == 0) {
//                    ps.setRealTimeOrigin(null);
//                    ps.setRealTimeDestiny(null);
//                    ps.setAutorizado(null);
                }
                return jornada;
            }
        } else {
            return jornada;
        }

//        if (ps.getAutorizado() != null && ps.getAutorizado() != 1) {
//            return ps;
//        }
//        if (timeOrigin != null && timeDestiny != null
//                && (ps.getAutorizado() != null && ps.getAutorizado() == 1)) {
//            timeOrigin = timeOrigin;
//            horaIniSec = MovilidadUtil.toSecs(timeOrigin);
//            timeDestiny = timeDestiny;
//            horaFinSec = MovilidadUtil.toSecs(timeDestiny);
//        } else {
//            return ps;
//        }
        if (horaIniSec > ultimaHoraDia) {
            Date fecha = MovilidadUtil.sumarDias(jornada.getFecha(), 1);
            ParamFeriado pf = mapParamFeriado.get(Util.dateFormat(fecha));
            if (pf == null && !MovilidadUtil.isSunday(fecha)) {
                JornadaUtil.calcular("H", timeOrigin, "H", timeDestiny, "");

            } else {
                JornadaUtil.calcular("F", timeOrigin, "F", timeDestiny, "");
            }
        } else {

            ParamFeriado pffHI = mapParamFeriado.get(Util.dateFormat(jornada.getFecha()));
            ParamFeriado pffHF = pffHI;
            Date fecha = jornada.getFecha();
            if (horaFinSec > ultimaHoraDia) {
                fecha = MovilidadUtil.sumarDias(jornada.getFecha(), 1);
                pffHF = mapParamFeriado.get(Util.dateFormat(fecha));
            }
                        
            // REGLA ESPECIAL ÁREA LAVADO
            if (jornada.getIdParamArea() != null && jornada.getIdParamArea().getIdParamArea() == 6) {
                boolean sabadoInicio = MovilidadUtil.isSaturday(jornada.getFecha());
                boolean sabadoFin = MovilidadUtil.isSaturday(fecha);
                boolean domingoInicio = MovilidadUtil.isSunday(jornada.getFecha());
                boolean domingoFin = MovilidadUtil.isSunday(fecha);

                // Sábado se trata como festivo
                String contextoInicio = sabadoInicio ? "F" : (domingoInicio ? "H" : ((pffHI != null) ? "F" : "H"));
                String contextoFin = sabadoFin ? "F" : (domingoFin ? "H" : ((pffHF != null) ? "F" : "H"));

                JornadaUtil.calcular(contextoInicio, timeOrigin, contextoFin, timeDestiny, "");
            } else {
                // LÓGICA ORIGINAL PARA OTRAS ÁREAS
                if ((pffHI == null && !MovilidadUtil.isSunday(jornada.getFecha())) && (pffHF == null && !MovilidadUtil.isSunday(fecha))) {
                    JornadaUtil.calcular("H", timeOrigin, "H", timeDestiny, "");
                }
                if ((pffHI != null || MovilidadUtil.isSunday(jornada.getFecha())) && (pffHF == null && !MovilidadUtil.isSunday(fecha))) {
                    JornadaUtil.calcular("F", timeOrigin, "H", timeDestiny, "");
                }
                if ((pffHI != null || MovilidadUtil.isSunday(jornada.getFecha())) && (pffHF != null || MovilidadUtil.isSunday(fecha))) {
                    JornadaUtil.calcular("F", timeOrigin, "F", timeDestiny, "");
                }
                if ((pffHI == null && !MovilidadUtil.isSunday(jornada.getFecha())) && (pffHF != null || MovilidadUtil.isSunday(fecha))) {
                    JornadaUtil.calcular("H", timeOrigin, "F", timeDestiny, "");
                }
            }
            
        }
        jornada.setDiurnas(calculator.getDiurnas());
        jornada.setNocturnas(calculator.getNocturnas());
        jornada.setExtraDiurna(calculator.getExtra_diurna());
        jornada.setExtraNocturna(calculator.getExtra_nocturna());
        jornada.setFestivoDiurno(calculator.getFestivo_diurno());
        jornada.setFestivoNocturno(calculator.getFestivo_nocturno());
        jornada.setFestivoExtraDiurno(calculator.getFestivo_extra_diurno());
        jornada.setFestivoExtraNocturno(calculator.getFestivo_extra_nocturno());
//        system();
        //Tipo de calculo automatico
        jornada.setTipoCalculo(2);
        if (opc == 1) {
            genJornadaEJB.edit(jornada);
//        } else if (opc == 0) {
//            ps.setRealTimeOrigin(null);
//            ps.setRealTimeDestiny(null);
//            ps.setAutorizado(null);
//        } else if (opc == 3) {
//            ps.setRealTimeOrigin(null);
//            ps.setRealTimeDestiny(null);
//            ps.setAutorizado(null);
        }
        return jornada;
    }

    
    @Transactional
    public GenericaJornada cargarCalcularDatoPorPartes(GenericaJornada jornada, int opc) {
        GenericaJornada onePart = null;
        GenericaJornada twoPart = null;
        GenericaJornada threePart = null;

        // Determinar si usa tiempos reales
        boolean realTime = isRealTime(jornada.getAutorizado(), 
                                       jornada.getPrgModificada(), 
                                       jornada.getRealTimeOrigin());

        String timeOrigin1, timeDestiny1, timeOrigin2, timeDestiny2, timeOrigin3, timeDestiny3;

        if (realTime) {
            timeOrigin1 = jornada.getRealTimeOrigin();
            timeDestiny1 = jornada.getRealTimeDestiny();
            timeOrigin2 = jornada.getRealHiniTurno2();
            timeDestiny2 = jornada.getRealHfinTurno2();
            timeOrigin3 = jornada.getRealHiniTurno3();
            timeDestiny3 = jornada.getRealHfinTurno3();
        } else {
            timeOrigin1 = jornada.getTimeOrigin();
            timeDestiny1 = jornada.getTimeDestiny();
            timeOrigin2 = jornada.getHiniTurno2();
            timeDestiny2 = jornada.getHfinTurno2();
            timeOrigin3 = jornada.getHiniTurno3();
            timeDestiny3 = jornada.getHfinTurno3();
        }

        // Calcular cada parte individualmente
        onePart = calcularUnaParte(timeOrigin1, timeDestiny1, jornada.getFecha(), jornada);
        twoPart = calcularUnaParte(timeOrigin2, timeDestiny2, jornada.getFecha(), jornada);
        threePart = calcularUnaParte(timeOrigin3, timeDestiny3, jornada.getFecha(), jornada);

        // Resetear todos los campos a cero
        jornada.setDiurnas(calculator.hr_cero);
        jornada.setNocturnas(calculator.hr_cero);
        jornada.setExtraDiurna(calculator.hr_cero);
        jornada.setExtraNocturna(calculator.hr_cero);
        jornada.setFestivoDiurno(calculator.hr_cero);
        jornada.setFestivoNocturno(calculator.hr_cero);
        jornada.setFestivoExtraDiurno(calculator.hr_cero);
        jornada.setFestivoExtraNocturno(calculator.hr_cero);

        // Sumar las tres partes
        sumarPorPartes(jornada, onePart);
        sumarPorPartes(jornada, twoPart);
        sumarPorPartes(jornada, threePart);

        // Tipo de cálculo por partes
        jornada.setTipoCalculo(3);

        if (opc == 1) {
            genJornadaEJB.edit(jornada);
        }

        return jornada;
    }
    
    private GenericaJornada calcularUnaParte(String timeOrigin, String timeDestiny, 
                                         Date fecha, GenericaJornada jornadaOriginal) {
        if (timeOrigin == null || timeDestiny == null || 
            timeOrigin.equals(calculator.hr_cero) || timeDestiny.equals(calculator.hr_cero)) {
            return null;
        }

        calculator.reset();

        // Crear objeto temporal para esta parte
        GenericaJornada parteTemporal = new GenericaJornada();
        parteTemporal.setFecha(fecha);
        parteTemporal.setIdParamArea(jornadaOriginal.getIdParamArea());

        int ultimaHoraDia = MovilidadUtil.toSecs("23:59:59");
        int horaIniSec = MovilidadUtil.toSecs(timeOrigin);
        int horaFinSec = MovilidadUtil.toSecs(timeDestiny);

        // Aplicar la misma lógica de cargarCalcularDato pero sin persistir
        if (horaIniSec > ultimaHoraDia) {
            Date fechaSiguiente = MovilidadUtil.sumarDias(fecha, 1);
            ParamFeriado pf = mapParamFeriado.get(Util.dateFormat(fechaSiguiente));

            if (pf == null && !MovilidadUtil.isSunday(fechaSiguiente)) {
                JornadaUtil.calcular("H", timeOrigin, "H", timeDestiny, "");
            } else {
                JornadaUtil.calcular("F", timeOrigin, "F", timeDestiny, "");
            }
        } else {
            ParamFeriado pffHI = mapParamFeriado.get(Util.dateFormat(fecha));
            ParamFeriado pffHF = pffHI;
            Date fechaFin = fecha;

            if (horaFinSec > ultimaHoraDia) {
                fechaFin = MovilidadUtil.sumarDias(fecha, 1);
                pffHF = mapParamFeriado.get(Util.dateFormat(fechaFin));
            }

            // APLICAR REGLA ESPECIAL ÁREA LAVADO (igual que en cargarCalcularDato)
            if (jornadaOriginal.getIdParamArea() != null && 
                jornadaOriginal.getIdParamArea().getIdParamArea() == 6) {
                boolean sabadoInicio = MovilidadUtil.isSaturday(fecha);
                boolean sabadoFin = MovilidadUtil.isSaturday(fechaFin);
                boolean domingoInicio = MovilidadUtil.isSunday(fecha);
                boolean domingoFin = MovilidadUtil.isSunday(fechaFin);

                String contextoInicio = sabadoInicio ? "F" : (domingoInicio ? "H" : ((pffHI != null) ? "F" : "H"));
                String contextoFin = sabadoFin ? "F" : (domingoFin ? "H" : ((pffHF != null) ? "F" : "H"));

                JornadaUtil.calcular(contextoInicio, timeOrigin, contextoFin, timeDestiny, "");
            } else {
                // Lógica normal de festivos/hábiles
                if ((pffHI == null && !MovilidadUtil.isSunday(fecha)) && 
                    (pffHF == null && !MovilidadUtil.isSunday(fechaFin))) {
                    JornadaUtil.calcular("H", timeOrigin, "H", timeDestiny, "");
                }
                if ((pffHI != null || MovilidadUtil.isSunday(fecha)) && 
                    (pffHF == null && !MovilidadUtil.isSunday(fechaFin))) {
                    JornadaUtil.calcular("F", timeOrigin, "H", timeDestiny, "");
                }
                if ((pffHI != null || MovilidadUtil.isSunday(fecha)) && 
                    (pffHF != null || MovilidadUtil.isSunday(fechaFin))) {
                    JornadaUtil.calcular("F", timeOrigin, "F", timeDestiny, "");
                }
                if ((pffHI == null && !MovilidadUtil.isSunday(fecha)) && 
                    (pffHF != null || MovilidadUtil.isSunday(fechaFin))) {
                    JornadaUtil.calcular("H", timeOrigin, "F", timeDestiny, "");
                }
            }
        }

        // Guardar resultados del cálculo
        parteTemporal.setDiurnas(calculator.getDiurnas());
        parteTemporal.setNocturnas(calculator.getNocturnas());
        parteTemporal.setExtraDiurna(calculator.getExtra_diurna());
        parteTemporal.setExtraNocturna(calculator.getExtra_nocturna());
        parteTemporal.setFestivoDiurno(calculator.getFestivo_diurno());
        parteTemporal.setFestivoNocturno(calculator.getFestivo_nocturno());
        parteTemporal.setFestivoExtraDiurno(calculator.getFestivo_extra_diurno());
        parteTemporal.setFestivoExtraNocturno(calculator.getFestivo_extra_nocturno());

        return parteTemporal;
    }
    
    private void sumarPorPartes(GenericaJornada jornadaTotal, GenericaJornada parte) {
        if (parte == null) {
            return;
        }

        jornadaTotal.setDiurnas(
            MovilidadUtil.toTimeSec(
                MovilidadUtil.toSecs(jornadaTotal.getDiurnas()) + 
                MovilidadUtil.toSecs(parte.getDiurnas())
            )
        );

        jornadaTotal.setNocturnas(
            MovilidadUtil.toTimeSec(
                MovilidadUtil.toSecs(jornadaTotal.getNocturnas()) + 
                MovilidadUtil.toSecs(parte.getNocturnas())
            )
        );

        jornadaTotal.setExtraDiurna(
            MovilidadUtil.toTimeSec(
                MovilidadUtil.toSecs(jornadaTotal.getExtraDiurna()) + 
                MovilidadUtil.toSecs(parte.getExtraDiurna())
            )
        );

        jornadaTotal.setExtraNocturna(
            MovilidadUtil.toTimeSec(
                MovilidadUtil.toSecs(jornadaTotal.getExtraNocturna()) + 
                MovilidadUtil.toSecs(parte.getExtraNocturna())
            )
        );

        jornadaTotal.setFestivoDiurno(
            MovilidadUtil.toTimeSec(
                MovilidadUtil.toSecs(jornadaTotal.getFestivoDiurno()) + 
                MovilidadUtil.toSecs(parte.getFestivoDiurno())
            )
        );

        jornadaTotal.setFestivoNocturno(
            MovilidadUtil.toTimeSec(
                MovilidadUtil.toSecs(jornadaTotal.getFestivoNocturno()) + 
                MovilidadUtil.toSecs(parte.getFestivoNocturno())
            )
        );

        jornadaTotal.setFestivoExtraDiurno(
            MovilidadUtil.toTimeSec(
                MovilidadUtil.toSecs(jornadaTotal.getFestivoExtraDiurno()) + 
                MovilidadUtil.toSecs(parte.getFestivoExtraDiurno())
            )
        );

        jornadaTotal.setFestivoExtraNocturno(
            MovilidadUtil.toTimeSec(
                MovilidadUtil.toSecs(jornadaTotal.getFestivoExtraNocturno()) + 
                MovilidadUtil.toSecs(parte.getFestivoExtraNocturno())
            )
        );
    }
    /**
     * Recalcula las jornadas con fechas de Sábado y Domingo identificando si el
     * empleado en cuestión ha descansado o no en la semana.
     *
     * @param gj Objeto GenericaJornada que contiene la jornada del empleado.
     */
    public void recalcularJornada(GenericaJornada gj) {
        /*
        System.out.println("🔶 === INICIO recalcularJornada ===");
        System.out.println("🔶 ID Jornada: " + gj.getIdGenericaJornada());
        System.out.println("🔶 Empleado: " + gj.getIdEmpleado().getIdentificacion());
        System.out.println("🔶 Fecha: " + gj.getFecha());
        System.out.println("🔶 Es Sábado: " + MovilidadUtil.isSaturday(gj.getFecha()));
        System.out.println("🔶 Es Domingo: " + MovilidadUtil.isSunday(gj.getFecha()));
        */

        Date mondayNetxWeekend = null;
        Date endDayNextWeekend = null;
        Date saturday = null;
        Date sunday = null;

        // Identificar si es área Lavado
        Integer areaId = gj.getIdParamArea().getIdParamArea();
        boolean isAreaLavado = (areaId == 6);

        //System.out.println("🔶 Área ID: " + areaId + " | Es Área Lavado: " + isAreaLavado);

        // ⭐ LÓGICA ESPECIAL PARA ÁREA LAVADO CUANDO ES SÁBADO
        if (isAreaLavado && MovilidadUtil.isSaturday(gj.getFecha())) {
            // Para sábados en área Lavado, calcular la SIGUIENTE semana
            saturday = gj.getFecha();  // El sábado actual
            sunday = MovilidadUtil.sumarDias(saturday, 1);  // Domingo siguiente
            mondayNetxWeekend = MovilidadUtil.sumarDias(sunday, 1);  // Lunes siguiente
            endDayNextWeekend = MovilidadUtil.sumarDias(mondayNetxWeekend, 4);  // Viernes siguiente (lunes + 4 días)
            
            /*
            System.out.println("🔶 ⚡ CÁLCULO ESPECIAL PARA SÁBADO EN ÁREA LAVADO");
            System.out.println("🔶 saturday: " + saturday);
            System.out.println("🔶 sunday: " + sunday);
            System.out.println("🔶 mondayNetxWeekend: " + mondayNetxWeekend);
            System.out.println("🔶 endDayNextWeekend: " + endDayNextWeekend);
            */
        } else {
            // ⭐ LÓGICA ORIGINAL PARA TODAS LAS DEMÁS ÁREAS Y DÍAS
            // Calcular fechas de la semana
            if (UtilJornada.tipoLiquidacion()) {
                if (MovilidadUtil.isSunday(gj.getFecha())) {
                    saturday = getDiaSemana(gj.getFecha(), Calendar.SATURDAY);
                    sunday = getDiaSemana(gj.getFecha(), Calendar.SUNDAY);
                    mondayNetxWeekend = MovilidadUtil.sumarDias(sunday, 1);
                    if (isAreaLavado) {
                        endDayNextWeekend = getDiaSemana(mondayNetxWeekend, Calendar.FRIDAY);
                    } else {
                        endDayNextWeekend = getDiaSemana(mondayNetxWeekend, Calendar.SATURDAY);
                    }
                } else {
                    mondayNetxWeekend = getDiaSemana(gj.getFecha(), Calendar.MONDAY);
                    if (isAreaLavado) {
                        endDayNextWeekend = getDiaSemana(gj.getFecha(), Calendar.FRIDAY);
                    } else {
                        endDayNextWeekend = getDiaSemana(gj.getFecha(), Calendar.SATURDAY);
                    }
                    saturday = MovilidadUtil.sumarDias(mondayNetxWeekend, -2);
                    sunday = MovilidadUtil.sumarDias(mondayNetxWeekend, -1);
                }
            } else {
                mondayNetxWeekend = getDiaSemana(gj.getFecha(), Calendar.MONDAY);
                if (isAreaLavado) {
                    endDayNextWeekend = getDiaSemana(gj.getFecha(), Calendar.FRIDAY);
                } else {
                    endDayNextWeekend = getDiaSemana(gj.getFecha(), Calendar.SATURDAY);
                }
                saturday = getDiaSemana(gj.getFecha(), Calendar.SATURDAY);
                sunday = getDiaSemana(gj.getFecha(), Calendar.SUNDAY);
            }
        }

        // Calcular si hay descanso en la semana
        Date startDayNextWeek = isAreaLavado ? sunday : mondayNetxWeekend;

        //System.out.println("🔶 startDayNextWeek: " + startDayNextWeek);
        //System.out.println("🔶 endDayNextWeekend: " + endDayNextWeekend);

        int descanso = genJornadaEJB.descansoEnSemana(
            startDayNextWeek,
            endDayNextWeekend,
            gj.getIdEmpleado().getIdEmpleado(), 
            gj.getIdParamArea().getIdParamArea()
        );

        //System.out.println("🔶 DESCANSO EN SEMANA: " + descanso);
    
        // ⭐ NUEVO: Procesar la jornada actual si es fin de semana
        if (MovilidadUtil.isSaturday(gj.getFecha()) || MovilidadUtil.isSunday(gj.getFecha())) {
            //System.out.println("🔶 ✅ ES FIN DE SEMANA - Entrando a lógica de procesamiento");

            boolean debeProcejarJornadaActual = true;
            if (isAreaLavado && !MovilidadUtil.isSaturday(gj.getFecha())) {
                debeProcejarJornadaActual = false;
                //System.out.println("🔶 ❌ No procesar: es Área Lavado y NO es sábado");
            }

            if (debeProcejarJornadaActual) {
                //System.out.println("🔶 ✅ Procesando jornada actual...");

                String identificacion = gj.getIdEmpleado().getIdentificacion();
                int resp_tiene_festivo = tieneFestivo(gj);
                /*
                System.out.println("🔶 tieneFestivo(): " + resp_tiene_festivo);
                System.out.println("🔶 ANTES de pasarHoras:");
                System.out.println("🔶   - festivo_diurno: " + gj.getFestivoDiurno());
                System.out.println("🔶   - festivo_nocturno: " + gj.getFestivoNocturno());
                System.out.println("🔶   - dominical_comp_diurnas: " + gj.getDominicalCompDiurnas());
                System.out.println("🔶   - dominical_comp_nocturnas: " + gj.getDominicalCompNocturnas());
                */
                GenericaJornada gjPersistir = pasarHoras(gj, descanso, resp_tiene_festivo);

                if (gjPersistir != null) {
                    /*
                    System.out.println("🔶 ✅ pasarHoras() retornó objeto (NO NULL)");
                    System.out.println("🔶 DESPUÉS de pasarHoras:");
                    System.out.println("🔶   - festivo_diurno: " + gjPersistir.getFestivoDiurno());
                    System.out.println("🔶   - festivo_nocturno: " + gjPersistir.getFestivoNocturno());
                    System.out.println("🔶   - dominical_comp_diurnas: " + gjPersistir.getDominicalCompDiurnas());
                    System.out.println("🔶   - dominical_comp_nocturnas: " + gjPersistir.getDominicalCompNocturnas());
                    */

                    genJornadaEJB.edit(gjPersistir);
                    //System.out.println("🔶 ✅ Cambios guardados en BD");
                } else {
                    //System.out.println("🔶 ❌ pasarHoras() retornó NULL - NO SE HICIERON CAMBIOS");
                }
            }
        } else {
            //System.out.println("🔶 ❌ NO es fin de semana - saltando procesamiento");
        }

        // ⭐ NUEVO: Buscar otras jornadas del fin de semana (excluyendo la actual)
        List<GenericaJornada> list = genJornadaEJB.getJornadasByDateAndEmpleado(
            saturday, sunday, gj.getIdEmpleado().getIdEmpleado()
        );

        // Filtrar para no procesar dos veces la misma jornada
        if (!list.isEmpty()) {
            final Integer idJornadaActual = gj.getIdGenericaJornada();
            list = list.stream()
                .filter(j -> !j.getIdGenericaJornada().equals(idJornadaActual))
                .collect(Collectors.toList());
        }
        // Para Lavado solo procesa SÁBADOS
        if (isAreaLavado && !list.isEmpty()) {
            list = list.stream()
                .filter(j -> MovilidadUtil.isSaturday(j.getFecha()))
                .collect(Collectors.toList());
        }

        String identificacion = gj.getIdEmpleado().getIdentificacion();
        // Procesar las demás jornadas del fin de semana
        for (GenericaJornada g : list) {
            int resp_tiene_festivo = tieneFestivo(g);
            GenericaJornada gjPersistir = pasarHoras(g, descanso, resp_tiene_festivo);
            if (gjPersistir != null) {
                genJornadaEJB.edit(gjPersistir);
            }
        }        
        //System.out.println("🔶 === FIN recalcularJornada ===");
    }
    
    private boolean tieneHorasTrabajadas(GenericaJornada g) {
        String timeOrigin;
        String timeDestiny;

        boolean realTime = isRealTime(g.getAutorizado(), g.getPrgModificada(), g.getRealTimeOrigin());
        if (realTime) {
            timeOrigin = g.getRealTimeOrigin();
            timeDestiny = g.getRealTimeDestiny();
        } else {
            timeOrigin = g.getTimeOrigin();
            timeDestiny = g.getTimeDestiny();
        }

        return timeOrigin != null && timeDestiny != null 
               && MovilidadUtil.toSecs(timeOrigin) > 0 
               && MovilidadUtil.toSecs(timeDestiny) > 0;
    }

    public Calendar getNextMonday(Calendar now) {
//        Calendar now = Calendar.getInstance();
        int weekday = now.get(Calendar.DAY_OF_WEEK);
        if (weekday != Calendar.MONDAY) {
            // calculate how much to add
            // the 2 is the difference between Saturday and Monday
            int days = (Calendar.SATURDAY - weekday + 2) % 7;
            now.add(Calendar.DAY_OF_YEAR, days);
        } else {
            now.add(Calendar.DAY_OF_YEAR, 1);
            weekday = now.get(Calendar.DAY_OF_WEEK);
            // the 2 is the difference between Saturday and Monday
            int days = (Calendar.SATURDAY - weekday + 2) % 7;
            now.add(Calendar.DAY_OF_YEAR, days);
        }
        return now;
    }

    public int tieneFestivo(GenericaJornada ps) {
        
        // AGREGAR AL INICIO:
        Integer areaId = ps.getIdParamArea() != null ? ps.getIdParamArea().getIdParamArea() : null;        
    
        int ultimaHoraDia = MovilidadUtil.toSecs("23:59:59");
        int horaIniSec;
        int horaFinSec;
        String timeOrigin;
        String timeDestiny;

        if (ps.getAutorizado() != null && ps.getAutorizado() == 1) {
            if (ps.getRealTimeOrigin() != null) {
                timeOrigin = ps.getRealTimeOrigin();
                horaIniSec = MovilidadUtil.toSecs(timeOrigin);
                timeDestiny = ps.getRealTimeDestiny();
                horaFinSec = MovilidadUtil.toSecs(ps.getRealTimeDestiny());
            } else {
                timeOrigin = ps.getTimeOrigin();
                horaIniSec = MovilidadUtil.toSecs(timeOrigin);
                timeDestiny = ps.getTimeDestiny();
                horaFinSec = MovilidadUtil.toSecs(timeDestiny);
            }
        } else if (ps.getPrgModificada() != null && ps.getPrgModificada() == 1) {
            timeOrigin = ps.getRealTimeOrigin();
            horaIniSec = MovilidadUtil.toSecs(timeOrigin);
            timeDestiny = ps.getRealTimeDestiny();
            horaFinSec = MovilidadUtil.toSecs(ps.getRealTimeDestiny());
        } else {
            timeOrigin = ps.getTimeOrigin();
            horaIniSec = MovilidadUtil.toSecs(timeOrigin);
            timeDestiny = ps.getTimeDestiny();
            horaFinSec = MovilidadUtil.toSecs(timeDestiny);
        }
        ParamFeriado pffHI = paraFeEJB.findByFecha(ps.getFecha());
        ParamFeriado pffHF = pffHI;
        Date fecha = ps.getFecha();
        if (horaFinSec > ultimaHoraDia) {
            fecha = MovilidadUtil.sumarDias(ps.getFecha(), 1);
            pffHF = paraFeEJB.findByFecha(fecha);
        }
        
        // REGLA ESPECIAL ÁREA LAVADO
        if (areaId != null && areaId == 6) {
            if (MovilidadUtil.isSaturday(ps.getFecha())) {
                // Sábado se trata como domingo festivo
                // Retornar 3 (domingo sin festivo real)
                return 3;
            }
            if (MovilidadUtil.isSunday(ps.getFecha())) {
                // Domingo se trata como día ordinario
                return 0;
            }
        }
        
//        Si ja jornada conmienza un dia festivo y termina el domingo
        if (pffHI != null && MovilidadUtil.isSunday(fecha)) {
            return 1;
        }
//        Si la jornada comineza un domingo y termina en un festivo
        if ((pffHF != null && MovilidadUtil.isSunday(ps.getFecha()))) {
            return 2;
        }
//        Si la jornada comienza o termina un dia domingo
        if (MovilidadUtil.isSunday(fecha) || MovilidadUtil.isSunday(ps.getFecha())) {
            return 3;
        }
        return 0;
    }

    private Map getMailParams() {
        NotificacionCorreoConf conf = NCCEJB.find(1);
        NotificacionTemplate template = notificacionTemplateEjb.find(ConstantsUtil.TEMPLATEGENERICAJORNADA);
        Map mapa = new HashMap();
        mapa.put("host", conf.getSmtpServer());
        mapa.put("mailBcc", conf.getCc1());
        mapa.put("from", conf.getEmail());
        mapa.put("port", conf.getPuerto().toString());
        mapa.put("password", conf.getPassword());
        mapa.put("template", template.getPath());
        return mapa;
    }

    public void notificar(GenericaJornada gj) {
        try {
            Map mapa = getMailParams();
            Map mailProperties = new HashMap();
            Empleado empl = gj.getIdEmpleado();
            GenericaJornadaMotivo motivo = jornadaMotivoEJB.find(gj.getIdGenericaJornadaMotivo().getIdGenericaJornadaMotivo());
            mailProperties.put("identificacion", empl.getIdentificacion());
            mailProperties.put("nombre", empl.getNombres() + " " + empl.getApellidos());
            mailProperties.put("fecha", Util.dateFormat(gj.getFecha()));
            mailProperties.put("hora_ini_prg", gj.getTimeOrigin());
            mailProperties.put("hora_fin_prg", gj.getTimeDestiny());
            mailProperties.put("hora_ini_real", gj.getRealTimeOrigin());
            mailProperties.put("hora_fin_real", gj.getRealTimeDestiny());
            mailProperties.put("user_name", user.getUsername());
            mailProperties.put("motivo", motivo.getDescripcion());
            mailProperties.put("observacion", gj.getObservaciones());
//            System.out.println("Notificar...");
            mailProperties.put("url", generarTokenUrl(gj));
            String asunto = "MODIFICACIÓN JORNADA";
            String destinatarios = genJornadaParam.getEmails();
            SendMails.sendEmail(mapa, mailProperties, asunto, "", destinatarios, "Notificaciones RIGEL", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean aprobarHorasFeriadas(GenericaJornada gj) {
        int totalHorasExtrasNuevas = MovilidadUtil.toSecs(gj.getFestivoExtraDiurno())
                + MovilidadUtil.toSecs(gj.getFestivoExtraNocturno());
        if (totalHorasExtrasNuevas > 0) {
            return true;
        }
        return false;
    }

    public boolean isRealTime(Integer autizado, Integer prgModificada, String realTime) {
        if (autizado != null && autizado == 1) {
            return realTime != null;
        } else {
            return prgModificada != null && prgModificada == 1;
        }
    }

    /**
     * Resta segundos de un tiempo y garantiza que nunca retorne valores negativos
     * @param tiempoBase Tiempo en formato "HH:mm:ss"
     * @param segundosARestar Segundos a restar
     * @return Tiempo resultante o "00:00:00" si el resultado sería negativo
     */
    private String restarTiempoSeguro(String tiempoBase, int segundosARestar) {
        int baseEnSegundos = MovilidadUtil.toSecs(tiempoBase);
        int resultado = baseEnSegundos - segundosARestar;
        return resultado > 0 ? MovilidadUtil.toTimeSec(resultado) : calculator.hr_cero;
    }

    /**
     * Realiza operaciones aritméticas con tiempos de forma segura
     * @param tiempo1 Primer tiempo en formato "HH:mm:ss"
     * @param tiempo2 Segundo tiempo en formato "HH:mm:ss"
     * @param sumar true para sumar, false para restar
     * @return Tiempo resultante o "00:00:00" si el resultado sería negativo
     */
    private String operarTiempoSeguro(String tiempo1, String tiempo2, boolean sumar) {
        int seg1 = MovilidadUtil.toSecs(tiempo1);
        int seg2 = MovilidadUtil.toSecs(tiempo2);
        int resultado = sumar ? seg1 + seg2 : seg1 - seg2;
        return resultado > 0 ? MovilidadUtil.toTimeSec(resultado) : calculator.hr_cero;
    }

        /**
         * Pasa las horas calculadas(diurnas, nocturnas, extra diurna, extra
         * nocturna, festivo diurno, festivo nocturno, festivo extra diurna, festivo
         * extra nocturno) a los atributos de dominicales sin y con compesatorios
         * nocturno
         *
         * @param gj Objeto GenericaJornada que contiene la jornada del empleado a
         * gestionar.
         * @param descanso Variable int que trabaja con dos valores 0 y 1, el primer
         * valor indica que no hay descanso en la semana y el segundo valor indica
         * que si hay descanso en la semana
         * @param tieneFestivo indica si la jornada a trabajar tiene festivo en su
         * turno.
         * @return
         */
        public GenericaJornada pasarHoras(GenericaJornada gj, int descanso, int tieneFestivo) {
            int ultimaHoraDia = MovilidadUtil.toSecs("23:59:59");
            int horaIniSec;
            int horaFinSec;
            String timeOrigin;
            String timeDestiny;
            boolean realTime = isRealTime(gj.getAutorizado(), gj.getPrgModificada(), gj.getRealTimeOrigin());
            
            if (realTime) {
                timeOrigin = gj.getRealTimeOrigin();
                horaIniSec = MovilidadUtil.toSecs(timeOrigin);
                timeDestiny = gj.getRealTimeDestiny();
                horaFinSec = MovilidadUtil.toSecs(timeDestiny);
            } else {
                timeOrigin = gj.getTimeOrigin();
                horaIniSec = MovilidadUtil.toSecs(timeOrigin);
                timeDestiny = gj.getTimeDestiny();
                horaFinSec = MovilidadUtil.toSecs(timeDestiny);
            }

            if (horaIniSec == 0 && horaFinSec == 0) {
                return null;
            }

            if (descanso != 0) {
                // ⭐ MODIFICAR ESTA VALIDACIÓN
                // Solo verificar si tiene horas festivas para mover
                boolean tieneHorasFestivas = MovilidadUtil.toSecs(gj.getFestivoDiurno()) > 0 
                    || MovilidadUtil.toSecs(gj.getFestivoNocturno()) > 0 
                    || MovilidadUtil.toSecs(gj.getFestivoExtraDiurno()) > 0 
                    || MovilidadUtil.toSecs(gj.getFestivoExtraNocturno()) > 0;

                // Si no tiene horas festivas para mover, salir
                if (!tieneHorasFestivas) {
                    return null;
                }
                
                int diurnas_dom = 0;
                int nocturnas_dom = 0;
                int diurnas_dom_extra = 0;
                int nocturnas_dom_extra = 0;

                //La jornada comienza un festivo y termina en domingo
                if (tieneFestivo == 1) {
                    if (MovilidadUtil.toSecs(timeDestiny) > MovilidadUtil.toSecs("30:00:00")) {
                        diurnas_dom = MovilidadUtil.toSecs(timeDestiny) - MovilidadUtil.toSecs("30:00:00");
                        nocturnas_dom = MovilidadUtil.toSecs(timeDestiny) - ultimaHoraDia - diurnas_dom;

                        if (MovilidadUtil.toSecs(gj.getFestivoExtraDiurno()) > 0) {
                            gj.setDominicalCompDiurnaExtra(gj.getFestivoExtraDiurno());
                            gj.setFestivoExtraDiurno(calculator.hr_cero);
                        } else {
                            gj.setDominicalCompDiurnaExtra(calculator.hr_cero);
                        }

                        if (MovilidadUtil.toSecs(gj.getFestivoExtraNocturno()) > 0) {
                            if (MovilidadUtil.toSecs(gj.getFestivoExtraNocturno()) > MovilidadUtil.toSecs("01:00:00")) {
                                int horasDominical = MovilidadUtil.toSecs(timeDestiny) - ultimaHoraDia;

                                if (horasDominical >= MovilidadUtil.toSecs(gj.getFestivoExtraNocturno())) {
                                    gj.setDominicalCompNocturnaExtra(gj.getFestivoExtraNocturno());
                                    gj.setFestivoExtraNocturno(calculator.hr_cero);
                                } else {
                                    gj.setDominicalCompNocturnaExtra(MovilidadUtil.toTimeSec(horasDominical));
                                    gj.setFestivoExtraNocturno(operarTiempoSeguro(
                                        gj.getFestivoExtraNocturno(), 
                                        MovilidadUtil.toTimeSec(horasDominical), 
                                        false
                                    ));
                                }
                            } else {
                                gj.setDominicalCompNocturnaExtra(gj.getFestivoExtraNocturno());
                                gj.setFestivoExtraNocturno(calculator.hr_cero);
                            }
                        } else {
                            gj.setDominicalCompNocturnaExtra(calculator.hr_cero);
                        }

                        gj.setDominicalCompDiurnas(MovilidadUtil.toTimeSec(diurnas_dom));
                        gj.setDominicalCompNocturnas(MovilidadUtil.toTimeSec(nocturnas_dom));
                        gj.setFestivoDiurno(restarTiempoSeguro(gj.getFestivoDiurno(), diurnas_dom));
                        gj.setFestivoNocturno(restarTiempoSeguro(gj.getFestivoNocturno(), nocturnas_dom));

                    } else {
                        nocturnas_dom = MovilidadUtil.toSecs(timeDestiny) - ultimaHoraDia;

                        if (MovilidadUtil.toSecs(gj.getFestivoExtraNocturno()) > 0) {
                            if (nocturnas_dom > MovilidadUtil.toSecs(gj.getFestivoExtraNocturno())) {
                                nocturnas_dom = nocturnas_dom - MovilidadUtil.toSecs(gj.getFestivoExtraNocturno());
                            } else {
                                nocturnas_dom = 0;
                            }
                            int horasFestivas = ultimaHoraDia - MovilidadUtil.toSecs(timeOrigin);
                            if (horasFestivas >= MovilidadUtil.toSecs(horasJornada)) {
                                gj.setDominicalCompNocturnaExtra(gj.getFestivoExtraNocturno());

                                if (MovilidadUtil.toSecs(gj.getDominicalCompNocturnaExtra()) >= MovilidadUtil.toSecs(gj.getFestivoExtraNocturno())) {
                                    gj.setFestivoExtraNocturno(calculator.hr_cero);
                                } else {
                                    gj.setFestivoExtraNocturno(operarTiempoSeguro(
                                        gj.getFestivoExtraNocturno(),
                                        gj.getDominicalCompNocturnaExtra(),
                                        false
                                    ));
                                }
                            } else {
                                gj.setDominicalCompNocturnaExtra(gj.getFestivoExtraNocturno());
                                gj.setDominicalCompDiurnas(calculator.hr_cero);
                                gj.setDominicalCompNocturnas(MovilidadUtil.toTimeSec(nocturnas_dom));
                                gj.setFestivoExtraNocturno(calculator.hr_cero);
                                gj.setFestivoNocturno(restarTiempoSeguro(gj.getFestivoNocturno(), nocturnas_dom));
                            }
                        } else {
                            gj.setDominicalCompNocturnaExtra(calculator.hr_cero);
                            gj.setDominicalCompDiurnas(calculator.hr_cero);
                            gj.setDominicalCompNocturnas(MovilidadUtil.toTimeSec(nocturnas_dom));
                            gj.setFestivoNocturno(restarTiempoSeguro(gj.getFestivoNocturno(), nocturnas_dom));
                        }
                    }
                    return gj;
                }

                //La jornada comienza un domingo y termina en festivo
                if (tieneFestivo == 2) {
                    if (MovilidadUtil.toSecs(timeOrigin) < MovilidadUtil.toSecs(calculator.getIni_nocturna())) {
                        diurnas_dom = MovilidadUtil.toSecs(calculator.getIni_nocturna()) - MovilidadUtil.toSecs(timeOrigin);
                        nocturnas_dom = ultimaHoraDia - MovilidadUtil.toSecs(timeOrigin) - diurnas_dom;

                        if (MovilidadUtil.toSecs(gj.getFestivoExtraNocturno()) > 0) {
                            int horasDominical = ultimaHoraDia - MovilidadUtil.toSecs(timeOrigin);

                            if (horasDominical >= MovilidadUtil.toSecs(horasJornada)) {
                                String horasExtrasComp = MovilidadUtil.toTimeSec(horasDominical - MovilidadUtil.toSecs(horasJornada));
                                gj.setDominicalCompNocturnaExtra(horasExtrasComp);

                                if (MovilidadUtil.toSecs(gj.getDominicalCompNocturnaExtra()) >= MovilidadUtil.toSecs(gj.getFestivoExtraNocturno())) {
                                    gj.setFestivoExtraNocturno(calculator.hr_cero);
                                } else {
                                    gj.setFestivoExtraNocturno(operarTiempoSeguro(
                                        gj.getFestivoExtraNocturno(),
                                        gj.getDominicalCompNocturnaExtra(),
                                        false
                                    ));
                                }

                                gj.setDominicalCompDiurnas(gj.getFestivoDiurno());
                                gj.setDominicalCompNocturnas(gj.getFestivoNocturno());
                                gj.setFestivoNocturno(calculator.hr_cero);
                                gj.setFestivoDiurno(calculator.hr_cero);
                            } else {
                                gj.setDominicalCompNocturnaExtra(calculator.hr_cero);
                                gj.setDominicalCompDiurnaExtra(calculator.hr_cero);
                                gj.setDominicalCompDiurnas(MovilidadUtil.toTimeSec(diurnas_dom));
                                gj.setDominicalCompNocturnas(MovilidadUtil.toTimeSec(nocturnas_dom));
                                gj.setFestivoNocturno(restarTiempoSeguro(gj.getFestivoNocturno(), nocturnas_dom));
                                gj.setFestivoDiurno(restarTiempoSeguro(gj.getFestivoDiurno(), diurnas_dom));
                            }
                        } else {
                            gj.setDominicalCompNocturnaExtra(calculator.hr_cero);
                            gj.setDominicalCompDiurnaExtra(calculator.hr_cero);
                            gj.setDominicalCompDiurnas(gj.getFestivoDiurno());
                            gj.setFestivoDiurno(calculator.hr_cero);
                            gj.setDominicalCompNocturnas(MovilidadUtil.toTimeSec(nocturnas_dom));
                            gj.setFestivoNocturno(restarTiempoSeguro(gj.getFestivoNocturno(), nocturnas_dom));
                            return gj;
                        }
                    } else {
                        nocturnas_dom = ultimaHoraDia - MovilidadUtil.toSecs(timeOrigin);
                        gj.setDominicalCompDiurnas(calculator.hr_cero);
                        gj.setDominicalCompNocturnas(MovilidadUtil.toTimeSec(nocturnas_dom));
                        gj.setFestivoNocturno(restarTiempoSeguro(gj.getFestivoNocturno(), nocturnas_dom));
                    }
                    return gj;
                }

                //La jornada comienza o termina un domingo y no tuvo festivos
                if (tieneFestivo == 3) {
                    if (MovilidadUtil.toSecs(gj.getFestivoDiurno()) > 0 
                        || MovilidadUtil.toSecs(gj.getFestivoNocturno()) > 0 
                        || MovilidadUtil.toSecs(gj.getFestivoExtraDiurno()) > 0 
                        || MovilidadUtil.toSecs(gj.getFestivoExtraNocturno()) > 0) {

                        gj.setDominicalCompDiurnas(gj.getFestivoDiurno());
                        gj.setDominicalCompNocturnas(gj.getFestivoNocturno());
                        gj.setDominicalCompNocturnaExtra(gj.getFestivoExtraNocturno());
                        gj.setDominicalCompDiurnaExtra(gj.getFestivoExtraDiurno());
                        gj.setFestivoDiurno(calculator.hr_cero);
                        gj.setFestivoNocturno(calculator.hr_cero);
                        gj.setFestivoExtraNocturno(calculator.hr_cero);
                        gj.setFestivoExtraDiurno(calculator.hr_cero);
                    }
                    return gj;
                }

                if (tieneFestivo == 0) {
                    gj.setDominicalCompDiurnaExtra(null);
                    gj.setDominicalCompNocturnaExtra(null);
                    gj.setDominicalCompDiurnas(null);
                    gj.setDominicalCompNocturnas(null);
                    return gj;
                }

            } else {
                if (gj.getDominicalCompDiurnas() != null) {
                    if (gj.getAutorizado() != null && gj.getAutorizado() == 1 && gj.getNominaBorrada() == 0) {
                        if (MovilidadUtil.toSecs(gj.getRealTimeDestiny()) > 0) {
                            gj.setFestivoDiurno(operarTiempoSeguro(
                                gj.getDominicalCompDiurnas(),
                                gj.getFestivoDiurno(),
                                true
                            ));
                            gj.setFestivoNocturno(operarTiempoSeguro(
                                gj.getDominicalCompNocturnas(),
                                gj.getFestivoNocturno(),
                                true
                            ));
                            gj.setDominicalCompDiurnas(null);
                            gj.setDominicalCompNocturnas(null);
                            gj.setFestivoExtraNocturno(operarTiempoSeguro(
                                gj.getDominicalCompNocturnaExtra(),
                                gj.getFestivoExtraNocturno(),
                                true
                            ));
                            gj.setFestivoExtraDiurno(operarTiempoSeguro(
                                gj.getDominicalCompDiurnaExtra(),
                                gj.getFestivoExtraDiurno(),
                                true
                            ));
                            gj.setDominicalCompNocturnaExtra(null);
                            gj.setDominicalCompDiurnaExtra(null);
                        } else {
                            gj.setDominicalCompDiurnas(null);
                            gj.setDominicalCompNocturnas(null);
                            gj.setDominicalCompNocturnaExtra(null);
                            gj.setDominicalCompDiurnaExtra(null);
                        }
                    } else if ((gj.getAutorizado() == null && gj.getNominaBorrada() == 0) 
                               || (gj.getAutorizado() != null && gj.getAutorizado() == 0 && gj.getNominaBorrada() == 0)) {
                        if (MovilidadUtil.toSecs(gj.getTimeOrigin()) > 0) {
                            gj.setFestivoDiurno(operarTiempoSeguro(
                                gj.getDominicalCompDiurnas(),
                                gj.getFestivoDiurno(),
                                true
                            ));
                            gj.setFestivoNocturno(operarTiempoSeguro(
                                gj.getDominicalCompNocturnas(),
                                gj.getFestivoNocturno(),
                                true
                            ));
                            gj.setDominicalCompDiurnas(null);
                            gj.setDominicalCompNocturnas(null);
                            gj.setFestivoExtraNocturno(operarTiempoSeguro(
                                gj.getDominicalCompNocturnaExtra(),
                                gj.getFestivoExtraNocturno(),
                                true
                            ));
                            gj.setFestivoExtraDiurno(operarTiempoSeguro(
                                gj.getDominicalCompDiurnaExtra(),
                                gj.getFestivoExtraDiurno(),
                                true
                            ));
                            gj.setDominicalCompNocturnaExtra(null);
                            gj.setDominicalCompDiurnaExtra(null);
                        } else {
                            gj.setDominicalCompDiurnas(null);
                            gj.setDominicalCompNocturnas(null);
                            gj.setDominicalCompNocturnaExtra(null);
                            gj.setDominicalCompDiurnaExtra(null);
                        }
                    }
                    return gj;
                }
            }

            return null;
        }

    public String generarTokenUrl(GenericaJornada gj) {

        GenericaJornadaToken gjt = new GenericaJornadaToken();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String uri = request.getRequestURI();
        String url = request.getRequestURL().toString();
        String ctxPath = request.getContextPath();
        url = url.replaceFirst(uri, "");
        url = url + ctxPath;
        String token = TokenGeneratorUtil.nextToken();
        url = url + "/genericaJornadaToken/genericaJornadaToken.jsf?pin=" + token;
        gjt.setActivo(0);
        gjt.setCreado(MovilidadUtil.fechaCompletaHoy());
        gjt.setEstadoReg(0);
        gjt.setIdGenericaJornada(gj);
        gjt.setToken(token);
        gjt.setUsername(user.getUsername());
        genJornadaTokenEJB.create(gjt);
        return url;
    }

    private Map<String, List<GenericaJornada>> cargarMapSemanalDeJornadas(List<GenericaJornada> jornadas) throws ParseException {
        jornadas.sort((d1, d2) -> d1.getFecha().compareTo(d2.getFecha()));
        Date fromDate = jornadas.get(0).getFecha();
        int indexLast = jornadas.size() - 1;
        Date toDate = jornadas.get(indexLast).getFecha();
        Calendar current = Calendar.getInstance();
        current.setTime(fromDate);
        int i = 1;
        Map<String, List<GenericaJornada>> map = new HashMap<>();
        while (!current.getTime().after(toDate)) {
            Date diaDomingo = MovilidadUtil.getDiaSemana(current.getTime(), Calendar.SUNDAY);
            String key = Util.dateFormat(current.getTime()).concat("_").concat(Util.dateFormat(diaDomingo));
            List<GenericaJornada> list = jornadas.stream()
                    .filter(x -> MovilidadUtil.betweenSinHora(x.getFecha(), current.getTime(), diaDomingo))
                    .collect(Collectors.toList());
            map.put(key, list);
            current.setTime(MovilidadUtil.sumarDias(diaDomingo, 1));
        }
        List<Map.Entry<String, List<GenericaJornada>>> list = new ArrayList<>(map.entrySet());

        // Invertir el orden de la lista
        Collections.reverse(list);
        Map<String, List<GenericaJornada>> reversedMap = new HashMap<>();
        for (Map.Entry<String, List<GenericaJornada>> entry : list) {
            reversedMap.put(entry.getKey(), entry.getValue());
        }
        return reversedMap;
    }

    public String getRol_user() {
        return rol_user;
    }

    public void setRol_user(String rol_user) {
        this.rol_user = rol_user;
    }

    public GenericaJornadaParam getGenJornadaParam() {
        return genJornadaParam;
    }

    public void setGenJornadaParam(GenericaJornadaParam genJornadaParam) {
        this.genJornadaParam = genJornadaParam;
    }

    public List<GenericaJornada> getGenericaJornadaList() {
        return genericaJornadaList;
    }

    public void setGenericaJornadaList(List<GenericaJornada> genericaJornadaList) {
        this.genericaJornadaList = genericaJornadaList;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Map<String, GenericaJornadaTipo> getMapJornadaTipo() {
        return mapJornadaTipo;
    }

    public void setMapJornadaTipo(Map<String, GenericaJornadaTipo> mapJornadaTipo) {
        this.mapJornadaTipo = mapJornadaTipo;
    }

    public Map<String, ParamFeriado> getMapParamFeriado() {
        return mapParamFeriado;
    }

    public void setMapParamFeriado(Map<String, ParamFeriado> mapParamFeriado) {
        this.mapParamFeriado = mapParamFeriado;
    }

    public ParamAreaUsr getPau() {
        return pau;
    }

    public void setPau(ParamAreaUsr pau) {
        this.pau = pau;
    }

}
