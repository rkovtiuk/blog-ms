package com.rkovtiuk.blog_ms.blog.domain.mappers;

import com.rkovtiuk.blog_ms.core.domain.entities.Comment;
import com.rkovtiuk.blog_ms.core.domain.requests.blog.CreateCommentRequest;

public interface CommentMapper {
    Comment map(CreateCommentRequest request, Integer userId, int blogId);
}
