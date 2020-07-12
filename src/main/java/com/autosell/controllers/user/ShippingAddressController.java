package com.autosell.controllers.user;

import com.autosell.domains.BillingAddress;
import com.autosell.domains.ShippingAddress;
import com.autosell.repositories.ShippingAddressRepository;
import com.autosell.services.BillingAddressService;
import com.autosell.services.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShippingAddressController {

    @Autowired
    ShippingAddressService shippingAddressService;
    @GetMapping(value = {"/shippingAddress_input"})
    public String billingAddressForm(@ModelAttribute("shippingAddress") ShippingAddress shippingAddress){
        return "user/shippingForm";
    }
    @PostMapping(value = {"/shippingAddress_save"})
    public String saveBillingAddress(@ModelAttribute("shippingAddress") ShippingAddress shippingAddress, Model model){
        model.addAttribute("shippingAddress", shippingAddress);
        shippingAddressService.save(shippingAddress);

        return "user/billingSuccess";
    }
}
