package com.example.order.online_order.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class OrderConfirmedEvent extends ApplicationEvent {

    private final Long orderId;

    public OrderConfirmedEvent(Object source, Long orderId) {
        super(source);
        this.orderId = orderId;
    }

}
