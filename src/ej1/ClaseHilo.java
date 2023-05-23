package ej1;



import ej1.modelo.Profesor;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClaseHilo extends Thread{
    private Socket cliente;
    private DataInputStream dataInputStream;
    private ObjectOutputStream objectOutputStream;
    private Profesor[] profesores;

    public ClaseHilo(Socket cliente, Profesor[] profesores) {
        this.cliente = cliente;
        try {
            dataInputStream=new DataInputStream(cliente.getInputStream());
            objectOutputStream=new ObjectOutputStream(cliente.getOutputStream());
            this.profesores=profesores;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void run() {
        Profesor profesor = null;
        String id="";
        int idInt;
        boolean exito=false;

        while(!id.equals("*")){
            exito=false;
            try {
                id= dataInputStream.readUTF();
                if(!id.equals("*")){
                    idInt=Integer.parseInt(id);
                    for (Profesor p:profesores) {
                        if(p.getIdProfesor()==idInt){
                            profesor=p;
                            exito=true;
                            break;
                        }
                    }
                    if(exito==false){
                        profesor=new Profesor();
                    }
                    objectOutputStream.writeObject(profesor);


                }else{

                    System.out.println("El cliente"+cliente.toString()+" ha solicitado salir");
                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            dataInputStream.close();
            objectOutputStream.close();
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
