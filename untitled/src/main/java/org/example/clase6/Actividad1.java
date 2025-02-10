package org.example.clase6;

import java.util.*;

public class Actividad1 {
    public static class Usuario {
        private String id;

        public Usuario(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return id;
        }
    }

    public static class RedSocial {
        private Map<Usuario, List<Usuario>> seguidores;

        public RedSocial() {
            seguidores = new HashMap<>();
        }

        // Agregar un nuevo usuario
        public void agregarUsuario(Usuario usuario) {
            if (!seguidores.containsKey(usuario)) {
                seguidores.put(usuario, new ArrayList<>());
            }
        }

        // Seguir a otro usuario
        public void seguir(Usuario seguidor, Usuario seguido) {
            if (!seguidores.containsKey(seguidor)) {
                System.out.println("El usuario " + seguidor + " no existe.");
                return;
            }
            if (!seguidores.containsKey(seguido)) {
                System.out.println("El usuario " + seguido + " no existe.");
                return;
            }

            List<Usuario> seguidos = seguidores.get(seguidor);
            if (!seguidos.contains(seguido)) {
                seguidos.add(seguido);
            }
        }

        // Dejar de seguir a otro usuario
        public void dejarDeSeguir(Usuario seguidor, Usuario seguido) {
            if (!seguidores.containsKey(seguidor)) {
                System.out.println("El usuario " + seguidor + " no existe.");
                return;
            }
            List<Usuario> seguidos = seguidores.get(seguidor);
            if (seguidos.contains(seguido)) {
                seguidos.remove(seguido);
            }
        }

        // Lista de usuarios que sigue un usuario dado
        public List<Usuario> listarSeguidos(Usuario usuario) {
            if (!seguidores.containsKey(usuario)) {
                System.out.println("El usuario " + usuario + " no existe.");
                return Collections.emptyList();
            }
            return seguidores.get(usuario);
        }

        // Lista de usuarios que siguen a un usuario dado
        public List<Usuario> listarSeguidores(Usuario usuario) {
            List<Usuario> seguidoresUsuario = new ArrayList<>();
            for (Map.Entry<Usuario, List<Usuario>> entry : seguidores.entrySet()) {
                if (entry.getValue().contains(usuario)) {
                    seguidoresUsuario.add(entry.getKey());
                }
            }
            return seguidoresUsuario;
        }
    }


    public static void main(String[] args) {
        // Crear usuarios
        Usuario usuarioA = new Usuario("A");
        Usuario usuarioB = new Usuario("B");
        Usuario usuarioC = new Usuario("C");

        // Crear la red social
        RedSocial redSocial = new RedSocial();

        // Agregar usuarios a la red social
        redSocial.agregarUsuario(usuarioA);
        redSocial.agregarUsuario(usuarioB);
        redSocial.agregarUsuario(usuarioC);

        // Realizar operaciones
        redSocial.seguir(usuarioA, usuarioB);
        redSocial.seguir(usuarioA, usuarioC);
        redSocial.seguir(usuarioB, usuarioC);

        // Consultar lista de seguidos
        System.out.println(usuarioA + " sigue a: " + redSocial.listarSeguidos(usuarioA));
        System.out.println(usuarioB + " sigue a: " + redSocial.listarSeguidos(usuarioB));

        // Consultar lista de seguidores
        System.out.println(usuarioC + " es seguido por: " + redSocial.listarSeguidores(usuarioC));

        // Dejar de seguir
        redSocial.dejarDeSeguir(usuarioA, usuarioB);
        System.out.println(usuarioA + " sigue a: " + redSocial.listarSeguidos(usuarioA));
    }

}
