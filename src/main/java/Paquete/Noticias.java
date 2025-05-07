package Paquete;

import java.util.HashSet;

/**
 * Noticias que puede acceder el Alumno
 * @author Oscar Maqueda Baños
 * @version 1.0
 */
public class Noticias {
    //ATRIBUTOS DE CLASE
    private  String titulo, contenido;
    private int[] fecha;

    //ATRIBUTOS CON ASOCIACIONES
    public HashSet<Alumno> alumnos_asociados;

    /**
     * Constructor de la Noticia
     * @param titulo Titulo de la Noticia
     * @param contenido Contenido de la Noticia
     * @param fecha Fecha en la que se realizo la Noticia
     */
    public Noticias(String titulo, String contenido, int[] fecha) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
    }
}
