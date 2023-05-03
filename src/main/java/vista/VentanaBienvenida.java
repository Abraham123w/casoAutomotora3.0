package vista;

import Model.Automotora;
import controller.AutomotoraController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBienvenida extends JFrame implements ActionListener {

    private JButton btnAgregarCliente;
    private JButton btnAgregarVehiculo;
    private JButton btnBuscarVehiculo;
    private JButton btnSalir;
    private Automotora automotora;

    public VentanaBienvenida(Automotora automotora) {
        super("Bienvenido a la aplicación de gestión de clientes y vehículos");
      this.automotora=automotora;
        // Crear botones
        btnAgregarCliente = new JButton("Agregar Cliente");
        btnAgregarVehiculo = new JButton("Agregar Vehículo");
        btnBuscarVehiculo = new JButton("Buscar Vehículo");
        btnSalir = new JButton("Salir");

        // Agregar los botones a la ventana
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(btnAgregarCliente);
        panel.add(btnAgregarVehiculo);
        panel.add(btnBuscarVehiculo);
        panel.add(btnSalir);
        add(panel);

        // Configurar la ventana
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Configurar los botones
        btnAgregarCliente.addActionListener(this);
        btnAgregarVehiculo.addActionListener(this);
        btnBuscarVehiculo.addActionListener(this);
        btnSalir.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregarCliente) {
            VentanaAgregarCliente ventanaAgregarCliente= new VentanaAgregarCliente(automotora);
            this.dispose();
        } else if (e.getSource() == btnAgregarVehiculo) {
            VentanaAgregarVehiculo ventanaAgregarVehiculo= new VentanaAgregarVehiculo(automotora);
            ventanaAgregarVehiculo.setVisible(true);
            this.dispose();
        } else if (e.getSource() == btnBuscarVehiculo) {
            VentanaBuscarVehiculo ventanaBuscarVehiculo= new VentanaBuscarVehiculo(automotora);
            this.dispose();
        } else if (e.getSource() == btnSalir) {
            AutomotoraController.almacenarDatos(automotora);
            this.dispose();
            salir();

        }
    }



    private void salir() {
        System.exit(0);
    }


}
