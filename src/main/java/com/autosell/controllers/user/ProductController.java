package com.autosell.controllers.user;

import com.autosell.domains.Product;
import com.autosell.services.ProductService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping( value = {"/account"})
public class ProductController {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    WebApplicationContext servletContext;
    @Autowired
    ProductService productService;
    @ModelAttribute("products")
    List<Product> getAllProduct(Model model)
    {
        return productService.findAll();
    }


    @GetMapping("/product-form")
    public String showProductForm(@ModelAttribute("product") Product product, Model model)
    {
        return "user/product-form";
    }
    @PostMapping("/addproduct")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes)
    {

//        if (product.getProduct_image() == null) {
//
//            String localeMsg = messageSource.getMessage("productPicRequired", null, null, loc);
//            bindingResult.addError(new FieldError("product", "employeePic", product.getProduct_image(), false, null, null, localeMsg));
//        }else if(product.getProduct_image().getSize() == 0){
//
//            String localeMsg = messageSource.getMessage("employeePicRequired", null, null, loc);
//            bindingResult.addError(new FieldError("product", "employeePic", product.getProduct_image(), false, null, null, localeMsg));
//        }else{
//            String imgName = product.getId()+"."+ FilenameUtils.getExtension(product.getProduct_image().getOriginalFilename());
//            String absolutePath  = servletContext.getServletContext().getRealPath("/images/")+imgName;
//            MultipartFile product_image = product.getProduct_image();
//            try {
//                product_image.transferTo(new File(absolutePath));
//                product.setProduct_image(imgName);
//            } catch (IOException e) {
//                bindingResult.addError(new FieldError("product", "product_image", product.getProduct_image(), false, null, null, e.getLocalizedMessage()));
//            }

//        }
        if(bindingResult.hasErrors())
        {
            return "user/product-form";
        }

        if(product!=null) {
            productService.save(product);
        }

//        List<Product> products=productService.findAll();
//        redirectAttributes.addFlashAttribute("products",products);
        return "redirect:/account/product-details";

    }
    @GetMapping("/product-details")
    public String showDetails(Model model)
    {
        return "user/show-product-details";
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String showEditForm(@PathVariable("id") long id,Model model)
    {

        Optional<Product> employeeOptional =productService.findById(id);
        model.addAttribute("product",employeeOptional.get());
        return "user/product-edit";
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public String updateEmployee(@Valid @ModelAttribute("product") Product product,BindingResult bindingResult,@PathVariable("id") long id)
    {

        if (bindingResult.hasErrors()) {
            product.setId(id);
            return "user/product-edit";
        }
        productService.save(product);
        return("redirect:/account/product-details");
    }

    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") long id,Model model)
    {
        productService.deleteById(id);
        return("redirect:/account/product-details");
    }

}
