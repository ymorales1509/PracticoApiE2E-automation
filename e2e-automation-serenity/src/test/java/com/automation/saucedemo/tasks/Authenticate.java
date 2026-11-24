package com.automation.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.annotations.Step;

import static com.automation.saucedemo.ui.SauceDemoUI.LOGIN_BUTTON;
import static com.automation.saucedemo.ui.SauceDemoUI.PASSWORD;
import static com.automation.saucedemo.ui.SauceDemoUI.USERNAME;

public class Authenticate implements Task {

    private final String username;
    private final String password;

    private Authenticate(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Authenticate withCredentials(String username, String password) {
        return new Authenticate(username, password);
    }

    @Override
    @Step("{0} authenticates as #username")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(USERNAME),
                Enter.theValue(password).into(PASSWORD),
                Click.on(LOGIN_BUTTON)
        );
    }
}
