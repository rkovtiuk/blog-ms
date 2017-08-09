package com.rkovtiuk.blog_ms.dashboard.service;

import com.rkovtiuk.blog_ms.core.domain.model.BlogDTO;

import java.util.List;

public interface BlogService {
    List<BlogDTO> dashboard(int page);

    List<BlogDTO> getBlogsByAuthor(int page, int authorId);

    List<BlogDTO> getBlogsByCategory(int page, int categoryId);
}
