package org.example.clase4;

import java.util.Arrays;
import java.util.List;

public class Actividad2 {
    public static int[] encontrarDosMaximos(List<Integer> numeros, int inicio, int fin) {
        // Caso base: Si hay solo un número, retornarlo dos veces
        if (inicio == fin) {
            return new int[]{numeros.get(inicio), Integer.MIN_VALUE};
        }

        // Caso base: Si hay dos números, ordenarlos y retornarlos
        if (fin - inicio == 1) {
            int max1 = Math.max(numeros.get(inicio), numeros.get(fin));
            int max2 = Math.min(numeros.get(inicio), numeros.get(fin));
            return new int[]{max1, max2};
        }

        // Dividir la lista en dos mitades
        int medio = (inicio + fin) / 2;

        // Encontrar los dos mayores en cada mitad
        int[] maxIzq = encontrarDosMaximos(numeros, inicio, medio);
        int[] maxDer = encontrarDosMaximos(numeros, medio + 1, fin);
        // Combinar los resultados para obtener los dos mayores
        return combinarMaximos(maxIzq, maxDer);
    }

    private static int[] combinarMaximos(int[] maxIzq, int[] maxDer) {
        int[] todos = {maxIzq[0], maxIzq[1], maxDer[0], maxDer[1]};
        Arrays.sort(todos); // Ordenamos el array de cuatro elementos
        return new int[]{todos[3], todos[2]}; // Retornamos los dos mayores
    }

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(12, 45, 7, 89, 56, 99, 34, 78);

        int[] resultado = encontrarDosMaximos(numeros, 0, numeros.size() - 1);

        System.out.println("Los dos números más grandes son: " + resultado[0] + " y " + resultado[1]);
    }
}
