/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Alura.conversormonedas.Controller;

import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class ConversorMonedas {
    
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
    
    public int solicitarMonedaConversion(){
        String[] opciones = {"De colones a D\u00f3lar", "De colones a Euro", "De colones a Libras", 
                             "De colones a Yen", "De colones a Won Coreano", "De D\u00f3lar a colones",
                             "De Euro a colones", "De Libras a colones", "De Yen a colones", 
                             "De Won Coreano a colones"};
        String opcionEscogida = (String) JOptionPane.showInputDialog(null, "Seleccione una opci\u00f3n de conversi\u00f3n", "Menu", 
                -1, null, opciones, opciones[0]);
        
        return Menu.opcionEscogida(opciones, opcionEscogida);
    }
    
    public double solicitarMontoDinero(){            
        try{
            double valorIngresado = Double.parseDouble(JOptionPane.showInputDialog(null, 
                    "Ingrese la cantidad de dinero que desea convertir:"));
            if(valorIngresado <= 0) {
                throw new NumberFormatException();
            }
            return valorIngresado;
        }catch(NumberFormatException  e){
            JOptionPane.showMessageDialog(null, "Valor no v\u00e1lido", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor", "Error", JOptionPane.ERROR_MESSAGE);
    }
        
        return -1;
    }
    
    public String convertir(int tipoConversion, double valor) {
        
        double dolar = 654; //equivalente de 1 dolar a colones
        double euro  = 667.21; //equivalente de 1 euro a colones
        double libra = 775.80; //equivalente de 1 libra a colones
        double yen = 4.79; //equivalente de 1 yen a colones
        double wonCoreano = 0.49; //equivalente de 1 won coreano a colones
        
        double conversion = 0; 
        String mensaje = null;
        switch (tipoConversion) {
            case COLONES_A_DOLAR:
                conversion = conversionColonesAValor(dolar, valor);
               mensaje = String.format("%.2f Dolares", conversion);
                
                break;
                
            case COLONES_A_EURO:
                conversion = conversionColonesAValor(euro, valor);
                 mensaje = String.format("%.2f Euros", conversion);
//                mensaje = conversion + " Euros";
                break;
                
            case COLONES_A_LIBRAS:
                conversion = conversionColonesAValor(libra, valor);
                mensaje = String.format("%.2f Libras", conversion);
                
                break;
                
            case COLONES_A_YEN:
                conversion = conversionColonesAValor(yen, valor);
                mensaje = String.format("%.2f Yenes", conversion);
                
                break;
                
            case COLONES_A_WON_COREANO:
                conversion = conversionColonesAValor(wonCoreano, valor);
                mensaje = String.format("%.2f Won Coreanos", conversion);
                
                break;
                
            case DOLAR_A_COLONES:
                mensaje = conversionValorAColones(dolar, valor);
                
                break;
                
            case EURO_A_COLONES:
                mensaje = conversionValorAColones(euro, valor);
                
                break;
                
            case LIBRAS_A_COLONES:
                mensaje = conversionValorAColones(libra, valor);
                
                break;
                
            case YEN_A_COLONES:
                mensaje = conversionValorAColones(yen, valor);
                
                break;
                
            case WON_COREANO_A_COLONES:             
                mensaje = conversionValorAColones(wonCoreano, valor);
                
                break;
        }
        return mensaje;
    }
    
    private String conversionValorAColones(double moneda, double valor){
        double conversion = moneda * valor;
        return String.format("%.2f Colones", conversion);
      
    }
    
    private double conversionColonesAValor(double moneda, double valor){
        return valor / moneda;
    }
    
}
