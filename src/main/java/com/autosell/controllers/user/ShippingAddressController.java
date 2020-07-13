package com.autosell.controllers.user;


import com.autosell.domains.ShippingAddress;
import com.autosell.repositories.ShippingAddressRepository;
import com.autosell.services.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShippingAddressController {

    @Autowired
    ShippingAddressService shippingAddressService;
    @GetMapping(value = {"/shippingAddress_input"})
    public String shippingAddressForm(@ModelAttribute("shippingAddress") ShippingAddress shippingAddress){
        return "user/shippingForm";
    }
    @PostMapping(value = {"/shippingAddress_save"})
    public String saveShippingAddress(@ModelAttribute("shippingAddress") ShippingAddress shippingAddress, Model model){
        model.addAttribute("shippingAddress", shippingAddress);
        shippingAddressService.save(shippingAddress);
        return "redirect:saveShippingSuccess";
    }
    @GetMapping(value = {"/saveShippingSuccess"})
    public String shippingAddressSuccess(Model model){
        model.addAttribute("allShippingAddress", shippingAddressService.getAllShippingAddress());
        return "/user/shippingSuccess";
    }
    @GetMapping("/editShipping/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        ShippingAddress shipping = shippingAddressService.findById(id);

        model.addAttribute("shippingAddressUpdate", shipping);
        return "/user/update_Shipping";
    }
    @PostMapping(value={"/editShipping/update/{id}"})
    public String updateShippingAddress(@PathVariable("id") long id, ShippingAddress shipping, BindingResult result, Model model){
        if(result.hasErrors()){
            shipping.setId(id);
            return "/user/update_Shipping";
        }
        shippingAddressService.save(shipping);
        model.addAttribute("allShippingAddress",shippingAddressService.getAllShippingAddress());
        return "/user/shippingSuccess";
    }
    @GetMapping("/deleteShipping/{id}")
    public String deleteShipping(@PathVariable("id") long id, ShippingAddress shipping, Model model) {
        shipping= shippingAddressService.findById(id);
        shippingAddressService.delete(shipping);
        model.addAttribute("allShippingAddress", shippingAddressService.getAllShippingAddress());
        return "/user/shippingSuccess";
    }
}
