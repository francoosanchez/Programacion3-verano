package clase11.actividad3;

/*
    Actividad 3

    Diseño de Distribución de Equipos Electrónicos en Oficinas
    En una oficina de 4x4, se necesita organizar la disposición de computadoras y
    impresoras de manera que optimice el uso del espacio y facilite el acceso. Las
    restricciones de diseño son las siguientes:
    No puede haber dos computadoras en la misma fila o columna.
    No puede haber dos impresoras en la misma fila o columna.
    Debes encontrar todas las combinaciones posibles para colocar 4 computadoras y 4
    impresoras en el tablero, respetando las restricciones anteriores.
    Objetivo: Implementar un programa en Java que utilice la técnica de backtracking para
    encontrar todas las configuraciones posibles de colocación de computadoras e
    impresoras en el tablero de 4x4. Tu programa debe imprimir cada configuración válida.
 */
public class c11_act3 {

    // Función para verificar si es seguro colocar un escritorio o una silla en la posición (fila, columna)
    public static boolean esSeguro(int[][] habitacion, int fila, int columna) {
        // Verificamos si ya hay un escritorio o silla en la misma fila
        for (int i = 0; i < fila; i++) {
            if (habitacion[i][columna] != 0) {
                return false;
            }
        }
        // Verificamos si ya hay un escritorio o silla en la misma columna
        for (int j = 0; j < columna; j++) {
            if (habitacion[fila][j] != 0) {
                return false;
            }
        }

        // Si no hay conflictos, es seguro colocar el escritorio o silla
        return true;
    }

    // Función recursiva para colocar los escritorios y sillas usando backtracking
    public static void colocarElementos(int[][] habitacion, int fila, int escritoriosRestantes, int sillasRestantes) {
        // Caso base: si hemos colocado todos los escritorios y sillas, imprimimos la habitación
        if (escritoriosRestantes == 0 && sillasRestantes == 0) {
            imprimirHabitacion(habitacion);
            return;
        }

        // Recorremos cada columna en la fila actual
        for (int columna = 0; columna < habitacion.length; columna++) {
            // Intentamos colocar un escritorio si quedan escritorios por colocar
            if (escritoriosRestantes > 0 && esSeguro(habitacion, fila, columna)) {
                // Colocamos un escritorio (representado por 1)
                habitacion[fila][columna] = 1;

                // Llamada recursiva para intentar colocar el siguiente elemento
                colocarElementos(habitacion, fila + 1, escritoriosRestantes - 1, sillasRestantes);

                // Backtracking: quitamos el escritorio
                habitacion[fila][columna] = 0;
            }

            // Intentamos colocar una silla si quedan sillas por colocar
            if (sillasRestantes > 0 && esSeguro(habitacion, fila, columna)) {
                // Colocamos una silla (representada por 2)
                habitacion[fila][columna] = 2;

                // Llamada recursiva para intentar colocar el siguiente elemento
                colocarElementos(habitacion, fila + 1, escritoriosRestantes, sillasRestantes - 1);

                // Backtracking: quitamos la silla
                habitacion[fila][columna] = 0;
            }
        }
    }

    // Función para imprimir la disposición de los escritorios y sillas en la habitación
    public static void imprimirHabitacion(int[][] habitacion) {
        for (int[] fila : habitacion) {
            for (int valor : fila) {
                if (valor == 1) {
                    System.out.print("E "); // Escritorio
                } else if (valor == 2) {
                    System.out.print("S "); // Silla
                } else {
                    System.out.print(". "); // Espacio vacío
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Función principal para resolver el problema
    public static void resolverUbicacion() {
        // Creamos una habitación de 4x4 vacía
        int[][] habitacion = new int[4][4];

        // Comenzamos el proceso de backtracking para colocar los escritorios y sillas
        colocarElementos(habitacion, 0, 2, 2); // Dos escritorios y dos sillas
    }

    // Método main para ejecutar el programa
    public static void main(String[] args) {
        resolverUbicacion();
    }

}
