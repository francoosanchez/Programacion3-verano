package org.example.clase4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Actividad4 {

    public static List<Integer> encontrarNMayores(List<Integer> lista, int n) {
        return encontrarNMayores(lista, 0, lista.size() - 1, n);
    }

    private static List<Integer> encontrarNMayores(List<Integer> lista, int inicio, int fin, int n) {
        // Caso base: si la sublista tiene n o menos elementos, la ordenamos y devolvemos los mayores n
        if (fin - inicio + 1 <= n) {
            return lista.subList(inicio, fin + 1).stream()
                    .sorted((a, b) -> Integer.compare(b, a)) // Ordenar en orden descendente
                    .limit(n) // Tomar los n mayores
                    .collect(Collectors.toList());
        }

        // Dividir la lista en dos mitades
        int medio = (inicio + fin) / 2;

        // Obtener los n mayores de cada mitad
        List<Integer> mayoresIzq = encontrarNMayores(lista, inicio, medio, n);
        List<Integer> mayoresDer = encontrarNMayores(lista, medio + 1, fin, n);

        // Combinar los resultados y obtener los n mayores finales
        return combinarNMayores(mayoresIzq, mayoresDer, n);
    }

    private static List<Integer> combinarNMayores(List<Integer> izq, List<Integer> der, int n) {
        return Arrays.stream(
                        Arrays.copyOf(
                                Stream.concat(izq.stream(), der.stream())
                                        .sorted((a, b) -> Integer.compare(b, a)) // Orden descendente
                                        .toArray(Integer[]::new),
                                n // Limitar a los n mayores
                        ))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(12, 3, 45, 7, 23, 9, 89, 56, 77, 5, 34, 99);
        int n = 5;

        List<Integer> resultado = encontrarNMayores(lista, n);

        System.out.println("Los " + n + " mayores elementos son: " + resultado);
    }

}
