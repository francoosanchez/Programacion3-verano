package clase3;

public class Actividad2 {
    // Método para realizar la búsqueda binaria en un array ordenado
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calcular el índice medio

            // Verificar si el elemento objetivo está en la posición media
            if (arr[mid] == target) {
                return mid; // El índice del elemento encontrado
            }

            // Si el elemento objetivo es menor que el valor en el medio, buscar en la mitad izquierda
            if (arr[mid] > target) {
                right = mid - 1;
            }
            // Si el elemento objetivo es mayor que el valor en el medio, buscar en la mitad derecha
            else {
                left = mid + 1;
            }
        }

        // Si el elemento no está presente en el array, retornar -1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        int target = 7;

        // Llamar al método de búsqueda binaria
        int result = binarySearch(arr, target);

        if (result == -1) {
            System.out.println("El elemento no se encuentra en el array.");
        } else {
            System.out.println("El elemento " + target + " se encuentra en el índice: " + result);
        }
    }
}
