package com.example.order.inventory.controller;

import com.example.order.common.response.ApiResponse;
import com.example.order.inventory.dto.request.InventoryCreateRequest;
import com.example.order.inventory.dto.request.InventoryUpdateRequest;
import com.example.order.inventory.dto.response.InventoryResponse;
import com.example.order.inventory.service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Validated
@Tag(name = "Inventory Service", description = "Inventory service include add and remove stocks")
public class InventoryController {

    private final InventoryService service;

    @PostMapping
    @Operation(summary = "Create Inventory", description = "Add a new inventory item")
    public ResponseEntity<ApiResponse<InventoryResponse>> createInventory(@Valid @RequestBody InventoryCreateRequest request) {
        InventoryResponse response = service.createInventory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Inventory created successfully.", response));
    }

    @GetMapping("/{inventoryId}")
    @Operation(summary = "Get inventory", description = "Get a single inventory details by getting the inventory id")
    public ResponseEntity<ApiResponse<InventoryResponse>> getInventoryById(
            @PathVariable
            @Positive(message = "Inventory ID must be > 0")
            Long inventoryId
    ) {

        InventoryResponse response = service.getInventoryById(inventoryId);
        return ResponseEntity.ok(ApiResponse.success("Inventory retrieved successfully", response));

    }

    @GetMapping("/product/{productId}")
    @Operation(summary = "Get Inventory", description = "Get a single inventory by getting the product id")
    public ResponseEntity<ApiResponse<InventoryResponse>> getInventoryByProductId(
            @PathVariable
            @Positive(message = "Product ID must be greater than zero")
            Long productId
    ) {

        InventoryResponse response = service.getInventoryByProductId(productId);
        return ResponseEntity.ok(ApiResponse.success("Inventory retrieved successfully.", response));

    }

    @GetMapping
    @Operation(summary = "All inventories", description = "Get all inventory items")
    public ResponseEntity<ApiResponse<List<InventoryResponse>>> getAllInventories() {
        List<InventoryResponse> responses = service.getAllInventories();
        return ResponseEntity.ok(ApiResponse.success("Inventories retrieved successfully", responses));
    }

    @GetMapping("/available")
    @Operation(summary = "Available inventories", description = "Get all inventories which is having the available status")
    public ResponseEntity<ApiResponse<Page<InventoryResponse>>> getAvailableInventories(
            @RequestParam(defaultValue = "0")
            @PositiveOrZero(message = "Page number cannot be negative")
            int page,

            @RequestParam(defaultValue = "3")
            @Positive(message = "Page size should be > 0")
            int size,

            @RequestParam(defaultValue = "id")
            String sortBy,

            @RequestParam(defaultValue = "asc")
            String direction
    ) {

        Pageable pageable = createPageable(page, size, sortBy, direction);
        Page<InventoryResponse> responses = service.getAllAvailableInventories(pageable);
        return ResponseEntity.ok(ApiResponse.success("Available inventories retrieved successfully.", responses));

    }

    @GetMapping("/low-stock")
    @Operation(summary = "Low stock", description = "Get all low stock inventories")
    public ResponseEntity<ApiResponse<Page<InventoryResponse>>> getLowStockInventories(
            @RequestParam
            @PositiveOrZero(message = "Low stock quantity cannot be negative")
            Integer quantity,

            @RequestParam(defaultValue = "0")
            @PositiveOrZero(message = "Page number cannot be negative")
            int page,

            @RequestParam(defaultValue = "4")
            @Positive(message = "Page size must be > 0")
            int size
    ) {

        Pageable pageable = PageRequest.of(page, size);
        Page<InventoryResponse> responses = service.getLowStockInventories(quantity, pageable);
        return ResponseEntity.ok(ApiResponse.success("Low stock inventories retrieved successfully", responses));

    }

    @PutMapping("/{inventoryId}")
    @Operation(summary = "Update inventory", description = "Update a single inventory by the inventory id")
    public ResponseEntity<ApiResponse<InventoryResponse>> updateInventory(
            @PathVariable
            @Positive(message = "Inventory ID must be > 0")
            Long inventoryId,

            @Valid @RequestBody
            InventoryUpdateRequest request
    ) {

        InventoryResponse response = service.updateInventory(inventoryId, request);
        return ResponseEntity.ok(ApiResponse.success("Inventory updated success", response));

    }

    @PatchMapping("/{inventoryId}/add-stock")
    @Operation(summary = "Add stock", description = "Add stock partial update like quantity update")
    public ResponseEntity<ApiResponse<InventoryResponse>> addStock(
            @PathVariable
            @Positive(message = "Inventory ID must be > 0")
            Long inventoryId,

            @RequestParam
            @Positive(message = "Quantity must be greater than zero")
            Integer quantity
    ) {
        InventoryResponse response = service.addStock(inventoryId, quantity);
        return ResponseEntity.ok(ApiResponse.success("Stock added successfully", response));
    }

    @PatchMapping("/{productId}/reduce-stock")
    @Operation(summary = "Reduce stock", description = "Decreasing the stock size by getting the product id and quantity")
    public ResponseEntity<ApiResponse<InventoryResponse>> reduceStock(
            @PathVariable
            @Positive(message = "Product ID must be > 0")
            Long productId,

            @RequestParam
            @Positive(message = "Quantity must be greater than zero")
            Integer quantity
    ) {
        InventoryResponse response = service.reduceStock(productId, quantity);
        return ResponseEntity.ok(ApiResponse.success("Stock added successfully", response));
    }

    private Pageable createPageable(int page, int size, String sortBy, String direction) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        return PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
    }



}
