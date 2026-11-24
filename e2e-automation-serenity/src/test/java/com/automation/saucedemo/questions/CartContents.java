package com.automation.saucedemo.questions;

import java.util.List;

import com.automation.saucedemo.ui.SauceDemoUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.core.pages.WebElementFacade;

public class CartContents implements Question<List<String>> {

    public static CartContents products() {
        return new CartContents();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        List<WebElementFacade> products = SauceDemoUI.CART_PRODUCT_NAMES.resolveAllFor(actor);
        return products.stream().map(WebElementFacade::getText).toList();
    }
}
