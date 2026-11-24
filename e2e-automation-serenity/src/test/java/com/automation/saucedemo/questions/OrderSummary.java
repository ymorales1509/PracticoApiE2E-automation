package com.automation.saucedemo.questions;

import com.automation.saucedemo.ui.SauceDemoUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class OrderSummary implements Question<OrderSummary.Details> {

    public record Details(List<String> products, String subtotal, String total) {
    }

    public static OrderSummary details() {
        return new OrderSummary();
    }

    @Override
    public Details answeredBy(Actor actor) {
        List<String> products = SauceDemoUI.CART_PRODUCT_NAMES.resolveAllFor(actor)
                .stream()
                .map(WebElementFacade::getText)
                .toList();
        String subtotal = SauceDemoUI.SUBTOTAL.resolveFor(actor).getText();
        String total = SauceDemoUI.TOTAL.resolveFor(actor).getText();
        return new Details(products, subtotal, total);
    }
}
