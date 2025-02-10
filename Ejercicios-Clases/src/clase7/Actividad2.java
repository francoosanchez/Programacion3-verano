package clase7;

public class Actividad2 {
    /*
    Para resolver este problema, tenemos dos enfoques: fuerza bruta y programación dinámica. Vamos a hacer una prueba de escritorio para ambos métodos, suponiendo que tenemos los siguientes objetos con su peso (w) y valor (v):

Objeto	Peso (w)	Valor (v)
1	2	3
2	3	4
3	4	5
4	5	6
5	6	8

Y la capacidad máxima de la mochila es 10.

1. Enfoque de Fuerza Bruta:

En fuerza bruta, probamos todas las combinaciones posibles de objetos, y para cada combinación, verificamos si el peso total no excede la capacidad de la mochila y si el valor es máximo.

Combinaciones posibles:
	•	{Objeto 1}: peso = 2, valor = 3
	•	{Objeto 2}: peso = 3, valor = 4
	•	{Objeto 3}: peso = 4, valor = 5
	•	{Objeto 4}: peso = 5, valor = 6
	•	{Objeto 5}: peso = 6, valor = 8
	•	{Objeto 1, 2}: peso = 5, valor = 7
	•	{Objeto 1, 3}: peso = 6, valor = 8
	•	{Objeto 1, 4}: peso = 7, valor = 9
	•	{Objeto 1, 5}: peso = 8, valor = 11
	•	{Objeto 2, 3}: peso = 7, valor = 9
	•	{Objeto 2, 4}: peso = 8, valor = 10
	•	{Objeto 2, 5}: peso = 9, valor = 12
	•	{Objeto 3, 4}: peso = 9, valor = 11
	•	{Objeto 3, 5}: peso = 10, valor = 13
	•	{Objeto 4, 5}: peso = 11, valor = 14 (excede la capacidad)
	•	{Objeto 1, 2, 3}: peso = 9, valor = 12
	•	{Objeto 1, 2, 4}: peso = 10, valor = 13
	•	{Objeto 1, 2, 5}: peso = 11, valor = 15 (excede la capacidad)
	•	{Objeto 1, 3, 4}: peso = 11, valor = 14 (excede la capacidad)
	•	{Objeto 1, 3, 5}: peso = 12, valor = 16 (excede la capacidad)
	•	{Objeto 1, 4, 5}: peso = 13, valor = 17 (excede la capacidad)
	•	{Objeto 2, 3, 4}: peso = 12, valor = 15 (excede la capacidad)
	•	{Objeto 2, 3, 5}: peso = 13, valor = 17 (excede la capacidad)
	•	{Objeto 2, 4, 5}: peso = 14, valor = 18 (excede la capacidad)
	•	{Objeto 3, 4, 5}: peso = 15, valor = 19 (excede la capacidad)
	•	{Objeto 1, 2, 3, 4}: peso = 14, valor = 18 (excede la capacidad)
	•	{Objeto 1, 2, 3, 5}: peso = 15, valor = 19 (excede la capacidad)
	•	{Objeto 1, 2, 4, 5}: peso = 16, valor = 20 (excede la capacidad)
	•	{Objeto 1, 3, 4, 5}: peso = 17, valor = 21 (excede la capacidad)
	•	{Objeto 2, 3, 4, 5}: peso = 18, valor = 22 (excede la capacidad)
	•	{Objeto 1, 2, 3, 4, 5}: peso = 20, valor = 23 (excede la capacidad)

Valor máximo en la fuerza bruta: 13 (combinación de los objetos 3 y 5, peso 10).

2. Enfoque de Programación Dinámica:

Para este enfoque, utilizamos una tabla dp donde dp[i][j] representa el valor máximo alcanzable con los primeros i objetos y una capacidad de mochila de j. Inicializamos la primera fila y columna de la tabla con ceros (si no hay objetos o la capacidad es 0, el valor es 0).

Paso 1: Inicialización

i/j	0	1	2	3	4	5	6	7	8	9	10
0	0	0	0	0	0	0	0	0	0	0	0
1	0	0	3	3	3	3	3	3	3	3	3
2	0	0	3	4	4	4	7	7	7	7	7
3	0	0	3	4	5	5	7	9	9	9	9
4	0	0	3	4	5	6	7	9	10	10	13
5	0	0	3	4	5	6	8	9	12	12	13

Paso 2: Llenado de la tabla dp:
	•	Para cada objeto, verificamos si lo podemos incluir en la mochila (es decir, si el peso del objeto no excede la capacidad restante). Si lo incluimos, sumamos el valor del objeto y miramos si el valor obtenido es mayor que no incluirlo.
	•	Llenamos la tabla según esta lógica.

Paso 3: Resultado

El valor máximo alcanzable está en dp[5][10], que es 13, lo que coincide con el resultado de la fuerza bruta.

Resumen:
	•	Fuerza bruta: El valor máximo es 13 con la combinación de objetos 3 y 5.
	•	Programación dinámica: El valor máximo es 13, y se encuentra en la celda dp[5][10].

Ambos métodos nos dan el mismo resultado, pero la programación dinámica es mucho más eficiente al evitar tener que probar todas las combinaciones posibles.
     */
}
