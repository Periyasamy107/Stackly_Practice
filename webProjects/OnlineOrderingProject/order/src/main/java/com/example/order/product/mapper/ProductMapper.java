package com.example.order.product.mapper;

import com.example.order.product.dto.request.ProductCreateRequest;
import com.example.order.product.dto.response.ProductResponse;
import com.example.order.product.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductCreateRequest request);

    ProductResponse toResponse(Product product);

}
