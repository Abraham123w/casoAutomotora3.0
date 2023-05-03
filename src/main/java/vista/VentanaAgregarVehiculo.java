package vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Model.Automotora;
import Model.Vehiculo;
import Validadadores.ValidadAno;
import controller.AutomotoraController;

public class VentanaAgregarVehiculo extends JFrame implements ActionListener {

    private JTextField nombreTextField, anoTextField, precioTextField, kilometrosTextField, modeloTextField;
    private JComboBox<String> colorComboBox, marcaComboBox;
    private JButton agregarButton, regresarButton;
    private Automotora automotora;

    public VentanaAgregarVehiculo(Automotora automotora) {
        // Configuración de la ventana
        this.automotora=automotora;
        setTitle("Agregar Vehículo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(null);

        // Creación de los componentes de la ventana
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(20, 20, 80, 20);
        add(nombreLabel);
        nombreTextField = new JTextField();
        nombreTextField.setBounds(120, 20, 200, 20);
        add(nombreTextField);

        JLabel anoLabel = new JLabel("Año:");
        anoLabel.setBounds(20, 50, 80, 20);
        add(anoLabel);
        anoTextField = new JTextField("yyyy");
        anoTextField.setBounds(120, 50, 80, 20);
        add(anoTextField);

        JLabel precioLabel = new JLabel("Precio (CLP):");
        precioLabel.setBounds(20, 80, 80, 20);
        add(precioLabel);
        precioTextField = new JTextField("$ 0");
        precioTextField.setBounds(120, 80, 100, 20);
        add(precioTextField);

        JLabel kilometrosLabel = new JLabel("Kilómetros:");
        kilometrosLabel.setBounds(20, 110, 80, 20);
        add(kilometrosLabel);
        kilometrosTextField = new JTextField("0 km");
        kilometrosTextField.setBounds(120, 110, 100, 20);
        add(kilometrosTextField);

        JLabel colorLabel = new JLabel("Color:");
        colorLabel.setBounds(20, 140, 80, 20);
        add(colorLabel);
        String[] colores = {"Rojo", "Azul", "Verde", "Negro", "Blanco"};
        colorComboBox = new JComboBox<>(colores);
        colorComboBox.setBounds(120, 140, 100, 20);
        add(colorComboBox);

        JLabel marcaLabel = new JLabel("Marca:");
        marcaLabel.setBounds(20, 170, 80, 20);
        add(marcaLabel);
        String[] marcas = {"Toyota", "Mazda", "Nissan", "Kia", "Hyundai"};
        marcaComboBox = new JComboBox<>(marcas);
        marcaComboBox.setBounds(120, 170, 100, 20);
        add(marcaComboBox);

        JLabel modeloLabel = new JLabel("Modelo:");
        modeloLabel.setBounds(20, 200, 80, 20);
        add(modeloLabel);
        modeloTextField = new JTextField();
        modeloTextField.setBounds(120, 200, 200, 20);
        add(modeloTextField);

        agregarButton = new JButton("Agregar");
        agregarButton.setBounds(20, 250, 100, 30);
        agregarButton.addActionListener(this);
        add(agregarButton);

        regresarButton = new JButton("Regresar");
        regresarButton.setBounds(220, 250, 100, 30);
        regresarButton.addActionListener(this);
        add(regresarButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregarButton) {
            String nombre = nombreTextField.getText();

            String ano = anoTextField.getText();
           // int anoInt=Integer.parseInt(ano);

            String precio = precioTextField.getText();
          //  double precioDouble=Double.parseDouble(precio);

            String kilometros = kilometrosTextField.getText();
           // int KilometrosRecorridosInt=Integer.parseInt(kilometros);

            String color = (String) colorComboBox.getSelectedItem();
            String marca = (String) marcaComboBox.getSelectedItem();
            String modelo = modeloTextField.getText();

            // Validación de los datos ingresados
            boolean datosValidos = true;
            // Validar el nombre
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un nombre para el vehículo", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
            // Validar el año
            try {
                int anoInt = Integer.parseInt(ano);
                datosValidos = ValidadAno.validarAno(anoInt);
                if (!datosValidos) {
                    JOptionPane.showMessageDialog(this, "El año debe estar entre 1900 y 2100", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un año válido (4 dígitos)", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
            // Validar el precio
            try {
                String precioSinSigno = precio.substring(1); // Quita el signo de pesos
                int precioInt = Integer.parseInt(precioSinSigno.replaceAll("\\s","")); // Quita los espacios en blanco
                if (precioInt < 0) {
                    JOptionPane.showMessageDialog(this, "El precio no puede ser negativo", "Error", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un precio válido (número entero y sin signo de pesos)", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
            // Validar los kilómetros
            try {
                String kilometrosSinTexto = kilometros.substring(0, kilometros.length()-3); // Quita el "km" al final
                int kilometrosInt = Integer.parseInt(kilometrosSinTexto.replaceAll("\\s","")); // Quita los espacios en blanco
                if (kilometrosInt < 0) {
                    JOptionPane.showMessageDialog(this, "Los kilómetros no pueden ser negativos", "Error", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Debe ingresar una cantidad de kilómetros válida (número entero y con 'km' al final)", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }

            // Si los datos ingresados son válidos, agregar el vehículo a la base de datos
            if (datosValidos) {
                // Agregar código para agregar el vehículo a la base de datos
               // Vehiculo vehiculo = new Vehiculo(modelo, Integer.parseInt(ano), Double.parseDouble(precio.substring(1)), Integer.parseInt(kilometros.substring(0, kilometros.length()-3)), color, marca);
                automotora.añadirVehiculo(modelo, Integer.parseInt(ano), Double.parseDouble(precio.substring(1)), Integer.parseInt(kilometros.substring(0, kilometros.length()-3)), color, marca);
                JOptionPane.showMessageDialog(this, "Vehículo agregado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == regresarButton) {
            // Agregar código para cerrar la ventana y volver a la ventana anterior
            VentanaBienvenida ventanaMenuBienvenida = new VentanaBienvenida(automotora);
            this.dispose();
        }
    }
   /* public static void main(String[] args) {
        new VentanaAgregarVehiculo(new Automotora()).setVisible(true);
    }*/

}