package com.orderflow.services.order;

public class OrderItem {

  private Long productId;
  private int quantity;

  public OrderItem() {}

  public OrderItem(Long productId, int quantity) {
    this.productId = productId;
    this.quantity = quantity;
  }

  public Long getProductId() {
    return productId;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
