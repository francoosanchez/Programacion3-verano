package clase15;

import java.util.*;

public class Actividad3 {
    static class Sucursal {
        String nombre;
        int monto; // + para cobros, - para pagos

        Sucursal(String nombre, int monto) {
            this.nombre = nombre;
            this.monto = monto;
        }
    }

    public static void planificarRecorrido(List<Sucursal> sucursales, int saldoInicial) {
        PriorityQueue<Sucursal> cobrables = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.monto, a.monto)); // Máximo primero
        PriorityQueue<Sucursal> pagables = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.monto)); // Pagos pequeños primero

        for (Sucursal s : sucursales) {
            if (s.monto >= 0) {
                cobrables.offer(s);
            } else {
                pagables.offer(s);
            }
        }

        List<String> recorrido = new ArrayList<>();
        int saldo = saldoInicial;

        while (!cobrables.isEmpty() || !pagables.isEmpty()) {
            boolean visitado = false;

            // Priorizar cobros
            while (!cobrables.isEmpty()) {
                Sucursal s = cobrables.poll();
                saldo += s.monto;
                recorrido.add(s.nombre + " (Cobro: +" + s.monto + ", Saldo: " + saldo + ")");
                visitado = true;
            }

            // Si no se puede cobrar más, pagar lo que se pueda
            Iterator<Sucursal> it = pagables.iterator();
            while (it.hasNext()) {
                Sucursal s = it.next();
                if (saldo + s.monto >= 0) { // Verificar saldo suficiente
                    saldo += s.monto;
                    recorrido.add(s.nombre + " (Pago: " + s.monto + ", Saldo: " + saldo + ")");
                    it.remove();
                    visitado = true;
                }
            }

            if (!visitado) {
                System.out.println("No se puede continuar sin saldo suficiente.");
                break;
            }
        }

        System.out.println("Recorrido planificado:");
        recorrido.forEach(System.out::println);
        System.out.println("Saldo final: " + saldo);
    }

    public static void main(String[] args) {
        List<Sucursal> sucursales = Arrays.asList(
                new Sucursal("Sucursal A", 500),
                new Sucursal("Sucursal B", -300),
                new Sucursal("Sucursal C", 200),
                new Sucursal("Sucursal D", -400),
                new Sucursal("Sucursal E", 100)
        );

        int saldoInicial = 300;
        planificarRecorrido(sucursales, saldoInicial);
    }
}


