# Prueba de Escritorio para el Problema de la Mochila

## Problema
Dada una mochila con capacidad máxima de peso **P = 6**, y **n = 3** objetos con peso y valor:

| Objeto | Peso (w) | Valor (v) |
|--------|---------|----------|
| 1      | 3       | 4        |
| 2      | 4       | 5        |
| 3      | 2       | 3        |

El objetivo es seleccionar algunos objetos para maximizar el valor total sin superar la capacidad de la mochila.

---

## Método de Fuerza Bruta
Probamos todas las combinaciones posibles:

1. **No elegir ningún objeto** → Peso = 0, Valor = 0
2. **Elegir solo un objeto**:
    - (Objeto 1): Peso = 3, Valor = 4
    - (Objeto 2): Peso = 4, Valor = 5
    - (Objeto 3): Peso = 2, Valor = 3
3. **Elegir dos objetos**:
    - (Objeto 1 y 2): Peso = 3 + 4 = 7 (Excede capacidad, no válido)
    - (Objeto 1 y 3): Peso = 3 + 2 = 5, Valor = 4 + 3 = **7**
    - (Objeto 2 y 3): Peso = 4 + 2 = 6, Valor = 5 + 3 = **8**
4. **Elegir los tres objetos**:
    - (Objeto 1, 2 y 3): Peso = 3 + 4 + 2 = 9 (Excede capacidad, no válido)

### Solución Óptima por Fuerza Bruta
La mejor combinación válida es elegir **Objeto 2 y Objeto 3**, con **valor máximo = 8**.

---

## Método de Programación Dinámica
Creamos una tabla `dp[i][w]` donde `i` es el número de objetos considerados y `w` es la capacidad de la mochila.

### Paso 1: Definir la Tabla `dp`

| i / w | 0 | 1 | 2 | 3 | 4 | 5 | 6 |
|-------|---|---|---|---|---|---|---|
| 0     | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| 1     | 0 | 0 | 0 | 4 | 4 | 4 | 4 |
| 2     | 0 | 0 | 0 | 4 | 5 | 5 | 5 |
| 3     | 0 | 0 | 3 | 4 | 5 | 7 | 8 |

### Paso 2: Rellenar la Tabla

1. **Fila 0:** No hay objetos, todos los valores son 0.
2. **Fila 1 (Objeto 1 - Peso 3, Valor 4):**
    - Capacidad < 3 → Valor = 0
    - Capacidad ≥ 3 → Valor = 4
3. **Fila 2 (Objeto 2 - Peso 4, Valor 5):**
    - Capacidad < 4 → Mantiene valores anteriores
    - Capacidad ≥ 4 → Compara no tomar el objeto (4) o tomarlo (5)
4. **Fila 3 (Objeto 3 - Peso 2, Valor 3):**
    - Capacidad < 2 → Mantiene valores anteriores
    - Capacidad ≥ 2 → Compara no tomar el objeto o tomarlo para mejorar el valor

### Resultado Final
El valor máximo obtenido es **dp[3][6] = 8**, seleccionando **Objeto 2 y Objeto 3**.

---

## Conclusión
Tanto la **fuerza bruta** como la **programación dinámica** encuentran que la mejor selección es **Objeto 2 y Objeto 3**, con un **valor máximo de 8**.

