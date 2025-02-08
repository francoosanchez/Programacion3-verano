package clase4.actividad2;

/*
    Actividad 2

    Objetivo: Dada una lista de números, encontrar los dos números mayores utilizando la técnica de Divide y Conquista.
    Tareas:
    - Pseudocódigo: Escribe el pseudocódigo que resuelva el problema.
    - Implementación en Java: Implementa el pseudocódigo en Java.
 */

public class c4_act2 {
    public static int[] encontrarDosMayores(int[] nums, int ini, int fin){
        if(fin -ini == 1){ // O(1)
            if (nums[ini] > nums[fin]) { // O(1)
                return new int[]{nums[ini], nums[fin]};                
            }else{
                return new int[]{nums[fin], nums[ini]};
            }

        }

        int mitad = (ini + fin) / 2; // O(1)
        
        int[] izq = encontrarDosMayores(nums, ini, mitad); // O(T(n/2))
        int[] der = encontrarDosMayores(nums, mitad +1, fin); // O(T(n/2))
        
        int mayorGlobal = Math.max(izq[0], der[0]); // O(1)
        int segundoMayorGloabal;

        if(mayorGlobal == izq[0]){ // O(1)
            segundoMayorGloabal = Math.max(izq[1], der[0]); // O(1)
        }else{
            segundoMayorGloabal = Math.max(izq[0], der[1]); // O(1)
        }

        return new int[]{mayorGlobal, segundoMayorGloabal}; // O(1)
    }
    /*
     El algoritmo tiene una complejidad lineal O(n) debido a que estamos dividiendo el problema en partes iguales, resolviendo  cada parte recursivamente, y combinando
     los resultados en tiempo constante.
     */

    public static void main(String[] args) {
        int[] nums = {10, 20, 5, 30, 25, 15, 35, 50};
        
        int[] resultado = encontrarDosMayores(nums, 0, nums.length -1);
        System.out.println("Los dos números mayores son: " + resultado[0] + " y " + resultado[1]);
    }
    
}
