package clase13;

public class Actividad1 {
    /*
1. Ejemplos de Acciones Posibles del Atacante

Un atacante podría intentar realizar las siguientes acciones maliciosas sobre la plataforma web:
	•	Fuerza bruta: Intentar múltiples combinaciones de usuario y contraseña para acceder a una cuenta.
	•	SQL Injection: Ingresar comandos SQL en los campos de entrada para manipular la base de datos.
	•	Cross-Site Scripting (XSS): Inyectar scripts maliciosos en la plataforma para atacar a otros usuarios.
	•	DDoS (Denegación de servicio distribuida): Enviar múltiples solicitudes para sobrecargar el servidor.
	•	Escaneo de puertos: Buscar servicios abiertos en el servidor para identificar vulnerabilidades.
	•	Ataques de phishing: Engañar a los usuarios para que revelen credenciales sensibles.

2. Funciones del Sistema de Detección de Ataques

El sistema de detección debe cumplir con las siguientes funciones:
	•	Monitoreo de tráfico en tiempo real: Analizar patrones de tráfico y detectar anomalías.
	•	Análisis de logs: Revisar registros de actividad en busca de intentos sospechosos de acceso.
	•	Filtrado de tráfico malicioso: Bloquear direcciones IP que realicen ataques repetidos.
	•	Detección de patrones de ataque: Usar reglas predefinidas para identificar intentos de inyección de código.
	•	Autenticación reforzada: Implementar mecanismos como CAPTCHA o autenticación multifactor.

Técnicas y herramientas para la detección de ataques

El sistema puede utilizar las siguientes herramientas para detectar ataques:
	•	Sistemas de Detección de Intrusos (IDS): Como Snort o Suricata, para analizar paquetes de red.
	•	Machine Learning: Algoritmos que identifican comportamientos sospechosos basados en datos históricos.
	•	Reglas de firewall avanzadas: Configuración de reglas específicas para bloquear tráfico sospechoso.
	•	Análisis de firmas: Comparar el tráfico con bases de datos de amenazas conocidas.
	•	Sandboxing: Ejecutar archivos sospechosos en un entorno aislado para analizar su comportamiento.

3. Aplicación de la poda alfa-beta

La poda alfa-beta es una técnica utilizada en algoritmos de búsqueda en árboles de decisión para reducir la cantidad de nodos evaluados en un problema de toma de decisiones, como la detección de ataques.

Aplicación en ciberseguridad

Supongamos que el sistema tiene que decidir si una actividad es maliciosa o no. Un árbol de decisión puede evaluar diferentes características, como la frecuencia de solicitudes, los patrones de acceso y las direcciones IP involucradas.
	•	Nodo “Fuerza Bruta Detectada”: Si un usuario intenta iniciar sesión muchas veces en poco tiempo, el sistema debe decidir si bloquearlo.
	•	Poda Alfa-Beta: Si el sistema ya detectó suficientes señales de ataque (por ejemplo, intentos fallidos desde múltiples IPs en poco tiempo), no es necesario evaluar más nodos, optimizando la detección y respuesta.

4. Árbol de decisión simplificado

Aquí tienes un esquema básico de un árbol de decisión para detectar un ataque:

                     [Inicio de sesión sospechoso]
                               |
              ----------------------------------
              |                                |
  [Múltiples intentos fallidos?]    [Acceso desde ubicación desconocida?]
        |                                 |
   -----------                        -------------
   |         |                        |           |
[Sí]       [No]                  [Sí]         [No]
   |         |                        |           |
[Bloquear] [Monitorear]          [Requerir MFA] [Acceso permitido]

Este árbol ayuda al sistema a decidir si debe bloquear, monitorear o permitir una acción basada en ciertos criterios. Se puede ampliar con más nodos para incluir ataques como SQL Injection, DDoS o XSS.

     */
}
