package clase4;

public class Actividad4 {
    /**
     * 1. Cómo funciona el algoritmo
     * 	1.	Se divide la lista en dos mitades.
     * 	2.	Se encuentra el par de números más grandes en cada mitad recursivamente.
     * 	3.	Se comparan los cuatro números obtenidos (dos de cada mitad) para determinar los dos más grandes globalmente.
     *
     * Cada vez que la lista se divide, el problema se reduce a la mitad hasta que cada segmento contiene solo un número.
     *
     * 2. Evaluar las comparaciones en cada nivel
     * 	•	Primer paso: Se divide la lista en dos mitades.
     * 	•	Segundo paso: Cada mitad se divide nuevamente en otras dos mitades.
     * 	•	Esto continúa hasta que cada grupo tiene solo un número.
     *
     * Para cada par de números, se determina el mayor y el segundo mayor con una comparación. Luego, cuando los pares se combinan, hay que realizar más comparaciones para determinar los dos mayores entre los cuatro números de cada combinación.
     *
     * En cada nivel de la recursión:
     * 	1.	Se comparan los números dentro de cada mitad (como en un torneo de eliminación).
     * 	2.	Se comparan los dos valores más altos de cada mitad para determinar los dos globales.
     *
     * 3. Contar cuántas veces se divide la lista
     * 	•	Si tenemos 8 números, se dividen en 2 grupos de 4, luego en 4 grupos de 2 y finalmente en 8 grupos de 1.
     * 	•	Cada comparación reduce el problema a la mitad hasta que queda solo un número en cada subproblema.
     * 	•	Para encontrar el número más grande, se hacen aproximadamente ￼ comparaciones.
     * 	•	Luego, se realizan comparaciones adicionales para encontrar el segundo mayor.
     *
     * En total, se realizan aproximadamente ￼ comparaciones.
     *
     * 4. Conclusión
     *
     * El algoritmo es eficiente porque en lugar de comparar todos los pares posibles (lo que tomaría ￼ tiempo en un enfoque ingenuo), usa divide y conquista para reducir drásticamente el número de comparaciones necesarias, logrando un tiempo de ejecución cercano a ￼.
     */
}
