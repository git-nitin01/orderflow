package com.orderflow.services.inventory;

import com.orderflow.backend.product.Product;
import com.orderflow.backend.product.ProductService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InventoryService {

  private static final Logger log = LoggerFactory.getLogger(InventoryService.class);

  private final Map<Long, InventoryItem> stock = new ConcurrentHashMap<>();
  private final ProductService productService;

  public InventoryService(ProductService productService) {
      this.productService = productService;
  }

  @PostConstruct
  void init() {
    // Seed inventory for existing products
    for (Product product : productService.getAll()) {
      // For demo: random stock between 5 and 30
      int available = 5 + new Random().nextInt(26);
      InventoryItem item = new InventoryItem(
            product.getId(),
            product.getName(),
            available,
            0
      );
      stock.put(product.getId(), item);
    }
    log.info("Initialized inventory with {} products", stock.size());
  }

  public List<InventoryItem> getAll() {
    return new ArrayList<>(stock.values());
  }

  public Optional<InventoryItem> findByProductId(Long productId) {
    return Optional.ofNullable(stock.get(productId));
  }

  /**
   * Placeholder: in a real system this would
   * - validate stock for each order line
   * - reserve quantities
   * - emit an InventoryReserved / InventoryRejected event
   */
  public void handleOrderCreated(String orderId) {
    log.info("Received orderCreated event for orderId={}, inventory reservation to be implemented.", orderId);
    // TODO: fetch order lines from Order service and update stock accordingly
  }
}
