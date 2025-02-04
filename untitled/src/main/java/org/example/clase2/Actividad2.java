package org.example.clase2;

public class Actividad2 {
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] B = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        int n = A.length; // Tamaño de la matriz
        int[][] C = new int[n][n]; // Matriz resultado

        // Multiplicación de matrices
        for (int i = 0; i < n; i++) { // (1) Recorrer filas de A
            for (int j = 0; j < n; j++) { // (2) Recorrer columnas de B
                C[i][j] = 0; // Inicializar el elemento
                for (int k = 0; k < n; k++) { // (3) Sumar productos
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        // Mostrar matriz resultado
        System.out.println("Matriz resultante:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
