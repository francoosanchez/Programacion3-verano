package org.example.clase1;

import java.util.Scanner;

public class Actividad3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Introduce el segundo número: ");
        double numero2 = scanner.nextDouble();

        System.out.print("Elige una operación (suma, resta, multiplicacion, division): ");
        String operacion = scanner.next().toLowerCase();

        double resultado;

        switch (operacion) {
            case "suma":
                resultado = numero1 + numero2;
                System.out.println("El resultado de la suma es: " + resultado);
                break;
            case "resta":
                resultado = numero1 - numero2;
                System.out.println("El resultado de la resta es: " + resultado);
                break;
            case "multiplicacion":
                resultado = numero1 * numero2;
                System.out.println("El resultado de la multiplicación es: " + resultado);
                break;
            case "division":
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                    System.out.println("El resultado de la división es: " + resultado);

                } else {
                    System.out.println("Error: No se puede dividir entre cero.");
                }
                break;
            default:
                System.out.println("Operación no válida. Intenta nuevamente con suma, resta, multiplicacion o division.");
        }

        scanner.close();

    }
}

