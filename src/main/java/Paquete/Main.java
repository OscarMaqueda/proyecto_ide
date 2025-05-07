package Paquete;



/**
 * Main para probar el codigo y sus relaciones
 * @author Oscar Maqueda Baños
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        //CREAR LOS DIAS DE LAS ASIGNATURAS
        ArrayList<String> dias = new ArrayList<>();
        dias.add("Lunes");
        dias.add("Miercoles");
        dias.add("Viernes");

        //CREAR 2 ASIGNATURAS, 2 PROFESORES Y 2 ALUMNOS
        Asignatura asig1 = new Asignatura(100,20,1,"BaseDatos",dias);
        Asignatura asig2 = new Asignatura(100,20,1,"Programacion",dias);

        Contacto profe1 = new Contacto("profe1@profe1.com","+34-2222","pedro",asig1);
        Contacto profe2 = new Contacto("profe2@profe2.com","+34-3333","pedro",asig2);

        Alumno alu1 = new Alumno("pepe","gonzalez","+34-1111","11111D","malaga",18);
        Alumno alu2 = new Alumno("pedro","lopez","+34-4444","44444D","barcelona",20);

        //ASIGNACION DE CAMPOS
        alu1.getAsignaturas_inscritas().add(asig1);
        alu1.getContactos_disponibles().add(profe1);
        profe1.getAlumnos_suscritos().add(alu1);
        asig1.getAlumnos_inscritos().add(alu1);

        alu2.getAsignaturas_inscritas().add(asig2);
        alu2.getContactos_disponibles().add(profe2);
        profe2.getAlumnos_suscritos().add(alu2);
        asig2.getAlumnos_inscritos().add(alu2);

        //CREAR 1 ACTIVIDAD EN CADA ASIGNATURA
        int[] fecha1 = {1,2};
        int[] fecha2 = {1,3};
        String titulo = "practica_1";
        String descripcion1 = "actividad base de datios";
        String descripcion2 = "actividad base de datios";

        profe1.aniadirActividad(fecha2, fecha1,descripcion1,titulo);
        profe2.aniadirActividad(fecha2,fecha1,descripcion2,titulo);

        alu1.realizarTarea();
        profe1.ponerNota();

        System.out.println("Su nota media es: "+alu1.consultarNotaMediaGeneral());

    }
}