# Explicación del Algoritmo N Queens con Backtracking

## ¿Cómo funciona el backtracking en este problema?
El algoritmo usa backtracking para colocar las `N` reinas en un tablero `N x N`, asegurando que ninguna ataque a otra. Se exploran todas las combinaciones posibles, retrocediendo si una configuración no es válida.

## ¿Qué pasa cuando el algoritmo encuentra una solución? ¿Qué ocurre cuando no puede colocar más reinas?
Cuando encuentra una solución, devuelve `true`, lo que propaga el éxito hacia atrás en la recursión. Si no se pueden colocar más reinas, devuelve `false` y retrocede para probar otras posiciones.

## ¿Qué sucede en el código cuando el algoritmo "retrocede"? ¿Cómo se visualiza en Python Tutor?
Cuando una colocación no permite completar el tablero, la reina más reciente se elimina (`board[row][col] = 0`) y se prueban otras opciones. En Python Tutor, se vería la pila de llamadas creciendo y retrocediendo hasta encontrar una solución o agotar las opciones.

## ¿Qué modificaciones harías para aumentar N a 8? ¿Cómo crees que cambiaría el tiempo de ejecución?
Para `N = 8`, basta con cambiar `private static final int N = 30;` a `8`. El tiempo de ejecución se reduciría drásticamente en comparación con `N = 30`, ya que el número de combinaciones exploradas decrece exponencialmente.

## ¿Por qué el método `isSafe` es crucial en este algoritmo?
`isSafe` evita intentos inválidos al comprobar que una reina no es atacada antes de colocarla. Esto reduce el espacio de búsqueda y hace que el algoritmo sea eficiente.

