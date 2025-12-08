package com.orderflow.services.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  private final ProductRepository repository;

  public ProductService(ProductRepository repository) {
    this.repository = repository;
  }

  public List<Product> getAll() {
    return repository.findAll();
  }

  public Product getById(Long id) {
    return repository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Product not found: " + id));
  }
}
