package com.Alura.conversormonedas.Model;

import javax.swing.JOptionPane;

/**
 * @version august 21, 2022
 * @author Cristofer Guanipa Rivero
 */
public abstract class Conversor {

    /**
    * Este metodo se encarga de convertir el valor ingresado por el usuario, al valor de la conversion que el usuario escogio 
    *
    * @param tipoConversion es el valor que decide que conversion se va a realizar.
    * @param valor es el valor ingresado por el usuario.
    * @return La conversion del valor ingresado por el usuario, al valor de la conversion.
    */
    public abstract String convertir(int tipoConversion, double valor);

    public abstract String[] getOpciones();

    /**
    * Este metodo se encarga de solicitarle al usuario el valor que debe ingresar 
    *
    * @return El valor que el usuario desea convertir.
    */
    public double solicitarValor() {
        return solicitarValor(null);
    }

    /**
    * Este metodo se encarga de solicitarle al usuario el valor que debe ingresar 
    * 
    * @param mensaje es el mensaje que le muestra al usuario especificando que valor debe ingresar
    * @return El valor que el usuario desea convertir.
    */
    protected double solicitarValor(String mensaje) {
        try {
            double valorIngresado = Double.parseDouble(JOptionPane.showInputDialog(null,
                    mensaje));
            if (valorIngresado <= 0) {
                throw new NumberFormatException();
            }
            return valorIngresado;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor no v\u00e1lido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return -1;
    }
}
