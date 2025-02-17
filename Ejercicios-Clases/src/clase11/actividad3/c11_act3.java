package clase11.actividad3;

/*
    Actividad 3

    Diseño de Distribución de Equipos Electrónicos en Oficinas
    En una oficina de 4x4, se necesita organizar la disposición de computadoras y
    impresoras de manera que optimice el uso del espacio y facilite el acceso. Las
    restricciones de diseño son las siguientes:
    No puede haber dos computadoras en la misma fila o columna.
    No puede haber dos impresoras en la misma fila o columna.
    Debes encontrar todas las combinaciones posibles para colocar 4 computadoras y 4
    impresoras en el tablero, respetando las restricciones anteriores.
    Objetivo: Implementar un programa en Java que utilice la técnica de backtracking para
    encontrar todas las configuraciones posibles de colocación de computadoras e
    impresoras en el tablero de 4x4. Tu programa debe imprimir cada configuración válida.
 */

public class c11_act3 {
    static int N = 4;
    static char[][] oficina = new char[N][N];
    static boolean[] colComputadoras = new boolean[N];
    static boolean[] colImpresoras = new boolean[N];

    public static void main(String[] args) {
        inicializarOficina();
        backtracking(0, 0, 0, 0);
    }

    static void inicializarOficina() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                oficina[i][j] = '.'; // Espacios vacíos
            }
        }
    }

    static void backtracking(int fila, int col, int computadorasColocadas, int impresorasColocadas) {
        if (computadorasColocadas == 4 && impresorasColocadas == 4) { // Si se colocaron las 4 computadoras y 4 impresoras
            imprimirOficina();
            return;
        }

        if (fila >= N) {
            return;
        }

        if (col >= N) {
            backtracking(fila + 1, 0, computadorasColocadas, impresorasColocadas);
            return;
        }

        // Intentamos colocar una computadora
        if (computadorasColocadas < 4 && !colComputadoras[col]) {
            oficina[fila][col] = 'C';
            colComputadoras[col] = true;
            backtracking(fila + 1, 0, computadorasColocadas + 1, impresorasColocadas);
            oficina[fila][col] = '.';
            colComputadoras[col] = false;
        }

        // Intentamos colocar una impresora
        if (impresorasColocadas < 4 && !colImpresoras[col]) {
            oficina[fila][col] = 'I';
            colImpresoras[col] = true;
            backtracking(fila + 1, 0, computadorasColocadas, impresorasColocadas + 1);
            oficina[fila][col] = '.';
            colImpresoras[col] = false;
        }

        // Continuamos con la siguiente columna
        backtracking(fila, col + 1, computadorasColocadas, impresorasColocadas);
    }

    static void imprimirOficina() {
        System.out.println("\nConfiguración válida:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(oficina[i][j] + " ");
            }
            System.out.println();
        }
    }
}