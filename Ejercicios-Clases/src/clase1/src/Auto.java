public class Auto extends Vehiculo {
    int cantidadPuertas;

    public Auto(String matricula, String marca, String modelo, int cantidadPuertas) {
        super(matricula, marca, modelo);
        this.cantidadPuertas = cantidadPuertas;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }
}

