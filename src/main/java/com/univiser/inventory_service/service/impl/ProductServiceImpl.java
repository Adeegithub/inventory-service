package com.univiser.inventory_service.service.impl;

import com.univiser.inventory_service.dto.ProductDTO;
import com.univiser.inventory_service.entity.Product;
import com.univiser.inventory_service.exception.ResourceNotFoundException;
import com.univiser.inventory_service.mapper.ProductMapper;
import com.univiser.inventory_service.repository.ProductRepository;
import com.univiser.inventory_service.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    //Injecting Dependencies
    private ProductRepository productRepository;
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = ProductMapper.mapToProduct(productDTO);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDTO(savedProduct);
    }

    @Override
    public ProductDTO getProductById(int productId) {
        Product searchedProduct = productRepository.findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product ID not found with the id: " + productId));
        return ProductMapper.mapToProductDTO(searchedProduct);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
         List<Product> allProducts = productRepository.findAll();
        return allProducts.stream().map((product) -> ProductMapper.mapToProductDTO(product))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAvailableProducts() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream().filter(product -> product.getQuantity() > 0).map((product) -> ProductMapper.mapToProductDTO(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO updateProduct(int productId, ProductDTO updatedProduct) {
        Product product = productRepository.findById(productId).orElseThrow(
                ()-> new ResourceNotFoundException("Product Not Found with given id: " + productId));

        product.setProductName(updatedProduct.getProductName());
        product.setQuantity(updatedProduct.getQuantity());
        product.setPrice(updatedProduct.getPrice());

        Product updatedProductObj =  productRepository.save(product);
        return ProductMapper.mapToProductDTO(updatedProductObj);
    }

    @Override
    public void deleteProduct(int productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                ()-> new ResourceNotFoundException("Product Not Found with given id: " + productId));

        productRepository.deleteById(productId);
    }
}
