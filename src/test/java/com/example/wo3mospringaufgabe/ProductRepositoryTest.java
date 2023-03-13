package com.example.wo3mospringaufgabe;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProductRepositoryTest {

//    @Test
//    void list() {
//        //GIVEN
//        ProductRepository productRepository = new ProductRepository();
//
//        //WHEN
//        List<Product> actual = productRepository.list();
//
//        //THEN
//        List<Product> expected = new ArrayList<>();
//        expected.add(new Product("1", "Apple"));
//        expected.add(new Product("2", "Banana"));
//
//        assertEquals(expected, actual);
//    }

    @Test
    void get() {
        //GIVEN
        ProductRepository productRepository = new ProductRepository();

        //WHEN
        Product actual = productRepository.get("1");

        //THEN
        Product expected = new Product("1", "Apple");

        assertEquals(expected, actual);
    }

//    @Test
//    void get_whenNonExistingId_thenReturnNull() {
//        //GIVEN
//        ProductRepository productRepository = new ProductRepository();
//
//        //WHEN
//        Product actual = productRepository.get("3");
//
//        //THEN
//        assertNull(actual);
//    }
}
