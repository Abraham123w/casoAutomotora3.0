package Validadadores;

public class FormatoTelefonoValido {
    public static boolean formatoTelefonoValido(String telefono) {
        // Se utiliza la función "matches()" para comparar la entrada con una expresión regular que valida el formato de un número de teléfono móvil chileno.
        // La expresión regular consta de "+56 9", seguido de ocho dígitos.
        return telefono.matches("\\+56 9 \\d{8}");
    }

}
