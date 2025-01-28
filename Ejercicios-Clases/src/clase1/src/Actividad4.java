//Programa que solicita dos numeroos y una operacion y muestra el resultado

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Actividad4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num1;
        ArrayList<Integer> pares = new ArrayList<>();
        ArrayList<Integer> impares = new ArrayList<>();

        System.out.println("Ingrese el primer numero: ");
        num1 = scanner.nextInt();


        for (int i = 0; i < num1; i++) {
            if (i % 2 == 0) {
                pares.add(i);
            } else {
                impares.add(i);
            }
        }

        System.out.println("Los numeros pares son: " + pares);
        System.out.println("Los numeros impares son: " + impares);
    }
}
