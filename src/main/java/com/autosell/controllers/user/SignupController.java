package com.autosell.controllers.user;

import com.autosell.configs.RoleEnum;
import com.autosell.domains.Role;
import com.autosell.domains.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SignupController{

    @GetMapping(value = "/signup")
    public String signupForm(@ModelAttribute("user") User user,Model model){
        model.addAttribute("label","Buyer");
        return "user/signup";
    }
    @PostMapping(value = "/signup")
    public String saveBuyer(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            System.out.println("===================================");
            model.addAttribute("label","Buyer");
            return "user/signup";
        }else{
            return "redirect:/signin";
        }

    }
    @GetMapping(value = "/seller-signup")
    public String sellerSignupForm(@ModelAttribute("user") User user,Model model){
        model.addAttribute("label","Seller");
        return "user/signup";
    }
}
