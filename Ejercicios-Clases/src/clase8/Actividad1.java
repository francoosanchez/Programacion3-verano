package clase8;

import java.util.Arrays;

public class Actividad1 {
    static final int INF = 99999;

    public static void floydWarshall(int graph[][]) {
        int V = graph.length;
        int dist[][] = new int[V][V];

        // Copia la matriz de adyacencia inicial en dist[][]
        for (int i = 0; i < V; i++) {
            dist[i] = Arrays.copyOf(graph[i], V);
        }

        // Algoritmo de Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Imprimir la matriz de distancias más cortas
        printSolution(dist);
    }

    public static void printSolution(int dist[][]) {
        System.out.println("Matriz de distancias más cortas entre todos los pares de nodos:");
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
                {0, 3, INF, 5},
                {2, 0, INF, 4},
                {INF, 1, 0, INF},
                {INF, INF, 2, 0}
        };

        floydWarshall(graph);
    }
}
