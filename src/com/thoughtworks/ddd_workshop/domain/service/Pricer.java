package com.thoughtworks.ddd_workshop.domain.service;

import com.thoughtworks.ddd_workshop.domain.vo.Price;

public class Pricer {


    private PricingStrategy strategy;

    public Pricer(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public Price price(String productName){
        return strategy.computePrice(productName);
    }
}
