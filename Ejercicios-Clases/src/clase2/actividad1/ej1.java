package clase2.actividad1;

/*
    Actividad 1

    Dada esta matriz: int[][] mat = {{4,5,6},{7,8,9},{5,6,7}}; Realizar un programa en java para calcular el promedio. Para los cálculos, asumir que la matriz es cuadrada Realizar el conteo de instrucciones.
    Calcular la complejidad asintótica.
 */

public class ej1 {

    public static void main(String[] args) {
        int[][] matriz = {{4, 5, 6}, {7, 8, 9}, {5, 6, 7}};
        int suma = 0; // 1

        for (int i = 0; i < matriz.length; i++) { // 1 + (n + 1) + 2n = 2 + 3n
            for (int j = 0; j < matriz[i].length; j++) { // 1 + (n + 1) + 2n = 2 + 3n
                suma += matriz[i][j]; // 2n
            }
        }

        double promedio = (double) suma / (matriz.length * matriz[0].length); // 2
        System.out.println("Promedio: " + promedio); // 2
    }

    // f(n) = 1 + 2 + 3n + n (2 + 3n + 2n) + 2 + 2 = 5n^2 + 5n + 7
    // Tiene una complejidad asintótica: CUADRÁTICA
}