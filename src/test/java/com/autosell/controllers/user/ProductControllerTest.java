package com.autosell.controllers.user;

import com.autosell.domains.Category;
import com.autosell.domains.Product;
import com.autosell.services.CategoryService;
import com.autosell.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ProductControllerTest {


    @InjectMocks
   private ProductController productController;

    @Mock

    private ProductService productService;

    @Mock

    private CategoryService categoryService;
    @Mock

    private Model model;


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

//        Product product1=new Product(1l,"Bike",20.2f,7.7f,1,"This is description","boat.jpg",false,1l,0);
//        Product product2=new Product(2l,"Phone",203.42f,7.7f,1,"This is description","phone.jpg",false,2l,0);
//        Product product3=new Product(12l,"Laptop",1420.2f,7.7f,1,"This is description","laptop.jpg",false,3l,0);
//        Product product4=new Product(13l,"Desktop",40.2f,7.7f,1,"This is description","desktop.jpg",false,3l,0);
//        Product product5=new Product(14l,"Boat",14.2f,7.7f,1,"This is description","laptop.jpg",false,4l,0);
//        Product product6=new Product(3l,"Jacket",420.2f,7.7f,1,"This is description","jacket.jpg",false,4l,0);
//        Product product7=new Product(4l,"Shoe",120.2f,7.7f,1,"This is description","shoe.jpg",false,1l,0);

        List<Category> categories=new ArrayList<>();
        categories.add(new Category(1,"Electronics","this is desc"));
        categories.add(new Category(2,"Jwellery","this is desc"));
        categories.add(new Category(3,"Jwellery","this is desc"));




    }
    @Test
    public void showProductForm()
    {
        String viewName = productController.showProductForm(new Product(), model);
        verify(model, times(1)).addAttribute(eq("categories"), verify(categoryService, times(1)).findAll());
        assertEquals("user/product_form", viewName);
    }


}