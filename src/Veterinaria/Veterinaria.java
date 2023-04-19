package Veterinaria;

import View.FormularioReview;
import controller.FormularioController;
import java.util.ArrayList;
import model.Mascota;
import model.Servicio;
import model.Size;
import model.TablaServicios;

/**
 *
 * @author Daniel Barrientos - 1152143
 */
public class Veterinaria {

    private ArrayList<Mascota> listaMascotas;

    public Veterinaria() {
        this.listaMascotas = new ArrayList<>();

    }

    public void agregarMascota(String nombre, String codigo, String raza, Size size, ArrayList<Servicio> servicio) {
        Mascota mascota = new Mascota(codigo, nombre, raza, size, servicio);
        listaMascotas.add(mascota);
    }

    public Integer calcularServicio(String codigo) {
        //se busca la mascota por el codigo para saber a cual se le calcula el valor servicio y se guarda en una variable temporaral de tipo Mascota
        Mascota mascota = buscarMascota(codigo);

        //se instancia la clase TablaServicios para llamar el metodo obtenerPrecio de dicha clase
        TablaServicios tablaServicios = new TablaServicios();
        return tablaServicios.obtenerPrecio(mascota.getServicio(), mascota.getSize());
    }

    public Mascota buscarMascota(String codigo) {

        for (Mascota mascota : listaMascotas) {
            if (mascota.getCodigo().equals(codigo)) {
                return mascota;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        FormularioReview formulario = new FormularioReview();
        formulario.setTitle("Happy Pet");

        Veterinaria veterinaria = new Veterinaria();

        FormularioController formularioController = new FormularioController(formulario, veterinaria);

    }

}
