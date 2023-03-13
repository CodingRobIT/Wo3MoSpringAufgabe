package com.example.wo3mospringaufgabe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
@RestController
@RequestMapping("/shop")

public class ShopService {

    private ProductRepository productRepository;
    private OrderRepository orderRepository = new OrderRepository();

    public ShopService() {
        productRepository = new ProductRepository();
    }

    public void listProducts() {
        System.out.println(productRepository.list());
    }

    public void getProduct(String id) {
        System.out.println(productRepository.get(id));
    }

    public void listOrders() {
        System.out.println(orderRepository.list());
    }

    public void getOrder(String id) {
        System.out.println(orderRepository.get(id));
    }

    public Order addOrder(List<String> productIds) {
        List<Product> allProducts = new ArrayList<>();

        for (String productId : productIds) {
            Product product = productRepository.get(productId);

            if (product == null) {
                throw new NoSuchElementException("Product with Id: " + productId + " not found!");
            }

            allProducts.add(product);
        }

        Order order = new Order(UUID.randomUUID().toString(), allProducts);
        return orderRepository.add(order);
    }
}
