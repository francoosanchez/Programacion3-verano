package org.example.clase4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Actividad5 {
    public static class Corredor {
        String nombre;
        String categoria;
        double tiempo;

        public Corredor(String nombre, String categoria, double tiempo) {
            this.nombre = nombre;
            this.categoria = categoria;
            this.tiempo = tiempo;
        }
    }

    public static Map<String, Corredor> encontrarMejoresTiempos(List<Corredor> corredores) {
        return dividirYVencer(corredores, 0, corredores.size() - 1);
    }

    private static Map<String, Corredor> dividirYVencer(List<Corredor> corredores, int inicio, int fin) {
        if (inicio == fin) {
            Map<String, Corredor> resultado = new HashMap<>();
            resultado.put(corredores.get(inicio).categoria, corredores.get(inicio));
            return resultado;
        }

        int medio = (inicio + fin) / 2;
        Map<String, Corredor> izquierda = dividirYVencer(corredores, inicio, medio);
        Map<String, Corredor> derecha = dividirYVencer(corredores, medio + 1, fin);

        return combinarResultados(izquierda, derecha);
    }

    private static Map<String, Corredor> combinarResultados(Map<String, Corredor> izquierda, Map<String, Corredor> derecha) {
        Map<String, Corredor> resultado = new HashMap<>(izquierda);

        for (Map.Entry<String, Corredor> entry : derecha.entrySet()) {
            String categoria = entry.getKey();
            Corredor corredor = entry.getValue();
            resultado.merge(categoria, corredor, (c1, c2) -> c1.tiempo <= c2.tiempo ? c1 : c2);
        }

        return resultado;
    }

    public static void main(String[] args) {
        List<Corredor> corredores = Arrays.asList(
                new Corredor("Juan", "100m", 10.5),
                new Corredor("Carlos", "200m", 20.3),
                new Corredor("Pedro", "100m", 10.2),
                new Corredor("Luis", "200m", 19.8),
                new Corredor("Miguel", "100m", 10.1)
        );

        Map<String, Corredor> mejoresTiempos = encontrarMejoresTiempos(corredores);

        for (Map.Entry<String, Corredor> entry : mejoresTiempos.entrySet()) {
            System.out.println("Categoría: " + entry.getKey() + ", Mejor Corredor: " + entry.getValue().nombre + ", Tiempo: " + entry.getValue().tiempo);
        }
    }

}
