package clase2;

public class Actividad2 {
    public static void main(String[] args) {

        int[][] matriz = {{2,2,2},{2,2,2},{2,2,2}};
        int[][] otraM = {{3,3,3},{3,3,3},{3,3,3}};
        int[][] multiplicada = new int[3][3];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                multiplicada[i][j] = matriz[i][j] * otraM[i][j];
            }
        }

        for (int i = 0; i < multiplicada.length; i++) {
            for (int j = 0; j < multiplicada.length; j++) {
                System.out.print(multiplicada[i][j] + " ");
            }
            System.out.println();
        }

        // La complejidad de mi algoritmo es O(n^2) ya que recorro la matriz con dos ciclos anidados.
        // n^2 + 3 por todas las asignaciones y operaciones realizadas.

    }
}

