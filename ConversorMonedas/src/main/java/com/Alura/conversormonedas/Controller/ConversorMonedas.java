package com.Alura.conversormonedas.Controller;

import com.Alura.conversormonedas.Model.Conversor;

/**
 * @version august 21, 2022
 * @author Cristofer Guanipa Rivero
 */
public class ConversorMonedas extends Conversor {

    private final byte COLONES_A_DOLAR = 0;
    private final byte COLONES_A_EURO = 1;
    private final byte COLONES_A_LIBRAS = 2;
    private final byte COLONES_A_YEN = 3;
    private final byte COLONES_A_WON_COREANO = 4;
    private final byte DOLAR_A_COLONES = 5;
    private final byte EURO_A_COLONES = 6;
    private final byte LIBRAS_A_COLONES = 7;
    private final byte YEN_A_COLONES = 8;
    private final byte WON_COREANO_A_COLONES = 9;

    private String[] opciones = {"De colones a D\u00f3lar", "De colones a Euro", "De colones a Libras",
        "De colones a Yen", "De colones a Won Coreano", "De D\u00f3lar a colones",
        "De Euro a colones", "De Libras a colones", "De Yen a colones",
        "De Won Coreano a colones"};

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
        return super.solicitarValor("Ingrese la cantidad de dinero que desea convertir:");
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

        double dolar = 654; //equivalente de 1 dolar a colones
        double euro = 667.21; //equivalente de 1 euro a colones
        double libra = 775.80; //equivalente de 1 libra a colones
        double yen = 4.79; //equivalente de 1 yen a colones
        double wonCoreano = 0.49; //equivalente de 1 won coreano a colones

        double conversion;
        String mensaje = "Tienes $ ";
        switch (tipoConversion) {
            case COLONES_A_DOLAR:
                conversion = conversionColonesAValor(dolar, valor);
                mensaje += String.format("%.2f Dolares", conversion);

                break;

            case COLONES_A_EURO:
                conversion = conversionColonesAValor(euro, valor);
                mensaje += String.format("%.2f Euros", conversion);
                break;

            case COLONES_A_LIBRAS:
                conversion = conversionColonesAValor(libra, valor);
                mensaje += String.format("%.2f Libras", conversion);

                break;

            case COLONES_A_YEN:
                conversion = conversionColonesAValor(yen, valor);
                mensaje += String.format("%.2f Yenes", conversion);

                break;

            case COLONES_A_WON_COREANO:
                conversion = conversionColonesAValor(wonCoreano, valor);
                mensaje += String.format("%.2f Won Coreanos", conversion);

                break;

            case DOLAR_A_COLONES:
                mensaje += conversionValorAColones(dolar, valor);

                break;

            case EURO_A_COLONES:
                mensaje += conversionValorAColones(euro, valor);

                break;

            case LIBRAS_A_COLONES:
                mensaje += conversionValorAColones(libra, valor);

                break;

            case YEN_A_COLONES:
                mensaje += conversionValorAColones(yen, valor);

                break;

            case WON_COREANO_A_COLONES:
                mensaje += conversionValorAColones(wonCoreano, valor);

                break;
        }
        return mensaje;
    }

    private String conversionValorAColones(double moneda, double valor) {
        double conversion = moneda * valor;
        return String.format("%.2f Colones", conversion);

    }

    private double conversionColonesAValor(double moneda, double valor) {
        return valor / moneda;
    }

}
