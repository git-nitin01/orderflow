package com.orderflow.services.inventory;

import com.orderflow.backend.messaging.KafkaTopics;
import com.orderflow.backend.messaging.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryEventsListener {

  private static final Logger log = LoggerFactory.getLogger(InventoryEventsListener.class);

  private final InventoryService inventoryService;

  public InventoryEventsListener(InventoryService inventoryService) {
    this.inventoryService = inventoryService;
  }

  @KafkaListener(
    topics = KafkaTopics.ORDER_CREATED,
    groupId = "orderflow-inventory"
  )
  public void handleOrderCreated(OrderCreatedEvent event) {
    log.info(
      "Inventory service received OrderCreatedEvent: orderId={}, totalAmount={}",
      event.getOrderId(), event.getTotalAmount()
    );

    // For now, just log + placeholder
    inventoryService.handleOrderCreated(event.getOrderId().toString());

    // Later:
    // - fetch order lines
    // - validate stock
    // - reserve / reject
    // - emit InventoryReserved / InventoryRejected events
  }
}
