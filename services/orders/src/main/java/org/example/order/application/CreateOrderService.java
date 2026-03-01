package org.example.order.application;

import org.example.order.domain.Order;
import org.example.order.persistence.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateOrderService {

    private final OrderRepository orderRepository;

    public CreateOrderService(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order create(CreateOrderCommand command) {

        var order = new Order(
                command.supplier(),
                command.destination(),
                command.product(),
                command.quantity(),
                command.notes()
        );
        return orderRepository.save(order);
    }
}
