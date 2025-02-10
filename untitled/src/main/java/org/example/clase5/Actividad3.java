package org.example.clase5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Actividad3 {
    public static class Mercancia {
        private String descripcion;
        private double peso;
        private double valor;

        public Mercancia(String descripcion, double peso, double valor) {
            this.descripcion = descripcion;
            this.peso = peso;
            this.valor = valor;
        }

        public double getPeso() {
            return peso;
        }

        public double getValor() {
            return valor;
        }

        public double getValorPorPeso() {
            return valor / peso;
        }

        @Override
        public String toString() {
            return descripcion + " (Peso: " + peso + ", Valor: " + valor + ")";
        }
    }

    public static List<String> cargarCamion(List<Mercancia> mercancias, double capacidadCamion) {
        // Ordenar por valor por unidad de peso en orden descendente
        mercancias.sort(Comparator.comparingDouble(Mercancia::getValorPorPeso).reversed());

        List<String> seleccionados = new ArrayList<>();
        double pesoActual = 0;

        for (Mercancia mercancia : mercancias) {
            if (pesoActual + mercancia.getPeso() <= capacidadCamion) {
                seleccionados.add(mercancia.toString());
                pesoActual += mercancia.getPeso();
            } else {
                double pesoRestante = capacidadCamion - pesoActual;
                double fraccion = pesoRestante / mercancia.getPeso();
                seleccionados.add(mercancia.descripcion + " (Fracción: " + fraccion + ")");
                pesoActual = capacidadCamion;
                break;
            }
        }

        return seleccionados;
    }


    public static void main(String[] args) {
        List<Mercancia> mercancias = Arrays.asList(
                new Mercancia("Oro", 10, 5000),
                new Mercancia("Plata", 20, 3000),
                new Mercancia("Cobre", 30, 1000)
        );
        double capacidadCamion = 25;

        List<String> resultado = cargarCamion(mercancias, capacidadCamion);
        System.out.println("Mercancías cargadas: " + resultado);
    }
}
