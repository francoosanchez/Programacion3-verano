package clase14;

public class Actividad1 {
    /*
1. ¿Cómo funciona el backtracking en este problema?

El algoritmo intenta colocar una reina en cada fila del tablero de ajedrez de forma recursiva. Para cada fila:
	•	Coloca una reina en la primera columna disponible.
	•	Comprueba si la posición es segura (isSafe).
	•	Si es segura, pasa a la siguiente fila.
	•	Si no lo es o si no puede colocar una reina en la siguiente fila, retrocede (backtracking) y mueve la reina anterior a la siguiente columna disponible.

2. ¿Qué pasa cuando el algoritmo encuentra una solución?

Cuando logra colocar una reina en cada fila sin conflictos:
	•	Registra o imprime la solución.
	•	Luego continúa explorando otras posibles soluciones (si se buscan todas).
	•	Si solo se busca una solución, puede detenerse ahí.

3. ¿Qué ocurre cuando no puede colocar más reinas?

Si en una fila no hay posiciones seguras:
	•	El algoritmo “retrocede” (backtracking): elimina la reina colocada en la fila anterior y prueba la siguiente columna.
	•	Este proceso continúa hasta encontrar una nueva posición válida o hasta agotar todas las posibilidades.

4. ¿Qué sucede en el código cuando el algoritmo “retrocede”?

Cuando retrocede:
	•	Se deshace la última decisión (se remueve una reina del tablero).
	•	Se prueba una posición alternativa.
	•	En Python Tutor, verías que la pila de llamadas recursivas disminuye temporalmente a medida que el algoritmo vuelve a estados anteriores y luego se incrementa cuando intenta nuevas posiciones.

5. ¿Cómo se visualiza en Python Tutor?

En Python Tutor:
	•	Verás cómo se apilan y desapilan las llamadas recursivas.
	•	Cuando el algoritmo retrocede, se elimina una reina del tablero y la función vuelve a la llamada anterior para probar una nueva columna.
	•	Puedes observar cómo cambian las variables y el estado del tablero en cada paso.

6. ¿Qué modificaciones harías para aumentar N a 8? ¿Cómo crees que cambiaría el tiempo de ejecución?
	•	Modificaciones: Cambiar el valor de N a 8 (si está definido como una variable).

N = 8


	•	Tiempo de ejecución: Aumentará significativamente, ya que el espacio de búsqueda crece exponencialmente. Sin embargo, el backtracking sigue siendo eficiente comparado con un enfoque de fuerza bruta, ya que descarta muchas combinaciones inválidas rápidamente.

7. ¿Por qué el método isSafe es crucial en este algoritmo?
	•	Función clave: Verifica si una reina puede colocarse en una posición específica sin ser atacada.
	•	Verificaciones:
	•	Columna actual.
	•	Diagonal superior izquierda.
	•	Diagonal superior derecha.
	•	Importancia: Sin isSafe, el algoritmo probaría muchas posiciones inválidas, incrementando el tiempo de ejecución.

     */
}
