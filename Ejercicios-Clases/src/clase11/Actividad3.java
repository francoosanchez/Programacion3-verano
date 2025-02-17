package clase11;

public class Actividad3 {
    static final int N = 4;

    public static void main(String[] args) {
        char[][] oficina = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                oficina[i][j] = '.';
            }
        }
        colocarComputadoras(oficina, 0);
    }

    private static void colocarComputadoras(char[][] oficina, int fila) {
        if (fila == N) {
            colocarImpresoras(oficina, 0);
            return;
        }

        for (int col = 0; col < N; col++) {
            if (esValido(oficina, fila, col, 'C')) {
                oficina[fila][col] = 'C';
                colocarComputadoras(oficina, fila + 1);
                oficina[fila][col] = '.'; // Backtracking
            }
        }
    }

    private static void colocarImpresoras(char[][] oficina, int fila) {
        if (fila == N) {
            imprimirOficina(oficina);
            return;
        }

        for (int col = 0; col < N; col++) {
            if (esValido(oficina, fila, col, 'P')) {
                oficina[fila][col] = 'P';
                colocarImpresoras(oficina, fila + 1);
                oficina[fila][col] = '.'; // Backtracking
            }
        }
    }

    private static boolean esValido(char[][] oficina, int fila, int col, char equipo) {
        for (int i = 0; i < N; i++) {
            if (oficina[fila][i] == equipo || oficina[i][col] == equipo) {
                return false;
            }
        }
        return true;
    }

    private static void imprimirOficina(char[][] oficina) {
        System.out.println("Solución:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(oficina[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


