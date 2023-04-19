package controller;

import Veterinaria.Veterinaria;
import View.FormularioReview;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Servicio;
import model.Size;

/**
 *
 * @author Daniel Barrientos - 1152143
 */
public class FormularioController implements ActionListener {

    private FormularioReview formulario;
    private Veterinaria veterinaria;
    private Servicio servicio;

    public FormularioController(FormularioReview formulario, Veterinaria veterinaria) {
        this.formulario = formulario;
        this.veterinaria = veterinaria;
        ActionListener(this);
    }

    private void ActionListener(ActionListener controller) {
        formulario.btnCalcular.addActionListener(controller);
        formulario.btnGuardar.addActionListener(controller);
        formulario.btnMostrar.addActionListener(controller);

    }

    public void limpiarCampos() {
        formulario.txtNombre.setText("");
        formulario.txtRaza.setText("");
        formulario.txtTamanio.setText("");
        formulario.chkBanioCompleto.setState(false);
        formulario.chkCortePelo.setState(false);
        formulario.chkCorteUnias.setState(false);
        formulario.chkVacunas.setState(false);
        formulario.areaResultado.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getActionCommand().contentEquals("Guardar")) {

            String codigo = formulario.txtCodigo.getText();
            String nombre = formulario.txtNombre.getText();
            String raza = formulario.txtRaza.getText();
            Size size;
            ArrayList<Servicio> serviciosLista = new ArrayList<>();

            if (formulario.txtTamanio.getText().equalsIgnoreCase("Pequeño")) {
                size = Size.PEQUE;
            } else if (formulario.txtTamanio.getText().equalsIgnoreCase("Mediano")) {
                size = Size.MEDIANO;
            } else {
                size = Size.GRANDE;
            }

            if (formulario.chkBanioCompleto.getState()) {
                servicio = new Servicio(1, "Banio completo");
                serviciosLista.add(servicio);
            }
            if (formulario.chkVacunas.getState()) {
                servicio = new Servicio(2, "Aplicacion vacunas");
                serviciosLista.add(servicio);
            }
            if (formulario.chkCortePelo.getState()) {
                servicio = new Servicio(3, "Corte pelo");
                serviciosLista.add(servicio);
            }
            if (formulario.chkCorteUnias.getState()) {
                servicio = new Servicio(4, "Corte unias");
                serviciosLista.add(servicio);
            }

            veterinaria.agregarMascota(nombre, codigo, raza, size, serviciosLista);

            JOptionPane.showMessageDialog(formulario, "Mascota agregada correctamente");

            limpiarCampos();

        }

        if (event.getActionCommand().contentEquals("Calcular Servicio")) {

            String codigo = formulario.txtCodigo.getText();
            int valorServicio = veterinaria.calcularServicio(codigo);
            formulario.areaResultado.setText(veterinaria.buscarMascota(codigo).toString() + "\nEl costo del servicio es: " + valorServicio);

        }

        if (event.getActionCommand().contentEquals("Mostrar Datos")) {
            String codigo = formulario.txtCodigo.getText();

            formulario.areaResultado.setText(veterinaria.buscarMascota(codigo).toString());

        }

    }

}
