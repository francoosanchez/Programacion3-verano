package clase12.actividad3;

import java.util.*;

class Almacen {
    private String id;
    private String nombre;

    public Almacen(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}

class Grafo {
    private Map<String, Almacen> almacenes;
    private Map<String, List<String>> adyacencias;

    public Grafo() {
        almacenes = new HashMap<>();
        adyacencias = new HashMap<>();
    }

    public void agregarAlmacen(String id, String nombre) {
        Almacen almacen = new Almacen(id, nombre);
        almacenes.put(id, almacen);
        adyacencias.putIfAbsent(id, new ArrayList<>());
    }

    public void conectarAlmacenes(String id1, String id2) {
        if (almacenes.containsKey(id1) && almacenes.containsKey(id2)) {
            adyacencias.get(id1).add(id2);
            adyacencias.get(id2).add(id1); // Grafo no dirigido
        }
    }

    public void DFS(String inicio) {
        Set<String> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        DFSUtil(inicio, visitados);
        System.out.println();
    }

    private void DFSUtil(String id, Set<String> visitados) {
        if (!visitados.contains(id)) {
            visitados.add(id);
            System.out.print(almacenes.get(id).getNombre() + " -> ");
            for (String vecino : adyacencias.get(id)) {
                DFSUtil(vecino, visitados);
            }
        }
    }

    public void BFS(String inicio) {
        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();
        System.out.println("Recorrido BFS:");
        cola.add(inicio);
        visitados.add(inicio);

        while (!cola.isEmpty()) {
            String id = cola.poll();
            System.out.print(almacenes.get(id).getNombre() + " -> ");
            for (String vecino : adyacencias.get(id)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }
}

public class c12_act3 {
    public static void main(String[] args) {
        Grafo redAlmacenes = new Grafo();

        redAlmacenes.agregarAlmacen("A", "Almacen 1");
        redAlmacenes.agregarAlmacen("B", "Almacen 2");
        redAlmacenes.agregarAlmacen("C", "Almacen 3");
        redAlmacenes.agregarAlmacen("D", "Almacen 4");

        redAlmacenes.conectarAlmacenes("A", "B");
        redAlmacenes.conectarAlmacenes("A", "C");
        redAlmacenes.conectarAlmacenes("B", "D");
        redAlmacenes.conectarAlmacenes("C", "D");

        redAlmacenes.DFS("A");
        redAlmacenes.BFS("A");
    }
}
