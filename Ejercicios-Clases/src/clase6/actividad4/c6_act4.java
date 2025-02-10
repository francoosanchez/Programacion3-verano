package clase6.actividad4;

/*
    Actividad 4

    Una empresa de logística tiene varios centros de distribución en diferentes ciudades de una región y necesita optimizar las rutas de entrega de sus camiones. 
    Cada centro de distribución está conectado a otros centros mediante carreteras, y cada carretera tiene un tiempo de viaje asociado en minutos. 
    La empresa desea minimizar el tiempo total de entrega desde su centro de distribución principal hasta todas las otras ciudades.
    Objetivo:
    Aplicar el algoritmo de Dijkstra para encontrar el tiempo mínimo de entrega desde el centro de distribución principal hasta los demás centros, considerando las
    diferentes rutas disponibles.
 */
import java.util.*;

class Dijkstra {
    static class Nodo {

        int ciudad;
        int tiempo;

        public Nodo(int ciudad, int tiempo) {
            this.ciudad = ciudad;
            this.tiempo = tiempo;
        }
    }

    public static void c6_act4(List<List<Nodo>> grafo, int origen) {
        int numCiudades = grafo.size();
        int[] tiemposMinimos = new int[numCiudades];  
        Arrays.fill(tiemposMinimos, Integer.MAX_VALUE);
        tiemposMinimos[origen] = 0;

        PriorityQueue<Nodo> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.tiempo));
        pq.add(new Nodo(origen, 0));

        while (!pq.isEmpty()) {
            Nodo actual = pq.poll();
            int ciudadActual = actual.ciudad;

            if (actual.tiempo > tiemposMinimos[ciudadActual]) {
                continue;
            }

            for (Nodo vecino : grafo.get(ciudadActual)) {
                int ciudadVecino = vecino.ciudad;
                int tiempoDeViaje = vecino.tiempo;

                if (tiemposMinimos[ciudadActual] + tiempoDeViaje < tiemposMinimos[ciudadVecino]) {
                    tiemposMinimos[ciudadVecino] = tiemposMinimos[ciudadActual] + tiempoDeViaje;
                    pq.add(new Nodo(ciudadVecino, tiemposMinimos[ciudadVecino]));
                }
            }
        }
        for (int i = 0; i < numCiudades; i++) {
            System.out.println("Tiempo mínimo desde el centro de distribución principal hasta la ciudad " + i + ": " + tiemposMinimos[i] + " minutos");
        }
    }

    public static void main(String[] args) {
        int numCiudades = 5; 
        List<List<Nodo>> grafo = new ArrayList<>();
        for (int i = 0; i < numCiudades; i++) {
            grafo.add(new ArrayList<>());
        }

        grafo.get(0).add(new Nodo(1, 10)); 
        grafo.get(0).add(new Nodo(2, 20)); 
        grafo.get(0).add(new Nodo(3, 30)); 

        grafo.get(1).add(new Nodo(0, 10)); 
        grafo.get(1).add(new Nodo(2, 5));  
        grafo.get(1).add(new Nodo(4, 10)); 

        grafo.get(2).add(new Nodo(0, 20)); 
        grafo.get(2).add(new Nodo(1, 5));  
        grafo.get(2).add(new Nodo(3, 10)); 

        grafo.get(3).add(new Nodo(0, 30)); 
        grafo.get(3).add(new Nodo(2, 10)); 
        grafo.get(3).add(new Nodo(4, 15)); 

        grafo.get(4).add(new Nodo(1, 10));
        grafo.get(4).add(new Nodo(3, 15));  

        // Llamamos al algoritmo de Dijkstra con el centro de distribución principal (ciudad 0)
        c6_act4(grafo, 0);
    }
}
