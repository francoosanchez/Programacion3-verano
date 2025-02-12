package org.example.clase11;

import java.util.*;

public class Actividad3 {


    private static final int SIZE = 4;

    public static void main(String[] args) {
        char[][] board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '.'; // Espacios vacíos
            }
        }

        List<char[][]> solutions = new ArrayList<>();
        placeComputers(board, 0, new boolean[SIZE], new boolean[SIZE], solutions);
        printSolutions(solutions);
    }

    private static void placeComputers(char[][] board, int row, boolean[] usedColsC, boolean[] usedColsP, List<char[][]> solutions) {
        if (row == SIZE) {
            placePrinters(board, 0, usedColsP, solutions);
            return;
        }

        for (int col = 0; col < SIZE; col++) {
            if (!usedColsC[col]) {
                board[row][col] = 'C';
                usedColsC[col] = true;
                placeComputers(board, row + 1, usedColsC, usedColsP, solutions);
                usedColsC[col] = false;
                board[row][col] = '.';
            }
        }
    }

    private static void placePrinters(char[][] board, int row, boolean[] usedColsP, List<char[][]> solutions) {
        if (row == SIZE) {
            solutions.add(copyBoard(board));
            return;
        }

        for (int col = 0; col < SIZE; col++) {
            if (!usedColsP[col] && board[row][col] == '.') {
                board[row][col] = 'P';
                usedColsP[col] = true;
                placePrinters(board, row + 1, usedColsP, solutions);
                usedColsP[col] = false;
                board[row][col] = '.';
            }
        }
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
