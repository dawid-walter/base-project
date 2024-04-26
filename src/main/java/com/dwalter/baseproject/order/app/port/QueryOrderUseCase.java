package com.dwalter.baseproject.order.app.port;

import com.dwalter.baseproject.order.domain.Order;

import java.util.List;

public interface QueryOrderUseCase {
    List<Order> findAll();

}
