package clase5;

import java.util.*;

class Item {
    double peso, valor;

    public Item(double peso, double valor) {
        this.peso = peso;
        this.valor = valor;
    }

    public double valorPorUnidad() {
        return valor / peso;
    }
}

public class Actividad3 {
    public static List<String> maximizarCarga(List<Item> items, double capacidad) {
        // Ordenamos los items por valor por unidad de peso en orden descendente
        items.sort((a, b) -> Double.compare(b.valorPorUnidad(), a.valorPorUnidad()));
        List<String> seleccionados = new ArrayList<>();
        double pesoTotal = 0, valorTotal = 0;

        for (Item item : items) {
            if (pesoTotal + item.peso <= capacidad) {
                seleccionados.add("Item completo: peso " + item.peso + ", valor " + item.valor);
                pesoTotal += item.peso;
                valorTotal += item.valor;
            } else {
                double fraccion = (capacidad - pesoTotal) / item.peso;
                seleccionados.add("Item fraccionado: " + (fraccion * 100) + "% del peso " + item.peso + ", valor " + (fraccion * item.valor));
                valorTotal += fraccion * item.valor;
                break;
            }
        }

        seleccionados.add("Valor total maximizado: " + valorTotal);
        return seleccionados;
    }

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120)
        );
        double capacidad = 50;

        List<String> resultado = maximizarCarga(new ArrayList<>(items), capacidad);
        resultado.forEach(System.out::println);
    }


}
