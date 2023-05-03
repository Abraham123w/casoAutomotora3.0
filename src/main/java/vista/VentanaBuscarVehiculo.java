package vista;
// Se importan las clases Automotora y Vehiculo desde el paquete Model, y las clases necesarias desde otros paquetes.
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
    private JComboBox<String> cmbMarca, cmbModelo;
    private JButton btnBuscar, btnRegresar;
    private Automotora automotora;

    // Se define el constructor de la clase.
    public VentanaBuscarVehiculo(Automotora automotora) {
        // Se asigna la instancia de Automotora recibida como parámetro al atributo de la clase.
        this.automotora = automotora;

        // Se crea una nueva ventana con el título "Buscar Vehículo" y se establece su tamaño y diseño de cuadrícula de 3x2.
        ventana = new JFrame("Buscar Vehículo");
        ventana.setSize(400, 150);
        ventana.setLayout(new GridLayout(3, 2));

        // Se crean las etiquetas, los cuadros de selección y los botones necesarios para la búsqueda de vehículos.
        JLabel lblMarca = new JLabel("Marca:");
        cmbMarca = new JComboBox<String>(automotora.obtenerMarcasDeVehiculos());
        JLabel lblModelo = new JLabel("Modelo:");
        cmbModelo = new JComboBox<String>();
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(this);
        btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(this);

        // Se agregan los componentes creados a la ventana.
        ventana.add(lblMarca);
        ventana.add(cmbMarca);
        ventana.add(lblModelo);
        ventana.add(cmbModelo);
        ventana.add(btnBuscar);
        ventana.add(btnRegresar);

        // Se agrega un listener al cuadro de selección de marca para actualizar el cuadro de selección de modelo cuando se seleccione una marca.
        cmbMarca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marcaSeleccionada = (String) cmbMarca.getSelectedItem();
                String[] modelos = automotora.obtenerModelosDeVehiculosPorMarca(marcaSeleccionada);
                cmbModelo.setModel(new DefaultComboBoxModel<String>(modelos));
            }
        });

        // Se hace visible la ventana.
        ventana.setVisible(true);
    }

    // Se define el método actionPerformed, que maneja los eventos de los botones.
    public void actionPerformed(ActionEvent evt) {
        // Si se hace clic en el botón "Buscar", se realiza una búsqueda de vehículos por modelo y se muestran los resultados en una nueva ventana de tabla.
        if (evt.getSource() == btnBuscar) {
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

            // Se crea una nueva ventana de tabla y se le pasan los datos de los vehículos y el nombre de las columnas.
            VentanaTabla ventanaTabla = new VentanaTabla(datosVehiculos, nombreColumnas);

            // Se limpia el formulario.
            cmbMarca.setSelectedIndex(0);
            cmbModelo.setModel(new DefaultComboBoxModel<String>());
        }
        // Si se hace clic en el botón "Regresar", se vuelve a la ventana anterior.
        else if (evt.getSource() == btnRegresar) {
            VentanaBienvenida ventanaMenuBienvenida = new VentanaBienvenida(automotora);
            ventana.dispose();
        }
    }
}