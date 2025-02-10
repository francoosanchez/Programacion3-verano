package clase5.actividad3;

/* 
    Actividad 3
    
    Una empresa distribuidora necesita cargar un camión con mercancía que se
    puede fraccionar. Indicar con una lista los elementos a subir al camión para
    maximizar el valor total, dado que el camión tiene una capacidad limitada.
 */

import java.util.Arrays;
import java.util.Comparator;

public class c5_act3 {

    static class Mercancia {
        int valor;
        int peso;

        public Mercancia(int valor, int peso) {
            this.valor = valor;
            this.peso = peso;
        }

        // Método para obtener la densidad de valor por peso
        public double getValorPorPeso() {
            return (double) valor / peso;
        }
    }

    public static double maximizarCapacidad(Mercancia[] mercancias, double capacidad) {
        // Ordenar por mayor valor/peso de forma descendente
        Arrays.sort(mercancias, Comparator.comparingDouble(Mercancia::getValorPorPeso).reversed());

        double valorTotal = 0.0;

        for (Mercancia mercancia : mercancias) {
            if (capacidad == 0) {
                break;
            }

            if (mercancia.peso <= capacidad) {
                capacidad -= mercancia.peso;
                valorTotal += mercancia.valor;
            } else {
                // Fraccionar el último objeto
                double fraccion = capacidad / mercancia.peso;
                valorTotal += mercancia.valor * fraccion;
                capacidad = 0;
            }
        }

        return valorTotal;
    }

    public static void main(String[] args) {
        // Lista de mercancías (valor, peso)
        Mercancia[] misMercancias = {
            new Mercancia(2000, 10),
            new Mercancia(1500, 30),
            new Mercancia(3000, 40)
        };

        double capacidadPerCamion = 50;
        double valorMax = maximizarCapacidad(misMercancias, capacidadPerCamion);

        System.out.println("Capacidad del camión: " + capacidadPerCamion);
        System.out.println("Valor máximo que puede llevar el camión: $" + valorMax);
    }
}

