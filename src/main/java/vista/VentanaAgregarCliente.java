package vista;

import Model.Automotora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAgregarCliente extends JFrame implements ActionListener {

    private JTextField txtNombre;
    private JTextField txtRut;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JButton btnAgregar;
    private JButton btnCancelar;
    private Automotora automotora;
   /* public VentanaAgregarCliente(Automotora automotora){
        super("Agregar Cliente");
        this.automotora= automotora;

    }*/

    public VentanaAgregarCliente(Automotora automotora) {
        super("Agregar Cliente");
        this.automotora= automotora;



        // Crear campos de texto
        txtNombre = new JTextField();
        txtRut = new JTextField();
        txtDireccion = new JTextField();
        txtTelefono = new JTextField();
        txtCorreo = new JTextField();

        // Crear botones
        btnAgregar = new JButton("Agregar");
        btnCancelar = new JButton("Cancelar");

        // Agregar los componentes a la ventana
        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));
        panel.add(new JLabel("Nombre del cliente:"));
        panel.add(txtNombre);
        panel.add(new JLabel("RUT del cliente (formato xxxxxxxx-x):"));
        panel.add(txtRut);
        panel.add(new JLabel("Dirección del cliente:"));
        panel.add(txtDireccion);
        panel.add(new JLabel("Teléfono del cliente (formato +56 9 xxxxxxxx):"));
        panel.add(txtTelefono);
        panel.add(new JLabel("Correo electrónico del cliente:"));
        panel.add(txtCorreo);
        panel.add(btnAgregar);
        panel.add(btnCancelar);
        add(panel);

        // Configurar la ventana
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        // Configurar los botones
        btnAgregar.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
            agregarCliente();
        } else if (e.getSource() == btnCancelar) {
            cancelar();
        }
    }

    private void agregarCliente() {
        String nombre = txtNombre.getText();
        String rut = txtRut.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String correo = txtCorreo.getText();

        // Validar que los campos estén completos
        if (nombre.isEmpty() || rut.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos");
            return;
        }

        // Validar que el RUT tenga el formato correcto
        if (!rut.matches("\\d{7,8}-[\\dkK]")) {
            JOptionPane.showMessageDialog(this, "El RUT debe tener el formato xxxxxxxx-x");
            return;
        }

        // Validar que el teléfono tenga el formato correcto
        if (!telefono.matches("\\+56 9 \\d{8}")) {
            JOptionPane.showMessageDialog(this, "El teléfono debe tener el formato +56 9 xxxxxxxx");
            return;
        }

        // Validar que el correo tenga el formato correcto
        if (!correo.matches("\\w+@\\w+\\.\\w+")) {
            JOptionPane.showMessageDialog(this, "El correo electrónico debe tener el formato usuario@dominio.com");
            return;
        }

        // Agregar el cliente a la base de datos
       automotora.añadirCliente( nombre, rut, direccion, telefono, correo);
        //String nombre, String rut, String direccion, String numeroTel, String correo
        // Aquí se podría llamar a un método de una clase DAO para agregar el cliente a la base de datos

        JOptionPane.showMessageDialog(this, "Cliente agregado correctamente");
        // Si es así, crea una nueva instancia de la clase VentanaMenuBienvenida pasándole como argumento un objeto "automotora"
        VentanaBienvenida ventanaMenuBienvenida = new VentanaBienvenida(automotora);
        dispose();
    }

    private void cancelar() {
        dispose();
    }

    /*public static void main(String[] args) {
        new VentanaAgregarCliente(new Automotora());
    }*/

}