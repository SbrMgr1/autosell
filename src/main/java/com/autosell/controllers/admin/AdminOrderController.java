package com.autosell.controllers.admin;


import com.autosell.domains.ProductOrder;
import com.autosell.services.ProductOrderService;
import com.autosell.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.List;

@RequestMapping("/admin/account")
@Controller
public class AdminOrderController {
    @Autowired
    ProductOrderService productOrderService;
    @Autowired
    ProductService productService;

    @RequestMapping(value = {"","/"})
    public String getOrders(Model model){
       List<ProductOrder> productOrders= productOrderService.getAll();
       model.addAttribute("productOrders",productOrders);
        return "admin/orderForm";
    }
    @PostMapping(value = "/save")
    public String save(@ModelAttribute("order")ProductOrder productOrder, @RequestParam("order-status")String stat,@RequestParam("id")Long id, Model model,HttpSession session){
        productOrderService.get(id).setOrder_status(stat);
        model.addAttribute("productOrders",productOrderService.getAll());
        ProductOrder productOrder1 = productOrderService.get(id);
        session.setAttribute("productOrder1",productOrder1);
        return "admin/orderForm";
    }
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id")Long id, Model model){
        productOrderService.deleteById(id);
        model.addAttribute("productOrders",productOrderService.getAll());
        return "admin/orderForm";
    }

    @GetMapping(value = "/edit/{id}")
    public String editOrder(@ModelAttribute("productOrder")ProductOrder productOrder,@PathVariable("id")Long id, Model model){
        return "admin/editOrderForm";
    }

    @RequestMapping(value = {"/history"})
    public String getHistory(Model model){
        List<ProductOrder> productOrders= productOrderService.getAll();
        model.addAttribute("productOrders",productOrders);
        return "admin/history";
    }
}
