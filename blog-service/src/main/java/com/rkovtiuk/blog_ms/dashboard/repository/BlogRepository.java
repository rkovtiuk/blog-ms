package com.rkovtiuk.blog_ms.dashboard.repository;

import com.rkovtiuk.blog_ms.db.domain.entities.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BlogRepository extends Repository<Blog, Integer>{

    Blog findById(Integer id);

    Page<Blog> findAllOrderByCreatedDate(Pageable pageable);

    Page<Blog> findAllByAuthorId(Integer id, Pageable pageable);

    Page<Blog> findAllByBlogCategoryIdOrderByCreatedDate(Integer id, Pageable pageable);

}
