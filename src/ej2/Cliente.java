package ej2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        String id="";
        String host="localhost";
        int puerto=6000;
        DataOutputStream dataOutputStream;
        ObjectInputStream objectInputStream;
        Coche coche;
        try {

            Socket cliente=new Socket(host,puerto);
            dataOutputStream=new DataOutputStream(cliente.getOutputStream());
            objectInputStream=new ObjectInputStream(cliente.getInputStream());

            while(!id.equals("*")){
                System.out.println("ID del vehiculo a consultar");
                id= entrada.nextLine();

                dataOutputStream.writeUTF(id);
                if(!id.equals("*")){


                    coche=(Coche) objectInputStream.readObject();
                    System.out.println(coche);



                }else{
                    break;
                }
            }
            objectInputStream.close();
            dataOutputStream.close();
            cliente.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


}
