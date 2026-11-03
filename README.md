# README — PA3: Algoritmos y Estructuras de Datos

> **Curso:** ALGORITMO Y ESTRUCTURA DE DATOS BASADOS EN INTELIGENCIA ARTIFICIAL
> **Código:**   4682
> **Evaluación:** PA3  

## 1. Integrantes

| Integrante | Rol |
|---|---|
| Roy Granados Aguilar | Desarrollo de la Actividad 1 | 
| Jorge Zuniga | Desarrollo de la Actividad 2 |
| Cesar Chavero | Desarrollo de la Actividad |
| Imanol Ponce de León | Desarrollo de la Actividad 3 |
| Josept | Desarrollo de la Actividad |



### Actividad 1. Pila LIFO


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

### Actividad 4. Comparación y argumentación
