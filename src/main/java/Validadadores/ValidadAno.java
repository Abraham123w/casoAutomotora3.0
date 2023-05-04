package Validadadores;

import javax.swing.*;

public class ValidadAno {

   /* public static boolean validarAno(int ano) {
        boolean dato = true;
        try {
            if (ano < 1900 || ano > 2100) {
                dato = false;
            }
        } catch (NumberFormatException ex) {
            dato = false;
        }
        return dato;
    }*/
    public static int validarAno(String ano) {
        int anoInt = 0;
        try {
            anoInt = Integer.parseInt(ano);
            if (anoInt < 1900 || anoInt > 2100) {
                return -1;
            }
        } catch (NumberFormatException ex) {
            return -1;
        }
        return anoInt;
    }
}
