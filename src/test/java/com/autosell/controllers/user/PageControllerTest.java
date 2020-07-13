package com.autosell.controllers.user;

import com.autosell.domains.Content;
import com.autosell.services.ContentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


class PageControllerTest {

    @InjectMocks
    PageController pageController;
    @Mock
    ContentService contentService;
    @Mock
    Model model;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    

    @Test
  public void getPage()
    {
       Content content=new Content("about","name","content");
        String viewName = pageController.getPage("about", model);
        assertEquals("user/page", viewName);
        verify(contentService, times(1)).find("about");
        verify(model, times(1)).addAttribute(eq("content"),argumentCaptor.capture());
    }

    @GetMapping("page/{slug}")
    public String getPage(@PathVariable("slug") String slug, Model model) {
        Content content = contentService.find(slug);
        model.addAttribute("content", content);
        return "user/page";

    }
}