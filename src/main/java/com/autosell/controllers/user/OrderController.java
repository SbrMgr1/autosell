package com.autosell.controllers.user;

import com.autosell.domains.ProductOrder;
import com.autosell.services.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/orders")
@Controller
public class OrderController {
    @Autowired
    ProductOrderService productOrderService;

    @RequestMapping(value = {"","/"})
    public String getOrders(Model model){
        ProductOrder productOrder1= new ProductOrder();
        productOrderService.save(productOrder1);
        model.addAttribute("orders",productOrderService.findAll());
        return "admin/orderForm";
    }
    @PostMapping(value = "/save")
    public String save(@ModelAttribute("productOrder")ProductOrder productOrder,Model model){
        productOrderService.save(productOrder);
        model.addAttribute("orders",productOrderService.findAll());
        return "admin/orderForm";
    }
    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id")Long id, Model model){
        ProductOrder order=productOrderService.find(id);
        model.addAttribute("order",order);
        return "admin/editOrderForm";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id")Long id, Model model){
        productOrderService.deleteById(id);
        model.addAttribute("orders",productOrderService.findAll());
        return "admin/orderForm";
    }
}
