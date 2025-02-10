package clase8;

import java.util.Arrays;

public class Actividad2 {
    static final int INF = 99999;

    public static void floydWarshall(int graph[][]) {
        int numVertices = graph.length;
        int dist[][] = new int[numVertices][numVertices];

        // Inicializamos la matriz de distancias
        for (int i = 0; i < numVertices; i++) {
            dist[i] = Arrays.copyOf(graph[i], numVertices);
        }

        // Aplicamos el algoritmo de Floyd-Warshall
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
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

    public static void main(String[] args) {
        int graph[][] = {
                {0, 3, INF, 7},
                {8, 0, 2, INF},
                {5, INF, 0, 1},
                {2, INF, INF, 0}
        };

        floydWarshall(graph);
    }
}


