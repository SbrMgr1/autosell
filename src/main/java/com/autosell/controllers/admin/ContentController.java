package com.autosell.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/administration/cms-managent")
public class ContentController {


    @GetMapping(value = {"","/"})
    public String index(){
        return "admin/cms_list";
    }
}
