package org.example.clase15;

import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class Actividad4 {


    public static class Nodo {
        private String nombre;
        private double transaccion; // Puede ser positiva (cobro) o negativa (pago)
        private double valorEnDolares; // Valor de la criptomoneda en dólares

        public Nodo(String nombre, double transaccion, double valorEnDolares) {
            this.nombre = nombre;
            this.transaccion = transaccion;
            this.valorEnDolares = valorEnDolares;
        }

        public String getNombre() {
            return nombre;
        }

        public double getTransaccion() {
            return transaccion;
        }

        public double getValorEnDolares() {
            return valorEnDolares;
        }

        public double getValorTransaccionEnDolares() {
            return transaccion * valorEnDolares;
        }
    }


    public static class AgenteFinanciero {
        private double saldoBilletera;
        private double saldoDolares; // Saldo en dólares
        private List<Nodo> nodos;

        public AgenteFinanciero(double saldoBilletera, List<Nodo> nodos) {
            this.saldoBilletera = saldoBilletera;
            this.saldoDolares = saldoBilletera; // Consideramos inicialmente el saldo en criptomonedas como dólares
            this.nodos = nodos;
        }

        public void planificarRecorrido() {
            List<Nodo> recorrido = new ArrayList<>();
            Nodo nodoActual;

            while (!nodos.isEmpty()) {
                nodoActual = obtenerMejorNodo();

                if (nodoActual != null && saldoBilletera + nodoActual.getTransaccion() >= 0) {
                    saldoBilletera += nodoActual.getTransaccion();
                    saldoDolares += nodoActual.getValorTransaccionEnDolares();
                    recorrido.add(nodoActual);
                    nodos.remove(nodoActual);
                    System.out.println("Visitando nodo: " + nodoActual.getNombre() + " | Saldo en billetera: " + saldoBilletera + " | Saldo en dólares: " + saldoDolares);
                } else {
                    System.out.println("No se puede visitar el nodo: " + nodoActual.getNombre() + " debido a fondos insuficientes.");
                }
            }

            System.out.println("Recorrido completado. Saldo final en dólares: " + saldoDolares);
        }

        private Nodo obtenerMejorNodo() {
            Nodo mejorNodo = null;

            for (Nodo nodo : nodos) {
                if (mejorNodo == null || nodo.getValorTransaccionEnDolares() > mejorNodo.getValorTransaccionEnDolares()) {
                    mejorNodo = nodo;
                }
            }

            return mejorNodo;
        }
    }

    public static void main(String[] args) {
        List<Nodo> nodos = new ArrayList<>();
        nodos.add(new Nodo("Nodo 1", 100, 1.5));  // Cobro de 100 criptomonedas con valor de 1.5 USD
        nodos.add(new Nodo("Nodo 2", -50, 1.4));  // Pago de 50 criptomonedas con valor de 1.4 USD
        nodos.add(new Nodo("Nodo 3", 200, 1.6));  // Cobro de 200 criptomonedas con valor de 1.6 USD
        nodos.add(new Nodo("Nodo 4", -150, 1.3)); // Pago de 150 criptomonedas con valor de 1.3 USD

        AgenteFinanciero agente = new AgenteFinanciero(500, nodos); // Saldo inicial de 500 criptomonedas
        agente.planificarRecorrido();
    }


}
