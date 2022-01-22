package com.thoughtworks.ddd_workshop.domain.events;

import java.util.UUID;

public class OrderCreated implements DomainEvent{
    private UUID orderId;

    public OrderCreated(UUID orderId) {
        this.orderId = orderId;
    }
}
