package com.rkovtiuk.blog_ms.webui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.rkovtiuk.blog_ms.webui.utils.Pages.*;

@Controller
public class WebUIController {

    @RequestMapping("/")
    public String home(ModelMap modelMap){
        return HOME_PAGE;
    }

    @RequestMapping("/dashboard")
    public String dashboard(ModelMap modelMap){
        return DASHBOARD_PAGE;
    }

    @RequestMapping("/notifications")
    public String notifications(ModelMap modelMap){
        return NOTIFICATIONS_PAGE;
    }

    @RequestMapping("/blog")
    public String blog(ModelMap modelMap){
        return BLOG_PAGE;
    }

}
