package com.autosell.controllers.user;

import com.autosell.domains.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping( value = {"/account"})
public class ProductController {

    @GetMapping("/product-form")
    public String showProductForm(@ModelAttribute("product") Product product, Model model)
    {
        return "user/product-form";
    }
    @PostMapping("/addproduct")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes)
    {
        System.out.println("here");
        if(bindingResult.hasErrors())
        {
            return "user/product-form";
        }
//        redirectAttributes.addFlashAttribute("products",products);
        return "redirect:/account/product-details";

    }
    @GetMapping("/account/product-details")
    public String showDetails(Model model)
    {
        return "user/show-product-details";
    }

}
