package com.automation.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.annotations.Step;

import static com.automation.saucedemo.ui.SauceDemoUI.CHECKOUT_BUTTON;
import static com.automation.saucedemo.ui.SauceDemoUI.CONTINUE_BUTTON;
import static com.automation.saucedemo.ui.SauceDemoUI.FIRST_NAME;
import static com.automation.saucedemo.ui.SauceDemoUI.LAST_NAME;
import static com.automation.saucedemo.ui.SauceDemoUI.POSTAL_CODE;

public class CompleteCheckoutForm implements Task {

    private final String firstName;
    private final String lastName;
    private final String postalCode;

    private CompleteCheckoutForm(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public static CompleteCheckoutForm with(String firstName, String lastName, String postalCode) {
        return new CompleteCheckoutForm(firstName, lastName, postalCode);
    }

    @Override
    @Step("{0} completes the checkout form")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CHECKOUT_BUTTON),
                Enter.theValue(firstName).into(FIRST_NAME),
                Enter.theValue(lastName).into(LAST_NAME),
                Enter.theValue(postalCode).into(POSTAL_CODE),
                Click.on(CONTINUE_BUTTON)
        );
    }
}
