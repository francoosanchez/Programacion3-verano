package clase2;

public class Actividad1 {
    public static void main(String[] args) {

        int[][] matriz = new int[3][3];
        matriz[0][0] = 4;
        matriz[0][1] = 5;
        matriz[0][2] = 6;
        matriz[1][0] = 7;
        matriz[1][1] = 8;
        matriz[1][2] = 9;
        matriz[2][0] = 5;
        matriz[2][1] = 6;
        matriz[2][2] = 7;

        int sumador = 0;
        int cantidadElementos = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                sumador = sumador + matriz[i][j];
                cantidadElementos++;
            }
        }

        int promedio = sumador / cantidadElementos;

        System.out.printf("El promedio es: " + promedio + "\n");

        // La complejidad de mi algoritmo es O(n^2) ya que recorro la matriz con dos ciclos anidados.
        // n^2 + 14 por todas las asignaciones y operaciones realizadas.

    }
}
