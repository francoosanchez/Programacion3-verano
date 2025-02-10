package clase6.actividad2;

/*
    Actividad 2

    Implementación de un c6_act2 en una Matriz de Adyacencia
    Objetivo: Implementar un c6_act2 utilizando una matriz de adyacencia en Java y realizar varias operaciones para manipular y consultar el c6_act2.
    Descripción del Problema:
    Dado un c6_act2 dirigido, tu tarea es implementar las siguientes operaciones utilizando una matriz de adyacencia:
    Operaciones: 
    - Inicialización del c6_act2
    - Agregar Arista
    - Eliminar Arista
    - Verificar Arista
    - Listar Adyacentes
    - Contar Grado de Entrada y Salida: Implementa métodos para contar el grado de salida (número de aristas que salen) y el grado de entrada (número de aristas que entran) de un vértice dado.
 */

public class c6_act2 {
    private int[][] matriz;
    private int numVertices;

    public c6_act2(int numVertices) {
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
        c6_act2 c6_act2 = new c6_act2(5);

        c6_act2.agregarArista(0, 1);
        c6_act2.agregarArista(1, 2);
        c6_act2.agregarArista(3, 4);

        // Verificar arista
        System.out.println("¿Existe arista entre 0 y 1? " + c6_act2.verificarArista(0, 1));

        // Listar adyacentes
        c6_act2.listarAdyacentes(1);

        // Contar grados
        System.out.println("Grado de salida de 1: " + c6_act2.gradoSalida(1));
        System.out.println("Grado de entrada de 2: " + c6_act2.gradoEntrada(2));

        // Eliminar arista
        c6_act2.eliminarArista(0, 1);
        System.out.println("¿Existe arista entre 0 y 1 después de eliminar? " + c6_act2.verificarArista(0, 1));
    }
}
