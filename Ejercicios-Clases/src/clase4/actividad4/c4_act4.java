package clase4.actividad4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Actividad 4
    
    Objetivo: Encontrar los "n" elementos más grandes en una lista utilizando la técnica de Divide y Vencerás
    Tareas:
    Resolver mediante pseudocódigo
    Realizar el análisis de recurrencia mediante método inductivo (sin utilizar fórmulas
    matemáticas) para indicar la complejidad algorítmica.
    Implementar en java 
 */

public class c4_act4 {
    public static List<Integer> nMayores(List<Integer> lista, int n) {
        if (lista.size() <= n) { // Caso base: Si la lista es menor o igual al tamaño n, retornarla ordenada
            lista.sort((a, b) -> b - a); // Ordenar de mayor a menor
            return lista;
        }
        if (lista.size() == 1) { // Caso base: si solo hay un elemento, retornarlo
            return lista;
        }

        // Dividimos la lista en dos partes
        int mitad = lista.size() / 2;
        List<Integer> izq = nMayores(lista.subList(0, mitad), n);
        List<Integer> der = nMayores(lista.subList(mitad, lista.size()), n);

        // Combinamos los resultados de ambas mitades
        List<Integer> combinada = combinar(izq, der, n); // O(n)
        
        return combinada;
    }

    // Método para combinar dos listas ordenadas, devolviendo los n mayores elementos
    public static List<Integer> combinar(List<Integer> izq, List<Integer> der, int n) {
        List<Integer> resultado = new ArrayList<>();
        int i = 0, j = 0;

        // Fusionamos ambas listas, comparando elementos
        while (i < izq.size() && j < der.size() && resultado.size() < n) {
            if (izq.get(i) > der.get(j)) {
                resultado.add(izq.get(i)); // O(1)
                i++;
            } else {
                resultado.add(der.get(j)); // O(1)
                j++;
            }
        }

        // Agregamos los elementos restantes de ambas listas
        while (i < izq.size() && resultado.size() < n) {
            resultado.add(izq.get(i)); // O(1)
            i++;
        }

        while (j < der.size() && resultado.size() < n) {
            resultado.add(der.get(j)); // O(1)
            j++;
        }

        return resultado; // O(n)
    }

    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(3, 10, 1, 23, 14, 7, 19, 8);
        int n = 3;

        List<Integer> resultado = nMayores(lista, n);
        System.out.println("Los " + n + " elementos más grandes son: " + resultado);
    }
}
