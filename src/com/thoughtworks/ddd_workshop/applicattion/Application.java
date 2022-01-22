package com.thoughtworks.ddd_workshop.applicattion;

import com.thoughtworks.ddd_workshop.domain.*;

import java.util.Currency;

public class Application {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Pricer pricer = new Pricer(new DiscountOnCompetitorPriceStrategy(10.00));
        Product ipad = new Product("IpadPro", pricer.price("IpadPro"));
        Product pen = new Product("Hero ink Pen", pricer.price("Hero ink Pen"));
        Product bat = new Product("GM Cricket bat", pricer.price("GM Cricket bat"));

        cart.add(ipad);
        cart.add(pen);
        cart.add(bat, 2);

        cart.remove(ipad);

        cart.listRemovedProducts().ifPresent(items -> System.out.println(items));

    }
}
