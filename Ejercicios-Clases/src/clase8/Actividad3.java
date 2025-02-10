package clase8;

import java.util.Arrays;
import java.util.Scanner;

public class Actividad3 {
    static final int INF = 99999;
    static int[][] next;

    public static void floydWarshall(int graph[][]) {
        int numVertices = graph.length;
        int dist[][] = new int[numVertices][numVertices];
        next = new int[numVertices][numVertices];

        // Inicializamos la matriz de distancias y la matriz de caminos
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    next[i][j] = j;
                } else {
                    next[i][j] = -1;
                }
            }
        }

        // Aplicamos el algoritmo de Floyd-Warshall
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        // Detectamos ciclos negativos
        for (int i = 0; i < numVertices; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Se ha detectado un ciclo negativo en la red de rutas.");
                return;
            }
        }

        printSolution(dist);
    }

    static void printSolution(int dist[][]) {
        System.out.println("Matriz de tiempos mínimos entre centros de distribución:");
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void printPath(int origen, int destino) {
        if (next[origen][destino] == -1) {
            System.out.println("No hay camino disponible.");
            return;
        }
        System.out.print("Camino más corto: " + origen);
        while (origen != destino) {
            origen = next[origen][destino];
            System.out.print(" -> " + origen);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int graph[][] = {
                {0, 3, INF, 7},
                {8, 0, 2, INF},
                {5, INF, 0, 1},
                {2, INF, INF, 0}
        };

        floydWarshall(graph);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nodo de origen: ");
        int origen = scanner.nextInt();
        System.out.print("Ingrese el nodo de destino: ");
        int destino = scanner.nextInt();
        scanner.close();

        printPath(origen, destino);
    }
}


