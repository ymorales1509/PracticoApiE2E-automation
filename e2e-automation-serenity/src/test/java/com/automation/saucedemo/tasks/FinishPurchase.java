package com.automation.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.annotations.Step;

import static com.automation.saucedemo.ui.SauceDemoUI.FINISH_BUTTON;

public class FinishPurchase implements Task {

    public static FinishPurchase now() {
        return new FinishPurchase();
    }

    @Override
    @Step("{0} finishes the purchase")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(FINISH_BUTTON));
    }
}
