package com.rkovtiuk.blog_ms.blog.controllers;

import com.rkovtiuk.blog_ms.blog.service.BlogService;
import com.rkovtiuk.blog_ms.core.domain.entities.Comment;
import com.rkovtiuk.blog_ms.core.domain.models.BlogDTO;
import com.rkovtiuk.blog_ms.core.domain.requests.blog.CreateCommentRequest;
import com.rkovtiuk.blog_ms.core.exception.AuthorizedException;
import com.rkovtiuk.blog_ms.core.exception.EmptyRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.rkovtiuk.blog_ms.core.utils.NetworkUtils.createTokenHeader;
import static com.rkovtiuk.blog_ms.core.utils.Path.AuthApi.TOKEN_HEADER_NAME;
import static com.rkovtiuk.blog_ms.core.utils.Path.BlogApi.*;
import static com.rkovtiuk.blog_ms.core.utils.Path.USER_API;
import static com.rkovtiuk.blog_ms.core.utils.Path.UserApi.GET_USER_ID_BY_TOKEN;
import static com.rkovtiuk.blog_ms.core.utils.Validator.isEmpty;

@RestController
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    private Integer getUserIdByToken(String token){
        String path = USER_API + GET_USER_ID_BY_TOKEN;
        return new RestTemplate().postForObject(path, null, Integer.class, createTokenHeader(token));
    }

    @RequestMapping(value = DASHBOARD, method = RequestMethod.GET)
    public List<BlogDTO> dashboard(@RequestParam(value = "page", defaultValue = "1") int page){
        return blogService.dashboard(page);
    }

    @RequestMapping(value = GET_BLOGS_BY_AUTHOR, method = RequestMethod.GET)
    public List<BlogDTO> blogsByAuthor(@RequestParam(value = "page", defaultValue = "1") int page,
                                       @PathVariable(value = "id") int authorId){
        return blogService.getBlogsByAuthor(page, authorId);
    }

    @RequestMapping(value = GET_BLOGS_BY_CATEGORY, method = RequestMethod.GET)
    public List<BlogDTO> blogsByCategory(@RequestParam(value = "page", defaultValue = "1") int page,
                                         @RequestParam(value = "category_id") int categoryId){
        return blogService.getBlogsByCategory(page, categoryId);
    }

    @RequestMapping(value = REMOVE_BLOG, method = RequestMethod.DELETE)
    public void removeBlog(@RequestHeader(value = TOKEN_HEADER_NAME) String token,
                                             @PathVariable(value = "id") int blogId) throws EmptyRequestException, AuthorizedException {
        if (isEmpty(token) || blogId==0) throw new EmptyRequestException();
        Integer userId = getUserIdByToken(token);
        if (isEmpty(userId)) throw new AuthorizedException();

        blogService.removeBlog(userId, blogId);
    }

    @RequestMapping(value = GET_BLOG_COMMENTS, method = RequestMethod.GET)
    public List<Comment> blogComments(@RequestParam(value = "page", defaultValue = "1") int page,
                                      @PathVariable(value = "id") int blogId){
        return blogService.getComments(page, blogId);
    }

    @RequestMapping(value = CREATE_COMMENT, method = RequestMethod.POST)
    public ResponseEntity<Comment> writeComment(@RequestHeader(value = TOKEN_HEADER_NAME) String token,
                                                @PathVariable(value = "id") int blogId,
                                                @RequestBody CreateCommentRequest request) throws EmptyRequestException, AuthorizedException {
        if (isEmpty(token) || blogId==0) throw new EmptyRequestException();
        Integer userId = getUserIdByToken(token);
        if (isEmpty(userId)) throw new AuthorizedException();

        Comment comment = blogService.addComment(userId, blogId, request);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

}
