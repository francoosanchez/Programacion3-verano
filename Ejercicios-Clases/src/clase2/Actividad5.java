package clase2;

public class Actividad5 {
    // Método recursivo para sumar los primeros n números enteros
    public static int sumarNumeros(int n) {
        if (n <= 0) {
            return 0; // Caso base: si n es 0 o negativo, la suma es 0
        }
        return n + sumarNumeros(n - 1); // Llamada recursiva
    }

    public static void main(String[] args) {
        int numero = 10;
        System.out.println("La suma de los primeros " + numero + " números enteros es: " + sumarNumeros(numero));
    }
}


