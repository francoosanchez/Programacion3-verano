package clase1.actividad5;

/*
    Actividad 5: Sistema de Gestión de Vehículos

    Se desea implementar un sistema para gestionar diferentes tipos de vehículos en un concesionario. Los vehículos tienen las siguientes características:
    Todos los vehículos tienen un número de matrícula, marca, modelo y un método para mostrar información del vehículo.
    Existen tres tipos de vehículos:
    - Autos: Tienen un atributo adicional llamado cantidadDePuertas.
    - Camiones: Tienen un atributo adicional llamado capacidadDeCarga (en toneladas).
    - Motos: Tienen un atributo adicional llamado tipoDeMoto (por ejemplo, "deportiva", "urbana").

    Debe implementarse una clase abstracta llamada Vehiculo y tres clases concretas (Auto, Camion, Moto) que hereden de ella.
    Crear una clase principal para:
    Crear objetos de cada tipo de vehículo. Almacenar los vehículos en una lista.
    Mostrar la información de todos los vehículos.
 */
import java.util.ArrayList;
import java.util.List;

// Clase abstracta Vehiculo
abstract class Vehiculo {

    protected String matricula;
    protected String marca;
    protected String modelo;

    public Vehiculo(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    // Método abstracto para mostrar información
    public abstract void mostrarInformacion();
}

// Clase Auto que hereda de Vehiculo
class Auto extends Vehiculo {

    private int cantidadDePuertas;

    public Auto(String matricula, String marca, String modelo, int cantidadDePuertas) {
        super(matricula, marca, modelo);
        this.cantidadDePuertas = cantidadDePuertas;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Auto -> Matrícula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo
                + ", Puertas: " + cantidadDePuertas);
    }
}

// Clase Camion que hereda de Vehiculo
class Camion extends Vehiculo {

    private double capacidadDeCarga; // En toneladas

    public Camion(String matricula, String marca, String modelo, double capacidadDeCarga) {
        super(matricula, marca, modelo);
        this.capacidadDeCarga = capacidadDeCarga;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Camión -> Matrícula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo
                + ", Capacidad de carga: " + capacidadDeCarga + " toneladas");
    }
}

// Clase Moto que hereda de Vehiculo
class Moto extends Vehiculo {

    private String tipoDeMoto; // Ejemplo: "deportiva", "urbana"

    public Moto(String matricula, String marca, String modelo, String tipoDeMoto) {
        super(matricula, marca, modelo);
        this.tipoDeMoto = tipoDeMoto;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Moto -> Matrícula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo
                + ", Tipo: " + tipoDeMoto);
    }
}

// Clase principal
public class c1_act5 {

    public static void main(String[] args) {
        // Crear lista de vehículos
        List<Vehiculo> vehiculos = new ArrayList<>();

        // Agregar vehículos a la lista
        vehiculos.add(new Auto("ABC123", "Toyota", "Corolla", 4));
        vehiculos.add(new Camion("DEF456", "Volvo", "FH16", 18.5));
        vehiculos.add(new Moto("GHI789", "Yamaha", "YZF-R3", "deportiva"));

        // Mostrar información de los vehículos
        System.out.println("Información de los vehiculos: ");
        for (Vehiculo v : vehiculos) {
            v.mostrarInformacion();
        }
    }
}
