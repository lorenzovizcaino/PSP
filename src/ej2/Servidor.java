package ej2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
    public static ArrayList<Coche> coches=new ArrayList<>();
    public static void main(String[] args) {
        llenarArray();
        String id="";
        int idInt;
        DataInputStream dataInputStream;
        ObjectOutputStream objectOutputStream;
        Coche coche=null;
        boolean exito;

        try {
            ServerSocket servidor=new ServerSocket(6000);
            Socket cliente=servidor.accept();
            dataInputStream=new DataInputStream(cliente.getInputStream());
            objectOutputStream=new ObjectOutputStream(cliente.getOutputStream());
            while(!id.equals("*")){
                exito=false;
                id=dataInputStream.readUTF();
                System.out.println(id);
                if(!id.equals("*")){
                    idInt=Integer.parseInt(id);
                    for (Coche c:coches) {
                        if(c.getId()==idInt){
                            coche=c;
                            exito=true;
                            break;
                        }
                    }
                    if(!exito){
                        coche=new Coche();
                    }
                    objectOutputStream.writeObject(coche);
                }else{
                    break;
                }
            }
            objectOutputStream.close();
            dataInputStream.close();
            cliente.close();
            servidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static void llenarArray() {
        Coche c1= new Coche(1,"Mazda","3","2345RED",150,true);
        Coche c2= new Coche(2,"Peugeot","308","4587ERF",140,true);
        Coche c3= new Coche(3,"Seat","Altea","4524DCS",148,true);
        Coche c4= new Coche(4,"Renault","Clio","8965ASQ",100,false);
        Coche c5= new Coche(5,"Audi","A6","9514ERT",250,true);
        coches.add(c1);
        coches.add(c2);
        coches.add(c3);
        coches.add(c4);
        coches.add(c5);

    }
}
