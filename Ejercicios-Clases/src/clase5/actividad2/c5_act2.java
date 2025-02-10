package clase5.actividad2;

import java.util.Arrays;

/*
    Actividad 2: Cambio de Moneda Extranjera con Múltiples Tipos de Comprobantes
    
    Descripción del Problema:
    Un sistema de tesorería tiene a disposición una variedad de comprobantes que incluyen monedas, cheques, bonos y otros documentos financieros. 
    Cada comprobante tiene un valor específico. 
    El objetivo es realizar una compra de moneda extranjera minimizando el número de comprobantes utilizados.
    Resolver mediante pseudocódigo e implementación java.
    Indicar la complejidad algorítmica.
 */

public class c5_act2 {
    public static int minimizarComprobantes(int[] comprobantes, int valorCompra){
        Arrays.sort(comprobantes); // O(n log n)
        int contadorDeComprobantes = 0;
    
        for(int i = comprobantes.length -1; i >= 0; i --){
          while(valorCompra >= comprobantes[i]){ // O(n)
            valorCompra -= comprobantes[i]; // O(1)
            contadorDeComprobantes++; // O(1)
            }
        }

        
        if(valorCompra == 0){ //O(1)
            return contadorDeComprobantes; // si puedo
        }else{ 
            return -1; // no puedo 
        }
    }

    public static void main(String[] args) {
        int[]  comprobantes = {1,5,10,50,100,200};
        int valorCompra = 352;

        int resultado = minimizarComprobantes(comprobantes,valorCompra);

        if(resultado != -1 ){ // si es -1 
            System.out.println("El valor de la compra "+ valorCompra + " es posible de darse con: " + resultado +" comprobantes utilizados.");
        }else{
            System.out.println("El valor de la compra " + valorCompra + " NO es posible de darse con: " + comprobantes + "comprobantes");
        }
    }
    
}
