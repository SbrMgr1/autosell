package com.autosell.controllers.admin;

import com.autosell.domains.Product;
import com.autosell.domains.ProductOrder;
import com.autosell.services.ProductOrderService;
import com.autosell.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/admin/account")
@Controller
public class AdminOrderController {
    @Autowired
    ProductOrderService productOrderService;
    @Autowired
    ProductService productService;

    @RequestMapping(value = {"","/"})
    public String getOrders(Model model, HttpSession session){
        Product product =productService.findById(1).get();
        List<Product> products= Arrays.asList(product);
        model.addAttribute("products",products);

        ProductOrder productOrder1= new ProductOrder();
        productOrder1.setOrder_status("Recived");
        productOrderService.save(productOrder1);
        session.setAttribute("orders",productOrderService.findAll());
        model.addAttribute("orders",productOrderService.findAll());
        return "admin/orderForm";
    }
    @PostMapping(value = "/save")
    public String save(@ModelAttribute("order")ProductOrder productOrder, @RequestParam("order-status")String stat,@RequestParam("id")Long id, Model model){
      //  ProductOrder order=productOrderService.find(id);
      //  order.setOrder_status(stat);
     //   productOrderService.save(order);
        model.addAttribute("orders",productOrderService.findAll());
        return "admin/orderForm";
    }
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id")Long id, Model model){
        Product product =productService.findById(1).get();
        List<Product> products= Arrays.asList(product);
        model.addAttribute("products",products);

        productOrderService.deleteById(id);
        model.addAttribute("orders",productOrderService.findAll());
        return "admin/orderForm";
    }

    @GetMapping(value = "/edit/{id}")
    public String editOrder(@PathVariable("id")Long id, Model model){
        Product product =productService.findById(1).get();
        List<Product> products= Arrays.asList(product);
        model.addAttribute("products",products);
        ProductOrder productOrder=new ProductOrder();
        productOrder.setOrder_status("Recived");
        model.addAttribute("order",productOrder);
        return "admin/editOrderForm";
    }
}
