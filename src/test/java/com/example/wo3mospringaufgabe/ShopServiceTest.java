package com.example.wo3mospringaufgabe;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;


class ShopServiceTest {

    //GIVEN (Für alle Tests)

    OrderRepository orderRepository = mock(OrderRepository.class);
    ProductRepository productRepository = mock(ProductRepository.class);
    IdService idService = mock(IdService.class);
    ShopService shopService = new ShopService(productRepository, orderRepository, idService); //wird nicht gemockt da wir sonst den ShopService nicht testen können

    @Test
    void addOrder() {
        //GIVEN
        //ShopService shopService = new ShopService(); Wird jetzt nicht mehr genutz da wir Mocks dafür nutzen
        List<String> productIds = List.of("124");
        when(productRepository.get("124"))
                .thenReturn(new Product("451", "GameBoy"));
        when(orderRepository.add(new Order("randomID", List.of(new Product("451", "GameBoy")))))
                .thenReturn(new Order("randomID", List.of(new Product("451", "GameBoy"))));
        when(idService.generateId())
                .thenReturn("randomID"); //Natürlich kann man hier auch nur RandomID schreiben oder 1 oder 2 oder a um sich den stress zu ersparen mit der langen nummer/ID

        //WHEN
        Order actual1 = shopService.addOrder(productIds);

        //THEN
        Order expected = new Order("randomID", List.of(new Product("451", "GameBoy")));
        assertEquals(expected, actual1);

        verify(productRepository).get("124");
        verify(orderRepository).add(new Order("randomID", List.of(new Product("451", "GameBoy"))));
        verify(idService).generateId();
        assertEquals(expected, actual1);
    }

    @Test
    void addOrder_whenInvalidId_thenThrowException() {
        //GIVEN
        //ShopService shopService = new ShopService(); Auch hier wird jetzt nicht mehr genutzt
        when(productRepository.get("3"))
                .thenReturn(null);

        List<String> productIds = List.of("3");

        //WHEN
        try {
            shopService.addOrder(productIds);

            //THEN
            fail();
        } catch (NoSuchElementException e) {

        }
        verify(productRepository).get("3");
    }

    @Test
    void listProductTest() {
        //GIVEN
        when(productRepository.list())
                .thenReturn(List.of(new Product("1", "Apple")));

        //WHEN
        List<Product> actual = shopService.listProducts();
        List<Product> expected = List.of(new Product("1", "Apple"));


        //THEN
        verify(productRepository).list();
        assertEquals(expected, actual);


    }

    @Test
    void listOrderTest() {
        //GIVEN
        when(orderRepository.list())
                .thenReturn(List.of(new Order("1", List.of(new Product("1", "Birnen")))));
        //WHEN
        List<Order> actual = shopService.listOrders();
        List<Order> expected = List.of(new Order("1", List.of(new Product("1", "Birnen"))));
        //THEN
        verify(orderRepository).list();
        assertEquals(expected, actual);

    }






}
