package com.univiser.inventory_service.service;

import com.univiser.inventory_service.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    //Create Product
    ProductDTO createProduct(ProductDTO productDTO);

    //Get Product By ID
    ProductDTO getProductById(int productId);

    //Get All Products
    List<ProductDTO> getAllProducts();

    //Get Available Products
    List<ProductDTO> getAvailableProducts();

    //Update Product
    ProductDTO updateProduct(int productId, ProductDTO updatedProduct);

    //Delete Product
    void deleteProduct(int productId);

}
