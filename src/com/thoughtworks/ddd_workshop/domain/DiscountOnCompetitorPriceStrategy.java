package com.thoughtworks.ddd_workshop.domain;

import java.util.Currency;
import java.util.Map;

public class DiscountOnCompetitorPriceStrategy implements  PricingStrategy{

    private static Map<String, Price> competitorPriceMap;

    static {
        competitorPriceMap = Map.of("IpadPro", new Price(35600, Currency.getInstance("INR")),
                "Hero ink Pen", new Price(100, Currency.getInstance("INR")),
                "GM Cricket bat", new Price(1500, Currency.getInstance("INR")));
    }

    private double percentage;

    public DiscountOnCompetitorPriceStrategy(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public Price computePrice(String productName) {
        Price price = competitorPriceMap.get(productName);
        return price.reduceBy(this.percentage);
    }
}
