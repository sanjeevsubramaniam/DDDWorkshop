package com.thoughtworks.ddd_workshop.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Product {
    private static Map<String, Product> productMap = new HashMap<>();
    String name;

    public static Product of(String name){
        var product = productMap.get(name);
        if(product == null){
           product = new Product(name);
            productMap.put(name, product);
        }
        return product;
    }

    private Product(String name) {
        this.name = Objects.requireNonNull(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
