package org.example.clase6;

import java.util.*;

public class Actividad3 {
    public static class Grafo {
        // Lista de adyacencia
        private List<List<int[]>> adjList;
        private int numVertices;

        // Constructor
        public Grafo(int numVertices) {
            this.numVertices = numVertices;
            adjList = new ArrayList<>();
            for (int i = 0; i < numVertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        // Agregar una arista al grafo
        public void agregarArista(int origen, int destino, int costo) {
            adjList.get(origen).add(new int[] {destino, costo});
            adjList.get(destino).add(new int[] {origen, costo});  // Grafo no dirigido
        }

        // Algoritmo de Prim para encontrar el Arbol de Recubrimiento Mínimo
        public void arbolDeRecubrimientoMinimo() {
            // Mínimo heap para obtener el siguiente nodo de menor costo
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

            // Un array para saber si un nodo ha sido visitado
            boolean[] visitado = new boolean[numVertices];

            // Variable para almacenar el costo total
            int costoTotal = 0;

            // Comenzamos desde el nodo 0
            minHeap.add(new int[] {0, 0});  // {nodo, costo}

            while (!minHeap.isEmpty()) {
                int[] nodoActual = minHeap.poll();
                int nodo = nodoActual[0];
                int costoArista = nodoActual[1];

                // Si el nodo ya fue visitado, lo ignoramos
                if (visitado[nodo]) continue;
                visitado[nodo] = true;

                // Sumamos el costo de esta arista al costo total
                costoTotal += costoArista;

                // Mostrar la conexión
                System.out.println("Conectando estación " + nodo + " con costo: " + costoArista);

                // Revisamos los vecinos del nodo actual
                for (int[] vecino : adjList.get(nodo)) {
                    int destino = vecino[0];
                    int costo = vecino[1];

                    // Si el destino no ha sido visitado, lo agregamos al heap
                    if (!visitado[destino]) {
                        minHeap.add(new int[] {destino, costo});
                    }
                }
            }

            System.out.println("Costo total del árbol de recubrimiento mínimo: " + costoTotal);
        }
    }

    public static void main(String[] args) {
        // Número de estaciones (nodos)
        int numEstaciones = 5;

        // Crear el grafo
        Grafo grafo = new Grafo(numEstaciones);

        // Agregar las aristas (conexiones entre estaciones con sus respectivos costos)
        // Formato: origen, destino, costo
        grafo.agregarArista(0, 1, 2);
        grafo.agregarArista(0, 2, 3);
        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(1, 3, 4);
        grafo.agregarArista(2, 3, 5);
        grafo.agregarArista(3, 4, 2);

        // Ejecutar el algoritmo de Prim
        grafo.arbolDeRecubrimientoMinimo();
    }


}
