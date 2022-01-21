package com.thoughtworks.ddd_workshop.applicattion;

import com.thoughtworks.ddd_workshop.domain.Cart;
import com.thoughtworks.ddd_workshop.domain.Product;

public class Application {
    public static void main(String[] args) {
        Cart cart = new Cart();

        cart.add(Product.of("IpadPro"));
        cart.add(Product.of("Hero ink Pen"));
        cart.add(Product.of("GM Cricket bat"), 2);

        cart.remove(Product.of("IpadPro"));

        System.out.println(cart.listRemovedProducts());
    }
}
