package org.example.clase8;

import java.util.Scanner;

public class Actividad3 {

    static final int INF = Integer.MAX_VALUE;

    // Método para encontrar el camino más corto entre dos nodos
    public static void floydWarshall(int[][] dist, int[][] pred) {
        int n = dist.length;

        // Aplicación del algoritmo de Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Si encontramos un camino más corto a través de k, actualizamos dist[i][j]
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pred[i][j] = k; // Establecemos el predecesor de j como k
                    }
                }
            }
        }

        // Detección de ciclos negativos
        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) {
                System.out.println("¡Existen ciclos negativos en el grafo!");
                return;
            }
        }
    }

    // Método para reconstruir el camino más corto entre dos nodos
    public static void printPath(int[][] pred, int i, int j) {
        if (i == j) {
            System.out.print(i + " ");
        } else if (pred[i][j] == -1) {
            System.out.print("No hay camino");
        } else {
            printPath(pred, i, pred[i][j]);
            System.out.print(j + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 4; // Número de centros de distribución
        int[][] dist = new int[n][n];
        int[][] pred = new int[n][n];

        // Inicialización de las matrices de distancias y predecesores
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
                pred[i][j] = -1; // -1 indica que no hay predecesor
            }
        }

        // Definir las distancias de las carreteras (tiempo de viaje en minutos)
        dist[0][1] = 10; // Centro 0 -> Centro 1
        dist[1][2] = 20; // Centro 1 -> Centro 2
        dist[2][3] = 30; // Centro 2 -> Centro 3
        dist[0][2] = 50; // Centro 0 -> Centro 2
        dist[1][3] = 40; // Centro 1 -> Centro 3

        // Añadir un costo adicional (negativo) en la ruta 0 -> 2
        dist[0][2] = -5; // Ruta especial con descuento

        // Llamar al algoritmo de Floyd-Warshall
        floydWarshall(dist, pred);

        // Solicitar origen y destino
        System.out.print("Ingresa el nodo de origen (0 a " + (n-1) + "): ");
        int origen = scanner.nextInt();

        System.out.print("Ingresa el nodo de destino (0 a " + (n-1) + "): ");
        int destino = scanner.nextInt();

        // Verificar si existe un camino
        if (dist[origen][destino] == INF) {
            System.out.println("No existe un camino entre el origen y el destino.");
        } else {
            System.out.println("El camino más corto desde el nodo " + origen + " hasta el nodo " + destino + " es:");
            printPath(pred, origen, destino);
            System.out.println("\nTiempo mínimo de entrega: " + dist[origen][destino] + " minutos");
        }

        scanner.close();
    }


}
