package clase4.actividad3;

import java.util.*;

public class c4_act3 {

    static class Cliente {
        int idCliente;
        String nombre;
        int scoring;

        public Cliente(int idCliente, String nombre, int scoring) {
            this.idCliente = idCliente;
            this.nombre = nombre;
            this.scoring = scoring;
        }

        @Override
        public String toString() {
            return nombre + " (ID: " + idCliente + ", Scoring: " + scoring + ")";
        }
    }

    public static Cliente[] encontrarDosMayores(List<Cliente> clientes, int inicio, int fin) {
        if (inicio == fin) { // Caso base: solo queda un elemento
            return new Cliente[]{clientes.get(inicio), new Cliente(-1, "Sin cliente", Integer.MIN_VALUE)};
        }
        
        if (fin - inicio == 1) { // Caso base: dos elementos
            Cliente c1 = clientes.get(inicio);
            Cliente c2 = clientes.get(fin);

            return c1.scoring > c2.scoring ? new Cliente[]{c1, c2} : new Cliente[]{c2, c1};
        }

        int mitad = (inicio + fin) / 2;

        Cliente[] izq = encontrarDosMayores(clientes, inicio, mitad);
        Cliente[] der = encontrarDosMayores(clientes, mitad + 1, fin);

        Cliente mayorGlobal = izq[0].scoring > der[0].scoring ? izq[0] : der[0];
        Cliente segundoMayorGlobal;

        if (mayorGlobal == izq[0]) {
            segundoMayorGlobal = izq[1].scoring > der[0].scoring ? izq[1] : der[0];
        } else {
            segundoMayorGlobal = der[1].scoring > izq[0].scoring ? der[1] : izq[0];
        }

        return new Cliente[]{mayorGlobal, segundoMayorGlobal};
    }

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Cliente A", 85));
        clientes.add(new Cliente(2, "Cliente B", 70));
        clientes.add(new Cliente(3, "Cliente C", 95));
        clientes.add(new Cliente(4, "Cliente D", 60));
        clientes.add(new Cliente(5, "Cliente E", 90));

        Cliente[] result = encontrarDosMayores(clientes, 0, clientes.size() - 1);

        System.out.println("Los dos clientes con los mayores scorings son: ");
        System.out.println("Mayor scoring: " + result[0]);
        System.out.println("Segundo mayor scoring: " + result[1]);
    }
}
