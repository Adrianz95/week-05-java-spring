# Product API

API REST de catálogo de productos desarrollada con Java y Spring Boot como proyecto formativo de la semana 5. El objetivo es practicar la programación orientada a objetos, la separación de responsabilidades y la creación de endpoints HTTP.

> **Estado:** README inicial. Los endpoints descritos son los previstos para el proyecto; no se consideran verificados hasta probarlos en la aplicación.

## Tecnologías previstas

- Java (versión compatible con la versión de Spring Boot elegida).
- Spring Boot.
- Spring Web.
- Maven.
- JUnit para pruebas automatizadas (si está incluido en las dependencias del proyecto).

## Requisitos

Antes de ejecutar el proyecto, comprueba que tienes instalado:

- JDK compatible con la versión de Spring Boot configurada.
- Maven, o el Maven Wrapper (`mvnw` / `mvnw.cmd`) si el proyecto lo incluye.
- Git.
- Una herramienta para probar peticiones HTTP, como `curl`, Postman o Bruno.

Comprueba las versiones instaladas:

```bash
java -version
mvn -version
git --version
```

## Cómo ejecutar

Desde la raíz del proyecto:

```bash
mvn spring-boot:run
```

Si el proyecto incluye Maven Wrapper, puedes usar:

En Linux/macOS:

```bash
./mvnw spring-boot:run
```

En Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Por defecto, Spring Boot suele iniciar el servidor en `http://localhost:8080`, salvo que la configuración del proyecto indique otro puerto.

Para compilar y ejecutar las pruebas disponibles:

```bash
mvn test
mvn package
```

Con Maven Wrapper, sustituye `mvn` por `./mvnw` en Linux/macOS o `.\mvnw.cmd` en Windows.

## Endpoints previstos

Las siguientes rutas forman parte del alcance inicial. **No se afirma que estén implementadas ni probadas todavía.** Actualiza esta tabla después de verificar cada endpoint.

| Método | Ruta | Objetivo | Estado |

|---|---|---|---|

| `GET` | `/products` | Listar productos | Pendiente de verificar |
| `GET` | `/products/{id}` | Consultar un producto por ID | Pendiente de verificar |
| `POST` | `/products` | Crear un producto | Pendiente de verificar |
| `PUT` | `/products/{id}` | Actualizar un producto existente | Pendiente de verificar |
| `DELETE` | `/products/{id}` | Eliminar un producto | Pendiente de verificar |

## Ejemplos de peticiones HTTP

Los ejemplos siguientes ilustran cómo probar los endpoints previstos. Ejecútalos únicamente cuando la aplicación esté arrancada y marca el resultado real en la tabla anterior.

### Listar productos

```bash
curl -i http://localhost:8080/products
```

### Consultar un producto

```bash
curl -i http://localhost:8080/products/1
```

### Crear un producto

```bash
curl -i -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Monitor","precio":179.99}'
```

### Actualizar un producto

```bash
curl -i -X PUT http://localhost:8080/products/1 \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Monitor actualizado","precio":199.99}'
```

### Eliminar un producto

```bash
curl -i -X DELETE http://localhost:8080/products/1
```

El formato exacto de las respuestas y sus códigos HTTP dependerá de la implementación actual. Comprueba los resultados reales antes de documentarlos como comportamiento confirmado.

## Arquitectura prevista

El proyecto separa las responsabilidades en capas:

- **Controller:** recibe peticiones HTTP y construye las respuestas.
- **Service:** aplica las reglas de negocio y las validaciones.
- **Repository:** encapsula el acceso a los datos.
- **Model / DTO:** representa los datos del dominio y, si se utilizan DTO, los datos intercambiados mediante la API.

## Pruebas recomendadas

Antes de considerar el proyecto funcional, comprueba al menos:

- La aplicación arranca correctamente.
- `GET /products` devuelve una respuesta válida.
- La consulta de un ID existente y de uno inexistente se gestiona correctamente.
- Crear un producto válido funciona.
- Un nombre vacío o un precio no válido se rechazan.
- Actualizar un producto existente y uno inexistente produce el resultado esperado.
- Eliminar un producto y volver a consultarlo produce el resultado esperado.
- `mvn test` termina correctamente y los tests cubren los casos principales.

## Limitaciones conocidas

- La implementación inicial prevista utiliza almacenamiento en memoria; si se confirma ese diseño, los datos se perderán al reiniciar la aplicación.
- No se ha confirmado la integración con una base de datos persistente.
- No se debe asumir que todos los endpoints, validaciones o códigos HTTP están implementados hasta probarlos.
- El uso de `double` para importes monetarios es didáctico; en una aplicación real suele ser preferible `BigDecimal`.
- La autenticación, autorización, paginación y configuración de despliegue quedan fuera del alcance inicial salvo que se añadan expresamente.

## Progreso

Actualiza esta sección según el estado real del proyecto:

- [ ] Proyecto arranca.
- [ ] `GET /products` probado.
- [ ] `GET /products/{id}` probado.
- [ ] `POST /products` probado.
- [ ] `PUT /products/{id}` probado.
- [ ] `DELETE /products/{id}` probado.
- [ ] Pruebas automatizadas ejecutadas.
