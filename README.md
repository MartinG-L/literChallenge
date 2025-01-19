# LiterChallenge

LiterChallenge es una aplicación de consola diseñada para gestionar libros y autores, permitiendo búsquedas, listados y análisis de datos relacionados con literatura. Esta aplicación utiliza una base de datos para almacenar la información y ofrece diversas funcionalidades a través de un menú interactivo.

## Características

La aplicación ofrece las siguientes funcionalidades accesibles desde un menú:

- **Buscar libro por título**  
  Permite buscar libros almacenados en la base de datos por su título.

- **Listar libros registrados**  
  Muestra un listado de todos los libros registrados en la base de datos.

- **Listar autores registrados**  
  Muestra un listado de todos los autores registrados, incluyendo detalles como fecha de nacimiento y muerte (si aplica).

- **Listar autores vivos en un determinado año**  
  Filtra y lista los autores que estaban vivos en el año especificado por el usuario.

- **Listar libros por idioma**  
  Muestra un listado de libros registrados según el idioma especificado (por ejemplo, inglés, español, finlandés, etc.).

- **Salir de la aplicación**  
  Finaliza la ejecución del programa.

## Requisitos

- **Java 17 o superior**
- **Spring Boot 3.4.1**
- **Maven** para gestionar las dependencias
- **Base de datos relacional compatible con JPA** (por ejemplo, MySQL o H2)

## Cómo ejecutar la aplicación

1. Clona el repositorio:

    ```bash
    git clone git@github.com:MartinG-L/literChallenge.git
    cd literChallenge
    ```

2. Compila y ejecuta el proyecto:

    ```bash
    mvn spring-boot:run
    ```

## Interacción con el menú

Cuando la aplicación se ejecute, se mostrará un menú interactivo en la consola. Elige una opción ingresando el número correspondiente.

### Estructura del menú

Al ejecutar el programa, el usuario verá el siguiente menú:


### Ejemplo de flujo

1. Selecciona una opción ingresando el número correspondiente.
2. Sigue las instrucciones en pantalla para completar la operación.
3. Regresa al menú principal después de completar cada operación.

## Tecnologías utilizadas

- **Java 17**: Lenguaje principal para la lógica del proyecto.
- **Spring Boot**: Framework utilizado para integrar la aplicación con la base de datos.
- **JPA**: Usado para el manejo de entidades y consultas a la base de datos.
- **Maven**: Para la gestión de dependencias.

## Mejoras futuras

- Agregar soporte para múltiples idiomas en el menú.
- Implementar validaciones adicionales para entradas del usuario.
- Guardar logs de las operaciones realizadas por los usuarios.

## Autor

Proyecto desarrollado por **Martin G-L**.
