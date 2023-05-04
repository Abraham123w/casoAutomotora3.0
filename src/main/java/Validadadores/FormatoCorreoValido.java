package Validadadores;

public class FormatoCorreoValido {
    public static boolean formatoCorreoValido(String correo) {
        return correo.matches("\\w+@\\w+\\.\\w+");
    }
}
