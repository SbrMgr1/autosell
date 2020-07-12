package com.autosell.controllers.user;

import com.autosell.domains.Product;
import com.autosell.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("products")
    public List<Product> getAllProducts(Model model)
    {
        return productService.findAll();
    }
    @GetMapping("/")
    public String home(){
        return "user/index";
    }


    @PostMapping
    public void something(){

    }





}
