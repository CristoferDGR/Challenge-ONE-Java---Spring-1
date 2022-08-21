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

                    break;

                case CONVERSION_TEMPERATURA:

                    break;
                default:
                    int continuar = continuarPrograma();
                    if(continuar > 0) {
                        seguirPrograma = -1;
                    }
                    
            }
        }
        JOptionPane.showMessageDialog(null, "Programa Terminado");    
    }
    
    
    public int solicitarTipoConversion() {
        String[] opciones = {"Conversor de moneda","Conversor de temperatura"};
        String opcionEscogida = (String) JOptionPane.showInputDialog(null, "Seleccione una opci\u00f3n de conversi\u00f3n", "Menu", 
                -1, null, opciones, opciones[0]);
        
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
    
    public void solicitarMontoDinero(){
        String[] opciones = {"Conversor de moneda","Conversor de temperatura"};
            
        try{
            double p = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la cantidad de dinero que desea convertir:"));

        }catch(NumberFormatException e){
            e.printStackTrace();
        }
    }
    
    public void solicitarMonedaConversion(){
        String[] opciones = {"De colones a D\u00f3lar", "De colones a Euro", "De colones a Libras", 
                             "De colones a Yen", "De colones a Won Coreano", "De D\u00f3lar a colones",
                             "De Euro a colones", "De Libras a colones", "De Yen a colones", 
                             "De Won Coreano a colones"};
        String opcionEscogida = (String) JOptionPane.showInputDialog(null, "Seleccione una opci\u00f3n de conversi\u00f3n", "Menu", 
                -1, null, opciones, opciones[0]);
    }
    
    public void mostrarConversion(){
        JOptionPane.showMessageDialog(null, "");
    }
    
    public void mostrarErrorValorInvalido() {
        JOptionPane.showMessageDialog(null, "Valor no v\u00e1lido", "Error", JOptionPane.ERROR_MESSAGE) ;
    }
    
    public int continuarPrograma(){
       return JOptionPane.showConfirmDialog(null, "Desea continuar con el programa");
    }
    
}
