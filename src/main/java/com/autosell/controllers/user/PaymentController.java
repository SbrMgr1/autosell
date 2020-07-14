package com.autosell.controllers.user;

import com.autosell.domains.BillingAddress;
import com.autosell.domains.Payment;
import com.autosell.domains.ProductOrder;
import com.autosell.domains.ShippingAddress;
import com.autosell.services.BillingAddressService;
import com.autosell.services.PaymentService;
import com.autosell.services.ProductOrderService;
import com.autosell.services.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/buyer/payment_input")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Autowired
    ProductOrderService productOrderService;


    @GetMapping(value = {"/", ""})
    public String paymentInput(@ModelAttribute("payment") Payment payment) {

        return "/user/paymentForm";
    }

    @PostMapping(value = {"/", ""})
    public String savePayment(@Valid @ModelAttribute("payment") Payment payment, BindingResult result, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "/user/paymentForm";
        } else {
            BillingAddress billingAddress = (BillingAddress) session.getAttribute("billingAddress");
            ShippingAddress shippingAddress = (ShippingAddress) session.getAttribute("shippingAddress");

            if(billingAddress ==null || shippingAddress == null){
                return "redirect:/";
            }

            ProductOrder productOrder = new ProductOrder();


//            productOrderService.findAll()


//            billingAddressService.save(billingAddress);
//            shippingAddressService.save(shippingAddress);

            session.setAttribute("billingAddress",null);
            session.setAttribute("shippingAddress",null);

            paymentService.save(payment);
            redirectAttributes.addFlashAttribute(payment);
        }
        return "redirect:/buyer/payment_input/payment-success";
    }

    @GetMapping(value = {"/payment-success"})
    public String PaymentUpdate(Model model) {
        model.addAttribute("allPaymentMethod", paymentService.getAllPayment());
        return "/user/paymentSuccess";
    }

    @GetMapping("/editPayment/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Payment payment = paymentService.findById(id);
        model.addAttribute("paymentUpdate", payment);

        return "/user/update_Payment";
    }

    @PostMapping(value = {"/editPayment/update/{id}"})
    public String updatePayment(@PathVariable("id") long id, Payment payment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            payment.setId(id);
            return "/user/update_Payment";
        }
        paymentService.save(payment);
        model.addAttribute("allPaymentMethod", paymentService.getAllPayment());
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
