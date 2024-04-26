package com.dwalter.baseproject.order.app;

import com.dwalter.baseproject.order.app.port.PlaceOrderUseCase;
import com.dwalter.baseproject.order.domain.Order;
import com.dwalter.baseproject.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class PlaceOrderService implements PlaceOrderUseCase {
    private final OrderRepository repository;

    @Override
    public PlaceOrderResponse placeOrder(PlaceOrderCommand command) {
        Order order = Order.builder()
                .recipient(command.getRecipient())
                .items(command.getItems())
                .build();
        Order save = repository.save(order);
        return PlaceOrderResponse.success(order.getId());
    }
}
