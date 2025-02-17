package clase11;

public class Actividad1 {
    static final int N = 4;

    public static void main(String[] args) {
        boolean[][] tablero = new boolean[N][N];
        colocarReinas(tablero, 0, 0, 0);
    }

    private static void colocarReinas(boolean[][] tablero, int fila, int col, int colocadas) {
        if (colocadas == 2) {
            imprimirTablero(tablero);
            return;
        }

        for (int i = fila; i < N; i++) {
            for (int j = (i == fila ? col : 0); j < N; j++) {
                if (esValido(tablero, i, j)) {
                    tablero[i][j] = true;
                    colocarReinas(tablero, i, j + 1, colocadas + 1);
                    tablero[i][j] = false; // Backtracking
                }
            }
        }
    }

    private static boolean esValido(boolean[][] tablero, int fila, int col) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j]) {
                    if (i == fila || j == col || Math.abs(i - fila) == Math.abs(j - col)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void imprimirTablero(boolean[][] tablero) {
        System.out.println("Solución:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

