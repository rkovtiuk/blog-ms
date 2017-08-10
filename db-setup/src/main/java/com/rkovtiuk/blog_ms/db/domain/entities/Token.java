package com.rkovtiuk.blog_ms.db.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "tokens")
public class Token extends BaseEntity{

    @Column(name = "session_token")
    private String sessionToken;

    @Column(name = "date")
    private Long createdAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
