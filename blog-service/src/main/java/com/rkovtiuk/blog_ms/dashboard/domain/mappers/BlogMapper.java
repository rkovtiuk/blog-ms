package com.rkovtiuk.blog_ms.dashboard.domain.mappers;

import com.rkovtiuk.blog_ms.core.domain.model.BlogDTO;
import com.rkovtiuk.blog_ms.db.domain.entities.Blog;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BlogMapper {

    List<BlogDTO> map(Page<Blog> pageableBlogs);
}
