package clase5.actividad4;

/*
    Actividad 4

    Ingresar a https://www.hackerrank.com/challenges/greedy-florist
    Resolver el desafío y luego subir el código fuente a teams y github.
 */
import java.util.*;

public class c5_act4 {
    public static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int totalCost = 0;
        int n = c.length;
        int purchases = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            totalCost += (purchases / k + 1) * c[i];
            purchases++;
        }
        
        return totalCost;
    }

    public static void main(String[] args) {
        int[] c = {2, 5, 6};
        int k = 3;
        int result = getMinimumCost(k, c);
        System.out.println("Costo mínimo total: " + result);
    }
}
