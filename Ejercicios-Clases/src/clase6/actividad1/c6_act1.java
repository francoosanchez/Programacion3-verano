package clase6.actividad1;

/*
    Actividad 1

    Desarrolla un programa que modele un sistema de seguidores en una red social utilizando un grafo representado con una lista de adyacencia. 
    En este sistema, cada usuario puede seguir a otros usuarios, y queremos almacenar y consultar estas relaciones de manera eficiente.

    Especificaciones:
    - Representación del Grafo:
        Utiliza una lista de adyacencia para representar el grafo. 
        En esta representación, cada nodo (usuario) tiene una lista de nodos a los que sigue (usuarios que lo siguen).

    - Estructuras de Datos:
        Usa una clase o estructura Usuario que tenga un identificador único (por ejemplo, un nombre o un número de ID).
        Utiliza un diccionario o un mapa para mantener la lista de adyacencia, donde cada clave es un Usuario y el valor asociado es una lista de usuarios que ese usuario sigue.

    - Operaciones Requeridas:
        * Agregar Usuario: Permite agregar un nuevo usuario al sistema.
        * Seguir: Permite que un usuario siga a otro. Si el usuario ya sigue al destinatario, la operación no debe tener efecto.
        * Dejar de Seguir: Permite que un usuario deje de seguir a otro. Si el usuario no sigue al destinatario, la operación no debe tener efecto.
        * Lista de Seguidores: Permite consultar la lista de usuarios que sigue un usuario dado.
        * Lista de Seguidores de: Permite consultar la lista de usuarios que siguen a un usuario dado.
 */

import java.util.ArrayList;
import java.util.TreeMap;

class Usuario {
    private int id;
    private String nombre;

    Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}

public class c6_act1 {
    public static void main(String[] args) {

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        TreeMap<Integer, ArrayList<Integer>> relaciones = new TreeMap<Integer, ArrayList<Integer>>();

        Usuario nico = new Usuario(0, "Nico");
        Usuario usuario1 = new Usuario(0, "Nico 2");
        Usuario usuario2 = new Usuario(0, "Nico 3");
        Usuario usuario3 = new Usuario(0, "Nico 4");
        Usuario usuario4 = new Usuario(0, "Nico 5");

        usuarios.add(nico);
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);

        // Agregar listas de adyacencia para cada vértice
        for (int i = 0; i < usuarios.size(); i++) {
            relaciones.put(i, new ArrayList<Integer>());
        }

        // Agregar aristas
        relaciones.get(0).add(2); // A - C
        relaciones.get(0).add(3); // B - D
        relaciones.get(2).add(3); // C - D
        relaciones.get(3).add(1); // C - D

        for (int i = 0; i < usuarios.size(); i++) {

            if (relaciones.get(i).size() <= 0) {
                System.out.print(String.format("El usuario %s no sigue a nadie actualmente", usuarios.get(i).getNombre()));
            } else {
                System.out.print(String.format("El usuario %s sigue a los usuarios: ", usuarios.get(i).getNombre()));
                for (int j = 0; j < relaciones.get(i).size(); j++) {
                    System.out.print( (usuarios.get(relaciones.get(i).get(j)).getNombre()) + " ");
                }
            }
            System.out.println("");
        }
    }
}
 