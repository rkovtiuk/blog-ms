package com.rkovtiuk.blog_ms.dashboard.repository;

import com.rkovtiuk.blog_ms.db.domain.entities.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BlogRepository extends Repository<Blog, Integer>{

    Blog findById(Integer id);

    List<Blog> findByAuthorId(Integer id);

    Page<Blog> findAllOrderByCreatedDate(Pageable pageable);

    Page<Blog> findAllByBlogCategoryIdOrderByCreatedDate(Pageable pageable);

}
