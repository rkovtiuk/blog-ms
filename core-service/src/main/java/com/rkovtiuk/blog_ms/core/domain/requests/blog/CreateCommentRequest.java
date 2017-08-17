package com.rkovtiuk.blog_ms.core.domain.requests.blog;

import com.rkovtiuk.blog_ms.core.domain.requests.BaseRequest;

public class CreateCommentRequest extends BaseRequest{

    private Integer blogId;
    private String text;
    private Integer answerId;

    public CreateCommentRequest() {
    }

    public CreateCommentRequest(Integer blogId, String text, Integer answerId) {
        this.blogId = blogId;
        this.text = text;
        this.answerId = answerId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }
}
