package com.rkovtiuk.blog_ms.blog.domain.mappers;

import com.rkovtiuk.blog_ms.core.domain.models.BlogDTO;
import com.rkovtiuk.blog_ms.core.domain.entities.Blog;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BlogMapper {

    List<BlogDTO> map(Page<Blog> pageableBlogs);
}
