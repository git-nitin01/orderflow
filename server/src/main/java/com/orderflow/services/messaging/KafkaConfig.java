package com.orderflow.services.messaging;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@EnableKafka
public class KafkaConfig {
  // We rely on Spring Boot's auto-configuration for factories and templates.
}
