package com.example.inventory.service;

import com.example.inventory.entity.Product;
import com.example.inventory.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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


    //페이지
    public Page<Product> findPage(int page, int size, String keyword, String sort) {

        Pageable pageable;

        if (sort != null) {
            String[] s = sort.split(",");
            pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(s[1]), s[0]));
        } else {
            pageable = PageRequest.of(page, size);
        }

        if (keyword == null || keyword.isEmpty()) {
            return productRepository.findAll(pageable);
        }

        return productRepository.findByNameContaining(keyword, pageable);
    }

}
