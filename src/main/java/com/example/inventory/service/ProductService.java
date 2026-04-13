package com.example.inventory.service;

import com.example.inventory.entity.Product;
import com.example.inventory.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    //조회 API
    public List<Product> findAll() {
        return productRepository.findAll();
    }


    //상품삭제
    public void delete(Long id) {
        productRepository.deleteById(id);
    }


    //상품수정
    public void update(Long id, Product newData) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("상품 없음"));

        product.setName(newData.getName());
        product.setQuantity(newData.getQuantity());
        product.setPrice(newData.getPrice());
        product.setPurchase(newData.getPurchase());

        productRepository.save(product);
    }


    //상품검색
    public List<Product> search(String name) {
        return productRepository.findByNameContaining(name);
    }
}
