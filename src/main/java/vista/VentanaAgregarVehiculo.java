package vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Model.Automotora;
import Model.Vehiculo;
import Validadadores.ValidadAno;


import static Validadadores.ValidadAno.validarAno;
import static Validadadores.ValidarKilometrosRecorridos.validarKilometros;
import static Validadadores.ValidarPrecio.validarPrecio;


public class VentanaAgregarVehiculo extends JFrame implements ActionListener {

    private JTextField anoTextField, precioTextField, kilometrosTextField, modeloTextField;
    private JComboBox<String> colorComboBox, marcaComboBox;
    private JButton agregarButton, regresarButton;
    private Automotora automotora;

    public VentanaAgregarVehiculo(Automotora automotora) {
        // Configuración de la ventana
        this.automotora=automotora;
        setTitle("Agregar Vehículo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        // Creación de los componentes de la ventana
        JLabel anoLabel = new JLabel("Año:");
        anoLabel.setBounds(20, 20, 80, 20);
        add(anoLabel);
        anoTextField = new JTextField("yyyy");
        anoTextField.setBounds(120, 20, 80, 20);
        add(anoTextField);

        JLabel precioLabel = new JLabel("Precio (CLP):");
        precioLabel.setBounds(20, 50, 80, 20);
        add(precioLabel);
        precioTextField = new JTextField("$ 0");
        precioTextField.setBounds(120, 50, 100, 20);
        add(precioTextField);

        JLabel kilometrosLabel = new JLabel("Kilómetros:");
        kilometrosLabel.setBounds(20, 80, 80, 20);
        add(kilometrosLabel);
        kilometrosTextField = new JTextField("0 km");
        kilometrosTextField.setBounds(120, 80, 100, 20);
        add(kilometrosTextField);

        JLabel colorLabel = new JLabel("Color:");
        colorLabel.setBounds(20, 110, 80, 20);
        add(colorLabel);
        String[] colores = {"Rojo", "Azul", "Verde", "Negro", "Blanco"};
        colorComboBox = new JComboBox<>(colores);
        colorComboBox.setBounds(120, 110, 100, 20);
        add(colorComboBox);

        JLabel marcaLabel = new JLabel("Marca:");
        marcaLabel.setBounds(20, 140, 80, 20);
        add(marcaLabel);
        String[] marcas = {"Toyota", "Mazda", "Nissan", "Kia", "Hyundai"};
        marcaComboBox = new JComboBox<>(automotora.obtenerMarcasDeVehiculos());
        marcaComboBox.setBounds(120, 140, 100, 20);
        add(marcaComboBox);

        JLabel modeloLabel = new JLabel("Modelo:");
        modeloLabel.setBounds(20, 170, 80, 20);
        add(modeloLabel);
        modeloTextField = new JTextField();
        modeloTextField.setBounds(120, 170, 200, 20);
        add(modeloTextField);

        agregarButton = new JButton("Agregar");
        agregarButton.setBounds(20, 220, 100, 30);
        agregarButton.addActionListener(this);
        add(agregarButton);

        regresarButton = new JButton("Regresar");
        regresarButton.setBounds(220, 220, 100, 30);
        regresarButton.addActionListener(this);
        add(regresarButton);
    }

    private Vehiculo obtenerDatosIngresados() {
        String ano = anoTextField.getText();
        String precio = precioTextField.getText();
        String kilometros = kilometrosTextField.getText();
        String color = (String) colorComboBox.getSelectedItem();
        String marca = (String) marcaComboBox.getSelectedItem();
        String modelo = modeloTextField.getText();

        // Validación de los datos ingresados
        boolean datosValidos = true;

        // Validar el año
        int anoInt = validarAno(ano);
        if (anoInt == -1) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un año válido (4 dígitos entre 1900 y 2100)", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }

        // Validar el precio
        int precioInt = validarPrecio(precio);
        if (precioInt == -1) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un precio válido (número entero y sin signo de pesos)", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }

        // Validar los kilómetros
        int kilometrosInt = validarKilometros(kilometros);
        if (kilometrosInt == -1) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una cantidad de kilómetros válida (número entero y con 'km' al final)", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }

        // Si los datos ingresados son válidos, crear el vehículo
        if (datosValidos) {
            return new Vehiculo(modelo, anoInt, precioInt, kilometrosInt, color, marca);
        } else {
            return null;
        }
    }


    private void agregarVehiculo() {
        Vehiculo vehiculo = obtenerDatosIngresados();
        if (vehiculo != null) {
            automotora. agregarVehiculoRecibiendoObjetoTipoVehiculo(vehiculo);
            JOptionPane.showMessageDialog(this, "Vehículo agregado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void regresarAVentanaAnterior() {
        VentanaBienvenida ventanaMenuBienvenida = new VentanaBienvenida(automotora);
        this.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregarButton) {
            agregarVehiculo();
        } else if (e.getSource() == regresarButton) {
            regresarAVentanaAnterior();
        }
    }
}