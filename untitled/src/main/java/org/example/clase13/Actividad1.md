## **Actividad 1**

### **1. Ejemplos de Acciones Posibles del Atacante**
Algunas acciones maliciosas que un atacante podría realizar incluyen:

- **Fuerza bruta**: Intentar múltiples combinaciones de usuario y contraseña para acceder a cuentas.
- **Inyección SQL**: Enviar consultas SQL maliciosas para obtener datos no autorizados.
- **Cross-Site Scripting (XSS)**: Inyectar scripts maliciosos en páginas web para robar información del usuario.
- **Denegación de Servicio (DoS/DDoS)**: Saturar el servidor con tráfico para dejar la plataforma inoperativa.
- **Phishing**: Engañar a los usuarios para que revelen credenciales mediante sitios web falsos.

---

### **2. Funciones del Sistema de Detección y Técnicas de Mitigación**
El sistema debe identificar y mitigar estos ataques con técnicas como:

- **Monitoreo de tráfico en tiempo real**: Analizar patrones de solicitudes HTTP para detectar anomalías.
- **Firewalls y WAF (Web Application Firewall)**: Bloquear peticiones sospechosas antes de que lleguen al servidor.
- **Sistemas de detección de intrusos (IDS/IPS)**: Registrar y bloquear intentos de acceso malicioso.
- **Limitación de intentos de inicio de sesión**: Prevenir ataques de fuerza bruta bloqueando IPs tras varios intentos fallidos.
- **Escaneo de código y sanitización de entradas**: Evitar inyecciones SQL y XSS mediante validaciones seguras.
- **Análisis de comportamiento con IA**: Usar modelos de aprendizaje automático para detectar patrones inusuales de uso.

---

### **3. Aplicación de la Poda Alfa-Beta**
La **poda alfa-beta** es una optimización del algoritmo *Minimax*, usado en toma de decisiones. Se aplicaría en este sistema para reducir el número de escenarios de ataque a evaluar, descartando caminos no óptimos en función de reglas predefinidas.

**Ejemplo de aplicación:**
- En un sistema de detección de intrusos, se pueden evaluar múltiples señales de alerta (número de intentos de login, solicitudes sospechosas, etc.).
- Con poda alfa-beta, si un patrón de ataque ya es altamente sospechoso, no es necesario evaluar características adicionales, optimizando la detección y reduciendo el procesamiento.

---

### **4. Árbol de Decisión Simplificado**

```plaintext
                 Inicio de Sesión
                 /        |        \
     Exitoso  Fallido(1)  Fallido(2+)
                |             |
                |             -> Revisión de IP
                |                /       \
                |        Confiable  Sospechosa
                |             |         |
                |             |   Bloqueo Temporal
                |             |  
                |      Intento Repetido
                |             |
                |     Bloqueo Permanente
                |
            Análisis Adicional
```

Este árbol de decisión evalúa intentos de acceso y define acciones como bloqueo temporal o permanente dependiendo de la cantidad y comportamiento de los intentos.

---

Este esquema representa un sistema de defensa básico, pero puede expandirse con técnicas más avanzadas de ciberseguridad.

