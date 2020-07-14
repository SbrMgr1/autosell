package com.autosell.controllers.user;

import com.autosell.domains.Product;
import com.autosell.domains.ProductOrder;
import com.autosell.services.ProductOrderService;
import com.autosell.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequestMapping("/buyer/account")
@Controller
public class UserOrderController {
    @Autowired
    ProductOrderService productOrderService;
    @Autowired
    ProductService productService;

    @RequestMapping(value = {"","/order"})
    public String getOrders(Model model, HttpSession session){
       ProductOrder productOrder= (ProductOrder)session.getAttribute("productOrder1");
       model.addAttribute("productOrder",productOrder);
        return "admin/orderForm";
    }
//    @PostMapping(value = "/save")
//    public String save(@ModelAttribute("productOrder")ProductOrder productOrder,Model model){
//
//        return "admin/orderForm";
//    }
//    @GetMapping(value = "/edit/{id}")
//    public String edit(@PathVariable("id")Long id, Model model){
//
//        return "admin/editOrderForm";
//    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id")Long id, Model model){

        return "admin/orderForm";
    }
    @PostMapping(value = "/order")
    public String order(@ModelAttribute("order")ProductOrder order,Model model){

        return "user/orderSuccess";
    }
    @GetMapping(value = "/checkout")
    public String orderForm(Model model){

        return "user/orderForm";
    }
    @GetMapping(value = "/edit")
    public String editOrder(Model model){

        return "user/orderForm";
    }
}
