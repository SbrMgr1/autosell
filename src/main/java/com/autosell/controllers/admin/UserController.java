package com.autosell.controllers.admin;

import com.autosell.domains.User;
import com.autosell.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/administration/users")
public class UserController {

//    @Autowired
//    JavaMailSender javaMailSender;


    @Autowired
    UserService userService;

    @GetMapping(value = {"", "/"})
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/user_list";
    }

    @PostMapping(value = "/accept/{id}")
    public @ResponseBody
    boolean acceptUser(@PathVariable("id") long id) {
        try {

//            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//            simpleMailMessage.setSubject("Hi");
//            simpleMailMessage.setText("Hi bro");
//            simpleMailMessage.setTo("sbr.mgr1@gmail.com");
//            javaMailSender.send(simpleMailMessage);
//

            return userService.acceptById(id);
        } catch (NullPointerException e) {
            return false;
        }

    }

}
