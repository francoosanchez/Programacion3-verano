package org.example.clase5;

import java.util.*;

public class Actividad2 {
    public static class Comprobante {
        private String descripcion;
        private int valor;

        public Comprobante(String descripcion, int valor) {
            this.descripcion = descripcion;
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }

        @Override
        public String toString() {
            return descripcion + " (" + valor + ")";
        }
    }

    public static List<Comprobante> seleccionarComprobantes(List<Comprobante> comprobantes, int montoObjetivo) {
        // Ordenamos los comprobantes de mayor a menor valor
        comprobantes.sort(Comparator.comparingInt(Comprobante::getValor).reversed());

        List<Comprobante> seleccionados = new ArrayList<>();
        int montoActual = 0;

        for (Comprobante comprobante : comprobantes) {
            if (montoActual + comprobante.getValor() <= montoObjetivo) {
                seleccionados.add(comprobante);
                montoActual += comprobante.getValor();
            }
            if (montoActual == montoObjetivo) break;
        }

        // Si no se pudo alcanzar el monto exacto, devolver lista vacía
        return (montoActual == montoObjetivo) ? seleccionados : Collections.emptyList();
    }

    public static void main(String[] args) {
        List<Comprobante> comprobantes = Arrays.asList(
                new Comprobante("Cheque", 100),
                new Comprobante("Billete 50", 50),
                new Comprobante("Billete 20", 20),
                new Comprobante("Moneda 10", 10),
                new Comprobante("Moneda 5", 5),
                new Comprobante("Moneda 1", 1)
        );
        int montoObjetivo = 126;

        List<Comprobante> resultado = seleccionarComprobantes(comprobantes, montoObjetivo);
        System.out.println("Comprobantes seleccionados: " + resultado);
    }
}
