package com.example.wo3mospringaufgabe;

public record Customer(
        String id,
        String name
) {
    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
