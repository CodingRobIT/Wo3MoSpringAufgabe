package com.example.wo3mospringaufgabe;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class OrderRepository {

    private final Map<String, Order> orders = new HashMap<>();

    public OrderRepository() { // unten nur als test damit die Order nicht leer ist
     // orders.put("1", new Order("1", List.of(new Product("1", "Apple"))));
//        orders.put("2", new Order("2", List.of(new Product("3", "Dattel"), new Product("4", "Papaya"))));
//        orders.put("3", new Order("3", List.of(new Product("5", "Himbeere"), new Product("6", "Blaubeere"))));
//        orders.put("4", new Order("4", List.of(new Product("7", "Erdbeere"), new Product("8", "Kaki"),new Product("9","Lychee"))));
    }

//    public OrderRepository(Map<String, Order> orders) {
//        this.orders = orders;
//    }

    public List<Order> list() {
        return new ArrayList<>(orders.values());
    }

    public Order get(String id) {
        return orders.get(id);
    }

    public Order add(Order order) {
        orders.put(order.getId(), order);
        return order;
    }

    public void deleteOrder(String id) {
        orders.remove(id);
    }

    public void putOrder(Order order) {
        orders.put(order.getId(), order);
    }
}
