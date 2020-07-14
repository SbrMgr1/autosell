package com.autosell.controllers.restcontroller;

import com.autosell.domains.Product;
import com.autosell.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerRestTest {

    @Autowired
    ProductService productService;

    @InjectMocks
    ProductControllerRest productControllerRest = new ProductControllerRest();

    Product product1,product2,product3,product4,product5;
    @BeforeEach
    void setup() throws JsonProcessingException {
//    Product product1,product2,product3,product4,product5;
//        Product product1 = new Product(1l, "Bike", 20.2f, 7.7f, 1, "This is description", "boat.jpg", false, 1l, 0);
//        Product product2 = new Product(2l, "Phone", 203.42f, 7.7f, 1, "This is description", "phone.jpg", false, 2l, 0);
//        Product product3 = new Product(12l, "Laptop", 1420.2f, 7.7f, 1, "This is description", "laptop.jpg", false, 3l, 0);
//        Product product4 = new Product(13l, "Desktop", 40.2f, 7.7f, 1, "This is description", "desktop.jpg", false, 3l, 0);
//        Product product5 = new Product(14l, "Boat", 14.2f, 7.7f, 1, "This is description", "laptop.jpg", false, 4l, 0);
    }

    @Test
    public void getAllProducts() {
        Mockito.when(productService.findAll()).thenReturn(Stream.of(product1, product2, product3, product4,product5).collect(Collectors.toList()));
        Assertions.assertThat(5).isEqualTo(productControllerRest.getAllProducts().size());
    }

    @Test
    public void getById() {
        Long id = 1l;
        Mockito.when(productService.findById(id)).thenReturn(java.util.Optional.ofNullable(product1));
        Assertions.assertThat(product1).isEqualTo(productControllerRest.getById(id));
    }

    @Test
    public void addProduct() {
        Mockito.when(productService.save(product1)).thenReturn(product1);
        Assertions.assertThat(product1).isEqualTo(productControllerRest.addProduct(product1));
    }
    @Test
    public void deleteProductById() {
        Long id = 1l;
        Mockito.when(productService.findById(id)).thenReturn(java.util.Optional.ofNullable(product1));
        Assertions.assertThat(product1).isEqualTo(productControllerRest.deleteProductById(1l));
    }
}