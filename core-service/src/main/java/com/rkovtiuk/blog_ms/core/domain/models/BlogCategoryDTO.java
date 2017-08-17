package com.rkovtiuk.blog_ms.core.domain.models;

public class BlogCategoryDTO {

    private String category;
    private Integer categoryId;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
