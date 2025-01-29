package clase2.actividad5;


/*
    Actividad 5

    Sumar los primeros n números enteros, implementando en java un algoritmo que use recursión.
    Realice el análisis de recurrencia.
 */

public class ej5 {

    public static int sumaRecursiva (int n) {
        if (n<=0){
            return 0;
        }

        return n + sumaRecursiva(n-1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("La suma de los primeros " + n + " numeros enteros es de: " + sumaRecursiva(n));
    }
    
}
