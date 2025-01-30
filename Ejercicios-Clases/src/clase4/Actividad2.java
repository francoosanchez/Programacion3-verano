package clase4;

import java.util.*;

public class Actividad2 {
    public static int[] encontrarDosMayores(List<Integer> numeros, int inicio, int fin) {
        if (inicio == fin) {
            return new int[]{numeros.get(inicio), Integer.MIN_VALUE};
        }

        int medio = (inicio + fin) / 2;
        int[] mayoresIzquierda = encontrarDosMayores(numeros, inicio, medio);
        int[] mayoresDerecha = encontrarDosMayores(numeros, medio + 1, fin);

        return combinarDosMayores(mayoresIzquierda, mayoresDerecha);
    }

    private static int[] combinarDosMayores(int[] izq, int[] der) {
        int[] mayores = new int[2];

        List<Integer> lista = new ArrayList<>();
        lista.add(izq[0]);
        lista.add(izq[1]);
        lista.add(der[0]);
        lista.add(der[1]);

        lista.sort(Collections.reverseOrder());

        mayores[0] = lista.get(0);
        mayores[1] = lista.get(1);

        return mayores;
    }

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, 45, 23, 89, 56, 78, 12, 90, 34);
        int[] resultado = encontrarDosMayores(numeros, 0, numeros.size() - 1);
        System.out.println("Los dos numeros mayores son: " + resultado[0] + " y " + resultado[1]);
    }
}


