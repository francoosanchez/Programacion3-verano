package org.example.clase12;

import java.util.*;

public class Actividad3 {
    public static class Almacen {
        private int id;
        private String nombre;

        public Almacen(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }

    public static class Grafo {
        private Map<Integer, Almacen> almacenes = new HashMap<>();
        private Map<Integer, List<Integer>> adyacencia = new HashMap<>();

        public void agregarAlmacen(int id, String nombre) {
            if (!almacenes.containsKey(id)) {
                Almacen almacen = new Almacen(id, nombre);
                almacenes.put(id, almacen);
                adyacencia.put(id, new ArrayList<>());
            }
        }

        public void conectarAlmacenes(int id1, int id2) {
            if (almacenes.containsKey(id1) && almacenes.containsKey(id2)) {
                adyacencia.get(id1).add(id2);
                adyacencia.get(id2).add(id1); // Si el grafo es no dirigido
            }
        }

        public void dfs(int inicio) {
            Set<Integer> visitados = new HashSet<>();
            System.out.print("Recorrido DFS: ");
            dfsRecursivo(inicio, visitados);
            System.out.println();
        }

        private void dfsRecursivo(int nodo, Set<Integer> visitados) {
            if (visitados.contains(nodo)) return;

            System.out.print(almacenes.get(nodo) + " ");
            visitados.add(nodo);

            for (int vecino : adyacencia.getOrDefault(nodo, Collections.emptyList())) {
                dfsRecursivo(vecino, visitados);
            }
        }

        public void bfs(int inicio) {
            Set<Integer> visitados = new HashSet<>();
            Queue<Integer> cola = new LinkedList<>();
            System.out.print("Recorrido BFS: ");

            visitados.add(inicio);
            cola.add(inicio);

            while (!cola.isEmpty()) {
                int nodo = cola.poll();
                System.out.print(almacenes.get(nodo) + " ");

                for (int vecino : adyacencia.getOrDefault(nodo, Collections.emptyList())) {
                    if (!visitados.contains(vecino)) {
                        visitados.add(vecino);
                        cola.add(vecino);
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Grafo red = new Grafo();

        red.agregarAlmacen(1, "Almacen A");
        red.agregarAlmacen(2, "Almacen B");
        red.agregarAlmacen(3, "Almacen C");
        red.agregarAlmacen(4, "Almacen D");
        red.agregarAlmacen(5, "Almacen E");

        red.conectarAlmacenes(1, 2);
        red.conectarAlmacenes(1, 3);
        red.conectarAlmacenes(2, 4);
        red.conectarAlmacenes(3, 5);
        red.conectarAlmacenes(4, 5);

        red.dfs(1);
        red.bfs(1);
    }
}
