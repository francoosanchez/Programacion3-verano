package clase6.actividad3;

import java.util.*;

class Grafo {
    private int numEstaciones;
    private LinkedList<Arista>[] listaAdyacencia;

    // Constructor
    public Grafo(int numEstaciones) {
        this.numEstaciones = numEstaciones;
        listaAdyacencia = new LinkedList[numEstaciones];
        for (int i = 0; i < numEstaciones; i++) {
            listaAdyacencia[i] = new LinkedList<>();
        }
    }

    // Clase interna para representar una arista
    static class Arista {
        int destino;
        int peso;

        public Arista(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    // Método para agregar una arista
    public void agregarArista(int origen, int destino, int peso) {
        listaAdyacencia[origen].add(new Arista(destino, peso));
        listaAdyacencia[destino].add(new Arista(origen, peso));
    }

    // Algoritmo de Prim para encontrar el Árbol de Recubrimiento Mínimo
    public void prim(int origen) {
        boolean[] visitado = new boolean[numEstaciones];
        int[] clave = new int[numEstaciones];
        int[] padre = new int[numEstaciones];
        PriorityQueue<Arista> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(a -> a.peso));

        // Inicializar
        Arrays.fill(clave, Integer.MAX_VALUE);
        Arrays.fill(padre, -1);
        clave[origen] = 0;
        colaPrioridad.add(new Arista(origen, 0));

        while (!colaPrioridad.isEmpty()) {
            Arista actual = colaPrioridad.poll();
            int u = actual.destino;

            // Si ya fue visitado, continuar
            if (visitado[u]) continue;
            visitado[u] = true;

            // Recorrer las aristas del nodo u
            for (Arista arista : listaAdyacencia[u]) {
                int v = arista.destino;
                int peso = arista.peso;

                // Si v no está visitado y el peso de la arista es menor que la clave de v
                if (!visitado[v] && peso < clave[v]) {
                    clave[v] = peso;
                    padre[v] = u;
                    colaPrioridad.add(new Arista(v, peso));
                }
            }
        }

        // Mostrar el conjunto de conexiones y calcular el costo total
        mostrarResultado(padre, clave);
    }

    // Mostrar el resultado del Árbol de Recubrimiento Mínimo
    private void mostrarResultado(int[] padre, int[] clave) {
        int costoTotal = 0;
        System.out.println("Conexiones del Árbol de Recubrimiento Mínimo:");
        for (int i = 1; i < numEstaciones; i++) {
            System.out.println("Estación " + padre[i] + " -> Estación " + i + " (Costo: " + clave[i] + ")");
            costoTotal += clave[i];
        }
        System.out.println("Costo total: " + costoTotal);
    }

    public static void main(String[] args) {
        // Crear un grafo de 5 estaciones
        Grafo grafo = new Grafo(5);

        // Agregar conexiones (aristas) entre las estaciones con sus respectivos costos
        grafo.agregarArista(0, 1, 10);
        grafo.agregarArista(0, 2, 5);
        grafo.agregarArista(1, 2, 2);
        grafo.agregarArista(1, 3, 1);
        grafo.agregarArista(2, 3, 9);
        grafo.agregarArista(2, 4, 7);
        grafo.agregarArista(3, 4, 3);

        // Llamar al algoritmo de Prim desde la estación 0
        grafo.prim(0);
    }
}
