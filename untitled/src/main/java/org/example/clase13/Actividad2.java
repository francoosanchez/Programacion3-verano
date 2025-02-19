package org.example.clase13;
import java.util.*;
public class Actividad2 {

    public static class Nodo implements Comparable<Nodo> {
        String ciudad;
        int costo;
        List<String> ruta;

        public Nodo(String ciudad, int costo, List<String> ruta) {
            this.ciudad = ciudad;
            this.costo = costo;
            this.ruta = new ArrayList<>(ruta);
            this.ruta.add(ciudad);
        }

        @Override
        public int compareTo(Nodo otro) {
            return Integer.compare(this.costo, otro.costo);
        }
    }

    public static class Grafo {
        private final Map<String, List<Map.Entry<String, Integer>>> adyacencia;

        public Grafo() {
            this.adyacencia = new HashMap<>();
        }

        public void agregarRuta(String origen, String destino, int costo) {
            adyacencia.putIfAbsent(origen, new ArrayList<>());
            adyacencia.get(origen).add(new AbstractMap.SimpleEntry<>(destino, costo));
        }

        public List<String> encontrarRutaMasBarata(String origen, String destino) {
            PriorityQueue<Nodo> pq = new PriorityQueue<>();
            pq.add(new Nodo(origen, 0, new ArrayList<>())) ;
            Set<String> visitados = new HashSet<>();

            while (!pq.isEmpty()) {
                Nodo actual = pq.poll();
                if (actual.ciudad.equals(destino)) {
                    System.out.println("Costo mínimo: " + actual.costo);
                    return actual.ruta;
                }

                if (visitados.contains(actual.ciudad)) continue;
                visitados.add(actual.ciudad);

                for (Map.Entry<String, Integer> vecino : adyacencia.getOrDefault(actual.ciudad, Collections.emptyList())) {
                    if (!visitados.contains(vecino.getKey())) {
                        pq.add(new Nodo(vecino.getKey(), actual.costo + vecino.getValue(), actual.ruta));
                    }
                }
            }
            return Collections.emptyList();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo grafo = new Grafo();

        // Agregando rutas
        grafo.agregarRuta("A", "B", 100);
        grafo.agregarRuta("A", "C", 200);
        grafo.agregarRuta("B", "D", 150);
        grafo.agregarRuta("C", "D", 100);
        grafo.agregarRuta("B", "E", 250);
        grafo.agregarRuta("D", "E", 50);

        // Entrada de usuario
        System.out.print("Ingrese ciudad de origen: ");
        String origen = scanner.nextLine();
        System.out.print("Ingrese ciudad destino: ");
        String destino = scanner.nextLine();

        // Encontrar la ruta más barata
        List<String> ruta = grafo.encontrarRutaMasBarata(origen, destino);

        if (!ruta.isEmpty()) {
            System.out.println("Itinerario: " + String.join(" -> ", ruta));
        } else {
            System.out.println("No hay ruta disponible entre " + origen + " y " + destino);
        }
        scanner.close();
    }
}
