package com.example.wo3mospringaufgabe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Data                 //Bruachen wir nicht bei record nur wenn es eine Class ist wird mit Lombok gearbeitet
//@NoArgsConstructor
//@AllArgsConstructor

public record Product(
        String id,
        String name) {

//    private String id;   //wird so nur verwendet wenn man public class Product hat also kein record
//    private String name;
}
