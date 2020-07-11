package com.autosell.controllers.user;

import com.autosell.domains.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping( value = {"/account"})
public class ProductController {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    WebApplicationContext servletContext;

    @GetMapping("/product-form")
    public String showProductForm(@ModelAttribute("product") Product product, Model model)
    {
        return "user/product-form";
    }
    @PostMapping("/addproduct")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes)
    {

        if (product.getProduct_image() == null) {

            String localeMsg = messageSource.getMessage("productPicRequired", null, null, loc);
            bindingResult.addError(new FieldError("product", "employeePic", product.getProduct_image(), false, null, null, localeMsg));
        }else if(product.getProduct_image().getSize() == 0){

            String localeMsg = messageSource.getMessage("employeePicRequired", null, null, loc);
            bindingResult.addError(new FieldError("product", "employeePic", product.getProduct_image(), false, null, null, localeMsg));
        }else{
            String imgName = product.getId()+"."+FilenameUtils.getExtension(product.getProduct_image().getOriginalFilename());
            String absolutePath  = servletContext.getServletContext().getRealPath("/images/")+imgName;
            MultipartFile product_image = product.getProduct_image();
            try {
                product_image.transferTo(new File(absolutePath));
                product.setProduct_image(imgName);
            } catch (IOException e) {
                bindingResult.addError(new FieldError("product", "product_image", product.getProduct_image(), false, null, null, e.getLocalizedMessage()));
            }

        }
        if(bindingResult.hasErrors())
        {
            return "user/product-form";
        }
//        redirectAttributes.addFlashAttribute("products",products);
        return "redirect:/account/product-details";

    }
    @GetMapping("/account/product-details")
    public String showDetails(Model model)
    {
        return "user/show-product-details";
    }

}
