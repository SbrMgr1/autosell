package com.autosell.controllers.admin;

import com.autosell.domains.Category;
import com.autosell.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/administration/product-category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = {"/",""})
    public String index(){
        return  "admin/category_list";
    }

    @GetMapping(value = "/add")
    public String showCategoryForm(@ModelAttribute("category")Category category){
        return "admin/category_form";
    }
    @PostMapping(value = "/add")
    public String addCategoruy(@Valid  @ModelAttribute("category")Category category, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "admin/category_form";
        }else{
            categoryService.save(category);
            return "redirect:/administration/product-category";
        }

    }
}
