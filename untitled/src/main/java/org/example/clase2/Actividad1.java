package org.example.clase2;

public class Actividad1 {
    public static void main(String[] args) {
        int[][] mat = {{4, 5, 6}, {7, 8, 9}, {5, 6, 7}};
        int n = mat.length; // Obtener tamaño de la matriz
        int suma = 0; // Inicializar la suma
        int elementos = n * n; // Calcular número total de elementos

        // Recorrer la matriz y sumar los elementos
        for (int i = 0; i < n; i++) { // (1) Bucle sobre filas
            for (int j = 0; j < n; j++) { // (2) Bucle sobre columnas
                suma += mat[i][j]; // (3) Sumar elemento actual
            }
        }

        // Calcular promedio
        double promedio = (double) suma / elementos; // (4) División para calcular promedio

        // Mostrar resultado
        System.out.println("El promedio de la matriz es: " + promedio); // (5) Imprimir resultado
    }
}