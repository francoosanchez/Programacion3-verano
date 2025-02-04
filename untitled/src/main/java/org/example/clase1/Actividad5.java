package org.example.clase1;

import java.util.ArrayList;
import java.util.List;

public class Actividad5 {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Auto("123ABC", "Toyota", "Corolla", 4));
        vehiculos.add(new Camion("456DEF", "Mercedes", "Actros", 15.5));
        vehiculos.add(new Moto("789GHI", "Yamaha", "R1", "Deportiva"));

        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.mostrarInformacion();
        }
    }


    public static abstract class Vehiculo {
        protected String matricula;
        protected String marca;
        protected String modelo;

        public Vehiculo(String matricula, String marca, String modelo) {
            this.matricula = matricula;
            this.marca = marca;
            this.modelo = modelo;
        }

        @Override
        public String toString() {
            return "Matrícula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo;
        }

        public abstract void mostrarInformacion();
    }

    public static class Auto extends Vehiculo {
        private int cantidadDePuertas;

        public Auto(String matricula, String marca, String modelo, int cantidadDePuertas) {
            super(matricula, marca, modelo);
            this.cantidadDePuertas = cantidadDePuertas;
        }

        @Override
        public void mostrarInformacion() {
            System.out.println(super.toString() + ", Puertas: " + cantidadDePuertas);
        }

    }

    public static class Camion extends Vehiculo {
        private double capacidadDeCarga;

        public Camion(String matricula, String marca, String modelo, double capacidadDeCarga) {
            super(matricula, marca, modelo);
            this.capacidadDeCarga = capacidadDeCarga;
        }

        @Override
        public void mostrarInformacion() {
            System.out.println(super.toString() + ", Capacidad de Carga: " + capacidadDeCarga + " toneladas");
        }
    }

    public static class Moto extends Vehiculo {
        private String tipoDeMoto;

        public Moto(String matricula, String marca, String modelo, String tipoDeMoto) {
            super(matricula, marca, modelo);
            this.tipoDeMoto = tipoDeMoto;
        }

        @Override
        public void mostrarInformacion() {
            System.out.println(super.toString() + ", Tipo de Moto: " + tipoDeMoto);
        }
    }

}
