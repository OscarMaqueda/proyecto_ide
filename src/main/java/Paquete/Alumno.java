package Paquete;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Alumnos
 * @author Oscar Maqueda Baños
 * @version 1.0
 */
public class Alumno {
    //ATRIBUTOS DE CLASE
    private String nombre, apellidos, telefono, dni, direccion;
    private int edad;

    //ATRIBUTOS CON ASOCIACIONES
    public HashSet<Asignatura> asignaturas_inscritas;
    public HashSet<Noticias> noticias_inscritas;
    public HashSet<Contacto> contactos_disponibles;

    /**
     * Constructor del Alumno
     * @param nombre Nombre del alumno
     * @param apellidos Apellidos del alumno
     * @param telefono Telefono del alumno
     * @param dni Dni del alumno
     * @param direccion Direccion del alumno
     * @param edad Edad del alumno
     */
    public Alumno(String nombre, String apellidos, String telefono, String dni, String direccion, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.dni = dni;
        this.direccion = direccion;
        this.edad = edad;
        asignaturas_inscritas = new HashSet<>();
        contactos_disponibles = new HashSet<>();
        noticias_inscritas = new HashSet<>();
    }

    Scanner sc = new Scanner(System.in);

    /**
     * Consulta la nota media de todas las asignaturas
     * @return media entre todas las asignaturas
     */
    public int consultarNotaMediaGeneral() {
        int variable = 0, cont_cantidadNotas = 0;
        for (Asignatura asig : asignaturas_inscritas) {
            for (Actividades acti : asig.getActividades()) {
                variable = variable + acti.getNota();
                cont_cantidadNotas++;
            }
        }
        try {
            return variable / cont_cantidadNotas;
        } catch (ArithmeticException e) {
            System.out.println("No tienes ninguna nota asignada");
            return 0;
        }
    }

    /**
     * Pregunta que actividad desea realizar y la pone como entregada
     */
    public void realizarTarea(){
        System.out.println("De que asignatura lo va a entregar?");
        for (Asignatura asignatura : asignaturas_inscritas){ //MOSTRAR ASIGNATURAS QUE ESTAS INSCRITO
            System.out.println(asignatura.getNombre());
        }
        String nombre = sc.next();

        for (Asignatura asignatura : getAsignaturas_inscritas()){
            if (asignatura.getNombre().equalsIgnoreCase(nombre)){ //SELECCIONAR LA ASIGNATURA
                System.out.println("Cual actividad quiere entregar?");
                for (Actividades actividades : asignatura.getActividades()){ //MOSTRAR ACTIVIDADES DE LA ASIGNATURA
                    System.out.println(actividades.getTitulo());
                }
                String titulo = sc.next();

                for (Actividades actividades : asignatura.getActividades()){
                    if (actividades.getTitulo().equalsIgnoreCase(titulo)){ //COMPROBAR QUE TENGA EL MISMO TITULO
                        actividades.setEntrega(true);
                    }else{
                        System.out.println("No hay ninguna Actividad con ese titulo");
                    }
                }
            }else{
                System.out.println("No estas inscrito en esa asignatura");
            }
        }

    }

    /**
     * Metodo ToString modificado
     * @return Nombre alumno y sus apellidos
     */
    @Override
    public String toString() {
        return "[nombre: "+nombre+" apellidos: "+apellidos+"]";
    }

    //#################### GETTER AND SETTERS ####################

    /**
     * Getter Nombre Alumno
     * @return Nombre Alumno
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter Asignaturas Inscritas del Alumno
     * @return Asignaturas Inscritas del Alumno
     */
    public HashSet<Asignatura> getAsignaturas_inscritas() {
        return asignaturas_inscritas;
    }

    /**
     * Getter Profesores disponibles a Contactar del Alumno
     * @return Profesores disponibles a Contactar del Alumno
     */
    public HashSet<Contacto> getContactos_disponibles() {
        return contactos_disponibles;
    }

}
