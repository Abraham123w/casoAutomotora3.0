package Validadadores;

import javax.swing.*;

public class ValidadAno {

    public static boolean validarAno(int ano) {
        boolean dato = true;
        try {
            if (ano < 1900 || ano > 2100) {
                dato = false;
            }
        } catch (NumberFormatException ex) {
            dato = false;
        }
        return dato;
    }

}
