package com.autosell.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class staticPagesController {
    @GetMapping(value = "/page/about-us}")
    public String contactUs(){
        return "user/contactUs";
    }
}
