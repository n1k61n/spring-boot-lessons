package com.example.testapp.controllers;


import com.example.testapp.services.ProductService;
import com.example.testapp.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // POST → Create a new product
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Double price = product.getPrice() < 0 ? 0 : product.getPrice();
        Integer stock = product.getStock() < 0 ? 1 : product.getStock();

        Product saved = productService.createProduct(
                product.getName(),
                price,
                product.getCategory(),
                stock
        );
        return ResponseEntity.ok(saved);
    }

    // GET → All products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{searchByName}/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        return productService.findProductByName(name)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(productService.findProductsByName(name));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updatePrice(@PathVariable Long id, @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProductPrice(id, productDetails.getPrice());
        return ResponseEntity.ok(updatedProduct);
    }
}