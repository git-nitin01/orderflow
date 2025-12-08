package com.orderflow.services.order;

import com.orderflow.backend.common.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

  private final OrderService service;

  public OrderController(OrderService service) {
    this.service = service;
  }

  @GetMapping
  public ApiResponse<List<Order>> getAll() {
    return ApiResponse.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ApiResponse<Order> getById(@PathVariable UUID id) {
    return service.findById(id)
            .map(ApiResponse::ok)
            .orElseGet(() -> ApiResponse.error("Order not found: " + id));
  }

  @PostMapping
  public ApiResponse<Order> create(@RequestBody List<OrderItem> items) {
    Order created = service.createOrder(items);
    return ApiResponse.ok(created, "Order created");
  }
}
