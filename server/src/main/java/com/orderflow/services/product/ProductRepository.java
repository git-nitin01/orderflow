package com.orderflow.services.product;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {

  private final Map<Long, Product> products = new ConcurrentHashMap<>();
  private final AtomicLong idSequence = new AtomicLong(0);

  @PostConstruct
  void init() {
    save(new Product(null, "Noise-Cancelling Headphones", "ELECTRONICS",
          BigDecimal.valueOf(179.99), 4.5));
    save(new Product(null, "Ergonomic Office Chair", "HOME & OFFICE",
          BigDecimal.valueOf(249.00), 3.2));
    save(new Product(null, "Mechanical Keyboard", "ELECTRONICS",
          BigDecimal.valueOf(129.50), 3.0));
    save(new Product(null, "Insulated Water Bottle", "LIFESTYLE",
          BigDecimal.valueOf(29.99), 4.0));
  }

  public List<Product> findAll() {
    return new ArrayList<>(products.values());
  }

  public Optional<Product> findById(Long id) {
    return Optional.ofNullable(products.get(id));
  }

  public Product save(Product product) {
    if (product.getId() == null) {
      product.setId(idSequence.incrementAndGet());
    }
    products.put(product.getId(), product);
    return product;
  }
}
