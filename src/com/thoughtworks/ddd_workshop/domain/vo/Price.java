package com.thoughtworks.ddd_workshop.domain.vo;

import java.util.Currency;

public class Price {
    private double amount;
    private Currency currency;

    public Price(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Price reduceBy(double percentage) {
        var discount = this.amount * (percentage/100.00);
        return  new Price(this.amount - discount, this.currency);
    }
}
