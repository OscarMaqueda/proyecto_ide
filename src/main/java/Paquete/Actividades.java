package Paquete;
/**
 * Actividades de las Asignaturas
 * @author Oscar Maqueda Baños
 * @version 1.0
 */

public class Actividades {
    //ATRIBUTOS DE CLASE
    private int[] fecha_entrega,fecha_inicio;
    private String descripcion, titulo;
    private boolean entrega;
    private int nota;

    /**
     * Constructor de la clase Actividades
     * @param fecha_entrega La fecha de entrega de la actividad
     * @param fecha_inicio Fecha en la que actividad da inicio
     * @param descripcion Breve descripcion de la tarea a realizar
     * @param titulo Titulo de la Actividad
     */

    public Actividades(int[] fecha_entrega, int[] fecha_inicio, String descripcion, String titulo) {
        this.fecha_entrega = fecha_entrega;
        this.fecha_inicio = fecha_inicio;
        this.descripcion = descripcion;
        this.titulo = titulo;
        entrega = false;
    }

    //#################### GETTER AND SETTERS ####################

    /**
     * Getter de la Descripcion de la Actividad
     * @return descripcion de la Actividad
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Getter del Titulo de la Actividad
     * @return titulo de la Actividad
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Comprobador de si se ha entregado o no la Actividad
     * @return True = Si; False = No
     */
    public boolean isEntrega() {
        return entrega;
    }

    /**
     * Cambia el estado de la entrega de la Actividad
     * @param entrega True = Si; False = No
     */
    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }

    /**
     * Getter de la Nota de la Actividad
     * @return nota de la Actividad
     */
    public int getNota() {
        return nota;
    }

    /**
     * Setter de la Nota de la Actividad
     * @param nota nota nueva
     */
    public void setNota(int nota) {
        this.nota = nota;
    }

    /**
     * Getter de la Fecha de entrega de la Actividad
     * @return Fecha de entrega de la Actividad
     */
    public int[] getFecha_entrega() {
        return fecha_entrega;
    }

    /**
     * Setter de la Fecha de inicio de la Actividad
     * @return Fecha de inicio de la Actividad
     */
    public int[] getFecha_inicio() {
        return fecha_inicio;
    }
}
