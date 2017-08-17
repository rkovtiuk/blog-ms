package com.rkovtiuk.blog_ms.blog.domain.mappers.impl;

import com.rkovtiuk.blog_ms.core.domain.requests.blog.CreateCommentRequest;
import com.rkovtiuk.blog_ms.blog.domain.mappers.CommentMapper;
import com.rkovtiuk.blog_ms.core.domain.entities.Comment;
import com.rkovtiuk.blog_ms.core.domain.entities.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CommentMapperImpl implements CommentMapper{

    @Override
    public Comment map(CreateCommentRequest request, Integer userId, int blogId) {
        Comment comment = new Comment();
        comment.setCreatedDate(new Date().getTime());
        comment.setText(request.getText());
        User user = new User();
        user.setId(userId);
        comment.setUser(user);
        return comment;
    }
}
