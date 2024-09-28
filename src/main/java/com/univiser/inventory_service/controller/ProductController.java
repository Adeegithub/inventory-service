package com.univiser.inventory_service.controller;
import com.univiser.inventory_service.dto.ProductDTO;
import com.univiser.inventory_service.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController //Capability to handle http requests.
@RequestMapping("/api/products") //Base URL
public class ProductController {
    private ProductService productService;

    //Add Product REST API
    @PostMapping //Maps Incoming HTTP request
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO savedProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    //Get Products by id REST API
    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") int productId){
        ProductDTO searchedProduct = productService.getProductById(productId);
        return ResponseEntity.ok(searchedProduct);
    }

    //Get All Products REST API
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> allProducts =  productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }

    //Get Available Products REST API
    @GetMapping("/available")
    public ResponseEntity<List<ProductDTO>> getAvailableProducts(){
        List<ProductDTO> allProducts =  productService.getAvailableProducts();
        return ResponseEntity.ok(allProducts);
    }

    //Update Product REST API
    @PutMapping("{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("id") int productId,
                                                    @RequestBody ProductDTO updatedProduct){
        ProductDTO updatedProductDTO =  productService.updateProduct(productId,updatedProduct);
        return ResponseEntity.ok(updatedProductDTO);
    }

    //Delete Product REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Product Deleted Successfully!");
    }
}
