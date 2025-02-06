package org.example.clase3;

import java.util.Arrays;

public class Actividad4 {
    // Método principal que ordena el arreglo
    public static void mergeSort(int[] arreglo) {
        if (arreglo.length < 2) {
            return; // Si el arreglo tiene 0 o 1 elementos, ya está ordenado
        }
        int medio = arreglo.length / 2;

        // Dividir el arreglo en dos mitades
        int[] izquierda = Arrays.copyOfRange(arreglo, 0, medio);
        int[] derecha = Arrays.copyOfRange(arreglo, medio, arreglo.length);

        // Llamadas recursivas para ordenar las mitades
        mergeSort(izquierda);
        mergeSort(derecha);

        // Mezclar las mitades ordenadas
        merge(arreglo, izquierda, derecha);
    }

    // Método para mezclar dos mitades ordenadas
    private static void merge(int[] arreglo, int[] izquierda, int[] derecha) {
        int i = 0, j = 0, k = 0;

        // Mezclar los elementos en orden
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                arreglo[k++] = izquierda[i++];
            } else {
                arreglo[k++] = derecha[j++];
            }
        }

        // Copiar los elementos restantes de la mitad izquierda
        while (i < izquierda.length) {
            arreglo[k++] = izquierda[i++];
        }

        // Copiar los elementos restantes de la mitad derecha
        while (j < derecha.length) {
            arreglo[k++] = derecha[j++];
        }
    }

    public static void main(String[] args) {
        int[] arreglo = {9, 3, 7, 5, 6, 2, 8}; // Array desordenado
        System.out.println("Array antes de ordenar: " + Arrays.toString(arreglo));

        mergeSort(arreglo); // Ordenar el array con Merge Sort

        System.out.println("Array después de ordenar: " + Arrays.toString(arreglo));
    }
}
