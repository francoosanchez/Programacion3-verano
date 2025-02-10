package org.example.clase6;

import java.util.*;

public class Actividad4 {


   public static class Grafo {
        // Lista de adyacencia del grafo (tiempo de viaje entre centros)
        private Map<Integer, List<int[]>> adjList;
        private int numCentros;

        // Constructor
        public Grafo(int numCentros) {
            this.numCentros = numCentros;
            adjList = new HashMap<>();
            for (int i = 0; i < numCentros; i++) {
                adjList.put(i, new ArrayList<>());
            }
        }

        // Agregar una carretera entre dos centros de distribución
        public void agregarCarretera(int origen, int destino, int tiempo) {
            adjList.get(origen).add(new int[] {destino, tiempo});
            adjList.get(destino).add(new int[] {origen, tiempo});  // Grafo no dirigido
        }

        // Algoritmo de Dijkstra para encontrar el tiempo mínimo de entrega
        public void calcularTiempoMinimo(int origen) {
            // Min-Heap (PriorityQueue) para explorar los nodos con menor tiempo de entrega
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

            // Array para almacenar el tiempo mínimo para llegar a cada nodo
            int[] tiempos = new int[numCentros];
            Arrays.fill(tiempos, Integer.MAX_VALUE);
            tiempos[origen] = 0;  // El tiempo al centro principal es 0

            // Añadir el nodo de inicio al heap
            minHeap.add(new int[] {origen, 0});

            while (!minHeap.isEmpty()) {
                int[] actual = minHeap.poll();
                int nodoActual = actual[0];
                int tiempoActual = actual[1];

                // Si ya encontramos un tiempo menor para este nodo, lo ignoramos
                if (tiempoActual > tiempos[nodoActual]) continue;

                // Explorar los vecinos del nodo actual
                for (int[] vecino : adjList.get(nodoActual)) {
                    int destino = vecino[0];
                    int tiempoViaje = vecino[1];

                    // Si encontramos un tiempo de viaje más corto para el vecino, lo actualizamos
                    if (tiempos[nodoActual] + tiempoViaje < tiempos[destino]) {
                        tiempos[destino] = tiempos[nodoActual] + tiempoViaje;
                        minHeap.add(new int[] {destino, tiempos[destino]});
                    }
                }
            }

            // Mostrar los tiempos mínimos de entrega desde el centro principal
            for (int i = 0; i < numCentros; i++) {
                if (tiempos[i] == Integer.MAX_VALUE) {
                    System.out.println("Centro " + i + " no es accesible desde el centro principal.");
                } else {
                    System.out.println("Tiempo mínimo de entrega al centro " + i + ": " + tiempos[i] + " minutos");
                }
            }
        }
    }


    public static void main(String[] args) {
        // Número de centros de distribución
        int numCentros = 5;

        // Crear el grafo
        Grafo grafo = new Grafo(numCentros);

        // Agregar carreteras entre centros con su respectivo tiempo de viaje (en minutos)
        // Formato: origen, destino, tiempo de viaje
        grafo.agregarCarretera(0, 1, 10);
        grafo.agregarCarretera(0, 2, 20);
        grafo.agregarCarretera(1, 2, 5);
        grafo.agregarCarretera(1, 3, 15);
        grafo.agregarCarretera(2, 3, 10);
        grafo.agregarCarretera(3, 4, 5);

        // Ejecutar el algoritmo de Dijkstra desde el centro de distribución principal (nodo 0)
        grafo.calcularTiempoMinimo(0);
    }

}
