package org.example.clase11;

import java.util.*;

public class Actividad2 {
    private static final int SIZE = 4;

    private static void backtrack(char[][] board, int row, List<char[][]> solutions) {
        if (row == SIZE) {
            solutions.add(copyBoard(board)); // Se guarda una solución válida
            return;
        }

        for (int col = 0; col < SIZE; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'D'; // Colocar escritorio ('D' de Desk)
                backtrack(board, row + 1, solutions);
                board[row][col] = '.'; // Retroceder
            }
        }
    }

    private static boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'D') return false; // Verifica la columna
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

    public static void main(String[] args) {
        char[][] board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '.'; // Espacios vacíos
            }
        }

        List<char[][]> solutions = new ArrayList<>();
        backtrack(board, 0, solutions);

        printSolutions(solutions);
    }
}
