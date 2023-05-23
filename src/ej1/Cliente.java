package ej1;



import ej1.modelo.Profesor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        String host="localhost";
        int puerto=6001;

        Scanner entrada=new Scanner(System.in);
        Profesor profesor;
        String id="";
        DataOutputStream dataOutputStream;
        ObjectInputStream objectInputStream;
        try {
            Socket cliente=new Socket(host,puerto);
            dataOutputStream=new DataOutputStream(cliente.getOutputStream());
            objectInputStream=new ObjectInputStream(cliente.getInputStream());
            while(!id.equals("*")){
                System.out.println("id del Profesor a consultar");
                id=entrada.nextLine();
                dataOutputStream.writeUTF(id);

                if(!id.equals("*")){
                    profesor= (Profesor) objectInputStream.readObject();
                    System.out.println(profesor);
                }else{
                    System.out.println("El cliente ha solicitado salir");
                }
            }
            dataOutputStream.close();
            objectInputStream.close();
            cliente.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
