package clase1.src;

public class Moto extends Vehiculo {
    String tipoMoto;

    public Moto(String matricula, String marca, String modelo, String tipoMoto) {
        super(matricula, marca, modelo);
        this.tipoMoto = tipoMoto;
    }

    public String getTipoMoto() {
        return tipoMoto;
    }

    public void setTipoMoto(String tipoMoto) {
        this.tipoMoto = tipoMoto;
    }
}

