package com.thoughtworks.ddd_workshop.domain;

public interface PricingStrategy {
    public Price computePrice(String productName);
}
