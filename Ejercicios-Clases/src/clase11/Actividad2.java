package clase11;

public class Actividad2 {
    static final int N = 4;

    public static void main(String[] args) {
        boolean[][] habitacion = new boolean[N][N];
        colocarMuebles(habitacion, 0, 0, 0);
    }

    private static void colocarMuebles(boolean[][] habitacion, int fila, int col, int colocados) {
        if (colocados == 2) {
            imprimirHabitacion(habitacion);
            return;
        }

        for (int i = fila; i < N; i++) {
            for (int j = (i == fila ? col : 0); j < N; j++) {
                if (esValido(habitacion, i, j)) {
                    habitacion[i][j] = true;
                    colocarMuebles(habitacion, i, j + 1, colocados + 1);
                    habitacion[i][j] = false; // Backtracking
                }
            }
        }
    }

    private static boolean esValido(boolean[][] habitacion, int fila, int col) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (habitacion[i][j]) {
                    if (i == fila || j == col) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void imprimirHabitacion(boolean[][] habitacion) {
        System.out.println("Solución:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(habitacion[i][j] ? "D " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


