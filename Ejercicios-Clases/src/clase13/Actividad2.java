package clase13;

import java.util.*;

class Grafo {
    private final Map<String, List<Arista>> adyacencia = new HashMap<>();

    // Agregar ciudad al grafo
    public void agregarCiudad(String ciudad) {
        adyacencia.putIfAbsent(ciudad, new ArrayList<>());
    }

    // Agregar una ruta con un costo
    public void agregarRuta(String origen, String destino, int costo) {
        adyacencia.get(origen).add(new Arista(destino, costo));
    }

    // Algoritmo UCS para encontrar la ruta más barata
    public void buscarRutaMasBarata(String origen, String destino) {
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(n -> n.costo));
        colaPrioridad.add(new Nodo(origen, 0, new ArrayList<>(List.of(origen))));

        Set<String> visitados = new HashSet<>();

        while (!colaPrioridad.isEmpty()) {
            Nodo actual = colaPrioridad.poll();
            String ciudadActual = actual.ciudad;
            int costoActual = actual.costo;
            List<String> rutaActual = actual.ruta;

            // Si llegamos al destino, imprimir la ruta y el costo
            if (ciudadActual.equals(destino)) {
                System.out.println("Ruta más barata: " + String.join(" -> ", rutaActual));
                System.out.println("Costo total: $" + costoActual);
                return;
            }

            // Marcar como visitado
            if (visitados.contains(ciudadActual)) continue;
            visitados.add(ciudadActual);

            // Explorar vecinos
            for (Arista arista : adyacencia.getOrDefault(ciudadActual, new ArrayList<>())) {
                if (!visitados.contains(arista.destino)) {
                    List<String> nuevaRuta = new ArrayList<>(rutaActual);
                    nuevaRuta.add(arista.destino);
                    colaPrioridad.add(new Nodo(arista.destino, costoActual + arista.costo, nuevaRuta));
                }
            }
        }
        System.out.println("No hay ruta disponible entre " + origen + " y " + destino);
    }
}

class Arista {
    String destino;
    int costo;

    public Arista(String destino, int costo) {
        this.destino = destino;
        this.costo = costo;
    }
}

class Nodo {
    String ciudad;
    int costo;
    List<String> ruta;

    public Nodo(String ciudad, int costo, List<String> ruta) {
        this.ciudad = ciudad;
        this.costo = costo;
        this.ruta = ruta;
    }
}

public class Actividad2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo grafo = new Grafo();

        // Agregar ciudades
        grafo.agregarCiudad("A");
        grafo.agregarCiudad("B");
        grafo.agregarCiudad("C");
        grafo.agregarCiudad("D");
        grafo.agregarCiudad("E");

        // Agregar rutas con costos
        grafo.agregarRuta("A", "B", 100);
        grafo.agregarRuta("A", "C", 300);
        grafo.agregarRuta("B", "C", 50);
        grafo.agregarRuta("B", "D", 200);
        grafo.agregarRuta("C", "D", 100);
        grafo.agregarRuta("D", "E", 150);
        grafo.agregarRuta("C", "E", 250);

        // Entrada del usuario
        System.out.print("Ingrese ciudad de origen: ");
        String origen = scanner.nextLine();

        System.out.print("Ingrese ciudad de destino: ");
        String destino = scanner.nextLine();

        // Buscar la ruta más barata
        grafo.buscarRutaMasBarata(origen, destino);
    }
}

