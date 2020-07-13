package com.autosell.controllers.user;

import com.autosell.domains.Payment;
import com.autosell.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @GetMapping(value = "/payment_input")
    public String paymentInput(@ModelAttribute("payment")Payment payment){

        return "/user/paymentForm";
    }
    @PostMapping(value = {"/payment_save"})
    public String savePayment(@ModelAttribute("payment")Payment payment, Model model, RedirectAttributes redirectAttributes){
        //model.addAttribute("allBillingAddress", billingAddressService.getAllBillingAddress());
        paymentService.save(payment);
        redirectAttributes.addFlashAttribute(payment);
        return "redirect:savePaymentSuccess";
    }
    @GetMapping(value = {"/savePaymentSuccess"})
    public String PaymentUpdate(Model model){
        model.addAttribute("allPaymentMethod", paymentService.getAllPayment());
        return "/user/paymentSuccess";
    }
    @GetMapping("/editPayment/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Payment payment = paymentService.findById(id);
        model.addAttribute("paymentUpdate", payment);

        return "/user/update_Payment";
    }
    @PostMapping(value={"/editPayment/update/{id}"})
    public String updatePayment(@PathVariable("id") long id, Payment payment, BindingResult result, Model model){
        if(result.hasErrors()){
            payment.setId(id);
            return "/user/update_Payment";
        }
        paymentService.save(payment);
        model.addAttribute("allPaymentMethod",paymentService.getAllPayment());
        return "/user/paymentSuccess";
    }
    @GetMapping("/deletePayment/{id}")
    public String deleteUser(@PathVariable("id") long id, Payment payment, Model model) {
        payment = paymentService.findById(id);
        paymentService.delete(payment);
        model.addAttribute("allPaymentMethod", paymentService.getAllPayment());
        return "/user/paymentSuccess";
    }

}
