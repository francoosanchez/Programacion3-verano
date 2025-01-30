package clase4;

import java.util.*;

class Cliente {
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


public class Actividad1 {
    public static Cliente encontrarMejorCliente(List<Cliente> clientes, int inicio, int fin) {
        if (inicio == fin) {
            return clientes.get(inicio);
        }

        int medio = (inicio + fin) / 2;
        Cliente mejorIzquierda = encontrarMejorCliente(clientes, inicio, medio);
        Cliente mejorDerecha = encontrarMejorCliente(clientes, medio + 1, fin);

        return (mejorIzquierda.scoring >= mejorDerecha.scoring) ? mejorIzquierda : mejorDerecha;
    }

    public static void main(String[] args) {
        List<Cliente> clientes = Arrays.asList(
                new Cliente(1, "Juan", 85),
                new Cliente(2, "Ana", 90),
                new Cliente(3, "Carlos", 88),
                new Cliente(4, "Beatriz", 95),
                new Cliente(5, "David", 80)
        );

        Cliente mejorCliente = encontrarMejorCliente(clientes, 0, clientes.size() - 1);
        System.out.println("El cliente con mayor scoring es: " + mejorCliente);
    }
}
