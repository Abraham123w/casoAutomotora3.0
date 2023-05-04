package Validadadores;

public class ValidarPrecio {
    public static int validarPrecio(String precio) {
        int precioInt = 0;
        try {
            String precioSinSigno = precio.substring(1); // Quita el signo de pesos
            precioInt = Integer.parseInt(precioSinSigno.replaceAll("\\s", "")); // Quita los espacios en blanco
            if (precioInt < 0) {
                return -1;
            }
        } catch (NumberFormatException ex) {
            return -1;
        }
        return precioInt;
    }
}
