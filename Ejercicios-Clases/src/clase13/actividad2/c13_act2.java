package clase13.actividad2;

import java.util.*;

class Nodo implements Comparable<Nodo> {
    String ciudad;
    int costo;
    List<String> ruta;
    
    Nodo(String ciudad, int costo, List<String> ruta) {
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

class Grafo {
    private Map<String, List<Nodo>> adyacencias;
    
    public Grafo() {
        this.adyacencias = new HashMap<>();
    }
    
    public void agregarRuta(String origen, String destino, int costo) {
        this.adyacencias.putIfAbsent(origen, new ArrayList<>());
        this.adyacencias.get(origen).add(new Nodo(destino, costo, new ArrayList<>()));
    }
    
    public void buscarRutaMasBarata(String origen, String destino) {
        PriorityQueue<Nodo> pq = new PriorityQueue<>();
        pq.add(new Nodo(origen, 0, new ArrayList<>()));
        
        Set<String> visitados = new HashSet<>();
        
        while (!pq.isEmpty()) {
            Nodo actual = pq.poll();
            
            if (actual.ciudad.equals(destino)) {
                System.out.println("Costo mínimo: " + actual.costo);
                System.out.println("Itinerario: " + String.join(" -> ", actual.ruta));
                return;
            }
            
            if (!visitados.contains(actual.ciudad)) {
                visitados.add(actual.ciudad);
                
                for (Nodo vecino : adyacencias.getOrDefault(actual.ciudad, new ArrayList<>())) {
                    if (!visitados.contains(vecino.ciudad)) {
                        pq.add(new Nodo(vecino.ciudad, actual.costo + vecino.costo, actual.ruta));
                    }
                }
            }
        }
        System.out.println("No hay ruta disponible.");
    }
}

public class c13_act2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo grafo = new Grafo();
        
        grafo.agregarRuta("A", "B", 100);
        grafo.agregarRuta("A", "C", 200);
        grafo.agregarRuta("B", "D", 150);
        grafo.agregarRuta("C", "D", 100);
        grafo.agregarRuta("B", "E", 250);
        grafo.agregarRuta("D", "E", 100);
        
        System.out.print("Ingrese ciudad de origen: ");
        String origen = scanner.nextLine();
        System.out.print("Ingrese ciudad de destino: ");
        String destino = scanner.nextLine();
        
        grafo.buscarRutaMasBarata(origen, destino);
        scanner.close();
    }
}
