package com.autosell.controllers.user;

import com.autosell.domains.Content;
import com.autosell.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @Autowired
    ContentService contentService;

<<<<<<< HEAD
    @GetMapping("/page/{slug}")
    public String getPage(@PathVariable("slug") String slug, Model model)
    {
        Content content=contentService.find(slug);
        model.addAttribute("content",content);
=======
    @GetMapping("page/{slug}")
    public String getPage(@PathVariable("slug") String slug, Model model) {
        Content content = contentService.find(slug);
        model.addAttribute("content", content);
>>>>>>> bb60739288dcc20301311fba52d07a654d1b4548
        return "user/page";

    }
}
