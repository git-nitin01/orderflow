package com.orderflow.services.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderEventProducer {

  private static final Logger log = LoggerFactory.getLogger(OrderEventProducer.class);

  private final KafkaTemplate<String, Object> kafkaTemplate;

  public OrderEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
      this.kafkaTemplate = kafkaTemplate;
  }

  public void sendOrderCreated(OrderCreatedEvent event) {
    String key = event.getOrderId().toString();
    log.info("Publishing OrderCreatedEvent for orderId={} to topic={}", key, KafkaTopics.ORDER_CREATED);

    kafkaTemplate.send(KafkaTopics.ORDER_CREATED, key, event)
          .whenComplete((result, ex) -> {
              if (ex != null) {
                log.error("Failed to publish OrderCreatedEvent for orderId={}", key, ex);
              } else {
                  log.debug("OrderCreatedEvent published to partition={}, offset={}",
                        result.getRecordMetadata().partition(),
                        result.getRecordMetadata().offset());
              }
          });
  }
}
