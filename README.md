# Cliente API

Esta es una API RESTful para gestionar datos de clientes, construida con Spring Boot. La API permite a los usuarios realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en los registros de clientes.

## Características

- **Obtener todos los clientes**: Recupera una lista de todos los clientes.
- **Obtener cliente por ID**: Recupera los detalles de un cliente específico por su ID.
- **Crear cliente**: Añade un nuevo registro de cliente.
- **Actualizar cliente**: Actualiza un registro de cliente existente.
- **Eliminar cliente**: Elimina un registro de cliente.

## Endpoints

| Método HTTP | Endpoint               | Descripción                           |
|-------------|------------------------|---------------------------------------|
| GET         | `/api/v1/clientes`     | Obtener todos los clientes            |
| GET         | `/api/v1/cliente/{id}` | Obtener cliente por ID                |
| POST        | `/api/v1/cliente`      | Crear un nuevo cliente                |
| PUT         | `/api/v1/cliente/{id}` | Actualizar un cliente existente       |
| DELETE      | `/api/v1/cliente/{id}` | Eliminar un cliente por ID            |

## Formatos de Solicitud y Respuesta

Todas las solicitudes y respuestas utilizan el formato JSON.

### Ejemplo de un DTO de Cliente

```json
{
  "id": 1,
  "nombre": "John",
  "apellido": "Doe",
  "correo": "john.doe@example.com",
  "registro": "2023-08-28T14:41:31"
}
```

### Manejo de Errores
La API utiliza un manejo estructurado de errores con códigos de estado HTTP apropiados:

- 200 OK: La solicitud fue exitosa.
- 201 Created: El recurso se creó con éxito.
- 204 No Content: El recurso se eliminó con éxito.
- 400 Bad Request: La solicitud es inválida o no se puede procesar.
- 404 Not Found: El recurso solicitado no se encontró.
- 500 Internal Server Error: Ocurrió un error en el servidor.


### Acceso a Datos y Manejo de Excepciones
- Acceso a Datos: La API utiliza servicios que interactúan con la capa de acceso a datos para recuperar y persistir datos.
- Manejo de Excepciones: Se implementa un manejo adecuado de excepciones para gestionar excepciones de acceso a datos y proporcionar mensajes de error significativos al cliente.
