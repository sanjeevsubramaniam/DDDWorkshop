package com.thoughtworks.ddd_workshop.domain.events;

public class ItemRemovedFromTheCart implements DomainEvent{
    private String itemName;

    public ItemRemovedFromTheCart(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
