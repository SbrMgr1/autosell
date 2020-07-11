package com.autosell.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignupController{

    @GetMapping(value = "/signup")
    public String signupForm(){

        return "user/signup";
    }
}
