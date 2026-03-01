package org.example.order.web;

import org.example.order.domain.Order;
import org.example.order.domain.OrderStatus;

import java.time.Instant;
import java.util.UUID;

public record OrderResponse(UUID id,
                            OrderStatus status,
                            String supplier,
                            String destination,
                            String product,
                            int quantity,
                            String notes,
                            Instant createdAt,
                            Instant updatedAt) {

    public static OrderResponse from(Order order) {

        return new OrderResponse(order.getId(),
                                 order.getStatus(),
                                 order.getSupplier(),
                                 order.getDestination(),
                                 order.getProduct(),
                                 order.getQuantity(),
                                 order.getNotes(),
                                 order.getCreatedAt(),
                                 order.getUpdatedAt());
    }
}
