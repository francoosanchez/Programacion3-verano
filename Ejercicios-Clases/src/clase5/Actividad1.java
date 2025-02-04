package clase5;

import java.util.*;

public class Actividad1 {
    public static List<Integer> obtenerCambio(List<Integer> monedas, int importe) {
        // Ordenamos las monedas en orden descendente para priorizar las de mayor valor
        monedas.sort(Collections.reverseOrder());
        List<Integer> cambio = new ArrayList<>();
        int suma = 0;

        for (int moneda : monedas) {
            if (suma + moneda <= importe) {
                cambio.add(moneda);
                suma += moneda;
            }
            if (suma == importe) {
                return cambio;
            }
        }

        return new ArrayList<>(); // Si no se puede dar el cambio exacto
    }

    public static void main(String[] args) {
        List<Integer> monedas = Arrays.asList(10, 1, 5, 2, 10, 10, 5, 2, 5, 5, 5, 5, 5, 10);
        int importe = 33;

        List<Integer> resultado = obtenerCambio(new ArrayList<>(monedas), importe);

        if (resultado.isEmpty()) {
            System.out.println("No se puede dar el cambio exacto.");
        } else {
            System.out.println("Cambio entregado: " + resultado);
        }
    }
}



