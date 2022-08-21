package com.Alura.conversormonedas.Controller;

import com.Alura.conversormonedas.Model.Conversor;

/**
 * @version august 21, 2022
 * @author Cristofer Guanipa Rivero
 */
public class ConversorTemperatura extends Conversor {

    private final byte CELCIUS_A_FAHRENHEIT = 0;
    private final byte CELCIUS_A_KELVIN = 1;
    private final byte FAHRENHEIT_A_CELCIUS = 2;
    private final byte FAHRENHEIT_A_KELVIN = 3;
    private final byte KELVIN_A_CELCIUS = 4;
    private final byte KELVIN_A_FAHRENHEIT = 5;
    private String[] opciones = {"De Celcius a Fahrenheit", "De Celcius a Kelvin", "De Fahrenheit a Celcius",
        "De Fahrenheit a Kelvin", "De Kelvin a Celcius", "De Kelvinr a Fahrenheit"};

    @Override
    public String[] getOpciones() {
        return opciones;
    }

    /**
    * Este metodo se encarga de solicitarle al usuario el valor que debe ingresar 
    *
    * @return El valor que el usuario desea convertir.
    */
    @Override
    public double solicitarValor() {
        return super.solicitarValor("Ingrese el valor de la temperatura que desea convertir:");
    }

    /**
    * Este metodo se encarga de convertir el valor ingresado por el usuario, al valor de la conversion que el usuario escogio 
    *
    * @param tipoConversion es el valor que decide que conversion se va a realizar.
    * @param valor es el valor ingresado por el usuario.
    * @return La conversion del valor ingresado por el usuario, al valor de la conversion.
    */
    @Override
    public String convertir(int tipoConversion, double valor) {

        double conversion;
        String mensaje = "El valor de la temperatura es: ";
        switch (tipoConversion) {
            case CELCIUS_A_FAHRENHEIT:
                conversion = (valor * 9 / 5) + 32;
                mensaje += String.format("%.2f Fahrenheit", conversion);

                break;

            case CELCIUS_A_KELVIN:
                conversion = valor + 273.15;
                mensaje += String.format("%.2f Kelvin", conversion);
                break;

            case FAHRENHEIT_A_CELCIUS:
                conversion = (valor - 32) * 5 / 9;
                mensaje += String.format("%.2f Celcius", conversion);

                break;

            case FAHRENHEIT_A_KELVIN:
                conversion = (valor - 32) * 5 / 9 + 273.15;
                mensaje += String.format("%.2f Kelvin", conversion);

                break;

            case KELVIN_A_CELCIUS:
                conversion = valor - 273.15;
                mensaje += String.format("%.2f Celcius", conversion);

                break;

            case KELVIN_A_FAHRENHEIT:
                conversion = (valor - 273.15) * 9 / 5 + 32;
                mensaje += String.format("%.2f Fahrenheit", conversion);

                break;

        }
        return mensaje;
    }
}
