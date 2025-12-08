package com.orderflow.services.payment;

import com.orderflow.backend.order.Order;
import com.orderflow.backend.order.OrderService;
import com.orderflow.backend.order.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentSimulationService {

  private final OrderService orderService;
  private final Random random = new Random();

  public PaymentSimulationService(OrderService orderService) {
      this.orderService = orderService;
  }

  public PaymentStatus simulatePayment(UUID orderId) {
    Order order = orderService.findById(orderId)
          .orElseThrow(() -> new IllegalArgumentException("Order not found: " + orderId));

    boolean approved = random.nextDouble() > 0.2; // 80% success

    if (approved) {
      order.setStatus(OrderStatus.PAID);
      return PaymentStatus.AUTHORIZED;
    } else {
      order.setStatus(OrderStatus.FAILED);
      return PaymentStatus.DECLINED;
    }
  }
}
