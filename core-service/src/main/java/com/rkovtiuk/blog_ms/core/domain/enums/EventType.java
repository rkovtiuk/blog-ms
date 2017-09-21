package com.rkovtiuk.blog_ms.core.domain.enums;

public enum EventType {

    BLOG_CREATE("blog_create"),
    BLOG_VIEW("blog_view"),
    BLOG_DELETE("blog_delete"),
    BLOG_LIKE("blog_like"),
    BLOG_DISLIKE("blog_dislike"),
    COMMENT_CREATE("comment_create"),
    COMMENT_DELETE("comment_delete"),
    COMMENT_LIKE("comment_like");

    String textType = "";

    private EventType(final String textType) {
        this.textType = textType;
    }

    @Override
    public String toString() {
        return textType;
    }
}
