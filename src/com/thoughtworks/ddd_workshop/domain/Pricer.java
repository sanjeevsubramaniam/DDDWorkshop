package com.thoughtworks.ddd_workshop.domain;

public class Pricer {


    private PricingStrategy strategy;

    public Pricer(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public Price price(String productName){
        return strategy.computePrice(productName);
    }
}
