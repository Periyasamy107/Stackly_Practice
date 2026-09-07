package com.example.order.product.controller;

import com.example.order.common.exception.DuplicateResourceException;
import com.example.order.product.dto.request.ProductCreateRequest;
import com.example.order.product.dto.request.ProductUpdateRequest;
import com.example.order.product.dto.response.ProductResponse;
import com.example.order.product.entity.ProductCategory;
import com.example.order.product.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductControllerForFrontend {

    private final ProductService productService;

    // =========================================================
    // PRODUCT LIST
    // =========================================================
    @GetMapping
    public String getAllProducts(Model model) {
        List<ProductResponse> products = productService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("pageTitle", "All Products");
        return "product/list";
    }

    // =========================================================
    // ACTIVE PRODUCTS
    // =========================================================
    @GetMapping("/active")
    public String getAllActiveProducts(Model model) {
        List<ProductResponse> products = productService.getAllActiveProducts();
        model.addAttribute("products", products);
        model.addAttribute("pageTitle", "Active Products");
        return "product/active";
    }

    // =========================================================
    // SINGLE PRODUCT DETAILS
    // =========================================================
    @GetMapping("/{productId}")
    public String getProductById(
            @PathVariable
            @Positive(message = "Product ID must be greater than zero")
            Long productId,

            Model model
    ) {
        ProductResponse product = productService.getProductById(productId);
        model.addAttribute("product", product);
        model.addAttribute("pageTitle", product.name());
        return "product/detail";
    }

    // =========================================================
    // CREATE PRODUCT - FORM
    // =========================================================
    @GetMapping("/create")
    public String showCreateProductForm(Model model) {
        ProductCreateRequest product = new ProductCreateRequest("", null, null, null);
//        if(!model.containsAttribute("product")) {
//            model.addAttribute(new ProductCreateRequest("", "", null, null));
//        }
        model.addAttribute("product", product);
        model.addAttribute("categories", ProductCategory.values());
        model.addAttribute("pageTitle", "Create Product");
        return "product/create";
    }

    // =========================================================
    // CREATE PRODUCT - SUBMIT
    // =========================================================
    @PostMapping
    public String createProduct(
            @Valid @ModelAttribute("product") ProductCreateRequest request,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("categories", ProductCategory.values());
            model.addAttribute("pageTitle", "Create Product");
            return "product/create";
        }

        try{
            ProductResponse response = productService.createProduct(request);
            redirectAttributes.addFlashAttribute("successMessage", "Product created successfully");
            return "redirect:/products/" + response.id();
        } catch (DuplicateResourceException exception) {
            bindingResult.rejectValue("name", "duplicate", exception.getMessage());
            model.addAttribute("categories", ProductCategory.values());
            model.addAttribute("pageTitle", "Create Product");
            return "product/create";
        }

    }

    // =========================================================
    // UPDATE PRODUCT - FORM
    // =========================================================
    @GetMapping("/{productId}/edit")
    public String showEditProductForm(
            @PathVariable
            @Positive(message = "Product ID must be greater than zero")
            Long productId,
            Model model
    ) {
        ProductResponse product = productService.getProductById(productId);
        ProductUpdateRequest updateRequest = new ProductUpdateRequest(
                product.name(), product.description(), product.price(), product.category(), product.active()
        );
        model.addAttribute("productId", productId);
        model.addAttribute("product", updateRequest);
        model.addAttribute("categories", ProductCategory.values());
        model.addAttribute("pageTitle", "Edit Product");
        return "product/edit";
    }

    // =========================================================
    // UPDATE PRODUCT - SUBMIT
    // =========================================================
    @PostMapping("/{productId}")
    public String updateProduct(
            @PathVariable
            @Positive(message = "Product ID must be greater than zero")
            Long productId,

            @Valid @ModelAttribute("product") ProductUpdateRequest request,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("productId", productId);
            model.addAttribute("categories", ProductCategory.values());
            model.addAttribute("pageTitle", "Edit Product");
            return "product/edit";
        }
        productService.updateProduct(productId, request);
        redirectAttributes.addFlashAttribute("successMessage", "Product updated successfully");
        return "redirect:/products/" + productId;
    }

    // =========================================================
    // UPDATE PRODUCT STATUS
    // =========================================================
    @PostMapping("/{productId}/status")
    public String updateProductStatus(
            @PathVariable
            @Positive(message = "Product ID must be greater than zero")
            Long productId,

            @RequestParam boolean active,
            RedirectAttributes redirectAttributes
    ) {
        productService.updateProductStatus(productId, active);
        redirectAttributes.addFlashAttribute("successMessage", active ? "Product activated successfully" : "Product deactivated successfully");
        return "redirect:/products/" + productId;
    }

//    // =========================================================
//    // PAGINATED ACTIVE PRODUCT
//    // =========================================================
//    @GetMapping("/page")
//    public String getActiveProductsWithPaging(
//            @RequestParam(defaultValue = "0")
//            @PositiveOrZero(message = "Page number cannot be negative")
//            int page,
//
//            @RequestParam(defaultValue = "5")
//            @Positive(message = "Page size must be greater than zero")
//            int size,
//
//            @RequestParam(defaultValue = "id")
//            String sortBy,
//
//            @RequestParam(defaultValue = "asc")
//            String direction,
//
//            Model model
//    ) {
//        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
//        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
//        Page<ProductResponse> products = productService.getActiveProducts(pageable);
//        model.addAttribute("products", products);
//        model.addAttribute("sortBy", sortBy);
//        model.addAttribute("direction", direction);
//        model.addAttribute("pageTitle", "Products");
//        return "product/page";
//    }

    // =========================================================
    // SEARCH PRODUCT
    // =========================================================
    @GetMapping("/search")
    public String searchProducts(
            @RequestParam
            @NotBlank(message = "Product name cannot be blank")
            String name,

            @RequestParam(defaultValue = "0")
            @PositiveOrZero(message = "Page number cannot be negative")
            int page,

            @RequestParam(defaultValue = "5")
            @Positive(message = "Page size must be greater than zero")
            int size,

            Model model
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductResponse> products = productService.searchAllProductsByName(name, pageable);
        model.addAttribute("products", products);
        model.addAttribute("searchName", name);
        model.addAttribute("pageTitle", "Search Products");
        return "product/search";
    }

//    // =========================================================
//    // PRODUCTS BY CATEGORY
//    // =========================================================
//    @GetMapping("/category/{category}")
//    public String getProductsByCategory(
//            @PathVariable ProductCategory category,
//
//            @RequestParam(defaultValue = "0")
//            @PositiveOrZero(message = "Page number cannot be negative")
//            int page,
//
//            @RequestParam(defaultValue = "5")
//            @Positive(message = "Page size must be greater than zero")
//            int size,
//
//            Model model
//    ) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<ProductResponse> products = productService.getProductsByCategory(category, pageable);
//        model.addAttribute("products", products);
//        model.addAttribute("category", category);
//        model.addAttribute("categories", ProductCategory.values());
//        model.addAttribute("pageTitle", category.name());
//        return "product/category";
//    }
//
//    // =========================================================
//    // PRODUCTS BY PRICE - RANGE
//    // =========================================================
//    @GetMapping("/price-range")
//    public String getProductsByPriceRange(
//            @RequestParam
//            @DecimalMin(value = "0.00", message = "Minimum price cannot be negative")
//            BigDecimal minPrice,
//
//            @RequestParam
//            @DecimalMin(value = "0.01", message = "Maximum price must be > 0")
//            BigDecimal maxPrice,
//
//            @RequestParam(defaultValue = "0")
//            @PositiveOrZero(message = "Page number cannot be negative")
//            int page,
//
//            @RequestParam(defaultValue = "5")
//            @Positive(message = "Page size must be greater than zero")
//            int size,
//
//            @RequestParam(defaultValue = "id")
//            String sortBy,
//
//            @RequestParam(defaultValue = "asc")
//            String direction,
//
//            Model model
//    ) {
//        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
//        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
//        Page<ProductResponse> products = productService.getProductsByPriceRange(minPrice, maxPrice, pageable);
//        model.addAttribute("products", products);
//        model.addAttribute("minPrice", minPrice);
//        model.addAttribute("maxPrice", maxPrice);
//        model.addAttribute("sortBy", sortBy);
//        model.addAttribute("direction", direction);
//        model.addAttribute("pageTitle", "Products by price range");
//        return "product/price-range";
//    }
//
//    // =========================================================
//    // NATIVE CATEGORY SEARCH
//    // =========================================================
//    @GetMapping("/native/category/{category}")
//    public String getProductsByCategoryNative(
//            @PathVariable ProductCategory category,
//
//            @RequestParam(defaultValue = "0")
//            @PositiveOrZero(message = "Page number cannot be negative")
//            int page,
//
//            @RequestParam(defaultValue = "5")
//            @Positive(message = "Page size must be greater than zero")
//            int size,
//
//            Model model
//    ) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<ProductResponse> products = productService.getProductsByCategoryNative(category, pageable);
//        model.addAttribute("products", products);
//        model.addAttribute("category", category);
//        model.addAttribute("pageTitle", "Native Category Search");
//        return "product/native-category";
//    }



}
