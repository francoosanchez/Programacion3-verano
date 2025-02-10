package clase7.actividad4;

/*
    Actividad 4

    Problema: Selección de paquetes de inversión
    Eres un gestor financiero y tienes la tarea de seleccionar entre varios paquetes de inversión para maximizar las ganancias. 
    Cada paquete tiene un costo inicial y una ganancia estimada. 
    Sin embargo, tu presupuesto es limitado, por lo que debes elegir cuidadosamente qué paquetes comprar para maximizar las ganancias sin exceder el presupuesto.
    Requerimientos:
    Te proporcionarán un arreglo de costos, donde cada elemento representa el costo de un paquete de inversión.
    También recibirás un arreglo de ganancias que representa la ganancia esperada de cada paquete.
    Debes implementar un algoritmo que determine la combinación de paquetes que maximiza las ganancias totales sin superar el presupuesto disponible.
    Datos de Ejemplo:
    Costos de los paquetes de inversión: [12, 20, 15, 25]
    Ganancias esperadas: [150, 200, 100, 300]
    Presupuesto disponible: 35
    El programa debe calcular cuál es la ganancia máxima que puedes obtener respetando el presupuesto.
    Calcular utilizando algoritmos de programación dinámica. 
    Indicar complejidades.
 */

public class c7_act4 {
    public static int seleccionPaquetes(int[] costos, int[] ganancia, int presupuesto)
    {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                if (costos[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costos[i - 1]] + ganancia[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][presupuesto];
    }

    public static void main(String[] args) 
    {
        int [] costos = {12, 20, 15, 25};
        int [] ganancias = {150, 200, 100, 300};
        int presupuesto = 35;

        System.out.println("El beneficio máximo con el presupuesto " + presupuesto + " es: " + seleccionPaquetes(costos, ganancias, presupuesto));
    }
    
}
