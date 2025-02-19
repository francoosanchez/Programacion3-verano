package clase15;

import java.util.*;

public class Actividad4 {
    static class Nodo {
        String nombre;
        double montoCripto; // + para cobros, - para pagos
        double volatilidad; // Factor de cambio (1 = sin cambio)

        Nodo(String nombre, double montoCripto, double volatilidad) {
            this.nombre = nombre;
            this.montoCripto = montoCripto;
            this.volatilidad = volatilidad;
        }

        double valorEnFiat(double tasaCambio) {
            return montoCripto * volatilidad * tasaCambio;
        }
    }

    public static void planificarRecorrido(List<Nodo> nodos, double saldoInicialFiat, double tasaCambio) {
        PriorityQueue<Nodo> cobrables = new PriorityQueue<>(
                (a, b) -> Double.compare(b.valorEnFiat(tasaCambio), a.valorEnFiat(tasaCambio))
        );
        PriorityQueue<Nodo> pagables = new PriorityQueue<>(
                Comparator.comparingDouble(a -> a.valorEnFiat(tasaCambio))
        );

        for (Nodo n : nodos) {
            if (n.montoCripto >= 0) {
                cobrables.offer(n);
            } else {
                pagables.offer(n);
            }
        }

        double saldoFiat = saldoInicialFiat;
        List<String> recorrido = new ArrayList<>();

        while (!cobrables.isEmpty() || !pagables.isEmpty()) {
            boolean visitado = false;

            while (!cobrables.isEmpty()) {
                Nodo n = cobrables.poll();
                double valorFiat = n.valorEnFiat(tasaCambio);
                saldoFiat += valorFiat;
                recorrido.add(n.nombre + " (Cobro: +" + String.format("%.2f", valorFiat) + " USD, Saldo: " + String.format("%.2f", saldoFiat) + ")");
                visitado = true;
            }

            Iterator<Nodo> it = pagables.iterator();
            while (it.hasNext()) {
                Nodo n = it.next();
                double valorFiat = Math.abs(n.valorEnFiat(tasaCambio));
                if (saldoFiat >= valorFiat) {
                    saldoFiat -= valorFiat;
                    recorrido.add(n.nombre + " (Pago: -" + String.format("%.2f", valorFiat) + " USD, Saldo: " + String.format("%.2f", saldoFiat) + ")");
                    it.remove();
                    visitado = true;
                }
            }

            if (!visitado) {
                System.out.println("No se puede continuar: saldo insuficiente para cubrir pagos restantes.");
                break;
            }
        }

        System.out.println("Recorrido planificado:");
        recorrido.forEach(System.out::println);
        System.out.println("Saldo final en USD: " + String.format("%.2f", saldoFiat));
    }

    public static void main(String[] args) {
        double tasaCambioInicial = 25000.0; // Valor inicial 1 cripto = 25,000 USD
        double saldoInicialFiat = 50000.0; // Saldo inicial en USD

        List<Nodo> nodos = Arrays.asList(
                new Nodo("Nodo A", 2.0, 1.05),   // Cobro con aumento del 5%
                new Nodo("Nodo B", -1.5, 0.95),  // Pago con disminución del 5%
                new Nodo("Nodo C", 1.0, 1.10),   // Cobro con aumento del 10%
                new Nodo("Nodo D", -0.5, 0.90),  // Pago con disminución del 10%
                new Nodo("Nodo E", 0.8, 1.02)    // Cobro con aumento del 2%
        );

        planificarRecorrido(nodos, saldoInicialFiat, tasaCambioInicial);
    }
}


