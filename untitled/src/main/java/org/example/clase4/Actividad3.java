package org.example.clase4;

import java.util.Arrays;
import java.util.List;

public class Actividad3 {

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

    public static Cliente[] encontrarDosMejores(List<Cliente> clientes, int inicio, int fin) {
        // Caso base: Si hay solo un cliente, lo retornamos con un valor mínimo
        if (inicio == fin) {
            return new Cliente[]{clientes.get(inicio), new Cliente(-1, "N/A", Integer.MIN_VALUE)};
        }

        // Caso base: Si hay dos clientes, los ordenamos y retornamos
        if (fin - inicio == 1) {
            Cliente max1 = (clientes.get(inicio).scoring >= clientes.get(fin).scoring) ? clientes.get(inicio) : clientes.get(fin);
            Cliente max2 = (clientes.get(inicio).scoring < clientes.get(fin).scoring) ? clientes.get(inicio) : clientes.get(fin);
            return new Cliente[]{max1, max2};
        }

        // Dividir la lista en dos mitades
        int medio = (inicio + fin) / 2;

        // Encontrar los dos mejores en cada mitad
        Cliente[] maxIzq = encontrarDosMejores(clientes, inicio, medio);
        Cliente[] maxDer = encontrarDosMejores(clientes, medio + 1, fin);

        // Combinar los resultados para obtener los dos mejores clientes
        return combinarDosMejores(maxIzq, maxDer);
    }

    private static Cliente[] combinarDosMejores(Cliente[] maxIzq, Cliente[] maxDer) {
        Cliente[] todos = {maxIzq[0], maxIzq[1], maxDer[0], maxDer[1]};
        Arrays.sort(todos, (a, b) -> Integer.compare(b.scoring, a.scoring)); // Ordenar por scoring descendente
        return new Cliente[]{todos[0], todos[1]}; // Retornar los dos mejores
    }

    public static void main(String[] args) {
        List<Cliente> clientes = Arrays.asList(
                new Cliente(1, "Juan", 85),
                new Cliente(2, "Ana", 92),
                new Cliente(3, "Pedro", 78),
                new Cliente(4, "Luis", 96),
                new Cliente(5, "Sofia", 89),
                new Cliente(6, "Carlos", 99),
                new Cliente(7, "Marta", 81)
        );

        Cliente[] resultado = encontrarDosMejores(clientes, 0, clientes.size() - 1);

        System.out.println("Los dos clientes con mayor scoring son:");
        System.out.println(resultado[0]);
        System.out.println(resultado[1]);
    }

}
