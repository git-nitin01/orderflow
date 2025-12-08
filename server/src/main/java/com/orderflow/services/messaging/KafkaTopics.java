package com.orderflow.services.messaging;

public final class KafkaTopics {

  public static final String ORDER_CREATED = "orderflow.order.created";
  public static final String PAYMENT_UPDATED = "orderflow.payment.updated";

  private KafkaTopics() {
    // utility class
  }
}
