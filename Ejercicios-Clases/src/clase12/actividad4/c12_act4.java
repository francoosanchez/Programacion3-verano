package clase12.actividad4;

import java.util.*;

class Usuario {
    private String id;
    private String nombre;

    public Usuario(String id, String nombre) {
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

class RedSocial {
    private Map<String, Usuario> usuarios;
    private Map<String, List<String>> amistades;

    public RedSocial() {
        usuarios = new HashMap<>();
        amistades = new HashMap<>();
    }

    public void agregarUsuario(String id, String nombre) {
        Usuario usuario = new Usuario(id, nombre);
        usuarios.put(id, usuario);
        amistades.putIfAbsent(id, new ArrayList<>());
    }

    public void conectarUsuarios(String id1, String id2) {
        if (usuarios.containsKey(id1) && usuarios.containsKey(id2)) {
            amistades.get(id1).add(id2);
            amistades.get(id2).add(id1); // Relación bidireccional
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
            System.out.print(usuarios.get(id).getNombre() + " -> ");
            for (String amigo : amistades.get(id)) {
                DFSUtil(amigo, visitados);
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
            System.out.print(usuarios.get(id).getNombre() + " -> ");
            for (String amigo : amistades.get(id)) {
                if (!visitados.contains(amigo)) {
                    visitados.add(amigo);
                    cola.add(amigo);
                }
            }
        }
        System.out.println();
    }
}

public class c12_act4 {
    public static void main(String[] args) {
        RedSocial red = new RedSocial();

        red.agregarUsuario("1", "Alice");
        red.agregarUsuario("2", "Bob");
        red.agregarUsuario("3", "Charlie");
        red.agregarUsuario("4", "David");

        red.conectarUsuarios("1", "2");
        red.conectarUsuarios("1", "3");
        red.conectarUsuarios("2", "4");
        red.conectarUsuarios("3", "4");

        red.DFS("1");
        red.BFS("1");
    }
}

