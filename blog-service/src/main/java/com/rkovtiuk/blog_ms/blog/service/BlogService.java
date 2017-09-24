package com.rkovtiuk.blog_ms.blog.service;

import com.rkovtiuk.blog_ms.core.domain.entities.Comment;
import com.rkovtiuk.blog_ms.core.domain.models.BlogDTO;
import com.rkovtiuk.blog_ms.core.domain.requests.blog.CreateCommentRequest;

import java.util.List;

public interface BlogService {
    List<BlogDTO> dashboard(int page);

    List<BlogDTO> getBlogsByAuthor(int page, int authorId);

    List<BlogDTO> getBlogsByCategory(int page, int categoryId);

    void removeBlog(Integer userId, int blogId);

    List<Comment> getComments(int page, int blogId);

    Comment addComment(Integer userId, int blogId, CreateCommentRequest request);
}
