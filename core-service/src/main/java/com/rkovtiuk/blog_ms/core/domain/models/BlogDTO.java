package com.rkovtiuk.blog_ms.core.domain.models;

import java.util.Date;

public class BlogDTO {

    private Integer id;
    private String title;
    private Date date;
    private BlogCategoryDTO blogCategoryDTO;
    private Integer authorId;
    private String authorName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BlogCategoryDTO getBlogCategoryDTO() {
        return blogCategoryDTO;
    }

    public void setBlogCategoryDTO(BlogCategoryDTO blogCategoryDTO) {
        this.blogCategoryDTO = blogCategoryDTO;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
