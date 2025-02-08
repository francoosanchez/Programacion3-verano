package clase2.actividad4;

import java.math.BigInteger;

/*
    Actividad 3

    ¿Cómo usaría los tipos de datos long y BigInteger para calcular el factorial? 
    Realizar la implementación en java.
 */

public class c2_act4 {
    public static void main(String[] args) {
        // Uso de long
        long numeroGrande = 9223372036854775807L;
        System.out.println("Número grande (long): " + numeroGrande);

        // Operaciones con long
        long otroNumero = 1000000000L;
        long sumaLong = numeroGrande - otroNumero;
        System.out.println("Suma en long (con seguridad): " + sumaLong);

        // Uso de BigInteger
        BigInteger numeroMuyGrande = new BigInteger("123456789012345678901234567890");
        BigInteger otroNumeroBig = new BigInteger("987654321098765432109876543210");
        
        // Operaciones con BigInteger
        BigInteger sumaBig = numeroMuyGrande.add(otroNumeroBig);
        BigInteger productoBig = numeroMuyGrande.multiply(otroNumeroBig);
        
        System.out.println("Suma (BigInteger): " + sumaBig);
        System.out.println("Multiplicación (BigInteger): " + productoBig);
    }
}


