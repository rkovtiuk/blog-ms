package com.rkovtiuk.blog_ms.webui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.rkovtiuk.blog_ms.webui.utils.Pages.HOME_PAGE;

@Controller
public class WebUIController {

    @RequestMapping("/")
    public String home(ModelMap model){
        return HOME_PAGE;
    }

}
