package com.example.wo3mospringaufgabe;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class ShopController {
    private final ShopService shopService;

    private final VendorService vendorService;

    public ShopController(ShopService shopService, VendorService vendorService) {
        this.shopService = shopService;
        this.vendorService = vendorService;
    }

    @GetMapping("/products")                //localhost:8080/api/products
    public List<Product> getProducts() {
        return shopService.listProducts();
    }

    @GetMapping("/products/{id}")           //localhost:8080/api/products/2  (Letze Zahl ist Produkt Nummer (
    public Product getProducts(@PathVariable String id) {
        return shopService.getProduct(id);
    }

    @GetMapping("/orders")              //localhost:8080/api/orders
    public List<Order> getOrders() {
        return shopService.listOrders();
    }

    @GetMapping("/orders/{id}")         //localhost:8080/api/orders/3 (Letzte Zahl ist die Order Nummer)
    public Order getOrders(@PathVariable String id) {
        return shopService.getOrder(id);
    }

    //    @PostMapping
//    public void addOrder(@RequestBody List<String> productId){
//        shopService.addOrder(productId);
//
//    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return vendorService.addProduct(product);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity deleteOrder(@PathVariable String id) {
        shopService.deleteOrder(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/orders")
    public void putOrder(@RequestBody Order order) {
        shopService.putOrder(order);
    }
}


