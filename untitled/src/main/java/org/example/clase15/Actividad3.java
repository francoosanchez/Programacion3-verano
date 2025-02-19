package org.example.clase15;

import java.util.*;

public class Actividad3 {
    public static class Sucursal {
        int id;
        int monto;

        public Sucursal(int id, int monto) {
            this.id = id;
            this.monto = monto;
        }
    }

    public static void main(String[] args) {
        List<Sucursal> sucursales = Arrays.asList(
                new Sucursal(1, 500),
                new Sucursal(2, -300),
                new Sucursal(3, 200),
                new Sucursal(4, -100),
                new Sucursal(5, 400),
                new Sucursal(6, -200)
        );

        int saldoInicial = 300;
        planificarRecorrido(sucursales, saldoInicial);
    }

    public static void planificarRecorrido(List<Sucursal> sucursales, int saldo) {
        List<Sucursal> pendientes = new ArrayList<>(sucursales);
        pendientes.sort(Comparator.comparingInt(s -> -s.monto)); // Ordenamos de mayor a menor cobro

        System.out.println("Saldo inicial: " + saldo);

        while (!pendientes.isEmpty()) {
            Sucursal mejorOpcion = null;
            for (Sucursal sucursal : pendientes) {
                if (sucursal.monto > 0 || saldo + sucursal.monto >= 0) {
                    mejorOpcion = sucursal;
                    break;
                }
            }

            if (mejorOpcion == null) {
                System.out.println("No hay más sucursales viables para visitar.");
                break;
            }

            saldo += mejorOpcion.monto;
            System.out.println("Visitando sucursal " + mejorOpcion.id + " (monto: " + mejorOpcion.monto + "), nuevo saldo: " + saldo);
            pendientes.remove(mejorOpcion);
        }
    }

}
