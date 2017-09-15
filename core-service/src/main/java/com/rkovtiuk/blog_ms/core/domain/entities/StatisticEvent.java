package com.rkovtiuk.blog_ms.core.domain.entities;

import com.rkovtiuk.blog_ms.core.domain.enums.StatisticsType;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private StatisticsType type;

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

    public StatisticsType getType() {
        return type;
    }

    public void setType(StatisticsType type) {
        this.type = type;
    }
}
