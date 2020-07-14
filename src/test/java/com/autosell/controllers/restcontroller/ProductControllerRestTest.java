package com.autosell.controllers.restcontroller;

import com.autosell.AutosellApplication;
import com.autosell.ServletInitializer;
import com.autosell.controllers.admin.UserController;
import com.autosell.domains.Product;
import com.autosell.repositories.ProductRepository;
import com.autosell.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase
@WithMockUser(username = "admin",password = "admin",roles={"ADMIN_ROLE"})
@WebMvcTest(ProductControllerRest.class)
class ProductControllerRestTest {
    @Autowired
    MockMvc mockMvc;


    @Autowired
    ProductControllerRest productController;

//    @MockBean
//    private ProductRepository repository;

    @MockBean
    ProductService productService;

    Product product1, product2, product3, product4, product5;

    @BeforeEach
    void setup() throws JsonProcessingException {
        product1 = new Product(1l, "Bike", 20.2f, 7.7f, 1, "This is description", "boat.jpg", false, 1l, 0);
        product2 = new Product(2l, "Phone", 203.42f, 7.7f, 1, "This is description", "phone.jpg", false, 2l, 0);
        product3 = new Product(12l, "Laptop", 1420.2f, 7.7f, 1, "This is description", "laptop.jpg", false, 3l, 0);
        product4 = new Product(13l, "Desktop", 40.2f, 7.7f, 1, "This is description", "desktop.jpg", false, 3l, 0);
        product5 = new Product(14l, "Boat", 14.2f, 7.7f, 1, "This is description", "laptop.jpg", false, 4l, 0);
    }


    @Test
    public void getAllProducts() {
        Mockito.when(productService.findAll()).thenReturn(Stream.of(product1, product2, product3, product4, product5).collect(Collectors.toList()));
        Assertions.assertThat(5).isEqualTo(productController.getAllProducts().size());
    }

    @Test
    public void getById() {
        Long id = 1l;
        Mockito.when(productService.findById(id)).thenReturn(java.util.Optional.ofNullable(product1));
        Assertions.assertThat(product1).isEqualTo(productController.getById(id));
    }

    @Test
    public void addProduct() {
        Mockito.when(productService.save(product1)).thenReturn(product1);
        Assertions.assertThat(product1).isEqualTo(productController.addProduct(product1));
    }

    @Test
    public void deleteProductById() {
        Long id = 1l;
        Mockito.when(productService.findById(id)).thenReturn(java.util.Optional.ofNullable(product1));
        Assertions.assertThat(product1).isEqualTo(productController.deleteProductById(1l));
//    }
    }
}