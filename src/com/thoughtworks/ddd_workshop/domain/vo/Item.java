package com.thoughtworks.ddd_workshop.domain.vo;

import java.util.LinkedList;
import java.util.List;
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
        return this.product.name();
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

    public List<Product> products() {
        List<Product> products = new LinkedList<>();
        for(int i = 1; i <= quantity; i++){
            products.add(new Product(this.product));
        }
        return products;
    }
}
