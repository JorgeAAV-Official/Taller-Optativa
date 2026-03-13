INTEGRANTES:
Jorge Alejandro Arias Vargas // Huver Olaya Méndez

Preguntas para análisis:

¿Qué diferencia existe entre paralelismo y concurrencia?

•	Concurrencia: Es la capacidad de un sistema para manejar múltiples tareas que inician, se ejecutan y se completan en períodos de tiempo superpuestos. No necesariamente significa que se ejecuten en el mismo instante; el sistema puede alternar rápidamente entre ellas (intercalado).

•	Paralelismo: Ocurre cuando las tareas se ejecutan literalmente al mismo tiempo. Esto requiere hardware con múltiples núcleos o procesadores donde cada hilo corre de forma simultánea e independiente.

¿Qué problema ocurre cuando varios hilos acceden al mismo recurso

Rta: Cuando varios hilos acceden y modifican un recurso compartido (como una variable o un archivo) sin control, se producen inconsistencias de datos.
Un hilo puede leer un valor, ser interrumpido, y cuando vuelve a actuar, el valor ya ha sido cambiado por otro hilo, provocando que el resultado final sea incorrecto o que la aplicación falle (corrupción de estado).

¿Qué es una condición de carrera (Race Conditión)

Rta: Es una situación anómala que sucede cuando el resultado de un programa depende del orden o la sincronización crítica de eventos que no están bajo control.
En programación multihilo, ocurre cuando dos o más hilos intentan modificar un dato compartido al mismo tiempo. El resultado final "depende de quién gane la carrera" para llegar primero, lo que hace que el error sea intermitente y difícil de detectar.

¿Por qué es importante sincronizar el acceso a recuersos compartidos?

Rta: La sincronización es vital porque establece un mecanismo de exclusión mutua. Esto garantiza que solo un hilo pueda acceder a una sección crítica de código o a un recurso compartido a la vez.
Sin ella, es imposible asegurar la integridad de los datos en aplicaciones concurrentes, como el ejemplo de la cuenta bancaria del taller, donde varios retiros simultáneos podrían dejar el saldo en negativo si no se bloquea el acceso durante la operación.
