package com.automation.saucedemo.questions;

import com.automation.saucedemo.ui.SauceDemoUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class OrderConfirmation implements Question<String> {

    public static OrderConfirmation message() {
        return new OrderConfirmation();
    }

    @Override
    public String answeredBy(Actor actor) {
        return SauceDemoUI.CONFIRMATION_HEADER.resolveFor(actor).getText();
    }
}
