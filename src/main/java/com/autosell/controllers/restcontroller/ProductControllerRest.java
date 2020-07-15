package com.autosell.controllers.restcontroller;

import com.autosell.domains.Product;
import com.autosell.services.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
@Api(value = "")
public class ProductControllerRest {

    @Autowired
    ProductService productService;

    @GetMapping("/get-all-products")
    public List<Product> getAllProducts()
    {
        List<Product> products=productService.findAll();
        return products;
    }
    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable("id") Long id)
    {
        Optional<Product> product=productService.findById(id);
        return product;
    }

    @PostMapping("/add-products")
    public Product addProduct(@RequestBody Product product)
    {
        Product product1= productService.save(product);
        return product1;
    }

    @PostMapping("/delete-product/{id}")
    public Optional<Product> deleteProductById(@PathVariable("id") Long id)
    {

     Optional<Product> product= productService.deleteById(id);
     return product;
    }
}
