//Programa que solicita dos numeroos y una operacion y muestra el resultado

import java.util.Scanner;
public class Actividad3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num1;
        int num2;
        String operacion;

        System.out.println("Ingrese el primer numero: ");
        num1 = scanner.nextInt();
        System.out.println("Ingrese el segundo numero: ");
        num2 = scanner.nextInt();
        System.out.println("Ingrese la operacion a realizar (sumar - restar - multiplicar - dividir): ");
        operacion = scanner.next();

        switch (operacion) {
            case "sumar":
                System.out.println("El resultado de la suma es: " + (num1 + num2));
                break;
            case "restar":
                System.out.println("El resultado de la resta es: " + (num1 - num2));
                break;
            case "multiplicar":
                System.out.println("El resultado de la multiplicacion es: " + (num1 * num2));
                break;
            case "dividir":
                System.out.println("El resultado de la division es: " + (num1 / num2));
                break;
            default:
                System.out.println("Operacion no valida");
                break;
        }
    }
}
