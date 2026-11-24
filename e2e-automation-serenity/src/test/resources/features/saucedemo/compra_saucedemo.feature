# language: es
Característica: Compra de productos en SauceDemo

  Escenario: Completar una compra de dos productos exitosamente
    Dado que el usuario abre la página de SauceDemo
    Cuando inicia sesión con el usuario "standard_user" y la contraseña "secret_sauce"
    Y agrega los productos "Sauce Labs Backpack" y "Sauce Labs Bike Light" al carrito
    Y abre el carrito de compras
    Entonces el carrito muestra los productos "Sauce Labs Backpack" y "Sauce Labs Bike Light"
    Cuando completa el formulario de compra con nombre "Yaily", apellido "Morales" y código postal "110111"
    Entonces el resumen de la orden muestra los productos "Sauce Labs Backpack" y "Sauce Labs Bike Light", subtotal "Item total: $39.98" y total "Total: $43.18"
    Cuando finaliza la compra
    Entonces se muestra la confirmación "Thank you for your order!"
