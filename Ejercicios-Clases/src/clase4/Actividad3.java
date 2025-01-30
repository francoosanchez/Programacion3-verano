package clase4;

public class Actividad3 {
    /**
     * 1. Entender cómo funciona el algoritmo
     *
     * El algoritmo sigue estos pasos:
     * 	1.	Divide la lista de clientes en dos mitades.
     * 	2.	Encuentra el mejor cliente (con mayor scoring) en cada mitad de forma recursiva.
     * 	3.	Compara los dos clientes obtenidos para determinar cuál es el mejor globalmente.
     *
     * Cada vez que la lista se divide, el problema se reduce a la mitad hasta que llega a un solo cliente.
     *
     * 2. Evaluar el número de comparaciones en cada nivel
     * 	•	Primer paso: La lista completa se divide en dos mitades.
     * 	•	Segundo paso: Cada mitad se divide nuevamente en otras dos mitades.
     * 	•	Esto sigue hasta que cada segmento contiene solo un cliente.
     *
     * En cada paso, el algoritmo compara los dos mejores clientes de cada mitad, haciendo una comparación adicional.
     *
     * 3. Contar cuántas veces se divide la lista
     * 	•	Si tenemos 8 clientes, se divide en 2 grupos de 4, luego en 4 grupos de 2 y finalmente en 8 grupos de 1.
     * 	•	Para cada grupo de 2, se realiza una comparación.
     * 	•	Luego, los ganadores de esos grupos de 2 se comparan entre sí, y así sucesivamente hasta obtener el mejor cliente.
     *
     * Esto significa que si tenemos ￼ clientes, se necesitan aproximadamente ￼ niveles de comparación.
     *
     * 4. Conclusión
     *
     * El algoritmo realiza una comparación por cada combinación de dos grupos en cada nivel de la recursión. Dado que hay aproximadamente ￼ niveles, el número total de comparaciones es cercano a ￼, lo que es bastante eficiente en comparación con un algoritmo que revisa todos los clientes uno por uno.
     */
}
