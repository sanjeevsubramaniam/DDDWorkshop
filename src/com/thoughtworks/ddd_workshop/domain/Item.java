package com.thoughtworks.ddd_workshop.domain;

import java.util.Objects;

public class Item {
    private Product product;
    private int quantity;

    public Item(Product item, int quantity) {
        this.product = Objects.requireNonNull(item);
        this.quantity = quantity;
    }


    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }


    public boolean isOf(Product other) {
        return this.product.equals(other);
    }

    public String itemName(){
        return this.product.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return quantity == item.quantity && product.equals(item.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }
}
