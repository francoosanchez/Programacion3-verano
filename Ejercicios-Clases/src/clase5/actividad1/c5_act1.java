package clase5.actividad1;
import java.util.ArrayList;
import java.util.List;


/*
    Actividad 1

    Dada una lista de monedas con denominaciones convencionales (10,1,5,2,10,10,5,2,5,5,5,5,5,5,10), implementar una función greedy 
    que devuelva o genere una lista de monedas para dar cambio exacto utilizando una lista de monedas disponible para un importe de $33. 
    Devolver una lista nula o lanzar una excepción, si no se puede dar el cambio.
    Realizar pseudocódigo e implementación en Java. Indicar la complejidad algorítmica.

 */


/*
PSEUDOCÓDIGO

 FUNCION dar_cambio(monedas, importe)
    ORDENAR monedas EN ORDEN DESCENDENTE (utilizando QuickSort)
    LISTA cambio = []
    PARA cada moneda EN monedas
        SI importe >= moneda
            AGREGAR moneda A cambio
            RESTAR moneda A importe
        SI importe == 0
            RETORNAR cambio
    FIN PARA
    SI importe > 0
        LANZAR EXCEPCIÓN "No se puede dar el cambio exacto"
*/

public class c5_act1 {

    public static List<Integer> darCambio(int[] monedas, int importe) throws Exception {
        // Ordenar las monedas de mayor a menor usando QuickSort
        quickSort.quickSort(monedas, 0, monedas.length - 1); // Llamada correcta a quickSort

        List<Integer> cambio = new ArrayList<>();
        for (int moneda : monedas) {
            while (importe >= moneda) {
                cambio.add(moneda);
                importe -= moneda;
            }
            if (importe == 0) {
                return cambio;
            }
        }

        throw new Exception("No se puede dar el cambio exacto");
    }

    public static void main(String[] args) {
        int[] monedas = {10,1,5,2,10,10,5,2,5,5,5,5,5,5,10};
        int importe = 33;

        try {
            List<Integer> resultado = darCambio(monedas, importe);
            System.out.println("Cambio dado: " + resultado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}