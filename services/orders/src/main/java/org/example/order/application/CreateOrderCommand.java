package org.example.order.application;

public record CreateOrderCommand(String supplier,
                                 String destination,
                                 String product,
                                 int quantity,
                                 String notes) {

}
