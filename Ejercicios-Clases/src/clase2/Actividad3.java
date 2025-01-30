package clase2;

import java.util.*;

class Factura {
    int idFactura;
    int idCliente;
    double importe;

    public Factura(int idFactura, int idCliente, double importe) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.importe = importe;
    }
}

class Cliente {
    int idCliente;
    String nombre;

    public Cliente(int idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
    }
}

public class Actividad3 {
    // Implementación con Map
    public static List<String> generarResumenConMap(List<Factura> facturas, List<Cliente> clientes) {
        Map<Integer, Double> sumaImportes = new HashMap<>();

        for (Factura factura : facturas) {
            sumaImportes.put(factura.idCliente, sumaImportes.getOrDefault(factura.idCliente, 0.0) + factura.importe);
        }

        List<String> resultado = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (sumaImportes.containsKey(cliente.idCliente)) {
                resultado.add("ID Cliente: " + cliente.idCliente + ", Nombre: " + cliente.nombre + ", Total: " + sumaImportes.get(cliente.idCliente));
            }
        }
        return resultado;
    }

    // Implementación sin Map
    public static List<String> generarResumenSinMap(List<Factura> facturas, List<Cliente> clientes) {
        List<String> resultado = new ArrayList<>();

        for (Cliente cliente : clientes) {
            double total = 0.0;
            for (Factura factura : facturas) {
                if (factura.idCliente == cliente.idCliente) {
                    total += factura.importe;
                }
            }
            if (total > 0) {
                resultado.add("ID Cliente: " + cliente.idCliente + ", Nombre: " + cliente.nombre + ", Total: " + total);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        List<Factura> facturas = Arrays.asList(
                new Factura(1, 101, 200.5),
                new Factura(2, 102, 150.75),
                new Factura(3, 101, 99.25),
                new Factura(4, 103, 300.0),
                new Factura(5, 102, 50.5)
        );

        List<Cliente> clientes = Arrays.asList(
                new Cliente(101, "Juan Perez"),
                new Cliente(102, "Ana Gomez"),
                new Cliente(103, "Carlos Ruiz"),
                new Cliente(104, "Beatriz Lopez")
        );

        System.out.println("Resumen con Map:");
        for (String resumen : generarResumenConMap(facturas, clientes)) {
            System.out.println(resumen);
        }

        System.out.println("\nResumen sin Map:");
        for (String resumen : generarResumenSinMap(facturas, clientes)) {
            System.out.println(resumen);
        }
    }
}


