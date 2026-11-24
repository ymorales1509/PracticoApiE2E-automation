EJERCICIO: AUTOMATIZACION DE USUARIOS CON KARATE

Requisitos previos
- Java 21 configurado en JAVA_HOME.
- Maven instalado y disponible en PATH.
- Conexion a Internet para acceder a https://petstore.swagger.io/v2.

Datos y escenarios
El Scenario Outline del archivo
src/test/resources/examples/users/petstore-user.feature ejecuta el ciclo CRUD
para cada usuario de src/test/resources/examples/users/petstore-users.csv.
Cada fila contiene los datos de creacion y los valores esperados despues de
actualizar el nombre y el correo. Para cada usuario se realizan estas
operaciones:
1. Crear el usuario mediante POST /user.
2. Consultarlo mediante GET /user/{username} y validar sus datos.
3. Actualizar su nombre y correo mediante PUT /user/{username}.
4. Consultarlo nuevamente y validar los valores actualizados.
5. Eliminarlo mediante DELETE /user/{username}.
6. Consultarlo despues de la eliminacion y validar HTTP 404.

Pasos de ejecucion
1. Abrir una terminal en la carpeta api-automation-karate, donde se encuentra
   el archivo pom.xml.
2. Verificar las versiones instaladas:

       java -version
       mvn -version

3. Ejecutar los escenarios parametrizados:

       mvn test -Dtest=PetstoreUserTest

4. Confirmar en la salida de Maven que el BUILD finalice correctamente y que
   los escenarios esten aprobados.
5. Abrir en un navegador el reporte HTML generado en:

       Report/karate-reports/karate-summary.html

   El reporte detallado del feature se encuentra en:

       Report/karate-reports/examples.users.petstore-user.html

Tambien se puede ejecutar la clase PetstoreUserTest desde IntelliJ IDEA. Los
reportes de Karate se guardan en la carpeta Report del proyecto.

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
