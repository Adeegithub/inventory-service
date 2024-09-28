package com.univiser.inventory_service.mapper;

import com.univiser.inventory_service.dto.ProductDTO;
import com.univiser.inventory_service.entity.Product;

public class ProductMapper {
    public static ProductDTO mapToProductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getProductName(),
                product.getQuantity(),
                product.getPrice()
        );
    }

    public static Product mapToProduct(ProductDTO productDTO){
        return new Product(
                productDTO.getId(),
                productDTO.getProductName(),
                productDTO.getQuantity(),
                productDTO.getPrice()
        );
    }
}
