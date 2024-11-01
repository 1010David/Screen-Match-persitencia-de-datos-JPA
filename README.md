# Curso Java: Trabajando con Lambdas, Streams y Spring Framework

Este proyecto fue desarrollado como parte del curso de Java, en el cual aprendimos a trabajar con **lambdas**, **streams** y el **Spring Framework**. A lo largo del curso, hemos abordado diversos temas relacionados con la estructura de proyectos Spring, el uso de APIs, la modularización de código, el manejo de excepciones y más.

## Contenido del Curso

### 1. Estructura de un Proyecto Spring
- **Objetivo**: Comprender la estructura inicial de un proyecto Spring.
- **Detalles**: Exploramos los paquetes, clases principales y el método `run` que arranca la aplicación Spring.

### 2. Inferencia de Tipos en Java
- **Objetivo**: Utilizar la inferencia de tipos con `var` para escribir código más limpio.
- **Detalles**: Se mostró cómo `var` permite que el compilador infiera el tipo de una variable.

### 3. Consumo de APIs
- **Objetivo**: Aprender a consumir APIs externas.
- **Detalles**: Implementamos el método `obtenerDatos` para consumir una API y obtener datos en formato JSON.

### 4. Modularización de Código
- **Objetivo**: Mantener el código organizado y fácil de mantener.
- **Detalles**: Se discutió la importancia de dividir el código en módulos.

### 5. Serialización y Deserialización
- **Objetivo**: Trabajar con JSON en Java.
- **Detalles**: Aprendimos a convertir JSON en clases Java, facilitando el manejo de datos provenientes de APIs.

### 6. Creación de Interfaces e Implementación de Métodos
- **Objetivo**: Implementar métodos genéricos utilizando interfaces.
- **Detalles**: Creamos una interfaz con Generics y la implementamos en clases separadas.

### 7. Inclusión de Dependencias con Maven
- **Objetivo**: Agregar nuevas librerías al proyecto.
- **Detalles**: Vimos cómo añadir dependencias en el archivo `pom.xml` y cómo Maven las gestiona.

### 8. APIs y Consultas Detalladas
- **Objetivo**: Realizar consultas más específicas a APIs.
- **Detalles**: Aprendimos a trabajar con APIs para obtener información detallada.

### 9. Uso de Anotaciones @JsonAlias y @JsonIgnoreProperties
- **Objetivo**: Mapear correctamente los datos de la API a nuestra aplicación.
- **Detalles**: Usamos estas anotaciones para manejar correctamente los datos que recibimos de una API.

### 10. Introducción a las Funciones Lambda
- **Objetivo**: Escribir código más conciso utilizando lambdas.
- **Detalles**: Aprendimos la sintaxis de las expresiones lambda y sus beneficios.

### 11. Uso de Streams en Java
- **Objetivo**: Manipular flujos de datos de manera eficiente.
- **Detalles**: Exploramos cómo usar streams para realizar operaciones como el filtrado, mapeo y reducción de datos.

### 12. Filtrado de Datos
- **Objetivo**: Seleccionar datos específicos de un flujo.
- **Detalles**: Utilizamos streams para filtrar episodios de series de televisión con una calificación específica.

### 13. Manipulación de Fechas
- **Objetivo**: Trabajar con fechas en Java.
- **Detalles**: Convertimos cadenas en `LocalDate` y manejamos excepciones como `DateTimeParseException`.

### 14. Manejo de Excepciones
- **Objetivo**: Capturar y manejar excepciones específicas.
- **Detalles**: Implementamos el manejo de excepciones como `NumberFormatException` y `DateTimeParseException`.

### 15. Interacción con el Usuario
- **Objetivo**: Crear una interfaz para que el usuario interactúe con el programa.
- **Detalles**: Desarrollamos un menú para que el usuario pueda buscar series y episodios.

### 16. Manipulación de Datos de una API
- **Objetivo**: Importar y manipular datos de una API externa.
- **Detalles**: Implementamos la lógica para consumir y manipular datos relacionados con series de televisión.

### 17. Manipulación de Cadenas para Acceder a una API
- **Objetivo**: Formatear cadenas correctamente para realizar consultas a una API.
- **Detalles**: Mostramos cómo manipular las URL para realizar consultas a una API y obtener los resultados deseados.

### 18. Introducción a las Expresiones Lambda
- **Objetivo**: Aprender a usar las expresiones lambda para simplificar el código.
- **Detalles**: Exploramos cómo las funciones anónimas pueden mejorar la eficiencia y legibilidad del código.

- ### 19. Uso de la Función peek
- **Objetivo**: Facilitar la depuración dentro de un Stream.
- **Detalles**: Se introdujo la función `peek`, que permite visualizar los elementos en cada etapa del Stream, ayudando a verificar y depurar el flujo de datos en tiempo real.

### 20. Operaciones Intermedias y Finales en Streams
- **Objetivo**: Manipular y extraer datos de forma eficiente.
- **Detalles**: Aprendimos a utilizar operaciones como `map`, `filter` y `find`, que nos permiten transformar, filtrar y encontrar datos específicos dentro de un Stream.

### 21. Uso de Optional para Evitar Nulos
- **Objetivo**: Evitar errores de referencia nula al trabajar con datos opcionales.
- **Detalles**: Se exploró el uso de `Optional` como un contenedor seguro para almacenar episodios y evitar errores de `NullPointerException` dentro de los flujos de datos.

### 22. DoubleSummaryStatistics
- **Objetivo**: Analizar estadísticas en los datos de calificación.
- **Detalles**: Usamos la clase `DoubleSummaryStatistics` para calcular la calificación más alta, la más baja y el total de evaluaciones de nuestras series, permitiendo obtener una visión detallada de los datos numéricos.


## Tecnologías Utilizadas
- **Java 11+**
- **Spring Framework**
- **Maven**
- **JSON**
- **Lambdas y Streams**

## Cómo ejecutar el proyecto
1. Clonar el repositorio.
2. Importar el proyecto en tu IDE preferido (IntelliJ, Eclipse, etc.).
3. Ejecutar el proyecto utilizando el archivo `main` de la aplicación Spring.
4. Asegúrate de tener configuradas las dependencias correctamente en el archivo `pom.xml`.

## Contribuciones
Este proyecto es parte de un curso y no está abierto a contribuciones externas por el momento.

## Autor
Desarrollado como parte de un curso de Java centrado en lambdas, streams y Spring Framework.

