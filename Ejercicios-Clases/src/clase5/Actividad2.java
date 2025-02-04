package clase5;

import java.util.*;

class Comprobante {
    int valor;

    public Comprobante(int valor) {
        this.valor = valor;
    }
}

public class Actividad2 {
    public static List<Integer> minimizarComprobantes(List<Integer> comprobantes, int importe) {
        // Ordenamos los comprobantes en orden descendente para minimizar la cantidad utilizada
        comprobantes.sort(Collections.reverseOrder());
        List<Integer> seleccionados = new ArrayList<>();
        int suma = 0;

        for (int comprobante : comprobantes) {
            if (suma + comprobante <= importe) {
                seleccionados.add(comprobante);
                suma += comprobante;
            }
            if (suma == importe) {
                return seleccionados;
            }
        }

        return new ArrayList<>(); // Si no se puede cubrir el importe exacto
    }

    public static void main(String[] args) {
        List<Integer> comprobantes = Arrays.asList(5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5);
        int importe = 3700;

        List<Integer> resultado = minimizarComprobantes(new ArrayList<>(comprobantes), importe);

        if (resultado.isEmpty()) {
            System.out.println("No se puede cubrir el importe exacto con los comprobantes disponibles.");
        } else {
            System.out.println("Comprobantes utilizados: " + resultado);
        }
    }
}

