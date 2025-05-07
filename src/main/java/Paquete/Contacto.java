package Paquete;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Profesores de los Alumnos y Asignaturas
 * @author Oscar Maqueda Baños
 * @version 1.0
 */
public class Contacto {
    //ATRIBUTOS DE CLASE
    private String correo, telefono, nombre;

    //ATRIBUTOS CON ASOCIACIONES
    public HashSet<Alumno> alumnos_suscritos;
    public Asignatura asignatura_impartida;

    /**
     * Contructor de Contacto
     * @param correo Correo de Contacto del profesor
     * @param telefono Telefono de Contacto del profesor
     * @param nombre Nombre del profesor
     * @param asignatura_impartida Asignatura impartida por el profesor
     */
    public Contacto(String correo, String telefono, String nombre, Asignatura asignatura_impartida) {
        this.correo = correo;
        this.telefono = telefono;
        this.nombre = nombre;
        this.asignatura_impartida = asignatura_impartida;
        alumnos_suscritos = new HashSet<>();
    }

    Scanner sc = new Scanner(System.in);

    /**
     * Metodo para expulsar a un alumno
     * @param alumno_expulsado Alumno al que desea expulsar
     */
    public void expulsarAlumno(Alumno alumno_expulsado){
        alumnos_suscritos.remove(alumno_expulsado);
        asignatura_impartida.getAlumnos_inscritos().remove(alumno_expulsado);
    }

    /**
     * Poner una nueva Actividad a realizar
     * @param fecha_entrega Poner fecha de entrega
     * @param fecha_inicio Poner fecha de inicio de la Actividad
     * @param descripcion Poner breve descripcion de la Actividad
     * @param titulo Poner titulo de la Actividad
     */
    public void aniadirActividad(int[] fecha_entrega, int[] fecha_inicio, String descripcion, String titulo){
        asignatura_impartida.getActividades().add(new Actividades(fecha_entrega, fecha_inicio, descripcion, titulo));
    }

    /**
     * Metodo para ponerle la nota a un alumno
     */
    public void ponerNota(){
        System.out.println("Elige el nombre de un Alumno para ponerle nota:");
        for (Alumno alumno : alumnos_suscritos) { //MOSTRAR ALUMNOS
            System.out.println(alumno);
        }
        String nombre = sc.next();

        for (Alumno alumno : alumnos_suscritos) { //ACCEDER A LOS ALUMNOS DEL PROFESOR
            if (alumno.getNombre().equalsIgnoreCase(nombre)) { //COMPROBAR QUE EL ALUMNO COINCIDE CON LO INSERTADO
                for (Asignatura asignatura : alumno.getAsignaturas_inscritas()) { //COMPROBAR LAS ASIGNATURAS DEL ALUMNO
                    if (asignatura.equals(asignatura_impartida)){ //SELECCIONAR LA ASIGNATURA QUE IMPARTE EL PROFESOR
                        System.out.println("Que actividad le vas a evaluar, elige su titulo");
                        for (Actividades actividades : asignatura.getActividades()) { //MOSTRAR LAS ACTIVIDADES PUBLICADAS
                            System.out.println("titulo: " + actividades.getTitulo() + ", descripcion: " + actividades.getDescripcion());
                        }
                        String titulo = sc.next();

                        for (Actividades actividades : asignatura.getActividades()) {
                            if (actividades.getTitulo().equalsIgnoreCase(titulo)) { //COMPROBAR QUE EXISTE UNA ACTIVIDAD CON ESE TITULO
                                if (actividades.isEntrega()) {
                                    System.out.println("Que nota le va a poner?");
                                    int nota_nueva = sc.nextInt();

                                    actividades.setNota(nota_nueva);
                                }else{
                                    System.out.println("La actividad no ha sido entregada aun");
                                }
                            }else{
                                System.out.println("No existe ningun titulo asi");
                            }
                        }
                    }
                }
            }else{
                System.out.println("No existe ningun alumno en su regimen con ese nombre");
            }
        }
    }

    //#################### GETTER AND SETTERS ####################


    /**
     * Getter de Alumnos inscritos a la misma Asignatura impartida
     * @return Alumnos inscritos a la misma Asignatura impartida
     */
    public HashSet<Alumno> getAlumnos_suscritos() {
        return alumnos_suscritos;
    }

    /**
     * Getter Asignatura impartida por el profesor
     * @return Asignatura impartida por el profesor
     */
    public Asignatura getAsignatura_impartida() {
        return asignatura_impartida;
    }

}
