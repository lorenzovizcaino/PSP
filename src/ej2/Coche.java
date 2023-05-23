package ej2;

import java.io.Serializable;

public class Coche implements Serializable {
    private int id;
    private String marca;
    private String modelo;
    private String matricula;
    private int caballos;
    private boolean climatizador;

    public Coche(int id,String marca, String modelo, String matricula, int caballos, boolean climatizador) {
        this.id=id;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.caballos = caballos;
        this.climatizador = climatizador;
    }

    public Coche() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCaballos() {
        return caballos;
    }

    public void setCaballos(int caballos) {
        this.caballos = caballos;
    }

    public boolean isClimatizador() {
        return climatizador;
    }

    public void setClimatizador(boolean climatizador) {
        this.climatizador = climatizador;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", caballos=" + caballos +
                ", climatizador=" + climatizador +
                '}';
    }
}
