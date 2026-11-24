package com.automation.saucedemo.tasks;

import java.util.List;

import com.automation.saucedemo.ui.SauceDemoUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.targets.Target;

public class AddProductsToCart implements Task {

    private final List<String> productNames;

    private AddProductsToCart(List<String> productNames) {
        this.productNames = List.copyOf(productNames);
    }

    public static AddProductsToCart named(String... productNames) {
        return new AddProductsToCart(List.of(productNames));
    }

    @Override
    @Step("{0} adds products to the cart")
    public <T extends Actor> void performAs(T actor) {
        for (String productName : productNames) {
            Target addButton = SauceDemoUI.ADD_TO_CART_BUTTONS.get(productName);
            if (addButton == null) {
                throw new IllegalArgumentException("Unsupported SauceDemo product: " + productName);
            }
            actor.attemptsTo(Click.on(addButton));
        }
    }
}
