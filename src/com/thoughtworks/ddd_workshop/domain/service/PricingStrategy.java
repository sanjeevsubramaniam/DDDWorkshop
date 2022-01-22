package com.thoughtworks.ddd_workshop.domain.service;

import com.thoughtworks.ddd_workshop.domain.vo.Price;

public interface PricingStrategy {
    public Price computePrice(String productName);
}
