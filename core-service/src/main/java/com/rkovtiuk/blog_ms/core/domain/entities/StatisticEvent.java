package com.rkovtiuk.blog_ms.core.domain.entities;

import com.rkovtiuk.blog_ms.core.domain.enums.EventType;

import javax.persistence.*;

@Entity
@Table(name = "statistics")
public class StatisticEvent extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "blog_id", nullable = true)
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = true)
    private Comment comment;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private EventType type;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}
