package org.example.clase6;

public class Actividad2 {

    public static class Grafo {
        private int[][] matrizAdyacencia;
        private int numVertices;

        // Constructor para inicializar el grafo
        public Grafo(int numVertices) {
            this.numVertices = numVertices;
            this.matrizAdyacencia = new int[numVertices][numVertices];
        }

        // Agregar una arista entre el vértice origen y el vértice destino
        public void agregarArista(int origen, int destino) {
            if (origen < 0 || origen >= numVertices || destino < 0 || destino >= numVertices) {
                System.out.println("Indices fuera de rango");
                return;
            }
            matrizAdyacencia[origen][destino] = 1;
        }

        // Eliminar una arista entre el vértice origen y el vértice destino
        public void eliminarArista(int origen, int destino) {
            if (origen < 0 || origen >= numVertices || destino < 0 || destino >= numVertices) {
                System.out.println("Indices fuera de rango");
                return;
            }
            matrizAdyacencia[origen][destino] = 0;
        }

        // Verificar si existe una arista entre el vértice origen y el vértice destino
        public boolean verificarArista(int origen, int destino) {
            if (origen < 0 || origen >= numVertices || destino < 0 || destino >= numVertices) {
                System.out.println("Indices fuera de rango");
                return false;
            }
            return matrizAdyacencia[origen][destino] == 1;
        }

        // Listar los vértices adyacentes a un vértice dado
        public void listarAdyacentes(int vertice) {
            if (vertice < 0 || vertice >= numVertices) {
                System.out.println("Indice fuera de rango");
                return;
            }
            System.out.print("Vértices adyacentes a " + vertice + ": ");
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }

        // Contar el grado de salida de un vértice (número de aristas que salen)
        public int contarGradoSalida(int vertice) {
            if (vertice < 0 || vertice >= numVertices) {
                System.out.println("Indice fuera de rango");
                return -1;
            }
            int gradoSalida = 0;
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    gradoSalida++;
                }
            }
            return gradoSalida;
        }

        // Contar el grado de entrada de un vértice (número de aristas que entran)
        public int contarGradoEntrada(int vertice) {
            if (vertice < 0 || vertice >= numVertices) {
                System.out.println("Indice fuera de rango");
                return -1;
            }
            int gradoEntrada = 0;
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[i][vertice] == 1) {
                    gradoEntrada++;
                }
            }
            return gradoEntrada;
        }

        // Mostrar la matriz de adyacencia (opcional)
        public void mostrarMatrizAdyacencia() {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    System.out.print(matrizAdyacencia[i][j] + " ");
                }
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        // Crear un grafo con 5 vértices
        Grafo grafo = new Grafo(5);

        // Agregar algunas aristas
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 4);

        // Mostrar la matriz de adyacencia
        System.out.println("Matriz de Adyacencia:");
        grafo.mostrarMatrizAdyacencia();

        // Verificar aristas
        System.out.println("¿Existe arista de 0 a 1? " + grafo.verificarArista(0, 1));
        System.out.println("¿Existe arista de 1 a 4? " + grafo.verificarArista(1, 4));

        // Listar adyacentes
        grafo.listarAdyacentes(0);
        grafo.listarAdyacentes(1);

        // Contar grado de entrada y salida
        System.out.println("Grado de salida de 0: " + grafo.contarGradoSalida(0));
        System.out.println("Grado de entrada de 3: " + grafo.contarGradoEntrada(3));

        // Eliminar una arista
        grafo.eliminarArista(0, 2);
        System.out.println("Matriz de Adyacencia después de eliminar arista (0, 2):");
        grafo.mostrarMatrizAdyacencia();
    }

}
