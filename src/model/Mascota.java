package model;

import java.util.ArrayList;

/**
 *
 * @author Daniel Barrientos - 1152143
 */
public class Mascota {

    private String codigo;
    private String nombre;
    private String raza;
    private Size size;
    private ArrayList<Servicio> servicio;

    public Mascota() {
    }

    public Mascota(String codigo, String nombre, String raza, Size size, ArrayList<Servicio> servicio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.raza = raza;
        this.size = size;
        this.servicio = servicio;
    }

    @Override
    public String toString() {

        return "Mascota:  " + "\nNombre: " + getNombre() + ". Raza: " + getRaza() + ". Tamaño: " + getSize();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public ArrayList<Servicio> getServicio() {
        return servicio;
    }

    public void setServicio(ArrayList<Servicio> servicio) {
        this.servicio = servicio;
    }

}
