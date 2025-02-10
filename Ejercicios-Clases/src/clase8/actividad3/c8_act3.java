package clase8.actividad3;

/*
    Actividad 3
    
    Dada la consigna de la actividad 2, modificar o rehacer el programa, para que se
    pida origen y destino y se imprima el camino más corto entre dos vértices.
 */

import java.util.Scanner;

public class c8_act3 {
    final static int INF = 99999; // Representación de infinito

    public static void main(String[] args) {
        c8_act3 fw = new c8_act3();
        int graph[][] = {
                { 0, 2, INF, 5 },
                { INF, 0, INF, 4 },
                { INF, INF, 0, INF },
                { INF, INF, 2, 0 }
        };
        int V = graph.length;

        // Ejecutar Floyd-Warshall y obtener matrices de distancia y predecesores
        int[][][] result = fw.floydWarshall(graph, V);
        int dist[][] = result[0];
        int next[][] = result[1];

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el centro de origen: ");
        int origen = scanner.nextInt();
        System.out.print("Ingrese el centro de destino: ");
        int destino = scanner.nextInt();
        scanner.close();

        // Imprimir el camino más corto
        fw.printShortestPath(origen, destino, next);
    }

    int[][][] floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        int next[][] = new int[V][V];

        // Inicializar matrices de distancias y predecesores
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    next[i][j] = j;
                } else {
                    next[i][j] = -1;
                }
            }
        }

        // Aplicación del algoritmo de Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        // Comprobación de ciclos negativos
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                System.out.println("El sistema de rutas contiene un ciclo negativo.");
                return new int[][][] { dist, next };
            }
        }

        return new int[][][] { dist, next };
    }

    void printShortestPath(int origen, int destino, int next[][]) {
        if (next[origen][destino] == -1) {
            System.out.println("No hay camino entre " + origen + " y " + destino);
            return;
        }

        System.out.print("Camino más corto: " + origen);
        while (origen != destino) {
            origen = next[origen][destino];
            System.out.print(" -> " + origen);
        }
        System.out.println();
    }
}
