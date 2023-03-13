package com.example.wo3mospringaufgabe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {

    private final Map<String, Product> products;

    public ProductRepository() {
        products = new HashMap<>();
        products.put("1", new Product("1", "Apple"));
        products.put("2", new Product("2", "Banana"));
    }

    public ProductRepository(Map<String, Product> products) {
        this.products = products;
    }

    public List<Product> list() {
        return new ArrayList<>(products.values());
    }

    public Product get(String id) {
        return products.get(id);
    }
}
