package Paquete;

/**
 * Temario perteneciente a una Asignatura
 * @author Oscar Maqueda Baños
 * @version 1.0
 */
public class Temario {
    //ATRIBUTOS DE CLASE
    private int tema;
    private String contenido;

    /**
     * Constructor del Tema
     * @param tema Nombre identificativo del tema
     * @param contenido Contenido del tema en cuestion
     */
    public Temario(int tema, String contenido) {
        this.tema = tema;
        this.contenido = contenido;
    }
}
