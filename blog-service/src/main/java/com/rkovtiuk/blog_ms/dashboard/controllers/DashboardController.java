package com.rkovtiuk.blog_ms.dashboard.controllers;

import com.rkovtiuk.blog_ms.core.domain.model.BlogDTO;
import com.rkovtiuk.blog_ms.dashboard.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.rkovtiuk.blog_ms.core.utils.Path.BlogApi.DASHBOARD;

@RestController
public class DashboardController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(DASHBOARD)
    public List<BlogDTO> dashboard(@RequestParam(value = "page", defaultValue = "1") int page){
        return blogService.dashboard(page);
    }

}
