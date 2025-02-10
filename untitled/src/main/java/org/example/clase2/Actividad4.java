package org.example.clase2;

public class Actividad4 {

   //El factorial de un número es el producto de todos los números desde ese número hasta 1.
   //5! = 5 × 4 × 3 × 2 × 1
    public static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Factorial de 5: " + factorial(5)); // 120
        System.out.println("Factorial de 3: " + factorial(3)); // 6
    }
}
