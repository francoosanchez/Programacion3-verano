package clase12;

import java.util.*;

class Almacen {
    int id;
    String nombre;

    public Almacen(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}

class Grafo {
    private Map<Integer, Almacen> almacenes;
    private Map<Integer, List<Integer>> adyacencias;

    public Grafo() {
        almacenes = new HashMap<>();
        adyacencias = new HashMap<>();
    }

    public void agregarAlmacen(int id, String nombre) {
        if (!almacenes.containsKey(id)) {
            Almacen almacen = new Almacen(id, nombre);
            almacenes.put(id, almacen);
            adyacencias.put(id, new ArrayList<>());
        }
    }

    public void conectarAlmacenes(int id1, int id2) {
        if (almacenes.containsKey(id1) && almacenes.containsKey(id2)) {
            adyacencias.get(id1).add(id2);
            adyacencias.get(id2).add(id1); // Grafo no dirigido
        }
    }

    public void dfs(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        System.out.println("Recorrido DFS desde " + almacenes.get(inicio).nombre + ":");
        dfsRecursivo(inicio, visitados);
        System.out.println();
    }

    private void dfsRecursivo(int nodo, Set<Integer> visitados) {
        visitados.add(nodo);
        System.out.print(almacenes.get(nodo).nombre + " ");
        for (int vecino : adyacencias.get(nodo)) {
            if (!visitados.contains(vecino)) {
                dfsRecursivo(vecino, visitados);
            }
        }
    }

    public void bfs(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();
        cola.add(inicio);
        visitados.add(inicio);

        System.out.println("Recorrido BFS desde " + almacenes.get(inicio).nombre + ":");

        while (!cola.isEmpty()) {
            int nodo = cola.poll();
            System.out.print(almacenes.get(nodo).nombre + " ");
            for (int vecino : adyacencias.get(nodo)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }
}

public class Actividad3 {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.agregarAlmacen(0, "Almacen A");
        grafo.agregarAlmacen(1, "Almacen B");
        grafo.agregarAlmacen(2, "Almacen C");
        grafo.agregarAlmacen(3, "Almacen D");
        grafo.agregarAlmacen(4, "Almacen E");

        grafo.conectarAlmacenes(0, 1);
        grafo.conectarAlmacenes(0, 2);
        grafo.conectarAlmacenes(1, 3);
        grafo.conectarAlmacenes(2, 4);

        grafo.dfs(0);
        grafo.bfs(0);
    }
}


