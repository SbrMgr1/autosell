package com.autosell.controllers.user;

import com.autosell.domains.BillingAddress;
import com.autosell.domains.User;
import com.autosell.services.BillingAddressService;
import com.autosell.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BillingAddressController {
    @Autowired
    BillingAddressService billingAddressService;
    UserService userService;
    User user;
    @GetMapping(value = {"/billingAddress_input"})
    public String billingAddressForm(@ModelAttribute("billingAddress")BillingAddress billing){
        return "user/billingForm";
    }
    @PostMapping(value = {"/billingAddress_save"})
    public String saveBillingAddress(@ModelAttribute("billingAddress")BillingAddress billing, Model model, RedirectAttributes redirectAttributes){
        //model.addAttribute("allBillingAddress", billingAddressService.getAllBillingAddress());
        billingAddressService.save(billing);
//        List<BillingAddress> billingAdres = new ArrayList<BillingAddress>();
//        billingAdres.add(billing);
//        user.setBillingAddress(billingAdres);
//        userService.saveBillingAddressByID(billing.getId());
        redirectAttributes.addFlashAttribute(billing);
        return "redirect:saveSuccess";
    }
    @GetMapping(value = {"/saveSuccess"})
    public String billingAddressSuccess(Model model){
        model.addAttribute("allBillingAddress", billingAddressService.getAllBillingAddress());
        return "redirect:/shippingAddress_input";
    }
    @GetMapping(value = {"/billingList"})
    public String billingAddressList(Model model){
        model.addAttribute("allBillingAddress", billingAddressService.getAllBillingAddress());
        return "/user/billingSuccess";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        BillingAddress billing = billingAddressService.findById(id);

        model.addAttribute("billingAddressUpdate", billing);
        return "/user/update_Billing";
    }
    @PostMapping(value={"/edit/update/{id}"})
    public String updateBillingAddress(@PathVariable("id") long id, BillingAddress billing, BindingResult result, Model model){
        if(result.hasErrors()){
            billing.setId(id);
            return "/user/update_Billing";
        }
        billingAddressService.save(billing);
        model.addAttribute("allBillingAddress",billingAddressService.getAllBillingAddress());
        return "/user/billingSuccess";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, BillingAddress billing, Model model) {
        billing = billingAddressService.findById(id);
        billingAddressService.delete(billing);
        model.addAttribute("allBillingAddress", billingAddressService.getAllBillingAddress());
        return "/user/billingSuccess";
    }
}
