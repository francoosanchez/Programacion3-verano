# Prueba de Escritorio para el Problema de la Mochila

## Problema
Dada una mochila con capacidad máxima de peso **P = 10**, y **n = 4** objetos con peso y valor:

| Objeto | Peso (w) | Valor (v) |
|--------|---------|----------|
| 1      | 2       | 4        |
| 2      | 5       | 2        |
| 3      | 6       | 1        |
| 4      | 7       | 6        |

El objetivo es seleccionar algunos objetos para maximizar el valor total sin superar la capacidad de la mochila.

---

## Método de Fuerza Bruta
Probamos todas las combinaciones posibles:

1. **No elegir ningún objeto** → Peso = 0, Valor = 0
2. **Elegir solo un objeto**:
    - (Objeto 1): Peso = 2, Valor = 4
    - (Objeto 2): Peso = 5, Valor = 2
    - (Objeto 3): Peso = 6, Valor = 1
    - (Objeto 4): Peso = 7, Valor = 6
3. **Elegir dos objetos**:
    - (Objeto 1 y 2): Peso = 2 + 5 = 7, Valor = 4 + 2 = **6**
    - (Objeto 1 y 3): Peso = 2 + 6 = 8, Valor = 4 + 1 = **5**
    - (Objeto 1 y 4): Peso = 2 + 7 = 9, Valor = 4 + 6 = **10**
    - (Objeto 2 y 3): Peso = 5 + 6 = 11 (Excede capacidad, no válido)
    - (Objeto 2 y 4): Peso = 5 + 7 = 12 (Excede capacidad, no válido)
    - (Objeto 3 y 4): Peso = 6 + 7 = 13 (Excede capacidad, no válido)
4. **Elegir tres objetos**:
    - (Objeto 1, 2 y 3): Peso = 2 + 5 + 6 = 13 (Excede capacidad, no válido)
    - (Objeto 1, 2 y 4): Peso = 2 + 5 + 7 = 14 (Excede capacidad, no válido)
    - (Objeto 1, 3 y 4): Peso = 2 + 6 + 7 = 15 (Excede capacidad, no válido)
    - (Objeto 2, 3 y 4): Peso = 5 + 6 + 7 = 18 (Excede capacidad, no válido)
5. **Elegir los cuatro objetos**:
    - Peso = 2 + 5 + 6 + 7 = 20 (Excede capacidad, no válido)

### Solución Óptima por Fuerza Bruta
La mejor combinación válida es elegir **Objeto 1 y Objeto 4**, con **valor máximo = 10**.

---

## Método de Programación Dinámica
Creamos una tabla `dp[i][w]` donde `i` es el número de objetos considerados y `w` es la capacidad de la mochila.

### Paso 1: Definir la Tabla `dp`

| i / w | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
|-------|---|---|---|---|---|---|---|---|---|---|----|
| 0     | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0  |
| 1     | 0 | 0 | 4 | 4 | 4 | 4 | 4 | 4 | 4 | 4 | 4  |
| 2     | 0 | 0 | 4 | 4 | 4 | 4 | 4 | 6 | 6 | 6 | 6  |
| 3     | 0 | 0 | 4 | 4 | 4 | 4 | 4 | 6 | 6 | 6 | 6  |
| 4     | 0 | 0 | 4 | 4 | 4 | 4 | 4 | 6 | 6 | 10 | 10 |

### Paso 2: Rellenar la Tabla

1. **Fila 0:** No hay objetos, todos los valores son 0.
2. **Fila 1 (Objeto 1 - Peso 2, Valor 4):**
    - Capacidad < 2 → Valor = 0
    - Capacidad ≥ 2 → Valor = 4
3. **Fila 2 (Objeto 2 - Peso 5, Valor 2):**
    - Capacidad < 5 → Mantiene valores anteriores
    - Capacidad ≥ 5 → Compara no tomar el objeto (4) o tomarlo (6)
4. **Fila 3 (Objeto 3 - Peso 6, Valor 1):**
    - Capacidad < 6 → Mantiene valores anteriores
    - Capacidad ≥ 6 → Compara no tomar el objeto o tomarlo para mejorar el valor
5. **Fila 4 (Objeto 4 - Peso 7, Valor 6):**
    - Capacidad < 7 → Mantiene valores anteriores
    - Capacidad ≥ 7 → Compara no tomar el objeto o tomarlo para mejorar el valor

### Recuperación de los Caminos
Para encontrar los objetos seleccionados en la solución óptima, retrocedemos en la tabla `dp`, verificando cuáles contribuyen al valor final de **10**. Esto nos lleva a seleccionar **Objeto 1 y Objeto 4**.

### Resultado Final
El valor máximo obtenido es **dp[4][10] = 10**, seleccionando **Objeto 1 y Objeto 4**.

---

## Conclusión
Tanto la **fuerza bruta** como la **programación dinámica** encuentran que la mejor selección es **Objeto 1 y Objeto 4**, con un **valor máximo de 10**.

