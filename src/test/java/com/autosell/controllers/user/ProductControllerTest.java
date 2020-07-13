package com.autosell.controllers.user;

import com.autosell.domains.Product;
import com.autosell.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {
    @Autowired
    private  MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
   private ProductController productController;

    @Autowired

    private ProductService productService;

    @BeforeEach
    void setUp() throws JsonProcessingException {
        List<Product> products=new ArrayList<>();
        products.add(new Product(1l,"Bike",20.2f,7.7f,1,"This is description","boat.jpg",false,1l,0));
        products.add(new Product(2l,"Phone",203.42f,7.7f,1,"This is description","phone.jpg",false,2l,0));
        products.add(new Product(12l,"Laptop",1420.2f,7.7f,1,"This is description","laptop.jpg",false,3l,0));
        products.add(new Product(13l,"Desktop",40.2f,7.7f,1,"This is description","desktop.jpg",false,3l,0));
        products.add(new Product(14l,"Boat",14.2f,7.7f,1,"This is description","laptop.jpg",false,4l,0));
        products.add(new Product(3l,"Jacket",420.2f,7.7f,1,"This is description","jacket.jpg",false,4l,0));
        products.add(new Product(4l,"Shoe",120.2f,7.7f,1,"This is description","shoe.jpg",false,1l,0));
    }

   @Test
    public
}