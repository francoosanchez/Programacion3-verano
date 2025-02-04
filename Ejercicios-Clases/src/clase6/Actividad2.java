package clase6;

import java.util.ArrayList;
import java.util.List;

public class Actividad2 {
    private int[][] matriz;
    private int numVertices;

    public Actividad2(int numVertices) {
        this.numVertices = numVertices;
        this.matriz = new int[numVertices][numVertices];
    }

    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matriz[origen][destino] = 1;
        }
    }

    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matriz[origen][destino] = 0;
        }
    }

    public boolean verificarArista(int origen, int destino) {
        return origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices && matriz[origen][destino] == 1;
    }

    public List<Integer> listarAdyacentes(int vertice) {
        List<Integer> adyacentes = new ArrayList<>();
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matriz[vertice][i] == 1) {
                    adyacentes.add(i);
                }
            }
        }
        return adyacentes;
    }

    public int contarGradoSalida(int vertice) {
        int grado = 0;
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matriz[vertice][i] == 1) {
                    grado++;
                }
            }
        }
        return grado;
    }

    public int contarGradoEntrada(int vertice) {
        int grado = 0;
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matriz[i][vertice] == 1) {
                    grado++;
                }
            }
        }
        return grado;
    }

    public void imprimirMatriz() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Actividad2 grafo = new Actividad2(5);

        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(3, 4);

        System.out.println("Matriz de adyacencia:");
        grafo.imprimirMatriz();

        System.out.println("Lista de adyacentes de 0: " + grafo.listarAdyacentes(0));
        System.out.println("Grado de salida de 0: " + grafo.contarGradoSalida(0));
        System.out.println("Grado de entrada de 3: " + grafo.contarGradoEntrada(3));
    }
}



