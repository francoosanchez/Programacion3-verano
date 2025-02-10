package clase8.actividad2;

/*
    Actividad 2

    Una empresa de logística tiene varios centros de distribución en diferentes ciudades de una región y necesita optimizar las rutas de entrega de sus camiones. 
    Cada centro de distribución está conectado a otros centros mediante carreteras, y cada carretera tiene un tiempo de viaje asociado en minutos. 
    Además, algunos centros pueden tener costos adicionales asociados que pueden resultar en tiempos negativos en algunas rutas debido a descuentos especiales
    o condiciones excepcionales. 
    La empresa desea no solo minimizar el tiempo total de entrega desde su centro de distribución principal hasta todas las otras ciudades, sino también
    identificar si existen ciclos negativos que podrían llevar a oportunidades de ahorro infinito en el sistema de rutas.
    Objetivo:
    Aplicar el algoritmo de Floyd-Warshall para: Encontrar el tiempo mínimo de entrega desde el centro de distribución principal hasta todos los demás centros de distribución,
    considerando las diferentes rutas disponibles.
 */

 public class c8_act2 {
     final static int INF = 99999; // Representación de infinito
     
     public static void main(String[] args) {
         c8_act2 fw = new c8_act2();
         int graph[][] = {
                 {0, 2, INF, 5},
                 {INF, 0, INF, 4},
                 {INF, INF, 0, INF},
                 {INF, INF, 2, 0}
         };
         int V = graph.length;
         fw.floydWarshall(graph, V);
     }
     
     void floydWarshall(int graph[][], int V) {
         int dist[][] = new int[V][V];
         
         // Inicializar la matriz de distancias
         for (int i = 0; i < V; i++) {
             for (int j = 0; j < V; j++) {
                 dist[i][j] = graph[i][j];
             }
         }
         
         // Aplicación del algoritmo de Floyd-Warshall
         for (int k = 0; k < V; k++) {
             for (int i = 0; i < V; i++) {
                 for (int j = 0; j < V; j++) {
                     if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                         dist[i][j] = dist[i][k] + dist[k][j];
                     }
                 }
             }
         }
         
         // Comprobación de ciclos negativos
         for (int i = 0; i < V; i++) {
             if (dist[i][i] < 0) {
                 System.out.println("El sistema de rutas contiene un ciclo negativo.");
                 return;
             }
         }
         
         // Imprimir la matriz de distancias
         printSolution(dist, V);
     }
     
     void printSolution(int dist[][], int V) {
         System.out.println("Matriz de tiempos mínimos entre cada par de centros de distribución:");
         for (int i = 0; i < V; i++) {
             for (int j = 0; j < V; j++) {
                 if (dist[i][j] == INF)
                     System.out.print("INF ");
                 else
                     System.out.print(dist[i][j] + "   ");
             }
             System.out.println();
         }
     }
 }
 
