package com.thoughtworks.ddd_workshop.domain.entity;

import com.thoughtworks.ddd_workshop.domain.vo.Product;

import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    private List<Product> products;

    public Order(List<Product> products) {
        this.id = UUID.randomUUID();
        this.products = products;
    }

    public UUID id() {
        return id;
    }
}
