package com.example.shop.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductCreateRequest request) {
        Long productId = productService.createProduct(request);
        return ResponseEntity.created(URI.create("/items/" + productId)).build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping{"/{itemId}"}
    public ResponseEntity<Product> getProduct(@PathVariable Long itemId){
        Product product = productService.getProductById(itemId);
        return ResponseEntity.ok(product);
    }

    @PatchMapping("/{itemId}")
    public ResponseEntity<Void> updateProduct(
            @PathVariable Long itemId,
            @RequestBody ProductUpdateRequest request){
        productService.updateProduct(itemId, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long itemId){
        productService.deleteProduct(itemId);
        return ResponseEntity.noContent().build();
    }

}
