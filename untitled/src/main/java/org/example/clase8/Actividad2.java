package org.example.clase8;

public class Actividad2 {
    static final int INF = Integer.MAX_VALUE;

    public static void floydWarshall(int[][] dist) {
        int n = dist.length;

        // Aplicación del algoritmo de Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
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

        System.out.println("El algoritmo se ejecutó correctamente, sin ciclos negativos.");
    }

    public static void main(String[] args) {
        int n = 4; // Número de centros de distribución
        int[][] dist = new int[n][n];

        // Inicialización de la matriz de distancias
        // (suponiendo un grafo de 4 nodos con algunas rutas y costos adicionales)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = (i == j) ? 0 : INF; // Tiempo de viaje a sí mismo es 0, el resto es infinito
            }
        }

        // Definir las distancias de las carreteras (tiempo de viaje en minutos)
        dist[0][1] = 10; // Centro 0 -> Centro 1
        dist[1][2] = 20; // Centro 1 -> Centro 2
        dist[2][3] = 30; // Centro 2 -> Centro 3
        dist[0][2] = 50; // Centro 0 -> Centro 2
        dist[1][3] = 40; // Centro 1 -> Centro 3

        // Añadir un costo adicional (negativo) en la ruta 1 -> 2
        dist[0][2] = -5; // Ruta especial con descuento

        // Llamar al algoritmo de Floyd-Warshall
        floydWarshall(dist);

        // Imprimir la matriz de distancias finales
        System.out.println("\nMatriz de tiempos mínimos de entrega (en minutos):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

}
