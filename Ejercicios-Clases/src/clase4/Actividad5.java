package clase4;

import java.util.*;

class Corredor {
    String nombre;
    String categoria;
    int tiempo;

    public Corredor(String nombre, String categoria, int tiempo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Corredor{nombre='" + nombre + "', categoria='" + categoria + "', tiempo=" + tiempo + "}";
    }
}

public class Actividad5 {
    public static Map<String, Corredor> encontrarMejoresTiempos(List<Corredor> corredores, int inicio, int fin) {
        if (inicio == fin) {
            Map<String, Corredor> resultado = new HashMap<>();
            resultado.put(corredores.get(inicio).categoria, corredores.get(inicio));
            return resultado;
        }

        int medio = (inicio + fin) / 2;
        Map<String, Corredor> mejoresIzquierda = encontrarMejoresTiempos(corredores, inicio, medio);
        Map<String, Corredor> mejoresDerecha = encontrarMejoresTiempos(corredores, medio + 1, fin);

        return combinarMejoresTiempos(mejoresIzquierda, mejoresDerecha);
    }

    private static Map<String, Corredor> combinarMejoresTiempos(Map<String, Corredor> izq, Map<String, Corredor> der) {
        Map<String, Corredor> resultado = new HashMap<>(izq);

        for (Map.Entry<String, Corredor> entry : der.entrySet()) {
            String categoria = entry.getKey();
            Corredor corredor = entry.getValue();
            resultado.merge(categoria, corredor, (c1, c2) -> c1.tiempo <= c2.tiempo ? c1 : c2);
        }

        return resultado;
    }

    public static void main(String[] args) {
        List<Corredor> corredores = Arrays.asList(
                new Corredor("Juan", "100m", 12),
                new Corredor("Ana", "200m", 24),
                new Corredor("Carlos", "100m", 11),
                new Corredor("Beatriz", "200m", 23),
                new Corredor("David", "100m", 13)
        );

        Map<String, Corredor> mejoresTiempos = encontrarMejoresTiempos(corredores, 0, corredores.size() - 1);
        mejoresTiempos.forEach((categoria, corredor) ->
                System.out.println("Categoria: " + categoria + ", Mejor Corredor: " + corredor));
    }
}
