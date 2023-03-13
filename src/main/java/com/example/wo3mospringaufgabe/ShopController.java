package com.example.wo3mospringaufgabe;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class ShopController {
ShopService shopService= new ShopService();

    @GetMapping("/products")
    public List<Product> getProducts() {
        return shopService.listProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProducts(@PathVariable String id) {
        return shopService.getProduct(id);
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return shopService.listOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrders(@PathVariable String id) {
        return shopService.getOrder(id);
    }
    @PostMapping
    public void addOrder(@RequestBody List<String> productId){
        shopService.addOrder(productId);

    }
}
