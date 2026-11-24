package com.automation.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.annotations.Step;

import static com.automation.saucedemo.ui.SauceDemoUI.CART_LINK;

public class OpenShoppingCart implements Task {

    public static OpenShoppingCart page() {
        return new OpenShoppingCart();
    }

    @Override
    @Step("{0} opens the shopping cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CART_LINK));
    }
}
