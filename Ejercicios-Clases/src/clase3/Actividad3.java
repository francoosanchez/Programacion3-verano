package clase3;

public class Actividad3 {
    // Método principal para ordenar el array
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            // Encuentra el índice de la partición
            int pivotIndex = partition(arr, low, high);

            // Llama recursivamente a los subarrays a la izquierda y a la derecha del pivote
            quicksort(arr, low, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, high);
        }
    }

    // Método para dividir el array y obtener el índice del pivote
    private static int partition(int[] arr, int low, int high) {
        // Elegir el último elemento como pivote
        int pivot = arr[high];
        int i = low - 1; // Índice del elemento más pequeño

        // Reorganizar el array comparando cada elemento con el pivote
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Intercambiar arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Intercambiar el pivote con el elemento en la posición i + 1
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Retorna la posición del pivote
    }

    // Método para imprimir el array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        System.out.println("Array original:");
        printArray(arr);

        // Llamar al método quicksort
        quicksort(arr, 0, arr.length - 1);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}
