package com.rkovtiuk.blog_ms.db.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "blog_categories")
public class BlogCategory extends BaseEntity {

    @Column(name = "category")
    private String category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "blogCategory", cascade = CascadeType.ALL)
    private List<Blog> categoryBlogs;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Blog> getCategoryBlogs() {
        return categoryBlogs;
    }

    public void setCategoryBlogs(List<Blog> categoryBlogs) {
        this.categoryBlogs = categoryBlogs;
    }
}
