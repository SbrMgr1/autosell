package com.autosell.controllers.user;

import com.autosell.configs.RoleEnum;
import com.autosell.domains.Role;
import com.autosell.domains.User;
import com.autosell.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SignupController{

    @Autowired
    UserService userService;

    @GetMapping(value = "/signup")
    public String signupForm(@ModelAttribute("user") User user,Model model){
        model.addAttribute("label","Buyer");
        return "user/signup";
    }
    @PostMapping(value = "/signup")
    public String saveBuyer(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            model.addAttribute("label","Buyer");
            model.addAttribute("error_msg","Error Occured.");
            return "user/signup";
        }else{
            user.setRole(RoleEnum.ROLE_BUYER);
            userService.save(user);
            redirectAttributes.addFlashAttribute("success_msg","Your account has been registered successfully. We will inform you in 24 hours.");
            return "redirect:/signin";
        }

    }
    @GetMapping(value = "/signup-seller")
    public String sellerSignupForm(@ModelAttribute("user") User user,Model model){
        model.addAttribute("label","Seller");
        return "user/signup";
    }
}
