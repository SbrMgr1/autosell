package com.autosell.controllers.user;

import com.autosell.configs.OrderStatusEnum;
import com.autosell.domains.*;
import com.autosell.helpers.MyHelper;
import com.autosell.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/buyer/payment_input")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Autowired
    ProductOrderService productOrderService;

    @Autowired
    UserService userService;


    @Autowired
    BillingAddressService billingAddressService;

    @Autowired
    ShippingAddressService shippingAddressService;


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

            billingAddress = billingAddressService.save(billingAddress);
            shippingAddress = shippingAddressService.save(shippingAddress);

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findByUserName(authentication.getName());

            ProductOrder productOrder = new ProductOrder();
            productOrder.setTransactionId(MyHelper.getRandomInt());
            productOrder.setBillingAddress(billingAddress);
            productOrder.setShippingAddress(shippingAddress);
            productOrder.setOrderStatus(OrderStatusEnum.PENDING);
            productOrder.setBuyer(user);

            //saving billing address
            //saving shipping address



            //collecting product
            List<OrderdProduct> orderdProducts = new ArrayList<OrderdProduct>();
            Map<Long,Product> products = (HashMap<Long,Product>)session.getAttribute("cart_item");
            for(Map.Entry<Long, Product> entry : products.entrySet()) {
                Long key = entry.getKey();
                Product p = entry.getValue();
                OrderdProduct orderdProduct = new OrderdProduct();
                orderdProduct.setPrice(p.getPrice());
                orderdProduct.setQty(p.getQty());
                orderdProduct.setTax(p.getTax());
                orderdProduct.setProduct(p);

                orderdProducts.add(orderdProduct);

            }

            productOrder.setProducts(orderdProducts);
            productOrderService.save(productOrder);

            paymentService.save(payment);
            redirectAttributes.addFlashAttribute(payment);
            return "redirect:/buyer/payment_input/payment-success";
        }

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
