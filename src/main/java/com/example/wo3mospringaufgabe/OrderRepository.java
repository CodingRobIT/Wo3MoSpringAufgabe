package com.example.wo3mospringaufgabe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {

    private Map<String, Order> orders = new HashMap<>();

    public OrderRepository() {
        orders.put("1", new Order("1", List.of(new Product("1", "Apple"), new Product("2", "Banana"))));
    }

    public OrderRepository(Map<String, Order> orders) {
        this.orders = orders;
    }

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
}
