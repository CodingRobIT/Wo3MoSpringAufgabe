package com.example.wo3mospringaufgabe;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class ShopController {
ShopService shopService= new ShopService();

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
    @PostMapping
    public void addOrder(@RequestBody List<String> productId){
        shopService.addOrder(productId);

    }

//    von der Musterlösung______________________________________________
//    @PostMapping("orders/")
//    public Order addOrder(@RequestBody List<String> productIds) {
//        return shopService.addOrder(productIds);  //Einziger Unterschied Matthias hat hier n return davor.
//    }
}
