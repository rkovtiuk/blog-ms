package com.rkovtiuk.blog_ms.core.domain.models;

import com.rkovtiuk.blog_ms.core.domain.enums.EventType;

public class StatisticsEventDTO {

    private String userId;
    private String blogId;
    private String commentId;
    private String eventType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public EventType getEventType() {
        return EventType.valueOf(eventType);
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType.toString();
    }
}
