package Validadadores;

public class CamposCompletos {

    // Este método devuelve un valor booleano que indica si se han completado todos los campos obligatorios.
    public static boolean camposCompletos(String nombre, String rut, String direccion, String telefono, String correo) {
        return !nombre.isEmpty() && !rut.isEmpty() && !direccion.isEmpty() && !telefono.isEmpty() && !correo.isEmpty();
    }


}
