package org.example.clase5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Actividad1 {

    public static List<Integer> darCambio(List<Integer> monedasDisponibles, int importe) {
        // Ordenamos las monedas en orden descendente para aplicar la estrategia greedy
        monedasDisponibles.sort(Comparator.reverseOrder());

        List<Integer> resultado = new ArrayList<>();
        int suma = 0;

        for (int i = 0; i < monedasDisponibles.size(); i++) {
            int moneda = monedasDisponibles.get(i);
            if (suma + moneda <= importe) {
                resultado.add(moneda);
                suma += moneda;
            }
            if (suma == importe) {
                return resultado;
            }
        }

        // Si no se pudo completar el importe exacto, lanzamos una excepción
        throw new IllegalArgumentException("No se puede dar cambio exacto con las monedas disponibles.");
    }

    public static void main(String[] args) {
        List<Integer> monedas = Arrays.asList(10,1,5,2,10,10,5,2,5,5,5,5,5,5,10);
        int importe = 33;

        try {
            List<Integer> cambio = darCambio(monedas, importe);
            System.out.println("Cambio: " + cambio);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
