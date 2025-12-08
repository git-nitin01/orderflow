package com.orderflow.services.product;

import com.orderflow.backend.common.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*") // adjust later for security
public class ProductController {

  private final ProductService service;

  public ProductController(ProductService service) {
    this.service = service;
  }

  @GetMapping
  public ApiResponse<List<Product>> getAllProducts() {
    return ApiResponse.ok(service.getAll());
  }

  @GetMapping("/{id}")
  public ApiResponse<Product> getProduct(@PathVariable Long id) {
    return ApiResponse.ok(service.getById(id));
  }
}
