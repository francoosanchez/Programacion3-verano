package org.example.clase12;

import java.util.*;

public class Actividad4 {

    public static class Usuario {
        private int id;
        private String nombre;

        public Usuario(int id, String nombre) {
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

    public static class RedSocial {
        private Map<Integer, Usuario> usuarios = new HashMap<>();
        private Map<Integer, List<Integer>> amistades = new HashMap<>();

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
            System.out.print("Recorrido DFS: ");
            dfsRecursivo(inicio, visitados);
            System.out.println();
        }

        private void dfsRecursivo(int nodo, Set<Integer> visitados) {
            if (visitados.contains(nodo)) return;

            System.out.print(usuarios.get(nodo) + " ");
            visitados.add(nodo);

            for (int amigo : amistades.getOrDefault(nodo, Collections.emptyList())) {
                dfsRecursivo(amigo, visitados);
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
                System.out.print(usuarios.get(nodo) + " ");

                for (int amigo : amistades.getOrDefault(nodo, Collections.emptyList())) {
                    if (!visitados.contains(amigo)) {
                        visitados.add(amigo);
                        cola.add(amigo);
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RedSocial red = new RedSocial();

        red.agregarUsuario(1, "Alice");
        red.agregarUsuario(2, "Bob");
        red.agregarUsuario(3, "Charlie");
        red.agregarUsuario(4, "David");
        red.agregarUsuario(5, "Eve");

        red.conectarUsuarios(1, 2);
        red.conectarUsuarios(1, 3);
        red.conectarUsuarios(2, 4);
        red.conectarUsuarios(3, 5);
        red.conectarUsuarios(4, 5);

        red.dfs(1);
        red.bfs(1);
    }
}
