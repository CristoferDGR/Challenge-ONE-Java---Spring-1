package com.Alura.conversormonedas.Controller;

import com.Alura.conversormonedas.Model.Conversor;
import javax.swing.JOptionPane;

/**
 * @version august 21, 2022
 * @author Cristofer Guanipa Rivero
 */
public class Menu {

    private final int CONVERSION_MONEDA = 0;
    private final int CONVERSION_TEMPERATURA = 1;

    /**
    * Este metodo se encarga de la logica del programa. 
    *
    */
    public void iniciarPrograma() {
        JOptionPane.showMessageDialog(null, "Bienvenido al programa de conversi\u00f3n de la moneda "
                + "Col\u00f3n costarricense y de conversi\u00f3n de temperatura");

        int seguirPrograma = 0;

        while (seguirPrograma == 0) {
            int tipoConversion = solicitarTipoConversion();
            Conversor conversor = null;
            switch (tipoConversion) {
                case CONVERSION_MONEDA:
                    conversor = new ConversorMonedas();
                    break;

                case CONVERSION_TEMPERATURA:
                    conversor = new ConversorTemperatura();
                    break;
            }
            if (conversor != null) {
                int opcionConversion = solicitarTipoConversion(conversor.getOpciones());
                if (opcionConversion >= 0) {
                    double valorConvertir = conversor.solicitarValor();
                    if (valorConvertir > 0) {
                        String conversion = conversor.convertir(opcionConversion, valorConvertir);

                        JOptionPane.showMessageDialog(null, conversion);
                    }
                }
            }

            seguirPrograma = continuarPrograma();

        }
        JOptionPane.showMessageDialog(null, "Programa Terminado");
    }

    /**
    * Este metodo se encarga de solicitarle al usuario que tipo de conversion desea.
    *
    * @return La opcion de conversion que el usuario escoge.
    */
    public int solicitarTipoConversion() {
        String[] opciones = {"Conversor de moneda", "Conversor de temperatura"};
        String opcionEscogida = (String) JOptionPane.showInputDialog(null, "Seleccione una opci\u00f3n de conversi\u00f3n", "Menu",
                -1, null, opciones, opciones[0]);

        return opcionEscogida(opciones, opcionEscogida);
    }

    /**
    * Este metodo se encarga de solicitarle al usuario que tipo de conversion desea. 
    *
    * @param opciones son las opciones de conversion que se encuentran disponibles para el usuario.
    * @return La opcion de conversion que el usuario escoge.
    */
    public static int solicitarTipoConversion(String[] opciones) {
        String opcionEscogida = (String) JOptionPane.showInputDialog(null, "Seleccione una opci\u00f3n de conversi\u00f3n", "Menu",
                -1, null, opciones, opciones[0]);

        return opcionEscogida(opciones, opcionEscogida);
    }

    /**
    * Este metodo se verificar que opcion escoge el usuario 
    *
    * @param opciones son las opciones de conversion que se encuentran disponibles para el usuario.
    * @param opcionEscogida es la opcion que el usuario escogió
    * @return El valor de la opcion que el usuario escogió.
    */
    public static int opcionEscogida(String[] opciones, String opcionEscogida) {
        if (opcionEscogida == null) {
            return -1;

        } else {
            int i = 0;
            do {
                if (opcionEscogida.equals(opciones[i])) {
                    return i;
                }
                i++;
            } while (i < opciones.length);
        }

        return -1;
    }

    public void mostrarConversionDinero(String valor) {
        JOptionPane.showMessageDialog(null, "Tienes $" + valor);
    }

    public void mostrarConversionTemperatura(String valor) {
        JOptionPane.showMessageDialog(null, "La temperatura es de " + valor);
    }

    public int continuarPrograma() {
        return JOptionPane.showConfirmDialog(null, "Desea continuar con el programa");
    }

}
