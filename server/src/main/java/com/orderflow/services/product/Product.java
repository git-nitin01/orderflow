package com.orderflow.services.product;

import java.math.BigDecimal;

public class Product {

  private Long id;
  private String name;
  private String category;
  private BigDecimal price;
  private double rating;

  public Product() {}

  public Product(Long id, String name, String category, BigDecimal price, double rating) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.price = price;
    this.rating = rating;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCategory() {
    return category;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public double getRating() {
    return rating;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }
}
