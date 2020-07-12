package com.autosell.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session){
        System.out.println("--------------------------------------"+session.getAttribute("user_name"));
        return "user/index";
    }
    @PostMapping
    public void something(){

    }





}
