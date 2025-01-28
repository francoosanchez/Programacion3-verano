//Programa que solicita dos numeroos y una operacion y muestra el resultado

import java.util.ArrayList;

public class Actividad5 {
    public static void main(String[] args) {

        Auto auto = new Auto("ABC123", "Ford", "Fiesta", 4);
        Moto moto = new Moto("XYZ987", "Honda", "CBR", "Deportiva");
        Camion camion = new Camion("ZZZ999", "Mercedes", "Actros", 20000);

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(auto);
        vehiculos.add(moto);
        vehiculos.add(camion);

        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.mostrarDatos();
            System.out.println();
        }
    }
}

