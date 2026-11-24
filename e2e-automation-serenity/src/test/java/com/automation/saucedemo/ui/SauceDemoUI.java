package com.automation.saucedemo.ui;

import java.util.Map;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class SauceDemoUI {

    public static final String URL = "https://www.saucedemo.com/";

    public static final Target USERNAME = Target.the("username field")
            .located(By.cssSelector("[data-test='username']"));
    public static final Target PASSWORD = Target.the("password field")
            .located(By.cssSelector("[data-test='password']"));
    public static final Target LOGIN_BUTTON = Target.the("login button")
            .located(By.cssSelector("[data-test='login-button']"));
    public static final Target CART_LINK = Target.the("shopping cart link")
            .located(By.cssSelector(".shopping_cart_link"));
    public static final Target CART_PRODUCT_NAMES = Target.the("cart product names")
            .located(By.cssSelector(".cart_item .inventory_item_name"));
    public static final Target CHECKOUT_BUTTON = Target.the("checkout button")
            .located(By.cssSelector("[data-test='checkout']"));
    public static final Target FIRST_NAME = Target.the("first name field")
            .located(By.cssSelector("[data-test='firstName']"));
    public static final Target LAST_NAME = Target.the("last name field")
            .located(By.cssSelector("[data-test='lastName']"));
    public static final Target POSTAL_CODE = Target.the("postal code field")
            .located(By.cssSelector("[data-test='postalCode']"));
    public static final Target CONTINUE_BUTTON = Target.the("continue button")
            .located(By.cssSelector("[data-test='continue']"));
    public static final Target SUBTOTAL = Target.the("order subtotal")
            .located(By.cssSelector("[data-test='subtotal-label']"));
    public static final Target TOTAL = Target.the("order total")
            .located(By.cssSelector("[data-test='total-label']"));
    public static final Target FINISH_BUTTON = Target.the("finish button")
            .located(By.cssSelector("[data-test='finish']"));
    public static final Target CONFIRMATION_HEADER = Target.the("order confirmation")
            .located(By.cssSelector("[data-test='complete-header']"));

    public static final Map<String, Target> ADD_TO_CART_BUTTONS = Map.of(
            "Sauce Labs Backpack", Target.the("add Sauce Labs Backpack to cart")
                    .located(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")),
            "Sauce Labs Bike Light", Target.the("add Sauce Labs Bike Light to cart")
                    .located(By.cssSelector("[data-test='add-to-cart-sauce-labs-bike-light']"))
    );

    private SauceDemoUI() {
    }
}
