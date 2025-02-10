package org.example.clase7;

public class Actividad4 {
    public static int calcularMaximaGanancia(int[] costos, int[] ganancias, int presupuesto) {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        // Rellenamos la tabla dp
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                if (costos[i - 1] <= j) {
                    // Si el costo del paquete es menor o igual al presupuesto disponible
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costos[i - 1]] + ganancias[i - 1]);
                } else {
                    // No podemos incluir este paquete
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][presupuesto]; // La ganancia máxima estará en esta celda
    }

    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300};
        int presupuesto = 35;

        int gananciaMaxima = calcularMaximaGanancia(costos, ganancias, presupuesto);
        System.out.println("La ganancia máxima es: " + gananciaMaxima);
    }
}
