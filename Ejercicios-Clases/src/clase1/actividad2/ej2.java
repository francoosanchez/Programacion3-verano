package clase1.actividad2;

/*
    Actividad 2: Operaciones con tipos de datos

    Declara las siguientes variables: Un número entero (int) que almacene tu edad.
    Un número decimal (double) que represente tu altura en metros.Un carácter
    (char) que contenga la inicial de tu primer nombre.Un texto (String) que
    represente tu ciudad de residencia.
    Realiza las siguientes operaciones: Suma tu edad con otro número cualquiera.
    Multiplica tu altura por 2. Concatena tu inicial con un texto para formar un mensaje
    como: "Tu inicial es X".
    Imprime los resultados en consola.
 */

public class ej2 {
    public static void main(String[] args) {
        int edad = 24;
        double altura = 1.64;
        char inicial = 'F';
        String ciudad = "Buenos Aires";

        int sumaEdad = edad + 10;
        double multiplicarAltura = altura * 2.0;
        String mensaje = "Tu inicial es " + inicial;
        
        System.out.println(sumaEdad);
        System.out.println(multiplicarAltura);
        System.out.println(mensaje);


    }
    
}
