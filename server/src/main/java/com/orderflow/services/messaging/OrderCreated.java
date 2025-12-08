package com.orderflow.services.messaging;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class OrderCreatedEvent {

  private UUID orderId;
  private BigDecimal totalAmount;
  private Instant createdAt;

  public OrderCreatedEvent() {
  }

  public OrderCreatedEvent(UUID orderId, BigDecimal totalAmount, Instant createdAt) {
    this.orderId = orderId;
    this.totalAmount = totalAmount;
    this.createdAt = createdAt;
  }

  public UUID getOrderId() {
    return orderId;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setOrderId(UUID orderId) {
    this.orderId = orderId;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }
}
