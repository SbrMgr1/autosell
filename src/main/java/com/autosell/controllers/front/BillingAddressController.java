package com.autosell.controllers.front;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BillingAddressController {
    @GetMapping(value = {"/billingAddress_save"})
    public String billingAddressForm(@ModelAttribute("billingAddress")BillingAddressController billing){
        return "shippingBilling";
    }
    @PostMapping(value = {"/billingAddress_save"})
    public String saveBillingAddress(BillingAddressController billing, Model model){
        model.addAttribute("billingAddress", billing);
        return "shippingBilling";
    }
}
