package com.orderflow.services.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventsLoggingListener {

  private static final Logger log = LoggerFactory.getLogger(OrderEventsLoggingListener.class);

  @KafkaListener(
    topics = KafkaTopics.ORDER_CREATED,
    groupId = "orderflow-debug"
  )
  public void handleOrderCreated(OrderCreatedEvent event) {
    log.info("Received OrderCreatedEvent in logging listener: orderId={}, totalAmount={}",
            event.getOrderId(), event.getTotalAmount());
  }
}
