EJERCICIO: AUTOMATIZACION DE USUARIOS CON KARATE

Requisitos
- Java 21
- Maven
- Conexion a Internet

Escenarios automatizados
El archivo petstore-user.feature contiene un Scenario Outline que ejecuta el
ciclo CRUD completo contra la API https://petstore.swagger.io/v2 para cada
usuario definido en src/test/resources/examples/users/petstore-users.csv:
1. Crear un usuario mediante POST /user.
2. Buscar el usuario creado mediante GET /user/{username}.
3. Actualizar su nombre y correo mediante PUT /user/{username}.
4. Buscar el usuario actualizado y validar los nuevos datos.
5. Eliminar el usuario mediante DELETE /user/{username} y comprobar que ya no
   se encuentra disponible.

El CSV incluye los datos originales y los valores esperados tras la
actualizacion. Cada fila representa un usuario independiente para el ciclo
completo.

Ejecucion
Desde la carpeta raiz del proyecto, ejecutar:

    mvn test -Dtest=PetstoreUserTest

Tambien se puede ejecutar la clase PetstoreUserTest desde IntelliJ IDEA.
Los reportes de Karate se generan en la carpeta Report dentro de
api-automation-karate.

Conclusiones
Karate permite describir en Gherkin las solicitudes REST y validar sus
respuestas de forma legible. La automatizacion verifica estados HTTP, acuses
de la API y datos recuperados antes y despues de actualizar el usuario.

En Petstore, POST /user responde con HTTP 200 y un acuse JSON con code y
message; ese cuerpo no representa el usuario ni indica una respuesta HTTP 201.
Para confirmar los datos almacenados, el escenario realiza GET
/user/{username} y valida el objeto de usuario devuelto.

Petstore es un servicio publico de demostracion: su disponibilidad y la
persistencia de los datos pueden variar. Por esta razon, un fallo de red o del
servicio puede afectar la ejecucion aunque las validaciones del feature sean
correctas.
