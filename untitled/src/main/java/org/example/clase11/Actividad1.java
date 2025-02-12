package org.example.clase11;

import java.util.*;

public class Actividad1 {
    private static final int SIZE = 4; // Tamaño del tablero 4x4

    public static void main(String[] args) {
        char[][] board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '.'; // Espacios vacíos
            }
        }

        List<char[][]> solutions = new ArrayList<>();
        backtrack(board, 0, 0, 2, solutions);

        printSolutions(solutions);
    }

    private static void backtrack(char[][] board, int row, int col, int queensLeft, List<char[][]> solutions) {
        if (queensLeft == 0) {
            solutions.add(copyBoard(board)); // Se guarda una solución válida
            return;
        }

        for (int i = row; i < SIZE; i++) {
            for (int j = (i == row ? col : 0); j < SIZE; j++) {
                if (isValid(board, i, j)) {
                    board[i][j] = 'Q'; // Colocar reina
                    backtrack(board, i, j + 1, queensLeft - 1, solutions);
                    board[i][j] = '.'; // Retroceder
                }
            }
        }
    }

    private static boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == 'Q' || board[row][i] == 'Q') return false;
        }

        for (int i = -SIZE; i < SIZE; i++) {
            if (row + i >= 0 && row + i < SIZE && col + i >= 0 && col + i < SIZE && board[row + i][col + i] == 'Q')
                return false;
            if (row + i >= 0 && row + i < SIZE && col - i >= 0 && col - i < SIZE && board[row + i][col - i] == 'Q')
                return false;
        }
        return true;
    }

    private static char[][] copyBoard(char[][] board) {
        char[][] copy = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, SIZE);
        }
        return copy;
    }

    private static void printSolutions(List<char[][]> solutions) {
        for (char[][] solution : solutions) {
            for (char[] row : solution) {
                System.out.println(new String(row));
            }
            System.out.println();
        }
    }
}
