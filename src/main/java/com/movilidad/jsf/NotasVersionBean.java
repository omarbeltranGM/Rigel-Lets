package com.movilidad.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

/**
 *
 * @author luis.lancheros
 */
@Named(value = "notasVersionBean")
@ViewScoped
public class NotasVersionBean implements Serializable {
    private List<VersionNote> notes;

    public NotasVersionBean() {
        notes = new ArrayList<>();
        notes.add(new VersionNote("1.3.3.1b", "2025-09-05", "Correcciones", 
                "- 'Novedades / Recapacitación' Permitir eliminar recapacitaciones sin que esté programada la tarea<br />"
                +   "- 'Novedades / Recapacitación' La columna 'Vigencia' se calcula correctamente<br />"
                +   "- 'Novedades / Recapacitación' Se puede asignar recapacitación sin validar la 'Fecha Inoperable'<br />"
                +   "- 'Novedades / Recapacitación' Ya no se cargan a recapacitación los accidentes que no corresponden a 'caso TM'<br />"
                +   "- 'Novedades / 03 Maestro novedades' Se agregan items en 'Tipo Infracción'<br />"
                +   "- 'Novedades / 03 Maestro novedades' Se actualiza la información del campo 'Tipo Infracción' de acuerdo a lo cargado en 'Hallazgos/Infracciones'"));
        notes.add(new VersionNote("1.3.3", "2025-08-19", "Correcciones", 
                "- 'Novedades / Daño a Flota' Error al descargar la información en archivo Excel.<br />"));
        notes.add(new VersionNote("1.3.3", "2025-08-19", "Cambios", 
                "- 'Accidentalidad / 01.Maestro Accidentes' Notificar a los usuarios parametrizados, la carga de documentos tipo 'ACTA DE CONCILIACIÓN JURIDICA'.<br />"
                +   "- 'Novedades / 03.Maestro Novedades' la nuevas novedades de tipo 'Infracciones' y 'Detalle de Tipo' 'Tipo I', 'Tipo II' o 'Tipo III' "
                        + "son asociadas al módulo 'Hallazgos / Infracciones'.<br />"
                +   "- 'Novedades / Recapacitación' Cargar automáticamente las novedades de comportamiento"));
        notes.add(new VersionNote("1.3.2", "2025-08-05", "Nuevo", 
                "- 'PD / Maestro PD' Agregar notificación de apertura de proceso disciplinario.<br />"
                +   "- 'Empleado / Usuarios' Agregar funcionalidad para resetear contraseña y notificar al email del colaborador.<br />"
                +   "- 'Empleado / Usuarios' Agregar funcionalidad para facilitar la creación y notificación de usuarios.<br />"));
        notes.add(new VersionNote("1.3.1", "2025-07-30", "Cambios", 
                "- Integrar ajustes liquidación de nómina.<br />"
                +   "- Integrar ajustes liquidación de nómina.<br />"));
        notes.add(new VersionNote("1.3.0", "2025-07-29", "Nuevo", 
                "- La ventana inicial se establece de acuerdo al rol del usuario en sesión <br />"));
        notes.add(new VersionNote("1.3.0 ", "2025-07-29", "Cambios", 
                "- 'Accidentalidad / 01. Maestro Accidentes' se agrega campo para permitir ingresar el usuario del inspector que atiende el caso. <br />"
                +   "- 'Accidentalidad / 01. Maestro Accidentes' la lista desplegable 'Desplazamiento' permite seleccionar las opciones 'SI' o 'NO'. <br />"
                +   "- 'Novedades / Recapacitación' se agrega columna 'Fecha Novedad' que contiene la fecha de creación de la novedad que genera la recapacitación. <br />"
                +   "- 'Novedades / Recapacitación' se agrega columna 'Estado Empleado' con colorimetría que indica en color verde si el operador está 'Activo' "
                        + "o en color rojo si está 'Retirado'. <br />"
                +   "- 'Novedades / Recapacitación' se agrega columna 'Vigencia' que indica en color rojo 'VENCIDA', si la novedad supera los 30 días sin ser programada.<br />"
                +   "- 'Novedades / Recapacitación' funcionalidad que permite desasignar la recapacitación dejando disponible al operador en la franja horaria donde había "
                        + "sido programada la recapacitacióm <br />"));
        notes.add(new VersionNote("1.3.0", "2025-07-29", "Correcciones", 
                "- 'Hallazgos/Infracciones' El archivo no se carga si existen errores.<br />"
                +   "- 'Hallazgos/Infracciones' Validar que el campo 'Puntos' no sea vacío.<br />"));
        notes.add(new VersionNote("1.2.1", "2025-07-07", "Cambios", 
                "- 'Novedades / Daño Flota' permitir a Gestores y Coordinador de ejecución de la operación la gestión de los registros de daño a flota <br />"));
        notes.add(new VersionNote("1.2.0", "2025-07-02", "Cambios", 
                "- Se corrigen errores al liquidar nómina.<br />"
                + "- 'Planeación y Programación / Bienestar' se agrega colorimetría a la columna 'Vigencia', los registros que estén 'Vigentes' en VERDE y los 'Vencidos' en ROJO.<br />"
                + "- 'Planeación y Programación / Bienestar' se agrega columna 'Estado Empleado' con colorimetría, 'Activo' en VERDE y 'retirado' en ROJO.<br />"
                + "- 'Planeación y Programación / Bienestar' se agrega columna 'Observación' para permitir agregar algún detalle al registro.<br />"
                + "- 'Planeación y Programación / Ejecución' habilitar opción que indique si la novedad reportada debe tener descanso en domingos/festivos.<br />"
                + "- 'Planeación y Programación / Ejecución' mostrar alerta (no bloqueante) en los registros que se ingresen y no tengan el mínimo parametrizado de horas de descanso (trasnoche-madrugue) "
                + "de la última programación disponible en Rigel."));
        notes.add(new VersionNote("1.1.2.2", "2025-06-25", "Correcciones", 
                "- 'Hallazgos / Infracciones' quitar la duplicidad de registros en el maestro de novedades al ejecutar la carga masiva de novedades infracciones.<br />"
                + "- 'Novedades / 03.Maestro novedades' los valores de los campos 'Sitio' y 'Tipo Infracción' son cargados en el proceso del menú 'Hallazgos / Infracciones'<br />"));
        notes.add(new VersionNote("1.1.2.1", "2025-06-11", "Correcciones", 
                "- 'Panel Principal / Gestión Servicio ' las clasificaciones especificadas para novedades 'Cambio Móvil' "
                        + "deben listarse únicamnete cuando se gestiona una novedad por cambio de móvil.<br />"));
        notes.add(new VersionNote("1.1.2", "2025-06-11", "Nuevo", 
                "- 'Mantenimiento / Disponibilidad de Flota' permitir carga masiva de novedades <br />"));
        notes.add(new VersionNote("1.1.2", "2025-06-11", "Correcciones", 
                "- 'Planeación y Programación / Actividades' Permitir duplicar actividades para un colaboradorador en la misma fecha.<br />"
                + "- 'Planeación y Programación / Actividades' filtros de fecha y unidad funcional son ajustados para que funcionen correctamente.<br />"
                + "- 'Planeación y Programación / Bienestar' actualizar el campo 'Vigencia' de acuerdo al momento en que se acceda al reporte.<br />"));
        notes.add(new VersionNote("1.1.2", "2025-06-11", "Cambios", 
                "- 'Planeación y Programación / Entrega Operadores' Quitar restricción en el rango de fechas seleccionable en 'Semana a Programar'.<br />"));
        notes.add(new VersionNote("1.1.1", "2025-05-30", "Cambios", 
                "- 'Panel Principal / Gestión Servicio' permitir el cambio de vehículo de busetón a padrón <br />"
                + "- 'Panel Principal / Gestión Servicio / Cambio de Móvil'  se amplian las opciones que tiene <br />"
                + "\tel usuario al momento de seleccionar 'Responsable' y 'Clasificación' <br />"));
        notes.add(new VersionNote("1.1.0", "2025-05-06", "Nuevo",
                "- Módulo 'Configuración / Parametrización Área'.<br />"
                + "Se permite creación de subprocesos (subáreas) a un proceso (área) <br />"
                + "- Módulo 'Control Jornada / Control Jornada Flexible otros cargos'.<br />"
                + "Se permite la carga y gestión de turnos por subproceso <br />"));
        notes.add(new VersionNote("1.1.0", "2025-05-06", "Correcciones", 
                "- Módulo 'Novedades / Daño flota p. componente'. Permitir descargar archivo del reporte. <br />"
                + "- Módulo 'Novedades / Daño flota p. grupo'. Permitir descargar archivo del reporte. <br />"
                + "- Módulo 'Novedades / Daño flota p. solución'. Permitir descargar archivo del reporte. <br />"));
        notes.add(new VersionNote("1.0.8", "2025-04-10", "Cambios",
                "Módulo 'Control Jornada / Control Jornada Flexible Operadores' <br />" +
                "\t- Corregir funcionalidad para que permita gestionar (aprobar/desaprobar) los ajustes de "
                        + "jornadas dominicales (nómina de operadores).<br />" +
                "\t- Corregir funcionalidad para que permita guardar los ajustes de jornadas dominicales.<br />"));
        notes.add(new VersionNote("1.0.7", "2025-04-03", "Cambios", 
                "Módulo 'Planeación & Programación / 26. Lista Proceso Programación' <br />" +
                "\t- Permitir consultar histórico de la lista de chequeo.<br />" +
                "\t- Permitir creación nuevas listas de chequeo.<br />" +
                "\t- Exportar información de las listas de chequeo en archivo excel <br />" +
                "\t- Inhabilitar edición de la información cuando la fecha actual esté fuera del rango de fechas con la que se crea la lista de chequeo.<br />" +
                "Módulo Novedades<br />" +
                "\t- Permitir cargar mas de una novedad a un operador para el mismo día.<br />"));
        notes.add(new VersionNote("1.0.6", "2025-03-06", "Nuevo", 
                "- Permitir en el módulo de maestro de novedades, asignar el estado 'En espera de ingreso' cuando la novedad afecte disponibilidad.<br />" +
                "- Permitir en el panel principal, asignar el estado 'En espera de ingreso' cuando la novedad afecte disponibilidad.<br />" +
                "- Listar los móviles con estado  'En espera de ingreso' en 'Mantenimiento / Disponibilidad de flota' <br />" +
                "- En el botón 'Agregar Actividad' permitir modificar el estado del móvil de la siguiente manera:\n" +
                "\tSe renombró botón pasando de 'Habilitar Vehículo' a  'Ingreso Centro Logístico'.\n" +
                "\tLa funcionalidad permite pasar a estado 'Inoperativo' el móvil cuando el botón 'Ingreso Centro Logístico' esté en 'Sí'. <br />"));
        notes.add(new VersionNote("1.0.6", "2025-03-06", "Cambios", 
                "- Submódulo 'Entrega de Operadores', permitir realizar la búsqueda por el número de identificación y no por Código TM. " +
                "Este cambio también aplica al ejecutar carga masiva\n <br />" 
                + "- La plantilla descargable en el submódulo 'Entrega de Operadores' se modifica de acuerdo al ajuste realizado. <br />"
                + "- Permitir crear identificador(idICO) alfanumérico en novedades tipo 'Infracciones' <br />"));
        notes.add(new VersionNote("1.0.5", "2025-02-27", "Correcciones", 
                "- Al ejecutar agenda masiva en el módulo recapacitación se actualiza la 'fecha de recapacitación' si el operador no asiste. <br />"));
        notes.add(new VersionNote("1.0.4", "2025-02-19", "Cambios", 
                "- Modificación del reporte Disponibilidad de flota del módulo Mantenimiento, para usuarios pertenecientes al proceso Mantenimiento. <br />"
                + "- Modificar el listado de ítems seleccionables cuando se desea clasificar una novedad del tipo “MTTO PREVENTIVO”. <br />"
                + "- Hacer obligatorio el campo “Fecha hora posible habilitación” al momento de crear una novedad en “Mantenimiento/Disponibilidad de flota”. <br />"));
        notes.add(new VersionNote("1.0.4", "2025-02-19", "Correcciones", 
                "- Módulo Novedades / Recapacitación. Actualización de la fecha según la programación. <br />"
                + "- Módulo Novedades / Recapacitación. Asignación de agenda (fecha) a la novedad más antigua. <br />"));
        notes.add(new VersionNote("1.0.3", "2025-02-13", "Cambios",
                "- Validación de registros entre los módulos de planeación y programación (actividades, bienestar, ejecución, medicina laboral, seguridad y vacaciones). <br />"
                + "- Quitar obligatoriedad de los campos hora inicio y hora fin en el módulo de Ejecución <br />"));
        notes.add(new VersionNote("1.0.2", "2025-02-13", "Correcciones",
                "- Agregar campos de hora inicio y hora fin, para permitir la creación de turnos. <br />"));
        notes.add(new VersionNote("1.0.2", "2025-02-13", "Correcciones",
                "- Corrección error Carga de programación en el modulo tabla control. <br />"
                + "- Corrección error actualización de campo usuario en el modulo maestro novedades al momento de cambiar puntos o al momento de aprobar o desaprobar la novedad. <br />"));
        notes.add(new VersionNote("1.0.1", "2025-01-22", "Correcciones", 
                "- Error al cargar archivo Hallazgos / Incidencias. Usuario aprobador: Richard Guevara <br />"
                + "- Imposibilidad de editar novedades tipo ‘Daño a Flota’. Usuario aprobador: Jessica Piza <br />"
                + "- Colaboradores con UF cruzada en módulo recapacitación. Usuario aprobador: Andres Castro <br />"
                + "- Error al descargar plantilla de ascenso a padrón. Usuario aprobador: Andres Castro <br />"
                + "- Al intentar gestionar una novedad de biométrico se quedaba ‘congelada’ la vista. <br />"
                + "- Actualización de cargo de empleados. Usuario aprobador: Richard Guevara <br />"));
        notes.add(new VersionNote("1.0.1", "2025-01-22", "Cambios",
                "- Funcionalidad para permitir descargar las plantillas para los procesos de carga archivo programación. <br />"
                + "- Bloquear vista del botón calcular en el menú liquidación jornada operadores. <br />"
                + "- Cambiar estado visible de la columna compensatorio en el menú liquidación jornada operadores. <br />"
                + "- Permitir aprobación masiva de novedades de marcaciones en el módulo de Biométricos. <br />"));
    }

    public List<VersionNote> getNotes() {
        return notes;
    }

    public void setNotes(List<VersionNote> notes) {
        this.notes = notes;
    }

    public static class VersionNote {
        private String version;
        private String date;
        private String type;
        private String adjustments;

        public VersionNote(String version, String date, String type, String adjustments) {
            this.version = version;
            this.date = date;
            this.type = type;
            this.adjustments = adjustments;
        }

        public String getVersion() {
            return version;
        }

        public String getDate() {
            return date;
        }

        public String getType() {
            return type;
        }

        public String getAdjustments() {
            return adjustments;
        }
    }
}
