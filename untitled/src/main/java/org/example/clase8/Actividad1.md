# Resolución de la Actividad 1 - Algoritmo de Floyd-Warshall

## Enunciado
Tenemos 4 nodos y las siguientes aristas con sus respectivos pesos:

- 1 → 2, peso 2
- 2 → 4, peso 4
- 1 → 4, peso 5
- 4 → 3, peso 2

Debemos realizar una prueba de escritorio para el algoritmo de Floyd-Warshall, que permite calcular las distancias más cortas entre todos los pares de nodos en un grafo ponderado.

## Matriz de Adyacencia Inicial
Dado que no todas las aristas están presentes, utilizamos infinito (∞) para representar la ausencia de conexión directa.

|   | 1  | 2  | 3  | 4  |
|---|----|----|----|----|
| 1 | 0  | 2  | ∞  | 5  |
| 2 | ∞  | 0  | ∞  | 4  |
| 3 | ∞  | ∞  | 0  | ∞  |
| 4 | ∞  | ∞  | 2  | 0  |

## Iteraciones del Algoritmo de Floyd-Warshall

### Considerando el nodo 1 como intermedio

No se producen mejoras en las distancias ya que el nodo 1 solo tiene conexiones directas a 2 y 4.

### Considerando el nodo 2 como intermedio

- Se mejora la distancia entre 1 y 4: 1 → 2 (2) + 2 → 4 (4) = 6 (No mejora el camino actual 1 → 4 que es 5).

### Considerando el nodo 3 como intermedio

- No se producen mejoras, ya que no tiene caminos de entrada.

### Considerando el nodo 4 como intermedio

- Se mejora la distancia entre 1 y 3: 1 → 4 (5) + 4 → 3 (2) = 7.
- Se mejora la distancia entre 2 y 3: 2 → 4 (4) + 4 → 3 (2) = 6.

## Matriz Final de Distancias Mínimas

|   | 1  | 2  | 3  | 4  |
|---|----|----|----|----|
| 1 | 0  | 2  | 7  | 5  |
| 2 | ∞  | 0  | 6  | 4  |
| 3 | ∞  | ∞  | 0  | ∞  |
| 4 | ∞  | ∞  | 2  | 0  |

## Conclusión
Tras aplicar el algoritmo de Floyd-Warshall, se obtienen las distancias más cortas entre todos los pares de nodos en el grafo. Se observa que se han actualizado algunas distancias gracias al uso de nodos intermedios, optimizando las rutas.

