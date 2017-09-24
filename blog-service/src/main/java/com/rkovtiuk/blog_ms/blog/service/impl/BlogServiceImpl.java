package com.rkovtiuk.blog_ms.blog.service.impl;

import com.rkovtiuk.blog_ms.blog.domain.mappers.BlogMapper;
import com.rkovtiuk.blog_ms.blog.domain.mappers.CommentMapper;
import com.rkovtiuk.blog_ms.blog.repository.BlogRepository;
import com.rkovtiuk.blog_ms.blog.repository.CommentRepository;
import com.rkovtiuk.blog_ms.blog.service.BlogService;
import com.rkovtiuk.blog_ms.core.domain.entities.Blog;
import com.rkovtiuk.blog_ms.core.domain.entities.Comment;
import com.rkovtiuk.blog_ms.core.domain.models.BlogDTO;
import com.rkovtiuk.blog_ms.core.domain.requests.blog.CreateCommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BlogServiceImpl implements BlogService {

    private final int PER_PAGE = 20;
    private final BlogRepository blogRepository;
    private final CommentRepository commentRepository;
    private final BlogMapper blogMapper;
    private final CommentMapper commentMapper;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository,
                           CommentRepository commentRepository,
                           BlogMapper blogMapper,
                           CommentMapper commentMapper) {
        this.blogRepository = blogRepository;
        this.commentRepository = commentRepository;
        this.blogMapper = blogMapper;
        this.commentMapper = commentMapper;
    }

    @Override
    public List<BlogDTO> dashboard(int page) {
        PageRequest pageRequest = new PageRequest(page, PER_PAGE, null,null);
        return blogMapper.map(blogRepository.findAllOrderByCreatedDate(pageRequest));
    }

    @Override
    public List<BlogDTO> getBlogsByAuthor(int page, int authorId) {
        PageRequest pageRequest = new PageRequest(page, PER_PAGE, null,null);
        return blogMapper.map(blogRepository.findAllByAuthorId(authorId, pageRequest));
    }

    @Override
    public List<BlogDTO> getBlogsByCategory(int page, int categoryId) {
        PageRequest pageRequest = new PageRequest(page, PER_PAGE, null,null);
        return blogMapper.map(blogRepository.findAllByBlogCategoryIdOrderByCreatedDate(categoryId, pageRequest));
    }

    @Override
    public void removeBlog(Integer userId, int blogId) {
        Comment comment = commentRepository.findOne(blogId);
        if (comment==null || comment.getUser()!=null || !Objects.equals(comment.getUser().getId(), userId)) return;
        commentRepository.delete(blogId);
    }

    @Override
    public List<Comment> getComments(int page, int blogId) {
        PageRequest pageRequest = new PageRequest(page, PER_PAGE, null,null);
        return commentRepository.findAllByBlogIdOrderByCreatedDate(blogId, pageRequest).getContent();
    }

    @Override
    public Comment addComment(Integer userId, int blogId, CreateCommentRequest request) {
        Comment comment = commentMapper.map(request, userId, blogId);
        Blog blog = blogRepository.findById(blogId);
        comment.setBlog(blog);
        return commentRepository.save(comment);
    }
}
