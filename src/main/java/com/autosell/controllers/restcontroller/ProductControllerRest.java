package com.autosell.controllers.restcontroller;

import com.autosell.domains.Product;
import com.autosell.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductControllerRest {
  @Autowired
  ProductService productService;

    @GetMapping("/get-all-products")
    public List<Product> getAllProducts()
    {
        return productService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable("id") Long id)
    {
        return productService.findById(id);
    }

    @PostMapping("/add-products")
    public Product addProduct(@RequestBody Product product)
    {
        return productService.save(product);
    }

    @PostMapping("/delete-product/{id}")
    public Optional<Product> deleteProductById(@PathVariable("id") Long id)
    {
     return productService.deleteById(id);
    }
}
