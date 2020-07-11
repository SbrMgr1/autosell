package com.autosell.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administration/product-category")
public class CategoryController {

    @GetMapping(value = {"/",""})
    public String index(){
        return  "admin/category_list";
    }
}
