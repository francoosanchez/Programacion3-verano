package clase12;

import java.util.*;

class Usuario {
    int id;
    String nombre;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}

class RedSocial {
    private Map<Integer, Usuario> usuarios;
    private Map<Integer, List<Integer>> amistades;

    public RedSocial() {
        usuarios = new HashMap<>();
        amistades = new HashMap<>();
    }

    public void agregarUsuario(int id, String nombre) {
        if (!usuarios.containsKey(id)) {
            Usuario usuario = new Usuario(id, nombre);
            usuarios.put(id, usuario);
            amistades.put(id, new ArrayList<>());
        }
    }

    public void conectarUsuarios(int id1, int id2) {
        if (usuarios.containsKey(id1) && usuarios.containsKey(id2)) {
            amistades.get(id1).add(id2);
            amistades.get(id2).add(id1); // Relación bidireccional
        }
    }

    public void dfs(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        System.out.println("Recorrido DFS desde " + usuarios.get(inicio).nombre + ":");
        dfsRecursivo(inicio, visitados);
        System.out.println();
    }

    private void dfsRecursivo(int nodo, Set<Integer> visitados) {
        visitados.add(nodo);
        System.out.print(usuarios.get(nodo).nombre + " ");
        for (int amigo : amistades.get(nodo)) {
            if (!visitados.contains(amigo)) {
                dfsRecursivo(amigo, visitados);
            }
        }
    }

    public void bfs(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();
        cola.add(inicio);
        visitados.add(inicio);

        System.out.println("Recorrido BFS desde " + usuarios.get(inicio).nombre + ":");

        while (!cola.isEmpty()) {
            int nodo = cola.poll();
            System.out.print(usuarios.get(nodo).nombre + " ");
            for (int amigo : amistades.get(nodo)) {
                if (!visitados.contains(amigo)) {
                    visitados.add(amigo);
                    cola.add(amigo);
                }
            }
        }
        System.out.println();
    }
}

public class Actividad4 {
    public static void main(String[] args) {
        RedSocial red = new RedSocial();
        red.agregarUsuario(0, "Alice");
        red.agregarUsuario(1, "Bob");
        red.agregarUsuario(2, "Charlie");
        red.agregarUsuario(3, "David");
        red.agregarUsuario(4, "Eve");

        red.conectarUsuarios(0, 1);
        red.conectarUsuarios(0, 2);
        red.conectarUsuarios(1, 3);
        red.conectarUsuarios(2, 4);

        red.dfs(0);
        red.bfs(0);
    }
}


