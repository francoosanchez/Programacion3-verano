package clase2;

import java.math.BigInteger;

public class Actividad4 {
    // Método usando long (limitado por el tamaño de long)
    public static long factorialLong(int n) {
        if (n < 0) throw new IllegalArgumentException("El número debe ser no negativo");
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
            if (resultado < 0) throw new ArithmeticException("Desbordamiento de long");
        }
        return resultado;
    }

    // Método usando BigInteger (sin límite práctico)
    public static BigInteger factorialBigInteger(int n) {
        if (n < 0) throw new IllegalArgumentException("El número debe ser no negativo");
        BigInteger resultado = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
        return resultado;
    }

    public static void main(String[] args) {
        int numero = 20;
        System.out.println("Factorial con long: " + factorialLong(numero));
        System.out.println("Factorial con BigInteger: " + factorialBigInteger(numero));
    }
}


