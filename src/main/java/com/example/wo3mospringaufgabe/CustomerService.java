package com.example.wo3mospringaufgabe;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final ProductRepository productRepository;

    public CustomerService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.list();
    }
}
