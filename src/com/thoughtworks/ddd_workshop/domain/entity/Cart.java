package com.thoughtworks.ddd_workshop.domain.entity;

import com.thoughtworks.ddd_workshop.domain.vo.Item;
import com.thoughtworks.ddd_workshop.domain.vo.Product;
import com.thoughtworks.ddd_workshop.domain.events.DomainEvent;
import com.thoughtworks.ddd_workshop.domain.events.ItemAddedToTheCart;
import com.thoughtworks.ddd_workshop.domain.events.ItemRemovedFromTheCart;


import java.util.*;
import java.util.stream.Collectors;

public class Cart {
    private final List<Item> items;
    private final List<DomainEvent> events;
    private final UUID cartId;

    public Cart() {
        cartId = UUID.randomUUID();
        items = new LinkedList<>();
        events = new LinkedList<>();
    }
    public void add(Product product){
       add(product, 1);
    }
    public void add(Product product, int quantity){
        Optional<Item> foundItem = items.stream().filter(item -> item.isOf(product)).findFirst();
        if(foundItem.isPresent()){
            foundItem.get().increaseQuantity(quantity);
        }else{
            items.add(new Item(product, quantity));
        }
        events.add(new ItemAddedToTheCart());
    }
    public void remove(Product product){
        Optional<Item> foundItem = items.stream().filter(item -> item.isOf(product)).findFirst();
        foundItem.ifPresent(item ->  {
            this.items.remove(item);
            events.add(new ItemRemovedFromTheCart(item.itemName()));
        });
    }
    public Optional<List<String>> listRemovedProducts(){
        List<DomainEvent> filteredEvents = events.stream()
                .filter(event -> event.getClass().equals(ItemRemovedFromTheCart.class)).toList();
        if(filteredEvents != null){
           return Optional.of(filteredEvents.stream().map(event -> (ItemRemovedFromTheCart)event).map(event -> event.getItemName())
                   .collect(Collectors.toList()));
        }
        return Optional.empty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return cartId.equals(cart.cartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId);
    }
}
