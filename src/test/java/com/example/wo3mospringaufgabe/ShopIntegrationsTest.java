package com.example.wo3mospringaufgabe;

import org.junit.jupiter.api.Test;

//package de.neuefische.integrationtest.controller;

// import de.neuefische.integrationtest.model.Product;
// import de.neuefische.integrationtest.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ShopIntegrationsTest {

    // Mock = So was wie Nachmachen
    // MockMvc ermöglicht uns Anfragen nachzumachen
    // Damit mockMvc NICHT null ist, müssen wir die Abhängigkeit, d.h. die DEPENDENCY bereitstellen...
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProductRepository productRepository;

    // 1. Wurde die Anfrage verstanden und angenommen? -> Status 200 = OK
    // 2. Bekommen wir alle Produkte zurück?
    // Wenn die Datenbank leer ist -> bekommen wir eine leere Liste []

    // Wenn wir alle Produkte abrufen
    // Sollen alle Produkte zurück kommen
    // Testmethode + sollte ...
    // PS: Es könnte vllllt eine Exception entstehen, das ist uns dann aber egal, weil dann ist der Test eben fehlgeschlagen
    @DirtiesContext
    @Test
    void testGetAllProducts_shouldReturnEmptyList_whenRepositoryIsEmpty() throws Exception {
        // mockMvc.perform -> wie bei Postman, verschickt eine Anfrage
        // GET = HTTP Verb um etwas anzufragen
        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                                []
                                """));
    }

    @Autowired
    OrderRepository orderRepository;
    Order order;

    @Test
    void testGetAllOrder_shouldReturnEmptyList_whenOrderRepositoryIsEmpty() throws Exception {
        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                                []
                                """));
    }

//    @Test
//    void getOrders() {
//
//
//    @Test
//    void testGetOrders() {
//    }
//
//    @Test
//    void addProduct() {
//    }
//
//    @Test
//    void deleteOrder() {
//    }
//
//    @Test
//    void putOrder() {
//    }
}