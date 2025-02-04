package clase6;

import java.util.*;

class Nodo implements Comparable<Nodo> {
    int ciudad;
    int tiempo;

    public Nodo(int ciudad, int tiempo) {
        this.ciudad = ciudad;
        this.tiempo = tiempo;
    }

    public int compareTo(Nodo otro) {
        return Integer.compare(this.tiempo, otro.tiempo);
    }
}

public class Actividad4 {

    public static int[] dijkstra(Map<Integer, List<Nodo>> grafo, int inicio, int numCiudades) {
        PriorityQueue<Nodo> pq = new PriorityQueue<>();
        int[] tiempos = new int[numCiudades];
        Arrays.fill(tiempos, Integer.MAX_VALUE);
        tiempos[inicio] = 0;
        pq.add(new Nodo(inicio, 0));

        while (!pq.isEmpty()) {
            Nodo actual = pq.poll();
            int ciudadActual = actual.ciudad;
            int tiempoActual = actual.tiempo;

            if (tiempoActual > tiempos[ciudadActual]) continue;

            for (Nodo vecino : grafo.getOrDefault(ciudadActual, new ArrayList<>())) {
                int nuevoTiempo = tiempoActual + vecino.tiempo;
                if (nuevoTiempo < tiempos[vecino.ciudad]) {
                    tiempos[vecino.ciudad] = nuevoTiempo;
                    pq.add(new Nodo(vecino.ciudad, nuevoTiempo));
                }
            }
        }
        return tiempos;
    }

    public static void main(String[] args) {
        Map<Integer, List<Nodo>> grafo = new HashMap<>();
        int numCiudades = 5;

        grafo.put(0, Arrays.asList(new Nodo(1, 10), new Nodo(2, 5)));
        grafo.put(1, Arrays.asList(new Nodo(2, 2), new Nodo(3, 1)));
        grafo.put(2, Arrays.asList(new Nodo(1, 3), new Nodo(3, 9), new Nodo(4, 2)));
        grafo.put(3, Arrays.asList(new Nodo(4, 4)));
        grafo.put(4, Arrays.asList(new Nodo(3, 6)));

        int inicio = 0;
        int[] tiemposMinimos = dijkstra(grafo, inicio, numCiudades);

        System.out.println("Tiempo mínimo de entrega desde la ciudad " + inicio + ":");
        for (int i = 0; i < tiemposMinimos.length; i++) {
            System.out.println("Ciudad " + i + ": " + tiemposMinimos[i] + " minutos");
        }
    }
}
