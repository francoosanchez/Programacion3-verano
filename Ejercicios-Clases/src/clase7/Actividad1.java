package clase7;

public class Actividad1 {
    /*
    Voy a hacer una prueba de escritorio para resolver el problema de la mochila utilizando fuerza bruta y programación dinámica con una capacidad máxima de 6.

Ejemplo de Entrada:

Supongamos que tenemos los siguientes objetos con su peso y valor:

Objeto	Peso (w)	Valor (v)
1	2	3
2	3	4
3	4	5
4	5	6

Capacidad máxima de la mochila P = 6.

1. Fuerza Bruta (Backtracking o Todas las combinaciones posibles)

Se prueban todas las combinaciones posibles de objetos y se selecciona la que maximiza el valor sin superar el peso permitido.

Generamos todas las combinaciones posibles:

Conjuntos válidos:
	1.	(Objeto 1, Objeto 2) → Peso = 2+3=5, Valor = 3+4=7 ✅
	2.	(Objeto 1, Objeto 3) → Peso = 2+4=6, Valor = 3+5=8 ✅
	3.	(Objeto 2, Objeto 3) → Peso = 3+4=7 (excede) ❌
	4.	(Objeto 1, Objeto 4) → Peso = 2+5=7 (excede) ❌
	5.	(Objeto 2, Objeto 4) → Peso = 3+5=8 (excede) ❌
	6.	(Objeto 3, Objeto 4) → Peso = 4+5=9 (excede) ❌
	7.	(Solo Objeto 1) → Peso = 2, Valor = 3 ✅
	8.	(Solo Objeto 2) → Peso = 3, Valor = 4 ✅
	9.	(Solo Objeto 3) → Peso = 4, Valor = 5 ✅
	10.	(Solo Objeto 4) → Peso = 5, Valor = 6 ✅

🔹 La mejor combinación es (Objeto 1, Objeto 3) con un valor máximo de 8.

2. Programación Dinámica (Método de la Mochila 0/1)

Se utiliza una tabla dp donde dp[i][j] representa el máximo valor posible usando los primeros i objetos y una capacidad j.

Tabla DP

Estado Inicial (dp se llena con 0s al inicio)

i / j	0	1	2	3	4	5	6
0	0	0	0	0	0	0	0
1	0	0	3	3	3	3	3
2	0	0	3	4	4	7	7
3	0	0	3	4	5	7	8
4	0	0	3	4	5	7	8

Explicación del llenado de la tabla dp
	1.	dp[1][j] → Solo Objeto 1:
	•	Solo puede entrar si j >= 2. En ese caso, el valor es 3.
	2.	dp[2][j] → Consideramos Objeto 2:
	•	Si j < 3, copiamos dp[1][j].
	•	Si j >= 3, tomamos el máximo entre no tomar el objeto (dp[1][j]) o tomarlo (valor_objeto2 + dp[1][j-3]).
	3.	dp[3][j] → Consideramos Objeto 3:
	•	Aplicamos la misma lógica, revisando si incluir el objeto mejora el valor.
	4.	dp[4][j] → Consideramos Objeto 4:
	•	La mejor solución sigue siendo 8, por lo que no cambia.

🔹 Valor óptimo dp[4][6] = 8, que coincide con la solución de fuerza bruta.

Conclusión
	•	Ambos métodos encuentran la mejor solución con un valor máximo de 8.
	•	Fuerza bruta explora todas las combinaciones posibles (exponencial).
	•	Programación dinámica usa una tabla dp, reduciendo el tiempo a O(n*P).

📌 Para problemas grandes, la programación dinámica es mucho más eficiente.
     */

}
