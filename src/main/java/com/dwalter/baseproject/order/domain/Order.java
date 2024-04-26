package com.dwalter.baseproject.order.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Order {
    Long id;
    @Builder.Default
    OrderStatus status = OrderStatus.NEW;
    List<OrderItem> items;
    Recipient recipient;
    LocalDateTime createdAt;

    BigDecimal totalPrice() {
        return items.stream()
                .map(item -> item.book.getPrice().multiply(new BigDecimal(item.quantity)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
