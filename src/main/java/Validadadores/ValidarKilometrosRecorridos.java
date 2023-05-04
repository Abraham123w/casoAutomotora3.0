package Validadadores;

public class ValidarKilometrosRecorridos {
    public static int validarKilometros(String kilometros) {
        int kilometrosInt = 0;
        try {
            String kilometrosSinTexto = kilometros.substring(0, kilometros.length() - 2); // Quita el "km" al final
            kilometrosInt = Integer.parseInt(kilometrosSinTexto.replaceAll("\\s", "")); // Quita los espacios en blanco
            if (kilometrosInt < 0) {
                return -1;
            }
        } catch (NumberFormatException ex) {
            return -1;
        }
        return kilometrosInt;
    }
}
