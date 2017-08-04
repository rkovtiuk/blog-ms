package com.rkovtiuk.boot_microservices.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification extends BaseEntity {

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
