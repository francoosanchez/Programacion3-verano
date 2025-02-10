package clase6.actividad3;

/*
    Actividad 3

    Diseño de una red de distribución eléctrica:
    Una empresa de energía necesita conectar varias estaciones eléctricas en una región para asegurar que toda la zona esté alimentada de manera eficiente. 
    Las estaciones están ubicadas en diferentes ciudades y los costos de instalación de las líneas eléctricas entre ellas varían según la distancia y el terreno.
    Tareas:
    - Representar el grafo utilizando una lista de adyacencia.
    - Aplicar el algoritmo de Prim para determinar el Árbol de Recubrimiento Mínimo.
    - Mostrar el conjunto de conexiones resultante y calcular el costo total.
*/

import java.util.*;

public class c6_act3 {

    static class RedElectrica {

        private List<List<int[]>> red;
        private int numEstaciones;

        // Constructor: inicializa la red de distribución
        RedElectrica(int numEstaciones) {
            this.numEstaciones = numEstaciones;
            red = new ArrayList<>(numEstaciones);
            for (int i = 0; i < numEstaciones; i++) {
                red.add(new ArrayList<>());
            }
        }

        // Método para agregar líneas eléctricas entre estaciones
        public void agregarLineaElectrica(int estacion1, int estacion2, int costo) {
            red.get(estacion1).add(new int[]{estacion2, costo});
            red.get(estacion2).add(new int[]{estacion1, costo});
        }

        // Método para calcular la red óptima de distribución (MST) usando Prim
        public int calcularRedOptima() {
            boolean[] conectado = new boolean[numEstaciones];
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            int costoTotal = 0;
            List<int[]> conexionesOptimas = new ArrayList<>(); // Lista de líneas eléctricas en la red óptima

            // Comenzamos desde la estación 0
            pq.add(new int[]{0, 0, -1}); // {estacion, costo, origen}

            while (!pq.isEmpty()) {
                int[] actual = pq.poll();
                int estacion = actual[0];
                int costo = actual[1];
                int origen = actual[2];

                if (conectado[estacion]) {
                    continue; // Si ya está conectada, ignorarla
                }
                conectado[estacion] = true;
                costoTotal += costo;

                // Guardar la conexión en la red óptima (evitamos la raíz -1)
                if (origen != -1) {
                    conexionesOptimas.add(new int[]{origen, estacion, costo});
                }

                for (int[] vecino : red.get(estacion)) {
                    int estacionVecina = vecino[0];
                    int costoVecino = vecino[1];

                    if (!conectado[estacionVecina]) {
                        pq.add(new int[]{estacionVecina, costoVecino, estacion});
                    }
                }
            }

            // Mostrar las conexiones de la red óptima
            System.out.println("Líneas eléctricas en la red óptima:");
            for (int[] conexion : conexionesOptimas) {
                System.out.println("Estación " + conexion[0] + " --- Estación " + conexion[1] + " (Costo: " + conexion[2] + ")");
            }

            return costoTotal;
        }
    }

    public static void main(String[] args) {
        RedElectrica red = new RedElectrica(6);

        red.agregarLineaElectrica(0, 1, 2);
        red.agregarLineaElectrica(0, 2, 7);
        red.agregarLineaElectrica(0, 3, 15);
        red.agregarLineaElectrica(0, 4, 4);
        red.agregarLineaElectrica(0, 5, 3);

        red.agregarLineaElectrica(1, 2, 3);
        red.agregarLineaElectrica(1, 4, 2);

        red.agregarLineaElectrica(2, 3, 6);
        red.agregarLineaElectrica(2, 5, 3);

        red.agregarLineaElectrica(3, 5, 1);
        red.agregarLineaElectrica(3, 4, 1);

        red.agregarLineaElectrica(4, 5, 3);

        int costoTotalMST = red.calcularRedOptima();
        System.out.println("Costo total mínimo de la red eléctrica: " + costoTotalMST);
    }
}

