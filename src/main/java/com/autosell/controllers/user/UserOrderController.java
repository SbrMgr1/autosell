package com.autosell.controllers.user;

import com.autosell.domains.Product;
import com.autosell.domains.ProductOrder;
import com.autosell.services.ProductOrderService;
import com.autosell.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping(value = "/order")
    public String order(@ModelAttribute("order")ProductOrder order,Model model){

        return "user/orderSuccess";
    }
    @GetMapping(value = "/checkout")
    public String orderForm(Model model){
        Product product =productService.findById(1).get();
        List<Product> products= Arrays.asList(product);
        model.addAttribute("products",products);
        ProductOrder productOrder=new ProductOrder();
        model.addAttribute("order",productOrder);
        return "user/orderForm";
    }
    @GetMapping(value = "/edit")
    public String editOrder(Model model){
        Product product2 =productService.findById(1).get();
        List<Product> products= Arrays.asList(product2);
        model.addAttribute("products",products);
        ProductOrder productOrder=new ProductOrder();
        model.addAttribute("order",productOrder);
        return "user/orderForm";
    }
}
