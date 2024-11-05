# Curso Java: Persistencia de datos con JPA

# Proyecto de Búsqueda y Gestión de Series

Este proyecto permite a los usuarios buscar series en una API externa y gestionar la información obtenida utilizando técnicas avanzadas de Java. Implementa principios de encapsulamiento, patrones de diseño, y manipulación de bases de datos, además de integrarse con herramientas como PostgreSQL y la API de ChatGPT para traducción.

## Funcionalidades

### Búsqueda de Series
- **Búsqueda en bucle**: Permite buscar múltiples series en la API, manteniendo el ciclo de búsqueda activo hasta que el usuario elija salir.
- **Datos adicionales**: Se mapean los atributos de la API para enriquecer la información mostrada al usuario.
- **Conversión de datos**: Los datos obtenidos de la API se transforman en instancias de la clase `Serie` para una mejor representación.

### Encapsulamiento y Métodos Privados
- **Encapsulación**: Los métodos utilizados exclusivamente dentro de una clase están declarados como privados, promoviendo la seguridad y eficiencia del código.

### Manejo de Excepciones
- **"If reducido" con OptionalDouble**: Uso de `OptionalDouble` para manejar valores decimales y errores potenciales mediante los métodos `of` y `orElse`.

### Enums y Clasificación de Series
- **Categorías por género**: Implementación de un `enum` para categorizar las series y creación de métodos personalizados dentro del enum.

### Integración con la API de ChatGPT
- **Traducción de datos**: Integración con la API de ChatGPT para traducir información obtenida, configurando las dependencias necesarias para la conexión.

## Configuración de la Base de Datos con PostgreSQL
1. **Instalación y configuración**: Diferenciación entre bases de datos relacionales y no relacionales, y creación de una base de datos PostgreSQL específica para series.
2. **Configuración en `application.properties`**: Añadir la dependencia JPA al `pom.xml` y configurar los detalles de conexión en el archivo de propiedades.

### Anotaciones de Hibernate
- **Mapeo de entidades**: Uso de anotaciones como `@Entity`, `@Column`, y `@Transient` en la clase `Serie` para mapear correctamente los datos en la base de datos.

### Manipulación de Repositorios
- **Clase `SerieRepository`**: Creación de una interfaz `Repository` para realizar operaciones CRUD, utilizando la anotación `@Autowired` para la inyección de dependencias.

### Seguridad y Variables de Entorno
- **Protección de datos sensibles**: Configuración de variables de entorno para ocultar detalles sensibles de conexión.

## Relaciones entre Entidades y JPA
- **Mapeo de relaciones**: Implementación de anotaciones como `@OneToMany` y `@ManyToOne` para identificar la relación entre series y episodios.
- **Tipos de relación**: Explicación y configuración de relaciones como "uno a muchos" y "muchos a uno".
- **Uso de claves foráneas**: Comprensión de claves foráneas para representar relaciones en bases de datos.

### Configuración de Cascade y Carga de Datos
- **Configuración Cascade**: Uso de `Cascade` para gestionar el flujo de guardado de series y episodios.
- **Estrategias de carga de datos**: Configuración de `fetch` para carga "lazy" o "eager", optimizando el rendimiento.

### Relaciones Bidireccionales
- **Sincronización de datos**: Configuración para que los cambios en la relación `Serie-Episodios` se reflejen en ambas direcciones.

## Consultas y Búsquedas en JPA
- **Consultas derivadas**: Uso de palabras clave en los métodos del `Repository` para realizar búsquedas personalizadas.
- **Streams vs. búsquedas en la base de datos**: Comparación entre el uso de streams y las consultas JPA para optimizar las operaciones de búsqueda.

### Ejecución de Búsquedas Avanzadas
- **Tipos de retorno**: Diferencias entre retornar una serie individual, una lista o un `Optional`.
- **Mapeo dinámico con Enums**: Configuración para mapear valores ingresados en los campos del enum.


