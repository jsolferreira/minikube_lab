package org.example.order.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CreateOrderRequest(@NotBlank String supplier,
                                 @NotBlank String destination,
                                 @NotBlank String product,
                                 @Positive int quantity,
                                 String notes) {

}
