package clase3;

public class Actividad4 {
    // Método principal para ordenar el array
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return; // Si el array tiene 0 o 1 elemento, ya está ordenado
        }

        int mid = arr.length / 2;

        // Dividir el array en dos mitades
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // Copiar los datos en los arrays izquierdo y derecho
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        // Llamar recursivamente a mergeSort para las dos mitades
        mergeSort(left);
        mergeSort(right);

        // Mezclar las dos mitades ordenadas
        merge(arr, left, right);
    }

    // Método para mezclar los dos arrays ordenados
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Mezclar los elementos de los arrays izquierdo y derecho
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copiar los elementos restantes de left[], si los hay
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Copiar los elementos restantes de right[], si los hay
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Método para imprimir el array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Array original:");
        printArray(arr);

        // Llamar al método mergeSort
        mergeSort(arr);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}
