package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Daniel
 */
public class TablaServicios {

    private HashMap<Integer, HashMap<String, Integer>> tabla = new HashMap<>();

    public TablaServicios() {

        /*SE CREA LA "LLAVE" PARA EL HASHMAP QUE SERIA EL SERVICIO
        la llave 1 es baño completo
        la llave 2 es aplicacion vacunas
        la llave 3 es corte pelo
        la llave 4 es corte uñas
         */
        tabla.put(1, new HashMap<>());
        tabla.put(2, new HashMap<>());
        tabla.put(3, new HashMap<>());
        tabla.put(4, new HashMap<>());

        //SE LE AGREGA EL TAMAÑO Y PRECIO DEPENDIEDO DEL SERVICIO Y TAMAÑO
        tabla.get(1).put("PEQUE", 15000);
        tabla.get(1).put("MEDIANO", 25000);
        tabla.get(1).put("GRANDE", 30000);

        tabla.get(2).put("PEQUE", 5000);
        tabla.get(2).put("MEDIANO", 5000);
        tabla.get(2).put("GRANDE", 5000);

        tabla.get(3).put("PEQUE", 5000);
        tabla.get(3).put("MEDIANO", 10000);
        tabla.get(3).put("GRANDE", 15000);

        tabla.get(4).put("PEQUE", 2000);
        tabla.get(4).put("MEDIANO", 4000);
        tabla.get(4).put("GRANDE", 6000);

    }

    public int obtenerPrecio(ArrayList<Servicio> servicio, Size size) {
        int tmp = 0;

        for (Servicio servicios : servicio) {

            Integer claveServicio = servicios.getCodigo();
            String claveSize = size.toString();

            // Verificar que el servicio y el tamaño existen en la tabla
            if (!tabla.get(claveServicio).containsKey(claveSize)) {
                throw new IllegalArgumentException("El tamaño no existe en la tabla.");
            }

            // Devolver el precio correspondiente
            tmp += tabla.get(claveServicio).get(claveSize);
        }

        return tmp;
    }

}
