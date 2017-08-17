package com.rkovtiuk.blog_ms.blog.repository;

import com.rkovtiuk.blog_ms.core.domain.entities.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

    Page<Comment> findAllByBlogIdOrderByCreatedDate(Integer id, Pageable pageable);

}
