package com.example.shop.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Long createProduct(ProductCreateRequest request){
        Product product = new Product(
                request.getName(),
                request.getPrice(),
                request.getStock()
        );

        productRepository.save(product);
        return product.getId();
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product getProductById(Long id){
        Product product = productRepository.findBtId(id);
        if(product == null){
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }
        return product;
    }

    @Transactional
    public void updateProduct(Long id, ProductUpdateRequest request){
        Product product = productRepository.findById(id);
        if(product == null){
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }
        product.updateInfo(request.getName(), request.getPrice(), request.getStock());
    }

    @Transactional
    public void deleteProduct(Long id){
        Product product = productRepository.findById(id);
        if(product == null){
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }
        productRepository.deleteById(id);
    }

}
