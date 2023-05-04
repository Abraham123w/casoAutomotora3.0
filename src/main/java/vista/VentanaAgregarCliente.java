package vista;

import Model.Automotora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Validadadores.CamposCompletos.camposCompletos;
import static Validadadores.FormatoCorreoValido.formatoCorreoValido;
import static Validadadores.FormatoRutValido.formatoRutValido;
import static Validadadores.FormatoTelefonoValido.formatoTelefonoValido;

public class VentanaAgregarCliente extends JFrame implements ActionListener {

    private JTextField txtNombre;
    private JTextField txtRut;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JButton btnAgregar;
    private JButton btnCancelar;
    private Automotora automotora;

    public VentanaAgregarCliente(Automotora automotora) {
        super("Agregar Cliente");
        this.automotora = automotora;
        crearCamposDeTexto();
        crearBotones();
        agregarComponentes();
        configurarVentana();
        agregarListeners();
    }

    private void crearCamposDeTexto() {
        txtNombre = new JTextField();
        txtRut = new JTextField();
        txtDireccion = new JTextField();
        txtTelefono = new JTextField();
        txtCorreo = new JTextField();
    }

    private void crearBotones() {
        btnAgregar = new JButton("Agregar");
        btnCancelar = new JButton("Cancelar");
    }

    private void agregarComponentes() {
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
    }

    private void configurarVentana() {
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void agregarListeners() {
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

    // Este método se utiliza para agregar un nuevo cliente a la automotora.
    private void agregarCliente() {
        // Se obtienen los valores ingresados en los campos de texto correspondientes.
        String nombre = txtNombre.getText();
        String rut = txtRut.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String correo = txtCorreo.getText();

        // Se verifica que todos los campos obligatorios estén completos utilizando el método "camposCompletos()".
        // Si algún campo está vacío, se muestra un mensaje de error y se sale del método.

        if (!camposCompletos(txtNombre.getText(), txtRut.getText(),txtDireccion.getText(),txtTelefono.getText(),txtCorreo.getText())) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos");
            return;
        }

        // Se verifica que el campo de texto "txtRut" tenga un formato de RUT válido utilizando el método "formatoRutValido()".
        // Si el formato no es válido, se muestra un mensaje de error y se sale del método.
        if (!formatoRutValido(txtRut.getText())) {
            JOptionPane.showMessageDialog(this, "El RUT debe tener el formato xxxxxxxx-x");
            return;
        }

        // Se verifica que el campo de texto "txtTelefono" tenga un formato de número de teléfono móvil chileno válido utilizando el método "formatoTelefonoValido()".
        // Si el formato no es válido, se muestra un mensaje de error y se sale del método.
        if (!formatoTelefonoValido(txtTelefono.getText())) {
            JOptionPane.showMessageDialog(this, "El teléfono debe tener el formato +56 9 xxxxxxxx");
            return;
        }

        // Se verifica que el campo de texto "txtCorreo" tenga un formato de dirección de correo electrónico válido utilizando el método "formatoCorreoValido()".
        // Si el formato no es válido, se muestra un mensaje de error y se sale del método.
        if (!formatoCorreoValido(txtCorreo.getText())) {
            JOptionPane.showMessageDialog(this, "El correo electrónico debe tener el formato usuario@dominio.com");
            return;
        }

        // Se añade el cliente a la automotora utilizando el método "añadirCliente()" y se muestra un mensaje de éxito.
        automotora.añadirCliente(nombre, rut, direccion, telefono, correo);
        JOptionPane.showMessageDialog(this, "Cliente agregado correctamente");

        // Se crea una nueva ventana de bienvenida y se cierra la ventana actual.
        VentanaBienvenida ventanaMenuBienvenida = new VentanaBienvenida(automotora);
        dispose();
    }

    // Este método se utiliza para cerrar la ventana.
    private void cancelar() {
        dispose();

    }
}