package Validadadores;

public class FormatoRutValido {
    public static boolean formatoRutValido(String rut) {
        // Se utiliza la función "matches()" para comparar la entrada con una expresión regular que valida el formato del RUT chileno.
        // La expresión regular consta de siete u ocho dígitos seguidos de un guión y un dígito o la letra "k" en mayúsculas o minúsculas.
        return rut.matches("\\d{7,8}-[\\dkK]");
    }

}
