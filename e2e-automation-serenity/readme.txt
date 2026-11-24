SAUCEDEMO - AUTOMATIZACION E2E CON SERENITY BDD Y SCREENPLAY

Requisitos
- Java 21 configurado en JAVA_HOME.
- Maven disponible en PATH.
- Google Chrome instalado.
- Conexion a Internet.

Estructura
- src/test/resources/features/saucedemo/compra_saucedemo.feature:
  escenario Cucumber en espanol.
- ui/SauceDemoUI.java: localizadores de la interfaz SauceDemo.
- tasks/: tareas Screenplay para navegar, autenticarse, agregar productos,
  completar el checkout y finalizar la compra.
- questions/: consultas para validar el carrito, el resumen y la confirmacion.
- steps/: definiciones de pasos y ciclo de vida del actor.

Ejecucion
1. Abrir una terminal en la carpeta e2e-automation-serenity, donde esta este
   archivo y pom.xml.
2. Comprobar las instalaciones:

       java -version
       mvn -version

3. Ejecutar el escenario y generar el reporte Serenity:

       mvn clean verify

Chrome se abre mediante Selenium WebDriver. Selenium Manager descarga el driver
compatible cuando sea necesario. El escenario usa el usuario demo
standard_user y la contrasena secret_sauce, agrega Sauce Labs Backpack y Sauce
Labs Bike Light, valida el carrito, el formulario, el subtotal/total y el
mensaje de confirmacion.

El reporte HTML se genera en e2e-automation-serenity/Reports/target/site/serenity/index.html.
