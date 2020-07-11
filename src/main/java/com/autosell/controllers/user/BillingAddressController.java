package com.autosell.controllers.user;

import com.autosell.domains.BillingAddress;
import com.autosell.services.BillingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BillingAddressController {
    @Autowired
    BillingAddressService billingAddressService;
    @GetMapping(value = {"/billingAddress_input"})
    public String billingAddressForm(@ModelAttribute("billingAddress")BillingAddress billing){
        return "user/shippingBilling";
    }
    @PostMapping(value = {"/billingAddress_save"})
    public String saveBillingAddress(@ModelAttribute("billingAddress")BillingAddress billing, Model model){
        model.addAttribute("billingAddress", billing);
        billingAddressService.save(billing);

        return "user/billingSuccess";
    }
}
