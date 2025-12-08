package com.orderflow.services.inventory;

import com.orderflow.backend.common.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(origins = "*")
public class InventoryController {

  private final InventoryService service;

  public InventoryController(InventoryService service) {
    this.service = service;
  }

  @GetMapping
  public ApiResponse<List<InventoryItem>> getAll() {
    return ApiResponse.ok(service.getAll());
  }

  @GetMapping("/{productId}")
  public ApiResponse<InventoryItem> getByProduct(@PathVariable Long productId) {
    return service.findByProductId(productId)
          .map(ApiResponse::ok)
          .orElseGet(() -> ApiResponse.error("Inventory not found for productId=" + productId));
  }
}
