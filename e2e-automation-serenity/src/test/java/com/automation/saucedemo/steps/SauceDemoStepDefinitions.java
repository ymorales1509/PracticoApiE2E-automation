package com.automation.saucedemo.steps;

import java.util.List;

import com.automation.saucedemo.questions.CartContents;
import com.automation.saucedemo.questions.OrderConfirmation;
import com.automation.saucedemo.questions.OrderSummary;
import com.automation.saucedemo.tasks.AddProductsToCart;
import com.automation.saucedemo.tasks.Authenticate;
import com.automation.saucedemo.tasks.CompleteCheckoutForm;
import com.automation.saucedemo.tasks.FinishPurchase;
import com.automation.saucedemo.tasks.OpenSauceDemo;
import com.automation.saucedemo.tasks.OpenShoppingCart;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SauceDemoStepDefinitions {

    @Dado("que el usuario abre la página de SauceDemo")
    public void openSauceDemo() {
        OnStage.theActorCalled("standard_user").attemptsTo(OpenSauceDemo.page());
    }

    @Cuando("inicia sesión con el usuario {string} y la contraseña {string}")
    public void authenticate(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(Authenticate.withCredentials(username, password));
    }

    @Y("agrega los productos {string} y {string} al carrito")
    public void addProducts(String firstProduct, String secondProduct) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProductsToCart.named(firstProduct, secondProduct)
        );
    }

    @Y("abre el carrito de compras")
    public void openCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(OpenShoppingCart.page());
    }

    @Entonces("el carrito muestra los productos {string} y {string}")
    public void verifyCartContents(String firstProduct, String secondProduct) {
        List<String> actualProducts = OnStage.theActorInTheSpotlight().asksFor(CartContents.products());
        assertEquals(List.of(firstProduct, secondProduct), actualProducts);
    }

    @Cuando("completa el formulario de compra con nombre {string}, apellido {string} y código postal {string}")
    public void completeCheckoutForm(String firstName, String lastName, String postalCode) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompleteCheckoutForm.with(firstName, lastName, postalCode)
        );
    }

    @Entonces("el resumen de la orden muestra los productos {string} y {string}, subtotal {string} y total {string}")
    public void verifyOrderSummary(String firstProduct, String secondProduct, String expectedSubtotal,
                                   String expectedTotal) {
        OrderSummary.Details summary = OnStage.theActorInTheSpotlight().asksFor(OrderSummary.details());
        assertEquals(List.of(firstProduct, secondProduct), summary.products());
        assertEquals(expectedSubtotal, summary.subtotal());
        assertEquals(expectedTotal, summary.total());
    }

    @Cuando("finaliza la compra")
    public void finishPurchase() {
        OnStage.theActorInTheSpotlight().attemptsTo(FinishPurchase.now());
    }

    @Entonces("se muestra la confirmación {string}")
    public void verifyConfirmation(String expectedConfirmation) {
        assertEquals(expectedConfirmation,
                OnStage.theActorInTheSpotlight().asksFor(OrderConfirmation.message()));
    }
}
