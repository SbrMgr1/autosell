package com.autosell.controllers.user;

import com.autosell.domains.Content;
import com.autosell.domains.Product;
import com.autosell.domains.User;
import com.autosell.services.CategoryService;
import com.autosell.services.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class ProductControllerTest {
    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Mock
    private CategoryService categoryService;

    @Mock
    private Model model;

    @Test
    public void showProductForm()
    {
        String viewName = productController.showProductForm(new Product(), model);
        verify(model, times(1)).addAttribute(eq("categories"), any());
        assertEquals("user/product_form", viewName);
    }

    @Test
    public void index()
    {
        String viewName = productController.index(model);
        verify(model, times(1)).addAttribute(eq("products"), any());
        assertEquals("user/product_list", viewName);

    }

    @Test
    public void showEditForm()
    {
        Product product1=new Product(1l,"Bike",20.2f,7.7f,1,"This is description","boat.jpg",false,1l,0);
        Product product=new Product();
        Long id=1l;
        String viewName = productController.showEditForm(id,model);
        when(productService.findById(id)).thenReturn(Optional.of(product));
        verify(productService, times(1)).findById(id);
        verify(model, times(1)).addAttribute(eq("product"),product);
        verify(model, times(1)).addAttribute(eq("categories"), anyList());
        assertEquals("user/product_form", viewName);
    }

}