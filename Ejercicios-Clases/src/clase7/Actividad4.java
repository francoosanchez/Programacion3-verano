package clase7;

public class Actividad4 {
    /*
        Paso 1: Definir el problema
        •	Tienes un conjunto de n paquetes, y cada paquete tiene:
                •	Un costo.
                •	Una ganancia esperada.
        •	Tienes un presupuesto disponible, y quieres maximizar la ganancia total sin exceder ese presupuesto.

                Paso 2: Definir la Recurrencia

        La matriz dp[i][j] representará la ganancia máxima que se puede obtener considerando los primeros i paquetes y con un presupuesto de j.

        La fórmula de recurrencia es la siguiente:
                •	Si el costo del paquete i es mayor que el presupuesto j, entonces no podemos incluir ese paquete. En ese caso, dp[i][j] = dp[i-1][j].
                •	Si el costo del paquete i es menor o igual al presupuesto j, entonces puedes optar entre incluir el paquete o no. La fórmula será:
                ￼

        Paso 3: Inicialización
        •	dp[0][j] = 0 para todo j, porque si no hay paquetes, el beneficio es 0.
                •	dp[i][0] = 0 para todo i, porque si no hay presupuesto, el beneficio es 0.

        Paso 4: Complejidad
        •	Tiempo: O(n * W), donde n es el número de paquetes y W es el presupuesto disponible.
                •	Espacio: O(n * W), porque necesitas una tabla dp de tamaño (n+1) x (W+1).

     */
// Función que implementa el algoritmo de la mochila
    public static int knapsack(int[] costos, int[] ganancias, int presupuesto) {
        int n = costos.length;

        // Inicializamos la tabla dp
        int[][] dp = new int[n + 1][presupuesto + 1];

        // Llenamos la tabla dp
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                if (costos[i - 1] <= j) {
                    // Elegimos entre no tomar el paquete o tomarlo
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costos[i - 1]] + ganancias[i - 1]);
                } else {
                    // No podemos tomar el paquete
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // El valor máximo estará en dp[n][presupuesto]
        return dp[n][presupuesto];
    }

    public static void main(String[] args) {
        // Datos de entrada
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300};
        int presupuesto = 35;

        // Calculamos la ganancia máxima
        int gananciaMaxima = knapsack(costos, ganancias, presupuesto);

        // Imprimimos el resultado
        System.out.println("La ganancia máxima que se puede obtener es: " + gananciaMaxima);
    }
}
/*
    Explicación del Código:
            1.	knapsack: Este es el método que resuelve el problema utilizando la técnica de programación dinámica. Utiliza una tabla dp donde dp[i][j] guarda la ganancia máxima que se puede obtener considerando los primeros i paquetes y un presupuesto de j.
            2.	main: En el método main, defines los arreglos costos y ganancias, junto con el presupuesto disponible, y luego llamas a la función knapsack para calcular la ganancia máxima. Finalmente, se imprime el resultado.

    Complejidad:
            •	Tiempo: O(n * W), donde n es el número de paquetes y W es el presupuesto disponible. La razón de esto es que debemos llenar una tabla dp de tamaño (n+1) x (W+1) y cada operación de llenado toma O(1).
            •	Espacio: O(n * W), ya que necesitamos una tabla dp de tamaño (n+1) x (W+1) para almacenar los resultados intermedios.

    Resultado:

    Si ejecutas este código con los datos proporcionados (costos = [12, 20, 15, 25], ganancias = [150, 200, 100, 300], y presupuesto = 35), el programa calculará y mostrará la ganancia máxima que puedes obtener sin exceder el presupuesto.
 */
