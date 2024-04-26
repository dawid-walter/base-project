package com.dwalter.baseproject.order.app;

import com.dwalter.baseproject.order.app.port.QueryOrderUseCase;
import com.dwalter.baseproject.order.domain.Order;
import com.dwalter.baseproject.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class QueryOrderService implements QueryOrderUseCase {
    private final OrderRepository repository;

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }
}
