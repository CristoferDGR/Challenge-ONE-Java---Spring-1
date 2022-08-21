package com.Alura.conversormonedas.Controller;

import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class Menu {
    
    private final int CONVERSION_MONEDA = 0;
     private final int CONVERSION_TEMPERATURA = 1;
    
    public void iniciarPrograma(){
        JOptionPane.showMessageDialog(null, "Bienvenido al programa de conversi\u00f3n de la moneda: Col\u00f3n costarricense");
        
        int seguirPrograma = 0;

        while (seguirPrograma == 0) {
            int tipoConversion = solicitarTipoConversion();
            
            switch (tipoConversion) {
                case CONVERSION_MONEDA:
                    ConversorMonedas conversor = new ConversorMonedas();
                    int opcionConversion = conversor.solicitarMonedaConversion();
                    
                    if(opcionConversion >= 0) {
                        double valorConvertir = conversor.solicitarMontoDinero();
                        if(valorConvertir > 0) {
                            String conversion = conversor.convertir(opcionConversion, valorConvertir);
                            mostrarConversion(conversion);
                            
                            
                        }
                    }
                    break;

                case CONVERSION_TEMPERATURA:

                    break;                   
            }
            int continuar = continuarPrograma();
            if (continuar > 0) {
                seguirPrograma = -1;
            }
        }
        JOptionPane.showMessageDialog(null, "Programa Terminado");    
    }
    
    
    public int solicitarTipoConversion() {
        String[] opciones = {"Conversor de moneda","Conversor de temperatura"};
        String opcionEscogida = (String) JOptionPane.showInputDialog(null, "Seleccione una opci\u00f3n de conversi\u00f3n", "Menu", 
                -1, null, opciones, opciones[0]);
        
        return opcionEscogida(opciones, opcionEscogida);
    }
    
    public static int opcionEscogida(String[] opciones, String opcionEscogida) {
        if(opcionEscogida == null){
            return -1;
            
        }else{
            int i = 0;
            do {
                if(opcionEscogida.equals(opciones[i])){
                    return i;
                }
                i++;
            }while(i < opciones.length);
        }
        
        return -1;
    }
    
    public void mostrarConversion(String valor){
        JOptionPane.showMessageDialog(null, "Tienes $" + valor);
    }
    
    public int continuarPrograma(){
       return JOptionPane.showConfirmDialog(null, "Desea continuar con el programa");
    }
    
}