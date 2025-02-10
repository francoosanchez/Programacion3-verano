package org.example.clase2;

public class Actividad5 {
    public static int sumaRecursiva(int n) {
        if (n <= 0) return 0;  // Caso base
        return n + sumaRecursiva(n - 1); // Llamada recursiva
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("La suma de los primeros " + n + " números es: " + sumaRecursiva(n));
        // Salida esperada: 15
    }
}
