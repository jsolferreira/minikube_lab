package org.example.order.web;

import jakarta.validation.Valid;
import org.example.order.application.CreateOrderCommand;
import org.example.order.application.CreateOrderService;
import org.example.order.domain.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final CreateOrderService createOrderService;

    public OrderController(CreateOrderService createOrderService) {

        this.createOrderService = createOrderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse create(@Valid @RequestBody CreateOrderRequest request) {

        final CreateOrderCommand command = new CreateOrderCommand(request.supplier(),
                                                                  request.destination(),
                                                                  request.product(),
                                                                  request.quantity(),
                                                                  request.notes());
        final Order order = createOrderService.create(command);
        return OrderResponse.from(order);
    }
}
