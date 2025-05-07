import Paquete.Actividades;
import Paquete.Alumno;
import Paquete.Asignatura;
import Paquete.Contacto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

class AlumnoTest {

    @Test
    void consultarNotaMediaGeneral() {
        int variable = 0, cont_cantidadNotas = 0;

        System.out.println("nota media de las actividades del alumno");
        ArrayList<String> dias = new ArrayList<>();
        dias.add("Lunes");
        dias.add("Miercoles");
        dias.add("Viernes");

        Asignatura asig1 = new Asignatura(100,20,1,"BaseDatos",dias);

        Contacto profe1 = new Contacto("profe1@profe1.com","+34-2222","pedro",asig1);

        Alumno alu1 = new Alumno("pepe","gonzalez","+34-1111","11111D","malaga",18);

        alu1.getAsignaturas_inscritas().add(asig1);
        alu1.getContactos_disponibles().add(profe1);
        profe1.getAlumnos_suscritos().add(alu1);
        asig1.getAlumnos_inscritos().add(alu1);

        int[] fecha1 = {1,2};
        int[] fecha2 = {1,3};
        String titulo = "practica_1";
        String descripcion1 = "actividad base de datios";

        profe1.getAsignatura_impartida().getActividades().add(new Actividades(fecha2, fecha1, descripcion1, titulo));

        for (Asignatura asignatura : alu1.getAsignaturas_inscritas()) //ENTREGAR LAS ACTIVIDADES
            for (Actividades actividades : asignatura.getActividades())
                actividades.setEntrega(true);

        for (Actividades actividades : profe1.getAsignatura_impartida().getActividades())
            actividades.setNota(8);

        int resultado = alu1.consultarNotaMediaGeneral();
        assertEquals(8,resultado);
    }

    @Test
    void realizarTarea() {
        System.out.println("realizar tarea alumno");

        ArrayList<String> dias = new ArrayList<>();
        dias.add("Lunes");
        dias.add("Miercoles");
        dias.add("Viernes");

        Asignatura asig1 = new Asignatura(100,20,1,"BaseDatos",dias);

        Contacto profe1 = new Contacto("profe1@profe1.com","+34-2222","pedro",asig1);

        Alumno alu1 = new Alumno("pepe","gonzalez","+34-1111","11111D","malaga",18);

        alu1.getAsignaturas_inscritas().add(asig1);
        alu1.getContactos_disponibles().add(profe1);
        profe1.getAlumnos_suscritos().add(alu1);
        asig1.getAlumnos_inscritos().add(alu1);

        int[] fecha1 = {1,2};
        int[] fecha2 = {1,3};
        String titulo = "practica_1";
        String descripcion1 = "actividad base de datios";

        profe1.getAsignatura_impartida().getActividades().add(new Actividades(fecha2, fecha1, descripcion1, titulo));

        for (Asignatura asignatura : alu1.getAsignaturas_inscritas()) //REALIZAR TAREA
            for (Actividades actividades : asignatura.getActividades())
                actividades.setEntrega(true);


        for (Asignatura asignatura : alu1.getAsignaturas_inscritas())
            for (Actividades actividades : asignatura.getActividades())
                assertEquals(true,actividades.isEntrega());
    }
}