package clase7.actividad3;

/*
    Actividad 3

    Problema: Selección óptima de proyectos
    Eres el gerente de una empresa que debe decidir en qué proyectos invertir. 
    Cada proyecto tiene un costo asociado y un beneficio esperado. 
    Tienes un presupuesto limitado y necesitas elegir qué combinación de proyectos maximiza el beneficio total sin exceder el presupuesto.
    Requerimientos:
    Te proporcionarán un arreglo de costos que representa el costo de cada proyecto.
    También te proporcionarán un arreglo de beneficios que indica el beneficio que se espera de cada proyecto.
    Implementa un algoritmo que determine qué proyectos deben seleccionarse para maximizar el beneficio total sin exceder el presupuesto.
    Supón que tienes los siguientes datos:
    Costos de los proyectos: [10, 15, 20, 25]
    Beneficios esperados de los proyectos: [100, 200, 150, 300]
    Presupuesto disponible: 40
    El programa debe calcular cuál es el beneficio máximo que puedes obtener respetando el presupuesto disponible y los proyectos seleccionados.
    Calcular utilizando algoritmos de programación dinámica. 
    Indicar complejidades.
 */

public class c7_act3 {
    public static int optimizarPresupuesto(int[] costos, int[] beneficios, int presupuesto) 
    {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) 
        {
            for (int j = 0; j <= presupuesto; j++) 
            {
                if (costos[i - 1] <= j) 
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costos[i - 1]] + beneficios[i - 1]);
                else 
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][presupuesto];
    }

    public static void main(String[] args) 
    {
        int[] costos = {5, 3, 4};
        int[] beneficios = {60,50,70};
        int presupuesto = 8;

        int beneficiosMaximo = optimizarPresupuesto(costos, beneficios, presupuesto);
        System.out.println("Beneficio máximo con el presupuesto " + presupuesto + " es: " + beneficiosMaximo);
    }
}

/*
* Complejidad Temporal: O(n * P), donde n es el número de proyectos y P es el presupuesto disponible.
*/
