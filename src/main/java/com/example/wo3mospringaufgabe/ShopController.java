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

//    @GetMapping("/products/{id}")
//    public String getProducts(@PathVariable String id) {
//        return productRepository.get(id).toString();
//    }
//
//    @GetMapping("/orders")
//    public String getOrders() {
//        return orderRepository.list().toString();
//    }
//
//    @GetMapping("/orders/{id}")
//    public String getOrders(@PathVariable String id) {
//        return orderRepository.get(id).toString();
//    }
//    @PostMapping
//    public void addOrder(@RequestBody List<String> productId){
//        orderRepository.
//
//    }
}
