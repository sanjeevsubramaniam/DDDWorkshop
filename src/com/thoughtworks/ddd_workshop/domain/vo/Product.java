package com.thoughtworks.ddd_workshop.domain.vo;

import java.util.Objects;

public class Product {
    private String name;
    private Price price;


    public Product(String name, Price price) {
        this.name = Objects.requireNonNull(name);
        this.price = Objects.requireNonNull(price);
    }

    public Product(Product other){
        this.name = other.name();
        this.price = other.price;
    }

    public String name(){
        return this.name;
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
