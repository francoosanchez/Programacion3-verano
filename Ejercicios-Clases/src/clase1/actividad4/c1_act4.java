package clase1.actividad4;

import java.util.Scanner;

/*
 Escribe un programa que:
- Solicite un número entero n al usuario.
- Imprima los números del 1 al n indicando si cada uno es par o impar.
 */

public class c1_act4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número entero: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " es par");
            } else {
                System.out.println(i + " es impar");
            }
        }
        scanner.close();
    }
    
}
