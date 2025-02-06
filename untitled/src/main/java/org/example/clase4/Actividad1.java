package org.example.clase4;

import java.util.Arrays;
import java.util.List;

public class Actividad1 {
    public static class Cliente {
        int id;
        String nombre;
        int scoring;

        public Cliente(int id, String nombre, int scoring) {
            this.id = id;
            this.nombre = nombre;
            this.scoring = scoring;
        }

        @Override
        public String toString() {
            return "Cliente{id=" + id + ", nombre='" + nombre + "', scoring=" + scoring + "}";
        }
    }

    public static Cliente encontrarClienteMaximo(List<Cliente> clientes, int inicio, int fin) {
        // Caso base: si hay un solo cliente, ese es el máximo
        if (inicio == fin) {
            return clientes.get(inicio);
        }

        // Dividir la lista en dos mitades
        int medio = (inicio + fin) / 2;

        // Encontrar el máximo en cada mitad
        Cliente maxIzquierda = encontrarClienteMaximo(clientes, inicio, medio);
        Cliente maxDerecha = encontrarClienteMaximo(clientes, medio + 1, fin);

        // Retornar el cliente con mayor scoring entre las dos mitades
        return (maxIzquierda.scoring >= maxDerecha.scoring) ? maxIzquierda : maxDerecha;
    }

    public static void main(String[] args) {
        List<Cliente> clientes = Arrays.asList(
                new Cliente(1, "Juan", 750),
                new Cliente(2, "Ana", 820),
                new Cliente(3, "Pedro", 920),
                new Cliente(4, "Laura", 890),
                new Cliente(5, "Carlos", 950)
        );

        Cliente clienteMax = encontrarClienteMaximo(clientes, 0, clientes.size() - 1);

        System.out.println("Cliente con el mayor scoring: " + clienteMax);
    }
}
