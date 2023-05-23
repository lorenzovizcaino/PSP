package ej1;



import ej1.modelo.Asignatura;
import ej1.modelo.Especialidad;
import ej1.modelo.Profesor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static Profesor[] profesores;
    public static Asignatura[] asignaturas1;
    public static Asignatura[] asignaturas2;
    public static Asignatura[] asignaturas3;
    public static Asignatura[] asignaturas4;
    public static void main(String[] args) {
        rellenarDatos();


        try {
            ServerSocket servidor=new ServerSocket(6001);
            while(true){

                Socket cliente=servidor.accept();
                System.out.println("Se ha conectado el cliente -->"+cliente.toString());
                ClaseHilo hilo1=new ClaseHilo(cliente,profesores);
                hilo1.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void rellenarDatos() {
        profesores = new Profesor[5];
        asignaturas1 = new Asignatura[3];
        asignaturas2 = new Asignatura[3];
        asignaturas3 = new Asignatura[3];
        asignaturas4 = new Asignatura[3];
        Asignatura lm = new Asignatura(1, "Linguaxe de marcas");
        Asignatura prog = new Asignatura(2, "Programacion");
        Asignatura cs = new Asignatura(3, "Contornos de Desarrollo");
        Asignatura si = new Asignatura(4, "Sistemas informaticos");
        Asignatura bd = new Asignatura(5, "Bases de datos");
        Asignatura psp = new Asignatura(6, "Programacion de Servicios y Procesos");
        Asignatura ad = new Asignatura(7, "Acceso a datos");
        Asignatura di = new Asignatura(8, "Diseño de interfaces");
        Asignatura pmdm = new Asignatura(9, "Programacion de moviles");
        Asignatura sxe = new Asignatura(10, "Sistemas de xestion");
        Asignatura fol = new Asignatura(11, "FOL");
        Asignatura eyp = new Asignatura(12, "Empresa e iniciativa emprendedora");
        Especialidad esp_informatica = new Especialidad(1, "Informatica");
        asignaturas1[0] = lm;
        asignaturas1[1] = prog;
        asignaturas1[2] = cs;
        asignaturas2[0] = si;
        asignaturas2[1] = bd;
        asignaturas2[2] = psp;
        asignaturas3[0] = ad;
        asignaturas3[1] = di;
        asignaturas3[2] = pmdm;
        asignaturas4[0] = sxe;
        asignaturas4[1] = fol;
        asignaturas4[2] = eyp;

        profesores[0] = new Profesor(1, "Juan Luis Ruiperez", asignaturas1, esp_informatica);
        profesores[1] = new Profesor(2, "Ana Dominguez Lorenzo", asignaturas1, esp_informatica);
        profesores[2] = new Profesor(3, "Santiago Couto Martinez", asignaturas1, esp_informatica);
        profesores[3] = new Profesor(4, "Emilio Claro Vazquez", asignaturas1, esp_informatica);
        profesores[4] = new Profesor(5, "Nuria Alvarez Dominguez", asignaturas1, esp_informatica);
    }
}
