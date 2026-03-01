package org.example.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OrderStatus status;

    @Column(nullable = false)
    private String supplier;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private String product;

    @Column(nullable = false)
    private int quantity;

    private String notes;

    @Column(nullable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    protected Order() {
        // JPA
    }

    public Order(String supplier, String destination, String product, int quantity, String notes) {

        if (supplier == null || supplier.isBlank()) {
            throw new IllegalArgumentException("supplier must not be blank");
        }
        if (destination == null || destination.isBlank()) {
            throw new IllegalArgumentException("destination must not be blank");
        }
        if (product == null || product.isBlank()) {
            throw new IllegalArgumentException("product must not be blank");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }

        this.id = UUID.randomUUID();
        this.status = OrderStatus.CREATED;
        this.supplier = supplier;
        this.destination = destination;
        this.product = product;
        this.quantity = quantity;
        this.notes = notes;
        this.createdAt = Instant.now();
        this.updatedAt = this.createdAt;
    }

    public UUID getId() {

        return id;
    }

    public OrderStatus getStatus() {

        return status;
    }

    public String getSupplier() {

        return supplier;
    }

    public String getDestination() {

        return destination;
    }

    public String getProduct() {

        return product;
    }

    public int getQuantity() {

        return quantity;
    }

    public String getNotes() {

        return notes;
    }

    public Instant getCreatedAt() {

        return createdAt;
    }

    public Instant getUpdatedAt() {

        return updatedAt;
    }
}
