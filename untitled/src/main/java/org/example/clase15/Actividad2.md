# Problema del Viajante

## Explicación del Problema

El problema del viajante (TSP, por sus siglas en inglés: Traveling Salesman Problem) es un problema de optimización combinatoria que consiste en encontrar la ruta más corta que un viajante debe recorrer para visitar un conjunto de ciudades una única vez y regresar a la ciudad de origen. Se trata de un problema NP-difícil, lo que significa que no existe un algoritmo eficiente conocido para resolverlo de manera exacta en todos los casos.

## Cálculo de combinaciones para 15 ciudades

Para un problema con **n** ciudades, el número total de posibles rutas es:

\[ (n - 1)! / 2 \]

Dado que el recorrido es cíclico y no importa el punto de inicio, se divide entre 2. Para **15 ciudades**, el número de combinaciones posibles es:

\[ \frac{(15 - 1)!}{2} = \frac{14!}{2} \]

Calculando:

\[ 14! = 87,178,291,200 \]

\[ \frac{87,178,291,200}{2} = 43,589,145,600 \]

Por lo tanto, existen **43,589,145,600** combinaciones posibles para recorrer 15 ciudades, lo que hace inviable resolverlo por fuerza bruta en un tiempo razonable.

## Métodos heurísticos

Para resolver el problema de manera aproximada en tiempos razonables, se utilizan heurísticas. Algunos de los métodos más comunes incluyen:

1. **Algoritmos Greedy (Voraces)**: Construyen una solución paso a paso eligiendo la mejor opción local en cada momento, por ejemplo, seleccionando la ciudad más cercana disponible en cada paso.

2. **Búsqueda Tabú**: Mantiene un conjunto de soluciones exploradas y evita volver a ellas para escapar de óptimos locales.

3. **Algoritmos Genéticos**: Se basan en la evolución natural y la selección, generando poblaciones de soluciones y aplicando operadores de mutación y cruce para encontrar mejores recorridos con el tiempo.

4. **Recocido Simulado (Simulated Annealing)**: Emula el proceso de enfriamiento de metales para escapar de óptimos locales probando soluciones aleatorias con una probabilidad decreciente de aceptar peores soluciones.

5. **Optimización por Colonia de Hormigas (Ant Colony Optimization)**: Basado en el comportamiento de las hormigas, que depositan feromonas en los caminos más cortos, permitiendo que futuras iteraciones favorezcan las mejores rutas descubiertas.

Estos métodos permiten encontrar soluciones aproximadas de alta calidad en tiempos razonables sin necesidad de evaluar todas las combinaciones posibles.

