package clase7;

public class Actividad3 {

    // Función que implementa el algoritmo de la mochila
    public static int knapsack(int[] costs, int[] benefits, int budget) {
        int n = costs.length;

        // Inicializamos la tabla dp
        int[][] dp = new int[n + 1][budget + 1];

        // Llenamos la tabla dp
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= budget; j++) {
                if (costs[i - 1] <= j) {
                    // Elegimos entre no tomar el proyecto o tomarlo
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costs[i - 1]] + benefits[i - 1]);
                } else {
                    // No podemos tomar el proyecto
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // El valor máximo estará en dp[n][budget]
        return dp[n][budget];
    }

    public static void main(String[] args) {
        // Datos de entrada
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;

        // Calculamos el beneficio máximo
        int beneficioMaximo = knapsack(costos, beneficios, presupuesto);

        // Imprimimos el resultado
        System.out.println("El beneficio máximo que se puede obtener es: " + beneficioMaximo);
    }
}
/*
    Explicación:
            •	knapsack: Este es el método que resuelve el problema de la mochila usando programación dinámica. Utiliza una tabla dp para almacenar el beneficio máximo que se puede obtener dado un conjunto de proyectos y un presupuesto limitado.
            •	dp[i][j]: El valor de la celda dp[i][j] contiene el beneficio máximo que se puede obtener considerando los primeros i proyectos y un presupuesto j.
	•	main: En el método main, se definen los arreglos costos y beneficios junto con el presupuesto, y se llama a la función knapsack para calcular el beneficio máximo. Finalmente, el resultado se imprime en la consola.

            Complejidad:
            •	Tiempo: O(n * W), donde n es el número de proyectos y W es el presupuesto disponible.
            •	Espacio: O(n * W), debido a la tabla dp de tamaño (n+1) x (W+1).

    Este código te permitirá calcular el beneficio máximo de forma eficiente en Java.

 */

