package com.orderflow.services.order;

import com.orderflow.backend.messaging.OrderCreatedEvent;
import com.orderflow.backend.messaging.OrderEventProducer;
import com.orderflow.backend.product.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderService {

  private final Map<UUID, Order> orders = new ConcurrentHashMap<>();
  private final ProductService productService;
  private final OrderEventProducer eventProducer;

  public OrderService(ProductService productService, OrderEventProducer eventProducer) {
    this.productService = productService;
    this.eventProducer = eventProducer;
  }

  public Order createOrder(List<OrderItem> items) {
    BigDecimal total = items.stream()
      .map(item -> productService.getById(item.getProductId())
              .getPrice()
              .multiply(BigDecimal.valueOf(item.getQuantity())))
      .reduce(BigDecimal.ZERO, BigDecimal::add);

    Order order = new Order(
      UUID.randomUUID(),
      Instant.now(),
      OrderStatus.PAYMENT_PENDING,
      total,
      items
    );

    orders.put(order.getId(), order);

    // Publish event to Kafka
    OrderCreatedEvent event = new OrderCreatedEvent(
      order.getId(),
      order.getTotalAmount(),
      order.getCreatedAt()
    );
    eventProducer.sendOrderCreated(event);

    return order;
  }

  public Optional<Order> findById(UUID id) {
    return Optional.ofNullable(orders.get(id));
  }

  public List<Order> findAll() {
    return new ArrayList<>(orders.values());
  }
}
