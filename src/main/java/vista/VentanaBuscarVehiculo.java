package vista;

import Model.Automotora;
import Model.Vehiculo;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class VentanaBuscarVehiculo implements ActionListener {

    // Se declaran los atributos de la clase.
    private JFrame ventana;
    private JLabel lblMarca, lblModelo;
    private JComboBox<String> cmbMarca, cmbModelo;
    private JButton btnBuscar, btnRegresar;
    private Automotora automotora;

    // Se define el constructor de la clase.
    public VentanaBuscarVehiculo(Automotora automotora) {
        this.automotora = automotora;
        crearVentana();
        crearComponentes();
        agregarComponentes();
        agregarListeners();
        mostrarVentana();
    }

    private void crearVentana() {
        ventana = new JFrame("Buscar Vehículo");
        ventana.setSize(400, 150);
        ventana.setLayout(new GridLayout(3, 2));
    }

    private void crearComponentes() {
        lblMarca = new JLabel("Marca:");
        cmbMarca = new JComboBox<String>(automotora.obtenerMarcasDeVehiculos());
        lblModelo = new JLabel("Modelo:");
        cmbModelo = new JComboBox<String>();
        btnBuscar = new JButton("Buscar");
        btnRegresar = new JButton("Regresar");
    }

    private void agregarComponentes() {
        ventana.add(lblMarca);
        ventana.add(cmbMarca);
        ventana.add(lblModelo);
        ventana.add(cmbModelo);
        ventana.add(btnBuscar);
        ventana.add(btnRegresar);
    }

    private void agregarListeners() {
        cmbMarca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCmbModelo();
            }
        });
        btnBuscar.addActionListener(this);
        btnRegresar.addActionListener(this);
    }

    private void mostrarVentana() {
        ventana.setVisible(true);
    }

    private void actualizarCmbModelo() {
        String marcaSeleccionada = (String) cmbMarca.getSelectedItem();
        String[] modelos = automotora.obtenerModelosDeVehiculosPorMarca(marcaSeleccionada);
        cmbModelo.setModel(new DefaultComboBoxModel<String>(modelos));
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnBuscar) {
            buscarVehiculos();
            limpiarFormulario();
        } else if (evt.getSource() == btnRegresar) {
            volverAVentanaAnterior();
        }
    }

    private void buscarVehiculos() {
        String marca = cmbMarca.getSelectedItem().toString();
        String modelo = cmbModelo.getSelectedItem().toString();

        List<Vehiculo> vehiculos = automotora.buscarVehiculosPorModelo(modelo);
        String[] nombreColumnas = {"Modelo", "Marca", "Año", "Color", "Precio", "Kilómetros Recorridos"};
        String[][] datosVehiculos = new String[vehiculos.size()][6];
        for (int i = 0; i < vehiculos.size(); i++) {
            datosVehiculos[i][0] = vehiculos.get(i).getModelo();
            datosVehiculos[i][1] = vehiculos.get(i).getMarca();
            datosVehiculos[i][2] = Integer.toString(vehiculos.get(i).getAno());
            datosVehiculos[i][3] = vehiculos.get(i).getColor();
            datosVehiculos[i][4] = Double.toString(vehiculos.get(i).getPrecio());
            datosVehiculos[i][5] = Double.toString(vehiculos.get(i).getKilometrosRecorridos());
        }
        VentanaTabla ventanaTabla = new VentanaTabla(datosVehiculos, nombreColumnas);
    }

    private void limpiarFormulario() {
        cmbMarca.setSelectedIndex(0);
        cmbModelo.setModel(new DefaultComboBoxModel<String>());
    }

    private void volverAVentanaAnterior() {
        VentanaBienvenida ventanaMenuBienvenida = new VentanaBienvenida(automotora);
        ventana.dispose();
    }
}