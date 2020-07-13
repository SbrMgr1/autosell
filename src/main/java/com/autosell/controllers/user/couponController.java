package com.autosell.controllers.user;

import com.autosell.domains.Coupon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class couponController {

    @GetMapping(value = "/coupon")
    public String viewCoupon(@ModelAttribute("couponDets") Coupon coupon, Model model){
        return "user/couponForm";
    }
    @PostMapping(value="/coupon_save")
    public String saveCoupon(@ModelAttribute("coupons")Coupon coupon, Model model){
        return "user/couponDetails";
    }

}
