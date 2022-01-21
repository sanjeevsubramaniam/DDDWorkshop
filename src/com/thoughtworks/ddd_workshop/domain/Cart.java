package com.thoughtworks.ddd_workshop.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cart {
    private List<Item> items;
    private  List<Item> removedItems;

    public Cart() {
        items = new LinkedList<>();
        removedItems = new LinkedList<>();
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
    }
    public void remove(Product product){
        Optional<Item> foundItem = items.stream().filter(item -> item.isOf(product)).findFirst();
        foundItem.ifPresent(item ->  {
            this.items.remove(item);
            this.removedItems.add(item);
        });
    }
    public List<String> listRemovedProducts(){
       return removedItems.stream().map(item -> item.itemName()).collect(Collectors.toList());
    }
}
