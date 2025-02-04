package org.example.clase2;

import java.util.ArrayList;
import java.util.List;

public class Actividad3 {


    public static class Factura {
        int idFactura;
        int idCliente;
        double importe;

        public Factura(int idFactura, int idCliente, double importe) {
            this.idFactura = idFactura;
            this.idCliente = idCliente;
            this.importe = importe;
        }
    }

    public static class Cliente {
        int idCliente;
        String nombre;

        public Cliente(int idCliente, String nombre) {
            this.idCliente = idCliente;
            this.nombre = nombre;
        }
    }

    public static class ClienteTotal {
        int idCliente;
        String nombre;
        double totalImporte;

        public ClienteTotal(int idCliente, String nombre, double totalImporte) {
            this.idCliente = idCliente;
            this.nombre = nombre;
            this.totalImporte = totalImporte;
        }

        @Override
        public String toString() {
            return "Cliente: " + nombre + " (ID: " + idCliente + ") - Total: " + totalImporte;
        }
    }


    public static void main(String[] args) {
        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(1, 101, 100.5));
        facturas.add(new Factura(2, 102, 200.0));
        facturas.add(new Factura(3, 101, 50.5));
        facturas.add(new Factura(4, 103, 300.0));
        facturas.add(new Factura(5, 102, 150.0));

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(101, "Juan"));
        clientes.add(new Cliente(102, "Maria"));
        clientes.add(new Cliente(103, "Carlos"));

        List<ClienteTotal> resultado = new ArrayList<>();

        for (Cliente cliente : clientes) { // O(n)
            double suma = 0;
            for (Factura factura : facturas) { // O(m)
                if (factura.idCliente == cliente.idCliente) {
                    suma += factura.importe;
                }
            }
            resultado.add(new ClienteTotal(cliente.idCliente, cliente.nombre, suma)); // O(1)
        }

        // Imprimir resultados
        for (ClienteTotal ct : resultado) {
            System.out.println(ct);
        }
    }

}
