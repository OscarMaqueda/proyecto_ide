import Paquete.Actividades;
import Paquete.Alumno;
import Paquete.Asignatura;
import Paquete.Contacto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


class ContactoTest {

    @Test
    void aniadirActividad() {
        ArrayList<String> dias = new ArrayList<>();
        dias.add("Lunes");
        dias.add("Miercoles");
        dias.add("Viernes");

        Asignatura asig1 = new Asignatura(100,20,1,"BaseDatos",dias);
        Contacto profe1 = new Contacto("profe1@profe1.com","+34-2222","pedro",asig1);

        int[] fecha1 = {1,2};
        int[] fecha2 = {1,3};
        String titulo = "practica_1";
        String descripcion1 = "actividad base de datos";

        profe1.aniadirActividad(fecha2, fecha1,descripcion1,titulo);

        for (Actividades actividades : profe1.getAsignatura_impartida().getActividades())
            assertEquals("practica_1", actividades.getTitulo());

        for (Actividades actividades : profe1.getAsignatura_impartida().getActividades())
            assertEquals("actividad base de datos", actividades.getDescripcion());

        for (Actividades actividades : profe1.getAsignatura_impartida().getActividades())
            assertEquals(fecha1, actividades.getFecha_inicio());

        for (Actividades actividades : profe1.getAsignatura_impartida().getActividades())
            assertEquals(fecha2, actividades.getFecha_entrega());
    }

    @Test
    void ponerNota() {
        ArrayList<String> dias = new ArrayList<>();
        dias.add("Lunes");
        dias.add("Miercoles");
        dias.add("Viernes");

        Alumno alu1 = new Alumno("pepe","gonzalez","+34-1111","11111D","malaga",18);
        Asignatura asig1 = new Asignatura(100,20,1,"BaseDatos",dias);
        Contacto profe1 = new Contacto("profe1@profe1.com","+34-2222","pedro",asig1);

        alu1.getAsignaturas_inscritas().add(asig1);
        alu1.getContactos_disponibles().add(profe1);
        profe1.getAlumnos_suscritos().add(alu1);
        asig1.getAlumnos_inscritos().add(alu1);

        int[] fecha1 = {1,2};
        int[] fecha2 = {1,3};
        String titulo = "practica_1";
        String descripcion1 = "actividad base de datos";

        profe1.getAsignatura_impartida().getActividades().add(new Actividades(fecha2, fecha1, titulo, descripcion1));

        for (Asignatura asignatura : alu1.getAsignaturas_inscritas())
            for (Actividades actividades : asignatura.getActividades())
                actividades.setEntrega(true);


        for (Actividades actividades : profe1.getAsignatura_impartida().getActividades()) //METODO PONER NOTA
            actividades.setNota(8);


        for (Actividades actividades : profe1.getAsignatura_impartida().getActividades())
            assertEquals(8, actividades.getNota());
    }
}