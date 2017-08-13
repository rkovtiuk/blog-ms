package com.rkovtiuk.blog_ms.dashboard.controllers;

import com.rkovtiuk.blog_ms.core.domain.models.BlogDTO;
import com.rkovtiuk.blog_ms.dashboard.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.rkovtiuk.blog_ms.core.utils.Path.BlogApi.*;

@RestController
public class DashboardController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(DASHBOARD)
    public List<BlogDTO> dashboard(@RequestParam(value = "page", defaultValue = "1") int page){
        return blogService.dashboard(page);
    }

    @RequestMapping(GET_BLOGS_BY_AUTHOR)
    public List<BlogDTO> blogsByAuthor(@RequestParam(value = "page", defaultValue = "1") int page,
                                       @PathVariable(value = "id") int authorId){
        return blogService.getBlogsByAuthor(page, authorId);
    }

    @RequestMapping(GET_BLOGS_BY_CATEGORY)
    public List<BlogDTO> blogsByCategory(@RequestParam(value = "page", defaultValue = "1") int page,
                                         @RequestParam(value = "category_id") int categoryId){
        return blogService.getBlogsByCategory(page, categoryId);
    }

}
