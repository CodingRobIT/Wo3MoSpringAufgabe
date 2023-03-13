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
        products.put("3", new Product("3", "Dattel"));
        products.put("4", new Product("4", "Papaya"));
        products.put("5", new Product("5", "Himbeere"));
        products.put("6", new Product("6", "Blaubeere"));
        products.put("7", new Product("7", "Erdbeere"));
        products.put("8", new Product("8", "Kaki"));
        products.put("9", new Product("9", "Lytchi"));
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
