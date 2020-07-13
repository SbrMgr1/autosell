package com.autosell.controllers.admin;

import com.autosell.domains.Content;
import com.autosell.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
@RequestMapping(value = "/administration/cms-managent")
public class ContentController {

    @Autowired
    ContentService contentService;

    @GetMapping(value = {"","/"})
    public String index(Model model){
        Content content = new Content("aboutus","about us","Content Here");
        contentService.save(content);
        List<Content> contents = contentService.getAllContents();
        model.addAttribute("contents",contents);
        return "admin/cms_list";
    }
    @GetMapping("/add")
    public String getContent(@ModelAttribute("con")Content con){
        return "admin/contentForm";
    }
    @PostMapping("/add")
    public String addContent(@ModelAttribute("con")Content con, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "admin/contentForm";
        }
        contentService.save(con);

        List<Content> contents = contentService.getAllContents();
        model.addAttribute("contents",contents);
        return "admin/cms_list";
    }
    @GetMapping(value = "/edit/{slug}")
    public String editContent(@ModelAttribute("con")Content con,@PathVariable("slug")String slug,Model model){

        Content content=contentService.find(slug);
        model.addAttribute(content);

        return "admin/editContentForm";
    }
    @GetMapping(value = "/delete/{slug}")
    public String deleteContent(@PathVariable("slug")String slug,Model model){
        contentService.delete(slug);
        List<Content> contents = contentService.getAllContents();
        model.addAttribute("contents",contents);
        return "admin/cms_list";
    }

}
