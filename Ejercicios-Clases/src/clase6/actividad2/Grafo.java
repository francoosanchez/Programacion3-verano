package clase6.actividad2;

public class Grafo {
    private int[][] matriz;
    private int numVertices;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.matriz = new int[numVertices][numVertices];
    }

    // Agregar arista
    public void agregarArista(int u, int v) {
        matriz[u][v] = 1;
    }

    // Eliminar arista
    public void eliminarArista(int u, int v) {
        matriz[u][v] = 0;
    }

    // Verificar arista
    public boolean verificarArista(int u, int v) {
        return matriz[u][v] == 1;
    }

    // Listar adyacentes
    public void listarAdyacentes(int u) {
        for (int v = 0; v < numVertices; v++) {
            if (matriz[u][v] == 1) {
                System.out.print(v + " ");
            }
        }
        System.out.println();
    }

    // Contar grado de salida
    public int gradoSalida(int u) {
        int grado = 0;
        for (int v = 0; v < numVertices; v++) {
            if (matriz[u][v] == 1) {
                grado++;
            }
        }
        return grado;
    }

    // Contar grado de entrada
    public int gradoEntrada(int v) {
        int grado = 0;
        for (int u = 0; u < numVertices; u++) {
            if (matriz[u][v] == 1) {
                grado++;
            }
        }
        return grado;
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(5); // Grafo con 5 vértices

        grafo.agregarArista(0, 1);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(3, 4);

        // Verificar arista
        System.out.println("¿Existe arista entre 0 y 1? " + grafo.verificarArista(0, 1));

        // Listar adyacentes
        grafo.listarAdyacentes(1);

        // Contar grados
        System.out.println("Grado de salida de 1: " + grafo.gradoSalida(1));
        System.out.println("Grado de entrada de 2: " + grafo.gradoEntrada(2));

        // Eliminar arista
        grafo.eliminarArista(0, 1);
        System.out.println("¿Existe arista entre 0 y 1 después de eliminar? " + grafo.verificarArista(0, 1));
    }
}
