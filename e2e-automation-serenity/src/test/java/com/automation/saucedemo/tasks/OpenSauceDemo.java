package com.automation.saucedemo.tasks;

import com.automation.saucedemo.ui.SauceDemoUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.annotations.Step;

public class OpenSauceDemo implements Task {

    public static OpenSauceDemo page() {
        return new OpenSauceDemo();
    }

    @Override
    @Step("{0} opens SauceDemo")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(SauceDemoUI.URL));
    }
}
