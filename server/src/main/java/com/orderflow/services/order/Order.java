package com.orderflow.services.order;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Order {

  private UUID id;
  private Instant createdAt;
  private OrderStatus status;
  private BigDecimal totalAmount;
  private List<OrderItem> items;

  public Order() {}

  public Order(UUID id, Instant createdAt, OrderStatus status,
    BigDecimal totalAmount, List<OrderItem> items) {
    this.id = id;
    this.createdAt = createdAt;
    this.status = status;
    this.totalAmount = totalAmount;
    this.items = items;
  }

  public UUID getId() {
    return id;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public List<OrderItem> getItems() {
    return items;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  public void setItems(List<OrderItem> items) {
    this.items = items;
  }
}
