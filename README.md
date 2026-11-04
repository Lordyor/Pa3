# README — PA3: Algoritmos y Estructuras de Datos

> **Curso:** ALGORITMO Y ESTRUCTURA DE DATOS BASADOS EN INTELIGENCIA ARTIFICIAL
> **Código:**   4682
> **Evaluación:** PA3  

## 1. Integrantes

| Integrante | Rol |
|---|---|
| Roy Granados Aguilar | Desarrollo de la Actividad | 
| Jorge Zuniga | Desarrollo de la Actividad 2 |
| Cesar Chavero | Desarrollo de la Actividad 4 |
| Imanol Ponce de León | Desarrollo de la Actividad 3 |
| Josept | Desarrollo de la Actividad 1 |



### Actividad 1. Pila LIFO
### 1. ¿Qué caracteriza a una estructura LIFO?

LIFO (*Last In, First Out*) significa que **el último elemento en entrar es el primero en salir**. Una pila es una estructura lineal de acceso restringido: solo se inserta y se elimina por un extremo, llamado **tope**. Sus operaciones principales son O(1).

### 2. Caso y representación gráfica

La unidad de servicios académicos debe **deshacer acciones en orden inverso al que se registraron** (cambiar una nota, cambiar un horario, corregir un dato de matrícula). Cada acción se apila al registrarla y se desapila al deshacerla.

```
apilar(A1)       apilar(A2)       apilar(A3)       desapilar() -> A3
                                  |  A3  | <- tope   |  A2  | <- tope
                 |  A2  | <- tope |  A2  |           |  A1  |
|  A1  | <- tope |  A1  |         |  A1  |
+------+         +------+         +------+           +------+
```

El orden de salida es **A3 → A2 → A1**, inverso al de registro.

### 3. Algoritmos (pseudocódigo)

```
Estructura Pila
    datos ← lista vacía
    tope ← -1                    // -1 indica pila vacía
Fin Estructura

Función estaVacia(P) : Booleano
    Retornar (P.tope = -1)
Fin Función

Procedimiento apilar(P, elemento)
    P.tope ← P.tope + 1
    P.datos[P.tope] ← elemento
Fin Procedimiento

Función desapilar(P) : Elemento
    Si estaVacia(P) entonces
        Mostrar "Error: pila vacía"
        Retornar NULO
    Fin Si
    elemento ← P.datos[P.tope]
    P.tope ← P.tope - 1
    Retornar elemento
Fin Función

Función verTope(P) : Elemento
    Si estaVacia(P) entonces
        Mostrar "La pila está vacía"
        Retornar NULO
    Fin Si
    Retornar P.datos[P.tope]     // consulta sin eliminar
Fin Función
```

**Prueba de escritorio**

| Operación | Contenido (base → tope) | Resultado |
|---|---|---|
| inicio | [ ] | estaVacia = Verdadero |
| apilar("Cambiar nota") | [Cambiar nota] | |
| apilar("Cambiar horario") | [Cambiar nota, Cambiar horario] | |
| verTope() | sin cambios | "Cambiar horario" |
| desapilar() | [Cambiar nota] | "Cambiar horario" |
| desapilar() | [ ] | "Cambiar nota" |
| desapilar() | [ ] | Error: pila vacía |

### 4. Aplicación concreta en el caso

**Historial de acciones para deshacer (Undo) en el sistema académico.** Cada modificación de un registro se apila; al pulsar "Deshacer", `desapilar()` revierte **la última acción realizada**, luego la anterior, y así sucesivamente.

La pila es la estructura más adecuada porque deshacer exige revertir en **orden inverso** al registro. Con otro orden, el sistema quedaría inconsistente, ya que una acción reciente puede depender de las anteriores. Con LIFO el acceso es directo al tope, en O(1).



### Actividad 2. Cola FIFO


### Actividad 3. Selección de estructura para situaciones reales

A continuación se analiza y determina la estructura de datos lineal (Pila LIFO o Cola FIFO) correspondiente a cada situación operativa planteada en el caso de la unidad de servicios académicos, adjuntando su respectiva fundamentación técnica.

---

### Tabla de Clasificación y Selección

| Situación Real | Estructura Seleccionada | Justificación Técnica |
| :--- | :--- | :--- |
| **1. Registro de acciones recientes para revertir cambios** | **Pila (LIFO)** | La reversión de estados exige un acceso inverso a la secuencia de eventos. La pila permite extraer el elemento ubicado en el tope (*último en entrar*), garantizando deshacer la modificación más reciente para restaurar el sistema al estado inmediatamente anterior. |
| **2. Atención de solicitudes en orden de llegada** | **Cola (FIFO)** | Respetando el principio de equidad, el primer elemento en ingresar al sistema por el extremo posterior (*Rear*) debe ser el primero en ser atendido por el extremo anterior (*Front*). Preserva el orden cronológico estricto de llegada. |
| **3. Procesamiento donde el último ingresado debe atenderse primero** | **Pila (LIFO)** | Esta regla de negocio coincide directamente con el comportamiento destructivo por el tope característico de las pilas. La estructura otorga prioridad absoluta de extracción al elemento con menor tiempo de permanencia. |
| **4. Flujo de espera de trámites pendientes** | **Cola (FIFO)** | Modela un *buffer* o fila de espera secuencial. Evita el fenómeno de postergación indefinida (*starvation*), asegurando que todas las solicitudes completen su ciclo de procesamiento en función de su antigüedad en la fila. |

---

### Justificación Técnica Detallada

1. **Registro de acciones para revertir cambios (Pila - LIFO):**
   * **Mapeo:** Mecanismo de *Undo/Redo*.
   * **Explicación:** Al modificar registros o notas, cada operación se apila. Para revertir un error, se ejecuta una operación `desapilar()` (`pop`), obteniendo el último cambio realizado. Utilizar una cola rompería la integridad del sistema al deshacer la primera acción histórica en lugar de la más reciente.

2. **Atención de solicitudes en orden de llegada (Cola - FIFO):**
   * **Mapeo:** Gestión de turnos y peticiones HTTP/Tickets.
   * **Explicación:** Garantiza imparcialidad. Las inserciones se realizan con `encolar()` (`enqueue`) al final de la cola y las atenciones se procesan con `desencolar()` (`dequeue`) al frente, asegurando un tiempo de respuesta justo según la llegada.

3. **Procesamiento del último ingresado primero (Pila - LIFO):**
   * **Mapeo:** Evaluación de expresiones / Manejo de llamadas a funciones (Call Stack).
   * **Explicación:** El punto de acceso único (Tope) restringe la salida a los elementos recién ingresados. Es la única estructura lineal que satisface de forma nativa la restricción de atender con prioridad al último registro sin necesidad de reordenar o reorganizar los datos.

4. **Flujo de espera de trámites pendientes (Cola - FIFO):**
   * **Mapeo:** Cola de impresión / Procesamiento asíncrono de tareas (*Job Queue*).
   * **Explicación:** Permite administrar la concurrencia de trámites administrativos entrantes cuando la capacidad de atención es limitada, ordenando las solicitudes en una fila temporal donde el orden de salida es idéntico al de entrada.

## Actividad 4. Comparación y Argumentación

### 1. Comparación Académica entre Pila (LIFO) y Cola (FIFO)

Para evaluar y contrastar ambas estructuras de datos lineales en el contexto del caso planteado, se presentan sus diferencias fundamentales en la siguiente tabla comparativa:

| Eje de Comparación | Estructura Pila (LIFO) | Estructura Cola (FIFO) |
| :--- | :--- | :--- |
| **Principio de funcionamiento** | **LIFO** (*Last In, First Out* / Último en entrar, primero en salir). El último elemento ingresado es el primero en ser procesado o retirado. | **FIFO** (*First In, First Out* / Primero en entrar, primero en salir). El primer elemento ingresado es el primero en ser atendido o retirado. |
| **Operaciones principales** | • `apilar` (*push*): Agrega un elemento en la cima/tope.<br>• `desapilar` (*pop*): Retira el elemento de la cima/tope.<br>• `tope` (*peek/top*): Consulta el elemento superior sin extraerlo.<br>• `esta_vacia`: Verifica si la pila carece de elementos. | • `encolar` (*enqueue*): Agrega un elemento al final de la cola.<br>• `desencolar` (*dequeue*): Retira el elemento ubicado al frente.<br>• `frente` (*front/peek*): Consulta el primer elemento sin extraerlo.<br>• `esta_vacia`: Verifica si la cola carece de elementos. |
| **Forma de acceso** | **Restringida a un solo extremo** denominado **tope** (*top*). No es posible acceder directamente a los elementos inferiores sin remover previamente los superiores. | **Restringida a ambos extremos**: Las inserciones se realizan exclusivamente por el **final** (*rear*) y las extracciones por el **frente** (*front*). |
| **Ventajas en contextos de aplicación** | Ideal para mecanismos de reversión o deshacer acciones (*undo*), evaluación de expresiones algebraicas, navegadores (historial de páginas) y gestión de la pila de llamadas (*call stack*). | Garantiza equidad e imparcialidad en la atención de solicitudes por orden de llegada, manejo de impresiones en red, procesamiento de trámites y buffers de datos. |

---

### 2. Conclusión Grupal

La selección adecuada de una estructura de datos —ya sea una **pila** o una **cola**— constituye una decisión técnica fundamental en el diseño de software, pues incide de manera directa en el rendimiento, la mantenibilidad y la coherencia lógica de la solución frente a los requerimientos del sistema.

Por un lado, las **pilas** son óptimas cuando el flujo operativo requiere deshacer acciones recientes o revertir estados en orden inverso al de su registro (comportamiento LIFO). Por otro lado, las **colas** garantizan un flujo de atención equitativo, ordenado e imparcial, respetando de manera estricta la secuencia cronológica en la que ingresan las solicitudes (comportamiento FIFO). 

En consecuencia, fundamentar correctamente la elección de la estructura de datos no solo previene fallas de procesamiento y reduce la complejidad algorítmica, sino que asegura que la arquitectura del sistema refleje fielmente las reglas de negocio planteadas.

---

### 3. Video

https://youtu.be/fNLk8xx4-o8

