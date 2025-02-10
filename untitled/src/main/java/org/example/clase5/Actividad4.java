package org.example.clase5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


// corre en java 8
public class Actividad4 {

    // Complete the getMinimumCost function below.
    public static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int totalCost = 0;
        int comprasPrevias = 0;
        int n = c.length;

        for (int i = n - 1; i >= 0; i--) {
            totalCost += (comprasPrevias / k + 1) * c[i];
            comprasPrevias++;
        }

        return totalCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];
        String[] cItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(cItems[i]);
        }

        int minimumCost = getMinimumCost(k, c);
        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();
    }


}
