package Paquete;

import java.util.HashSet;
import java.util.List;

/**
 * Asignatura de los Alumnos
 * @author Oscar Maqueda Baños
 * @version 1.0
 */
public class Asignatura {
    //ATRIBUTOS DE CLASE
    private int capacidad, duracion, hora;
    private String nombre;
    private List<String> dias;

    //ATRIBUTOS CON ASOCIACIONES
    public HashSet<Alumno> alumnos_inscritos;
    public HashSet<Actividades> actividades;
    public HashSet<Temario> temarios;

    /**
     * Constructor de la Asignatura
     * @param capacidad Capacidad de alumnos de la Asignatura
     * @param duracion Duracion en horas de la Asignatura
     * @param hora Hora a la que empieza la Asignatura
     * @param nombre Nombre de la Asignatura
     * @param dias Dias en los que la Asignatura es impartida
     */
    public Asignatura(int capacidad, int duracion, int hora, String nombre, List<String> dias) {
        this.capacidad = capacidad;
        this.duracion = duracion;
        this.hora = hora;
        this.nombre = nombre;
        this.dias = dias;
        alumnos_inscritos = new HashSet<>();
        actividades = new HashSet<>();
        temarios = new HashSet<>();
    }


    //#################### GETTER AND SETTERS ####################

    /**
     * Getter del Nombre de la Asignatura
     * @return Nombre de la Asignatura
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter de los Alumnos inscritos a la Asignatura
     * @return Alumnos inscritos a la Asignatura
     */
    public HashSet<Alumno> getAlumnos_inscritos() {
        return alumnos_inscritos;
    }

    /**
     * Getter de las Actividades de la Asignatura
     * @return Actividades de la Asignatura
     */
    public HashSet<Actividades> getActividades() {
        return actividades;
    }
}