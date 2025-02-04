package org.example.clase2;

public class Actividad4 {
    public static long factorial(long n) {
        if (n < 0) throw new IllegalArgumentException("El número debe ser no negativo");
        long resultado = 1;
        for (long i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("Factorial de 10: " + factorial(10)); // 3,628,800
        System.out.println("Factorial de 20: " + factorial(20)); // 2,432,902,008,176,640,000
    }
}
