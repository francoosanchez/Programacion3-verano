package clase1.actividad3;

import java.util.Scanner;

/*
    Actividad 3: Calculadora Básica
    
    Objetivo: Practicar estructuras de control y entrada de datos.
    Enunciado: Escribe un programa que:
    Solicite dos números al usuario.
    Solicite una operación matemática: suma, resta, multiplicación o división.
    Realice la operación seleccionada y muestre el resultado.
 */

public class c1_act3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- CALCULADORA ---");
        
        System.out.println("Ingresar el primer número: ");
        double num1 = scanner.nextDouble();

        System.out.println("Ingresar el segundo número: ");
        double num2 = scanner.nextDouble();

        System.out.println("Elegir la operación a realizar (+ - * /)");
        char operacion = scanner.next().charAt(0);

        double resultado = 0;

        scanner.close();


        switch (operacion) {
            case '+':
            resultado = num1 + num2;
            break;

            case '-':
            resultado = num1 - num2;
            break;

            case '*':
            resultado = num1 * num2;
            break;

            case '/':
            if(num2 != 0){
                resultado = num1 / num2;
            }else{
                System.out.println("NO ES POSIBLE DIVIDIR POR CERO");
            }
            
            break;

        default:
        System.out.println("Operación no válida");
        break;
        }

        System.out.println("El resultado es: " + resultado);
    }
    
}
