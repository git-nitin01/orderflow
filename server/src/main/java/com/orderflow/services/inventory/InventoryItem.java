package com.orderflow.services.inventory;

public class InventoryItem {

  private Long productId;
  private String productName;
  private int available;
  private int reserved;

  public InventoryItem() {
  }

  public InventoryItem(Long productId, String productName, int available, int reserved) {
    this.productId = productId;
    this.productName = productName;
    this.available = available;
    this.reserved = reserved;
  }

  public Long getProductId() {
    return productId;
  }

  public String getProductName() {
    return productName;
  }

  public int getAvailable() {
    return available;
  }

  public int getReserved() {
    return reserved;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setAvailable(int available) {
    this.available = available;
  }

  public void setReserved(int reserved) {
    this.reserved = reserved;
  }
}
