package clase14;

public class Actividad2 {
    private static final int SIZE = 6; // Tamaño del tablero 6x6

    public static void printBoard(int[][] board) {
        for (int i = 0; i < SIZE; i++) {
            if (i % 2 == 0 && i != 0) {
                System.out.println("- - - - - - - - - - -");
            }
            for (int j = 0; j < SIZE; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isValid(int[][] board, int num, int row, int col) {
        // Verificar fila
        for (int j = 0; j < SIZE; j++) {
            if (board[row][j] == num) return false;
        }

        // Verificar columna
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) return false;
        }

        // Verificar subcuadrante 2x3
        int boxRow = (row / 2) * 2;
        int boxCol = (col / 3) * 3;
        for (int i = boxRow; i < boxRow + 2; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }

    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(board, num, row, col)) {
                            board[row][col] = num;

                            if (solveSudoku(board)) return true;
                            board[row][col] = 0; // Retroceder
                        }
                    }
                    return false; // No se pudo colocar un número válido
                }
            }
        }
        return true; // Solución encontrada
    }

    public static void main(String[] args) {
        int[][] sudokuBoard = {
                {0, 0, 0, 0, 6, 0},
                {0, 0, 1, 0, 0, 4},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 5, 0, 0},
                {3, 0, 0, 0, 0, 0},
                {0, 6, 0, 0, 0, 0}
        };

        System.out.println("Sudoku inicial:");
        printBoard(sudokuBoard);

        if (solveSudoku(sudokuBoard)) {
            System.out.println("\nSudoku resuelto:");
            printBoard(sudokuBoard);
        } else {
            System.out.println("No se encontró solución.");
        }
    }
}


