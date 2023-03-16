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

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @Test
        //@DirtiesContext //Bräuchte ich beim ersten Test nicht zwingend
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

    @Test
    @DirtiesContext
    void testGetAllProducts_shouldReturnOneProduct_whenRepositoryHasOneProduct() throws Exception {
        Product product = new Product("L0815", "Löffel");
        productRepository.save(product);  //in Sergj seinem beispiel steht hier productRepository.add(product);

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                           {
                            "id": "L0815",
                            "name": "Löffel"
                          }
                        ]
                        """));
    }


    @Test
    @DirtiesContext
    void addProduct_shouldReturnCreatedProduct() throws Exception {
        // Wir verschicken eine POST Anfrage an die URL
        mockMvc.perform(
                        // WAS WIR VERSCHICKEN
                        post("/api")
                                // Das ist unser Format - wir verschicken fast immer JSON
                                .contentType(MediaType.APPLICATION_JSON)
                                // Was im Body beim POST-Request verschickt wird
                                .content(
                                        """
                                                 {
                                                     "name": "Schaufel",
                                                     "id": "1"
                                                 }
                                                """
                                ))
                // VERGLEICH - IST UNSER ERGEBNIS RICHTIG?
                .andExpect(
                        // Der Status den wir zurück bekommen
                        status().isOk()
                )
                .andExpect(
                        // Das ist der Request Body - Der Inhalt den wir bekommen
                        content().json(
                                """
                                         {
                                             "name": "Schaufel",
                                             "id": "1"
                                         }
                                        """
                        ));
    }



  /*  @Test
    // @DirtiesContext = Putzkraft => Wenn du etwas eingefügt hast ins Repo, lösche es danach wieder!
    @DirtiesContext
    void getAllProducts_shouldReturnListWithOneProduct_whenRepositoryHasOneProduct() throws Exception {
        // Wie kriegen wir etwas ins Repo?
        // zB per POST .. oder?
        // einfach direkt mit einem Repository aufruf!
        Product product = new Product("Georgischer Rotwein", "1");
        productRepository.add(product);

        // mockMvc.perform -> wie bei Postman, verschickt eine Anfrage
        // GET = HTTP Verb um etwas anzufragen
        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                                [
                                   {
                                    "name": "Georgischer Rotwein",
                                    "id": "1"
                                  }
                                ]
                                """));
    } */

    @Autowired
    OrderRepository orderRepository;
    //Order order;

    @Test
    @DirtiesContext
    void testGetAllOrder_shouldReturnEmptyList_whenOrderRepositoryIsEmpty() throws Exception {
        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        []
                        """));
    }

   /* @Test
    @DirtiesContext
    void testGetAllOrder_shouldReturnOneOrder_whenOrderRepositoryHasOneOrder() throws Exception {

        Order order = new Order("B2", List.of(new Product("K8", "Klobürste")));

        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                           {
                             "id": "B2"
                          }
                        ]
                        """));
    } */

}